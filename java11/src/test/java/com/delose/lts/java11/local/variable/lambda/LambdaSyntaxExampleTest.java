package com.delose.lts.java11.local.variable.lambda;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LambdaSyntaxExampleTest {
    @Test
    public void testApplyOperation() {
        LambdaSyntaxExample example = new LambdaSyntaxExample();
        String result = example.applyOperation(10, 20, (var x, var y) -> "Result: " + (x + y));
        assertEquals("Result: 30", result);
    }

}
