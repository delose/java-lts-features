package com.delose.java.lts.queue;

import org.junit.Ignore;
import org.junit.Test;

import com.delose.java.lts.queue.impl.QueueNonOptimised;
import com.delose.java.lts.queue.impl.QueueOptimised;

public class QueuePerformanceTest {

    private static final int NUM_OPERATIONS = 1_000_000;

    @Test
    @Ignore("This performance test is intermittenly succeeding and failing and needs further investigation.")
    public void testPerformance() {
        long nonOptimisedTime = measurePerformance(new QueueNonOptimised<Integer>());
        long optimisedTime = measurePerformance(new QueueOptimised<Integer>());
        
        System.out.println("time difference: " + (nonOptimisedTime - optimisedTime) + " ns");
        org.junit.Assert.assertTrue("Optimised queue should be faster", optimisedTime < nonOptimisedTime);
    }

    private long measurePerformance(Queue<Integer> queue) {
        long startTime = System.nanoTime();

        // Enqueue operations
        for (int i = 0; i < NUM_OPERATIONS; i++) {
            queue.enqueue(i);
        }

        // Dequeue operations
        for (int i = 0; i < NUM_OPERATIONS; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(queue.getClass().getSimpleName() + " took " + duration + " ns");
        return duration;
    }
}
