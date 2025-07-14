# Practice Sheet - Doubly Linked List

## Node Class Definition
```python
class Node:
    def __init__(self, elem, next, prev):
        self.elem = elem
        self.next = next
        self.prev = prev
```

---

## Question - 01: Check Palindrome in Doubly Linked List
**Problem Statement:**  
Given a non-dummy headed doubly non-circular linked list, write a function that returns `True` if the linked list is a palindrome, otherwise `False`.

**Examples:**  
- **Input:**  
  1 ⇔ 2 ⇔ 2 ⇔ 1 ⇔ None  
  **Output:** True  
- **Input:**  
  1 ⇔ 2 ⇔ 3 ⇔ 4 ⇔ None  
  **Output:** False  

---

## Question - 02: Reverse a Doubly Linked List
**Problem Statement:**  
Given a non-dummy headed doubly non-circular linked list, reverse the list.

**Examples:**  
- **Input:**  
  10 ⇔ 20 ⇔ 30 ⇔ None  
  **Output:**  
  30 ⇔ 20 ⇔ 10 ⇔ None  
- **Input:**  
  A ⇔ B ⇔ C ⇔ None  
  **Output:**  
  C ⇔ B ⇔ A ⇔ None  

---

## Question - 03: Find the Largest Node in a Doubly Circular Linked List
**Problem Statement:**  
Given a dummy-headed doubly circular linked list, find the largest node in the list.

**Examples:**  
- **Input:**  
  dummy ⇔ 5 ⇔ 15 ⇔ 10 ⇔ dummy  
  **Output:** 15  
- **Input:**  
  dummy ⇔ -3 ⇔ -8 ⇔ -1 ⇔ dummy  
  **Output:** -1  

---

## Question - 04: Rotate Left in a Doubly Circular Linked List
**Problem Statement:**  
Given a dummy-headed doubly circular linked list, rotate it left by k nodes.

**Examples:**  
- **Input (k=2):**  
  dummy ⇔ 1 ⇔ 2 ⇔ 3 ⇔ 4 ⇔ dummy  
  **Output:**  
  dummy ⇔ 3 ⇔ 4 ⇔ 1 ⇔ 2 ⇔ dummy  
- **Input (k=1):**  
  dummy ⇔ A ⇔ B ⇔ C ⇔ dummy  
  **Output:**  
  dummy ⇔ B ⇔ C ⇔ A ⇔ dummy  

---

## Question - 05: Rotate Right in a Doubly Circular Linked List
**Problem Statement:**  
Given a dummy-headed doubly circular linked list, rotate it right by k nodes.

**Examples:**  
- **Input (k=1):**  
  dummy ⇔ X ⇔ Y ⇔ Z ⇔ dummy  
  **Output:**  
  dummy ⇔ Z ⇔ X ⇔ Y ⇔ dummy  
- **Input (k=3):**  
  dummy ⇔ 10 ⇔ 20 ⇔ 30 ⇔ 40 ⇔ dummy  
  **Output:**  
  dummy ⇔ 20 ⇔ 30 ⇔ 40 ⇔ 10 ⇔ dummy  

---

### Question - 06: Delete Middle Node
**Problem Statement:**  
Delete the middle node of a non-dummy headed doubly linked list. If the list has even length, delete the second middle node.

**Examples:**  
- **Input:**  
  1 ⇔ 2 ⇔ 3 ⇔ 4 ⇔ 5 ⇔ None  
  **Output:**  
  1 ⇔ 2 ⇔ 4 ⇔ 5 ⇔ None  
- **Input:**  
  A ⇔ B ⇔ C ⇔ D ⇔ None  
  **Output:**  
  A ⇔ B ⇔ D ⇔ None

---

### Question - 07: Swap First and Last Nodes
**Problem Statement:**  
Swap the first and last nodes of a non-dummy headed doubly linked list.

**Examples:**  
- **Input:**  
  10 ⇔ 20 ⇔ 30 ⇔ 40 ⇔ None  
  **Output:**  
  40 ⇔ 20 ⇔ 30 ⇔ 10 ⇔ None  
- **Input:**  
  A ⇔ B ⇔ None  
  **Output:**  
  B ⇔ A ⇔ None  

---

### Question - 08: Remove Duplicates
**Problem Statement:**  
Remove all duplicates from a sorted doubly linked list.

