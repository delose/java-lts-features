package com.delose.lts.java11.file.methods;

import static org.junit.Assert.assertEquals;

import java.nio.file.Path;

import org.junit.Test;

public class FileOperationsExampleTest {

    @Test
    public void testFileOperations() throws Exception {
        FileOperationsExample example = new FileOperationsExample();
        Path path = Path.of("test.txt");

        example.writeFile("Test content", path);
        String content = example.readFile(path);

        assertEquals("Test content", content);
    }
}
