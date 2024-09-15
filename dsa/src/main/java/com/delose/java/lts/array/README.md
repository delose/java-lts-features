# Array and Dynamic Array

## Overview

An array is a linear data structure that stores elements in contiguous memory locations. The index of an array starts from zero, making it easy to access elements by their position. Arrays are fixed in size, meaning that once created, their size cannot be changed. A Dynamic Array, however, is a variation that can resize itself when it gets full, allowing more flexibility in managing dynamic datasets.

## Key Operations

- **Add**: Inserts an element at the end of the array.
- **Get**: Retrieves the element at a specified index.
- **Remove**: Deletes the element at a specified index, shifting subsequent elements to fill the gap.
- **Contains**: Checks whether an element exists within the array.
- **Size**: Returns the number of elements currently stored in the array.

## Non-Optimized vs Optimized Version

### Non-Optimized Version
- **Fixed Capacity**: The non-optimized array has a fixed size, meaning that once the array is full, no more elements can be added.
- **Manual Memory Management**: The developer must handle memory manually by checking whether the array is full before adding new elements.

### Optimized Version (Dynamic Array)
- **Dynamic Resizing**: The optimized version automatically resizes itself when the array reaches its capacity, typically by doubling its size. This allows the array to accommodate more elements as needed.
- **Ease of Use**: The resizing operation is abstracted away, providing a more user-friendly interface for working with dynamic datasets.

## Complexity

- **Add**: O(1) amortized (in the dynamic array, since resizing occurs occasionally).
- **Get**: O(1)
- **Remove**: O(n) (due to the need to shift elements after removal).
- **Contains**: O(n)
- **Size**: O(1)

## Use Cases

Arrays and dynamic arrays are fundamental structures used in many applications. They are the backbone of many other data structures, including lists, stacks, and queues, and are commonly used for storing and manipulating collections of data in both simple and complex programs.