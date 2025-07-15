package codingquestions.leetcode;

/**
 * 872. Leaf-Similar Trees
 * Solved
 * Easy
 * Topics
 * Companies
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 **/

import java.util.ArrayList;
import java.util.List;

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
public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        returnleaf(root1, a);
        returnleaf(root2, b);

        return a.equals(b);

    }

    public void returnleaf(TreeNode root, List<Integer> a) {


        if (root.left == null && root.right == null) {
            a.add(root.val);
        } else if (root.left == null) {
            returnleaf(root.right, a);
        } else if (root.right == null) {
            returnleaf(root.left, a);
        } else {
            returnleaf(root.right, a);
            returnleaf(root.left, a);
        }


    }
}
