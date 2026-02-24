package com.delose.lts.java8.banking;

/**
 * Exception thrown when a deposit command is invalid.
 */
public class InvalidDepositException extends DepositServiceException {
    
    public InvalidDepositException(String message) {
        super(message);
    }
}
