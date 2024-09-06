package com.delose.lts.java11.local.variable.lambda;

import java.util.function.BiFunction;

public class LambdaSyntaxExample {
    public String applyOperation(int a, int b, BiFunction<Integer, Integer, String> operation) {
        return operation.apply(a, b);
    }

}
