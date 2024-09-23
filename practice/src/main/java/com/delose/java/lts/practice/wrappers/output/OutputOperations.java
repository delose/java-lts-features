package com.delose.java.lts.practice.wrappers.output;

public class OutputOperations {

    /**
     * Prints text or values the console
     */
    public void print(Object obj) {
        System.out.print(obj);
    }

    /**
     * Prints formatted text or values to the console
     */
    public void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    /**
     * Prints text or values to the console, followed by a new line
     */
    public void println(Object obj) {
        System.out.println(obj);
    }

}
