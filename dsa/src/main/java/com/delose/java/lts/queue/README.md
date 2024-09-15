# Queue

## Overview

A Queue is a linear data structure that follows the First-In-First-Out (FIFO) principle. This means that the first element added to the queue will be the first one to be removed. Queues are commonly used in various scenarios, such as task scheduling, buffering, and breadth-first search algorithms.

## Key Operations

- **Enqueue**: Adds an element to the rear of the queue.
- **Dequeue**: Removes and returns the element at the front of the queue.
- **Peek**: Returns the element at the front without removing it.
- **IsEmpty**: Checks whether the queue is empty.
- **Size**: Returns the number of elements in the queue.

## Non-Optimized vs Optimized Version

### Non-Optimized Version
- **LinkedList-Based**: The non-optimized version uses a `LinkedList` to manage the queue. This provides simplicity but may have higher memory overhead and less predictable performance due to object references.

### Optimized Version
- **Array-Based with Dynamic Resizing**: The optimized version uses a circular array to manage the queue. This reduces memory overhead and can improve cache performance. The array resizes dynamically when it becomes full.

## Complexity

- **Enqueue**: O(1) amortized (for the array-based implementation, considering occasional resizing).
- **Dequeue**: O(1)
- **Peek**: O(1)
- **IsEmpty**: O(1)
- **Size**: O(1)

## Use Cases

Queues are useful in a variety of applications:
- **Task Scheduling**: Tasks are often managed in queues, where they are processed in the order they arrive.
- **Breadth-First Search**: Queues are integral to BFS in graph and tree traversal algorithms.
- **Buffering**: Queues are used to manage buffering in networking and IO operations, ensuring data is processed in the order it arrives.