package codingquestions.leetcode;

/*
498. Diagonal Traverse
Solved
Medium
Topics
premium lock icon
Companies
Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

 

Example 1:


Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,4,7,5,3,6,8,9]
Example 2:

Input: mat = [[1,2],[3,4]]
Output: [1,2,3,4]
 

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
-105 <= mat[i][j] <= 105
*/
/*
(0, 0) -> (0, 0)
(0, 1) -> (1, 0)
(2, 0) -> (0, 2)
(0, 3) -> (3, 0)
(4, 0) -> (0, 4)
(0, 5) -> (5, 0)

(0, i) -> (i, 0)
*/
class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int cur = 0;
        int rx = 0, ry = 0, lx = 0, ly = 0;
        for(int i = 0; i < m + n - 1; i++){
            //Up-right: (0, i)
            if(i < n){
                rx = 0;
                ry = i;
            } else{
                //i >= n
                rx = i - n + 1;
                ry = n - 1;
            }

            //Down-left: (i, 0)
            if(i < m){
                lx = i;
                ly = 0;
            } else{
                lx = m - 1;
                ly = i - m + 1;
            }

            if((i & 1) > 0){
                while(rx <= lx)
                    res[cur++] = mat[rx++][ry--];
            }
            else{
                while(lx >= rx)
                    res[cur++] = mat[lx--][ly++];
            }
        }
        return res;
    }
}
