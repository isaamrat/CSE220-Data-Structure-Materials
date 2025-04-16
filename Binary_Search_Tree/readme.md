# Chapter 6: Binary Search Tree (BST) and Heap

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
    /    \
   20     40
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
