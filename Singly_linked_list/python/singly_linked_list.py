class Node:
    def __init__(self, el, ne=None):
        self.elem = el  # Initialize Node with element and optional next node
        self.next = ne

class SinglyLinkedList:
    def __init__(self):
        self.head = None  # Initialize empty linked list

    def array_to_list_builder(self, arr):
        if not arr:
            return  # Return if array is empty
        self.head = Node(arr[0])  # Initialize head with first element
        tail = self.head
        for i in range(1, len(arr)):
            newNode = Node(arr[i])  # Create new node for each element
            tail.next = newNode  # Link current tail to new node
            tail = tail.next  # Update tail to new node

    def print_list(self):
        temp = self.head
        while temp is not None:
            print(temp.elem, end=' -> ')  # Print current element
            temp = temp.next
        print("None")  # Print end of list

    def append_list(self, newElem):
        newNode = Node(newElem)  # Create new node with new element
        if not self.head:
            self.head = newNode  # Set new node as head if list is empty
            return
        temp = self.head
        while temp.next is not None:
            temp = temp.next  # Traverse to the end of the list
        temp.next = newNode  # Append new node at the end

    def prepend(self, newElem):
        newNode = Node(newElem)  # Create new node with new element
        newNode.next = self.head  # Link new node to current head
        self.head = newNode  # Set new node as head

    def listSize(self):
        temp = self.head
        count = 0
        while temp is not None:
            temp = temp.next
            count += 1  # Count nodes in the list
        return count

    def nodeAt(self, n):
        if n < 0:
            return 'Not found'  # Return if index is negative
        temp = self.head
        indx = 0
        while temp is not None:
            if indx == n:
                return temp  # Return node at given index
            indx += 1
            temp = temp.next
        return 'Not found'  # Return if index is out of range

    def insert(self, indx, val):
        if indx < 0 or self.listSize() < indx:
            return 'Not valid'  # Return if index is invalid
        newNode = Node(val)
        if indx == 0:
            newNode.next = self.head
            self.head = newNode  # Insert new node at the beginning
        else:
            prev = self.nodeAt(indx - 1)
            newNode.next = prev.next
            prev.next = newNode  # Insert new node at the given index

    def remove(self, indx):
        if self.head is None:
            return 'Not valid'  # Return if list is empty
        if indx < 0 or self.listSize() <= indx:
            return 'Not valid'  # Return if index is invalid
        if indx == 0:
            self.head = self.head.next  # Remove head node
        else:
            prev = self.nodeAt(indx - 1)
            if prev.next is not None:
                prev.next = prev.next.next  # Remove node at given index
    
    def reverseList(self):
        # Initialize prevNode to None to store the previous node during reversal
        prevNode = None
        
        # Start from the current head of the linked list
        current = self.head
        
        # Traverse through the linked list until current becomes None (end of the list)
        while current is not None:
            # Store the next node in nextNode before changing current.next
            nextNode = current.next
            
            # Reverse the pointer of current node to point to the previous node
            current.next = prevNode
            
            # Move prevNode and current one step forward in the linked list
            prevNode = current
            current = nextNode
        
        # Update the head of the linked list to point to the last node (which is now the first)
        self.head = prevNode


# Tester code
if __name__ == "__main__":
    
    # Test Case 1: Build list from array and print
    arr = [1, 2, 3, 4, 5]
    list1 = SinglyLinkedList()
    list1.array_to_list_builder(arr)
    print("\nTest Case 1: Build list from array")
    list1.print_list()  # Expected output: 1 -> 2 -> 3 -> 4 -> 5 -> None

    # Test Case 2: Test list size
    print("\nTest Case 2: List size")
    print(list1.listSize())  # Expected output: 5

    # Test Case 3: Access node at index 2
    temp = list1.nodeAt(2)
    print("\nTest Case 3: Access node at index 2")
    print(temp.elem)  # Expected output: 3

    # Test Case 4: Insert value 9 at index 2
    list1.insert(2, 9)
    print("\nTest Case 4: Insert value 9 at index 2")
    list1.print_list()  # Expected output: 1 -> 2 -> 9 -> 3 -> 4 -> 5 -> None

    # Test Case 5: Remove node at index 3
    list1.remove(3)
    print("\nTest Case 5: Remove node at index 3")
    list1.print_list()  # Expected output: 1 -> 2 -> 9 -> 4 -> 5 -> None

    # Test Case 6: Remove node at index 0 (head)
    list1.remove(0)
    print("\nTest Case 6: Remove node at index 0")
    list1.print_list()  # Expected output: 2 -> 9 -> 4 -> 5 -> None

    # Test Case 7: Remove node at index 10 (out of bounds)
    result = list1.remove(10)
    print("\nTest Case 7: Remove node at index 10 (out of bounds)")
    print(result)  # Expected output: Not valid

    # Test Case 8: Reverse a linked list
    arr = [1, 2, 3, 4, 5]
    list8 = SinglyLinkedList()
    list8.array_to_list_builder(arr)
    print("\nTest Case 8: Reverse a linked list")
    list8.reverseList()
    list8.print_list()  # Expected output: 5 -> 4 -> 3 -> 2 -> 1 -> None
