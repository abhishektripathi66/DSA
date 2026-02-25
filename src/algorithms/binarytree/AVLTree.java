package algorithms.binarytree;

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
}
