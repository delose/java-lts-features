package com.delose.java.lts.array;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayBeginnerTest {

    @Test
    public void testAddAndGet() {
        ArrayBeginner array = new ArrayBeginner();
        array.add(1);
        array.add(2);
        array.add(3);

        assertEquals(1, array.get(0));
        assertEquals(2, array.get(1));
        assertEquals(3, array.get(2));
    }

    @Test
    public void testRemove() {
        ArrayBeginner array = new ArrayBeginner();
        array.add(1);
        array.add(2);
        array.add(3);

        array.remove(1);
        assertEquals(3, array.get(1));
        assertEquals(2, array.size());
    }

    @Test
    public void testResize() {
        ArrayBeginner array = new ArrayBeginner(2);
        array.add(1);
        array.add(2);
        array.add(3);

        assertEquals(3, array.size());
        assertEquals(3, array.get(2));
    }

    @Test
    public void testContains() {
        ArrayBeginner array = new ArrayBeginner();
        array.add(1);
        array.add(2);
        array.add(3);

        assertTrue(array.contains(2));
        assertFalse(array.contains(4));
    }

}
