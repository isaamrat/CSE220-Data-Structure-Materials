```
Class MaxHeap:
    // Constructor to initialize the MaxHeap
    Method MaxHeap(capacity):
        Initialize heap as an empty list with size equal to capacity
        Set size to 0
        Set capacity to the provided capacity

    // Insert a value into the heap
    Method insert(val):
        If size >= capacity:
            Print "No space in the heap!"
            Return
        Set heap[size] to val
        Call swim(size) to ensure heap property is maintained
        Increment size by 1

    // Helper method to maintain the heap property by swimming the element up
    Method swim(indx):
        Set pindx to (indx - 1) // 2  // Parent index
        While indx > 0 and heap[indx] > heap[pindx]:
            Swap heap[indx] with heap[pindx]
            Set indx to pindx
            Set pindx to (indx - 1) // 2

    // Print the heap array
    Method printHeapArr():
        For i from 0 to size - 1:
            Print heap[i]
        Print a newline

    // Remove the maximum element (root of the heap) and restore heap property
    Method removeMax():
        If size <= 0:
            Print "No elements to remove!"
            Return
        Set temp to heap[0]  // Store the root value
        Set heap[0] to heap[size - 1]  // Replace root with last element
        Set heap[size - 1] to 0  // Set last element to 0 (no longer part of the heap)
        Decrement size by 1
        Call heapify(0) to restore heap property from root
        Return temp

    // Helper method to restore the heap property from the given index
    Method heapify(indx):
        Set left to 2 * indx + 1  // Left child index
        Set right to 2 * indx + 2  // Right child index
        If left >= size:
            Return  // No children, so return
        Set largest to left
        If right < size and heap[largest] < heap[right]:
            Set largest to right
        If heap[indx] < heap[largest]:
            Swap heap[indx] with heap[largest]
            Call heapify(largest) to continue the heapify process

    // Perform heap sort by removing the maximum element repeatedly
    Method heapSort():
        Create an empty array arr of size equal to heap size
        For i from 0 to size - 1:
            Set arr[i] to removeMax()
        Return arr

    // Perform heap sort in-place by swapping root with the last element and heapifying
    Method heapSortInPlace():
        For i from size - 1 down to 1:
            Swap heap[i] with heap[0]  // Swap max element (root) with last element
            Decrement size by 1
            Call heapify(0) to restore the heap property
        Return heap  // The heap array is now sorted

// Example usage
Create instance h1 of MaxHeap with capacity 5
Call insert(2) on h1
Call insert(5) on h1
Call insert(7) on h1
Call insert(9) on h1
Call insert(8) on h1
Call printHeapArr() on h1  // Print the heap after all insertions

Create sortedArr by calling heapSort() on h1
Print sortedArr  // Print the sorted array
```