class MaxHeap:
    def __init__(self, capacity):
        # Initialize the heap with a fixed size array
        self.__heap = [0] * capacity         # Array to store heap elements
        self.__size = 0                      # Current number of elements in the heap
        self.__capacity = capacity           # Maximum number of elements the heap can hold

    def insert(self, val):
        # Insert a value into the heap
        if self.__size >= self.__capacity:
            print("No space in the heap!")   # Heap is full
            return
        self.__heap[self.__size] = val       # Place the value at the next available index
        self.swim(self.__size)               # Move the value to its correct position
        self.__size += 1                     # Increment the size of the heap

    def swim(self, indx):
        # Move an element up the heap until the max-heap property is restored
        pindx = (indx - 1) // 2              # Get parent index
        while indx > 0 and self.__heap[indx] > self.__heap[pindx]:
            # Swap if current node is greater than its parent
            self.__heap[indx], self.__heap[pindx] = self.__heap[pindx], self.__heap[indx]
            indx = pindx                     # Move up to parent index
            pindx = (indx - 1) // 2          # Update parent index

    def printHeapArr(self):
        # Print all elements currently in the heap
        for i in range(self.__size):
            print(self.__heap[i], end=' ')
        print()

    def removeMax(self):
        # Remove and return the maximum element from the heap (root)
        if self.__size <= 0:
            print("No elements to remove!")  # Heap is empty
            return
        temp = self.__heap[0]                # Store max element to return later
        self.__heap[0] = self.__heap[self.__size - 1]  # Move last element to root
        self.__heap[self.__size - 1] = 0     # Optional: reset last element
        self.__size -= 1                     # Decrease heap size
        self.heapify(0)                      # Restore heap property from root
        return temp                          # Return removed max element

    def heapify(self, indx):
        # Restore heap property by moving the value down the tree
        left = 2 * indx + 1                  # Index of left child
        right = 2 * indx + 2                 # Index of right child

        if left >= self.__size:
            return                           # No children, stop recursion

        largest = left                       # Assume left child is the largest

        if right < self.__size and self.__heap[right] > self.__heap[left]:
            largest = right                  # Right child is larger

        if self.__heap[largest] > self.__heap[indx]:
            # Swap and continue heapifying down
            self.__heap[indx], self.__heap[largest] = self.__heap[largest], self.__heap[indx]
            self.heapify(largest)            # Recursive call

    def heapSort(self):
        # Return sorted elements in descending order (non-destructive)
        temp_heap = MaxHeap(self.__capacity)
        for i in range(self.__size):
            temp_heap.insert(self.__heap[i])     # Copy elements to a new heap
        arr = []
        while temp_heap.__size > 0:
            arr.append(temp_heap.removeMax())    # Extract max repeatedly
        return arr                               

    def sortInPlace(self):
        # Sorts the heap in-place (destructively), using heap sort technique
        original_size = self.__size
        for i in range(self.__size - 1, 0, -1):
            temp = self.removeMax()            # Remove max element
            self.__heap[i] = temp              # Place it at the end          
        return self.__heap


# === Driver Code ===

# Create a MaxHeap with capacity of 7
heap = MaxHeap(7)

# Insert values one-by-one (not using loop)
heap.insert(10)
heap.insert(4)
heap.insert(15)
heap.insert(20)
heap.insert(1)
heap.insert(17)
heap.insert(8)

# Display the heap structure after insertions
print("Heap after insertions:")
heap.printHeapArr()

# Remove the maximum element (root of the heap)
max_val = heap.removeMax()
print("Removed max element:", max_val)

# Display the heap structure after removal
print("Heap after removing max:")
heap.printHeapArr()

# Display a sorted version (descending) without modifying original heap
sorted_desc = heap.heapSort()
print("Heap elements in descending order (non-destructive):", sorted_desc)

# Re-create the heap and insert values again for in-place sort test
heap = MaxHeap(7)
heap.insert(10)
heap.insert(4)
heap.insert(15)
heap.insert(20)
heap.insert(1)
heap.insert(17)
heap.insert(8)

# Perform in-place sorting (modifies original heap)
sorted_inplace = heap.sortInPlace()
print("Heap array sorted in-place (ascending order):", sorted_inplace)
