package com.delose.lts.java8.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenCombineExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<String> combinedFuture = future1.thenCombine(
                future2,
                (result1, result2) -> result1 + " " + result2
        );

        System.out.println(combinedFuture.get());
    }
}
