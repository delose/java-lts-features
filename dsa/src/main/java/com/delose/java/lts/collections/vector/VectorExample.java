package com.delose.java.lts.collections.vector;

import java.util.Iterator;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<String> fruits = new Vector<>();
        fruits.add("Grapes");
        fruits.add("Mango");
        System.out.println(fruits);

        String grapes = fruits.get(0);
        System.out.println(grapes);

        for (String fruit : fruits) {
            System.out.println("iterator.next(): " + fruit);
        }

        fruits.remove("Mango");
        System.out.println(fruits);
        System.out.println("size: " + fruits.size());
        System.out.println("capacity: " + fruits.capacity());
    }
}
