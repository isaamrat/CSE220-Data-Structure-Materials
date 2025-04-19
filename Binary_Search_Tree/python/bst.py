import numpy as np

# Class representing a single node of a Binary Search Tree
class Node:
    def __init__(self, val):
        self.elem = val          # The value stored at this node
        self.left = None         # Pointer to the left child
        self.right = None        # Pointer to the right child

# Function to insert a value into the BST
def insert(root, val):
    if root is None:
        return Node(val)         # Create a new node if the tree/subtree is empty
    if val > root.elem:
        root.right = insert(root.right, val)  # Recursively insert into the right subtree
    elif val < root.elem:
        root.left = insert(root.left, val)    # Recursively insert into the left subtree
    return root               # Return the unchanged root pointer

# Function to construct a BST from a given array of values
def treeFromArr(arr):
    root = None
    for val in arr:
        root = insert(root, val)  # Insert each element one by one
    return root

# Function to perform in-order traversal (left, root, right)
def inOrder(root):
    if root is None:
        return                    # Base case: stop for empty subtree
    inOrder(root.left)            # Visit left subtree
    print(root.elem, end=' ')     # Print current node's value
    inOrder(root.right)           # Visit right subtree

# Function to find the minimum value in a BST (leftmost node)
def findMin(root):
    if root.left is None:
        return root.elem          # If no left child, this is the smallest
    return findMin(root.left)     # Otherwise, go further left

# Function to search for a target value in the BST
def searchVal(root, target):
    if root is None:
        return False              # Base case: value not found
    if root.elem == target:
        return True               # Value found at current node
    if target < root.elem:
        return searchVal(root.left, target)   # Search left subtree
    else:
        return searchVal(root.right, target)  # Search right subtree

# Function to remove a node with a specific value from the BST
def removeNode(root, target):
    if root is None:
        return None               # Base case: empty tree
    if target > root.elem:
        root.right = removeNode(root.right, target)   # Search in right subtree
    elif target < root.elem:
        root.left = removeNode(root.left, target)     # Search in left subtree
    else:
        # Node to be deleted found
        if root.left is None:
            return root.right      # Replace node with its right child
        elif root.right is None:
            return root.left       # Replace node with its left child
        # Node has two children
        minimum = findMin(root.right)  # Find in-order successor (smallest in right subtree)
        root.elem = minimum            # Replace value with successor's value
        root.right = removeNode(root.right, minimum)  # Delete the in-order successor
    return root                     # Return the modified root

# Function to count total number of nodes in a BST
def nodeCount(root): 
    if root is None:
        return 0                    # Base case: no nodes
    # Count 1 (current node) + left subtree nodes + right subtree nodes
    return 1 + nodeCount(root.left) + nodeCount(root.right)

# Function to store in-order traversal results into a numpy array
def getInorderArr(root, arr, indx):
    if root is None:
        return indx                  # Base case: no further nodes
    indx = getInorderArr(root.left, arr, indx)  # Visit left subtree
    arr[indx] = root.elem                     # Store current node's value
    indx += 1                                 # Move to next index
    indx = getInorderArr(root.right, arr, indx)  # Visit right subtree
    return indx                                # Return the updated index

# Function to build a balanced BST from a sorted array (recursively)
def buildBalancedBST(arr, s, e):
    if s > e:
        return None                  # Base case: no elements left
    mid = (s + e) // 2               # Pick middle element as root
    root = Node(arr[mid])            # Create a new node
    root.left = buildBalancedBST(arr, s, mid-1)   # Recursively build left subtree
    root.right = buildBalancedBST(arr, mid+1, e)  # Recursively build right subtree
    return root                      # Return the root of the subtree

# Function to balance an unbalanced BST
def BalanceBst(root):
    count = nodeCount(root)                      # Get total number of nodes
    arr3 = np.zeros(count, dtype=int)            # Create a numpy array to hold in-order values
    getInorderArr(root, arr3, 0)                 # Populate the array with in-order traversal (sorted)
    root = buildBalancedBST(arr3, 0, count-1)    # Build balanced BST from the sorted array
    return root                                  # Return the new root of the balanced BST


# Create an array of elements to build the BST
arr = np.array([70, 50, 40, 90, 20, 95, 99, 80, 85, 75])

# Build BST from the array
root = treeFromArr(arr)

# Perform and print in-order traversal (should print sorted values)
inOrder(root)
print()

# Uncomment to test:
print(findMin(root))                      # Find and print the minimum value
print(searchVal(root, 199))               # Search for a value in the BST
arr2 = [40, 50, 70, 90, 95, 99]
root2 = treeFromArr(arr2)                 # Build another unbalanced BST
root2 = BalanceBst(root2)                 # Balance it
inOrder(root2)                            # Print in-order traversal of balanced BST
