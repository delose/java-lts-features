package com.delose.lts.java11.file.methods;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public final class FileOperationsExample {

    public void writeFile(String content, Path filePath) throws Exception {
        Objects.requireNonNull(content, "content must not be null");
        Objects.requireNonNull(filePath, "filePath must not be null");
        Files.writeString(filePath, content);
    }

    public String readFile(Path filePath) throws Exception {
        Objects.requireNonNull(filePath, "filePath must not be null");
        return Files.readString(filePath);
    }

    public static void main(String[] args) throws Exception {
        FileOperationsExample example = new FileOperationsExample();
        Path path = Path.of("sample.txt");

        example.writeFile("Hello, Java 11!", path);
        String content = example.readFile(path);
        System.out.println(content);  // Output: Hello, Java 11!
    }
}
