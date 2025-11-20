package com.delose.lts.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsExample {

    public List<String> filterStartsWith(List<String> names, String startsWith) {
        return names.stream()
                .filter(name -> name.startsWith(startsWith))
                .collect(Collectors.toList());
    }

    public List<String> filterStartsWith(List<String> names) {
        String STARTS_WITH_DEFAULT = "A";
        return this.filterStartsWith(names, STARTS_WITH_DEFAULT);
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

    public enum TextCase {
        LOWER,
        UPPER
    }

    public List<String> mapUpperLowerCase(List<String> list, TextCase tc) {
        return list.stream()
                .map(text -> tc.equals(TextCase.UPPER) ? text.toUpperCase() : text.toLowerCase())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        StreamsExample s = new StreamsExample();

        List<String> stringList = List.of(
                "John", "Jenkins", "Karl", "Lonnie", "Gustaf", "Candice", "Adele");

        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);

        // Starts with

        List<String> namesThatStartsWithC = s.filterStartsWith(stringList, "C");
        List<String> namesThatStartsWithDefault = s.filterStartsWith(stringList, "A");

        System.out.println(namesThatStartsWithC);
        System.out.println(namesThatStartsWithDefault);

        // Odd / Even numbers

        List<Integer> oddNumbers = s.filterOddEven(intList, NumberType.ODD);
        List<Integer> evenNumbers = s.filterOddEven(intList, NumberType.EVEN);

        System.out.println(oddNumbers);
        System.out.println(evenNumbers);

        // Upper/Lower case

        List<String> upperCase = s.mapUpperLowerCase(stringList, TextCase.UPPER);
        List<String> lowerCase = s.mapUpperLowerCase(stringList, TextCase.LOWER);

        System.out.println(upperCase);
        System.out.println(lowerCase);

        // Find first

        Optional<String> first = stringList.stream().findFirst();
        System.out.println(first);

        try {
            Optional<String> empty = new ArrayList<String>().stream().findFirst();
            System.out.println(empty.get().concat(": was found!")); // will not go here
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Sum of squares

        int sumOfSquares = List.of(1, 2, 3).stream()
                .map(n -> n*n)
                .reduce(0, Integer::sum);

        System.out.println(sumOfSquares);

        // Sort / Reverse Sort

        List<String> sortedNames = stringList.stream()
                .sorted()
                .collect(Collectors.toList());

        List<String> reverseSort = stringList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(sortedNames);
        System.out.println(reverseSort);


    }

}
