# 5.2 Binary Tree

 A tree is a binary tree if every single node of the tree has at most 2 child nodes.

| Tree Type       |  Representation | Description |
|----------------|----------------------|-------------|
| **Binary Tree** | <pre>     A<br>    / \ <br>   B   C<br>  / \ / \ <br> D  E F  G</pre> |  Tree with all nodes having 0 or 2 children |
| **Binary Tree<br>Left-Skewed** | <pre>     A<br>    /<br>   B<br>  /<br> C</pre> | All nodes have only left children |
| **Binary Tree<br>Right-skewed** | <pre>     A<br>      \ <br>       B<br>        \ <br>         C</pre> | All nodes have only right children |
| **Binary Tree<br>Degenerate** | <pre>     A<br>    / \ <br>   B   C<br>    \ /<br>    D E</pre> | Mixed nodes with single children |
| **Invalid<br>Not a Binary Tree** | <pre>     A<br>   / \| \ <br>  B  C  D<br> / \ <br>E   F</pre> | Node A has 3 children (invalid binary tree) |


### 5.3 Characteristics of a Binary Tree

 - Each node in a binary tree can have at most two child nodes
 - If the number of internal nodes is n, number of external nodes is n+1, number of edges is 2n, number of internal edges is n-1, number of external edges is n+1.
 - The maximum number of nodes possible in a binary tree of height ‘h’ is: \( 2^{h+1} - 1 \)
 - The maximum number of nodes at level i is: \( 2^i \)

### 5.4 Binary Tree Traversal: Pre-order, In-order, Post-order

#### Pre-order
 Whenever a node is visited for the first time, its element is printed. We start from the root and print its element. Then its left subtree is traversed. If a node does not have a left child, we return to that node After all the nodes of its entire left subtree have been traversed thrice, we head back to the root node for the second time and check if it has any right child, and if it does not have a right child either, we again return to that node After all the nodes of its entire left subtree have been traversed thrice, we head back to the root node for the third time and then go towards its parent node. After all the nodes of its entire left subtree have been traversed twice, we head back to the root node. After that, its right subtree is traversed. The root is printed at first.

#### In-order
 Whenever a node is visited for the second time, its element is printed. We start from the root and traverse its left subtree. If a node does not have a left child, we return to that node for the second time and print its element. Then we check if it has any right child, and if it does not have a right child either, we again return to that node for the third time and then go towards its parent node. After all the nodes of its entire left subtree have been traversed thrice, we head back to the root node for the second time and print its element. The root is printed after all the nodes of its left subtree are printed. After that, its right subtree is traversed. After all the nodes of its entire right subtree have been traversed thrice, we head back to the root node for the third time.

 In-order traversal also sorts the data in ascending order.

#### Post-order 
 Whenever a node is visited for the third time, its element is printed. We start from the root and traverse its left subtree. If a node does not have a left child, we return to that node for the second time and check if it has any right child, and if it does not have a right child either, we again return to that node for the third time, print its element and then go towards its parent node. After all the nodes of its entire left subtree have been traversed thrice, we head back to the root node and then traverse its right subtree. After all the nodes of its entire right subtree have been traversed thrice, we head back to the root node for the third time and print its element. The root is printed at the last. 

 ```
 Traversal Results:

        70
       /  \
     50    90
    / \    / \
  40  60 80  95
 /       / \   \
20     75  85  99

Pre-order: 70, 50, 40, 20, 60, 90, 80, 75, 85, 95, 99
In-order: 20, 40, 50, 60, 70, 75, 80, 85, 90, 95, 99
Post-order: 20, 40, 60, 50, 75, 85, 80, 99, 95, 90, 70
 ```

### 5.5 Types of a Binary Tree 

#### 5.5.1 Full/Strict Binary Tree 
 In a full binary tree, internal nodes (every node except the leaf nodes) have two children. How can we identify a full binary tree? Any binary tree that maintains the following condition is a full binary tree: 
 No of leaf nodes = no of internal nodes + 1 

 |Full Binary Tree||
 |----|---|
 | <pre>     A<br>    / \ <br>   B   C<br>      / \ <br>      F  G <br>        / \ <br>       H   I </pre> |  <pre>      A<br>    /   \ <br>   B     C<br>  / \   / \ <br> D   E  F  G  </pre> |
 |

 Here, in the leftmost tree, the no of internal nodes is 3 and the no of leaf nodes is 4. Again in the rightmost tree, the no of internal nodes is 3 and the no of leaf nodes is 4. 

