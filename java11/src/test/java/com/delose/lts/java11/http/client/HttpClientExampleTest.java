package com.delose.lts.java11.http.client;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HttpClientExampleTest {
    @Test
    public void testFetchData() {
        HttpClientExample example = new HttpClientExample();
        Optional<String> response = example.fetchData("https://jsonplaceholder.typicode.com/posts/1");
        assertTrue(response.isPresent());
        assertTrue(response.get().contains("\"id\": 1"));
    }

}
