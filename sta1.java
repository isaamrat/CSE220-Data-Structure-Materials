class Node{
    int elem;
    Node next;
    Node(int val){
        this.elem = val;
        this.next = null;
    }
}

class Stack{
    Node top;

    public void push(int val){
        Node newNode = new Node(val);
        newNode.next = this.top;
        this.top = newNode;
    }

    public int peek(){
        if (this.top == null ){
            return -1;
        }
        return this.top.elem;
    }


}

public class sta1 {
    public static void main(String[] args){
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        st.peek();
    }
}
