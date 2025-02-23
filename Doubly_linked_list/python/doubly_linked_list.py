class Node:
    def __init__(self, val, next=None, prev=None):
        self.elem = val
        self.next = next
        self.prev = prev

def arrayToDList(arr):
    if not arr:
        return None
    
    head = Node(arr[0])
    tail = head
    for i in range(1, len(arr)):
        newNode = Node(arr[i])
        tail.next = newNode   # Link current tail to the new node
        newNode.prev = tail   # Link new node back to current tail
        tail = newNode        # Update tail to the new node
    return head               # Return the head of the linked list

def printList(head):
    temp = head
    while temp:
        print(temp.elem, end=" <=> ")  # Print current node's element
        temp = temp.next               # Move to the next node
    print("None")                      # Print None at the end

def nodeAt(head, indx):
    temp = head
    count = 0
    while temp:
        if count == indx:
            return temp     # Return node if index matches
        count += 1
        temp = temp.next    # Move to the next node
    return None             # Return None if index is out of bounds

def insertAt(head, val, indx):
    newNode = Node(val)
    
    if indx == 0:
        # Insert at the beginning of the list
        newNode.next = head       # Link newNode to current head
        if head:
            head.prev = newNode   # Link current head back to newNode
        head = newNode            # Update head to newNode
        
    else:
        current = nodeAt(head, indx)
        if current:
            prev = current.prev   # Get the previous node
            
            # Connect newNode between prev and current
            newNode.next = current
            newNode.prev = prev
            
            current.prev = newNode   # Link current node back to newNode
            if prev:
                prev.next = newNode  # Link previous node to newNode
        else:
            print("Index out of bounds")
    return head


# Test Cases
print("Test Case 1:")
listHead1 = arrayToDList([1, 2, 3, 4, 5])
print("Original List:")
printList(listHead1)
print("Inserting 99 at index 1:")
listHead1 = insertAt(listHead1, 99, 1)
print("Modified List:")
printList(listHead1)
print()

print("Test Case 2:")
listHead2 = arrayToDList([10, 20, 30])
print("Original List:")
printList(listHead2)
print("Inserting 0 at index 0:")
listHead2 = insertAt(listHead2, 0, 0)
print("Modified List:")
printList(listHead2)
print()

print("Test Case 3:")
listHead3 = arrayToDList([100, 200, 300, 400])
print("Original List:")
printList(listHead3)
print("Inserting 500 at index 4:")
listHead3 = insertAt(listHead3, 500, 4)
print("Modified List:")
printList(listHead3)
print()

print("Test Case 4:")
listHead4 = arrayToDList([11, 22, 33])
print("Original List:")
printList(listHead4)
print("Inserting 44 at index 3:")
listHead4 = insertAt(listHead4, 44, 3)
print("Modified List:")
printList(listHead4)
print()

print("Test Case 5:")
listHead5 = arrayToDList([])
print("Original List (Empty):")
printList(listHead5)
print("Inserting 999 at index 0 into an empty list:")
listHead5 = insertAt(listHead5, 999, 0)
print("Modified List:")
printList(listHead5)
