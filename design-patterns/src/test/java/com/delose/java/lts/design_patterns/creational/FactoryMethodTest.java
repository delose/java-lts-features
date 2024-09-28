package com.delose.java.lts.design_patterns.creational;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FactoryMethodTest {

    PizzaFactory pizzaFactory;

    @BeforeEach
    public void setUp() {
        pizzaFactory = new PizzaFactory();
    }

    @Test
    public void givenCheesePizza_whenCreated_thenIngredientsAreSet() {
        //given
        Pizza cheesePizza = pizzaFactory.createPizza("cheese");

        //when + then
        cheesePizza.addIngredients();
        Assertions.assertEquals("Cheese", cheesePizza.getIngredients());

    }

}
