package com.delose.lts.java8.banking;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Repository for storing and retrieving idempotency records.
 * In production, this would be backed by a database with unique constraint on idempotencyKey.
 */
public interface IdempotencyRepository {
    
    /**
     * Finds an idempotency record by its key.
     * 
     * @param idempotencyKey the unique idempotency key
     * @return Optional containing the record if found
     */
    Optional<IdempotencyRecord> findByKey(String idempotencyKey);
    
    /**
     * Saves an idempotency record.
     * Should enforce uniqueness on idempotencyKey to prevent duplicates.
     * 
     * @param record the idempotency record to save
     * @throws DuplicateKeyException if the key already exists
     */
    void save(IdempotencyRecord record) throws DuplicateKeyException;
    
    /**
     * Cleans up old idempotency records based on retention policy.
     * Typically records older than a certain period (e.g., 30 days) can be archived.
     * 
     * @param olderThan the cutoff date for cleanup
     * @return number of records deleted
     */
    int cleanupOldRecords(LocalDateTime olderThan);
}
