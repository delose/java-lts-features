package com.delose.java.lts.array;

public class ArrayBeginner {

    private static final int DEFAULT_CAPACITY = 10;
    private int[] array;
    private int size;

    public ArrayBeginner() {
        array = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    public ArrayBeginner(int initialCapacity) {
        array = new int[initialCapacity];
        size = 0;
    }

    public void add(int value) {
        if (size == array.length) {
            resize();
        }
        array[size++] = value;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return array[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    private void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
