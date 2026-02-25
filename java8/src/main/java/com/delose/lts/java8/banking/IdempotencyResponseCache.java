package com.delose.lts.java8.banking;

import java.util.Optional;

public interface IdempotencyResponseCache {
    Optional<IdempotencyCacheEntry> get(String idempotencyKey);
    void put(String idempotencyKey, IdempotencyCacheEntry entry);
    boolean contains(String idempotencyKey);
}
