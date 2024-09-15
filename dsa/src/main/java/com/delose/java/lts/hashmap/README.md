# Hash Map

## Overview

A Hash Map is a data structure that allows for efficient storage and retrieval of key-value pairs. The underlying concept is to use a hash function to convert a key into an index in an array, where the corresponding value is stored. Hash Maps provide average time complexity of O(1) for lookups, insertions, and deletions, making them extremely useful in scenarios requiring fast access to data.

## Key Operations

- **Put**: Adds or updates a key-value pair in the map.
- **Get**: Retrieves the value associated with a specific key.
- **Remove**: Deletes the key-value pair for a given key.
- **ContainsKey**: Checks if a key exists in the map.
- **Size**: Returns the number of key-value pairs in the map.

## Non-Optimized vs Optimized Version

### Non-Optimized Version
- **Fixed Capacity**: The table has a fixed initial capacity, leading to potential performance degradation as the number of entries grows.
- **No Load Factor Management**: The non-optimized version does not manage the load factor, which could lead to poor performance as the table fills up.

### Optimized Version
- **Dynamic Resizing**: The optimized version resizes the table when the number of entries exceeds a certain threshold, maintaining performance.
- **Load Factor Management**: The optimized version manages the load factor to ensure that the map remains efficient even as it grows.

## Complexity

- **Put**: O(1) on average, O(n) in the worst case due to collisions.
- **Get**: O(1) on average, O(n) in the worst case due to collisions.
- **Remove**: O(1) on average, O(n) in the worst case due to collisions.
- **ContainsKey**: O(1) on average, O(n) in the worst case due to collisions.
- **Size**: O(1)

## Use Cases

Hash Maps are commonly used in scenarios where quick access to data is required, such as in caching, implementing dictionaries, and handling key-based lookups.