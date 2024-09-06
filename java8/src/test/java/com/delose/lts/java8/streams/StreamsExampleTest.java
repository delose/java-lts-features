package com.delose.lts.java8.streams;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StreamsExampleTest {
    @Test
    public void testFilterNames() {
        StreamsExample example = new StreamsExample();

        List<String> names = Arrays.asList("John", "Jane", "Peter", "Alice", "Jack");
        List<String> filteredNames = example.filterNames(names);

        assertEquals(Arrays.asList("John", "Jane", "Jack"), filteredNames);
    }
}
