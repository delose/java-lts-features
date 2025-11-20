package com.delose.lts.java8.streams;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {

    public List<String> filterNames(List<String> names, String startsWith) {
        return names.stream()
                .filter(name -> name.startsWith(startsWith))
                .collect(Collectors.toList());
    }

    public List<String> filterNames(List<String> names) {
        String STARTS_WITH_DEFAULT = "A";
        return this.filterNames(names, STARTS_WITH_DEFAULT);
    }

    public enum NumberType {
        ODD,
        EVEN
    }

    public List<Integer> filterOddEven(List<Integer> numbers, NumberType num) {
        return numbers.stream()
                .filter(number -> num.equals(NumberType.ODD) ? number % 2 > 0 : number % 2 == 0)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        StreamsExample s = new StreamsExample();

        // Starts with

        List<String> stringList = List.of(
                "John", "Jenkins", "Karl", "Lonnie", "Gustaf", "Candice", "Adele");

        List<String> namesThatStartsWithC = s.filterNames(stringList, "C");
        List<String> namesThatStartsWithDefault = s.filterNames(stringList, "A");

        System.out.println(namesThatStartsWithC);
        System.out.println(namesThatStartsWithDefault);

        // Odd / Even numbers

        List<Integer> oddNumbers = s.filterOddEven(List.of(1, 2, 3, 4, 5, 6), NumberType.ODD);
        List<Integer> evenNumbers = s.filterOddEven(List.of(1, 2, 3, 4, 5, 6), NumberType.EVEN);

        System.out.println(oddNumbers);
        System.out.println(evenNumbers);

    }

}
