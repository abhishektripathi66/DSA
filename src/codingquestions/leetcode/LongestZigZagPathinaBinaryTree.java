package codingquestions.leetcode;

/**
 * 1372. Longest ZigZag Path in a Binary Tree
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given the root of a binary tree.
 * <p>
 * A ZigZag path for a binary tree is defined as follow:
 * <p>
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
 * Change the direction from right to left or from left to right.
 * Repeat the second and third steps until you can't move in the tree.
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 * <p>
 * Return the longest ZigZag path contained in that tree.
 **/

import codingquestions.leetcode.ds.TreeNode;

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
public class LongestZigZagPathinaBinaryTree {
    int count = 0;

    public int longestZigZag(TreeNode root) {

        findZigZag(root, false, count);
        return count;
    }

    public void findZigZag(TreeNode root, boolean isLeft, int NodeCount) {
        if (root == null) return;
        count = Math.max(count, NodeCount);
        if (isLeft == true) {

            findZigZag(root.right, true, 1);
            findZigZag(root.left, false, ++NodeCount);

        } else {
            findZigZag(root.right, true, ++NodeCount);
            findZigZag(root.left, false, 1);
        }
    }
}
