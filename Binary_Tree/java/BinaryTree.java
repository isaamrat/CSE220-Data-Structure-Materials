class Node {
    Integer elem;
    Node left;
    Node right;
    
    // Constructor to initialize the node with a value
    Node(Integer val) {
        this.elem = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {

    // Converts an array to a binary tree by recursively creating nodes
    public static Node arrayToTree(Integer[] arr, int indx) {
        // Base condition to stop recursion if index is out of bounds or element is null
        if (indx >= arr.length || arr[indx] == null) {
            return null;
        }
        Node temp = new Node(arr[indx]); // Create a node with the current element
        // Recursively assign left and right children using indices 2*indx and 2*indx+1
        temp.left = arrayToTree(arr, 2 * indx);
        temp.right = arrayToTree(arr, 2 * indx + 1);
        return temp; // Return the created node
    }

    // Pre-order traversal: Root, Left, Right
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.elem); // Print the element of the current node
        preOrder(root.left); // Recursively traverse the left subtree
        preOrder(root.right); // Recursively traverse the right subtree
    }

    // Post-order traversal: Left, Right, Root
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left); // Recursively traverse the left subtree
        postOrder(root.right); // Recursively traverse the right subtree
        System.out.println(root.elem); // Print the element of the current node
    }

    // In-order traversal: Left, Root, Right
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left); // Recursively traverse the left subtree
        System.out.print(root.elem + " "); // Print the element of the current node
        inOrder(root.right); // Recursively traverse the right subtree
    }

    // Counts the total number of nodes in the tree
    public static int nodeCount(Node root) {
        if (root == null) {
            return 0; // Base case: no node to count
        }
        return 1 + nodeCount(root.left) + nodeCount(root.right); // Count the current node + left and right subtrees
    }

    // Helper function to return the maximum of two numbers
    public static int max(int x, int y) {
        return x > y ? x : y; // Return the greater of x and y
    }

    // Finds the height of the tree (maximum depth)
    public static int findHeight(Node root) {
        if (root == null) {
            return -1; // Base case: height of an empty tree is -1
        }
        // Find the heights of the left and right subtrees
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        return max(leftHeight, rightHeight) + 1; // Return the greater height + 1 for the current node
    }

    // Checks if the tree is a full binary tree (every node has either 0 or 2 children)
    public static boolean isFull(Node root) {
        if (root == null) {
            return true; // An empty tree is considered full
        }
        // If one child is missing, it's not a full binary tree
        if (root.left != null && root.right == null) {
            return false;
        }
        if (root.left == null && root.right != null) {
            return false;
        }
        return isFull(root.left) && isFull(root.right); // Recursively check left and right subtrees
    }

    // Checks if the tree is a complete binary tree
    public static boolean isComplete(Node root, int indx, int totalNode) {
        if (root == null) {
            return true; // An empty tree is considered complete
        }
        // If index exceeds total node count, the tree is not complete
        if (indx > totalNode) {
            return false;
        }
        // Recursively check left and right subtrees
        return isComplete(root.left, 2 * indx, totalNode) && isComplete(root.right, 2 * indx + 1, totalNode);
    }

    // Finds the depth of the target node in the tree
    public static int findDepth(Node root, int target, int depth) {
        if (root == null) {
            return -1; // Target node not found in this path
        }
        if (root.elem == target) {
            return depth; // Target node found, return the current depth
        }
        // Search the left subtree
        int leftDepth = findDepth(root.left, target, depth + 1);
        if (leftDepth != -1) {
            return leftDepth; // If found in the left subtree, return the depth
        }
        // Search the right subtree
        return findDepth(root.right, target, depth + 1);
    }

    // Checks if the tree is perfect (all leaf nodes are at the same depth)
    public static boolean isPerfect(Node root, int depth, int level) {
        if (root == null) {
            return true; // An empty tree is considered perfect
        }
        // If both children are null (leaf node), check if the depth equals level + 1
        if (root.left == null && root.right == null) {
            return depth == level + 1;
        }
        if (root.left == null || root.right == null) {
            return false; // If one child is missing, it's not perfect
        }
        // Recursively check left and right subtrees
        return isPerfect(root.left, depth, level + 1) && isPerfect(root.right, depth, level + 1);
    }

    // Checks if the tree is balanced (difference in heights of left and right subtrees <= 1)
    public static boolean isBalanced(Node root) {
        return checkHeightAndBalance(root) != -1; // Returns true if balanced, false if unbalanced
    }

    // Helper function to check height and balance of the tree
    public static int checkHeightAndBalance(Node node) {
        if (node == null) {
            return 0; // Null nodes have height 0
        }
        int leftHeight = checkHeightAndBalance(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is unbalanced
        }
        int rightHeight = checkHeightAndBalance(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is unbalanced
        }
        // If the height difference between left and right subtrees is greater than 1, tree is unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1; // Return the height of the node
    }

    // Main method for testing the tree functionalities
    public static void main(String[] args) {

        Integer[] arr = {null, 1, 2, 3, 4, 5, 6}; // Sample binary tree array representation
        Node root = arrayToTree(arr, 1); // Convert array to binary tree
        
        // Test case 1: InOrder Traversal (Left, Root, Right)
        System.out.println("InOrder Traversal:");
        inOrder(root);  // Expected output: 4 2 5 1 6 3
        System.out.println();

        // Test case 2: Node Count
        int nodeCountResult = nodeCount(root);
        System.out.println("Node Count: " + nodeCountResult);  // Expected output: 6
        
        // Test case 3: Find the depth of a target node (target = 5)
        int target = 5;
        int depth = findDepth(root, target, 0);
        System.out.println("Depth of node " + target + ": " + depth);  // Expected output: 2

        // Test case 4: Find the height of the tree
        int height = findHeight(root);
        System.out.println("Height of tree: " + height);  // Expected output: 2

        // Test case 5: Check if the tree is full
        boolean isFullResult = isFull(root);
        System.out.println("Is the tree full? " + isFullResult);  // Expected output: false

        // Test case 6: Check if the tree is complete
        int totalNodeCount = nodeCount(root);
        boolean isCompleteResult = isComplete(root, 1, totalNodeCount);
        System.out.println("Is the tree complete? " + isCompleteResult);  // Expected output: true

        // Test case 7: Check if the tree is perfect
        int depthForPerfect = findHeight(root) + 1;
        boolean isPerfectResult = isPerfect(root, depthForPerfect, 0);
        System.out.println("Is the tree perfect? " + isPerfectResult);  // Expected output: false

        // Test case 8: Check if the tree is balanced
        boolean isBalancedResult = isBalanced(root);
        System.out.println("Is the tree balanced? " + isBalancedResult);  // Expected output: true
    }
}
