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

        System.out.println("Search for x=10 : "+searchRec(root, 10));
        System.out.println("Search for x=12 : "+searchIterative(root, 12));
        
        System.out.println("\nSearch for x=3 : "+searchIterative(root, 3));
        //reassign the root, otherwise changes won't reflect
        root = insertRec(root, 3);
        System.out.println("After insertion, search for x=3 : "+searchRec(root, 3));

        root = delNode(root, 10);
        System.out.println("\nAfter deletion, search for x=10 : "+searchRec(root, 10));
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

    //3 cases for a node to be deleted
    //leaf node -> delete directly
    //non-leaf node with single child -> replace with child
    //non-leaf node with two children -> replace with closest higher or lower valued child, have to follow either of the ways everytime
    private static Node delNode(Node root, int x){
        if(root == null)
            return null;

        //first reach towards correct node
        if(root.key > x)
            root.left = delNode(root.left, x);
        else if(root.key < x)
            root.right = delNode(root.right, x);
        //then check conditions either leaf, non-leaf one child, or non-leaf two children
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                Node succ = getSucc(root);
                root.key = succ.key;
                root.right = delNode(root.right, succ.key);
            }
        }
        return root;
    }

    private static Node getSucc(Node root){
        if(root == null) //won't occur
            return null;
        
        Node curr = root.right; //if chosen left child, then have to go rightside afterwards
        while(curr!=null && curr.left!=null)
            curr = curr.left;

        return curr; //minimum higher value compared to root
    }
}

