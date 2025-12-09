package com.delose.java.lts.collections.stack;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.remove(1);
        System.out.println(s);
        System.out.println("s.peek(): " + s.peek());
        System.out.println("s.empty(): " + s.empty());
        System.out.println("s.pop(): " + s.pop());
        System.out.println("s.push(4): " + s.push(4));
        System.out.println("s.search(3): " + s.search(3));
        Stack<Integer> clone = (Stack<Integer>) s.clone();
        System.out.println("s.clone(): " + clone);
        clone.clear();
        System.out.println("s.clone() clear(): " + clone);
        System.out.println("s.elementAt(0): " + s.elementAt(0));
        System.out.println("s.capacity(): " + s.capacity());
        System.out.println("s.contains(1): " + s.contains(1));
        System.out.println("s.push(5): " + s.push(5));
        System.out.println("s.elementAt(2): " + s.elementAt(2));
        s.elements().asIterator().forEachRemaining(integer -> System.out.println("s.elements().asIterator().forEachRemaining: " + integer));
        System.out.println("s.firstElement(): " + s.firstElement());
        System.out.println("s.get(0): " + s.get(0));
        System.out.println("s.isEmpty(): " + clone.isEmpty());
//        System.out.println("s.getLast(): " + s.getLast());
        System.out.println("s.indexOf(3): " + s.indexOf(3));
        s.insertElementAt(2, 1);
        System.out.println("s.insertElementAt(2, 1) result: " + s);
//        System.out.println("s.reversed(): " + s.reversed());
        s.setElementAt(22, 1);
        System.out.println("s.setElementAt(22, 1) result: " + s);
        System.out.println("s.stream().count(): " + s.stream().count());
        System.out.println("s.subList(0, 2): " + s.subList(0, 2));
        System.out.println("s.isEmpty(): " + s.isEmpty());
        s.clear();
        System.out.println("s.isEmpty() after clear(): " + s.isEmpty());
    }
}
