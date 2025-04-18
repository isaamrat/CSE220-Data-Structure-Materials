class Node:
    def __init__(self, val):
        self.elem = val
        self.left = self.right = None

def insert(root, val):
    if root is None:
        return Node(val)
    if val > root.elem:
        root.right = insert(root.right, val)
    elif val < root.elem:
        root.left = insert(root.left, val)
    return root

def treeFromArr(arr):
    root = None
    for val in arr:
        root = insert(root, val)
    return root

def inOrder(root):
    if root is None:
        return
    inOrder(root.left)
    print(root.elem, end=' ')
    inOrder(root.right)

def findMin(root):
    if root.left is None:
        return root.elem
    return findMin(root.left)

def searchVal(root, target):
    if root is None:
        return False
    if root.elem == target:
        return True
    if target < root.elem:
        return searchVal(root.left, target)
    else:
        return searchVal(root.right, target)

def removeNode(root, target):
    if root is None:
        return None
    if target > root.elem:
        root.right = removeNode(root.right, target)
    elif target < root.elem:
        root.left = removeNode(root.left, target)
    else:
        if root.left is None:
            return root.right
        elif root.right is None:
            return root.left
        minimum = findMin(root.right)
        root.elem = minimum
        root.right = removeNode(root.right, minimum)
    return root



arr = [70, 50, 40, 90, 20, 95, 99, 80, 85, 75]
root = treeFromArr(arr)
inOrder(root)
print()
print(findMin(root))

print(searchVal(root, 199))
    