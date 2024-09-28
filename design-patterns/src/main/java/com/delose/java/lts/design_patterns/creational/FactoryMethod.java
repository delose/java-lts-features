package com.delose.java.lts.design_patterns.creational;

public class FactoryMethod {
    public static void main(String[] args) {
        BasePizzaFactory pizzaFactory = new PizzaFactory();
        Pizza cheesePizza = pizzaFactory.createPizza("cheese");
        Pizza veggiePizza = pizzaFactory.createPizza("veggie");
    }
}

abstract class Pizza {
    protected String ingredients;
    public abstract void addIngredients();
    public abstract void setIngredients();
    public abstract void setIngredients(String ingredients);
    public abstract String getIngredients();
    public void bakePizza() {
        System.out.println("Pizza baked at 400 for 20 minutes.");
    }
}

class CheesePizza extends Pizza {
    @Override
    public void addIngredients() {
        if (super.ingredients == null) {
            setIngredients();
            System.out.println("Preparing ingredients for cheese pizza.");
        }
    }

    @Override
    public void setIngredients() {
        super.ingredients = "Cheese";
    }

    @Override
    public void setIngredients(String ingredients) {
        super.ingredients = ingredients;
    }

    @Override
    public String getIngredients() {
        return super.ingredients;
    }
}

class PepperoniPizza extends Pizza {
    @Override
    public void addIngredients() {
        if (super.ingredients == null) {
            setIngredients();
            System.out.println("Preparing ingredients for pepperoni pizza.");
        }
    }

    @Override
    public void setIngredients() {
        super.ingredients = "Pepperoni";
    }

    @Override
    public void setIngredients(String ingredients) {
        super.ingredients = ingredients;
    }

    @Override
    public String getIngredients() {
        return super.ingredients;
    }
}

class VeggiePizza extends Pizza {
    @Override
    public void addIngredients() {
        if (super.ingredients == null) {
            setIngredients();
            System.out.println("Preparing ingredients for veggie pizza.");
        }
    }

    @Override
    public void setIngredients() {
        super.ingredients = "Veggies";
    }

    @Override
    public void setIngredients(String ingredients) {
        super.ingredients = ingredients;
    }

    @Override
    public String getIngredients() {
        return super.ingredients;
    }
}

abstract class BasePizzaFactory {
    
    public abstract Pizza createPizza(String type);
}

class PizzaFactory extends BasePizzaFactory{
    @Override
    public Pizza createPizza(String type){
        Pizza pizza;
        switch (type.toLowerCase())
        {
            case "cheese":
                pizza = new CheesePizza();
                pizza.setIngredients("Cheese");
                break;
            case "pepperoni":
                pizza = new PepperoniPizza();
                pizza.setIngredients("Pepperoni");
                break;
            case "veggie":
                pizza = new VeggiePizza();
                pizza.setIngredients("Veggies");
                break;
            default: throw new IllegalArgumentException("No such pizza.");
        }
        pizza.addIngredients();
        pizza.bakePizza();
        return pizza;
    }
}
