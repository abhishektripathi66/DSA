/**
102. Binary Tree Level Order Traversal
Solved
Medium
Topics
Companies
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
  **/

import java.util.*;

import DS.TreeNode;

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
public class BinaryTreeLevelOrderTraversal {
    List<List<Integer>> a = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        levelOrderhelper(root,0);
        return a;

    }

    public void levelOrderhelper(TreeNode root,int level){
        if(root == null) return;
        if(a.size()== level) a.add(level,new ArrayList<>());
        a.get(level).add(root.val);
        levelOrderhelper(root.left,level+1);
        levelOrderhelper(root.right,level+1);
    }
}
