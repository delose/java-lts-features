package com.delose.lts.java8.banking;

/**
 * Base exception for deposit service errors.
 */
public class DepositServiceException extends RuntimeException {
    
    public DepositServiceException(String message) {
        super(message);
    }
    
    public DepositServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
