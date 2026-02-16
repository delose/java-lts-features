package com.delose.lts.java11.pattern.matching;

import java.util.Objects;

public final class StringPatternExample {

    public String stripString(String input) {
        Objects.requireNonNull(input, "input must not be null");
        return input.strip();  // Removes leading and trailing whitespaces (Unicode-aware)
    }
}
