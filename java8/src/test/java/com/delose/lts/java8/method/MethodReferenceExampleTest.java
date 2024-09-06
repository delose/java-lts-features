package com.delose.lts.java8.method;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class MethodReferenceExampleTest {

    @Test
    public void testPrintAllMessages() {
        MethodReferenceExample example = new MethodReferenceExample();
        List<String> messages = Arrays.asList("Hello", "World", "Method References are cool!");

        // Capture the output using System.setOut if needed or just verify that no exceptions are thrown
        example.printAllMessages(messages);
    }
}
