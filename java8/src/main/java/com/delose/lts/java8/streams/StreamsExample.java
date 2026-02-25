package com.delose.lts.java8.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsExample {

    public List<String> filterStartsWith(List<String> names, String startsWith) {
        return names.stream()
                .filter(name -> name.startsWith(startsWith))
                .collect(Collectors.toList());
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

        System.out.println("--Starts with");

        List<String> namesThatStartsWithC = s.filterStartsWith(stringList, "C");
        List<String> namesThatStartsWithDefault = s.filterStartsWith(stringList, "A");

        System.out.println(namesThatStartsWithC);
        System.out.println(namesThatStartsWithDefault);

        System.out.println("--Odd / Even numbers");

        List<Integer> oddNumbers = s.filterOddEven(intList, NumberType.ODD);
        List<Integer> evenNumbers = s.filterOddEven(intList, NumberType.EVEN);

        System.out.println(oddNumbers);
        System.out.println(evenNumbers);

        System.out.println("--Upper/Lower case");

        List<String> upperCase = s.mapUpperLowerCase(stringList, TextCase.UPPER);
        List<String> lowerCase = s.mapUpperLowerCase(stringList, TextCase.LOWER);

        System.out.println(upperCase);
        System.out.println(lowerCase);

        System.out.println("--Find first");

        Optional<String> first = stringList.stream().findFirst();
        System.out.println(first);

        try {
            Optional<String> empty = new ArrayList<String>().stream().findFirst();
            System.out.println(empty.get().concat(": was found!")); // will not go here
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("--Sum of squares");

        int sumOfSquares = List.of(1, 2, 3).stream()
                .map(n -> n*n)
                .reduce(0, Integer::sum);

        System.out.println(sumOfSquares);

        System.out.println("--Sort / Reverse Sort");

        List<String> sortedNames = stringList.stream()
                .sorted()
                .collect(Collectors.toList());

        List<String> reverseSort = stringList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println(sortedNames);
        System.out.println(reverseSort);

        System.out.println("--Find max in list");

        Optional<Integer> maxNumber = intList.stream()
                .max(Integer::compare);
        maxNumber.ifPresent(System.out::println);

        System.out.println("--Find min in list");
        Optional<Integer> minNumber = intList.stream()
                .min(Integer::compare);
        minNumber.ifPresent(System.out::println);

        System.out.println("--Convert intList to longList");
        List<Long> longList = intList.stream()
                .mapToLong(Long::valueOf)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(longList);

        System.out.println("--Anagram list");

        List<String> words = Arrays.asList("listen", "silent", "enlist", "rat", "tar", "god", "dog", "team", "meat");

        Map<String, List<String>> anagramList = words.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(
                        word -> {
                            char[] chars = word.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);
                        }
                ));

        System.out.println(anagramList);

        System.out.println("--Count frequency of each word");
        List<String> sentences = List.of(
                "Java is fun",
                "Streams are powerful",
                "Java is powerful"
        );
        Map<String, Long> wordFreq = sentences.stream()
                .flatMap(sentence ->
                        Arrays.stream(sentence.toLowerCase().split("\\s+")))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println(wordFreq);

        System.out.println("--Find duplicate numbers and how many times they occur");

        List<Integer> integerListWithDuplicates = List.of(1, 2, 2, 3, 4, 4, 4, 5, 5, 6, 7, 7, 7, 7, 7, 8, 8, 9, 9, 9);

        Map<Integer, Long> duplicates = integerListWithDuplicates.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .peek(System.out::println)
                .filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(duplicates);

    }

}
