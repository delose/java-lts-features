package com.delose.lts.java8.multithreading;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class FrequencyCounter {
    public static void main(String[] args) {
        List<Integer> integerList = List.of(1, 2, 3, 3, 4, 5, 5);

        useStreams(integerList);

        useThreads(integerList);

    }

    private static void useThreads(List<Integer> integerList) {
        long start = System.currentTimeMillis();
        Map<Integer, Integer> freqMap = new ConcurrentHashMap<>();
        Thread t1 = new Thread(() -> process(freqMap, integerList.subList(0, integerList.size() / 2)));
        Thread t2 = new Thread(() -> process(freqMap, integerList.subList(integerList.size() / 2, integerList.size())));
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(freqMap + " took " + (System.currentTimeMillis() - start));
    }

    private static void process(Map<Integer, Integer> freqMap, List<Integer> chunk) {
        for (Integer num: chunk) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
    }

    private static void useStreams(List<Integer> integerList) {
        long start = System.currentTimeMillis();
        System.out.println();
        Map<Integer, Long> longMap = integerList.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));

        System.out.println(longMap + " took " + (System.currentTimeMillis() - start));
    }
}
