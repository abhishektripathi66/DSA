package codingquestions.leetcode.ds;

/**
 * 700. Search in a Binary Search Tree
 * Solved
 * Easy
 * Topics
 * Companies
 * You are given the root of a binary search tree (BST) and an integer val.
 * <p>
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 **/

import DS.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class SearchinaBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode left = searchBST(root.left, val);
        if (left != null) return left;
        TreeNode right = searchBST(root.right, val);
        if (right != null) return right;
        else return null;

    }
}
