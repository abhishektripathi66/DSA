package codingquestions.leetcode;

import java.util.*;

/*
118. Pascal's Triangle
Solved
Easy
Topics
premium lock icon
Companies
Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:


 

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30
*/
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curRow = new ArrayList<>();
        curRow.add(1);
        res.add(curRow);
        for(int iter = 2; iter <= numRows; iter++){
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for(int i = 1; i < curRow.size(); i++)
                newRow.add(curRow.get(i - 1) + curRow.get(i));
            
            newRow.add(1);
            res.add(newRow);
            curRow = newRow;
        }
        return res;
    }
}
