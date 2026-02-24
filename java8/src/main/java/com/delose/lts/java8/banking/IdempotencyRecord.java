package com.delose.lts.java8.banking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Record of an idempotent operation.
 * Immutable to ensure thread safety and audit integrity.
 */
public final class IdempotencyRecord {
    private final String idempotencyKey;
    private final String accountId;
    private final BigDecimal amount;
    private final String transactionId;
    private final LocalDateTime createdAt;
    private final String status;
    
    public IdempotencyRecord(String idempotencyKey,
                            String accountId,
                            BigDecimal amount,
                            String transactionId,
                            LocalDateTime createdAt,
                            String status) {
        this.idempotencyKey = idempotencyKey;
        this.accountId = accountId;
        this.amount = amount;
        this.transactionId = transactionId;
        this.createdAt = createdAt;
        this.status = status;
    }
    
    public String getIdempotencyKey() {
        return idempotencyKey;
    }
    
    public String getAccountId() {
        return accountId;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public String getTransactionId() {
        return transactionId;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public String getStatus() {
        return status;
    }
    
    @Override
    public String toString() {
        return "IdempotencyRecord{" +
                "idempotencyKey='" + idempotencyKey + '\'' +
                ", accountId='" + accountId + '\'' +
                ", amount=" + amount +
                ", transactionId='" + transactionId + '\'' +
                ", createdAt=" + createdAt +
                ", status='" + status + '\'' +
                '}';
    }
}
