package com.delose.lts.java8.string;

public class StringOperatorsExample {
    public static void main(String[] args) {
        String str = "Hello World";
        String EMPTY = " ";

        String str1 = str.split(EMPTY)[0];
        String str2 = str.split(EMPTY)[1];

        System.out.println("First word: " + str1);
        System.out.println("Second word: " + str2);
    }
}
