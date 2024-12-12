// Node class representing each node of the binary tree
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// BinaryTree class containing the binary search implementation
class BinaryTree {
    Node root;

    // Constructor to initialize the tree
    public BinaryTree() {
        root = null;
    }

    // Method to insert a new key into the binary tree
    void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key into the binary tree
    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        // Return the unchanged node
        return root;
    }

    // Method to search for a key in the binary tree
    boolean search(int key) {
        return searchRec(root, key);
    }

    // A recursive function to search for a key in the binary tree
    boolean searchRec(Node root, int key) {
        // Base case: root is null or the key is present at root
        if (root == null) {
            return false;
        }
        if (root.key == key) {
            return true;
        }

        // Key is smaller than root's key
        if (key < root.key) {
            return searchRec(root.left, key);
        }

        // Key is larger than root's key
        return searchRec(root.right, key);
    }

    // In-order traversal to display the tree's elements
    void inorder() {
        inorderRec(root);
    }

    // A recursive function to do in-order traversal of the binary tree
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert keys into the binary tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Display the tree's elements using in-order traversal
        System.out.println("In-order traversal of the binary tree:");
        tree.inorder();

        // Search for keys in the binary tree
        int keyToSearch = 40;
        System.out.println("\n\nIs " + keyToSearch + " present in the tree? " + tree.search(keyToSearch));

        keyToSearch = 90;
        System.out.println("Is " + keyToSearch + " present in the tree? " + tree.search(keyToSearch));
    }

