package com.delose.java.lts.hashmap;

public class HashMapBeginner<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private Entry<K, V>[] table;

    public HashMapBeginner() {
        table = new Entry[INITIAL_CAPACITY];
    }

    public void put(K key, V value) {
        int index = hash(key) % INITIAL_CAPACITY;
        Entry<K, V> newEntry = new Entry<>(key, value);
        if (table[index] == null) {
            table[index] = newEntry;
        } else {
            Entry<K, V> current = table[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(key)) {
                current.value = value;
            } else {
                current.next = newEntry;
            }
        }
    }

    public V get(K key) {
        int index = hash(key) % INITIAL_CAPACITY;
        Entry<K, V> current = table[index];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key) % INITIAL_CAPACITY;
        Entry<K, V> current = table[index];
        Entry<K, V> previous = null;
        while (current != null) {
            if (current.key.equals(key)) {
                if (previous == null) {
                    table[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int size() {
        int size = 0;
        for (Entry<K, V> entry : table) {
            while (entry != null) {
                size++;
                entry = entry.next;
            }
        }
        return size;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode());
    }

    private static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}
