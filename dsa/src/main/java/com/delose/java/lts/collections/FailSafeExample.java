package com.delose.java.lts.collections;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailSafeExample {
    public static void main(String[] args) {
        // Use a concurrent collection
        CopyOnWriteArrayList<String> fruits = new CopyOnWriteArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        Iterator<String> iterator = fruits.iterator();

        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);

            if (fruit.equals("Banana")) {
                fruits.add("Grape"); // Safe operation, no exception
            }
        }

        System.out.println("Final list: " + fruits);
    }
}
