package com.delose.lts.java8.banking;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory implementation of AccountRepository.
 * Uses ConcurrentHashMap for thread-safe operations.
 * 
 * NOTE: For production use, replace with a database implementation
 * that supports transactions and optimistic locking.
 */
public class InMemoryAccountRepository implements AccountRepository {
    
    private final Map<String, Account> store = new ConcurrentHashMap<>();
    
    @Override
    public Optional<Account> findById(String accountId) {
        return Optional.ofNullable(store.get(accountId));
    }
    
    @Override
    public void save(Account account) {
        store.put(account.getAccountId(), account);
    }
    
    /**
     * For testing purposes: creates a sample account.
     */
    public void createSampleAccount(String accountId, BigDecimal initialBalance) {
        Account account = new Account(accountId, initialBalance, true);
        store.put(accountId, account);
    }
    
    /**
     * For testing purposes: clears all accounts.
     */
    public void clearAll() {
        store.clear();
    }
}
