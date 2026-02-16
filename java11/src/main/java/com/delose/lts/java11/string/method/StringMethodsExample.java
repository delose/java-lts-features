package com.delose.lts.java11.string.method;

import java.util.Objects;

public final class StringMethodsExample {

    public boolean isBlank(String input) {
        Objects.requireNonNull(input, "input must not be null");
        return input.isBlank();
    }

    public String repeatString(String input, int count) {
        Objects.requireNonNull(input, "input must not be null");
        return input.repeat(count);
    }

    public String stripString(String input) {
        Objects.requireNonNull(input, "input must not be null");
        return input.strip();
    }

    public long countLines(String input) {
        Objects.requireNonNull(input, "input must not be null");
        return input.lines().count();
    }
}
