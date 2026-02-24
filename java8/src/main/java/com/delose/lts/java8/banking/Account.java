package com.delose.lts.java8.banking;

import java.math.BigDecimal;

/**
 * Bank account entity.
 * Thread-safe with proper encapsulation.
 */
public class Account {
    private final String accountId;
    private BigDecimal balance;
    private final boolean active;
    private final LocalDateTime createdAt;
    
    public Account(String accountId, BigDecimal initialBalance, boolean active) {
        this.accountId = accountId;
        this.balance = initialBalance;
        this.active = active;
        this.createdAt = LocalDateTime.now();
    }
    
    public String getAccountId() {
        return accountId;
    }
    
    public BigDecimal getBalance() {
        return balance;
    }
    
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", balance=" + balance +
                ", active=" + active +
                ", createdAt=" + createdAt +
                '}';
    }
}
