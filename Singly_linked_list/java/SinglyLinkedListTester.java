class Node {
    int elem; // Data stored in the node
    Node next; // Reference to the next node in the linked list

    // Constructor to initialize a node with given element
    Node(int el) {
        this.elem = el; // Set the element of the node
        this.next = null; // Initialize next pointer to null
    }
}

class SinglyLinkedList {
    Node head;

    // Converts an array into a linked list without tail
    public void arrayToListBuilderWithoutTail(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        this.head = new Node(arr[0]); // Create the head node with the first element of the array
        for (int i = 1; i < arr.length; i++) {
            append(arr[i]);
        }
    }



    // Converts an array into a linked list
    public void arrayToListBuilder(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        this.head = new Node(arr[0]); // Create the head node with the first element of the array
        Node tail = this.head; // Initialize the tail pointer to the head node
        for (int i = 1; i < arr.length; i++) {
            Node newNode = new Node(arr[i]); // Create a new node for each element in the array
            tail.next = newNode; // Link the current tail to the new node
            tail = tail.next; // Move the tail pointer to the new node
        }
    }

    // Prints the elements of the linked list
    public void printList() {
        Node temp = this.head; // Start from the head of the linked list
        System.out.print("Linked List: ");
        while (temp != null) { // Traverse through the linked list until the end
            System.out.print(temp.elem + " -> "); // Print the element of the current node
            temp = temp.next; // Move to the next node
        }
        System.out.println("null");
    }

    // Appends an element to the end of the linked list
    public void append(int el) {
        Node newNode = new Node(el); // Create a new node with the given element
        if (this.head == null) { // If the list is empty, set the new node as the head
            this.head = newNode;
            return;
        }
        Node temp = this.head; // Start traversal from the head
        while (temp.next != null) { // Find the last node in the list
            temp = temp.next;
        }
        temp.next = newNode; // Append the new node to the end of the list
    }

    // Prepends an element to the beginning of the linked list
    public void prepend(int el) {
        Node newNode = new Node(el); // Create a new node with the given element
        newNode.next = this.head; // Link the new node to the current head
        this.head = newNode; // Set the new node as the new head
    }

    // Returns the size of the linked list
    public int listSize() {
        Node temp = this.head; // Start traversal from the head
        int count = 0;
        while (temp != null) { // Count nodes until the end of the list
            temp = temp.next;
            count += 1;
        }
        return count; // Return the size of the list
    }

    // Returns the node at a specific index
    public Node nodeAt(int indx) {
        if (indx < 0) {
            return null;
        }
        Node temp = this.head; // Start traversal from the head
        int count = 0;
        while (temp != null) { // Traverse until the end of the list or the desired index
            if (count == indx) {
                return temp; // Return the node at the desired index
            }
            count += 1;
            temp = temp.next;
        }
        return null; // Return null if the index is out of bounds
    }

    // Inserts an element at a specific index
    public String insert(int indx, int val) {
        if (indx < 0 || indx > listSize()) { // Check if the index is valid
            return "Invalid";
        }
        Node newNode = new Node(val); // Create a new node with the given value
        if (indx == 0) { // Insert at the beginning if index is 0
            newNode.next = this.head;
            this.head = newNode;
        } else {
            Node prev = nodeAt(indx - 1); // Find the node before the insertion point
            if (prev == null) {
                return "Invalid";
            }
            newNode.next = prev.next; // Link the new node to the next node of the previous node
            prev.next = newNode; // Link the previous node to the new node
        }
        return "Successful";
    }

    // Removes an element at a specific index
    public String remove(int indx) {
        if (indx < 0) { // Check if the index is valid
            return "Invalid";
        }
        if (indx == 0) { // Remove the head node if index is 0
            this.head = this.head.next;
        } else {
            Node prev = nodeAt(indx - 1); // Find the node before the node to be removed
            if (prev == null) {
                return "Invalid";
            }
            Node nextNode = prev.next.next; // Find the node after the node to be removed
            prev.next = nextNode; // Link the previous node to the next node, skipping the removed node
        }
        return "Successful";
    }

    public void reverseList() {
        Node prevNode = null;  // Initialize prevNode to store the previous node during reversal
        Node current = this.head;  // Start from the current head of the linked list
        
        // Traverse through the linked list until current becomes null (end of the list)
        while (current != null) {
            Node nextNode = current.next;  // Store the next node in nextNode before changing current.next
            
            current.next = prevNode;  // Reverse the pointer of current node to point to the previous node
            
            // Move prevNode and current one step forward in the linked list
            prevNode = current;
            current = nextNode;
        }
        
        // Update the head of the linked list to point to the last node (which is now the first)
        this.head = prevNode;
    }
    
}

public class SinglyLinkedListTester {
    public static void main(String[] args) {
        // Test Case 1: Build list from array without tail
        int[] arr1 = { 1, 2, 3, 4, 5 };
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.arrayToListBuilderWithoutTail(arr1);
        System.out.println("Test Case 1: Build list from array without tail");
        list1.printList(); // Output: Linked List: 1 -> 2 -> 3 -> 4 -> 5 -> null

        // Test Case 2: Build list from array
        int[] arr = { 1, 2, 3, 4, 5 };
        SinglyLinkedList list = new SinglyLinkedList();
        list.arrayToListBuilder(arr);
        System.out.println("Test Case 2: Build list from array");
        list.printList(); // Output: Linked List: 1 -> 2 -> 3 -> 4 -> 5 -> null

        // Test Case 3: Append an element
        list.append(6);
        System.out.println("\nTest Case 3: Append an element");
        list.printList(); // Output: Linked List: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null

        // Test Case 4: Prepend an element
        list.prepend(0);
        System.out.println("\nTest Case 4: Prepend an element");
        list.printList(); // Output: Linked List: 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null

        // Test Case 5: Insert an element at index 3
        list.insert(3, 99);
        System.out.println("\nTest Case 5: Insert an element at index 3");
        list.printList(); // Output: Linked List: 0 -> 1 -> 2 -> 99 -> 3 -> 4 -> 5 -> 6 -> null

        // Test Case 6: Remove an element at index 2
        list.remove(2);
        System.out.println("\nTest Case 6: Remove an element at index 2");
        list.printList(); // Output: Linked List: 0 -> 1 -> 99 -> 3 -> 4 -> 5 -> 6 -> null

        // Test Case 7: Get size of the list
        System.out.println("\nTest Case 7: Get size of the list");
        System.out.println("Size of the list: " + list.listSize()); // Output: Size of the list: 7

        // Test Case 8: Get node at index 4
        Node node = list.nodeAt(4);
        if (node != null) {
            System.out.println("\nTest Case 8: Get node at index 4");
            System.out.println("Element at index 4: " + node.elem); // Output: Element at index 4: 4
        }

        // Test Case 9: Reverse a linked list
        int[] arr2 = { 1, 2, 3, 4, 5 };
        SinglyLinkedList list8 = new SinglyLinkedList();
        list8.arrayToListBuilder(arr2);
        System.out.println("\nTest Case 9: Reverse a linked list");
        list8.reverseList();
        list8.printList(); // Output: Linked List: 5 -> 4 -> 3 -> 2 -> 1 -> null
    }
}