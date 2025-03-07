import numpy as np

class Node:
    def __init__(self, id, name):
        self.key = id  # Store the key (ID)
        self.val = name  # Store the value (name)
        self.next = None  # Pointer to next node for handling collisions

class HashTable:
    def __init__(self, size):
        self.size = size  # Size of the hash table
        self.tableArr = np.empty(size, dtype=object)  # Initialize array with None values
    
    def hashFunction(self, key):
        return key % self.size  # Simple modulo-based hash function
    
    def insert(self, id, name):
        hashIndx = self.hashFunction(id)
        newNode = Node(id, name)

        # If no collision, insert directly
        if self.tableArr[hashIndx] is None:
            self.tableArr[hashIndx] = newNode
        else:
            # Handle collision using chaining (linked list)
            temp = self.tableArr[hashIndx]
            while temp.next is not None:
                temp = temp.next
            temp.next = newNode
    
    def printTable(self):
        print('='*55)
        for i in range(len(self.tableArr)):
            print(i, end=' : ')
            temp = self.tableArr[i]
            while temp is not None:
                print(f'({temp.key}, {temp.val}) -> ', end='')
                temp = temp.next
            print('None')
        print('='*55)
    
    def search(self, id):
        hashIndx = self.hashFunction(id)
        temp = self.tableArr[hashIndx]
        
        while temp is not None:
            if temp.key == id:
                return hashIndx  # Return index if key is found
            temp = temp.next
        return -1  # Key not found
    
    def remove(self, id):
        hashIndx = self.hashFunction(id)
        temp = self.tableArr[hashIndx]
        
        if temp is  None: # If there's no node available to remove
            return
        
        if temp.key == id: # If the node to be removed is the first node
            self.tableArr[hashIndx] = temp.next
            return
        
        # Traverse the linked list to find and remove the node
        while temp.next is not None:
            if temp.next.key == id:
                temp.next = temp.next.next
                return
            temp = temp.next

# Test cases to validate HashTable functionality
if __name__ == "__main__":
    hashTable1 = HashTable(5)
    
    # Insert elements
    hashTable1.insert(101, 'Bob')
    hashTable1.insert(102, 'Ben')
    hashTable1.insert(111, 'Stewie')
    hashTable1.insert(106, 'Anna')  # Testing collision (106 % 5 == 1, same as 101)
    hashTable1.insert(201, 'Chris') # Another collision case
    
    # Print table before removal
    print("Hash Table before deletion:")
    hashTable1.printTable()
    
    # Search tests
    print("Search 101:", hashTable1.search(101))  # Expected: valid index
    print("Search 103:", hashTable1.search(103))  # Expected: -1 (not found)
    
    # Remove elements
    hashTable1.remove(101) # Remove an existing key
    hashTable1.remove(103) # Attempt to remove a non-existing key
    
    # Print table after removal
    print("Hash Table after deletion:")
    hashTable1.printTable()
