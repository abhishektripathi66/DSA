package algorithms.binarytree;

public class BinarySearchTree {

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

        System.out.println("For x=10 : "+searchRec(root, 10));
        System.out.println("For x=12 : "+searchIterative(root, 12));
        
        //reassign the root, otherwise changes won't reflect
        root = insertRec(root, 3);

    }

    private static boolean searchRec(Node root, int x){
        if(root == null)
            return false;

        if(root.key == x)
            return true;
        else if(root.key < x)
            return searchRec(root.right, x);
        else
            return searchRec(root.left, x);
    }

    private static boolean searchIterative(Node root, int x){
        while(root != null){
            if(root.key == x)
                return true;
            else if(root.key < x)
                root = root.right;
            else
                root = root.left;
        }
        return false;
    }

    private static Node insertRec(Node root, int x){
        if(root == null)
            return new Node(x);
        
        if(root.key > x)
            root.left = insertRec(root.left, x);
        else if(root.key < x)
            root.right = insertRec(root.right, x);

        return root;
    }

    private static Node insertIterative(Node root, int x){
        Node temp = new Node(x);
        Node parent = null, curr = root;

        while(curr != null){
            parent = curr;

            if(curr.key > x)
                curr = curr.left;
            else if(curr.key < x)
                curr = curr.right;
            else
                return root;
        }

        if(parent == null)
            return temp;
        else if(parent.key > x)
            parent.left = temp;
        else
            parent.right = temp;

        return root;
    }
}

