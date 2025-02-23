class Node {
    int elem;
    Node prev;
    Node next;

    // Constructor to initialize Node with value
    Node(int val) {
        this.elem = val;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {

    // Builds a doubly linked list from an array of integers
    public static Node listBuilder(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;  // Return null for empty input array
        }

        Node head = new Node(arr[0]);
        Node tail = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]);
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }
        return head;  // Return the head of the constructed list
    }

    // Prints the elements of the doubly linked list from head to tail
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.elem);
            temp = temp.next;
        }
    }

    // Returns the last node of the doubly linked list
    public static Node getLastNode(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        return temp;  // Return the last node
    }

    // Prints the elements of the doubly linked list from tail to head
    public static void printReverse(Node head) {
        Node temp = getLastNode(head);
        while (temp != null) {
            System.out.println(temp.elem);
            temp = temp.prev;
        }
    }

    // Returns the size (number of nodes) of the doubly linked list
    public static int listSize(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Returns the node at a specified index in the doubly linked list
    public static Node nodeAt(Node head, int indx) {
        if (indx < 0) {
            return null;  // Return null for negative index
        }

        Node temp = head;
        int count = 0;
        while (temp != null) {
            if (count == indx) {
                return temp;
            }
            count++;
            temp = temp.next;
        }
        return null;  // Return null if index is out of bounds
    }

    // Inserts a new node with given value at a specified index in the doubly linked list
    public static Node insertAt(Node head, int val, int indx) {
        if (indx < 0) {
            System.out.println("Index cannot be negative");
            return head;  // Return the unchanged head
        }

        Node newNode = new Node(val);

        if (indx == 0) {
            // Insert at the beginning of the list
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            return newNode;  // Return newNode as the new head
        }

        Node current = nodeAt(head, indx);
        if (current != null) {
            Node prev = current.prev;

            // Connect newNode between prev and current
            newNode.next = current;
            newNode.prev = prev;

            current.prev = newNode;   // Link current node back to newNode
            if (prev != null) {
                prev.next = newNode;  // Link previous node to newNode
            }
        } else {
            System.out.println("Index out of bounds");
        }

        return head;  // Return the unchanged head if index is out of bounds
    }

    // Main method to test the DoublyLinkedList class
    public static void main(String[] args) {
        // Test listBuilder and printReverse
        int[] arr = {1, 2, 3, 4, 5};
        Node head1 = listBuilder(arr);
        System.out.println("Original list:");
        printList(head1);
        System.out.println("List in reverse:");
        printReverse(head1);
        System.out.println();

        // Test listSize
        System.out.println("Size of the list: " + listSize(head1));
        System.out.println();

        // Test nodeAt
        int index = 2;
        Node nodeAtIndex = nodeAt(head1, index);
        if (nodeAtIndex != null) {
            System.out.println("Node at index " + index + ": " + nodeAtIndex.elem);
        } else {
            System.out.println("Node at index " + index + " not found");
        }
        System.out.println();

        // Test insertAt
        int newValue = 99;
        int insertIndex = 1;
        System.out.println("Inserting " + newValue + " at index " + insertIndex);
        head1 = insertAt(head1, newValue, insertIndex);
        System.out.println("Updated list:");
        printList(head1);
    }
}
