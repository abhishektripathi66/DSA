package algorithms.binarytree;

import java.util.LinkedList;
import java.util.Queue;


/*
 * Binary Tree Traversals
 *
 * Given a binary tree, traverse all its nodes in a specific order.
 * Traversal means visiting every node exactly once.
 *
 * There are two main categories of traversals:
 *
 * 1. Breadth-First Search (BFS) / Level Order Traversal
 *    - Visits nodes level by level from left to right
 *    - Uses a queue data structure
 *
 * 2. Depth-First Search (DFS)
 *    a) Inorder Traversal   (Left → Root → Right)
 *    b) Preorder Traversal (Root → Left → Right)
 *    c) Postorder Traversal(Left → Right → Root)
 *    - Uses recursion or an explicit stack
 *
 * Time Complexity:
 *    - O(n) for all traversals, where n is the number of nodes
 *
 * Space Complexity:
 *    - BFS: O(w), where w is the maximum width of the tree (worst case O(n))
 *    - DFS: O(h), where h is the height of the tree
 *           → Balanced tree: O(log n)
 *           → Skewed tree: O(n)
 *
 * Example Tree:
 *          5
 *         / \
 *       10   20
 *       /    /
 *     25    30
 *
 * BFS (Level Order):     5 10 20 25 30
 * Inorder Traversal:    25 10 5 30 20
 * Preorder Traversal:   5 10 25 20 30
 * Postorder Traversal:  25 10 30 20 5
 */

public class BFSAndDFSTraversal{

    static class Node{
        int key;
        Node left;
        Node right;

        Node(int key){
            this.key = key;
        }
    }

    public static void main(String[] args) {
        /* given tree representation
                 5
                / \
               10   20
              /    /
            25    30
        */
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(25);
        root.right.left = new Node(30);

        System.out.println("BFS Traversal : ");
        bfsTraversal(root);
        System.out.println();

        System.out.println("DFS Traversals :");
        System.out.print("Inorder traversal : ");
        inorderTraversal(root);
        System.out.println();

        System.out.print("Preorder traversal : ");
        preorderTraversal(root);
        System.out.println();

        System.out.print("Postorder traversal : ");
        postorderTraversal(root);
        System.out.println();
    }

    //Time complexity: O(n), Space Complexity:(w), n = number of nodes, w = max nodes at any level(max width of tree), worst case: O(n/2)=>(n)
    private static void bfsTraversal(Node root){
        //return in case if root is null
        if(root == null) 
            return;

        //intialize queue for level-by-level traversal
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){//while queue is not empty

            int size = q.size(); //get size to proceed nodes on current level

            for(int i=0; i<size; i++){
                Node curr = q.poll();

                System.out.print(curr.key+" ");

                //if children present for curr node, add them to proceed in upcoming level
                if(curr.left!=null)
                    q.add(curr.left);

                if(curr.right!=null)
                    q.add(curr.right);
            }

            System.out.println(""); //for new line
        }
    }

    // Time complexity: O(n), Space complexity: O(height of tree), so average case: O(log n); worst case: O(n)
    private static void inorderTraversal(Node root){
        if(root == null)
            return;
        //proceed left child first, then curr node, then right child
        inorderTraversal(root.left);
        System.out.print(root.key+" ");
        inorderTraversal(root.right);
    }

    private static void preorderTraversal(Node root){
        if(root == null)
            return;
        //curr node, left child, right child
        System.out.print(root.key+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    private static void postorderTraversal(Node root){
        if(root == null)
            return;
        //left child, right child, curr node
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.key+" ");
    }
}