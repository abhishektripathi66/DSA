package algorithms.binarytree;

/*
 * AVL Tree
 *
 * An AVL Tree is a self-balancing Binary Search Tree (BST) where the height
 * difference between the left and right subtree of any node (called the
 * balance factor) is at most 1.
 *
 * Balance Factor:
 *      balance = height(left subtree) - height(right subtree)
 *
 * If the balance factor becomes less than -1 or greater than 1 after an
 * insertion or deletion, the tree performs rotations to restore balance.
 *
 * Rotations Used for Rebalancing:
 *  - Left Rotation (RR case)
 *  - Right Rotation (LL case)
 *  - Left-Right Rotation (LR case)
 *  - Right-Left Rotation (RL case)
 *
 * These rotations ensure that the tree remains approximately balanced,
 * guaranteeing efficient operations.
 *
 * Supported Operations:
 *  - Search
 *  - Insert (with rebalancing)
 *  - Delete (with rebalancing)
 *  - Tree Rotations (Left and Right)
 *
 * Time Complexity:
 *  - Search:     O(log n)
 *  - Insert:     O(log n)
 *  - Delete:     O(log n)
 *
 * Because the tree remains balanced, the height of an AVL tree is
 * always O(log n).
 *
 * Space Complexity:
 *  - Recursive operations: O(log n) due to recursion stack
 *  - Iterative operations: O(1)
 *
 * Example AVL Tree:
 *
 *           30
 *          /  \
 *        20    40
 *       /  \
 *     10   25
 *
 *   Insert(50) → may cause imbalance → rotation performed
 */

public class AVLTree {

    static class Node{
        int key;
        Node left, right;
        int height;

        Node(int key){
            this.key = key;
            height = 1;
        }
    }

    public static void main(String[] args) {
         Node root = null; 
        
        // Constructing tree given in the above figure 
        root = insert(root, 10); 
        root = insert(root, 20); 
        root = insert(root, 30); 
        root = insert(root, 40); 
        root = insert(root, 50); 
        root = insert(root, 25); 

        
        /* The constructed AVL Tree would be 
                  30 
                /   \ 
              20     40 
             /  \      \ 
           10   25     50 
        */

        preOrder(root);
        root = delete(root, 20);
        System.out.println("\nAfter deleting 20:");
        preOrder(root);

    }


    //height of tree
    private static int height(Node node){
        if(node == null)
            return 0;
        return node.height;
    }

    //to get balance factor of a node
    private static int getBalance(Node node){
        if(node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    /*       
    For keys(T1) < key(x) < keys(T2) < key(y) < keys(T3)

                y            Right rotate (at y)               x
               / \      ------------------------------->      / \
              x   T3    <------------------------------      T1   y
             / \              Left rotate (at x)                 / \
           T1   T2                                              T2   T3
    */

    //utility function to right rotate subtree rooted with Y
    private static Node rightRotate(Node y){

        //take references of the nodes required for rotation 
        Node x = y.left;
        Node t2 = x.right;

        //perform rotation
        x.right = y;
        y.left = t2;

        //updagte height of y first then x because x height depends upon y
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        //return new root
        return x;
    }

    //utility function to left rotate substree rooted with X
    private static Node leftRotate(Node x){
        //take requried references of the nodes 
        Node y = x.right;
        Node t2 = y.left;

        //peform rotation
        y.left = x;
        x.right = t2;

        //updagte height of x first then y
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        //return new root
        return y;
    }


    //balance factor > 1 then tree/substree is left heavy
    //balance factor < -1 then tree/substree is right heavy
    //4 Cases for imbalanced tree/substree
    //Left-Left Case : when new node is inserted into left subtree of left child -> single right rotation
    //Right-Right Case: when new node is inserted into right substree of right child -> single left rotation
    //Left-Right Case: new node is inserted into right substree of left child -> left rotation on left child so it becomes Left-Left case so right rotation on current node
    //Right-Left Case: new node is inserted into left substree of right child -> right rotation on right child then left rotation on current node
    private static Node insert(Node node, int key){

        //normal BST insertion
        if(node == null)
            return new Node(key);


        if(key < node.key)
            node.left = insert(node.left, key);
        else if(key > node.key)
            node.right = insert(node.right, key);
        else //duplicate values are not allowed
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        //check balance factor
        int balance = getBalance(node);

        //check 4 cases to verify and manage if tree/substree is imbalanced
        //LL Case
        if(balance > 1 && key < node.left.key){
             return rightRotate(node);
        }
        
        //RR Case
        if(balance < -1 && key > node.right.key){
            return leftRotate(node);
        }
        
        //LR Case
        if(balance > 1 && key > node.left.key){
            node.left = leftRotate(node.left);
            //after left rotation, it becomes LL Case so single right rotation on node 
            return rightRotate(node);
        }
        
        //RL Case
        if( balance < -1 && key < node.right.key){
            node.right = rightRotate(node.right);
            //RR case occurs, then to handle RR Case left rotation on current node
            return leftRotate(node);
        }

        return node;
    }

    private static Node delete(Node node, int key){
        //normal BST deletion
        if(node == null)
            return null;
    
        if(node.key > key)
            node.left = delete(node.left, key);
        else if(node.key < key)
            node.right = delete(node.right, key);
        else{
            if(node.left == null)
                return node.right; //parent function call will rebalance the height
            else if(node.right == null)
                return node.left;
            else{
                //replace with either smallest greatest value or greatest smallest value if both children are not null
                Node succ = getSuccessor(node);
                node.key = succ.key;
                node.right = delete(node.right, succ.key);

            }
        }

        //Same rotaion logic done in insert operation
        //since deleteion is performed, balance of the child node is considered instead of key comparision
        //same getBalance method can be used while inserting as well
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        //LL Case
        if(balance > 1 && getBalance(node.left) >= 0){ //left child balance -> 1 or 0
             return rightRotate(node);
        }
        
        //RR Case
        if(balance < -1 && getBalance(node.right) <= 0){//right child balance -> 0 or -1
            return leftRotate(node);
        }
        
        //LR Case
        if(balance > 1 && getBalance(node.left) < 0){ //left child balance -1
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        
        //RL Case
        if( balance < -1 && getBalance(node.right) > 0){ //right child balance 1
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    //method to get inorder successor, inorder predessor can be used as well
    private static Node getSuccessor(Node node){ 
        if(node == null)
            return null;

        Node curr = node.right;

        while(curr!=null && curr.left!=null)
            curr = curr.left;

        return curr;
    }

    //print preorder traversal
    private static void preOrder(Node root) { 
        if (root != null) { 
            System.out.print(root.key + " "); 
            preOrder(root.left); 
            preOrder(root.right); 
        } 
    } 
}
