package com.delose.java.lts.queue;

import org.junit.Test;

import com.delose.java.lts.queue.impl.QueueNonOptimised;
import com.delose.java.lts.queue.impl.QueueOptimised;

import static org.junit.Assert.*;

public class QueueUnitTest {

    @Test
    public void testEnqueueAndDequeue() {
        Queue<Integer> queue = new QueueNonOptimised<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(Integer.valueOf(1), queue.dequeue());
        assertEquals(Integer.valueOf(2), queue.dequeue());
        assertEquals(Integer.valueOf(3), queue.dequeue());

        Queue<Integer> queueO = new QueueOptimised<>();
        queueO.enqueue(1);
        queueO.enqueue(2);
        queueO.enqueue(3);

        assertEquals(Integer.valueOf(1), queueO.dequeue());
        assertEquals(Integer.valueOf(2), queueO.dequeue());
        assertEquals(Integer.valueOf(3), queueO.dequeue());
    }

    @Test(expected = IllegalStateException.class)
    public void testDequeueFromEmptyNonOptimisedQueue() {
        Queue<Integer> queue = new QueueNonOptimised<>();
        queue.dequeue();  // Should throw an exception
    }

    @Test(expected = IllegalStateException.class)
    public void testDequeueFromEmptyOptimisedQueue() {
        Queue<Integer> queueO = new QueueOptimised<>();
        queueO.dequeue();  // Should throw an exception
    }

    @Test
    public void testPeek() {
        Queue<Integer> queue = new QueueNonOptimised<>();
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(Integer.valueOf(1), queue.peek());
        assertEquals(2, queue.size());

        Queue<Integer> queueO = new QueueOptimised<>();
        queueO.enqueue(1);
        queueO.enqueue(2);

        assertEquals(Integer.valueOf(1), queueO.peek());
        assertEquals(2, queueO.size());
    }

    @Test
    public void testIsEmpty() {
        Queue<Integer> queue = new QueueNonOptimised<>();
        assertTrue(queue.isEmpty());

        queue.enqueue(1);
        assertFalse(queue.isEmpty());

        Queue<Integer> queueO = new QueueOptimised<>();
        assertTrue(queueO.isEmpty());

        queueO.enqueue(1);
        assertFalse(queueO.isEmpty());
    }

    @Test
    public void testSize() {
        Queue<Integer> queue = new QueueNonOptimised<>();
        queue.enqueue(1);
        queue.enqueue(2);

        assertEquals(2, queue.size());

        queue.dequeue();
        assertEquals(1, queue.size());

        Queue<Integer> queueO = new QueueOptimised<>();
        queueO.enqueue(1);
        queueO.enqueue(2);

        assertEquals(2, queueO.size());

        queueO.dequeue();
        assertEquals(1, queueO.size());
    }
}
