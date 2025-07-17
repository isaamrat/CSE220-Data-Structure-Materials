---
# [Practice Problems](#practice-problems)
---

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

---
# Practice Problems
 ## Question 1: Employee ID Hash Table with Forward Chaining

 In this task, you are asked to implement a **HashTable** class that stores key-value pairs, where the key is a **string (representing an employee ID)** and the value is a **string (representing the department name)**. The class should include a **hash_function** that computes the hash index based on the sum of ASCII values of each character in the key, then multiply each ASCII value by its position index (starting from 1) and finally sum these weighted values and take the modulus with the size of the hash table. The **insert()** method should insert a new key-value pair or update the value if the key already exists, using **forward chaining** to handle collisions. **If the key already exists, its value should be updated.** You are not allowed to use any built-in functions except len(). Assume the display method is already implemented.

 ### Sample Input:
 ```
 ht = HashTable(4)
 ht.insert("E123", "HR")
 ht.insert("BA", "Finance")
 ht.insert("XY", "Engineering")
 ht.insert("YX", "Marketing")
 print("\nHash table after insertions with collisions:")
 ht.display()
 ht.insert("E123", "Admin")
 print("\nHash table after update:")
 ht.display()
 ```

 ### Sample Output:
 ```
 Hash table after insertions with collisions:
 Index 0: (BA: Finance) -> None
 Index 1: (E123: HR) -> (YX: Marketing) -> None
 Index 2: (XY: Engineering) -> None
 Index 3: None

 Hash table after update:
 Index 0: (BA: Finance) -> None
 Index 1: (E123: Admin) -> (YX: Marketing) -> None
 Index 2: (XY: Engineering) -> None
 Index 3: None
 ```

 ### Explanation:
 For E123:
 ASCII values: 'E' = 69, '1' = 49, '2' = 50, '3' = 51.
 Weighted sum: (1 × 69) + (2 × 49) + (3 × 50) + (4 × 51) = 69 + 98 + 150 + 204 = 521.
 Index: 521 % 4 = 1.

 For BA:
 ASCII values: 'B' = 66, 'A' = 65.
 Weighted sum: (1 × 66) + (2 × 65) = 132.
 Index: 132 % 4 = 0.

 ---

 ## Question 2: Student Records Hash Table with Forward Chaining

 You are tasked with implementing a **hash table** that stores student records. Each record contains **a student name (a string) and a student ID (an integer)**. You will implement a hash table that uses **forward chaining** (a linked list) to handle collisions. Implement the following methods:

 **Hash Function**: You are given a string representing the student name. You need to calculate a hash index for this string using the following rules: Take the sum of the ASCII values of the characters in the string. If the sum is odd, return the sum modulo the size of the hash table. If the sum is even, return the sum divided by 2, modulo the size of the hash table.

 **Insert**: Implement the insert() method that takes a student name (string) and student ID (integer) and stores them in the hash table. If a student in the same index already exists in the hash table (i.e., there is a collision), use forward chaining (linked list) to store multiple student records at the same hash index. **Note**: If the key-value pair already exists, you will print an error message saying "Student already exists" and discard the key-value pair.

 **Search**: Implement the search() method that takes a student name (string) and returns the corresponding student ID (integer). If not found, then return None. No built-in function except len(). Assume the display method and Node class are already implemented.

 ### Sample Input:
 ```
 ht = HashTable(5)
 ht.insert("Alice", 123456)
 ht.insert("Bob", 135927)
 ht.insert("Charlie", 348247)
 ht.insert("David", 124382)
 print("\nHash table after insertions:")
 ht.display()
 ht.insert("Alice", 123456)
 ht.search("David")
 ```

 ### Sample Output:
 ```
 Hash table after insertions:
 Index 0: ("Bob", 135927)
 Index 1: None
 Index 2: None
 Index 3: ("Charlie", 348247)
 Index 4: ("Alice", 123456) -> ("David", 124382)

 Student already exists
 ID of David is 124382
 ```

 ### Explanation:
 For 'Alice', hash function calculation, sum of ASCII values = 65 + 108 + 105 + 99 + 101 = 478. Since 478 is even, the hash index = 478 / 2 % 5 = 4.

 For 'Bob', sum of ASCII values = 66 + 111 + 98 = 275. Since 275 is odd, the hash index = 275 % 5 = 0.

 When we try to insert ("Alice", 123456) again, since the (key, value) pair already exists, an error message is printed.

 David is found at index 4 and his ID returned.

 ---

 ## Question 3: Employee ID Hash Table with Addition-Based Hashing

 In this task, you are asked to implement a **HashTable** class that stores key-value pairs, where the key is a **string (representing an employee ID)** and the value is a **string (representing the department name)**. The class should include a **hash_function** that computes the hash index based on the sum of ASCII values of each character in the key, sum each ASCII value by its position index (starting from 1) and finally sum these weighted values and take the modulus with the size of the hash table. The **insert()** method should insert a new key-value pair or update the value if the key already exists, using **forward chaining** to handle collisions. **If the key already exists, its value should be updated.** You are not allowed to use any built-in functions except len(). Assume the display method is already implemented.

 ### Sample Input:
 ```
 ht = HashTable(4)
 ht.insert("E123", "HR")
 ht.insert("BA", "Finance")
 ht.insert("XY", "Engineering")
 ht.insert("YX", "Marketing")
 print("\nHash table after insertions with collisions:")
 ht.display()
 ht.insert("E123", "Admin")
 print("\nHash table after update:")
 ht.display()
 ```

 ### Sample Output:
 ```
 Hash table after insertions with collisions:
 Index 0: (XY: Engineering) -> (YX: Marketing) -> None
 Index 1: (E123: HR) -> None
 Index 2: (BA: Finance) -> None
 Index 3: None

 Hash table after update:
 Index 0: (XY: Engineering) -> (YX: Marketing) -> None
 Index 1: (E123: Admin) -> None
 Index 2: (BA: Finance) -> None
 Index 3: None
 ```

 ### Explanation:
 For E123:
 ASCII values: 'E' = 69, '1' = 49, '2' = 50, '3' = 51.
 Weighted sum: (1 + 69) + (2 + 49) + (3 + 50) + (4 + 51) = 70 + 51 + 53 + 55 = 229.
 Index: 229 % 4 = 1.

 For BA:
 ASCII values: 'B' = 66, 'A' = 65.
 Weighted sum: (1 + 66) + (2 + 65) = 134.
 Index: 134 % 4 = 2.

 ---

 ## Question 4: Student Records with Search and Delete

 You are tasked with implementing a **hash table** that stores student records. Each record contains **a student name (a string) and a student ID (an integer)**. You will implement a hash table that uses **forward chaining** (a linked list) to handle collisions. Implement the following methods:

 **Hash Function**: You are given a string representing the student name. You need to calculate a hash index for this string using the following rules: Take the sum of the ASCII values of the characters in the string. If the sum is odd, return the sum modulo the size of the hash table. If the sum is even, return the sum divided by 2, modulo the size of the hash table.

 **Search**: Implement the search() method that takes a student name (string) and returns the corresponding student ID (integer). If the student is found in the hash table, return the student ID. If the student is not found, return None.

 **Delete**: Implement the delete() method that takes a student name (string) and removes the corresponding record from the hash table. If the student is not found, return None.

 No built-in function except len(). Assume the display method and Node class are already implemented.

 ### Sample Input:
 ```
 ht = HashTable(5)
 // assume the insert method is called multiple times and some entries are already in the hashtable
 print('Hash table after insertions:\n')
 ht.display()
 ht.search("David")
 ht.delete("Alice")
 print('Hash table after deletions:\n')
 ht.display()
 ```

 ### Sample Output:
 ```
 Hash table after insertions:
 Index 0: ("Bob", 135927)
 Index 1: None
 Index 2: None
 Index 3: ("Charlie", 348247)
 Index 4: ("Alice", 123456) -> ("David", 124382)

 ID of David is 124382

 Hash table after deletions:
 Index 0: ("Bob", 135927)
 Index 1: None
 Index 2: None
 Index 3: ("Charlie", 348247)
 Index 4: ("David", 124382)
 ```

 ### Explanation:
 For 'Alice', hash function calculation, A → 65, l → 108, i → 105, c → 99, e → 101. The sum of ASCII values = 65 + 108 + 105 + 99 + 101 = 478. Since 478 is even, the hash index = 478 / 2 % 5 = 4.

 For 'Bob', B → 66, o → 111, b → 98. The sum of ASCII values = 66 + 111 + 98 = 275. Since 275 is odd, the hash index = 275 % 5 = 0.

 David is found at index 4 and his ID returned.

 ---

 ## Question 5: Package Tracking Hash Table

 In this task, you are asked to implement a **HashTable** class that stores key-value pairs, where the key is a **string (representing a package ID)** and the value is a **string (representing the package status)**. The class should include a **hash_function** that computes the hash index based on the sum of ASCII values of the first three characters of the key, adding 'X' if the key is shorter than three characters. The **insert()** method should insert a new key-value pair or update the value if the key already exists, using **forward chaining** to handle collisions. **If the key already exists, its value should be updated.**

 You are not allowed to use any built-in functions except len(). Assume the display method is already implemented.

 ### Sample Input:
 ```
 ht = HashTable(10)
 ht.insert("PKG123", "In Transit")
 ht.insert("AB", "Delivered")
 ht.insert("PKG456", "Returned")
 print("\nHash table after insertions:")
 ht.display()
 ht.insert("PKG123", "Delivered")  # Updating PKG123 status
 print("\nHash table after updates:")
 ht.display()
 ```

 ### Sample Output:
 ```
 Hash table after insertions:
 Index 6: PKG123 (In Transit)
 PKG456 (Returned)
 Index 9: AB (Delivered)

 Hash table after updates:
 Index 6: PKG123 (Delivered)
 PKG456 (Returned)
 Index 9: AB (Delivered)
 ```

 ### Explanation:
 For PKG123, Hash function calculation, 'P' = 80, 'K' = 75, 'G' = 71. Total sum = 80 + 75 + 71 = 226. So, index = 226 % 10 = 6.

 For AB 'A' = 65, 'B' = 66. Since the key is less than 3 characters, the ASCII value of 'X' (88) is added to the sum. Total sum = 65 + 66 + 88 = 219. So, index = 219 % 10 = 9.

 When we try to insert PKG123 again, since the key already exists its value will be updated from In Transit to Delivered.

 ---

 ## Question 6: Student Grade Hash Table (Version 1)

 You are asked to implement a HashTable class that stores key-value pairs, where the key is a string (representing a student ID) and the value is an integer (representing the student's grade).

 The class should include a hash_function that calculates the hash index by summing the ASCII values of the **first two characters** of the key. If the key is only one character, the ASCII value of 'Y' (89) should be added as the second character.

 The insert() method should add a new key-value pair or update the value if the key already exists. Use **forward chaining** to handle collisions.

 You are **not allowed** to use any built-in functions except len(). Assume the display() method is already implemented to show the hash table.

 ### Sample Input:
 ```
 ht = HashTable(7)
 ht.insert("S1", 85)
 ht.insert("A", 90)
 ht.insert("S2", 78)
 print("\nHash table after insertions:")
 ht.display()
 ht.insert("S1", 88)  # Updating S1 grade
 print("\nHash table after update:")
 ht.display()
 ```

 ### Sample Output:
 ```
 Hash table after insertions:
 Index 0: A (90) -> S2 (78) -> None
 Index 1: None
 Index 2: None
 Index 3: None
 Index 4: None
 Index 5: None
 Index 6: S1 (85) -> None

 Hash table after update:
 Index 0: A (90) -> S2 (78) -> None
 Index 1: None
 Index 2: None
 Index 3: None
 Index 4: None
 Index 5: None
 Index 6: S1 (88) -> None
 ```

 ### Explanation:
 For S1: 'S' = 83, '1' = 49. Total = 83 + 49 = 132. Index = 132 % 7 = 6.

 For A: 'A' = 65, 'Y' = 89. Total = 65 + 89 = 154. Index = 154 % 7 = 0.

 For S2: 'S' = 83, '2' = 50. Total = 83 + 50 = 133. Index = 133 % 7 = 0.

 ---

 ## Question 7: First Repeating Element with Smallest Index Difference

 You are given an array of positive integers containing n elements. Your task is to find the first repeating element in the array using a hash-based approach. A repeating element is one that appears more than once in the array, and among all repeating elements, you must return the one that repeats at the **smallest index difference**. If no element repeats, return -1.

 Use a hashmap to efficiently solve the problem by storing and checking the elements as you traverse the array.

 ### Sample Input 1:
 ```
 6
 10 5 3 4 3 5
 ```

 ### Sample Output 1:
 ```
 3
 ```

 ### Explanation:
 Both 3 and 5 repeat, but 3 repeats with a smaller index difference (indices 2 and 4).
 The difference of indexes for 3 is 2 (4-2 = 2) and 5 is 4 (5-1 = 4).

 ### Sample Input 2:
 ```
 5
 1 2 3 4 5
 ```

 ### Sample Output 2:
 ```
 -1
 ```

 ### Explanation:
 No elements repeat, so the output is -1.

 ### Sample Input 3:
 ```
 6
 1 1 3 4 3 3
 ```

 ### Sample Output 3:
 ```
 1
 ```

 ### Explanation:
 Both 1 and 3 repeat, but 1 repeats with a smaller index difference indices (0 and 1).
 3 appears at index no 2 and first repeat occurs at index no 4. Since we are taking the first repeating element, we will not consider the very last 3 at index no 5.
 So the difference of indexes for 1 is 1 (1-0 = 1) and 3 is 2 (4-2 = 2).

 ---

 ## Question 8: Product Price Hash Table

 In this task, you are asked to implement a **HashTable** class that stores key-value pairs, where the key is **a string (representing a product ID)** and the value **is a float (representing the product's price)**. The class should include a **hash_function** that computes the hash index based on the sum of the ASCII values of the first three characters of the key. If the key is shorter than three characters, it should add the ASCII value of '0' (48) to make the key length three. The **insert()** method should insert a new key-value pair into the hash table. If a collision occurs, the method will use forward chaining (linked lists) to store multiple entries at the same index. If the key already exists, it should update the value by adding the new price to the previous price.

 You are not allowed to use any built-in functions except len(). Assume the display method is already implemented.

 ### Sample Input:
 ```
 ht = HashTable(10)
 ht.insert("P123", 19.99)
 ht.insert("AB", 15.50)
 ht.insert("P456", 25.75)
 print("\nHash table after insertions:")
 ht.display()
 ht.insert("P123", 21.99)  # Updating price for P123 by adding the new price
 print("\nHash table after update:")
 ht.display()
 ```

 ### Sample Output:
 ```
 Hash table after insertions:
 Index 5: P456 (25.75)
 Index 9: P123 (19.99)
 A45 (15.50)

 Hash table after updates:
 Index 5: P456 (25.75)
 Index 9: P123 (41.98)  # 19.99 + 21.99
 Index 9: A45 (15.50)
 ```

 ### Explanation:
 For P123, Hash function calculation, 'P' = 80, '1' = 49, '2' = 50. Total sum = 80 + 49 + 50 = 179. So, index = 179 % 10 = 9.

 For AB 'A' = 65, 'B' = 66. Since the key is less than 3 characters, the ASCII value of '0' (48) is added to the sum. Total sum = 65 + 66 + 48 = 179. So, index = 179 % 10 = 9.

 When we try to insert P123 again, since the key already exists its value will be updated by adding 19.99 with 21.99.

 ---

 ## Question 9: Student Grade Hash Table (Version 2)

 You are asked to implement a HashTable class that stores key-value pairs, where the key is a string (representing a student ID) and the value is an integer (representing the student's grade).

 The class should include a hash_function that calculates the hash index by summing the ASCII values of the **first two characters** of the key. If the key is only one character, the ASCII value of 'Z' (90) should be added as the second character.

 The insert() method should add a new key-value pair or update the value if the key already exists. Use **forward chaining** to handle collisions.

 You are **not allowed** to use any built-in functions except len(). Assume the display() method is already implemented to show the hash table.

 ### Sample Input:
 ```
 ht = HashTable(7)
 ht.insert("S1", 85)
 ht.insert("A", 90)
 ht.insert("S2", 78)
 print("\nHash table after insertions:")
 ht.display()
 ht.insert("S1", 88)  # Updating S1 grade
 print("\nHash table after update:")
 ht.display()
 ```

 ### Sample Output:
 ```
 Hash table after insertions:
 Index 0: S2 (78) -> None
 Index 1: A (90) -> None
 Index 2: None
 Index 3: None
 Index 4: None
 Index 5: None
 Index 6: S1 (85) -> None

 Hash table after update:
 Index 0: S2 (78) -> None
 Index 1: A (90) -> None
 Index 2: None
 Index 3: None
 Index 4: None
 Index 5: None
 Index 6: S1 (88) -> None
 ```

 ### Explanation:
 For S1: 'S' = 83, '1' = 49. Total = 83 + 49 = 132. Index = 132 % 7 = 6.

 For A: 'A' = 65, 'Z' = 90. Total = 65 + 90 = 155. Index = 155 % 7 = 1.

 For S2: 'S' = 83, '2' = 50. Total = 83 + 50 = 133. Index = 133 % 7 = 0.

 ---

 ## Question 10: First Repeating Element with Largest Index Difference

 You are given an array of positive integers containing n elements. Your task is to find the first repeating element in the array using a hash-based approach. A repeating element is one that appears more than once in the array, and among all repeating elements, you must return the one that repeats at the **largest index difference**. If no element repeats, return -1.

 Use a hashmap to efficiently solve the problem by storing and checking the elements as you traverse the array.

 ### Sample Input 1:
 ```
 6
 10 5 3 4 3 5
 ```

 ### Sample Output 1:
 ```
 5
 ```

 ### Explanation:
 Both 3 and 5 repeat, but 5 repeats with a larger index difference (indices 1 and 5).
 The difference of indexes for 3 is 2 (4-2 = 2) and 5 is 4 (5-1 = 4).

 ### Sample Input 2:
 ```
 5
 1 2 3 4 5
 ```

 ### Sample Output 2:
 ```
 -1
 ```

 ### Explanation:
 No elements repeat, so the output is -1.

 ### Sample Input 3:
 ```
 6
 1 1 3 4 3 3
 ```

 ### Sample Output 3:
 ```
 3
 ```

 ### Explanation:
 Both 1 and 3 repeat, but 3 repeats with a higher index difference indices (2 and 4).
 3 appears at index no 2 and first repeat occurs at index no 4. Since we are taking the first repeating element, we will not consider the very last 3 at index no 5.
 So the difference of indexes for 1 is 1 (1-0 = 1) and 3 is 2 (4-2 = 2).
