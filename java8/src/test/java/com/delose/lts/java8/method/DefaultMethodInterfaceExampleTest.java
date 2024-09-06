package com.delose.lts.java8.method;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DefaultMethodInterfaceExampleTest {
    @Test
    public void testStartEngine() {
        Vehicle car = new Car("Toyota");
        assertEquals("The engine is starting...", car.startEngine());
    }

    @Test
    public void testGetBrand() {
        Vehicle car = new Car("Toyota");
        assertEquals("Toyota", car.getBrand());
    }
}