package com.delose.java.lts.practice.wrappers.array;

public class ArrayOperations<T> {

    /**
     * Compares two arrays lexicographically
     */
    public int compare(boolean[] a, boolean[] a2) {
        return java.util.Arrays.compare(a, a2);
    }

    /**
     * Compares two multidimensional arrays to check whether they are deeply equal to each other
     */
    public boolean deepEquals(T[] a, T[] a2) {
        return java.util.Arrays.deepEquals(a, a2);
    }

    /**
     * Checks if two arays are equal
     */
    public boolean equals(T[] a, T[] a2) {
        return java.util.Arrays.equals(a, a2);
    }

    /**
     * Fills an array with a specified value
     */
    public void fill(T[] a, T val) {
        java.util.Arrays.fill(a, val);
    }

    /**
     * Returns the index position of the first mismatch/conflict between two arrays
     */
    public int mismatch(T[] a, T[] a2) {
        return java.util.Arrays.mismatch(a, a2);
    }

    /**
     * Sorts an array in ascending order
     */
    public void sort(T[] a) {
        java.util.Arrays.sort(a);
    }

    /**
     * Returns the length of an array
     */
    public int length(T[] a) {
        return a.length;
    }
    
}
