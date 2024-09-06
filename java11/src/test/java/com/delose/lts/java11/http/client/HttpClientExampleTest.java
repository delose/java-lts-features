package com.delose.lts.java11.http.client;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HttpClientExampleTest {
    @Test
    public void testFetchData() throws Exception {
        HttpClientExample example = new HttpClientExample();
        String response = example.fetchData("https://jsonplaceholder.typicode.com/posts/1");
        assertTrue(response.contains("\"id\": 1"));
    }
}
