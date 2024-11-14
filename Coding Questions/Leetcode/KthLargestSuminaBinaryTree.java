/**
2583. Kth Largest Sum in a Binary Tree
Solved
Medium
Topics
Companies
Hint
You are given the root of a binary tree and a positive integer k.

The level sum in the tree is the sum of the values of the nodes that are on the same level.

Return the kth largest level sum in the tree (not necessarily distinct). If there are fewer than k levels in the tree, return -1.

Note that two nodes are on the same level if they have the same distance from the root.
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
    private long[] sums = new long[100000];
    private int maxLevel = 0;

    private void solve(TreeNode root, int lvl) {
        if (root == null) return;

        // Add the node's value to its level sum
        sums[lvl] += root.val;

        // Update the maximum level
        maxLevel = Math.max(maxLevel, lvl);

        solve(root.left, lvl + 1);
        solve(root.right, lvl + 1);
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        solve(root, 0);

        // Sort only the part of sums that has non-zero values, i.e., up to maxLevel + 1
        Long[] validSums = new Long[maxLevel + 1];
        for (int i = 0; i <= maxLevel; i++) {
            validSums[i] = sums[i];
        }
        Arrays.sort(validSums, Collections.reverseOrder());

        // Check if the k-th largest level exists
        return (k > maxLevel + 1) ? -1 : validSums[k - 1];
    }
}
