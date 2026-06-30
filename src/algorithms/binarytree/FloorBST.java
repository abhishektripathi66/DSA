package algorithms.binarytree;

/*
 * Floor in Binary Search Tree (BST)
 *
 * The floor of a value x in a BST is the greatest key
 * that is less than or equal to x.
 *
 * The algorithm traverses the tree using BST properties:
 *  - Move left if the current key is greater than x
 *  - Store the current node as a potential floor and move right if it is smaller than x
 *
 * Time Complexity:  O(h)
 * Space Complexity: O(1)
 * where h is the height of the BST.
 *
 * Example:
 *   Floor(3) → 2
 */

public class FloorBST {

    static class Node{
        int key;
        Node left;
        Node right;

        Node(int key){
            this.key = key;
        }
    }

    public static void main(String[] args) {

         /* For following binary search tree
                 5
                / \
               2   10
              /    /
            1    7
        */

        Node root = new Node(5);
        root.left = new Node(2);
        root.left.left = new Node(1);
        root.right = new Node(10);
        root.right.left = new Node(7);


        Node floor = floor(root, 3);
        System.out.println("Floor value for x=3 : "+ (floor!=null ? floor.key : -1) );
        
    }

    private static Node floor(Node root, int x){
        Node res = null; //to keep track of lower value

        while(root!=null){
            if(root.key == x) //if found passed value, return that node
                return root;
            else if(root.key > x)
                root = root.left;
            else{
                res = root;
                root = root.right;
            }
        }

        return res; //after loop, res will be closest smaller value
    } 
}
