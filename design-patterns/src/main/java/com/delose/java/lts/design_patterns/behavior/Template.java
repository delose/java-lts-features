package com.delose.java.lts.design_patterns.behavior;

abstract class HouseBuilder {

    public final void buildHouse() {
        buildFoundation();
        buildWalls();
        buildRoof();
        System.out.println("House built successfully.");
    }

    public void buildFoundation() {
        System.out.println("Building foundation with cement and steel.");
    }

    public void buildRoof() {
        System.out.println("Building roof with tiles.");
    }

    public abstract void buildWalls();
}

class WoodenHouse extends HouseBuilder {

    @Override
    public void buildWalls() {
        System.out.println("Building wooden walls.");
    }
}

class ConcreteHouse extends HouseBuilder {

    @Override
    public void buildWalls() {
        System.out.println("Building concrete walls.");
    }
}

public class Template {

    public static void main(String[] args) {
        HouseBuilder woodBuilder = new WoodenHouse();
        System.out.println("--Building a Wooden House--");
        woodBuilder.buildHouse();

        System.out.println("--Building a Concrete House--");
        HouseBuilder concreteBuilder = new ConcreteHouse();
        concreteBuilder.buildHouse();
    }
}