#### 5.5.2 Complete Binary Tree 
 In a complete binary tree, all the levels are filled entirely with nodes, except the lowest level of the tree. Also, in the lowest level of this binary tree, every node should possibly reside on the left side. 

 How can we identify a complete binary tree?
 - If all the internal nodes (every node except the leaf nodes) have two childs, then it is a complete binary tree.
 - If any of the internal nodes has only one child, the child must reside in the left side and not in the right side.

 |Complete Binary Tree||
 |----|---|
 |  <pre>      A<br>    /   \ <br>   B     C<br>  / \   / \ <br> D   E  F  G  </pre> | <pre>     A<br>    / \ <br>   B   C<br>  / \ <br> F   G <br>  </pre> |
|

 In the leftmost tree, all internal nodes have two children. Therefore, it is a complete binary tree. In the rightmost tree, all internal nodes except one have two children. The only internal node that has one child, has its child residing on its left side. Therefore, it is also a complete binary tree.

#### 5.5.3 Perfect Binary Tree
 In a perfect binary tree, every internal node has exactly two child nodes and all the leaf nodes are at the same level.

 |Perfect Binary Tree|Not a Perfect Binary Tree|Not a Perfect Binary Tree|
 |----|---|---|
 |  <pre>      A<br>    /   \ <br>   B     C<br>  / \   / \ <br> D   E  F  G  </pre> | <pre>     A<br>    / \ <br>   B   C<br>  / \ <br> F   G <br>  </pre> | <pre>     A<br>    / \ <br>   B   C<br>      / \ <br>      F  G <br>        / \ <br>       H   I </pre> |
|

 In the tree in the middle and rightmost position, all the leaf nodes are not on the same level.

#### 5.5.4 Balanced Binary Tree
 In a balanced binary tree, the height of the left and right subtree of any node differ by not more than 1. Balanced binary trees are also referred to as a height-balanced binary tree.
 
 df = | height of left child - height of right child |  

 |Unbalanced  Binary Tree| Balanced Binary Tree|
 |----|---|
 | <pre>     A<br>    / \ <br>   B   C<br>      / \ <br>      F  G <br>        / \ <br>       H   I </pre> |  <pre>      A<br>    /   \ <br>   B     C<br>  / \   <br> D   E   </pre> |
 |


 In the leftmost tree, the height of Node A's left subtree is 0 and right subtree is 2. Therefore, the difference between these two is 2. On the other hand, in the rightmost tree, no nodes have a height difference of more than 1 in between their left and right subtrees.

### 5.6 Binary Tree Coding

#### 5.6.1 Tree Construction using Array (Sequential Representation)
 Have you ever thought about how to represent binary trees in your program? If you can recall, we have been using linked lists so far to represent trees. So, there are two ways to represent binary trees:
 1. Dynamic Representation (Using Linked List)
 2. Sequential Representation (Using Array)

 We have already covered the dynamic representation of trees. Now let us look at how to sequentially represent binary trees.

 Sequential Representation (Using Array) Conditions:
- I. If the height of the binary tree is h, An array of maximum \( 2^{h+1} \) length is required.
- II. The root is placed at index 1.
- III. Any node that is placed at index i, will have its left child placed at 2i and its right child at \( 2i+1 \).

|**Pseudocode of Array representation of a Binary Tree:**|
|-|
```
 FUNCTION createBinaryTree(arr, index)
   IF index >= length of arr OR arr[index] IS NULL
     RETURN NULL
   ENDIF

   node ← new TreeNode(arr[index])
   node.left ← createBinaryTree(arr, 2 * index)
   node.right ← createBinaryTree(arr, 2 * index + 1)
   RETURN node
 END FUNCTION
```
#### 5.6.2 Level, Height, and Depth Finding
```
 Depth = number of edges from root to the node

 FUNCTION findDepth(root, targetValue, currentDepth)
     IF root IS NULL
       RETURN -1
 ENDIF

     IF root.elem == targetValue
       RETURN currentDepth
 ENDIF

     leftDepth ← findDepth(root.left, targetValue, currentDepth + 1)
     IF leftDepth ≠ -1
       RETURN leftDepth
 ENDIF

     RETURN findDepth(root.right, targetValue, currentDepth + 1)
 END FUNCTION
 ```
