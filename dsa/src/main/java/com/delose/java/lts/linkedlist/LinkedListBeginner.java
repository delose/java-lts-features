package com.delose.java.lts.linkedlist;

public class LinkedListBeginner {

    private Node head;

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
        }
    }

    public int get(int index) {
        Node current = head;
        int count = 0;
        while (current != null) {
            if (count == index) {
                return current.value;
            }
            count++;
            current = current.next;
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    public void remove(int index) {
        if (head == null) throw new IndexOutOfBoundsException("Index out of bounds");

        if (index == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;
        int count = 0;
        while (current != null) {
            if (count == index) {
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
            count++;
        }
        throw new IndexOutOfBoundsException("Index out of bounds");
    }

    public boolean contains(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
