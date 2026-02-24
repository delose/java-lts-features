package com.delose.lts.java8.banking;

/**
 * Exception thrown when a duplicate deposit is detected.
 */
public class DuplicateDepositException extends DepositServiceException {
    
    public DuplicateDepositException(String message) {
        super(message);
    }
}
