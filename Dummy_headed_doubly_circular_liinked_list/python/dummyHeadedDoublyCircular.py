# Node class represents an element in the doubly circular linked list
class Node:
    def __init__(self, val):
        self.prev = None  # reference to the previous node
        self.elem = val   # value stored in the node
        self.next = None  # reference to the next node

# Converts an array into a dummy-headed doubly circular linked list
def arr_to_dhdcl(arr):
    head = Node(None)  # create dummy head node
    head.next = head   # point next of dummy to itself
    head.prev = head   # point prev of dummy to itself

    for i in range(len(arr)):
        new_node = Node(arr[i])     # create new node
        last_node = head.prev       # last actual node

        new_node.next = head        # new node's next points to dummy head
        new_node.prev = last_node   # new node's prev points to last node
        last_node.next = new_node   # last node's next points to new node
        head.prev = new_node        # dummy head's prev updated to new node

    return head  # return head of list

# Prints the doubly circular linked list in a structured format
def print_list(head):
    temp = head
    print("[HEAD]", end="")       # starting point
    temp = temp.next              # move to first actual node
    while temp != head:
        print(f" <-> [{temp.elem}]", end="")
        temp = temp.next
    print(" -> ⟳")                # shows circular nature

# Returns the node at a given index (0-based), or None if out of bounds
def node_at(head, index):
    temp = head.next              # start from first actual node
    count = 0
    while temp != head:
        if count == index:
            return temp           # return node at index
        count += 1
        temp = temp.next
    return None                   # return None if index is out of bounds

# Inserts a new node with given value at given index (0-based)
def insert(head, index, value):
    target = node_at(head, index)  # find the node at the index
    if target is None:
        return                     # invalid index

    new_node = Node(value)         # create new node
    prev_node = target.prev        # node before insertion point

    # Pointer assignments
    new_node.next = target         # new node points to target as next
    new_node.prev = prev_node      # new node points to previous node as prev
    prev_node.next = new_node      # previous node now points to new node
    target.prev = new_node         # target's prev points back to new node

# Removes a node at a given index (0-based)
def remove(head, index):
    target = node_at(head, index)  # find the node at index
    if target is not None:         # make sure it's not out of bounds
        prev_node = target.prev
        next_node = target.next

        # Pointer assignments
        prev_node.next = next_node     # previous node skips over target
        next_node.prev = prev_node     # next node links back to previous

# Removes all elements that are a multiple of `mul`
def remove_multiple(head, mul):
    temp = head.next               # start from first element
    while temp != head:
        next_node = temp.next      # store next before potential removal
        if temp.elem % mul == 0:   # check divisibility
            prev_node = temp.prev
            prev_node.next = next_node  # unlink current node from list
            next_node.prev = prev_node
        temp = next_node           # move to next node

# Tester section (equivalent to main method)
if __name__ == "__main__":
    arr = [5, 8, 10, 50, 9]

    # Test arr_to_dhdcl and print_list
    print("Original List:")
    head = arr_to_dhdcl(arr)
    print_list(head)

    # Test insert
    print("\nAfter inserting 99 at index 1:")
    insert(head, 1, 99)
    print_list(head)

    # Test remove
    print("\nAfter removing element at index 2:")
    remove(head, 2)
    print_list(head)

    # Test node_at
    print("\nTesting node_at function:")
    node = node_at(head, 1)
    if node is not None:
        print(f"Element at index 1 is: {node.elem}")
    else:
        print("Index out of bounds.")

    # Test insert at invalid index
    print("\nTrying to insert at invalid index 10:")
    insert(head, 10, 100)
    print_list(head)  # should be unchanged

    # Test remove at invalid index
    print("\nTrying to remove at invalid index 10:")
    remove(head, 10)
    print_list(head)  # should be unchanged

    # Test remove_multiple
    print("\nAfter removing multiples of 5:")
    remove_multiple(head, 5)
    print_list(head)
