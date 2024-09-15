package com.delose.java.lts.queue.impl;

import com.delose.java.lts.queue.Queue;

public class QueueOptimised<T> implements Queue<T> {

    private static final int INITIAL_CAPACITY = 10;
    private T[] array;
    private int front;
    private int rear;
    private int size;

    @SuppressWarnings("unchecked")
    public QueueOptimised() {
        array = (T[]) new Object[INITIAL_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T value) {
        if (size == array.length) {
            resize();
        }
        rear = (rear + 1) % array.length;
        array[rear] = value;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T value = array[front];
        front = (front + 1) % array.length;
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return array[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] newArray = (T[]) new Object[array.length * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[(front + i) % array.length];
        }
        front = 0;
        rear = size - 1;
        array = newArray;
    }
}
