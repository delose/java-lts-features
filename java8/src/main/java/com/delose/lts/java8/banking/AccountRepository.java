package com.delose.lts.java8.banking;

import java.util.Optional;

/**
 * Repository for account operations.
 * In production, this would be backed by a database.
 */
public interface AccountRepository {
    
    /**
     * Finds an account by its ID.
     * 
     * @param accountId the account ID
     * @return Optional containing the account if found
     */
    Optional<Account> findById(String accountId);
    
    /**
     * Saves an account.
     * Should handle concurrent updates properly (optimistic locking recommended).
     * 
     * @param account the account to save
     */
    void save(Account account);
}
