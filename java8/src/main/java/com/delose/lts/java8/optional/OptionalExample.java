package com.delose.lts.java8.optional;

import java.util.Optional;

public class OptionalExample {

    public String getValue(Optional<String> optionalValue) {
        return optionalValue.orElse("Default Value");
    }

    public String getDefaultValueIfEmpty(Optional<String> optionalValue) {
        return optionalValue.orElse("Default Value");
    }

}
