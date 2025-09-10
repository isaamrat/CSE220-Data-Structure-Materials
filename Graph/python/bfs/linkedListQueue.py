class Node:
    def __init__(self, val):
        self.elem = val  # Value stored in the node
        self.next = None  # Pointer to the next node


class Queue:
    def __init__(self):
        self.__front = None  # Front of the queue (private)
        self.__rear = None  # Rear of the queue (private)

    def enqueue(self, val):
        """Add an element to the rear of the queue."""
        newNode = Node(val)

        if self.__rear is None:  # If the queue is empty
            self.__front = newNode
            self.__rear = newNode
            return

        self.__rear.next = newNode  # Link the new node to the rear
        self.__rear = newNode  # Update the rear pointer

    def dequeue(self):
        """Remove and return the element from the front of the queue."""
        if self.isEmpty():
            return None  # Queue is empty

        tempVal = self.__front.elem  # Store the value to be returned
        self.__front = self.__front.next  # Move the front pointer to the next node

        if self.__front is None:  # If the queue is now empty
            self.__rear = None  # Update the rear pointer

        return tempVal  # Return the dequeued value

    def isEmpty(self):
        """Check if the queue is empty."""
        if self.__rear is None:  # Queue is empty if rear is None
            return True
        else:
            return False