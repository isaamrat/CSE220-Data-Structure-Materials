class MaxHeap{
    private int[] heap;   // Array to store the elements of the heap.
    private int size;     // Current number of elements in the heap.
    private int capacity; // Maximum capacity of the heap.

    // Constructor to initialize the heap with a given capacity.
    MaxHeap(int cap){
        this.heap = new int[cap];  // Initialize the heap array with the given capacity.
        this.size = 0;             // Initially, the heap is empty.
        this.capacity = cap;       // Set the capacity of the heap.
    }

    // Insert a value into the heap.
    public void insert(int val){
        if (this.size >= this.capacity) {  // Check if the heap is full.
            System.out.println("Heap is full");  // Print error message if full.
            return;
        }
        this.heap[this.size] = val;   // Place the new value at the end of the heap.
        swim(this.size);               // Move the value to the correct position.
        this.size += 1;                // Increase the size of the heap.
    }

    // Helper method to move the element at index 'indx' upwards in the heap.
    public void swim(int indx){
        int pIndx = (indx-1)/2;  // Calculate the parent index.
        while ( indx > 0 && this.heap[indx]>this.heap[pIndx]) {  // If the current value is greater than its parent.
            int temp = this.heap[indx];     // Swap the current element with its parent.
            this.heap[indx] = this.heap[pIndx];
            this.heap[pIndx] = temp;

            indx = pIndx;        // Move up to the parent index.
            pIndx = (indx-1)/2;  // Update the parent index.
        }
    }

    // Print all the elements in the heap.
    public void printHeap(){
        for (int i=0; i<this.size; i++) {  // Loop through the heap array.
            System.out.print(this.heap[i]+" ");  // Print each element.
        }
        System.out.println();  // Move to the next line after printing all elements.
    }

    // Remove and return the maximum element from the heap.
    public int removeMax(){
        if (this.size <= 0) {  // If the heap is empty.
            System.out.println("No more elements to remove!");  // Print an error message.
            return -1;  // Return -1 to indicate no element was removed.
        }
        int temp = this.heap[0];  // Store the maximum element (the root).
        this.heap[0] = this.heap[this.size-1];  // Move the last element to the root.
        this.heap[this.size-1] = 0;  // Set the last element to zero.
        this.size -= 1;  // Decrease the size of the heap.
        heapify(0);  // Restore the heap property by heapifying from the root.
        return temp;  // Return the removed maximum element.
    }

    // Helper method to restore the heap property by moving the element at index 'indx' downwards.
    public void heapify(int indx){
        int left = 2*indx+1;  // Left child index.
        int right = 2*indx+2; // Right child index.
        if (left >= this.size) {  // If the left child is out of bounds, return.
            return;
        }
        int largest = left;  // Assume the left child is the largest.
        if (right < this.size && this.heap[largest] < this.heap[right]){  // If the right child is larger, update the largest.
            largest = right;
        }
        if (this.heap[indx] < this.heap[largest]) {  // If the current element is smaller than the largest child.
            int temp = this.heap[indx];   // Swap the current element with the largest child.
            this.heap[indx] = this.heap[largest];
            this.heap[largest] = temp;
            heapify(largest);  // Recursively heapify the affected subtree.
        }
    }

    // Sort the heap by repeatedly removing the maximum element and storing it in an array.
    public int[] sort(){
        int[] arr = new int[this.size];  // Create an array to store the sorted values.
        int ogSize = this.size;          // Store the original size of the heap.
        for (int i = 0; i < ogSize; i++) {  // Loop through and remove the max element.
            int temp = removeMax();  // Remove the maximum element.
            arr[i] = temp;           // Store the removed element in the sorted array.
        }
        return arr;  // Return the sorted array.
    }

    // Sort the heap in place without using extra space.
    public int[] sortInPlace(){
        int ogSize = this.size;  // Store the original size of the heap.
        for (int i = ogSize-1; i > 0; i--) {  // Loop through the heap from the last element to the second element.
            int temp = removeMax();  // Remove the maximum element.
            this.heap[i] = temp;     // Place the removed element at the correct position.
        }
        return this.heap;  // Return the heap array, which is now sorted in place.
    }
}

public class max_heap {
    public static void main(String[] args) {
        // === Driver Code ===

        // Create a MaxHeap with capacity of 7
        MaxHeap heap = new MaxHeap(7);

        // Insert values one-by-one (not using loop)
        heap.insert(10);
        heap.insert(4);
        heap.insert(15);
        heap.insert(20);
        heap.insert(1);
        heap.insert(17);
        heap.insert(8);

        // Display the heap structure after insertions
        System.out.println("Heap after insertions:");
        heap.printHeap();

        // Remove the maximum element (root of the heap)
        int max_val = heap.removeMax();
        System.out.println("Removed max element: " + max_val);

        // Display the heap structure after removal
        System.out.println("Heap after removing max:");
        heap.printHeap();

        // Display a sorted version (descending) without modifying original heap
        int[] sorted_desc = heap.sort();
        System.out.println("Heap elements in descending order (non-destructive):");
        for (int i : sorted_desc) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Re-create the heap and insert values again for in-place sort test
        heap = new MaxHeap(7);
        heap.insert(10);
        heap.insert(4);
        heap.insert(15);
        heap.insert(20);
        heap.insert(1);
        heap.insert(17);
        heap.insert(8);

        // Perform in-place sorting (modifies original heap)
        int[] sorted_inplace = heap.sortInPlace();
        System.out.println("Heap array sorted in-place (ascending order):");
        for (int i : sorted_inplace) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