```
 Height = longest path from the node to a leaf

 FUNCTION getHeight(node)
     IF node IS NULL
       RETURN -1
 ENDIF

     leftHeight ← getHeight(node.left)
     rightHeight ← getHeight(node.right)
     RETURN max(leftHeight, rightHeight) + 1
 END FUNCTION
 ```

#### 5.6.3 Number of Nodes Finding
```
 FUNCTION countNodes(root)  
   IF root IS NULL  
     RETURN 0  
   ENDIF  

   RETURN 1 + countNodes(root.left) + countNodes(root.right)  
 END FUNCTION  
```

 ### 5.6.4 Identifying Tree Types: Full, Complete and Perfect (Continued)

 
 ### Full Binary Tree Check
 **Condition:** Every node must have 0 or 2 children.

 **Pseudocode:**
 ```
 FUNCTION isFullTree(root)
     IF root IS NULL
         RETURN TRUE
     ENDIF
     
     IF (root.left IS NULL AND root.right IS NULL)
         RETURN TRUE
     ENDIF
     
     IF (root.left IS NOT NULL AND root.right IS NOT NULL)
         RETURN isFullTree(root.left) AND isFullTree(root.right)
     ENDIF
     
     RETURN FALSE
 END FUNCTION
 ```

 ### Complete Binary Tree Check
 **Condition:** All levels except last must be fully filled, and last level nodes are left-justified.

 **Pseudocode:**
 ```
 FUNCTION isComplete(root, index, totalNodes)
     IF root IS NULL
         RETURN TRUE
     ENDIF
     
     IF index > totalNodes
         RETURN FALSE
     ENDIF
     
     RETURN isComplete(root.left, 2 * index, totalNodes) AND isComplete(root.right, 2 * index + 1, totalNodes)
 END FUNCTION
 ```


 **Visual Examples:**
 ```
 Full but not Complete:     Complete but not Full:

      A                        A
    /   \                    /   \
   B     C                  B     C
  / \   / \                / \   /
 D   E F   G              D   E F
```

 #### Perfect Binary Tree or Not
  A perfect binary tree is a binary tree in which all interior nodes have exactly two children and all leaves are at the same level.

 **Pseudocode:**
 ```python
 FUNCTION isPerfect(root, depth, level)
     IF root IS NULL
         RETURN TRUE
     ENDIF

     IF root.left IS NULL AND root.right IS NULL
         RETURN depth == level + 1
     ENDIF

     IF root.left IS NULL OR root.right IS NULL
         RETURN FALSE
     ENDIF

     RETURN isPerfect(root.left, depth, level + 1) AND isPerfect(root.right, depth, level + 1)
 END FUNCTION

 # Helper to get depth
 FUNCTION getDepth(root)
     depth = 0
     WHILE root IS NOT NULL
         depth = depth + 1
         root = root.left
     ENDWHILE
     RETURN depth
 END FUNCTION
 ```

 #### Balanced Binary Tree or Not
  A balanced binary tree is one where the height difference between left and right subtrees of any node is no more than 1.

 **Pseudocode:**
 ```python
 FUNCTION isBalanced(root)
     IF root IS NULL
         RETURN (True, 0)
     ENDIF

     (leftBalanced, leftHeight) ← isBalanced(root.left)
     (rightBalanced, rightHeight) ← isBalanced(root.right)

     currentBalanced ← leftBalanced AND rightBalanced AND 
                      abs(leftHeight - rightHeight) ≤ 1
     currentHeight ← max(leftHeight, rightHeight) + 1

     RETURN (currentBalanced, currentHeight)
 END FUNCTION
 ```

 **Key Points:**
 1. For perfect binary trees:
    - All internal nodes must have exactly two children
    - All leaves must be at the same level
    - Total nodes = 2^(h+1) - 1 where h is height

 2. For balanced binary trees:
    - The height difference between left and right subtrees ≤ 1 for every node
    - AVL trees are examples of balanced binary trees

 3. Relationship between tree types:
    - Every perfect binary tree is both full and complete
    - Every complete binary tree is balanced
    - But not all balanced trees are complete

 **Visual Examples:**
 ```
 Perfect Binary Tree      Balanced but Not Perfect
        A                        A
      /   \                    /   \
     B     C                  B     C
    / \   / \                /     / \
   D  E  F  G               D     F   G
 ```

