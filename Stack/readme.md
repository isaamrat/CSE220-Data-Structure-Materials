# [Practice Problems](practice_problems.md)

# Stack Implementation in Java and Python

## Introduction to Stack

A **stack** is a linear data structure that follows the **Last In, First Out (LIFO)** principle. This means that the last element added to the stack will be the first one to be removed. Stacks are commonly used in various applications such as parsing expressions, backtracking algorithms, and managing function calls in programming languages.

### Key Operations of a Stack:
1. **Push**: Adds an element to the top of the stack.
2. **Pop**: Removes and returns the top element of the stack.
3. **Peek**: Returns the top element without removing it.
4. **isEmpty**: Checks if the stack is empty.

In this guide, we will implement a stack using a **linked list** in both **Java** and **Python**. We will also provide utility functions to check for balanced parentheses and evaluate postfix expressions.

---

## [Java Implementation](java/StackTester.java)

### Code Explanation

#### 1. **Node Class**
- Represents a node in the linked list.
- Each node stores:
  - `elem`: The value of the node.
  - `next`: A reference to the next node in the list.

```java
class Node {
    Object elem; // Stores the element of the node
    Node next; // Reference to the next node

    Node(Object val) {
        this.elem = val;
        this.next = null;
    }
}
```

#### 2. **Stack Class**
- Implements the stack using a linked list.
- **Attributes**:
  - `top`: A reference to the top node of the stack.
- **Methods**:
  - `push(Object val)`: Adds a new element to the top of the stack.
  - `pop()`: Removes and returns the top element. Returns `null` if the stack is empty.
  - `peek()`: Returns the top element without removing it. Returns `-1` if the stack is empty.
  - `isEmpty()`: Checks if the stack is empty.

```java
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
```

#### 3. **Utility Functions**
- **`paranthesisChecker(String eqn)`**: Checks if the parentheses in a given equation are balanced.
  - Uses a stack to track opening parentheses.
  - Returns `true` if balanced, otherwise `false`.

- **`postFixEvaluation(String eqn)`**: Evaluates a postfix expression.
  - Uses a stack to store operands and compute results based on operators.

```java
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
```

---

## [Python Implementation](python/stack.py)

### Code Explanation

#### 1. **Node Class**
- Represents a node in the linked list.
- Each node stores:
  - `elem`: The value of the node.
  - `next`: A reference to the next node in the list.

```python
class Node:
    def __init__(self, val):  # Initialize a node with a value and a pointer to the next node
        self.elem = val
        self.next = None
```

#### 2. **Stack Class**
- Implements the stack using a linked list.
- **Attributes**:
  - `__top`: A private reference to the top node of the stack.
- **Methods**:
  - `push(val)`: Adds a new element to the top of the stack.
  - `pop()`: Removes and returns the top element. Returns `None` if the stack is empty.
  - `peek()`: Returns the top element without removing it. Returns `None` if the stack is empty.
  - `isEmpty()`: Checks if the stack is empty.

```python
class Stack:
    def __init__(self):  # Initialize an empty stack with a private top attribute
        self.__top = None

    def push(self, val):  # Push a new value onto the stack
        newNode = Node(val)
        newNode.next = self.__top  # New node points to the current top
        self.__top = newNode  # Update top to new node

    def pop(self):  # Remove and return the top element, return None if empty
        if self.__top is None:
            return None
        temp = self.__top.elem  # Store top element
        self.__top = self.__top.next  # Move top to next node
        return temp
    
    def peek(self):  # Return top element without removing it, return None if empty
        return None if self.__top is None else self.__top.elem
    
    def isEmpty(self):  # Check if stack is empty
        return self.__top is None
```

#### 3. **Utility Functions**
- **`paranthesisCheck(eqn)`**: Checks if the parentheses in a given equation are balanced.
  - Uses a stack to track opening parentheses.
  - Returns `"It is balanced!"` if balanced, otherwise `"Not Balanced!"`.

- **`postFixEvaluation(eqn)`**: Evaluates a postfix expression.
  - Uses a stack to store operands and compute results based on operators.

```python
# Function to check if parentheses are balanced
def paranthesisCheck(eqn):
    st = Stack()
    for sym in eqn:
        if sym == '(':
            st.push(sym)  # Push opening parenthesis
        elif sym == ')':
            if st.pop() is None:  # Pop and check if stack is empty
                return "Not Balanced!"
    return "It is balanced!" if st.isEmpty() else "Not Balanced!"

# Function to evaluate a postfix expression
def postFixEvaluation(eqn):
    st = Stack()
    opeartor = ['+','-','/','*']
    for sym in eqn:
        if sym in opeartor:
            t1 = st.pop()
            t2 = st.pop()
            val = 0
            if sym == '+':
                val = t2+t1
            elif sym == '-':
                val = t2-t1
            elif sym == '/':
                val = t2/t1
            else:
                val = t2*t1
            st.push(val)
        else:
            st.push(int(sym))  
    temp = st.pop() 
    return temp

# Test Cases
if __name__ == "__main__":
    stack = Stack()
    stack.push(10)
    stack.push(20)
    stack.push(30)
    print("Peek after pushes:", stack.peek())  # Expected: 30
    print("Popped element:", stack.pop())  # Expected: 30
    print("Peek after pop:", stack.peek())  # Expected: 20
    print("Is stack empty?:", stack.isEmpty())  # Expected: False
    stack.pop()
    stack.pop()
    print("Is stack empty after popping all elements?:", stack.isEmpty())  # Expected: True

    eqn1 = "(2+(3-4)+6(7)+8)"
    eqn2 = "(2+(3-4)+6(7)+8"
    print("Equation 1 is balanced?:", paranthesisCheck(eqn1))  # Expected: It is balanced!
    print("Equation 2 is balanced?:", paranthesisCheck(eqn2))  # Expected: Not Balanced!

    eqn3 = "4572+-*"
    eqn4 = "23+5*"
    print("Postfix Evaluation (4572+-*):", postFixEvaluation(eqn3))  # Expected: -16
    print("Postfix Evaluation (23+5*):", postFixEvaluation(eqn4))  # Expected: 25
```

---

## Summary

- Both **Java** and **Python** implementations use a linked list to create a stack.
- The stack supports basic operations: `push`, `pop`, `peek`, and `isEmpty`.
- Utility functions are provided to check for balanced parentheses and evaluate postfix expressions.
- Test cases demonstrate the functionality of the stack and utility functions.
