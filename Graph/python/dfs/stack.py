class Node:
    def __init__(self, val):  # Initialize a node with a value and a pointer to the next node
        self.elem = val
        self.next = None

class Stack:
    def __init__(self):  # Initialize an empty stack with a private top attribute
        self.__top = None

    def push(self, val):  # Push a new value onto the stack
        newNode = Node(val)
        newNode.next = self.__top  # New node points to the current top
        self.__top = newNode  # Update top to new node

    def pop(self):  # Remove and return the top element, return None if empty
        if self.__top is None:
            return None
        temp = self.__top.elem  # Store top element
        self.__top = self.__top.next  # Move top to next node
        return temp
    
    def peek(self):  # Return top element without removing it, return None if empty
        return None if self.__top is None else self.__top.elem
    
    def isEmpty(self):  # Check if stack is empty
        return self.__top is None

