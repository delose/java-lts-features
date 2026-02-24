package com.delose.lts.java8.banking;

/**
 * Exception thrown when attempting to save a duplicate idempotency key.
 */
public class DuplicateKeyException extends RuntimeException {
    
    public DuplicateKeyException(String message) {
        super(message);
    }
}
