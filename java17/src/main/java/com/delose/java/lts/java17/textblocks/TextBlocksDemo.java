package com.delose.java.lts.java17.textblocks;

public class TextBlocksDemo {
    public static void main(String[] args) {

        String old = "This is the first line." +
                "This is the second line.";

        String multiLineText = """
            This is the first line.
            This is the second line.
            And this is the third line.
            """;
        System.out.println(multiLineText);

        String jsonPayload = """
            {
                "name": "Eugene Santos",
                "age": 38,
                "city": "Manila"
            }
            """;
        System.out.println(jsonPayload);

        String sqlQuery = """
                SELECT
                    employee_id,
                    first_name,
                    last_name
                FROM
                    employees
                WHERE
                    department_id = 101
                ORDER BY
                    last_name ASC;
                """;

        System.out.println(sqlQuery);
    }

}
