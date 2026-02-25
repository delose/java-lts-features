package com.delose.lts.java8.banking;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * Core service for processing deposit commands.
 * Does not handle idempotency; that is handled by IdempotencyMiddleware.
 */
public class IdempotentDepositService implements DepositService {
    
    private final AccountRepository accountRepository;
    private final AuditLogger auditLogger;
    
    public IdempotentDepositService(AccountRepository accountRepository,
                                    AuditLogger auditLogger) {
        this.accountRepository = accountRepository;
        this.auditLogger = auditLogger;
    }
    
    @Override
    public DepositResult processDeposit(DepositCommand command) {
        validateCommand(command);
        
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
        
        DepositResult result = new DepositResult(
            transactionId,
            command.getAccountId(),
            command.getAmount(),
            newBalance,
            LocalDateTime.now(),
            "COMPLETED"
        );
        
        auditLogger.log("Deposit processed. TransactionId: " + transactionId);
        
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
}
