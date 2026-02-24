package com.delose.lts.java8.banking;

/**
 * Exception thrown when an account is not found.
 */
public class AccountNotFoundException extends DepositServiceException {
    
    public AccountNotFoundException(String message) {
        super(message);
    }
}
