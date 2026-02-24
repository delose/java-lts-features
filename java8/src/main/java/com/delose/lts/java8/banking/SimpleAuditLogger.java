package com.delose.lts.java8.banking;

import java.time.LocalDateTime;

/**
 * Simple implementation of AuditLogger that prints to console.
 * In production, replace with a proper logging framework.
 */
public class SimpleAuditLogger implements AuditLogger {
    
    @Override
    public void log(String message) {
        System.out.println("[AUDIT] " + LocalDateTime.now() + " - " + message);
    }
    
    @Override
    public void logEvent(String eventType, 
                         String accountId, 
                         String idempotencyKey, 
                         String transactionId, 
                         String status, 
                         String details) {
        String logMessage = String.format(
            "Event: %s | Account: %s | IdempotencyKey: %s | TransactionId: %s | Status: %s | Details: %s",
            eventType, accountId, idempotencyKey, transactionId, status, details
        );
        log(logMessage);
    }
}
