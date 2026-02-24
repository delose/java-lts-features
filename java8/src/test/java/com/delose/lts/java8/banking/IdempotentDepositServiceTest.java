package com.delose.lts.java8.banking;

import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Unit tests for IdempotentDepositService.
 * Tests cover idempotency, validation, and error scenarios.
 */
public class IdempotentDepositServiceTest {
    
    private IdempotentDepositService depositService;
    private InMemoryAccountRepository accountRepository;
    private InMemoryIdempotencyRepository idempotencyRepository;
    private SimpleAuditLogger auditLogger;
    
    @Before
    public void setUp() {
        accountRepository = new InMemoryAccountRepository();
        idempotencyRepository = new InMemoryIdempotencyRepository();
        auditLogger = new SimpleAuditLogger();
        
        depositService = new IdempotentDepositService(
            idempotencyRepository,
            accountRepository,
            auditLogger
        );
        
        // Create test account
        accountRepository.createSampleAccount("ACC123", new BigDecimal("1000.00"));
    }
    
    @Test
    public void testProcessDeposit_Success() {
        DepositCommand command = new DepositCommand(
            "IDEMP-001",
            "ACC123",
            new BigDecimal("500.00"),
            "CASH",
            "Initial deposit"
        );
        
        DepositResult result = depositService.processDeposit(command);
        
        assertNotNull(result);
        assertEquals("ACC123", result.getAccountId());
        assertEquals(new BigDecimal("1500.00"), result.getNewBalance());
        assertNotNull(result.getTransactionId());
        assertEquals("COMPLETED", result.getStatus());
        
        // Verify idempotency record was created
        assertTrue(idempotencyRepository.findByKey("IDEMP-001").isPresent());
    }
    
    @Test(expected = DuplicateDepositException.class)
    public void testProcessDeposit_Duplicate() {
        DepositCommand command = new DepositCommand(
            "IDEMP-002",
            "ACC123",
            new BigDecimal("200.00"),
            "CASH",
            "Second deposit"
        );
        
        // First call succeeds
        depositService.processDeposit(command);
        
        // Second call with same idempotency key should fail
        depositService.processDeposit(command);
    }
    
    @Test(expected = AccountNotFoundException.class)
    public void testProcessDeposit_AccountNotFound() {
        DepositCommand command = new DepositCommand(
            "IDEMP-003",
            "ACC999",
            new BigDecimal("100.00"),
            "CASH",
            "Deposit to non-existent account"
        );
        
        depositService.processDeposit(command);
    }
    
    @Test(expected = InvalidDepositException.class)
    public void testProcessDeposit_InvalidAmount() {
        DepositCommand command = new DepositCommand(
            "IDEMP-004",
            "ACC123",
            new BigDecimal("-100.00"),
            "CASH",
            "Negative deposit"
        );
        
        depositService.processDeposit(command);
    }
    
    @Test(expected = InvalidDepositException.class)
    public void testProcessDeposit_NullIdempotencyKey() {
        DepositCommand command = new DepositCommand(
            null,
            "ACC123",
            new BigDecimal("100.00"),
            "CASH",
            "Missing idempotency key"
        );
        
        depositService.processDeposit(command);
    }
    
    @Test
    public void testIdempotencyRecord_Cleanup() {
        // Create a record with old date
        IdempotencyRecord oldRecord = new IdempotencyRecord(
            "OLD-IDEMP",
            "ACC123",
            new BigDecimal("100.00"),
            "TXN-OLD",
            LocalDateTime.now().minusDays(40), // 40 days old
            "COMPLETED"
        );
        idempotencyRepository.save(oldRecord);
        
        int deleted = idempotencyRepository.cleanupOldRecords(LocalDateTime.now());
        assertEquals(1, deleted);
        assertFalse(idempotencyRepository.findByKey("OLD-IDEMP").isPresent());
    }
    
    @Test
    public void testConcurrentDeposits_SameIdempotencyKey() throws InterruptedException {
        final String idempotencyKey = "CONCURRENT-001";
        final BigDecimal amount = new BigDecimal("100.00");
        
        DepositCommand command = new DepositCommand(
            idempotencyKey,
            "ACC123",
            amount,
            "CASH",
            "Concurrent deposit"
        );
        
        // Simulate concurrent requests
        Thread t1 = new Thread(() -> {
            try {
                depositService.processDeposit(command);
            } catch (Exception e) {
                // Expected: one will succeed, one will fail with duplicate
            }
        });
        
        Thread t2 = new Thread(() -> {
            try {
                depositService.processDeposit(command);
            } catch (Exception e) {
                // Expected: one will succeed, one will fail with duplicate
            }
        });
        
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        
        // Only one should succeed
        assertTrue(idempotencyRepository.findByKey(idempotencyKey).isPresent());
    }
}
