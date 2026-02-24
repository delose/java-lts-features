package com.delose.lts.java8.banking;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory implementation of IdempotencyRepository.
 * Uses ConcurrentHashMap for thread-safe operations.
 * 
 * NOTE: For production use, replace with a database implementation
 * that enforces unique constraints and supports TTL/retention policies.
 */
public class InMemoryIdempotencyRepository implements IdempotencyRepository {
    
    private final Map<String, IdempotencyRecord> store = new ConcurrentHashMap<>();
    private final long retentionPeriodDays = 30; // Configurable retention period
    
    @Override
    public Optional<IdempotencyRecord> findByKey(String idempotencyKey) {
        return Optional.ofNullable(store.get(idempotencyKey));
    }
    
    @Override
    public void save(IdempotencyRecord record) throws DuplicateKeyException {
        String key = record.getIdempotencyKey();
        
        // Check for existing record (atomic operation)
        IdempotencyRecord existing = store.putIfAbsent(key, record);
        if (existing != null) {
            throw new DuplicateKeyException("Idempotency key already exists: " + key);
        }
    }
    
    @Override
    public int cleanupOldRecords(LocalDateTime olderThan) {
        int count = 0;
        LocalDateTime cutoff = olderThan.minusDays(retentionPeriodDays);
        
        for (Map.Entry<String, IdempotencyRecord> entry : store.entrySet()) {
            if (entry.getValue().getCreatedAt().isBefore(cutoff)) {
                store.remove(entry.getKey());
                count++;
            }
        }
        return count;
    }
    
    /**
     * For testing purposes: clears all records.
     */
    public void clearAll() {
        store.clear();
    }
    
    /**
     * Gets current store size for monitoring.
     */
    public int size() {
        return store.size();
    }
}
