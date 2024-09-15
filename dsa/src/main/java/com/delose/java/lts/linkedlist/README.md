# Linked List

## Overview

A Linked List is a fundamental data structure where elements (called nodes) are stored in a linear sequence. Each node contains a value and a reference (or link) to the next node in the sequence. Linked Lists are especially useful for dynamic data structures where elements need to be frequently added or removed without the overhead of reallocating memory, as is required with arrays.

## Key Operations

- **Add**: Inserts a new node at the end of the list.
- **Get**: Retrieves the value of the node at a specified index.
- **Remove**: Deletes the node at a specified index.
- **Contains**: Checks whether a value exists within the list.
- **Size**: Returns the number of elements in the list.

## Non-Optimized vs Optimized Version

### Non-Optimized Version
- **Tail Pointer**: This version does not maintain a reference to the tail of the list, making additions to the end of the list an O(n) operation.
- **Size Calculation**: The size method iterates through the entire list to count the elements, making it O(n).

### Optimized Version
- **Tail Pointer**: Maintains a reference to the tail, allowing for O(1) time complexity for adding elements to the end.
- **Size Tracking**: Keeps track of the size in a variable, making size retrieval O(1).

## Complexity

- **Add**: O(1) (optimized) / O(n) (non-optimized)
- **Get**: O(n)
- **Remove**: O(n)
- **Contains**: O(n)
- **Size**: O(1) (optimized) / O(n) (non-optimized)

## Use Cases

Linked Lists are useful when:
- You need efficient insertions/deletions from any position in the list.
- You don’t need random access (as provided by arrays).