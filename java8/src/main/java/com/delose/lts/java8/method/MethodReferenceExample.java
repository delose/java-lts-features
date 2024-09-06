package com.delose.lts.java8.method;

import java.util.List;

public class MethodReferenceExample {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public void printAllMessages(List<String> messages) {
        messages.forEach(MethodReferenceExample::printMessage);
    }

}
