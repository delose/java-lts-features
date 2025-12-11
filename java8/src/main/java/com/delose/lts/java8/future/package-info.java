/**
 * This package contains various examples demonstrating the use of
 * the {@link java.util.concurrent.CompletableFuture} class introduced in Java 8.
 * <p>
 * The examples cover key functionalities:
 * <ul>
 *     <li>1. {@link com.delose.lts.java8.future.RunAsyncExample}: Running tasks without return values using {@code runAsync()}.</li>
 *     <li>2. {@link com.delose.lts.java8.future.SupplyAsyncExample}: Running tasks with return values using {@code supplyAsync()}.</li>
 *     <li>3. {@link com.delose.lts.java8.future.ThenApplyExample}: Chaining operations to transform results using {@code thenApply()}.</li>
 *     <li>4. {@link com.delose.lts.java8.future.ThenCombineExample}: Combining results of two independent futures using {@code thenCombine()}.</li>
 *     <li>5. {@link com.delose.lts.java8.future.ExceptionallyExample}: Handling exceptions within the asynchronous pipeline using {@code exceptionally()}.</li>
 * </ul>
 * These examples showcase how to build more responsive and non-blocking asynchronous workflows in Java.
 *
 * @since 1.8
 * @author Eugene via Google
 * @version 1.0
 */
package com.delose.lts.java8.future;