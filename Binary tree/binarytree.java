// Node class representing each element of the binary tree
class Node {
    int nodedata;
    Node left, right;

    // Constructor to create a new node with a given nodedata
    public Node(int item) {
        nodedata = item;
        left = right = null;
    }
}

// BinaryTree class for basic operations
public class binarytree {
    Node root;

    // Constructor to initialize an empty binary tree
    public binarytree() {
        root = null;
    }

    // Insert a new node into the binary tree (level-order insertion)
    public void insert(int nodedata) {
        root = insertRec(root, nodedata);
    }

    // Recursive method to insert a new nodedata into the binary tree
    private Node insertRec(Node root, int nodedata) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(nodedata);
            return root;
        }

        // Otherwise, recur down the tree
        if (nodedata < root.nodedata) {
            root.left = insertRec(root.left, nodedata);
        } else if (nodedata > root.nodedata) {
            root.right = insertRec(root.right, nodedata);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // In-order traversal: Left -> Root -> Right
    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.nodedata + " ");
            inOrderRec(root.right);
        }
    }

    // Pre-order traversal: Root -> Left -> Right
    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.nodedata + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    // Post-order traversal: Left -> Right -> Root
    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.nodedata + " ");
        }
    }

    // Search for a value in the binary tree
    public boolean search(int nodedata) {
        return searchRec(root, nodedata) != null;
    }

    // Recursive method to search for a given nodedata
    private Node searchRec(Node root, int nodedata) {
        // Base case: root is null or nodedata is present at root
        if (root == null || root.nodedata == nodedata) {
            return root;
        }

        // Key is greater than root's nodedata
        if (root.nodedata < nodedata) {
            return searchRec(root.right, nodedata);
        }

        // Key is smaller than root's nodedata
        return searchRec(root.left, nodedata);
    }

    // Driver method for testing the binary tree implementation
    public static void main(String[] args) {
        binarytree tree = new binarytree();

        // Inserting nodes into the tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Printing different traversals
        System.out.println("In-order traversal:");
        tree.inOrder(); // Output: 20 30 40 50 60 70 80

        System.out.println("\n\nPre-order traversal:");
        tree.preOrder(); // Output: 50 30 20 40 70 60 80

        System.out.println("\n\nPost-order traversal:");
        tree.postOrder(); // Output: 20 40 30 60 80 70 50

        // Searching for an element in the tree
        System.out.println("\n\nSearch for 60: " + tree.search(60)); // Output: true
        System.out.println("Search for 90: " + tree.search(90)); // Output: false
    }
}
