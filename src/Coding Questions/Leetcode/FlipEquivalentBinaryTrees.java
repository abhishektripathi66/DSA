/**
951. Flip Equivalent Binary Trees
Solved
Medium
Topics
Companies
For a binary tree T, we can define a flip operation as follows: choose any node, and swap the left and right child subtrees.

A binary tree X is flip equivalent to a binary tree Y if and only if we can make X equal to Y after some number of flip operations.

Given the roots of two binary trees root1 and root2, return true if the two trees are flip equivalent or false otherwise.

 **/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  public boolean flipEquiv(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null)
      return true;

    if (node1 == null || node2 == null || node1.val != node2.val)
      return false;

    return (flipEquiv(node1.left, node2.left) && flipEquiv(node1.right, node2.right)) ||
        (flipEquiv(node1.left, node2.right) && flipEquiv(node1.right, node2.left));
  }
}
