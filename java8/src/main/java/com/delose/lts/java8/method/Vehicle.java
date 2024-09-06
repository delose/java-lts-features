package com.delose.lts.java8.method;

public interface Vehicle {
    String getBrand();

    default String startEngine() {
        return "The engine is starting...";
    }
}