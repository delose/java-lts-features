package com.delose.java.lts.java17.textblocks;

public class TextBlocksDemo {
    public static void main(String[] args) {

        String old = "This is the first line." +
                "This is the second line.";

        // Text block for a financial agreement with formatted placeholders
        String agreement = """
                FINANCIAL SERVICES AGREEMENT

                This agreement is between:
                - Client: %s
                - Provider: %s

                Terms and conditions apply.
                """.formatted("John Doe", "FinTech Corp");

        System.out.println(agreement);

        // JSON payload for a transaction (using text block for readability)
        String jsonPayload = """
                {
                    "transactionId": "tx_123456",
                    "amount": 1500.75,
                    "currency": "USD",
                    "timestamp": "2023-10-05T12:34:56Z",
                    "description": "Payment for services"
                }
                """;

        System.out.println(jsonPayload);

        // SQL query for transaction report (using text block for complex query)
        String sqlQuery = """
                SELECT
                    transaction_id,
                    amount,
                    currency,
                    timestamp,
                    description
                FROM
                    transactions
                WHERE
                    timestamp >= DATE_SUB(CURRENT_DATE, INTERVAL 30 DAY)
                    AND status = 'COMPLETED'
                ORDER BY
                    timestamp DESC
                LIMIT 1000;
                """;

        System.out.println(sqlQuery);
    }

}
