// Node class represents an element in the doubly linked list
class Node {
    Node prev; // reference to the previous node
    int elem; // value stored in the node
    Node next; // reference to the next node

    // Constructor to create a node with a given value
    Node(int val) {
        this.elem = val;
        this.prev = null;
        this.next = null;
    }
}

// DoublyLinkedList class implements the linked list operations
class DoublyLinkedList {
    Node head; // head of the list

    // Converts an array to a doubly linked list
    public void arrToList(int[] arr) {
        this.head = new Node(arr[0]); // initialize head with the first element
        Node tail = this.head; // maintain a tail pointer for appending

        // Loop through remaining elements and add to the list
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]); // create a new node
            tail.next = newNode; // link current tail to new node
            newNode.prev = tail; // link new node back to current tail
            tail = newNode; // update tail to new node
        }
    }

    // Returns the node at a specific index
    public Node nodeAt(int idx) {
        if (idx < 0) {
            return null; // invalid index
        }
        Node temp = this.head; // start from head
        int count = 0;

        // Traverse list to find the desired index
        while (temp != null) {
            if (count == idx) {
                return temp; // found node
            }
            count += 1;
            temp = temp.next;
        }

        return null; // index out of bounds
    }

    // Inserts a node with value `val` at index `idx`
    public void insert(int idx, int val) {
        Node newNode = new Node(val); // create a new node

        if (idx == 0) {
            // Inserting at the beginning
            newNode.next = this.head; // new node points to current head
            this.head.prev = newNode; // old head points back to new node
            this.head = newNode; // update head to new node
        } else {
            Node prevNode = nodeAt(idx - 1); // get node before insertion point
            if (prevNode != null) {
                Node s = prevNode.next; // node that will come after the new node
                prevNode.next = newNode; // link previous node to new node
                newNode.prev = prevNode; // link new node back to previous

                newNode.next = s; // link new node to next node
                if (s != null) {
                    s.prev = newNode; // link next node back to new node
                }
            }
        }
    }

    // Removes the node at index `idx`
    public void remove(int idx) {
        if (idx == 0) {
            // Remove the head node
            this.head = this.head.next; // move head to next
            if (this.head != null) {
                this.head.prev = null; // new head has no previous
            }
        } else {
            Node prevNode = nodeAt(idx - 1); // get node before the one to remove
            if (prevNode != null && prevNode.next != null) {
                Node s = prevNode.next.next; // get node after the one being removed
                prevNode.next = s; // link previous node to s
                if (s != null) {
                    s.prev = prevNode; // link s back to previous node
                }
            }
        }
    }

    // Prints the list in reverse order
    public void reversePrint() {
        Node temp = this.head;

        // Go to the last node
        while (temp.next != null) {
            temp = temp.next;
        }

        // Traverse backward and print elements
        while (temp != null) {
            System.out.println(temp.elem);
            temp = temp.prev;
        }
    }
}

// Main class to test the DoublyLinkedList (currently empty)
public class doubly_linked_list {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        // Create a doubly linked list from array
        int[] arr = { 10, 20, 30, 40, 50 };
        list.arrToList(arr);
        System.out.println("Original list (reverse print):");
        list.reversePrint(); // Should print: 50, 40, 30, 20, 10

        // Insert at the beginning
        list.insert(0, 5);
        System.out.println("\nAfter inserting 5 at index 0:");
        list.reversePrint(); // Should print: 50, 40, 30, 20, 10, 5

        // Insert in the middle
        list.insert(3, 25);
        System.out.println("\nAfter inserting 25 at index 3:");
        list.reversePrint(); // Should print: 50, 40, 30, 25, 20, 10, 5

        // Insert at the end
        list.insert(7, 60);
        System.out.println("\nAfter inserting 60 at the end:");
        list.reversePrint(); // Should print: 60, 50, 40, 30, 25, 20, 10, 5

        // Remove head
        list.remove(0);
        System.out.println("\nAfter removing element at index 0:");
        list.reversePrint(); // Should not contain 5

        // Remove a middle element
        list.remove(3);
        System.out.println("\nAfter removing element at index 3:");
        list.reversePrint(); // Should not contain 30

        // Remove last element
        list.remove(5);
        System.out.println("\nAfter removing last element:");
        list.reversePrint(); // Should not contain 60
    }
}
