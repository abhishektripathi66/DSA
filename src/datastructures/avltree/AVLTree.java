package datastructures.avltree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AVLTree {
    
    private static class Node {
        int data;
        Node left, right;
        int height;
        
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1; // New nodes start with height 1, so that will be default
        }
    }
    
    private Node root;
    private int size;
    
    public AVLTree() {
        this.root = null;
        this.size = 0;
    }
    

    public int size() {
        return size;
    }
    
    // Method to check if tree is empty
    public boolean isEmpty() {
        return root == null;
    }
    
    // Add new value to tree
    public void insert(int data) {
        int initialSize = size;
        root = insertRec(root, data);
        if (size == initialSize) {
            throw new IllegalArgumentException("Duplicate values are not allowed: " + data);
        }
    }
    

    
    // Method for inserting nodes
    private Node insertRec(Node node, int data) {
        if (node == null) {
            size++;
            return new Node(data);
        }
        
        if (data < node.data) {
            node.left = insertRec(node.left, data);
        } else if (data > node.data) {
            node.right = insertRec(node.right, data);
        } else {
            // Duplicate values are not allowed.
            return node;
        }
        
        // Update height of current node
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        
        // Get the balance factor
        int balance = getBalance(node);
        
        // Perform rotations if needed below are different cases:
        
        // Left-Left case
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }
        
        // Right-Right case
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }
        
        // Left-Right case
        if (balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        // Right-Left case
        if (balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
    }
    
    // Delete value from tree
    public boolean delete(int data) {
        int initialSize = size;
        root = deleteRec(root, data);
        return size < initialSize;
    }
    
    // Recursive helper for deleting nodes
    private Node deleteRec(Node node, int data) {
        if (node == null) {
            return node;
        }
        
        if (data < node.data) {
            node.left = deleteRec(node.left, data);
        } else if (data > node.data) {
            node.right = deleteRec(node.right, data);
        } else {
            // Node found
            size--;
            
            // Node with only one or no child
            if (node.left == null || node.right == null) {
                Node temp = (node.left != null) ? node.left : node.right;
                
                // No child case:
                if (temp == null) {
                    temp = node;
                    node = null;
                } else {
                    // One child case:
                    node = temp;
                }
            } else {
                // Node with two childs
                Node temp = getMinValueNode(node.right);
                node.data = temp.data;
                node.right = deleteRec(node.right, temp.data);
                size++;
            }
        }


        // If the tree had only one node then return
        if (node == null) {
            return node;
        }
        
        // Update height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        
        // Get balance factor
        int balance = getBalance(node);
        
        // Perform rotations if needed below are different cases:
        
        // Left-Left case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rightRotate(node);
        }
        
        // Left-Right case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        // Right-Right case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return leftRotate(node);
        }
        
        // Right-Left case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        
        return node;
    }
    
    // Find value in tree
    public boolean search(int data) {
        return searchRec(root, data);
    }
    
    // Recursive helper for searching
    private boolean searchRec(Node node, int data) {
        if (node == null) {
            return false;
        }
        
        if (data == node.data) {
            return true;
        } else if (data < node.data) {
            return searchRec(node.left, data);
        } else {
            return searchRec(node.right, data);
        }
    }
    
    // Get nodes in order: left -> root -> right
    public List<Integer> inOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }
    
    // This function is recursive, so that's why we separate this.
    private void inOrderRec(Node node, List<Integer> result) {
        if (node != null) {
            inOrderRec(node.left, result);
            result.add(node.data);
            inOrderRec(node.right, result);
        }
    }
    
    // Get nodes in order: root -> left -> right
    public List<Integer> preOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        preOrderRec(root, result);
        return result;
    }
    
    // This function is recursive, so that's why we separate this.
    private void preOrderRec(Node node, List<Integer> result) {
        if (node != null) {
            result.add(node.data);
            preOrderRec(node.left, result);
            preOrderRec(node.right, result);
        }
    }
    
    // Get nodes in order: left -> right -> root
    public List<Integer> postOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        postOrderRec(root, result);
        return result;
    }
    
    // This function is recursive, so that's why we separate this.
    private void postOrderRec(Node node, List<Integer> result) {
        if (node != null) {
            postOrderRec(node.left, result);
            postOrderRec(node.right, result);
            result.add(node.data);
        }
    }
    
    // Get nodes level by level from top to bottom
    public List<Integer> levelOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            result.add(current.data);
            
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        
        return result;
    }
    
    // Get height of entire tree
    public int getTreeHeight() {
        return getHeight(root);
    }
    
    // Get height of a specific node
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }
    
    // Calculate balance factor for a node
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }
    
    /**
     * Performs a right rotation on the given node.
     * Used to balance the tree when left subtree is heavier.
     * 
     *     y                x
     *    / \              / \
     *   x   T3    -->    T1  y
     *  / \                  / \
     * T1  T2               T2 T3
     * 
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        
        // Perform rotation
        x.right = y;
        y.left = T2;
        
        // Update heights
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        
        return x;
    }
    
    /**
     * Performs a left rotation on the given node.
     * Used to balance the tree when right subtree is heavier.
     * 
     *   x                  y
     *  / \                / \
     * T1  y      -->     x   T3
     *    / \            / \
     *   T2 T3          T1 T2
     * 
     */
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        
        // Perform rotation
        y.left = x;
        x.right = T2;
        
        // Update heights
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        
        return y;
    }
    
    // Find node with smallest value in subtree
    private Node getMinValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    
    // Find smallest value in tree
    public int findMin() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return getMinValueNode(root).data;
    }
    
    // Find largest value in tree
    public int findMax() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        
        Node current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }
    
    // Check if tree follows AVL rules
    public boolean isAVL() {
        return isAVLRec(root);
    }
    
    // Recursive helper to check AVL property
    private boolean isAVLRec(Node node) {
        if (node == null) {
            return true;
        }
        
        int balance = getBalance(node);
        if (Math.abs(balance) > 1) {
            return false;
        }
        
        return isAVLRec(node.left) && isAVLRec(node.right);
    }
    
    // Show tree structure level by level
    /**
     * Displays the tree in a simple level-by-level format.
     * Shows each level of the tree on a separate line.
     */
    public void displayTree() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        
        System.out.println("AVL Tree (Level by Level):");
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            System.out.print("Level " + level + ": ");
            
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                if (current != null) {
                    System.out.print(current.data + "(h:" + current.height + ") ");
                    queue.offer(current.left);
                    queue.offer(current.right);
                } else {
                    System.out.print("null ");
                }
            }
            System.out.println();
            level++;
            
            // Stop if all remaining nodes are null
            boolean hasNonNull = false;
            for (Node node : queue) {
                if (node != null) {
                    hasNonNull = true;
                    break;
                }
            }
            if (!hasNonNull) break;
        }
    }
    
    // Test all AVL tree functions
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        
        // Test insertions
        System.out.println("1. Test Insertions:");
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45};
        
        for (int value : values) {
            tree.insert(value);
            System.out.println("Inserted: " + value + " | Tree size: " + tree.size());
        }
        
        System.out.println("\nTree after insertions:");
        tree.displayTree();
        
        // Test traversals
        System.out.println("\n2. TestTraversals:");
        System.out.println("In-order traversal: " + tree.inOrderTraversal());
        System.out.println("Pre-order traversal: " + tree.preOrderTraversal());
        System.out.println("Post-order traversal: " + tree.postOrderTraversal());
        System.out.println("Level-order traversal: " + tree.levelOrderTraversal());
        
        // Test search
        System.out.println("\n3. Test Search:");
        int[] searchValues = {40, 90};
        for (int value : searchValues) {
            System.out.println("Search " + value + ": " + tree.search(value));
        }
        
        // Test min/max
        System.out.println("\n4. Testing Min && Max:");
        System.out.println("Minimum value: " + tree.findMin());
        System.out.println("Maximum value: " + tree.findMax());
        System.out.println("Tree height: " + tree.getTreeHeight());
        
        // Test AVL property
        System.out.println("\n5. Test AVL Property:");
        System.out.println("Is valid AVL tree: " + tree.isAVL());
        
        // Test deletions
        System.out.println("\n6. Test Deletions:");
        int[] deleteValues = {20, 30};
        
        for (int value : deleteValues) {
            boolean deleted = tree.delete(value);
            System.out.println("Delete " + value + ": " + deleted + " | Tree size: " + tree.size());
            System.out.println("Is valid AVL tree: " + tree.isAVL());
        }
        
        System.out.println("\nTree after deletions:");
        tree.displayTree();
        
        // Test edge cases
        System.out.println("\n7. Test Edge Cases:");
        try {
            tree.insert(40); // This will throw an exeption
        } catch (IllegalArgumentException e) {
            System.out.println("Duplicate insertion handled: " + e.getMessage());
        }
        
        System.out.println("Delete non-existent value (999): " + tree.delete(999));
    }
}
