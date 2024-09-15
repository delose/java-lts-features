package com.delose.java.lts.hashmap;

import org.junit.Test;
import static org.junit.Assert.*;

public class HashMapBeginnerTest {

    @Test
    public void testPutAndGet() {
        HashMapBeginner<Integer, String> map = new HashMapBeginner<>();
        String one = "One";
        String two = "Two";
        String three = "Three";
        map.put(1, one);
        map.put(2, two);
        map.put(3, three);

        assertEquals(one, map.get(1));
        assertEquals(two, map.get(2));
        assertEquals(three, map.get(3));
    }

    @Test
    public void testRemove() {
        HashMapBeginner<Integer, String> map = new HashMapBeginner<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        map.remove(2);
        assertNull(map.get(2));
    }

    @Test
    public void testContainsKey() {
        HashMapBeginner<Integer, String> map = new HashMapBeginner<>();
        map.put(1, "One");
        map.put(2, "Two");

        assertTrue(map.containsKey(1));
        assertFalse(map.containsKey(3));
    }

    @Test
    public void testSize() {
        HashMapBeginner<Integer, String> map = new HashMapBeginner<>();
        map.put(1, "One");
        map.put(2, "Two");

        assertEquals(2, map.size());
        map.remove(2);
        assertEquals(1, map.size());
    }
}