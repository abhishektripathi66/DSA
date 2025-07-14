package codingquestions.leetcode;

/**
 * 199. Binary Tree Right Side View
 * Solved
 * Medium
 * Topics
 * Companies
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 */

import java.util.*;

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


public class BinaryTreeRightSideView {
    int maxlevel = 0;

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        right(root, 1, list);
        return list;
    }

    void right(TreeNode root, int level, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (maxlevel < level) {
            list.add(root.val);
            maxlevel = level;
        }
        right(root.right, level + 1, list);
        right(root.left, level + 1, list);

    }
}
