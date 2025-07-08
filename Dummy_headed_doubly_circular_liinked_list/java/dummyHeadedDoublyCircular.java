// Node class represents an element in the doubly circular linked list
class Node {
    Node prev; // reference to the previous node
    Integer elem; // value stored in the node
    Node next; // reference to the next node

    // Constructor to create a node with a given value
    Node(Integer val) {
        this.elem = val;
        this.prev = null;
        this.next = null;
    }
}

public class dummyHeadedDoublyCircular {

    // Converts an array into a dummy-headed doubly circular linked list
    public static Node arrToDHDCL(int[] arr) {
        Node head = new Node(null); // create dummy head node
        head.next = head; // point next of dummy to itself
        head.prev = head; // point prev of dummy to itself

        for (int i = 0; i < arr.length; i++) {
            Node newNode = new Node(arr[i]); // create new node
            Node lastNode = head.prev; // last actual node
            newNode.next = head; // new node's next points to dummy head
            newNode.prev = lastNode; // new node's prev points to last node
            lastNode.next = newNode; // last node's next points to new node
            head.prev = newNode; // dummy head's prev updated to new node
        }
        return head; // return head of list
    }

    // Prints the doubly circular linked list in a structured format
    public static void printList(Node head) {
        Node temp = head;
        System.out.print("[HEAD]"); // starting point
        temp = temp.next; // move to first actual node
        while (temp != head) {
            System.out.print(" <-> [" + temp.elem + "]");
            temp = temp.next;
        }
        System.out.println(" -> ⟳"); // shows circular nature
    }

    // Returns the node at a given index (0-based), or null if out of bounds
    public static Node nodeAt(Node head, int index) {
        Node temp = head.next; // start from first actual node
        int count = 0;
        while (temp != head) {
            if (count == index) {
                return temp; // return node at index
            }
            temp = temp.next;
            count++;
        }
        return null; // return null if index is out of bounds
    }

    // Inserts a new node with given value at given index (0-based)
    public static void insert(Node head, int index, int value) {
        Node target = nodeAt(head, index); // find the node at the index
        if (target == null) {
            return; // invalid index
        }
        Node newNode = new Node(value); // create new node

        Node prevNode = target.prev; // node before insertion point

        // Pointer assignments
        newNode.next = target; // new node points to target as next
        newNode.prev = prevNode; // new node points to previous node as prev
        prevNode.next = newNode; // previous node now points to new node
        target.prev = newNode; // target's prev points back to new node
    }

    // Removes a node at a given index (0-based)
    public static void remove(Node head, int index) {
        Node target = nodeAt(head, index); // find the node at index
        if (target != null) { // make sure it's not out of bounds
            Node prevNode = target.prev;
            Node nextNode = target.next;

            // Pointer assignments
            prevNode.next = nextNode; // previous node skips over target
            nextNode.prev = prevNode; // next node links back to previous
        }
    }

    // Removes all elements that are a multiple of `mul`
    public static void removeMultiple(Node head, int mul) {
        Node temp = head.next; // start from first element
        while (temp != head) {
            Node nextNode = temp.next; // store next before potential removal
            if (temp.elem % mul == 0) { // check divisibility
                Node prevNode = temp.prev; // get previous node
                prevNode.next = nextNode; // unlink current node from list
                nextNode.prev = prevNode; // link next node to previous
            }
            temp = nextNode; // move to next node
        }
    }

    // Tester method
    public static void main(String[] args) {
        int[] arr = { 5, 8, 10, 50, 9 };

        // Test arrToDHDCL and printList
        System.out.println("Original List:");
        Node head = arrToDHDCL(arr);
        printList(head);

        // Test insert
        System.out.println("\nAfter inserting 99 at index 1:");
        insert(head, 1, 99);
        printList(head);

        // Test remove
        System.out.println("\nAfter removing element at index 2:");
        remove(head, 2);
        printList(head);

        // Test nodeAt
        System.out.println("\nTesting nodeAt function:");
        Node node = nodeAt(head, 1);
        if (node != null) {
            System.out.println("Element at index 1 is: " + node.elem);
        } else {
            System.out.println("Index out of bounds.");
        }

        // Test insert at invalid index
        System.out.println("\nTrying to insert at invalid index 10:");
        insert(head, 10, 100);
        printList(head); // should be unchanged

        // Test remove at invalid index
        System.out.println("\nTrying to remove at invalid index 10:");
        remove(head, 10);
        printList(head); // should be unchanged

        // Test removeMultiple
        System.out.println("\nAfter removing multiples of 5:");
        removeMultiple(head, 5);
        printList(head);
    }
}
