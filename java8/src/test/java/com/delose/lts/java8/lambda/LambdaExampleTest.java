package com.delose.lts.java8.lambda;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LambdaExampleTest {

        @Test
        public void testAdditionOperation() {
            LambdaExample example = new LambdaExample();
            Operation add = (x, y) -> x + y;

            int result = example.executeOperation(5, 3, add);
            assertEquals(8, result);
        }
}
