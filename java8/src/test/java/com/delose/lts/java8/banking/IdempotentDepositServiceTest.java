package com.delose.lts.java8.banking;

import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Unit tests for IdempotentDepositService.
 * Tests cover core deposit logic without idempotency concerns.
 * For idempotency tests, see IdempotencyMiddlewareTest.
 */
public class IdempotentDepositServiceTest {
    
    private IdempotentDepositService depositService;
    private InMemoryAccountRepository accountRepository;
    private SimpleAuditLogger auditLogger;
    
    @Before
    public void setUp() {
        accountRepository = new InMemoryAccountRepository();
        auditLogger = new SimpleAuditLogger();
        
        depositService = new IdempotentDepositService(
            accountRepository,
            auditLogger
        );
        
        // Create test account
        accountRepository.createSampleAccount("ACC123", new BigDecimal("1000.00"));
    }
    
    @Test
    public void testProcessDeposit_Success() {
        DepositCommand command = new DepositCommand(
            "IDEMP-001", // idempotency key is still required for validation
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
        
        // Verify account balance was updated
        Account account = accountRepository.findById("ACC123").get();
        assertEquals(new BigDecimal("1500.00"), account.getBalance());
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
    public void testProcessDeposit_UpdatesBalanceCorrectly() {
        BigDecimal initialBalance = new BigDecimal("1000.00");
        BigDecimal depositAmount = new BigDecimal("250.75");
        BigDecimal expectedBalance = initialBalance.add(depositAmount);
        
        DepositCommand command = new DepositCommand(
            "IDEMP-005",
            "ACC123",
            depositAmount,
            "CASH",
            "Test deposit"
        );
        
        DepositResult result = depositService.processDeposit(command);
        
        assertEquals(expectedBalance, result.getNewBalance());
        
        Account account = accountRepository.findById("ACC123").get();
        assertEquals(expectedBalance, account.getBalance());
    }
    
    @Test
    public void testProcessDeposit_MultipleDeposits() {
        // First deposit
        DepositCommand cmd1 = new DepositCommand(
            "IDEMP-006",
            "ACC123",
            new BigDecimal("100.00"),
            "CASH",
            "First deposit"
        );
        DepositResult result1 = depositService.processDeposit(cmd1);
        assertEquals(new BigDecimal("1100.00"), result1.getNewBalance());
        
        // Second deposit
        DepositCommand cmd2 = new DepositCommand(
            "IDEMP-007",
            "ACC123",
            new BigDecimal("200.00"),
            "CASH",
            "Second deposit"
        );
        DepositResult result2 = depositService.processDeposit(cmd2);
        assertEquals(new BigDecimal("1300.00"), result2.getNewBalance());
        
        // Verify final balance
        Account account = accountRepository.findById("ACC123").get();
        assertEquals(new BigDecimal("1300.00"), account.getBalance());
    }
    
    @Test(expected = InvalidDepositException.class)
    public void testProcessDeposit_InactiveAccount() {
        // Create an inactive account directly
        Account inactiveAccount = new Account("ACC-INACTIVE", new BigDecimal("500.00"), false);
        accountRepository.save(inactiveAccount);
        
        DepositCommand command = new DepositCommand(
            "IDEMP-008",
            "ACC-INACTIVE",
            new BigDecimal("100.00"),
            "CASH",
            "Deposit to inactive account"
        );
        
        depositService.processDeposit(command);
    }
}
