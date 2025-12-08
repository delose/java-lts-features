package com.delose.java.lts.collections.hashmap;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {

        Map<String, String> m = new HashMap<>();
        m.put("k", "a");
        m.put(null, "a");
        System.out.println(m);
        m.put("k", "b");
        m.put(null, "b");
        System.out.println(m);
    }
}
