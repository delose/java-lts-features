package com.delose.lts.java8.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionallyExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
           if (true) {
               throw new RuntimeException("Something went wrong!");
           }
           return "Success";
        }).exceptionally(ex -> {
            System.out.println("Exception handled: " + ex.getMessage());
            return "Recovered Result";
        });

        System.out.println(future.get());
    }
}
