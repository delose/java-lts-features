package com.delose.lts.java8.banking;

/**
 * Represents a cached outcome of an idempotent operation.
 * Either a successful DepositResult or an error message.
 */
public class IdempotencyCacheEntry {
    private final DepositResult result;
    private final String errorMessage;
    private final boolean isSuccess;
    
    public IdempotencyCacheEntry(DepositResult result) {
        this.result = result;
        this.errorMessage = null;
        this.isSuccess = true;
    }
    
    public IdempotencyCacheEntry(String errorMessage) {
        this.result = null;
        this.errorMessage = errorMessage;
        this.isSuccess = false;
    }
    
    public boolean isSuccess() {
        return isSuccess;
    }
    
    public DepositResult getResult() {
        return result;
    }
    
    public String getErrorMessage() {
        return errorMessage;
    }
}
