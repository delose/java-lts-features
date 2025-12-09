package com.delose.java.lts.design_patterns.creational;

public class Singleton {

    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton initialization (once)");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return  instance;
    }

}
