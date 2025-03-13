class Node:
    def __init__(self, val):  # Initialize a node with a value and a pointer to the next node
        self.elem = val
        self.next = None

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
