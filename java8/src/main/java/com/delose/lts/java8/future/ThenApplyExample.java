package com.delose.lts.java8.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ThenApplyExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> "Eugene")
                .thenApply(name -> "Hello " + name)
                .thenApply(greeting -> ", How are you today?");

        System.out.println(welcomeText.get());
    }
}
