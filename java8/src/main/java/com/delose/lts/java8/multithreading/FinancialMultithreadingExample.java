package com.delose.lts.java8.multithreading;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
    private BigDecimal balance;
    private final Lock lock = new ReentrantLock();
    private final Condition sufficientFunds = lock.newCondition();
    private final Random random = new Random();

    public FaultyAccount(double initialBalance) {
        this.balance = BigDecimal.valueOf(initialBalance).setScale(2, RoundingMode.HALF_EVEN);
    }

    public void deposit(BigDecimal amount) {
        lock.lock();
        try {
            if (random.nextDouble() < 0.1) {
                throw new NetworkException("Simulated network error during deposit!");
            }
            balance = balance.add(amount).setScale(2, RoundingMode.HALF_EVEN);
            System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". New balance: " + balance);
            sufficientFunds.signalAll();
        } catch (NetworkException e) {
            System.out.println(Thread.currentThread().getName() + " ERROR: " + e.getMessage() + " Transaction aborted,");
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(BigDecimal amount) throws InterruptedException {
        lock.lock();
        try {
            while (balance.compareTo(amount) < 0) {
                System.out.println(Thread.currentThread().getName() + " is waiting for sufficient funds...");
                sufficientFunds.await();
            }
            balance = balance.subtract(amount).setScale(2, RoundingMode.HALF_EVEN);
            System.out.println(Thread.currentThread().getName() + " withdrew " + amount + ". New balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public BigDecimal getBalance() {
        return balance;
    }
}

public class FinancialMultithreadingExample {
    public static void main(String[] args) throws InterruptedException {
        FaultyAccount account = new FaultyAccount(1000.0);
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            BigDecimal amount = BigDecimal.valueOf(50);
            executor.submit(() -> account.deposit(amount));
        }

        executor.shutdown();
        if (executor.awaitTermination(1, TimeUnit.MINUTES)) {
            System.out.println("All tasks completed. Final balance (may be impacted by failures): " + account.getBalance());
        }
    }
}
