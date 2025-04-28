# Chapter 6: Binary Search Tree (BST)

## 6.1 Characteristics of a BST

Binary Search Tree is a binary tree data with the following fundamental properties:
1. The left subtree of a node contains only nodes with keys lesser than the node’s key.
2. The right subtree of a node contains only nodes with keys greater than the node’s key.
3. The left and right subtree each must also be a binary search tree.
4. Each node must have a distinct key, which means no duplicate values are allowed.

The goal of using BST data structure is to search any element within O(log(n)) time complexity.

### BST Examples:

```
         70
       /   \
     50     90
    /  \    / \
  40    60 80  95
 /        / \    \  
20       75 85    99  
```

## 6.2 Basic Operations on a BST

Any operation done in a BST must not violate the fundamental properties of a BST.

### 6.2.1 Creation of a BST

Draw the BST by inserting the following numbers from left to right:  
70, 50, 40, 90, 20, 20, 95, 99, 80, 85, 75

```
      root
        |
       70
      /  \
    50   90
   /    /  \
  40   80  95
 /    / \    \
20   75 85    99  
```

Here, the second 20 is ignored as it is a duplicate value.

### 6.2.2 Inserting a Node

While inserting a node into an existing BST, the process is similar to that of creating a BST. We start comparing it with the root node:
- If the new node data is greater, we go towards the right subtree of the root.
- If smaller, we go towards the left subtree.
We keep on going like this until we find a free space, and then make a node using the new node data and attach the new node at the vacant place.  
Note that after insertion, a balanced BST may become unbalanced, and therefore any searching operation done on it may take a lot longer than O(log(n)). We have to balance the tree if it becomes unbalanced.

### 6.2.3 Removing a Node

Three possible cases can occur while deleting a node:
1. **Case 1**: No subtree or children: This one is the easiest. You can simply just delete the node, without any additional actions required.
2. **Case 2**: One subtree (one child): You have to make sure that after the node is deleted, its child is then connected to the deleted node's parent.
3. **Case 3**: Two subtrees (two children): You have to find and replace the node you want to delete with its leftmost node in the right subtree (inorder successor) or rightmost node in the left subtree (inorder predecessor).

### Deletion Examples:

```
Initial Tree:
         70
       /   \
     50     90
    /  \    / \
  40    60 80  95
 /        / \    \  
20       75 85    99
```
```
Delete 99:

         70
       /   \
     50     90
    /  \    / \
  40    60 80  95
 /        / \  
20       75 85
```
```
Delete 70: 

         75
       /   \
     50     90
    /  \    / \
  40    60 80  95
 /        /  
20       85
```
```
Delete 40: 
         75
       /   \
     50     90
    /      /   \
  20     80    95
         /  
        85
```
```
Delete 75: 
         80
       /   \
     50     90
    /      /   \
  20     85    95
```

## 6.3 Balanced vs Unbalanced BST

If the height difference between left and right subtree of any node in the BST is more than one, it is an unbalanced BST. Otherwise, it is a balanced one. In a balanced BST, any searching operation can take up to O(log(n)) time complexity. In an unbalanced one, it may take O(n) time complexity, which renders the usage of BST obsolete.

`df = | height of left child - height of right child |`

`df <= 1 to be balanced ` 

```
Balanced BST:
         70
       /   \
     50     90
    /  \    / \
  40    60 80  95
 /        / \    \  
20       75 85    99

Unbalanced BST:
    70
      \
       90
        \
         95
          \
           99
```


## How to Convert a  Unbalanced BST into a Balanced BST?

I. **Traverse the given BST in inorder** and store the result in an array. This will give us the ascending sorted order of all the data.

II. **Take the data in the (size/2) position** in the array and make it the root. The left subtree of the root will be all the data residing from 0 to (size/2)-1 positions in the array. The right subtree of the root will be all the data residing from (size/2)+1 to (size-1) positions of the array.

III. **Recursively apply the process** of choosing the middlemost values from the left and right subtrees and connecting these to the root. Keep repeating this process until all elements of the array have been processed.

### Example:

**Step 1:** Start with the unbalanced BST:

