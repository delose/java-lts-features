package com.delose.lts.java8.function;

import java.util.function.*;

public class FunctionalInterfacesExample {

    public static void main(String[] args) {
        demonstrateFunction();
        demonstrateBiFunction();
        demonstrateConsumer();
        demonstrateSupplier();
        demonstratePredicate();
        demonstrateUnaryOperator();
        demonstrateBinaryOperator();
    }

    private static void demonstrateFunction() {
        Function<String, Integer> stringLength = s -> s.length();
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));
    }

    private static void demonstrateBiFunction() {
        BiFunction<String, String, String> concat = (s1, s2) -> s1 + s2;
        System.out.println("Concatenation: " + concat.apply("Hello, ", "World"));
    }

    private static void demonstrateConsumer() {
        Consumer<String> printer = s -> System.out.println("Consumer: " + s);
        printer.accept("Hello from Consumer");
    }

    private static void demonstrateSupplier() {
        Supplier<String> supplier = () -> "Hello from Supplier";
        System.out.println("Supplier: " + supplier.get());
    }

    private static void demonstratePredicate() {
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 5 even? " + isEven.test(5));
    }

    private static void demonstrateUnaryOperator() {
        UnaryOperator<Integer> square = n -> n * n;
        System.out.println("Square of 5: " + square.apply(5));
    }

    private static void demonstrateBinaryOperator() {
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("Sum of 5 and 3: " + add.apply(5, 3));
    }
}
