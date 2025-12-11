package com.delose.lts.java8.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class RunAsyncExample {
    public static void main(String[] args) throws Exception {
        System.out.println("Main thread started. Task will run in the background.");

        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("I'm running in a separate thread.");
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        });

        System.out.println("Main thread is busy with other work...");

        future.get();
        System.out.println("Main thread is finished and the background task is done.");
    }
}
