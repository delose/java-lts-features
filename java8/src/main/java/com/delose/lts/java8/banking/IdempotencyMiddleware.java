package com.delose.lts.java8.banking;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Middleware that adds idempotency to a DepositService.
 * Checks for duplicate idempotency keys and returns cached responses.
 * Also records idempotency in the repository for audit.
 */
public class IdempotencyMiddleware implements DepositService {
    
    private final DepositService delegate;
    private final IdempotencyResponseCache cache;
    private final IdempotencyRepository idempotencyRepository;
    private final AuditLogger auditLogger;
    
    public IdempotencyMiddleware(DepositService delegate,
                                 IdempotencyResponseCache cache,
                                 IdempotencyRepository idempotencyRepository,
                                 AuditLogger auditLogger) {
        this.delegate = delegate;
        this.cache = cache;
        this.idempotencyRepository = idempotencyRepository;
        this.auditLogger = auditLogger;
    }
    
    @Override
    public DepositResult processDeposit(DepositCommand command) {
        // Check cache first
        Optional<IdempotencyCacheEntry> cachedOpt = cache.get(command.getIdempotencyKey());
        if (cachedOpt.isPresent()) {
            IdempotencyCacheEntry cached = cachedOpt.get();
            if (cached.isSuccess()) {
                auditLogger.log("Idempotent deposit: returning cached success for key " + command.getIdempotencyKey());
                return cached.getResult();
            } else {
                auditLogger.log("Idempotent deposit: returning cached error for key " + command.getIdempotencyKey());
                throw new DepositServiceException(cached.getErrorMessage());
            }
        }
        
        try {
            DepositResult result = delegate.processDeposit(command);
            
            // Cache successful response
            cache.put(command.getIdempotencyKey(), new IdempotencyCacheEntry(result));
            
            // Record in repository for audit
            IdempotencyRecord record = new IdempotencyRecord(
                command.getIdempotencyKey(),
                command.getAccountId(),
                command.getAmount(),
                result.getTransactionId(),
                LocalDateTime.now(),
                "COMPLETED"
            );
            idempotencyRepository.save(record);
            
            auditLogger.log("Deposit processed and idempotency recorded. Key: " + command.getIdempotencyKey());
            
            return result;
        } catch (DepositServiceException e) {
            // Cache the error response
            cache.put(command.getIdempotencyKey(), new IdempotencyCacheEntry(e.getMessage()));
            
            // Record failure in repository
            IdempotencyRecord record = new IdempotencyRecord(
                command.getIdempotencyKey(),
                command.getAccountId(),
                command.getAmount(),
                null,
                LocalDateTime.now(),
                "FAILED: " + e.getMessage()
            );
            try {
                idempotencyRepository.save(record);
            } catch (Exception ex) {
                auditLogger.log("Failed to save idempotency record for failed deposit: " + ex.getMessage());
            }
            auditLogger.log("Deposit failed. Key: " + command.getIdempotencyKey() + ", Error: " + e.getMessage());
            throw e;
        }
    }
}
