package bfs;

// Node class represents a node in the linked list
class Node {
    Integer elem; // The data stored in the node
    Node next;    // Reference to the next node in the list

    // Constructor to initialize a node with a value
    Node(Integer val) {
        this.elem = val;
    }
}

public class queue {
    private Node front; // Reference to the front of the queue
    private Node rear;  // Reference to the rear of the queue

    // Method to add an element to the rear of the queue
    public void enqueue(Integer val) {
        Node newNode = new Node(val); // Create a new node with the given value
        if (this.rear == null) {      // If the queue is empty
            this.front = newNode;     // Set both front and rear to the new node
            this.rear = newNode;
            return;
        }
        this.rear.next = newNode; // Link the new node to the rear of the queue
        this.rear = newNode;      // Update the rear to the new node
    }

    // Method to remove and return the element at the front of the queue
    public Integer dequeue() {
        if (isEmpty()) {          // If the queue is empty, return null
            return null;
        }
        Integer tempVal = this.front.elem; // Store the value of the front node
        this.front = this.front.next;      // Move the front pointer to the next node
        if (this.front == null) {           // If the queue is now empty
            this.rear = null;               // Set rear to null
        }
        return tempVal; // Return the value of the dequeued node
    }

    // Method to return the element at the front of the queue without removing it
    public Integer peek() {
        if (isEmpty()) { // If the queue is empty, return null
            return null;
        }
        return this.front.elem; // Return the value of the front node
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return this.front == null; // Return true if front is null, otherwise false
    }
}
