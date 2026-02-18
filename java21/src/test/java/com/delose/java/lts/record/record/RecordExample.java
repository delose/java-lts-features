package com.delose.java.lts.java17.record;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Simple record for a financial transaction
record Transaction(String id, BigDecimal amount, String currency, Instant timestamp) {}

// Sealed interface for transaction types - ensures exhaustive pattern matching in switches
sealed interface TransactionType permits Purchase, Refund, Transfer {
    BigDecimal calculateFee(BigDecimal amount);
}

// Each transaction type implements the sealed interface
record Purchase(BigDecimal amount) implements TransactionType {
    @Override
    public BigDecimal calculateFee(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.02)); // 2% fee
    }
}

record Refund(BigDecimal amount) implements TransactionType {
    @Override
    public BigDecimal calculateFee(BigDecimal amount) {
        return BigDecimal.ZERO; // no fee for refunds
    }
}

record Transfer(BigDecimal amount) implements TransactionType {
    @Override
    public BigDecimal calculateFee(BigDecimal amount) {
        return amount.multiply(BigDecimal.valueOf(0.01)); // 1% fee
    }
}

public class RecordExample {

    public static void main(String[] args) {
        // Example 1: Using records for immutable data transfer
        List<Transaction> transactions = List.of(
                new Transaction("tx1", new BigDecimal("100.50"), "USD", Instant.now()),
                new Transaction("tx2", new BigDecimal("200.00"), "EUR", Instant.now()),
                new Transaction("tx3", new BigDecimal("150.75"), "USD", Instant.now()),
                new Transaction("tx4", new BigDecimal("300.25"), "GBP", Instant.now())
        );

        // Group by currency and sum amounts using BigDecimal for precision
        Map<String, BigDecimal> sumByCurrency = transactions.stream()
                .collect(Collectors.groupingBy(
                        Transaction::currency,
                        Collectors.mapping(Transaction::amount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
                ));

        System.out.println("Sum by currency: " + sumByCurrency);

        // Example 2: Sealed hierarchy and switch expression (exhaustive, no default needed)
        List<TransactionType> transactionTypes = List.of(
                new Purchase(new BigDecimal("100.00")),
                new Refund(new BigDecimal("50.00")),
                new Transfer(new BigDecimal("200.00"))
        );

        // Switch expression on sealed type - compiler ensures all cases are covered
        for (TransactionType type : transactionTypes) {
            BigDecimal fee = switch (type) {
                case Purchase p -> p.calculateFee(p.amount());
                case Refund r   -> r.calculateFee(r.amount());
                case Transfer t -> t.calculateFee(t.amount());
            };
            System.out.println("Fee for " + type + ": " + fee);
        }

        // Example 3: Pattern matching for instanceof (Java 16+)
        Object obj = new Purchase(new BigDecimal("100"));
        if (obj instanceof Purchase p) {
            System.out.println("Purchase amount via pattern matching: " + p.amount());
        }
    }

}
