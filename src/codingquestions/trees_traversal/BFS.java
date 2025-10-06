package codingquestions.trees_traversal;

import java.util.*;

public class BFS {
    public static class TreeNode {
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
          public Node left;
          public Node right;
          public Node next;
  
          public Node() {}
  
          public Node(int _val) {
              val = _val;
          }
  
          public Node(int _val, Node _left, Node _right, Node _next) {
              val = _val;
              left = _left;
              right = _right;
              next = _next;
          }
      };
  
      // BFS. Q1) Binary Tree level order traversal.
      public List<List<Integer>> levelOrder(TreeNode root) {
          List<List<Integer>> result = new ArrayList<>(); // List of List (the outer list)
  
          if (root == null) { // Base case.
              return result;
          }
  
          Queue<TreeNode> queue = new LinkedList<>(); // here the type is TreeNode as we are storing the tree nodes in queue.
          queue.offer(root); // store the first element root.
  
          while (!queue.isEmpty()) {
              int levelsize = queue.size(); // size of every level.
              List<Integer> currentlevel = new ArrayList<>(levelsize); // Internal list
              for (int i = 0; i < levelsize; i++) { // Iterate the every level.
                  TreeNode currentNode = queue.poll(); // removing the front Node from the queue and storing it in "currentNode"
                  currentlevel.add(currentNode.val); // Storing the values of every level.
                  if(currentNode.left != null){
                      queue.offer(currentNode.left); // adding the left node in the queue
                  }
                  if(currentNode.right != null){
                      queue.offer(currentNode.right); // adding the right node in the queue
                  }
              }
              result.add(currentlevel); // adding the internal list in the outer list
          }
          return result; // returning the outer list
      }
  
      // Q2) Binary Tree level order traversal II.
      public List<List<Integer>> levelOrderBottom(TreeNode root) {
          List<List<Integer>> result = new ArrayList<>();
  
          if(root == null){
              return result;
          }
  
          Queue<TreeNode> queue = new LinkedList<>();
          queue.offer(root);
  
          while(!queue.isEmpty()){
              int levelSize = queue.size();
              List<Integer> currentlevel = new ArrayList<>(levelSize);
              for(int i=0; i<levelSize; i++){
                  TreeNode currentNode = queue.poll();
                  currentlevel.add(currentNode.val);
                  if(currentNode.left != null){
                      queue.offer(currentNode.left);
                  }
                  if(currentNode.right != null){
                      queue.offer(currentNode.right);
                  }
              }
              result.addFirst(currentlevel);
          }
          return result;
      }
  
      // Google. Q3) Average of Levels in Binary Tree
      public List<Double> averageOfLevels(TreeNode root) {
          List<Double> result = new ArrayList<>();
  
          if(root == null){
              return result;
          }
  
          Queue<TreeNode> queue = new LinkedList<>();
          queue.offer(root);
  
          while(!queue.isEmpty()){
              int levelsize = queue.size();
              double averageLevel = 0; // initializing averageLevel to 0
              for(int i=0; i<levelsize; i++){
                  TreeNode currentNode = queue.poll();
                  averageLevel += currentNode.val; // adding the value of currentNode in averageLevel
                  if(currentNode.left != null){
                      queue.offer(currentNode.left);
                  }
                  if(currentNode.right != null){
                      queue.offer(currentNode.right);
                  }
              }
              averageLevel = averageLevel/levelsize; // calculating the average
              result.add(averageLevel);
          }
          return result;
      }
  
      // Google. Q4) Level order Successor of a node.
      public TreeNode findSuccessor(TreeNode root, int key){
          if(root == null){
              return null;
          }
  
          Queue<TreeNode> queue = new LinkedList<>();
          queue.offer(root);
  
          while(!queue.isEmpty()){
              TreeNode currentNode = queue.poll();
              if(currentNode.left != null){
                  queue.offer(currentNode.left);
              }
              if(currentNode.right != null){
                  queue.offer(currentNode.right);
              }
              if(currentNode.val == key){
                  break;
              }
          }
          return queue.peek();
      }
  
      // Q5) Zigzag level order traversal.
      public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
          List<List<Integer>> result = new ArrayList<>();
  
          if(root == null){
              return result;
          }
  
          Deque<TreeNode> queue = new LinkedList<>();
          queue.offer(root);
  
          boolean reverse = false;
  
          while(!queue.isEmpty()){
              int levelsize = queue.size();
              List<Integer> internal = new ArrayList<>(levelsize);
              for(int i=0; i<levelsize; i++){
                  if(!reverse){
                      TreeNode currentNode = queue.pollFirst();
                      internal.add(currentNode.val);
                      if(currentNode.left != null){
                          queue.addLast(currentNode.left);
                      }
                      if(currentNode.right != null){
                          queue.addLast(currentNode.right);
                      }
                  }else{
                      TreeNode currentNode = queue.pollLast();
                      internal.add(currentNode.val);
                      if(currentNode.right != null){
                          queue.addFirst(currentNode.right);
                      }
                      if(currentNode.left != null){
                          queue.addFirst(currentNode.left);
                      }
                  }
              }
              reverse = !reverse;
              result.add(internal);
          }
          return result;
      }
  
      // Q6) Populating Next Right Pointers in Each Node
      // Without using a queue
      // It is optimised O(1)
      public Node connect(Node root) {
          if(root == null){
              return root;
          }
  
          Node leftMost = root;
  
          while(leftMost.left != null){
              Node current = leftMost;
              while(current != null){
                  current.left.next = current.right;
                  if(current.next != null){
                      current.right.next = current.next.left;
                  }
                  current = current.next;
              }
              leftMost = leftMost.left;
          }
          return root;
      }
  
      // Q7) Binary Tree Right Side View
      public List<Integer> rightSideView(TreeNode root) {
          List<Integer> result = new ArrayList<>();
  
          if(root == null){
              return result;
          }
  
          Queue<TreeNode> queue = new LinkedList<>();
          queue.offer(root);
  
          while(!queue.isEmpty()){
              int levelSize = queue.size();
              for(int i=0; i<levelSize; i++){
                  TreeNode currentNode = queue.poll();
                  if(i == levelSize-1){
                      result.add(currentNode.val);
                  }
                  if(currentNode.left != null){
                      queue.offer(currentNode.left);
                  }
                  if(currentNode.right != null){
                      queue.offer(currentNode.right);
                  }
              }
          }
          return result;
      }
  
      // Q9) Symmetric Tree
      public boolean isSymmetric(TreeNode root) {
          Queue<TreeNode> queue = new LinkedList<>();
          queue.offer(root.left);
          queue.offer(root.right);
  
          while(!queue.isEmpty()){
              TreeNode left = queue.poll();
              TreeNode right = queue.poll();
  
              if(left == null && right == null){
                  continue;
              }
              if(left == null || right == null){
                  return false;
              }
              if(left.val != right.val){
                  return false;
              }
  
              queue.offer(left.left);
              queue.offer(right.right);
              queue.offer(left.right);
              queue.offer(right.left);
          }
          return true;
      }
}
