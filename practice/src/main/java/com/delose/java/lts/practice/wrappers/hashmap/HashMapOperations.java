package com.delose.java.lts.practice.wrappers.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.Collection;

public class HashMapOperations<K, V> {

    HashMap<K, V> hashMap;

    public HashMapOperations() {
        hashMap = new HashMap<>();
    }

    /**
     * Remove all entries from the map.
     */
    public void clear() {
        this.hashMap.clear();
    }

    /**
     * Create a copy of the HashMap.
     */
    @SuppressWarnings("unchecked")
    public HashMap<K, V> clone() {
        return (HashMap<K,V>) this.hashMap.clone();
    }

    /**
     * Compute a value for an entry based on its key and the current value (if it has one)
     */
    public V compute(K key, BiFunction<K, V, V> biFunction) {
        // BiFunction<BigDecimal, BigDecimal, BigDecimal> bf = (BigDecimal a, BigDecimal b) -> {
        //     return a.add(b);
        // };
        return this.hashMap.compute(key, biFunction);
    }

    /**
     * Compute a value for an entry based on its key only if an entry using the key does not already exist
     */
    public V computeIfAbsent(K key, Function<K, V> function) {
        // Function<K, V> function1 = (K k) -> {
        //     return function.apply(k);
        // };
        return this.hashMap.computeIfAbsent(key, function);
    }

    /**
     * Compute a new value for an entry based on its key and current value but only if an entry with the key already exists
     */
    public V computeIfPresent(K key, BiFunction<K, V, V> biFunction) {
        return this.hashMap.computeIfPresent(key, biFunction);
    }

    /**
     * Indicate if an entry with the specified value exists in the map
     */
    public boolean containsValue(V value) {
        return this.hashMap.containsValue(value);
    }

    /**
     * Return a set of all entries in the map
     */
    public Set<Map.Entry<K, V>> entrySet() {
        return this.hashMap.entrySet();
    }

    /**
     * Perform an action on every entry in the map
     */
    public void forEach(BiConsumer<K, V> biConsumer) {
        this.hashMap.forEach(biConsumer);
    }

    /**
     * Return the value of the entry with a specified key
     */
    public V get(K key) {
        return this.hashMap.get(key);
    }
    
    /**
     * Return the value of the entry with a specified key or a default value if the entry is not found
     */
    public V getOrDefault(K key, V defaultValue) {
        return this.hashMap.getOrDefault(key, defaultValue);
    }

    /**
     * Indicate whether the map is empty
     */
    public boolean isEmpty() {
        return this.hashMap.isEmpty();
    }

    /**
     * Return a set of all keys in the map
     */
    public Set<K> keySet() {
        return this.hashMap.keySet();
    }

    /**
     * Compute a value for an entry based on its key and value or write a specific value if the entry does not yet exist
     */
    public V merge(K key, V value, BiFunction<V, V, V> biFunction) {
        return this.hashMap.merge(key, value, biFunction);
    }

    /**
     * Write an entry into the map
     */
    public V put(K key, V value) {
        return this.hashMap.put(key, value);
    }
    
    /**
     * Write all of the entries from another map into this one
     */
    public void putAll(Map<K, V> map) {
        this.hashMap.putAll(map);
    }

    /**
     * Write an entry into the map but only if an entry with the same key does not already exist
     */
    public V putIfAbsent(K key, V value) {
        return this.hashMap.putIfAbsent(key, value);
    }

    /**
     * Remove an entry from the map
     */
    public V remove(K key) {
        return this.hashMap.remove(key);
    }

    /**
     * Write an entry in the map only if it exists
     */
    public V replace(K key, V value) {
        return this.hashMap.replace(key, value);
    }

    /**
     * Replaces the value of every entry with the result of an operation
     */
    public void replaceAll(BiFunction<K, V, V> biFunction) {
        this.hashMap.replaceAll(biFunction);
    }

    /**
     * Return the number of entries in the map
     */
    public int size() {
        return this.hashMap.size();
    }

    /**
     * Return a collection containing all of the values in the map
     */
    public Collection<V> values() {
        return this.hashMap.values();
    }
}
