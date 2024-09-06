package com.delose.lts.java8.method;

public class Car implements Vehicle {

    private String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }
}