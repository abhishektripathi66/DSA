package codingquestions.leetcode;

/**
 * 1448. Count Good Nodes in Binary Tree
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * <p>
 * Return the number of good nodes in the binary tree.
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
public class CountGoodNodesinBinaryTree {

    int count = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        findgood(root, root.val);
        return count;

    }

    public void findgood(TreeNode root, int max) {
        if (root == null) return;
        if (root.val >= max) {
            count++;
            max = root.val;
        }
        findgood(root.left, max);
        findgood(root.right, max);
    }
}
