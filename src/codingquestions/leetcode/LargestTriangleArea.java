/*
812. Largest Triangle Area
Solved
Easy
Topics
premium lock icon
Companies
Given an array of points on the X-Y plane points where points[i] = [xi, yi], return the area of the largest triangle that can be formed by any three different points. Answers within 10-5 of the actual answer will be accepted.

 

Example 1:


Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
Output: 2.00000
Explanation: The five points are shown in the above figure. The red triangle is the largest.
Example 2:

Input: points = [[1,0],[0,0],[0,1]]
Output: 0.50000
 

Constraints:

3 <= points.length <= 50
-50 <= xi, yi <= 50
All the given points are unique.
*/
class Solution {
    private int doubleArea(int[] a, int[] b, int[] c){
        //return AB x AC
        int res = (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]);
        return Math.abs(res);
    }
    public double largestTriangleArea(int[][] points) {
        int res = 0;
        for(int i = 0; i < points.length; i++)
            for(int j = i + 1; j < points.length; j++)
                for(int k = j + 1; k < points.length; k++)
                    res = Math.max(res, doubleArea(points[i], points[j], points[k]));
        
        double ans = (double)(res) / 2.0;
        return ans;
    }
}
