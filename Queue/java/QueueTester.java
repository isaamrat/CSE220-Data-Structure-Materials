// Node class represents a node in the linked list
class Node {
    Integer elem; // The data stored in the node
    Node next;    // Reference to the next node in the list

    // Constructor to initialize a node with a value
    Node(Integer val) {
        this.elem = val;
    }
}

// LinkedListQueue class implements a queue using a linked list
class LinkedListQueue {
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

public class QueueTester {

    // Method to remove odd elements from a given queue and return a new queue with even elements
    public static LinkedListQueue removeOdd(LinkedListQueue givenQueue) {
        if (givenQueue.isEmpty()) { // If the queue is empty, return null
            return null;
        }
        LinkedListQueue q2 = new LinkedListQueue(); // Create a new queue to store even elements
        while (!givenQueue.isEmpty()) { // Iterate through the given queue
            int val = givenQueue.dequeue(); // Dequeue an element
            if (val % 2 == 0) {            // Check if the element is even
                q2.enqueue(val);           // Enqueue the even element into the new queue
            }
        }
        return q2; // Return the new queue with even elements
    }

    // Method to remove odd elements from the given queue in-place
    public static void removeOddInGivenQ(LinkedListQueue givenQueue) {
        if (givenQueue.isEmpty()) { // If the queue is empty, return
            return;
        }
        givenQueue.enqueue(null);  // Use null as a marker to indicate the end of the queue
        Integer tempVal = givenQueue.dequeue(); // Dequeue the first element
        while (tempVal != null) {  // Iterate until the marker is encountered
            if (tempVal % 2 == 0) { // Check if the element is even
                givenQueue.enqueue(tempVal); // Enqueue the even element back into the queue
            }
            tempVal = givenQueue.dequeue(); // Dequeue the next element
        }
    }

    public static void main(String[] args) {
        LinkedListQueue q1 = new LinkedListQueue();

        // Test Case 1: Test enqueue and isEmpty
        System.out.println("-----Test Case 1: Test enqueue and isEmpty-----");
        System.out.println("Is queue empty? " + q1.isEmpty()); // Expected: true
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);
        q1.enqueue(5);
        q1.enqueue(6);
        System.out.println("Is queue empty after enqueue? " + q1.isEmpty()); // Expected: false

        // Test Case 2: Test peek
        System.out.println("\n-----Test Case 2: Test peek-----");
        System.out.println("Front element (peek): " + q1.peek()); // Expected: 1

        // Test Case 3: Test dequeue
        System.out.println("\n-----Test Case 3: Test dequeue-----");
        System.out.println("Dequeued: " + q1.dequeue()); // Expected: 1
        System.out.println("Dequeued: " + q1.dequeue()); // Expected: 2
        System.out.println("Peek after dequeues: " + q1.peek()); // Expected: 3

        // Test Case 4: Test removeOdd()
        System.out.println("\n-----Test Case 4: Test removeOdd()-----");
        LinkedListQueue q2 = new LinkedListQueue();
        q2.enqueue(1);
        q2.enqueue(2);
        q2.enqueue(3);
        q2.enqueue(4);
        q2.enqueue(5);
        q2.enqueue(6);
        q2 = removeOdd(q2);

        System.out.println("After removeOdd:");
        System.out.println(q2.dequeue()); // Expected: 2
        System.out.println(q2.dequeue()); // Expected: 4
        System.out.println(q2.dequeue()); // Expected: 6

        // Test Case 5: Test removeOddInGivenQ
        System.out.println("\n-----Test Case 5: Test removeOddInGivenQ-----");
        LinkedListQueue q3 = new LinkedListQueue();
        q3.enqueue(7);
        q3.enqueue(8);
        q3.enqueue(9);
        q3.enqueue(10);
        q3.enqueue(11);
        q3.enqueue(12);
        removeOddInGivenQ(q3);

        System.out.println("Queue empty after removeOddInGivenQ? " + q3.isEmpty()); // Expected: false

        System.out.println("After removeOddInGivenQ:");
        System.out.println(q3.dequeue()); // Expected: 8
        System.out.println(q3.dequeue()); // Expected: 10
        System.out.println(q3.dequeue()); // Expected: 12
    }
}