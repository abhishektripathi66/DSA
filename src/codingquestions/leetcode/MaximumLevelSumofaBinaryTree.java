/**
 * 1161. Maximum Level Sum of a Binary Tree
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * <p>
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 **/

// Using Arrays

import java.util.HashMap;
import java.util.Map;

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
public class MaximumLevelSumofaBinaryTree {
    int maxSum;
    int levels;
    int[] arrSum = new int[10001];

    public int maxLevelSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        levels = 1;
        int ret = 0;
        findLevelSum(root, levels);
        System.out.println(levels);
        for (int i = 1; i <= levels; i++) {
            if (arrSum[i] > maxSum) {
                maxSum = arrSum[i];
                ret = i;

            }

        }
        return ret;
    }

    public void findLevelSum(TreeNode root, int level) {
        if (root == null) return;

        findLevelSum(root.left, level + 1);
        findLevelSum(root.right, level + 1);
        arrSum[level] += root.val;
        levels = Math.max(levels, level);

    }

}

//Using Map

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
class MaximumLevelSumofaBinaryTree1 {
    int maxSum;
    int levels;
    Map<Integer, Integer> m = new HashMap<>();

    public int maxLevelSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        levels = 1;
        findLevelSum(root, levels);

        for (Map.Entry<Integer, Integer> ma : m.entrySet()) {
            if (ma.getValue() > maxSum) {
                maxSum = ma.getValue();
                levels = ma.getKey();
            }

        }
        return levels;
    }

    public void findLevelSum(TreeNode root, int level) {
        if (root == null) return;

        m.put(level, m.getOrDefault(level, 0) + root.val);

        findLevelSum(root.left, level + 1);
        findLevelSum(root.right, level + 1);


    }

}
