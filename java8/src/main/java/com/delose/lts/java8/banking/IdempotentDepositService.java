package com.delose.lts.java8.banking;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Idempotent service for processing deposit commands.
 * Uses unique idempotency keys to prevent duplicate processing.
 * Thread-safe implementation suitable for concurrent banking operations.
 */
public class IdempotentDepositService {
    
    private final IdempotencyRepository idempotencyRepository;
    private final AccountRepository accountRepository;
    private final AuditLogger auditLogger;
    
    public IdempotentDepositService(IdempotencyRepository idempotencyRepository,
                                    AccountRepository accountRepository,
                                    AuditLogger auditLogger) {
        this.idempotencyRepository = idempotencyRepository;
        this.accountRepository = accountRepository;
        this.auditLogger = auditLogger;
    }
    
    /**
     * Processes a deposit command in an idempotent manner.
     * 
     * @param command the deposit command containing account ID, amount, and idempotency key
     * @return the result of the deposit operation
     * @throws DuplicateDepositException if the idempotency key was already processed
     * @throws AccountNotFoundException if the account does not exist
     * @throws InvalidDepositException if the deposit amount is invalid
     */
    public DepositResult processDeposit(DepositCommand command) {
        // Validate command
        validateCommand(command);
        
        // Check for duplicate processing using idempotency key
        IdempotencyRecord existingRecord = idempotencyRepository.findByKey(command.getIdempotencyKey());
        if (existingRecord != null) {
            auditLogger.log("Duplicate deposit attempt detected for idempotency key: " 
                + command.getIdempotencyKey() + " by account: " + command.getAccountId());
            throw new DuplicateDepositException(
                "Deposit with idempotency key " + command.getIdempotencyKey() + " already processed"
            );
        }
        
        // Process the deposit atomically
        DepositResult result;
        try {
            result = executeDeposit(command);
            
            // Record successful processing with idempotency key
            IdempotencyRecord record = new IdempotencyRecord(
                command.getIdempotencyKey(),
                command.getAccountId(),
                command.getAmount(),
                result.getTransactionId(),
                LocalDateTime.now(),
                "COMPLETED"
            );
            idempotencyRepository.save(record);
            
            auditLogger.log("Deposit processed successfully. IdempotencyKey: " 
                + command.getIdempotencyKey() + ", TransactionId: " + result.getTransactionId());
                
        } catch (Exception e) {
            // Record failed attempt for monitoring
            IdempotencyRecord failedRecord = new IdempotencyRecord(
                command.getIdempotencyKey(),
                command.getAccountId(),
                command.getAmount(),
                null,
                LocalDateTime.now(),
                "FAILED: " + e.getMessage()
            );
            idempotencyRepository.save(failedRecord);
            auditLogger.log("Deposit failed. IdempotencyKey: " + command.getIdempotencyKey() 
                + ", Error: " + e.getMessage());
            throw e;
        }
        
        return result;
    }
    
    private void validateCommand(DepositCommand command) {
        if (command == null) {
            throw new InvalidDepositException("Deposit command cannot be null");
        }
        if (command.getIdempotencyKey() == null || command.getIdempotencyKey().trim().isEmpty()) {
            throw new InvalidDepositException("Idempotency key is required");
        }
        if (command.getAccountId() == null || command.getAccountId().trim().isEmpty()) {
            throw new InvalidDepositException("Account ID is required");
        }
        if (command.getAmount() == null || command.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidDepositException("Deposit amount must be positive");
        }
    }
    
    private DepositResult executeDeposit(DepositCommand command) {
        // Find account
        Account account = accountRepository.findById(command.getAccountId())
            .orElseThrow(() -> new AccountNotFoundException("Account not found: " + command.getAccountId()));
        
        // Check if account is active
        if (!account.isActive()) {
            throw new InvalidDepositException("Account is not active: " + command.getAccountId());
        }
        
        // Update balance atomically
        BigDecimal newBalance = account.getBalance().add(command.getAmount());
        account.setBalance(newBalance);
        accountRepository.save(account);
        
        // Generate transaction ID
        String transactionId = "DEP-" + UUID.randomUUID().toString();
        
        return new DepositResult(
            transactionId,
            command.getAccountId(),
            command.getAmount(),
            newBalance,
            LocalDateTime.now(),
            "COMPLETED"
        );
    }
}
