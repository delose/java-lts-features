package com.delose.lts.java8.streams;

import java.util.List;
import java.util.function.Predicate;

public class MatchStreamsExamples {

    public static void main() {

        List<Integer> intList = List.of(1, 2, 5, 7, 9, 11, 24, 48, 99, 100);

        Predicate<Integer> p1 = num -> num < 10;
        boolean allMatch = intList.stream()
                .allMatch(p1); // false
        System.out.println("--For " + intList + ": allMatch: " + allMatch);

        Predicate<Integer> p2 = num -> num > 100;
        boolean anyMatch = intList.stream()
                .anyMatch(p2); // false
        System.out.println("--For " + intList + ": anyMatch: " + anyMatch);

        Predicate<Integer> p3 = num -> num < 1;
        boolean noneMatch = intList.stream()
                .noneMatch(p3); // true
        System.out.println("--For " + intList + ": noneMatch: " + noneMatch);

    }
}
