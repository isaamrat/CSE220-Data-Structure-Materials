class Node:
    def __init__(self,val):
        self.elem = val
        self.prev = None
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = Node(None)
        self.head.next = self.head
        self.head.prev = self.head
    
    def addVal(self, val):
        newNode = Node(val)

        lastNode = self.head.prev
        lastNode.next = newNode
        newNode.prev = lastNode
        newNode.next = self.head
        self.head.prev = newNode


    def printList(self):
        temp = self.head.next
        while temp != self.head:
            print(temp.elem)
            temp = temp.next

l1 = LinkedList()
l1.addVal(1)
l1.addVal(2)
l1.addVal(3)

l1.printList()