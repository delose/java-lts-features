package com.delose.lts.java8.banking;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Result of a deposit operation.
 * Immutable to ensure thread safety.
 */
public final class DepositResult {
    private final String transactionId;
    private final String accountId;
    private final BigDecimal amount;
    private final BigDecimal newBalance;
    private final LocalDateTime timestamp;
    private final String status;
    
    public DepositResult(String transactionId,
                        String accountId,
                        BigDecimal amount,
                        BigDecimal newBalance,
                        LocalDateTime timestamp,
                        String status) {
        this.transactionId = transactionId;
        this.accountId = accountId;
        this.amount = amount;
        this.newBalance = newBalance;
        this.timestamp = timestamp;
        this.status = status;
    }
    
    public String getTransactionId() {
        return transactionId;
    }
    
    public String getAccountId() {
        return accountId;
    }
    
    public BigDecimal getAmount() {
        return amount;
    }
    
    public BigDecimal getNewBalance() {
        return newBalance;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public String getStatus() {
        return status;
    }
    
    @Override
    public String toString() {
        return "DepositResult{" +
                "transactionId='" + transactionId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", amount=" + amount +
                ", newBalance=" + newBalance +
                ", timestamp=" + timestamp +
                ", status='" + status + '\'' +
                '}';
    }
}