```
        50
       / 
     30   
    /  \
   20  40
    \
    25  
      \
      35  
```

**Step 2:** Traverse the BST in inorder to get the sorted values:  
[20, 25, 30, 35, 40, 50]

**Step 3:** Take the middle element (size/2 = 3) of the array (35) and make it the root.  
So, the root of the balanced tree is 35.

**Step 4:** The left subtree consists of the elements before 35, and the right subtree consists of the elements after 35.  
Left subtree: [20, 25, 30]  
Right subtree: [40, 50]

**Step 5:** Apply the same process to the left and right subtrees:
- For the left subtree [20, 25, 30], the middle element is 25, which becomes the left child of 35.  
- For the right subtree [40, 50], the middle element is 40, which becomes the right child of 35.

**Step 6:** Now, repeat the process for the left and right subtrees:
- For the left subtree [20], the middle element is 20, which becomes the left child of 25.  
- For the right subtree [30], the middle element is 30, which becomes the right child of 25.
- For the right subtree [50], the middle element is 50, which becomes the right child of 40.

**Step 7:** The resulting balanced BST is:

```
        35
       /  \
     25    40
    /  \     \
  20    30    50
```

**Final Balanced BST:**

```
        35
       /  \
     25    40
    /  \     \
  20    30    50
```

This is how you convert a larger unbalanced BST into a balanced BST by following the steps above.


## 6.4 BST Coding

### 6.4.1 Creating a BST / Inserting a Node

**Pseudocode:**
```
FUNCTION insert(node, key):
    IF node IS NULL:
        RETURN new Node(key)
    IF key < node.key:
        node.left = insert(node.left, key)
    ELSE IF key > node.key:
        node.right = insert(node.right, key)
    RETURN node
```

### 6.4.2 BST Traversal: Pre-order, In-order, Post-order

**Pre-Order:**
```
function preorder(root):
    if root is null:
        return
    print root.data
    preorder(root.left)
    preorder(root.right)
```

**In-Order:**
```
function inorder(root):
    if root is null:
        return
    inorder(root.left)
    print root.data
    inorder(root.right)
```

**Post-Order:**
```
function postorder(root):
    if root is null:
        return
    postorder(root.left)
    postorder(root.right)
    print root.data
```

### 6.4.3 Searching for an Element

**Pseudocode:**
```
FUNCTION search(node, key):
    IF node IS NULL:
        RETURN False
    IF node.key == key:
        RETURN True
    IF key < node.key:
        RETURN search(node.left, key)
    ELSE:
        RETURN search(node.right, key)
```

### 6.4.4 Removing a Node

**Pseudocode for deleting using successor (inorder successor):**
```
FUNCTION deleteUsingSuccessor(node, key):
    IF node IS NULL:
        RETURN NULL
    IF key < node.key:
        node.left = deleteUsingSuccessor(node.left, key)
    ELSE IF key > node.key:
        node.right = deleteUsingSuccessor(node.right, key)
    ELSE:
        IF node.left IS NULL:
            RETURN node.right
        ELSE IF node.right IS NULL:
            RETURN node.left
        successor = findMin(node.right)
        node.key = successor.key
        node.right = deleteUsingSuccessor(node.right, successor.key)
    RETURN node
```

### 6.4.5 Balancing BST

**Pseudocode:**
```
FUNCTION storeInorder(node, array, index):
    IF node IS NULL:
        RETURN index
    index = storeInorder(node.left, array, index)
    array[index] = node.key
    index = storeInorder(node.right, array, index)
    RETURN index

FUNCTION buildBalancedBST(array, start, end):
    IF start > end:
        RETURN NULL
    mid = (start + end) / 2
    node = new Node(array[mid])
    node.left = buildBalancedBST(array, start, mid - 1)
    node.right = buildBalancedBST(array, mid + 1, end)
    RETURN node
```

The tree balancing is done by traversing the BST and storing its elements in an array. Then, we rebuild the tree using the middle element as the root.
```
Unbalanced BST:
    40
     \
      50
       \ 
        70
         \
          90
           \
            95
             \ 
              99

Balanced BST:
                90
               /  \
             50    99
            / \    /
          40   70 95
```

