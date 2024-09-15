package com.delose.java.lts.linkedlist;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListBeginnerTest {

    @Test
    public void testAddAndGet() {
        LinkedListBeginner list = new LinkedListBeginner();
        list.add(1);
        list.add(2);
        list.add(3);
        
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testRemove() {
        LinkedListBeginner list = new LinkedListBeginner();
        list.add(1);
        list.add(2);
        list.add(3);
        
        list.remove(1);
        assertEquals(3, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    public void testContains() {
        LinkedListBeginner list = new LinkedListBeginner();
        list.add(1);
        list.add(2);
        list.add(3);
        
        assertTrue(list.contains(2));
        assertFalse(list.contains(4));
    }
}