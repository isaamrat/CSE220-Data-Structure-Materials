class Node {
    int key;
    String val;
    Node next;

    // Constructor to initialize a node with key-value pair
    Node(int id, String name) {
        this.key = id;
        this.val = name;
        this.next = null;
    }
}

class HashTable {
    Node[] tableArr; // Array of nodes representing the hash table
    int size; // Size of the hash table

    // Constructor to initialize hash table with a given size
    HashTable(int size) {
        tableArr = new Node[size];
        this.size = size;
    }

    // Hash function to determine index for a given key
    public int hashFunction(int id) {
        return id % this.size;
    }

    // Insert a new key-value pair into the hash table
    public void insert(int id, String name) {
        int hashIndx = hashFunction(id);
        Node newNode = new Node(id, name);

        // If no collision, insert directly
        if (this.tableArr[hashIndx] == null) {
            this.tableArr[hashIndx] = newNode;
        } else {
            // Handle collision using chaining (linked list)
            Node temp = this.tableArr[hashIndx];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Search for a key in the hash table
    public boolean search(int id) {
        int hashIndx = hashFunction(id);
        Node temp = this.tableArr[hashIndx];

        while (temp != null) {
            if (temp.key == id) {
                return true; // Key found
            }
            temp = temp.next;
        }
        return false; // Key not found
    }

    // Remove a key from the hash table
    public void remove(int id) {
        int hashIndx = hashFunction(id);
        Node temp = this.tableArr[hashIndx];

        if (temp == null)
            return; // Key not found

        // If the key to be removed is the first node
        if (temp.key == id) {
            this.tableArr[hashIndx] = temp.next;
            return;
        }

        // Traverse the linked list to find and remove the key
        while (temp.next != null) {
            if (temp.next.key == id) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    // Print the hash table
    public void printTable() {
        System.out.println("=".repeat(50));

        for (int i = 0; i < tableArr.length; i++) {
            System.out.print(i + " : ");
            Node temp = tableArr[i];
            while (temp != null) {
                System.out.print("(" + temp.key + " , " + temp.val + ") -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
        
        System.out.println("=".repeat(50));

    }
}

public class hash_table {
    public static void main(String[] args) {
        HashTable h1 = new HashTable(5);

        // Insert elements
        h1.insert(101, "Bob");
        h1.insert(102, "Steve");
        h1.insert(111, "Paige");
        h1.insert(106, "Anna"); // Testing collision (106 % 5 == 1, same as 101)
        h1.insert(201, "Chris"); // Another collision case

        // Search tests
        System.out.println("Search 101: " + h1.search(101)); // Expected: true
        System.out.println("Search 103: " + h1.search(103)); // Expected: false

        // Print table before removal
        System.out.println("Hash Table before deletion:");
        h1.printTable();

        // Remove elements
        h1.remove(101); // Remove an existing key
        h1.remove(103); // Attempt to remove a non-existing key

        // Print table after removal
        System.out.println("Hash Table after deletion:");
        h1.printTable();
    }
}
