/**
700. Search in a Binary Search Tree
Easy
Topics
Companies
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
  **/
public class FindtheOriginalTypedStringI {
    public int possibleStringCount(String word) {
        int count=1;
        for(int i=1;i<word.length();i++){
            if(word.charAt(i)==word.charAt(i-1)){
                count++;
            }
        }
        return count;
    }
}
