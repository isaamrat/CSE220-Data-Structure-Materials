class Node:
    def __init__(self, val):
        self.prev = None  # reference to the previous node
        self.elem = val   # value stored in the node
        self.next = None  # reference to the next node


class DoublyLinkedList:
    def __init__(self):
        self.head = None  # head of the list

    # Converts a list to a doubly linked list
    def arr_to_list(self, arr):
        if not arr:
            return
        self.head = Node(arr[0])
        tail = self.head

        for i in range(1, len(arr)):
            new_node = Node(arr[i])
            tail.next = new_node
            new_node.prev = tail
            tail = new_node

    # Returns the node at a specific index
    def node_at(self, idx):
        if idx < 0:
            return None
        temp = self.head
        count = 0
        while temp:
            if count == idx:
                return temp
            count += 1
            temp = temp.next
        return None

    # Inserts a node with value `val` at index `idx`
    def insert(self, idx, val):
        new_node = Node(val)
        if idx == 0:
            new_node.next = self.head
            if self.head:
                self.head.prev = new_node
            self.head = new_node
        else:
            prev_node = self.node_at(idx - 1)
            if prev_node:
                s = prev_node.next
                prev_node.next = new_node
                new_node.prev = prev_node
                new_node.next = s
                if s:
                    s.prev = new_node

    # Removes the node at index `idx`
    def remove(self, idx):
        if idx == 0 and self.head:
            self.head = self.head.next
            if self.head:
                self.head.prev = None
        else:
            prev_node = self.node_at(idx - 1)
            if prev_node and prev_node.next:
                s = prev_node.next.next
                prev_node.next = s
                if s:
                    s.prev = prev_node

    # Prints the list in reverse order
    def reverse_print(self):
        temp = self.head
        if not temp:
            return

        while temp.next:
            temp = temp.next

        while temp:
            print(temp.elem)
            temp = temp.prev


# Testing the doubly linked list
if __name__ == "__main__":
    dll = DoublyLinkedList()

    # Create a doubly linked list from array
    arr = [10, 20, 30, 40, 50]
    dll.arr_to_list(arr)
    print("Original list (reverse print):")
    dll.reverse_print()

    # Insert at the beginning
    dll.insert(0, 5)
    print("\nAfter inserting 5 at index 0:")
    dll.reverse_print()

    # Insert in the middle
    dll.insert(3, 25)
    print("\nAfter inserting 25 at index 3:")
    dll.reverse_print()

    # Insert at the end
    dll.insert(7, 60)
    print("\nAfter inserting 60 at the end:")
    dll.reverse_print()

    # Remove head
    dll.remove(0)
    print("\nAfter removing element at index 0:")
    dll.reverse_print()

    # Remove a middle element
    dll.remove(3)
    print("\nAfter removing element at index 3:")
    dll.reverse_print()

    # Remove last element
    dll.remove(5)
    print("\nAfter removing last element:")
    dll.reverse_print()