---

# Exercises

**5.1:** Find the level, depth, height and degree of the specified nodes of the following tree.
---
```
          A
        /   \
       B     C
      / \   / \
     D   E  F  G
    / \  /      \
   H   I J       K
                /
               L
```

| Node A    | Node D    | Node F    | Node C    |
|---|---|---|---|
| Level:    | Level:    | Level:    | Level:    |
| Depth:    | Depth:    | Depth:    | Depth:    |
| Height:    | Height:    | Height:    | Height:    |
| Degree:    | Degree:    | Degree:    | Degree:    |

| Node E    | Node G    | Node L    |
|---|---|---|
| Level:    | Level:    | Level:    |
| Depth:    | Depth:    | Depth:    |
| Height:    | Height:    | Height:    |
| Degree:    | Degree:    | Degree:    |

---
**5.2:** Identify which of the following trees are full, complete, perfect and balanced.
---
```
Tree-A
         70
        /  \
      50    90
     /  \   /  \
    40  60 80  95
   /      / \    \
  20     75 85    99
```
```
Tree-B
         70
        /  \
      50    90
     /        \
    40         95
   /            \
  20             99
```
```
Tree-C
           70
          / \
         /   \
        /     \
      50       95
     /  \      /
    20   60   80
             / \
            75  85
```
```
Tree-D
          A
         / \
        B   C
      / | \   \
     G  D  E   F
```
```
Tree-E
         1
        / \
       2   3
      / \
     4   5
```
```
Tree-F
        70
          \
          90
            \
            95
              \
              99
```

---

**5.3:** Write the code to construct a tree of height 3 and minimum number of 9 nodes. Use your imagination while designing the tree.
---
**5.4:** Traverse the following trees in pre-order, in-order and post-order and print the elements. Show both simulation and code.
---
```
          70
         /  \
        /    \
      50      90
     /  \    /  \
    40   60 80  95
   /     /  / \    \
  20    55 75  85  99
```

Pre-order:

In-order:

Post-order:

---
**5.5:** Consider the following array and convert it into a binary tree. Show simulation and code.
---
[None, 15, 25, 35, 10, 35, 15, 18, None, None, None, 33, None, 5, None, 19, None, None, None, 16]

---
**5.6:** Write a function `isSymmetric(root)` that takes the root of a binary tree, check
whether it is a mirror of itself (i.e., symmetric around its center).
---
```
          1
         / \
        / | \
       2  |  2
      / \ |  / \
     3  4 | 4  3
          |
Output: Symmetric
```
```
           1
         /   \
        /  |  \
       2   |   2
        \  |    \
         3 |     3
           |
Output: Not Symmetric
```
---
**5.7:** Write a function `isIdentical(root1, root2)` that takes the roots of two binary trees, check whether they are identical or not).
---
```
Tree1:
           70
         /    \
        /      \
      50       90
     /  \     /  \
    40   60  80   95
   /         / \    \
  20        75  85   99

Tree2:
           70
         /    \
        /      \
      50       90
     /  \     /  \
    40   60  80   95
   /    /    / \    \
  20   55   75  85   99

Output: Not Equivalent Trees

```
---
**5.8:** Given two binary trees, find if both of them are identical or not.
---
```
First Tree Comparison:

Input:

        1              1
       / \            /  \
      2   3          2    3

Output: Yes

Explanation:
There are two trees both having 3 nodes and 2 edges. Both trees are identical, having the root as 1, the left child of 1 as 2, and the right child of 1 as 3.
```
```
Second Tree Comparison::

Input:

        1              1
       / \            /  \
      2   3          3    2

Output: No

Explanation:
There are two trees both having 3 nodes and 2 edges, but both trees are not identical.
```
---
**5.9:** Given a binary tree, convert it into its mirror.
---
```

Input:

        10
       /  \
      20   30
     /  \ 
    40   60

Output: 30 10 60 20 40

Explanation:
The tree is:
        10
       /  \
      20   30
     /  \ 
    40   60

 (mirror)
        10
       /  \
      30   20
     /  \ 
    60   40

The inorder traversal of the mirror is:
30 10 60 20 40
```
---
**5.10:** Given a binary tree, find if it is height balanced or not. A tree is height balanced if the difference between heights of left and right subtrees is not more than one for all nodes of the tree.
---
```
Input: 
    1
   /
  2
   \
    3

Output: 0

Explanation 1:
The max difference in height of left subtree and right subtree is 2, which is greater than 1. Hence unbalanced.

------

Input:
    10
   /  \
  20   30
 /  \
40  60

Output: 1

Explanation 2:
The max difference in height of left subtree and right subtree is 1. Hence balanced.
```

