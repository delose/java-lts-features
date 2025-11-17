package com.delose.lts.java8.streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {
    public List<String> filterNames(List<String> names) {
        return names.stream()
                .filter(name -> name.startsWith("J"))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> stringList = List.of(
                "John", "Jenkins", "Karl", "Lonnie", "Gustaf", "Candicer");
        StreamsExample s = new StreamsExample();
        List<String> namesThatStartsWithJ = s.filterNames(stringList);
        System.out.println(namesThatStartsWithJ);
    }
}
