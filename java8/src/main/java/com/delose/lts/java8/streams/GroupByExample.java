package com.delose.lts.java8.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Book(String language, String title) {}

public class GroupByExample {

    static void main(String[] args) {
        List<Book> books = List.of(
                new Book("Spanish", "Don Quixote"),
                new Book("Spanish", "La Sombra del Viento"),
                new Book("English", "1984")
        );

        Map<String, Long> result = books.stream()
                .collect(Collectors.groupingBy(
                        Book::language,
                        Collectors.counting()
                ));

        System.out.println(result);
    }
}
