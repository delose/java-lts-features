package com.delose.lts.java11.epsilon.gc;

public class EpsilonGCExample {

    public static void main(String[] args) {
        // Allocate memory without reclaiming
        for (int i = 0; i < 10_000_000; i++) {
            byte[] b = new byte[1024 * 1024];  // 1 MB allocation
        }
        System.out.println("Memory allocation complete.");
    }
}
