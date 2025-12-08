package com.delose.java.lts.collections.hashset;

import java.util.HashSet;
import java.util.Set;

record User(String id, String name) {}
class Book {
    String title, author;

}

public class HashSetExample {
    public static void main(String[] args) {
        Set<User> s = new HashSet<>();
        s.add(new User("1", "Ziggy"));
        s.add(new User("1", "Ziggy"));
        System.out.println(s);
    }
}
