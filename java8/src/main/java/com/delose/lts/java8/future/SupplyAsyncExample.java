package com.delose.lts.java8.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class SupplyAsyncExample {
    public static void main(String[] args) throws Exception {
        System.out.println("Main thread started. Fetching result asynchronously.");

        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
           try {
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException e) {
               throw new IllegalStateException(e);
           }
           return "Hello, World";
        });

        System.out.println("Main thread is waiting for the result...");

        String result = future.get();

        System.out.println("Received result: " + result);
    }
}
