class Node {
    /** Node class for a Doubly Circular Linked List. */
    int elem; // Store the value of the node
    Node prev; // Pointer to the previous node
    Node next; // Pointer to the next node

    Node(int val) {
        this.elem = val;
    }
}

class LinkedList {
    /** Doubly Circular Linked List with a dummy head node. */
    Node head; // Dummy head node

    LinkedList() {
        this.head = new Node(0); // Create a dummy head node
        this.head.next = this.head; // Point next to itself (circular)
        this.head.prev = this.head; // Point prev to itself (circular)
    }

    void addVal(int val) {
        Node newNode = new Node(val); // Create a new node with the given value

        Node lastNode = this.head.prev; // Get the last actual node in the list
        lastNode.next = newNode; // Link last node's next to the new node
        newNode.prev = lastNode; // Set new node's prev to the last node
        newNode.next = this.head; // Link new node's next to head (circular)
        this.head.prev = newNode; // Update head's prev to the new node
    }

    void printList() {
        Node temp = this.head.next; // Start from the first actual node
        while (temp != this.head) { // Traverse until we reach the dummy head
            System.out.print(temp.elem + " "); // Print the element
            temp = temp.next; // Move to the next node
        }
        System.out.println();
    }

    void printListReverse() {
        Node temp = this.head.prev; // Start from the last actual node
        while (temp != this.head) { // Traverse until we reach the dummy head
            System.out.print(temp.elem + " "); // Print the element
            temp = temp.prev; // Move to the previous node
        }
        System.out.println();
    }

    void reverseDHCLL() {
        /** Reverse the doubly circular linked list. */
        if (this.head.next == this.head) { // If list is empty, do nothing
            return;
        }

        Node temp = this.head;
        boolean firstPass = true;
        while (temp != this.head || firstPass) {
            firstPass = false;
            Node swap = temp.next;
            temp.next = temp.prev;
            temp.prev = swap;
            temp = temp.prev;
        }
    }
}

public class dhdcl{
    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        
        System.out.println("Initial empty list:");
        l1.printList(); // Should print nothing
        
        l1.addVal(1); // Add value 1
        l1.addVal(2); // Add value 2
        l1.addVal(3); // Add value 3
        
        System.out.println("\nList after adding 1, 2, 3:");
        l1.printList(); // Should print 1 2 3
        System.out.println("Reverse order:");
        l1.printListReverse(); // Should print 3 2 1
        
        l1.reverseDHCLL(); // Reverse the list
        System.out.println("\nList after reversal:");
        l1.printList(); // Should print 3 2 1
        System.out.println("Reverse order:");
        l1.printListReverse(); // Should print 1 2 3
        
        l1.addVal(4); // Add value 4
        l1.addVal(5); // Add value 5
        System.out.println("\nList after adding 4, 5:");
        l1.printList(); // Should print 3 2 1 4 5
        System.out.println("Reverse order:");
        l1.printListReverse(); // Should print 5 4 1 2 3
        
        l1.reverseDHCLL(); // Reverse the list again
        System.out.println("\nList after another reversal:");
        l1.printList(); // Should print 5 4 1 2 3
        System.out.println("Reverse order:");
        l1.printListReverse(); // Should print 3 2 1 4 5
    }
}