class Node:
    """Node class for a Doubly Circular Linked List."""
    def __init__(self, val):
        self.elem = val  # Store the value of the node
        self.prev = None  # Pointer to the previous node
        self.next = None  # Pointer to the next node

class LinkedList:
    """Doubly Circular Linked List with a dummy head node."""
    def __init__(self):
        self.head = Node(None)  # Create a dummy head node
        self.head.next = self.head  # Point next to itself (circular)
        self.head.prev = self.head  # Point prev to itself (circular)
    
    def addVal(self, val):
        newNode = Node(val)  # Create a new node with the given value

        lastNode = self.head.prev  # Get the last actual node in the list
        lastNode.next = newNode  # Link last node's next to the new node
        newNode.prev = lastNode  # Set new node's prev to the last node
        newNode.next = self.head  # Link new node's next to head (circular)
        self.head.prev = newNode  # Update head's prev to the new node

    def printList(self):
        temp = self.head.next  # Start from the first actual node
        while temp != self.head:  # Traverse until we reach the dummy head
            print(temp.elem, end=' ')  # Print the element
            temp = temp.next  # Move to the next node
        print()
    
    def printListReverse(self):
        temp = self.head.prev  # Start from the last actual node
        while temp != self.head:  # Traverse until we reach the dummy head
            print(temp.elem, end=' ')  # Print the element
            temp = temp.prev  # Move to the previous node
        print()
    
    def reverseDHCLL(self):
        """Reverse the dummy headed doubly circular linked list."""
        if self.head.next == self.head:  # If list is empty, do nothing
            return

        temp = self.head
        
        # Swap the next and prev pointers for each node
        first_pass = True
        while temp != self.head or first_pass:
            first_pass = False
            temp2 = temp.next
            temp.next = temp.prev  # Swap pointers
            temp.prev = temp2
            temp = temp.prev  # Move to the next node (previously next)

    # Test cases
if __name__ == "__main__":
    l1 = LinkedList()
    
    print("Initial empty list:")
    l1.printList()  # Should print nothing
    
    l1.addVal(1)  # Add value 1
    l1.addVal(2)  # Add value 2
    l1.addVal(3)  # Add value 3
    
    print("\nList after adding 1, 2, 3:")
    l1.printList()  # Should print 1 2 3
    print("Reverse order:")
    l1.printListReverse()  # Should print 3 2 1
    
    l1.reverseDHCLL()  # Reverse the list
    print("\nList after reversal:")
    l1.printList()  # Should print 3 2 1
    print("Reverse order:")
    l1.printListReverse()  # Should print 1 2 3
    
    l1.addVal(4)  # Add value 4
    l1.addVal(5)  # Add value 5
    print("\nList after adding 4, 5:")
    l1.printList()  # Should print 3 2 1 4 5
    print("Reverse order:")
    l1.printListReverse()  # Should print 5 4 1 2 3
    
    l1.reverseDHCLL()  # Reverse the list again
    print("\nList after another reversal:")
    l1.printList()  # Should print 5 4 1 2 3
    print("Reverse order:")
    l1.printListReverse()  # Should print 3 2 1 4 5
