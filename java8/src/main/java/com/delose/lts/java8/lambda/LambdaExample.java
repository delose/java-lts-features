package com.delose.lts.java8.lambda;

import java.util.function.Function;

public class LambdaExample {
    public int executeOperation(int a, int b, Operation operation) {
        return operation.apply(a, b);
    }

    public String greet(Function<String, String> greeter, String name) {
        return greeter.apply(name);
    }

}
