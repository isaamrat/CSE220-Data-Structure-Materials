class Node {
    Object elem; // Stores the element of the node
    Node next; // Reference to the next node

    Node(Object val) {
        this.elem = val;
        this.next = null;
    }
}

class Stack {
    private Node top; // Top of the stack, made private to enforce encapsulation

    // Push a new element onto the stack
    public void push(Object val) {
        Node newNode = new Node(val);
        newNode.next = this.top;
        this.top = newNode;
    }

    // Returns the top element of the stack without removing it
    public Object peek() {
        if (this.top == null) {
            return -1; // Indicating stack is empty
        }
        return this.top.elem;
    }

    // Removes and returns the top element of the stack
    public Object pop() {
        if (this.top == null) {
            return null; // Stack is empty
        }
        Object t1 = this.top.elem;
        this.top = this.top.next;
        return t1;
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return this.top == null;
    }
}

public class StackTester {
    // Function to check if parentheses are balanced
    public static boolean paranthesisChecker(String eqn) {
        Stack st = new Stack();
        for (int i = 0; i < eqn.length(); i++) {
            if (eqn.charAt(i) == '(') {
                st.push('(');
            } else if (eqn.charAt(i) == ')') {
                if (st.pop() == null) {
                    return false; // Unmatched closing parenthesis
                }
            }
        }
        return st.isEmpty(); // If stack is empty, parentheses are balanced
    }

    // Function to evaluate a postfix expression
    public static int postFixEvaluation(String eqn) {
        Stack st = new Stack();
        String operators = "+-/*";
        for (int i = 0; i < eqn.length(); i++) {
            char sym = eqn.charAt(i);
            if (operators.indexOf(sym) != -1) { // Check if sym is an operator
                int t1 = (int) st.pop(); // Pop first operand
                int t2 = (int) st.pop(); // Pop second operand
                int val = 0;
                if (sym == '+') {
                    val = t2 + t1;
                } else if (sym == '-') {
                    val = t2 - t1;
                } else if (sym == '/') {
                    val = t2 / t1;
                } else if (sym == '*') {
                    val = t2 * t1;
                }
                st.push(val);
            } else {
                st.push((int)sym - 48); // Push operand onto stack
            }
        }
        return (int) st.pop();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        
        // Testing push function
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Peek after pushes: " + stack.peek()); // Expected: 30
        
        // Testing pop function
        System.out.println("Popped element: " + stack.pop()); // Expected: 30
        System.out.println("Peek after pop: " + stack.peek()); // Expected: 20
        
        // Testing isEmpty function
        System.out.println("Is stack empty?: " + stack.isEmpty()); // Expected: false
        stack.pop();
        stack.pop();
        System.out.println("Is stack empty after popping all elements?: " + stack.isEmpty()); // Expected: true

        // Testing parentheses checker
        String eqn1 = "a+(b-c)-(d+(e))";
        String eqn2 = "(a+b*(c-d)"; // Unbalanced
        System.out.println("Equation 1 is balanced?: " + paranthesisChecker(eqn1)); // Expected: true
        System.out.println("Equation 2 is balanced?: " + paranthesisChecker(eqn2)); // Expected: false

        // Testing postfix evaluation
        String eqn3 = "4572+-*";
        String eqn4 = "23+5*";
        System.out.println("Postfix Evaluation (4572+-*): " + postFixEvaluation(eqn3)); // Expected: -16
        System.out.println("Postfix Evaluation (23+5*): " + postFixEvaluation(eqn4)); // Expected: 25
    }
}
