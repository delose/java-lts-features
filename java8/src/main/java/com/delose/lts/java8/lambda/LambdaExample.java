package com.delose.lts.java8.lambda;

public class LambdaExample {
    public int executeOperation(int a, int b, Operation operation) {
        return operation.apply(a, b);
    }

    public static void main(String[] args) {
        LambdaExample example = new LambdaExample();

        // Using lambda expression for addition
        Operation add = (x, y) -> x + y;
        int result = example.executeOperation(5, 3, add);
        System.out.println("Addition Result: " + result);  // Output: 8
    }

}
