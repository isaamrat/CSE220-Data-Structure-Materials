# Binary Tree - Java & Python Implementations

## Overview

A **Binary Tree** is a tree data structure in which each node has at most two children, typically referred to as the left and right children. Each node in a binary tree stores a data element and references to its left and right children, which can either be subtrees or `null`.

### Properties of Binary Tree:

- **Root**: The top node in a tree, where all operations begin.
- **Leaf Nodes**: Nodes that have no children (both left and right references are `null`).
- **Height**: The height of a binary tree is the number of edges on the longest path from the root to a leaf.
- **Depth**: The depth of a node is the number of edges from the root to that node.
- **Full Binary Tree**: A binary tree where every node has either 0 or 2 children.
- **Complete Binary Tree**: A binary tree where all levels, except possibly the last, are completely filled, and all nodes are as far left as possible.
- **Perfect Binary Tree**: A binary tree where all internal nodes have two children, and all leaf nodes are at the same level.
- **Balanced Binary Tree**: A binary tree where the height difference between the left and right subtrees of any node is no greater than 1.

## Java Implementation

This Java implementation of a Binary Tree follows the same structure as the Python implementation. It provides methods for binary tree operations like:

- **Array to Tree Conversion**: Converts an array into a binary tree.
- **Traversals**:
  - [InOrder Traversal](#inorder-traversal) (Left, Root, Right)
  - [PreOrder Traversal](#preorder-traversal) (Root, Left, Right)
  - [PostOrder Traversal](#postorder-traversal) (Left, Right, Root)
- **Tree Properties**:
  - [Node Count](#node-count): Calculates the total number of nodes in the tree.
  - [Find Depth](#find-depth): Returns the depth of a target node.
  - [Find Height](#find-height): Calculates the height of the tree.
  - [Full Binary Tree](#isfull): Checks if the tree is a full binary tree.
  - [Complete Binary Tree](#iscomplete): Checks if the tree is a complete binary tree.
  - [Perfect Binary Tree](#isperfect): Verifies if the tree is a perfect binary tree.
  - [Balanced Tree](#isbalanced): Checks if the tree is balanced.

### Java Code

```java
class Node {
    Integer elem;
    Node left;
    Node right;
    
    Node(Integer val) {
        this.elem = val;
        this.left = null;
        this.right = null;
    }
```
<!-- // Functions: [arrayToTree](#array-to-tree), [inOrder](#inorder-traversal), [nodeCount](#node-count), [findDepth](#find-depth), [findHeight](#find-height), [isFull](#isfull), [isComplete](#iscomplete), [isPerfect](#isperfect), [isBalanced](#isbalanced)
``` -->

**Test cases** are present in the `main` method, where you can verify various tree properties such as node count, tree height, balance, and completeness.

---

## Python Implementation

This Python implementation of a Binary Tree includes the following functionalities:

- **Array to Tree Conversion**: Converts an array representation of a binary tree into an actual binary tree structure.
- **Traversals**:
  - [InOrder Traversal](#inorder-traversal) (Left, Root, Right)
  - [PreOrder Traversal](#preorder-traversal) (Root, Left, Right)
  - [PostOrder Traversal](#postorder-traversal) (Left, Right, Root)
- **Tree Properties**:
  - [Node Count](#node-count): Counts the total number of nodes in the tree.
  - [Find Depth](#find-depth): Finds the depth of a target node.
  - [Find Height](#find-height): Finds the height of the tree.
  - [Full Binary Tree](#isfull): Checks if the tree is a full binary tree.
  - [Complete Binary Tree](#iscomplete): Checks if the tree is a complete binary tree.
  - [Perfect Binary Tree](#isperfect): Checks if the tree is a perfect binary tree.
  - [Balanced Tree](#isbalanced): Checks if the tree is balanced.

### Python Code

```python
class Node:
    def __init__(self, elem):
        self.elem = elem
        self.left = self.right = None
```
<!-- # Functions: 
- [arrayToTree](#array-to-tree)
- [inOrder](#inorder-traversal)
- [nodeCount](#node-count)
- [findDepth](#find-depth)
- [findHeight](#find-height)
- [isFull](#isfull)
- [isComplete](#iscomplete)
- [isPerfect](#isperfect)
- [is_balanced](#isbalanced) -->


**Test cases** are included at the end of the script, where various tree properties are tested on a sample binary tree.

---

## Key Features

- **Tree Traversals**: Both Java and Python versions include functions for common tree traversal techniques: [PreOrder](#preorder-traversal), [InOrder](#inorder-traversal), and [PostOrder](#postorder-traversal).
- **Tree Property Checks**: Includes methods to check if the tree is full, complete, perfect, or balanced.
- **Binary Tree Construction**: Both implementations allow constructing a binary tree from an array representation of the tree structure.

---

## Functions

### [Array to Tree](#array-to-tree)

- Converts an array into a binary tree structure.
- It takes an array of integers (with `null` as placeholders for empty nodes) and recursively builds the tree by assigning left and right children based on array indices.

### [InOrder Traversal](#inorder-traversal)

- Prints the elements of the tree in InOrder (Left, Root, Right).
- Useful for printing the tree in ascending order for Binary Search Trees (BST).

### [PreOrder Traversal](#preorder-traversal)

- Prints the elements of the tree in PreOrder (Root, Left, Right).
- Useful for creating a copy of the tree.

### [PostOrder Traversal](#postorder-traversal)

- Prints the elements of the tree in PostOrder (Left, Right, Root).
- Useful for deleting the tree or evaluating expressions.

### [Node Count](#node-count)

- Counts the total number of nodes in the tree by recursively traversing the entire tree.

### [Find Depth](#find-depth)

- Finds the depth of a target node in the tree.
- Depth is defined as the number of edges from the root to the node.

### [Find Height](#find-height)

- Finds the height of the tree.
- Height is defined as the number of edges on the longest path from the root to a leaf.

### [Full Binary Tree](#isfull)

- Checks if the tree is a full binary tree.
- A full binary tree is a binary tree where every node has either 0 or 2 children.

### [Complete Binary Tree](#iscomplete)

- Checks if the tree is a complete binary tree.
- A complete binary tree is one where all levels are filled, except possibly the last, and all nodes are as far left as possible.

### [Perfect Binary Tree](#isperfect)

- Checks if the tree is a perfect binary tree.
- A perfect binary tree is one where all internal nodes have two children, and all leaf nodes are at the same level.

### [Balanced Tree](#isbalanced)

- Checks if the tree is balanced.
- A balanced binary tree has no more than 1 difference in height between the left and right subtrees of any node.

---

## Conclusion

This repository provides two implementations (Java and Python) of a binary tree, demonstrating key operations and properties. These implementations can be extended or modified for various applications such as data storage, searching, and more.

