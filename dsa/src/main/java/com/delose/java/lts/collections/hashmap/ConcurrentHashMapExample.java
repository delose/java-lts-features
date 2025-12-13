package com.delose.java.lts.collections.hashmap;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {

    public static void main(String[] args) {

        Map<String, String> capitalMap = new ConcurrentHashMap<>();

        capitalMap.put("USA", "Washington DC");
        capitalMap.put("India", "New Delhi");
        capitalMap.put("Japan", "Tokyo");
        capitalMap.put("China", "Beijing");

        System.out.println("ConcurrentHashMao before iteration: " + capitalMap);

        Iterator<String> iterator = capitalMap.keySet().iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("Reading Key: " + key + " -> Value: " + capitalMap.get(key));

            // No ConcurrentModificationException is thrown
            if (key.equals("India")) {
                capitalMap.put("Russia", "Moscow"); // Add new entry
                capitalMap.put("India", "Mumbai"); // Updated an existing entry
            }
        }

        System.out.println("ConcurrentHashMao after iteration: " + capitalMap);

    }
}
