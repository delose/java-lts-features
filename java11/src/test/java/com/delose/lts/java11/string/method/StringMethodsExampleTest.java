package com.delose.lts.java11.string.method;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringMethodsExampleTest {

    @Test
    public void testIsBlank() {
        StringMethodsExample example = new StringMethodsExample();
        assertTrue(example.isBlank("   "));
    }

    @Test
    public void testRepeatString() {
        StringMethodsExample example = new StringMethodsExample();
        assertEquals("Hello Hello Hello ", example.repeatString("Hello ", 3));
    }

    @Test
    public void testStripString() {
        StringMethodsExample example = new StringMethodsExample();
        assertEquals("Hello", example.stripString("  Hello  "));
    }

    @Test
    public void testCountLines() {
        StringMethodsExample example = new StringMethodsExample();
        assertEquals(3, example.countLines("Line1\nLine2\nLine3"));
    }

}
