package com.delose.java.lts.collections.hashtable;

import java.util.Hashtable;
import java.util.Map;

public class HashTableExample {
    public static void main(String[] args) {
        Map<String, String> ht = new Hashtable<>();
        ht.put("1", "a");
        System.out.println(ht);
        ht.put(null, "b"); // RTE
        System.out.println(ht);
    }
}
