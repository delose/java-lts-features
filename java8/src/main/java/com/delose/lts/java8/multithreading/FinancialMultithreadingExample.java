package com.delose.lts.java8.multithreading;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class NetworkException extends Exception {
    public NetworkException(String message) {
        super(message);
    }
}

class FaultyAccount {
    private double balance;
    private final Lock lock = new ReentrantLock();
    private final Condition sufficientFunds = lock.newCondition();
    private final Random random = new Random();

    public FaultyAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            if (random.nextDouble() < 0.1) {
                throw new NetworkException("Simulated network error during deposit!");
            }
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". New balance: " + balance);
            sufficientFunds.signalAll();
        } catch (NetworkException e) {
            System.out.println(Thread.currentThread().getName() + " ERROR: " + e.getMessage() + " Transaction aborted,");
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) throws InterruptedException {
        lock.lock();
        try {
            while (balance < amount) {
                System.out.println(Thread.currentThread().getName() + " is waiting for sufficient funds...");
                sufficientFunds.await();
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". New balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class FinancialMultithreadingExample {
    public static void main(String[] args) throws InterruptedException {
        FaultyAccount account = new FaultyAccount(1000.0);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            Random random = new Random();
//            double randomAmount = 10.0 + (90.0 * random.nextDouble());
            double randomAmount = 50.0;
            executor.submit(() -> account.deposit(randomAmount));
        }

        executor.shutdown();
        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("All tasks completed. Final balance (may be impacted by failures): " + account.getBalance());
        }
    }
}
