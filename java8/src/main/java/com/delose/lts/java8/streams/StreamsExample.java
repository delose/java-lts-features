package com.delose.lts.java8.streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {
    public List<String> filterNames(List<String> names) {
        return names.stream()
                .filter(name -> name.startsWith("J"))
                .collect(Collectors.toList());
    }
}
