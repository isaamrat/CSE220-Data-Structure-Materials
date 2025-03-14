class Node:
    def __init__(self, val):
        self.elem = val  # Value stored in the node
        self.next = None  # Pointer to the next node


class LinkedListQueue:
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

    def peek(self):
        """Return the element at the front of the queue without removing it."""
        if self.isEmpty():
            return None  # Queue is empty
        return self.__front.elem  # Return the front element


def removeOdd(givenQ):
    """Remove odd elements from the given queue and return a new queue with even elements."""
    q2 = LinkedListQueue()
    while not givenQ.isEmpty():
        val = givenQ.dequeue()
        if val % 2 == 0:  # Check if the value is even
            q2.enqueue(val)
    return q2


def removeOddInGivenQ(givenQ):
    """Remove odd elements from the given queue in-place."""
    givenQ.enqueue(None)  # Marker to indicate the end of the queue
    tempVal = givenQ.dequeue()
    while tempVal is not None:
        if tempVal % 2 == 0:  # Check if the value is even
            givenQ.enqueue(tempVal)  # Re-enqueue even values
        tempVal = givenQ.dequeue()


# Test Cases

if __name__ == "__main__":
    # Test Case 1: Enqueue and Dequeue
    Q1 = LinkedListQueue()
    Q1.enqueue(1)
    Q1.enqueue(2)
    Q1.enqueue(3)
    print(Q1.dequeue())  # Output: 1
    print(Q1.dequeue())  # Output: 2
    print(Q1.dequeue())  # Output: 3
    print(Q1.dequeue())  # Output: None (queue is empty)

    # Test Case 2: Check if the queue is empty
    Q2 = LinkedListQueue()
    print(Q2.isEmpty())  # Output: True
    Q2.enqueue(10)
    print(Q2.isEmpty())  # Output: False

    # Test Case 3: Peek at the front element
    Q3 = LinkedListQueue()
    Q3.enqueue(100)
    Q3.enqueue(200)
    print(Q3.peek())  # Output: 100
    Q3.dequeue()
    print(Q3.peek())  # Output: 200

    # Test Case 4: Remove odd elements and return a new queue
    Q4 = LinkedListQueue()
    Q4.enqueue(1)
    Q4.enqueue(2)
    Q4.enqueue(3)
    Q4.enqueue(4)
    Q4 = removeOdd(Q4)
    print(Q4.dequeue())  # Output: 2
    print(Q4.dequeue())  # Output: 4
    print(Q4.dequeue())  # Output: None (queue is empty)

    # Test Case 5: Remove odd elements in-place
    Q5 = LinkedListQueue()
    Q5.enqueue(1)
    Q5.enqueue(2)
    Q5.enqueue(3)
    Q5.enqueue(4)
    removeOddInGivenQ(Q5)
    print(Q5.dequeue())  # Output: 2
    print(Q5.dequeue())  # Output: 4
    print(Q5.dequeue())  # Output: None (queue is empty)
