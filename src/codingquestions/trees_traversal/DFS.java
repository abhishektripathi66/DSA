package codingquestions.trees_traversal;

import java.util.Arrays;

public class DFS {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    class Node {
        public int val;
        public BFS.Node left;
        public BFS.Node right;
        public BFS.Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, BFS.Node _left, BFS.Node _right, BFS.Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    // Q1) Diameter of a Binary Tree
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        traversal(root);
        return diameter-1;
    }

    public int traversal(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = traversal(node.left);
        int right = traversal(node.right);

        int dia = left+right + 1;
        diameter = Math.max(dia, diameter);
        return Math.max(left, right) +1;
    }

    // Q2) Invert Binary Tree
    public TreeNode invertTree(TreeNode root) {
        return traversal1(root);
    }

    public TreeNode traversal1(TreeNode node){
        if(node == null){
            return null;
        }

        traversal1(node.left);
        traversal1(node.right);

        node.left = node.right;
        node.right = node.left;

        return node;
    }

    // Q3) Maximum Depth of Binary Tree
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right)+1;
    }

    // Q4) Convert Sorted Array to Binary Search Tree
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }

    public TreeNode helper(int[] nums, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start+(end-start)/2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = helper(nums, start, mid-1);
        node.right = helper(nums, mid+1, end);

        return node;
    }

    // Q5) Flatten Binary Tree to Linked List
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while(current != null){
            if(current.left != null){
                TreeNode temp = current.left;
                while(temp.right != null){
                    temp = temp.right;
                }

                temp.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }

    // Q6) Validate Binary Search Tree
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    private boolean helper(TreeNode node, Integer low, Integer high){
        if(node == null){
            return true;
        }

        if(low != null && node.val <= low){
            return false;
        }
        if(high != null && node.val >= high){
            return false;
        }

        boolean left = helper(node.left, low, node.val);
        boolean right = helper(node.right, node.val, high);

        return left && right;
    }

    // Q7) Lowest common ancestor of a binary tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        return (left == null ? right : left);
    }

    // Q8) Kth Smallest element in BST
    int count = 0;
    int result = -1;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }

    public void inorder(TreeNode root, int k){
        if(root == null || result != -1){
            return;
        }

        int left = kthSmallest(root.left, k);
        count += 1;
        if(count == k){
            result = root.val;
            return;
        }
        int right = kthSmallest(root.right, k);
    }

    // Q9) Construct Binary Tree from Preorder and Inorder Traversal
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        int rootVal = preorder[0];
        int index = 0;

        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == rootVal){
                index = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTree(Arrays.copyOfRange(preorder, 1, index+1), Arrays.copyOfRange(inorder, 0, index));
        root.right = buildTree(Arrays.copyOfRange(preorder, index+1, preorder.length), Arrays.copyOfRange(inorder, index+1, inorder.length));

        return root;
    }

    // Q10) Path Sum
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }

        if(root.val == targetSum && root.left == null && root.right == null){
            return true;
        }

        boolean left = hasPathSum(root.left, targetSum-root.val);
        boolean right = hasPathSum(root.right, targetSum- root.val);

        return left || right;
    }
}
