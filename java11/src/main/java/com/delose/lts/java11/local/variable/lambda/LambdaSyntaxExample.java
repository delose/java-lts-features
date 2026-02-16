package com.delose.lts.java11.local.variable.lambda;

import java.util.Objects;
import java.util.function.BiFunction;

public final class LambdaSyntaxExample {
    public String applyOperation(int a, int b, BiFunction<Integer, Integer, String> operation) {
        Objects.requireNonNull(operation, "operation must not be null");
        return operation.apply(a, b);
    }
}
