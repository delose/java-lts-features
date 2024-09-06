package com.delose.lts.java11.nested.access.control;

import org.junit.Test;

public class OuterClassTest {

    @Test
    public void testNestBasedAccess() {
        OuterClass outer = new OuterClass();
        // below erroring out as inner class is private
        // outer.accessInnerField();  // This will internally verify the access between outer and inner classes
    }

}