## Exercises
#### 6.1: Convert the following unbalanced BSTs into balanced BSTs. Show simulation.

```
Tree1:
          70
         /  \
        50   90
       /      \
      40       95 
     /          \
    20           99

-----------------------
Tree2:
           70
          /  \
         /    \
        50    90
         \    / \
         60  75 95 
              \   \
              85  99
              /
             79
```

<!-- ![Image](./assets/b1.png) -->

#### 6.2: Insert keys 65, 105, 69 into the following BST and show the steps. Show simulation and code.

```
           70
          /  \
         /    \
        50     90
       / \     / \
      40 60   80  95 
     /       / \   \
    20      75 85  99
```

#### 6.3: Delete keys 20, 95, 50, 70, 75 into the following BST and show the steps. Show simulation
and code.
```
           70
          /  \
         /    \
        50     90
       / \     / \
      40 60   80  95 
     /   /   / \   \
    20  55  75 85  99
```
#### 6.4: How can you print the contents of a tree in descending order with and without using stack? Solve using code.

#### 6.5: Write a python program that takes the root of a tree and finds its inorder successor and
predecessor.
```
           70
          /  \
         /    \
        50     90
       / \     / \
      40 60   80  95 
     /       / \   \
    20      75 85  99

Output for node 70:
In-order Successor: 75
In-order Predecessor: 60
```

#### 6.6: Given a sorted array, write a function that creates a Balanced Binary Search Tree using array elements. Follow the steps mentioned below to implement the approach:
1. Set The middle element of the array as root.
2. Recursively do the same for the left half and right half.
3. Get the middle of the left half and make it the left child of the root created in step 1.
4. Get the middle of the right half and make it the right child of the root created in step 1.
5. Print the preorder of the tree.

```
Sample 01:
  Given Array: [1, 2, 3]
  BST
    2
   / \
  1   3
  Output: Pre-order of created BST: 2 1 3
-------------------
Sample 02:
  Given Array: [1, 2, 3, 4]
  BST
      3
     / \
    2   4
   /
  1 
  Output: Pre-order of created BST: 3 2 1 4
```
#### 6.7: Given the root of a binary tree, check whether it is a BST or not. A BST is defined as follows:
1. The left subtree of a node contains only nodes with keys less than the node's key.
2. The right subtree of a node contains only nodes with keys equal or greater than the
node's key.
3. Both the left and right subtrees must also be binary search trees
```
Input 01:
    2
   / \
  1   3

Output: 1

Explanation: The left subtree of root node contains node With key lesser than the root nodes key and the right subtree of root node contains node with key greater than the root nodes key. Hence, the tree is a BSI
-------------------
Input 02:

    2
     \
      7
       \
        6
         \
          5
           \
            9
             \
              2
               \
                6
  
Output: 0

Explanation: Since the node with value 7 has right subtree nodes with keys less than 7, this is not a BST.
```
#### 6.8: Given a sorted array. Write a function that creates a Balanced Binary Search Tree using array elements. Height balanced BST means a binary tree in which the depth of the left subtree and the right subtree of every node never differ by more than 1
```
Input: nums = {1, 2, 3, 4, 5, 6}
Ouput: {4, 2, 1, 3, 6, 5, 7}
Explanation:
The preorder traversal of the following BST formed is {4, 2, 1, 3, 6, 5, 7}:
             4
           /  \
          /    \
         2      6
        / \    / \
       1   3  5   7

```
#### 6.9: Given a BST, and a reference to a Node x in the BST. Find the Inorder Successor of the given node in the BST.
```
Input:
          20
         /  \
        8   22
       / \
      4  12
        /  \
       10  14

K(data of x) = 8
Output: 10
Explanation:
Inorder Traversal: 4 8 10 12 14 20 22
Hence, successor of 8 is 10
```
#### 6.10: Given a Binary search tree, your task is to complete the function which will return the Kth largest element without doing any modification in the Binary Search Tree.
```
Input:
          20
         /  \
        8   22
       / \
      4  12
        /  \
       10  14

K = 4
Output: 12
```
