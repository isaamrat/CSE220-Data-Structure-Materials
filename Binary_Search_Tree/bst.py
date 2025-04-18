class Node:
    def __init__(self, val):
        self.elem = val
        self.left = self.right = None

def insert(root, val):
    if root is None:
        return Node(val)
    if val<root.elem:
        root.left = insert(root.left, val)
    elif val>root.elem:
        root.right = insert(root.right, val)
    
    return root

def inOrder(root):
    if root is None:
        return
    inOrder(root.left)
    print(root.elem, end=' ')
    inOrder(root.right)

def createBST(arr):
    root = None
    for val in arr:
        root = insert(root, val)
    return root

def searchKey(root, target):
    if root is None:
        return False
    if root.elem == target:
        return True
    if target < root.elem:
        return searchKey(root.left, target)
    else:
        return searchKey(root.right, target)

def findMin(root):
    if root.left is None:
        return root.elem
    return findMin(root.left)

def removeWithSuccessor(root, target):
    if root is None:
        return None
    if target > root.elem:
        root.right = removeWithSuccessor(root.right, target)
    elif target < root.elem:
        root.left = removeWithSuccessor(root.left, target)
    else:
        if root.left is None:
            return root.right
        elif root.right is None:
            return root.left
        else:
            successor = findMin(root.right)
            root.elem = successor
            root.right = removeWithSuccessor(root.right, successor)
    return root

root = createBST([70, 50, 60, 40, 90, 20, 20, 95, 99, 80, 85, 75])
inOrder(root)
print()
print(searchKey(root, 55))
print(findMin(root))
removeWithSuccessor(root, 99)
inOrder(root)
print()

removeWithSuccessor(root, 40)
inOrder(root)
print()

removeWithSuccessor(root, 90)
inOrder(root)
print()
removeWithSuccessor(root, 70)
inOrder(root)
print()
removeWithSuccessor(root, 75)
inOrder(root)
print()