---
**5.11:** Given a binary tree, check whether all of its nodes have the value equal to the sum of their child nodes.
---
```
Input:
    10
   /
  10
   
Output: 1

Explanation 1:
Here, every node is sum of its left and right child.

----

Input:
    1
   / \
  4   3
 / \
5   N

Output: 0

Explanation 2:
Here, 1 is the root node and 4, 3 are its child nodes. 4 + 3 = 7 which is not equal to the value of root node. Hence, this tree does not satisfy the given conditions.
```
---

**5.12:** Given a binary tree, find the largest value in each level.
---
```
Input:
      4
     / \
    9   2
   / \   \
  3   5   7

Output: 4 9 7

Explanation: 
There are three levels in the tree:
1. {4}, max - 4
2. {9, 2}, max - 9
3. {3, 5, 7}, max-7
```
---
**5.13:** Given a binary tree, check if it has duplicate values.
---

```
Input:
    1
   / \
  2   3
       \
        2

Output: Yes
Explanation: The duplicate value is 2.

Input:
    1
   / \
  20   3
        \
         4

Output: No
Explanation: There are no duplicates.
```
---
**5.14:** Given a root of a binary tree, and an integer k, print all the nodes which are at k distance from root.
---
```
Example tree:
       1
     /  \
    2    3
   / \   /
  4   5  8

Nodes at distance 2: 4, 5, 8
```
---
**5.15:** Given a binary tree and a key, write a function that prints all the ancestors of the node with the key. For example, if the given tree is following binary Tree
and the key is 7, then your function should print 4, 2, 1.
---
```
Example tree:
      1
     / \
    2   3
   / \
  4   5
 /
7

Key = 7 → Ancestors: 4, 2, 1
```
---
**5.16:** Given a binary tree, print all the nodes having exactly one child.
---
```
Input:
      2
     / \
    3   5
   /   / \
  7   8   6

Output: 3
Explanation: There is one node having single child that is 3.
```
---

**5.17:** Given a binary tree, check whether it is a skewed binary tree or not. A skewed tree is a tree where each node has only one child node or none.
---
```
Input:
    5
   /
  4
   \
    3
   /
  2

Output: Yes

Input:
    5
   /
  4
   \
    3
   / \
  2   4

Output: No
```
---
**5.18:** Given a binary tree, find its minimum depth. The minimum depth is the number of nodes
along the shortest path from the root node down to the nearest leaf node. For example, the
minimum depth of the below Binary Tree is 2.
---
```
Example tree:
      1
     / \
    2   3
   / \
  4   5
 /
7

Minimum depth: 2
```
---
**5.19:** Given a binary tree, print all nodes that are full nodes. Full nodes are nodes which have both left and right children as non-empty.
---
```
Input:
      10
     /  \
    8    2
   / \  /
  3  5 7

Output: 10 8
```
---
**5.20:** Given a binary tree with distinct nodes(no two nodes have the same data values). The
problem is to print the path from root to a given node x. If node x is not present then print “No
Path”.
---
```
Input:
      1
     / \
    2   3
   / \ / \
  4  5 6 7

x = 5 
Output: 1 -> 2 -> 5
```
---
**5.21:** Evaluate a given binary expression tree representing algebraic expressions. A binary
expression tree is a binary tree, where the operators are stored in the tree’s internal nodes, and the leaves contain constants. Assume that each node of the binary expression tree has zero or
two children. The supported operators are +, -, * and /.
For example, the value of the following expression tree is 28.
---
```
Example tree:
     '+'
     / \
    /   \
   '*'   '/'
  /  \    /\
 '-'  5  21 7
 / \
10  5

Value: 28
```
