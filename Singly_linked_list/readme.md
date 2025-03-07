# Singly Linked List Implementation

## Introduction to Linked Lists

A linked list is a linear data structure where elements are stored in nodes, and each node points to the next node in the sequence. Unlike arrays, linked lists do not store elements in contiguous memory locations but instead use pointers or references to connect nodes together.

### Linked Lists vs Arrays

| Feature | Linked Lists | Arrays |
|---------|--------------|--------|
| Memory Allocation | Dynamic (allocated at runtime) | Static (fixed size at declaration) |
| Element Insertion/Deletion | O(1) time complexity (if position is known) | O(n) time complexity (requires shifting elements) |
| Random Access | O(n) time complexity (requires traversal) | O(1) time complexity (direct index access) |
| Memory Usage | Higher (extra space for pointers) | Lower (only data elements) |
| Memory Efficiency | More efficient with frequent insertions/deletions | More efficient for random access |
| Implementation Complexity | More complex | Simpler |
| Cache Locality | Less cache-friendly | More cache-friendly |

## Repository Overview

This repository contains implementations of a Singly Linked List data structure in both Java and Python. A singly linked list is a type of linked list where each node contains a data element and a reference to the next node in the sequence.

## Table of Contents
- [Structure Overview](#structure-overview)
- [Node Class](#node-class)
- [SinglyLinkedList Class](#singlylinkedlist-class)
  - [Constructor](#constructor)
  - [Array to List Builder](#array-to-list-builder)
  - [Print List](#print-list)
  - [Append](#append)
  - [Prepend](#prepend)
  - [List Size](#list-size)
  - [Node At](#node-at)
  - [Insert](#insert)
  - [Remove](#remove)
  - [Reverse List](#reverse-list)
- [Usage Examples](#usage-examples)
- [Time and Space Complexity Analysis](#time-and-space-complexity-analysis)
- [Applications of Linked Lists](#applications-of-linked-lists)

## Structure Overview

The implementation consists of two main classes:
1. `Node` - Represents a single node in the linked list
2. `SinglyLinkedList` - Manages the linked list operations

Both Java and Python implementations provide the same core functionality with language-specific syntax.

## Node Class

The `Node` class is the building block of the linked list and contains:

### Java Implementation
```java
class Node {
    int elem;    // Data stored in the node
    Node next;   // Reference to the next node in the linked list

    // Constructor to initialize a node with given element
    Node(int el) {
        this.elem = el;
        this.next = null;
    }
}
```

### Python Implementation
```python
class Node:
    def __init__(self, el, ne=None):
        self.elem = el    # Data stored in the node
        self.next = ne    # Reference to the next node in the linked list
```

The `Node` class stores an integer element and a reference to the next node. In Python, the next node can be optionally provided during initialization.

## SinglyLinkedList Class

The `SinglyLinkedList` class manages the linked list and provides various operations.

### Constructor

Initializes an empty linked list with the head set to null/None.

#### Java
```java
class SinglyLinkedList {
    Node head;
    // head is implicitly set to null
}
```

#### Python
```python
def __init__(self):
    self.head = None  # Initialize empty linked list
```

### Array to List Builder

Converts an array of integers into a linked list.

#### Method Details:
- Checks if the array is empty or null/None, returning early if true
- Creates the head node with the first element of the array
- Iterates through the remaining elements, creating a new node for each and linking them together

#### Java
```java
public void arrayToListBuilder(int[] arr) {
    if (arr == null || arr.length == 0) {
        return;
    }
    this.head = new Node(arr[0]);
    Node tail = this.head;
    for (int i = 1; i < arr.length; i++) {
        Node newNode = new Node(arr[i]);
        tail.next = newNode;
        tail = tail.next;
    }
}
```

#### Python
```python
def array_to_list_builder(self, arr):
    if not arr:
        return
    self.head = Node(arr[0])
    tail = self.head
    for i in range(1, len(arr)):
        newNode = Node(arr[i])
        tail.next = newNode
        tail = tail.next
```

### Print List

Prints the elements of the linked list in a readable format.

#### Method Details:
- Starts traversal from the head node
- Prints each node's element followed by an arrow symbol
- Ends with "null"/"None" to indicate the end of the list

#### Java
```java
public void printList() {
    Node temp = this.head;
    System.out.print("Linked List: ");
    while (temp != null) {
        System.out.print(temp.elem + " -> ");
        temp = temp.next;
    }
    System.out.println("null");
}
```

#### Python
```python
def print_list(self):
    temp = self.head
    while temp is not None:
        print(temp.elem, end=' -> ')
        temp = temp.next
    print("None")
```

### Append

Adds a new node with the given element to the end of the list.

#### Method Details:
- Creates a new node with the given element
- If the list is empty, sets the new node as the head
- Otherwise, traverses to the end of the list and links the last node to the new node

#### Java
```java
public void append(int el) {
    Node newNode = new Node(el);
    if (this.head == null) {
        this.head = newNode;
        return;
    }
    Node temp = this.head;
    while (temp.next != null) {
        temp = temp.next;
    }
    temp.next = newNode;
}
```

#### Python
```python
def append_list(self, newElem):
    newNode = Node(newElem)
    if not self.head:
        self.head = newNode
        return
    temp = self.head
    while temp.next is not None:
        temp = temp.next
    temp.next = newNode
```

### Prepend

Adds a new node with the given element to the beginning of the list.

#### Method Details:
- Creates a new node with the given element
- Sets the next pointer of the new node to the current head
- Updates the head to point to the new node

#### Java
```java
public void prepend(int el) {
    Node newNode = new Node(el);
    newNode.next = this.head;
    this.head = newNode;
}
```

#### Python
```python
def prepend(self, newElem):
    newNode = Node(newElem)
    newNode.next = self.head
    self.head = newNode
```

### List Size

Returns the number of nodes in the linked list.

#### Method Details:
- Initializes a counter to 0
- Traverses the list from head to tail, incrementing the counter for each node
- Returns the final count

#### Java
```java
public int listSize() {
    Node temp = this.head;
    int count = 0;
    while (temp != null) {
        temp = temp.next;
        count += 1;
    }
    return count;
}
```

#### Python
```python
def listSize(self):
    temp = self.head
    count = 0
    while temp is not None:
        temp = temp.next
        count += 1
    return count
```

### Node At

Returns the node at a specific index in the linked list.

#### Method Details:
- Checks if the index is valid (not negative)
- Traverses the list while counting nodes until it reaches the desired index
- Returns the node at that index, or null/a message if the index is out of bounds

#### Java
```java
public Node nodeAt(int indx) {
    if (indx < 0) {
        return null;
    }
    Node temp = this.head;
    int count = 0;
    while (temp != null) {
        if (count == indx) {
            return temp;
        }
        count += 1;
        temp = temp.next;
    }
    return null;
}
```

#### Python
```python
def nodeAt(self, n):
    if n < 0:
        return 'Not found'
    temp = self.head
    indx = 0
    while temp is not None:
        if indx == n:
            return temp
        indx += 1
        temp = temp.next
    return 'Not found'
```

### Insert

Inserts a new node with the given value at a specific index.

#### Method Details:
- Validates the index (must be non-negative and not greater than the list size)
- Creates a new node with the given value
- Handles two cases:
  - If inserting at the beginning (index 0), updates the head
  - Otherwise, finds the node before the insertion point, adjusts pointers to include the new node

#### Java
```java
public String insert(int indx, int val) {
    if (indx < 0 || indx > listSize()) {
        return "Invalid";
    }
    Node newNode = new Node(val);
    if (indx == 0) {
        newNode.next = this.head;
        this.head = newNode;
    } else {
        Node prev = nodeAt(indx - 1);
        if (prev == null) {
            return "Invalid";
        }
        newNode.next = prev.next;
        prev.next = newNode;
    }
    return "Successful";
}
```

#### Python
```python
def insert(self, indx, val):
    if indx < 0 or self.listSize() < indx:
        return 'Not valid'
    newNode = Node(val)
    if indx == 0:
        newNode.next = self.head
        self.head = newNode
    else:
        prev = self.nodeAt(indx - 1)
        newNode.next = prev.next
        prev.next = newNode
```

### Remove

Removes the node at a specific index from the linked list.

#### Method Details:
- Validates the index (must be non-negative and within the list bounds)
- Handles two cases:
  - If removing the head (index 0), updates the head to the second node
  - Otherwise, finds the node before the removal point, adjusts pointers to bypass the node to be removed

#### Java
```java
public String remove(int indx) {
    if (indx < 0) {
        return "Invalid";
    }
    if (indx == 0) {
        this.head = this.head.next;
    } else {
        Node prev = nodeAt(indx - 1);
        if (prev == null) {
            return "Invalid";
        }
        Node nextNode = prev.next.next;
        prev.next = nextNode;
    }
    return "Successful";
}
```

#### Python
```python
def remove(self, indx):
    if self.head is None:
        return 'Not valid'
    if indx < 0 or self.listSize() <= indx:
        return 'Not valid'
    if indx == 0:
        self.head = self.head.next
    else:
        prev = self.nodeAt(indx - 1)
        if prev.next is not None:
            prev.next = prev.next.next
```

### Reverse List

Reverses the order of nodes in the linked list.

#### Method Details:
- Initializes three pointers: previous (initially null/None), current (starting at head), and next
- Iterates through the list, for each node:
  - Saves the next node reference
  - Reverses the current node's pointer to point to the previous node
  - Moves previous and current pointers one step forward
- Updates the head to point to the last node (which becomes the first node in the reversed list)

#### Java
```java
public void reverseList() {
    Node prevNode = null;
    Node current = this.head;
    
    while (current != null) {
        Node nextNode = current.next;
        current.next = prevNode;
        prevNode = current;
        current = nextNode;
    }
    
    this.head = prevNode;
}
```

#### Python
```python
def reverseList(self):
    prevNode = None
    current = self.head
    
    while current is not None:
        nextNode = current.next
        current.next = prevNode
        prevNode = current
        current = nextNode
    
    self.head = prevNode
```

## Usage Examples

Both implementations include test cases demonstrating each functionality:

1. Creating a linked list from an array
2. Appending and prepending elements
3. Inserting elements at specific positions
4. Removing elements from specific positions
5. Finding list size and accessing elements at specific indices
6. Reversing the linked list

## Time and Space Complexity Analysis

| Operation | Time Complexity | Space Complexity |
|-----------|-----------------|------------------|
| Creation (from array) | O(n) | O(n) |
| Append | O(n) | O(1) |
| Prepend | O(1) | O(1) |
| Insert | O(n) | O(1) |
| Remove | O(n) | O(1) |
| Get Size | O(n) | O(1) |
| Access Node | O(n) | O(1) |
| Reverse | O(n) | O(1) |
| Print | O(n) | O(1) |

*Note: n represents the number of elements in the linked list*

## Applications of Linked Lists

Linked lists are beneficial in many scenarios:

1. **Dynamic Memory Management**: When you don't know the size of the data structure in advance or when it needs to grow and shrink frequently.

2. **Implementation of Other Data Structures**: 
   - Stacks and queues can be efficiently implemented using linked lists
   - Graph adjacency lists
   - Hash tables (for handling collisions)

3. **Memory Efficiency for Large Records**: When elements are large, moving pointers is more efficient than moving the complete elements.

4. **Operating System Applications**:
   - Implementation of file systems
   - Memory management (free lists)
   - Process scheduling

5. **Applications with Frequent Insertions/Deletions**:
   - Music playlists
   - Browser navigation (back/forward)
   - Text editors

6. **Sparse Matrix Representation**: Efficient storage of matrices with mostly zero values.

7. **Polynomial Manipulation**: Representing and manipulating polynomial expressions.

8. **Undo Functionality**: Implementing undo operations in applications.

### When to Choose Linked Lists Over Arrays

Linked lists are preferable when:
- The size of the collection is unknown or changes frequently
- Frequent insertions and deletions are required, especially at the beginning or middle of the list
- Random access to elements is not a primary requirement
- Memory usage needs to be optimized for dynamic collection sizes
- You need to implement data structures like stacks, queues, or graphs efficiently

While arrays excel at random access and cache locality, linked lists provide flexibility and efficiency for certain operations that make them indispensable in many programming scenarios.