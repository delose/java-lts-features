package com.delose.java.lts.queue.impl;

import java.util.LinkedList;

import com.delose.java.lts.queue.Queue;

public class QueueNonOptimised<T> implements Queue<T> {

    private LinkedList<T> list = new LinkedList<>();

    public void enqueue(T value) {
        list.addLast(value);
    }

    public T dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.removeFirst();
    }

    public T peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }
}
