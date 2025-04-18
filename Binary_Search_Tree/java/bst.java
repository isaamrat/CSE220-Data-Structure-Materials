class Node{
    int elem;
    Node left;
    Node right;
    Node(int val){
        this.elem = val;
        this.left = null;
        this.right = null;
    }
}

public class bst{
    public static Node insert(Node root, int val){
        if (root == null) {
            return new Node(val);
        }
        if (val > root.elem) {
            root.right = insert(root.right, val);
        }
        else if(val < root.elem){
            root.left = insert(root.left, val);
        }
        return root;
    }

    public static Node buildTree(int[] arr){
        Node root = null;
        for (int i : arr) {
            root = insert(root, i);
        }
        return root;
    }

    public static void inOrder(Node root){
        if (root == null)
        return;
        inOrder(root.left);
        System.out.println(root.elem);
        inOrder(root.right);
    }

    public static int findMin(Node root){
        if (root.left == null)
            return root.elem;
        // return root.elem
        return findMin(root.left);
    }

    public static boolean searchVal(Node root, int target){
        if (root == null)
            return false;
        if (root.elem == target)
            return true;
        if (target > root.elem)
            return searchVal(root.right, target);
        else
            return searchVal(root.left, target);
    }


    public static void main(String[] args) {
        int[] arr = {70, 50, 40, 90, 20, 95, 99, 80, 85, 75};
        Node root = buildTree(arr);
        // inOrder(root);
        System.out.println( findMin(root));
        System.out.println(searchVal(root, 195));

    }
}