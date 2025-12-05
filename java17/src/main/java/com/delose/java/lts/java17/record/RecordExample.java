package com.delose.java.lts.java17.record;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

record Book(String language, String title) {}

public class RecordExample {

    public static void main(String[] args) {
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
