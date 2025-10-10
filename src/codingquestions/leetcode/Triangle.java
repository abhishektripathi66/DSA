package codingquestions.leetcode;
import java.util.*;
/*
120. Triangle
Solved
Medium
Topics
premium lock icon
Companies
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
Example 2:

Input: triangle = [[-10]]
Output: -10
 

Constraints:

1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104
 

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
*/
class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] res = new int[202][202];
        for(int i = 0; i < triangle.size(); i++){
            for(int j = 0; j <= i; j++)
                res[i][j] = 1000000000;
        }

        res[0][0] = triangle.get(0).get(0);
        for(int i = 0; i < triangle.size() - 1; i++){
            //row i: i + 1 elements
            for(int j = 0; j <= i; j++){
                if(res[i][j] == 1000000000)
                    continue;
                
                res[i + 1][j] = Math.min(res[i + 1][j], res[i][j] + triangle.get(i + 1).get(j));
                res[i + 1][j + 1] = Math.min(res[i + 1][j + 1], res[i][j] + triangle.get(i + 1).get(j + 1));
            }
        }

        int ans = 1000000000;
        for(int i = 0; i < triangle.size(); i++)
            ans = Math.min(ans, res[triangle.size() - 1][i]);
        
        return ans;
    }
}
