# Queue Data Structure: A Comprehensive Guide

## Table of Contents
1. [What is a Queue?](#what-is-a-queue)
2. [How Does a Queue Work?](#how-does-a-queue-work)
3. [Queue Operations](#queue-operations)
4. [Implementation of Queue](#implementation-of-queue)
   - [Java Implementation](#java-implementation)
   - [Python Implementation](#python-implementation)
5. [Problem-Solving with Queues](#problem-solving-with-queues)
   - [Remove Odd Elements](#remove-odd-elements)
   - [Remove Odd Elements In-Place](#remove-odd-elements-in-place)
6. [Pros and Cons of Queues](#pros-and-cons-of-queues)
7. [Time and Space Complexity](#time-and-space-complexity)
8. [Applications of Queues](#applications-of-queues)
9. [Summary](#summary)

---

## What is a Queue?

A **Queue** is a linear data structure that follows the **First-In-First-Out (FIFO)** principle. This means that the first element added to the queue will be the first one to be removed. Think of it like a line of people waiting for a bus—the first person in line gets on the bus first.

---

## How Does a Queue Work?

A queue has two primary operations:
1. **Enqueue**: Adds an element to the rear (end) of the queue.
2. **Dequeue**: Removes and returns the element from the front (start) of the queue.

Additionally, queues often support:
- **Peek**: Returns the element at the front without removing it.
- **isEmpty**: Checks if the queue is empty.

---

## Queue Operations

### 1. **Enqueue**
- **Purpose**: Adds an element to the rear of the queue.
- **How it works**:
  - Create a new node with the given value.
  - If the queue is empty, set both `front` and `rear` to the new node.
  - Otherwise, link the new node to the current `rear` and update `rear` to the new node.

### 2. **Dequeue**
- **Purpose**: Removes and returns the element from the front of the queue.
- **How it works**:
  - If the queue is empty, return `null` (or `None` in Python).
  - Store the value of the front node.
  - Move the `front` pointer to the next node.
  - If the queue becomes empty after dequeue, set `rear` to `null`.

### 3. **Peek**
- **Purpose**: Returns the element at the front of the queue without removing it.
- **How it works**:
  - If the queue is empty, return `null`.
  - Otherwise, return the value of the `front` node.

### 4. **isEmpty**
- **Purpose**: Checks if the queue is empty.
- **How it works**:
  - Return `true` if `front` is `null`, otherwise `false`.

---

## Implementation of Queue

### Java Implementation

```java
class Node {
    Integer elem; // The data stored in the node
    Node next;    // Reference to the next node in the list

    Node(Integer val) {
        this.elem = val;
    }
}

class LinkedListQueue {
    private Node front; // Reference to the front of the queue
    private Node rear;  // Reference to the rear of the queue

    public void enqueue(Integer val) {
        Node newNode = new Node(val);
        if (this.rear == null) { // If the queue is empty
            this.front = newNode;
            this.rear = newNode;
            return;
        }
        this.rear.next = newNode; // Link the new node to the rear
        this.rear = newNode;      // Update the rear pointer
    }

    public Integer dequeue() {
        if (isEmpty()) { // If the queue is empty
            return null;
        }
        Integer tempVal = this.front.elem; // Store the value to be returned
        this.front = this.front.next;      // Move the front pointer
        if (this.front == null) {          // If the queue is now empty
            this.rear = null;              // Update the rear pointer
        }
        return tempVal; // Return the dequeued value
    }

    public Integer peek() {
        if (isEmpty()) { // If the queue is empty
            return null;
        }
        return this.front.elem; // Return the front element
    }

    public boolean isEmpty() {
        return this.front == null; // Check if the queue is empty
    }
}
```

### Python Implementation

```python
class Node:
    def __init__(self, val):
        self.elem = val  # Value stored in the node
        self.next = None  # Pointer to the next node


class LinkedListQueue:
    def __init__(self):
        self.__front = None  # Front of the queue (private)
        self.__rear = None  # Rear of the queue (private)

    def enqueue(self, val):
        """Add an element to the rear of the queue."""
        newNode = Node(val)
        if self.__rear is None:  # If the queue is empty
            self.__front = newNode
            self.__rear = newNode
            return
        self.__rear.next = newNode  # Link the new node to the rear
        self.__rear = newNode  # Update the rear pointer

    def dequeue(self):
        """Remove and return the element from the front of the queue."""
        if self.isEmpty():
            return None  # Queue is empty
        tempVal = self.__front.elem  # Store the value to be returned
        self.__front = self.__front.next  # Move the front pointer
        if self.__front is None:  # If the queue is now empty
            self.__rear = None  # Update the rear pointer
        return tempVal  # Return the dequeued value

    def isEmpty(self):
        """Check if the queue is empty."""
        return self.__rear is None  # Queue is empty if rear is None

    def peek(self):
        """Return the element at the front of the queue without removing it."""
        if self.isEmpty():
            return None  # Queue is empty
        return self.__front.elem  # Return the front element
```

---

## Problem-Solving with Queues

### Remove Odd Elements

#### Purpose:
Remove all odd elements from a queue and return a new queue containing only even elements.

#### Implementation:
- **Java**:
  ```java
  public static LinkedListQueue removeOdd(LinkedListQueue givenQueue) {
      if (givenQueue.isEmpty()) {
          return null;
      }
      LinkedListQueue q2 = new LinkedListQueue();
      while (!givenQueue.isEmpty()) {
          int val = givenQueue.dequeue();
          if (val % 2 == 0) {
              q2.enqueue(val);
          }
      }
      return q2;
  }
  ```

- **Python**:
  ```python
  def removeOdd(givenQ):
      q2 = LinkedListQueue()
      while not givenQ.isEmpty():
          val = givenQ.dequeue()
          if val % 2 == 0:  # Check if the value is even
              q2.enqueue(val)
      return q2
  ```

### Remove Odd Elements In-Place

#### Purpose:
Remove all odd elements from the given queue without creating a new queue.

#### Implementation:
- **Java**:
  ```java
  public static void removeOddInGivenQ(LinkedListQueue givenQueue) {
      if (givenQueue.isEmpty()) {
          return;
      }
      givenQueue.enqueue(null);  // Use null as a marker
      Integer tempVal = givenQueue.dequeue();
      while (tempVal != null) {
          if (tempVal % 2 == 0) {
              givenQueue.enqueue(tempVal);
          }
          tempVal = givenQueue.dequeue();
      }
  }
  ```

- **Python**:
  ```python
  def removeOddInGivenQ(givenQ):
      givenQ.enqueue(None)  # Marker to indicate the end of the queue
      tempVal = givenQ.dequeue()
      while tempVal is not None:
          if tempVal % 2 == 0:  # Check if the value is even
              givenQ.enqueue(tempVal)  # Re-enqueue even values
          tempVal = givenQ.dequeue()
  ```

---

## Pros and Cons of Queues

### Pros:
1. **FIFO Principle**: Ensures fair processing of elements.
2. **Dynamic Size**: Can grow or shrink as needed.
3. **Efficient Operations**: Enqueue and dequeue operations are O(1) in a well-implemented queue.

### Cons:
1. **Limited Access**: Only the front and rear elements are accessible.
2. **Memory Overhead**: Requires additional memory for pointers in linked list implementations.

---

## Time and Space Complexity

| Operation      | Time Complexity | Space Complexity |
|----------------|-----------------|------------------|
| Enqueue        | O(1)            | O(1)             |
| Dequeue        | O(1)            | O(1)             |
| Peek           | O(1)            | O(1)             |
| isEmpty        | O(1)            | O(1)             |
| Remove Odd     | O(n)            | O(n)             |
| Remove Odd In-Place | O(n)      | O(1)             |

---

## Applications of Queues

1. **Task Scheduling**: Operating systems use queues to manage processes.
2. **Breadth-First Search (BFS)**: Queues are used in graph traversal algorithms.
3. **Printers**: Print jobs are managed using queues.
4. **Call Centers**: Incoming calls are handled in a queue-based system.

---

## Summary

A queue is a simple yet powerful data structure that follows the FIFO principle. It is widely used in various real-world applications and algorithms. This guide provides a detailed explanation of queue operations, implementations in Java and Python, and problem-solving techniques. Understanding queues is essential for mastering data structures and algorithms.

---