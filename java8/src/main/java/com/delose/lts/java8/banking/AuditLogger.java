package com.delose.lts.java8.banking;

/**
 * Audit logger for tracking all deposit operations.
 * In production, this would integrate with a logging system (e.g., SLF4J, Log4j)
 * and potentially send audit events to a separate audit trail system.
 */
public interface AuditLogger {
    
    /**
     * Logs an audit message with timestamp.
     * 
     * @param message the audit message
     */
    void log(String message);
    
    /**
     * Logs an audit event with structured data.
     * 
     * @param eventType the type of event (e.g., "DEPOSIT_PROCESSED", "DUPLICATE_DETECTED")
     * @param accountId the account ID
     * @param idempotencyKey the idempotency key
     * @param transactionId the transaction ID (if applicable)
     * @param status the status of the operation
     * @param details additional details (JSON format recommended)
     */
    void logEvent(String eventType, 
                  String accountId, 
                  String idempotencyKey, 
                  String transactionId, 
                  String status, 
                  String details);
}
