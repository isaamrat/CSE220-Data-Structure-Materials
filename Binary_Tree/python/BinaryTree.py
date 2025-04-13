class Node:
    def __init__(self, elem):
        self.elem = elem  # Store the element of the node
        self.left = self.right = None  # Initialize left and right child to None

def arrayToTree(arr, i):
    # Base condition to stop recursion if index is out of bounds or the element is None
    if i >= len(arr) or arr[i] is None:
        return None
    root = Node(arr[i])  # Create a new node with the element at index i
    # Recursively create the left and right subtrees
    root.left = arrayToTree(arr, i * 2)
    root.right = arrayToTree(arr, i * 2 + 1)
    return root  # Return the root node of the subtree

def inOrder(root):
    # Base case: If the node is None, return
    if root is None:
        return
    # Recursively visit the left subtree, print the node, then visit the right subtree
    inOrder(root.left)
    print(root.elem, end=' ')
    inOrder(root.right)

def nodeCount(root): 
    # Base case: If the node is None, return 0
    if root is None:
        return 0
    # Recursively count the nodes in the left and right subtrees
    return 1 + nodeCount(root.left) + nodeCount(root.right)

def findDepth(root, target, depth=0):
    # Base case: If the node is None, return -1
    if root is None:
        return -1
    # If the target node is found, return the current depth
    if root.elem == target:
        return depth
    # Recursively search in the left subtree
    leftDepth = findDepth(root.left, target, depth + 1)

    if leftDepth != -1:
        return leftDepth

    # Recursively search in the right subtree
    rightDepth = findDepth(root.right, target, depth + 1)

    return rightDepth

def findHeight(root):
    # Base case: If the node is None, return -1
    if root is None:
        return -1
    # Recursively find the height of the left and right subtrees
    leftHeight = findHeight(root.left)
    rightHeight = findHeight(root.right)
    # Return the maximum height of the two subtrees + 1 for the current node
    return max(leftHeight, rightHeight) + 1

def isFull(root):
    # Base case: If the node is None, the tree is considered full
    if root is None:
        return True
    # If one child is missing, the tree is not full
    if root.left is not None and root.right is None:
        return False
    if root.left is None and root.right is not None:
        return False
    # Recursively check the left and right subtrees
    return isFull(root.left) and isFull(root.right)

def isComplete(root, i, totalNode):
    # Base case: If the node is None, return True
    if root is None:
        return True
    # If the index exceeds the total number of nodes, the tree is not complete
    if i > totalNode:
        return False
    # Recursively check the left and right subtrees
    return isComplete(root.left, i * 2, totalNode) and isComplete(root.right, i * 2 + 1, totalNode)

def isPerfect(root, depth, level=0):
    # Base case: If the node is None, the tree is considered perfect if depth is level + 1
    if root is None:
        return True
    # If both left and right children are None, check if depth equals level + 1
    if root.left is None and root.right is None:
        return depth == level + 1
    # If one child is missing, the tree is not perfect
    if root.left is None or root.right is None:
        return False
    # Recursively check the left and right subtrees
    return isPerfect(root.left, depth, level + 1) and isPerfect(root.right, depth, level + 1)

def is_balanced(root):
    # Helper function to check the balance of the tree
    def check_height_and_balance(node):
        if node is None:
            return 0  # A null node has height 0

        left_height = check_height_and_balance(node.left)
        if left_height == -1:
            return -1  # Left subtree is unbalanced

        right_height = check_height_and_balance(node.right)
        if right_height == -1:
            return -1  # Right subtree is unbalanced

        # If the height difference between the left and right subtrees is greater than 1, the tree is unbalanced
        if abs(left_height - right_height) > 1:
            return -1

        return max(left_height, right_height) + 1

    return check_height_and_balance(root) != -1


# Test cases 

arr = [None, 1, 2, 3, 4, 5, 6]
root = arrayToTree(arr, 1)

print("Test case 1: InOrder Traversal of the tree")
inOrder(root)  # Expected output: 4 2 5 1 6 3
print()

print("Test case 2: Node Count")
print(f"Node Count: {nodeCount(root)}")  # Expected output: 6

target = 5
print("Test case 3: Find the depth of a target node")
print(f"Depth of node {target}: {findDepth(root, target)}")  # Expected output: 2

print("Test case 4: Find the height of the tree")
print(f"Height of the tree: {findHeight(root)}")  # Expected output: 2

print("Test case 5: Check if the tree is full")
print(f"Is the tree full? {isFull(root)}")  # Expected output: False

totalNode = nodeCount(root)
print("Test case 6: Check if the tree is complete")
print(f"Is the tree complete? {isComplete(root, 1, totalNode)}")  # Expected output: True

depth = findHeight(root) + 1  # Calculate the depth of the tree
print("Test case 7: Check if the tree is perfect")
print(f"Is the tree perfect? {isPerfect(root, depth)}")  # Expected output: False

print("Test case 8: Check if the tree is balanced")
print(f"Is the tree balanced? {is_balanced(root)}")  # Expected output: True
