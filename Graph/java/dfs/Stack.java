package dfs;

class Node {
    Integer elem; // Stores the element of the node
    Node next; // Reference to the next node

    Node(Integer val) {
        this.elem = val;
        this.next = null;
    }
}

public class Stack {
    private Node top; // Top of the stack, made private to enforce encapsulation

    // Push a new element onto the stack
    public void push(Integer val) {
        Node newNode = new Node(val);
        newNode.next = this.top;
        this.top = newNode;
    }

    // Returns the top element of the stack without removing it
    public Integer peek() {
        if (this.top == null) {
            return -1; // Indicating stack is empty
        }
        return this.top.elem;
    }

    // Removes and returns the top element of the stack
    public Integer pop() {
        if (this.top == null) {
            return null; // Stack is empty
        }
        Integer t1 = this.top.elem;
        this.top = this.top.next;
        return t1;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return this.top == null;
    }
}