**Examples:**  
- **Input:**  
  1 ⇔ 1 ⇔ 2 ⇔ 3 ⇔ 3 ⇔ 3 ⇔ None  
  **Output:**  
  1 ⇔ 2 ⇔ 3 ⇔ None  
- **Input:**  
  A ⇔ A ⇔ A ⇔ B ⇔ B ⇔ None  
  **Output:**  
  A ⇔ B ⇔ None  

---

### Question - 09: Merge Two Sorted Lists
**Problem Statement:**  
Merge two sorted doubly linked lists into one sorted list.

**Examples:**  
- **Input:**  
  List1: 1 ⇔ 3 ⇔ 5 ⇔ None  
  List2: 2 ⇔ 4 ⇔ 6 ⇔ None  
  **Output:**  
  1 ⇔ 2 ⇔ 3 ⇔ 4 ⇔ 5 ⇔ 6 ⇔ None  
- **Input:**  
  List1: A ⇔ C ⇔ None  
  List2: B ⇔ D ⇔ E ⇔ None  
  **Output:**  
  A ⇔ B ⇔ C ⇔ D ⇔ E ⇔ None  

---

### Question - 10: Split List into Halves
**Problem Statement:**  
Split a doubly linked list into two halves. If the length is odd, the first half should contain the extra node.

**Examples:**  
- **Input:**  
  1 ⇔ 2 ⇔ 3 ⇔ 4 ⇔ None  
  **Output:**  
  First half: 1 ⇔ 2 ⇔ None  
  Second half: 3 ⇔ 4 ⇔ None  
- **Input:**  
  A ⇔ B ⇔ C ⇔ D ⇔ E ⇔ None  
  **Output:**  
  First half: A ⇔ B ⇔ C ⇔ None  
  Second half: D ⇔ E ⇔ None

---

### Question - 11: Detect Loop in Doubly Linked List
**Problem Statement:**  
Given a doubly linked list, detect if it contains a loop (not circular, but an accidental loop).

**Examples:**  
- **Input:**  
  A → B → C → D → B (loop back to B)  
  **Output:** True  
- **Input:**  
  X → Y → Z → None  
  **Output:** False

---

### Question - 12: Pairwise Swap Nodes
**Problem Statement:**  
Swap elements in a doubly linked list pairwise (swap 1st with 2nd, 3rd with 4th, etc.).

**Examples:**  
- **Input:**  
  10 ⇔ 20 ⇔ 30 ⇔ 40 ⇔ None  
  **Output:**  
  20 ⇔ 10 ⇔ 40 ⇔ 30 ⇔ None  
- **Input:**  
  A ⇔ B ⇔ C ⇔ None  
  **Output:**  
  B ⇔ A ⇔ C ⇔ None  

---

### Question - 13: Delete All Occurrences of Key
**Problem Statement:**  
Delete all nodes containing a given key from a doubly linked list.

**Examples:**  
- **Input (key=5):**  
  5 ⇔ 2 ⇔ 5 ⇔ 8 ⇔ 5 ⇔ None  
  **Output:**  
  2 ⇔ 8 ⇔ None  
- **Input (key='X'):**  
  X ⇔ Y ⇔ X ⇔ Z ⇔ None  
  **Output:**  
  Y ⇔ Z ⇔ None  

---

### Question - 14: Sort a Doubly Linked List
**Problem Statement:**  
Sort the given doubly linked list.

**Examples:**  
- **Input:**  
  4 ⇔ 2 ⇔ 5 ⇔ 1 ⇔ None  
  **Output:**  
  1 ⇔ 2 ⇔ 4 ⇔ 5 ⇔ None  
- **Input:**  
  D ⇔ B ⇔ A ⇔ C ⇔ None  
  **Output:**  
  A ⇔ B ⇔ C ⇔ D ⇔ None  

---

### Question - 15: Find Intersection Point of Two Lists
**Problem Statement:**  
Find the intersection node where two doubly linked lists merge.

**Examples:**  
- **Input:**  
  List1: 1 ⇔ 2 ⇔ 3 ⇔ 4  
  List2: 9 ⇔ 8 ⇔ 3 ⇔ 4  
  **Output:** Node with value 3  
- **Input:**  
  X ⇔ Y ⇔ Z  
  A ⇔ B ⇔ Y ⇔ Z  
  **Output:** Node with value Y  

---

### Additional Notes
- All operations should be performed in-place when possible
- Time complexity should be O(n) for all operations
- For circular lists, remember to maintain proper connections
- Edge cases (empty list, single node) should be handled properly
