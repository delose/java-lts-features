package com.delose.java.lts.collections.queue;

import java.util.LinkedList;

public class QueueExample {
    public static void main(String[] args) {
        java.util.Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        System.out.println("q: " + q);
        q.add(3); // can throw IllegalStateException if the queue is full in a fixed-size implementation
        System.out.println("q: " + q);
        System.out.println("q.remove(): " + q.remove());
        System.out.println("q.poll(): " + q.poll());
        System.out.println("q.peek(): " + q.peek());
        q.remove();
        System.out.println("q.peek(): " + q.peek());
        q.add(4);
        System.out.println("q: " + q);
        System.out.println("q.peek(): " + q.peek());
        System.out.println("q.remove(): " + q.remove());
        System.out.println("q.poll(): " + q.poll());
        System.out.println("q.remove(): " + q.remove()); // fails with NoSuchElementException


    }
}
