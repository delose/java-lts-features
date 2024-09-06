package com.delose.lts.java8.optional;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

public class OptionalExampleTest {

    @Test
    public void testGetValue() {
        OptionalExample example = new OptionalExample();

        Optional<String> presentValue = Optional.of("Present Value");
        Optional<String> emptyValue = Optional.empty();

        assertEquals("Present Value", example.getValue(presentValue));
        assertEquals("Default Value", example.getValue(emptyValue));
    }

    @Test
    public void testGetDefaultValueIfEmpty() {
        OptionalExample example = new OptionalExample();
        
        assertEquals("Hello, World!", example.getDefaultValueIfEmpty(Optional.of("Hello, World!")));
        assertEquals("Default Value", example.getDefaultValueIfEmpty(Optional.empty()));
    }
}
