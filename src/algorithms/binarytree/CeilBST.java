package algorithms.binarytree;


/*
 * Ceil in Binary Search Tree (BST)
 *
 * The ceil of a value x in a BST is the smallest key
 * that is greater than or equal to x.
 *
 * The algorithm traverses the tree using BST properties:
 *  - Move right if the current key is less than x
 *  - Store the current node as a potential ceil and move left if it is greater than x
 *
 * Time Complexity:  O(h)
 * Space Complexity: O(1)
 * where h is the height of the BST.
 *
 * Example:
 *   Ceil(6) → 7
 */

public class CeilBST {

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

        Node ceil = ceil(root, 6);
        System.out.println("Ceil value for x=6 : "+ (ceil!=null ? ceil.key : -1) );
    }

    private static Node ceil(Node root, int x){
        Node res = null; //to keep track of upper value found

        while(root!=null){
            if(root.key == x) //if found exact value, return that node
                return root;
            else if(root.key < x) //if smaller value found, go towards right
                root = root.right;
            else{
                res = root; //store upper value found then check on left subtree
                root = root.left;
            }
        }

        return res; //after completion of loop, res will be closest upper value to x
    }


}
