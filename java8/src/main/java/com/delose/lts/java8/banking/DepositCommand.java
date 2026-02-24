package com.delose.lts.java8.banking;

import java.math.BigDecimal;

/**
 * Command object for deposit operations.
 * Immutable to ensure thread safety and consistency.
 */
public final class DepositCommand {
    private final String idempotencyKey;
    private final String accountId;
    private final BigDecimal amount;
    private final String source; // e.g., "CASH", "TRANSFER", "CHECK"
    private final String description;
    
    public DepositCommand(String idempotencyKey, 
                         String accountId, 
                         BigDecimal amount,
                         String source,
                         String description) {
        this.idempotencyKey = idempotencyKey;
        this.accountId = accountId;
        this.amount = amount;
        this.source = source;
        this.description = description;
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
    
    public String getSource() {
        return source;
    }
    
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return "DepositCommand{" +
                "idempotencyKey='" + idempotencyKey + '\'' +
                ", accountId='" + accountId + '\'' +
                ", amount=" + amount +
                ", source='" + source + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
