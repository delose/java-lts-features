package com.delose.lts.java11.nested.access.control;

public class OuterClass {
    private String outerField = "Outer field";

    class InnerClass {
        private String innerField = "Inner field";

        private void accessOuterField() {
            System.out.println("Accessing: " + outerField);  // Accessing private member of outer class
        }
    }

    private void accessInnerField() {
        InnerClass inner = new InnerClass();
        System.out.println("Accessing: " + inner.innerField);  // Accessing private member of inner class
        inner.accessOuterField();  // Accessing private method of inner class
    }


}
