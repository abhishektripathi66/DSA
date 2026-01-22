package algorithms.binarytree;

public class HeightOfBinaryTree {

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

        System.out.println("Height of given binary tree : "+heightOfBinaryTree(root));
    }

    private static int heightOfBinaryTree(Node root){

        //return 0 for null
        if(root == null)
            return 0;
    
        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);

        //take max from left and right heights and add 1 for current node
        return Math.max(leftHeight, rightHeight)+1;
    }
}
