// Node1 class representing each element of the binary tree

import java.util.LinkedList;
import java.util.Queue;

class Node1 {
    int nodedata;
    Node1 left, right;

    // Constructor to create a new node with a given nodedata
    public Node1(int item) {
        nodedata = item;
        left = right = null;
    }
}

// BinaryTree class for basic operations
public class binarytree {
    Node1 root;

    // Constructor to initialize an empty binary tree
    public binarytree() {
        root = null;
    }

    // Insert a new node into the binary tree (level-order insertion)
    public void insert(int nodedata) {
        root = insertRec(root, nodedata);
    }

    // Recursive method to insert a new nodedata into the binary tree
    private Node1 insertRec(Node1 root, int nodedata) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node1(nodedata);
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

    private void inOrderRec(Node1 root) {
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

    private void preOrderRec(Node1 root) {
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

    // Level-order traversal: Root -> Level by Level
    public void levelOrder() {
        if (root == null) return;
        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node1 currentNode = queue.poll();
            System.out.print(currentNode.nodedata + " ");
            if (currentNode.left != null) queue.add(currentNode.left);
            if (currentNode.right != null) queue.add(currentNode.right);
        }
    }


    private void postOrderRec(Node1 root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.nodedata + " ");
        }
    }

    // Delete a node with the given data from the tree
public void delete(int nodedata) {
    root = deleteRec(root, nodedata);
}

private Node1 deleteRec(Node1 root, int nodedata) {
    if (root == null) return root;

    // Traverse the tree to find the node
    if (nodedata < root.nodedata) {
        root.left = deleteRec(root.left, nodedata);
    } else if (nodedata > root.nodedata) {
        root.right = deleteRec(root.right, nodedata);
    } else {
        // Node1 with only one child or no child
        if (root.left == null) return root.right;
        else if (root.right == null) return root.left;

        // Node1 with two children: get the inorder successor
        root.nodedata = minValue(root.right);
        root.right = deleteRec(root.right, root.nodedata);
    }
    return root;
}

    // Helper method to find the minimum value in the subtree
    private int minValue(Node1 root) {
        int minValue = root.nodedata;
        while (root.left != null) {
            minValue = root.left.nodedata;
            root = root.left;
        }
        return minValue;
        }

    // Calculate the height of the tree
public int height() {
    return height(root);
}
    

private int height(Node1 node) {
    if (node == null) return 0;
    int leftHeight = height(node.left);
    int rightHeight = height(node.right);
    return Math.max(leftHeight, rightHeight) + 1;
}



    // Search for a value in the binary tree
    public boolean search(int nodedata) {
        return searchRec(root, nodedata) != null;
    }

    // Recursive method to search for a given nodedata
    private Node1 searchRec(Node1 root, int nodedata) {
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

        System.out.println("\n\nLevel-order traversal:");
        tree.levelOrder(); // Output: 50 30 70 20 40 60 80
        System.out.println("\n\nTree height: " + tree.height()); // Expected output: Height of tree


        System.out.println("\n\nDeleting 20:");
tree.delete(20);
tree.inOrder(); // Expected output (without 20): 30 40 50 60 70 80


        // Searching for an element in the tree
        System.out.println("\n\nSearch for 60: " + tree.search(60)); // Output: true
        System.out.println("Search for 90: " + tree.search(90)); // Output: false
    }
}
