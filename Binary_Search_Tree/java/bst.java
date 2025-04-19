// Class representing a node of a Binary Search Tree (BST)
class Node {
    int elem;       // The value stored in the node
    Node left;      // Reference to the left child
    Node right;     // Reference to the right child

    // Constructor to initialize a node with a given value
    Node(int val) {
        this.elem = val;
        this.left = null;
        this.right = null;
    }
}

public class bst {

    // Function to insert a value into the BST
    public static Node insert(Node root, int val) {
        if (root == null) {  // Base case: if tree is empty, create a new node
            return new Node(val);
        }
        if (val > root.elem) {  // If value is greater, insert into right subtree
            root.right = insert(root.right, val);
        } else if (val < root.elem) {  // If value is smaller, insert into left subtree
            root.left = insert(root.left, val);
        }
        // Return the unchanged root node pointer after insertion
        return root;
    }

    // Function to build a BST from an array of values
    public static Node buildTree(int[] arr) {
        Node root = null;  // Initialize the root as null
        for (int i : arr) {  // Insert each element from the array into the BST
            root = insert(root, i);
        }
        return root;  // Return the constructed BST
    }

    // In-order traversal: left, root, right
    public static void inOrder(Node root) {
        if (root == null)
            return;  // Base case: empty subtree
        inOrder(root.left);             // Visit left subtree
        System.out.println(root.elem);  // Visit current node
        inOrder(root.right);            // Visit right subtree
    }

    // Function to find the minimum value in BST (leftmost node)
    public static int findMin(Node root) {
        if (root.left == null)  // If no left child, this is the minimum
            return root.elem;
        return findMin(root.left);  // Keep going left
    }

    // Function to search for a target value in the BST
    public static boolean searchVal(Node root, int target) {
        if (root == null)  // Base case: value not found
            return false;
        if (root.elem == target)  // Value found at current node
            return true;
        if (target > root.elem)
            return searchVal(root.right, target);  // Search right subtree
        else
            return searchVal(root.left, target);   // Search left subtree
    }

    // Function to remove a node with a specific value from BST
    public static Node removeNode(Node root, int target) {
        if (root == null) {  // Base case: empty tree
            return null;
        }
        if (target > root.elem) {
            root.right = removeNode(root.right, target);  // Recurse right
        } else if (target < root.elem) {
            root.left = removeNode(root.left, target);    // Recurse left
        } else {
            // Node to be deleted found
            if (root.left == null) {
                return root.right;  // Replace node with right child
            } else if (root.right == null) {
                return root.left;   // Replace node with left child
            }
            // Node has two children
            int successor = findMin(root.right);  // Find in-order successor (smallest in right subtree)
            root.elem = successor;  // Replace value with successor
            root.right = removeNode(root.right, successor);  // Remove successor
        }
        return root;  // Return modified root
    }

    // Store in-order traversal result into an array
    public static int inOrderArr(Node root, int[] arr, int indx) {
        if (root == null) {
            return indx;  // Base case
        }
        indx = inOrderArr(root.left, arr, indx);  // Visit left subtree
        arr[indx] = root.elem;                    // Store current node value
        indx += 1;                                // Move index forward
        indx = inOrderArr(root.right, arr, indx); // Visit right subtree
        return indx;                              // Return updated index
    }

    // Count total number of nodes in BST
    public static int nodeCount(Node root) {
        if (root == null) {
            return 0;  // Base case: no nodes
        }
        // Count 1 (current node) + left subtree nodes + right subtree nodes
        return 1 + nodeCount(root.left) + nodeCount(root.right);
    }

    // Recursively build a balanced BST from a sorted array
    public static Node balanceBST(int[] arr, int s, int e) {
        if (s > e) {
            return null;  // Base case: no elements to include
        }
        int mid = (s + e) / 2;  // Pick middle element for balanced BST
        Node root = new Node(arr[mid]);  // Make it root
        root.left = balanceBST(arr, s, mid - 1);   // Recursively build left subtree
        root.right = balanceBST(arr, mid + 1, e);  // Recursively build right subtree
        return root;
    }

    // Balance an unbalanced BST
    public static Node BuildBalanceBST(Node root) {
        int count = nodeCount(root);  // Get total number of nodes
        int[] arr = new int[count];   // Create an array to hold in-order values
        inOrderArr(root, arr, 0);     // Populate the array with in-order traversal (sorted order)
        Node newRoot = balanceBST(arr, 0, count - 1);  // Build balanced BST from sorted array
        return newRoot;
    }

    // Main function to test the BST functionalities
    public static void main(String[] args) {
        // Sample array to build an initial BST
        int[] arr = {70, 50, 40, 90, 20, 95, 99, 80, 85, 75};
        Node root = buildTree(arr);  // Build BST

        // Print in-order traversal (sorted order)
        System.out.println("In-order Traversal:");
        inOrder(root);

        // Test findMin function
        System.out.println("Minimum value in BST: " + findMin(root));  // Should print 20

        // Test searchVal function
        System.out.println("Search 90: " + searchVal(root, 90));   // Should print true
        System.out.println("Search 195: " + searchVal(root, 195)); // Should print false

        // Test removeNode function
        System.out.println("Remove 90:");
        root = removeNode(root, 90);  // Remove a value
        inOrder(root);  // Check updated BST

        // Test balancing a skewed BST
        System.out.println("Balancing a skewed BST:");
        int[] arr2 = {70, 60, 50, 40, 30, 20, 10};
        Node root2 = buildTree(arr2);  // Build unbalanced BST
        System.out.println("Before balancing:");
        inOrder(root2);  // Skewed order

        root2 = BuildBalanceBST(root2);  // Balance it
        System.out.println("After balancing:");
        inOrder(root2);  // Should be more balanced now
    }
}
