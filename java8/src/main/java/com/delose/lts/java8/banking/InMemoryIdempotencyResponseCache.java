package com.delose.lts.java8.banking;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryIdempotencyResponseCache implements IdempotencyResponseCache {
    private final Map<String, IdempotencyCacheEntry> cache = new ConcurrentHashMap<>();
    
    @Override
    public Optional<IdempotencyCacheEntry> get(String idempotencyKey) {
        return Optional.ofNullable(cache.get(idempotencyKey));
    }
    
    @Override
    public void put(String idempotencyKey, IdempotencyCacheEntry entry) {
        cache.put(idempotencyKey, entry);
    }
    
    @Override
    public boolean contains(String idempotencyKey) {
        return cache.containsKey(idempotencyKey);
    }
}
