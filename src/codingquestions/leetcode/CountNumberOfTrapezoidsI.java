/*
3623. Count Number of Trapezoids I
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given a 2D integer array points, where points[i] = [xi, yi] represents the coordinates of the ith point on the Cartesian plane.

A horizontal trapezoid is a convex quadrilateral with at least one pair of horizontal sides (i.e. parallel to the x-axis). Two lines are parallel if and only if they have the same slope.

Return the number of unique horizontal trapezoids that can be formed by choosing any four distinct points from points.

Since the answer may be very large, return it modulo 109 + 7.

 

Example 1:

Input: points = [[1,0],[2,0],[3,0],[2,2],[3,2]]

Output: 3

Explanation:



There are three distinct ways to pick four points that form a horizontal trapezoid:

Using points [1,0], [2,0], [3,2], and [2,2].
Using points [2,0], [3,0], [3,2], and [2,2].
Using points [1,0], [3,0], [3,2], and [2,2].
Example 2:

Input: points = [[0,0],[1,0],[0,1],[2,1]]

Output: 1

Explanation:



There is only one horizontal trapezoid that can be formed.

 

Constraints:

4 <= points.length <= 105
–108 <= xi, yi <= 108
All points are pairwise distinct.
*/
class Solution {
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < points.length; i++)
            mp.put(points[i][1], mp.getOrDefault(points[i][1], 0) + 1);

        long res = 0, MOD = 1000000000 + 7;
        long cur = 0;
        for(Integer val : mp.values()){
            System.out.println(val);
            res = (res + cur * val * (val - 1) / 2) % MOD;
            cur = (cur + (long)val * (val - 1) / 2) % MOD;
        }
        return (int)res;
    }
}
