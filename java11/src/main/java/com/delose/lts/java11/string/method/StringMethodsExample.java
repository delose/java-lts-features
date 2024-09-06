package com.delose.lts.java11.string.method;

public class StringMethodsExample {

    public boolean isBlank(String input) {
        return input.isBlank();
    }

    public String repeatString(String input, int count) {
        return input.repeat(count);
    }

    public String stripString(String input) {
        return input.strip();
    }

    public long countLines(String input) {
        return input.lines().count();
    }


}
