package com.delose.lts.java8.streams;

import java.util.List;

/**
 * Parallel Stream internally, it does:
 * Task splitting: it uses "split iterator" function to split data into multiple chunks (recursively)
 * Task submission and processing: Uses Fork-Join pool technique
 */
public class ParallelStreamsExample  {
    static void main() {
        List<Integer> integerList = List.of(5, 10, 15, 20, 100, 105, 110, 115, 120, 44, 22, 33, 55, 66, 77, 88, 99, 2000 , 20, 40, 60, 80);

        long sequentialStreamTime = System.currentTimeMillis();

        integerList.stream()
                .map((Integer val) -> val * val)
                .forEach(System.out::println);

        System.out.println("Sequential processing time taken: " + (System.currentTimeMillis() - sequentialStreamTime) + " milliseconds");

        long parallelStreamTime = System.currentTimeMillis();

        integerList.parallelStream()
                .map((Integer val) -> val * val)
                .forEach(System.out::println);

        System.out.println("Parallel processing time taken: " + (System.currentTimeMillis() - parallelStreamTime) + " milliseconds");

    }
}
