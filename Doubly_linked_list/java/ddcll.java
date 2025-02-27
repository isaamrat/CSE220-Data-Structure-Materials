class Node{
    Node prev;
    int elem;
    Node next;
    Node(int val){
        this.elem = val;
    }
}

class DummyHeadedDoublyCircularLinkedList{
    Node head;
    DummyHeadedDoublyCircularLinkedList(){
        this.head = new Node(0);
        this.head.next = this.head;
        this.head.prev = this.head;
    }

    public void addVal(int val){
        Node newNode = new Node(val);

        Node lastNode = this.head.prev;
        lastNode.next = newNode;
        newNode.prev = lastNode;
        newNode.next = this.head;
        this.head.prev = newNode;
    }

    public void printList(){
        Node temp = this.head.next;

        while(temp != this.head){
            System.out.println(temp.elem);
            temp = temp.next;
        }
    }
}

public class ddcll{
    public static void main(String[] args){
        DummyHeadedDoublyCircularLinkedList list1 = new DummyHeadedDoublyCircularLinkedList();
        list1.addVal(1);
        list1.addVal(2);
        list1.addVal(3);

        list1.printList();
    }
}