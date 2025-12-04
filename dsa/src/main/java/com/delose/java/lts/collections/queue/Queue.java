package com.delose.java.lts.collections.queue;

public interface Queue<T> {
    void enqueue(T value);
    T dequeue();
    boolean isEmpty();
    int size();
    T peek();
}
