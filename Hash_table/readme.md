# Hash Table Implementation

## Overview

This repository contains both Java and Python implementations of a hash table data structure that uses chaining (linked lists) to handle collisions. The hash table stores key-value pairs where keys are integers and values are strings. These implementations demonstrate fundamental hash table operations like insertion, searching, removal, and display.

## Table of Contents

- [Java Implementation](#java-implementation)
  - [Classes](#java-classes)
  - [Technical Details](#java-technical-details)
- [Python Implementation](#python-implementation)
  - [Classes](#python-classes)
  - [Technical Details](#python-technical-details)
- [Collision Handling](#collision-handling)
- [Performance Considerations](#performance-considerations)
- [Example Output](#example-output)

## Java Implementation

### Java Classes

The Java implementation consists of three classes:

1. `Node`: Represents individual elements in the hash table
2. `HashTable`: The main hash table implementation with core operations
3. `hash_table`: Contains the `main` method to demonstrate usage

### Java Technical Details

#### Node Class

```java
class Node {
    int key;
    String val;
    Node next;

    Node(int id, String name) {
        this.key = id;
        this.val = name;
        this.next = null;
    }
}
```

The `Node` class is responsible for:

- Storing a key (`int`) and value (`String`) pair
- Maintaining a reference to the next node in case of collisions
- Initializing a new node with the provided key-value pair through its constructor

#### HashTable Class

```java
class HashTable {
    Node[] tableArr;
    int size;
    
    // Methods: hashFunction, insert, search, remove, printTable
}
```

The `HashTable` class implements the core functionality:

##### Constructor

```java
HashTable(int size) {
    tableArr = new Node[size];
    this.size = size;
}
```

- Initializes a hash table with the specified size
- Creates an array of `Node` references with the given size

##### Hash Function

```java
public int hashFunction(int id) {
    return id % this.size;
}
```

- Determines the index where a key will be stored in the hash table
- Uses the modulo operation to map keys to array indices within the table size
- This simple hash function ensures that all keys map to a valid index in the range [0, size-1]

##### Insert Operation

```java
public void insert(int id, String name) {
    int hashIndx = hashFunction(id);
    Node newNode = new Node(id, name);

    if (this.tableArr[hashIndx] == null) {
        this.tableArr[hashIndx] = newNode;
    } else {
        Node temp = this.tableArr[hashIndx];
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
}
```

- Creates a new node with the provided key-value pair
- Calculates the appropriate index using the hash function
- If no collision occurs (the index is empty), inserts the node directly
- In case of collision, traverses to the end of the linked list and adds the new node
- Time complexity: O(1) in best case, O(n) in worst case (when all keys hash to the same index)

##### Search Operation

```java
public boolean search(int id) {
    int hashIndx = hashFunction(id);
    Node temp = this.tableArr[hashIndx];

    while (temp != null) {
        if (temp.key == id) {
            return true;
        }
        temp = temp.next;
    }
    return false;
}
```

- Calculates the hash index for the given key
- Traverses the linked list at that index to find a node with the matching key
- Returns `true` if found, `false` otherwise
- Time complexity: O(1) in best case, O(n) in worst case (when all keys hash to the same index)

##### Remove Operation

```java
public void remove(int id) {
    int hashIndx = hashFunction(id);
    Node temp = this.tableArr[hashIndx];

    if (temp == null)
        return;

    if (temp.key == id) {
        this.tableArr[hashIndx] = temp.next;
        return;
    }

    while (temp.next != null) {
        if (temp.next.key == id) {
            temp.next = temp.next.next;
            return;
        }
        temp = temp.next;
    }
}
```

- Calculates the hash index for the given key
- Handles special cases:
  - If the linked list at the index is empty, returns without action
  - If the target node is the first in the linked list, updates the head pointer
- Otherwise, traverses the linked list to find the node before the target
- When found, removes the target node by updating the next pointer of the preceding node
- Time complexity: O(1) in best case, O(n) in worst case

##### Print Table Operation

```java
public void printTable() {
    System.out.println("=".repeat(50));

    for (int i = 0; i < tableArr.length; i++) {
        System.out.print(i + " : ");
        Node temp = tableArr[i];
        while (temp != null) {
            System.out.print("(" + temp.key + " , " + temp.val + ") -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
    
    System.out.println("=".repeat(50));
}
```

- Displays the entire hash table for debugging and visualization
- Prints the index followed by all key-value pairs at that index
- Shows the linked list structure with the arrow notation
- Each linked list ends with "null" to indicate the end of the chain
- Visual separator lines are used for better readability

#### hash_table Class

This class contains the `main` method that demonstrates the usage of the hash table:

```java
public class hash_table {
    public static void main(String[] args) {
        HashTable h1 = new HashTable(5);

        // Insert elements
        h1.insert(101, "Bob");
        h1.insert(102, "Steve");
        h1.insert(111, "Paige");
        h1.insert(106, "Anna");
        h1.insert(201, "Chris");

        // Search tests
        System.out.println("Search 101: " + h1.search(101));
        System.out.println("Search 103: " + h1.search(103));

        // Print table before removal
        System.out.println("Hash Table before deletion:");
        h1.printTable();

        // Remove elements
        h1.remove(101);
        h1.remove(103);

        // Print table after removal
        System.out.println("Hash Table after deletion:");
        h1.printTable();
    }
}
```

## Python Implementation

### Python Classes

The Python implementation consists of two classes:

1. `Node`: Represents individual elements in the hash table
2. `HashTable`: The main hash table implementation with core operations

### Python Technical Details

#### Node Class

```python
class Node:
    def __init__(self, id, name):
        self.key = id    # Store the key (ID)
        self.val = name  # Store the value (name)
        self.next = None # Pointer to next node for handling collisions
```

The Python `Node` class is similar to its Java counterpart:
- Takes an ID and name as parameters during initialization
- Sets the `next` pointer to `None` by default
- Used to create a linked list structure for handling collisions

#### HashTable Class

```python
class HashTable:
    def __init__(self, size):
        self.size = size  # Size of the hash table
        self.tableArr = np.empty(size, dtype=object)  # Initialize array with None values
```

##### Constructor

- Initializes the hash table with a specified size
- Uses NumPy's `empty` function to create an array with `None` values
- The `dtype=object` parameter allows the array to store any object type (like `Node` instances)

##### Hash Function

```python
def hashFunction(self, key):
    return key % self.size  # Simple modulo-based hash function
```

- Uses the same modulo-based hash function as the Java implementation
- Maps any integer key to an array index within the range [0, size-1]

##### Insert Operation

```python
def insert(self, id, name):
    hashIndx = self.hashFunction(id)
    newNode = Node(id, name)

    # If no collision, insert directly
    if self.tableArr[hashIndx] is None:
        self.tableArr[hashIndx] = newNode
    else:
        # Handle collision using chaining (linked list)
        temp = self.tableArr[hashIndx]
        while temp.next is not None:
            temp = temp.next
        temp.next = newNode
```

- Creates a new node with the provided key-value pair
- Calculates the index using the hash function
- Directly inserts the node if there's no collision
- In case of collision, adds the new node at the end of the linked list
- The implementation is nearly identical to the Java version, just with Python syntax

##### Search Operation

```python
def search(self, id):
    hashIndx = self.hashFunction(id)
    temp = self.tableArr[hashIndx]
    
    while temp is not None:
        if temp.key == id:
            return hashIndx  # Return index if key is found
        temp = temp.next
    return -1  # Key not found
```

- Calculates the hash index for the given key
- Traverses the linked list at that index to find a node with the matching key
- *Note a key difference from the Java version*: Returns the index where the key was found instead of a boolean
- Returns -1 if the key is not found

##### Remove Operation

```python
def remove(self, id):
    hashIndx = self.hashFunction(id)
    temp = self.tableArr[hashIndx]
    
    if temp is None: # If there's no node available to remove
        return
    
    if temp.key == id: # If the node to be removed is the first node
        self.tableArr[hashIndx] = temp.next
        return
    
    # Traverse the linked list to find and remove the node
    while temp.next is not None:
        if temp.next.key == id:
            temp.next = temp.next.next
            return
        temp = temp.next
```

- Follows the same algorithm as the Java implementation
- Handles the same edge cases:
  - Empty bucket
  - Node to remove is the first in the list
- Traverses the linked list to find and remove nodes further down the chain

##### Print Table Operation

```python
def printTable(self):
    print('='*55)
    for i in range(len(self.tableArr)):
        print(i, end=' : ')
        temp = self.tableArr[i]
        while temp is not None:
            print(f'({temp.key}, {temp.val}) -> ', end='')
            temp = temp.next
        print('None')
    print('='*55)
```

- Displays the hash table similar to the Java version
- Uses Python's f-strings for formatting output
- Maintains the same arrow notation for visualizing linked lists

#### Main Execution Block

```python
if __name__ == "__main__":
    hashTable1 = HashTable(5)
    
    # Insert elements
    hashTable1.insert(101, 'Bob')
    hashTable1.insert(102, 'Ben')
    hashTable1.insert(111, 'Stewie')
    hashTable1.insert(106, 'Anna')  # Testing collision (106 % 5 == 1, same as 101)
    hashTable1.insert(201, 'Chris') # Another collision case
    
    # Print table before removal
    print("Hash Table before deletion:")
    hashTable1.printTable()
    
    # Search tests
    print("Search 101:", hashTable1.search(101))  # Expected: valid index
    print("Search 103:", hashTable1.search(103))  # Expected: -1 (not found)
    
    # Remove elements
    hashTable1.remove(101) # Remove an existing key
    hashTable1.remove(103) # Attempt to remove a non-existing key
    
    # Print table after removal
    print("Hash Table after deletion:")
    hashTable1.printTable()
```

- Similar test cases to the Java implementation
- Demonstrates the same operations: insert, search, remove, and print
- Tests collision handling with the same pattern of key values

## Collision Handling

Both implementations use chaining to handle collisions:

- When multiple keys hash to the same index, they form a linked list
- New elements are added to the end of the linked list
- Searches and removals require traversing the linked list to find the target key

## Performance Considerations

- Time complexity for operations in both implementations:
  - Insert: O(1) average case, O(n) worst case
  - Search: O(1) average case, O(n) worst case
  - Remove: O(1) average case, O(n) worst case
- Space complexity: O(n) where n is the number of key-value pairs

The performance heavily depends on the quality of the hash function and the load factor (ratio of elements to table size). A good hash function should distribute keys uniformly across the table to minimize collisions.

## Differences Between Implementations

1. **Array Initialization**: 
   - Java uses a `Node[]` array initialized with `null` values
   - Python uses NumPy's `empty` function with `dtype=object`

2. **Search Return Value**:
   - Java returns a boolean (`true` if found, `false` if not)
   - Python returns an integer (the hash index if found, `-1` if not)

3. **Syntax Differences**:
   - Java uses `null` vs Python's `None`
   - Java uses dot notation for method calls vs Python's method calls
   - String formatting differs between languages

4. **Library Usage**:
   - Python implementation uses NumPy for array creation
   - Java implementation uses standard Java arrays



## Example Output

### Java Output

```
Search 101: true
Search 103: false
Hash Table before deletion:
==================================================
0 : null
1 : (101 , Bob) -> (106 , Anna) -> null
2 : (102 , Steve) -> null
3 : null
4 : (111 , Paige) -> (201 , Chris) -> null
==================================================
Hash Table after deletion:
==================================================
0 : null
1 : (106 , Anna) -> null
2 : (102 , Steve) -> null
3 : null
4 : (111 , Paige) -> (201 , Chris) -> null
==================================================
```

### Python Output

```
Hash Table before deletion:
=======================================================
0 : None
1 : (101, Bob) -> (106, Anna) -> None
2 : (102, Ben) -> None
3 : None
4 : (111, Stewie) -> (201, Chris) -> None
=======================================================
Search 101: 1
Search 103: -1
Hash Table after deletion:
=======================================================
0 : None
1 : (106, Anna) -> None
2 : (102, Ben) -> None
3 : None
4 : (111, Stewie) -> (201, Chris) -> None
=======================================================
```

Notice how keys 101 and 106 both hash to index 1, and keys 111 and 201 both hash to index 4 in both implementations, demonstrating collision handling through chaining.