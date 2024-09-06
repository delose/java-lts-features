package com.delose.lts.java11.pattern.matching;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringPatternExampleTest {
    @Test
    public void testStripString() {
        StringPatternExample example = new StringPatternExample();
        assertEquals("Hello, World!", example.stripString("   Hello, World!   "));
    }

}
