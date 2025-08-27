/*
3459. Length of Longest V-Shaped Diagonal Segment
Solved
Hard
Topics
premium lock icon
Companies
Hint
You are given a 2D integer matrix grid of size n x m, where each element is either 0, 1, or 2.

A V-shaped diagonal segment is defined as:

The segment starts with 1.
The subsequent elements follow this infinite sequence: 2, 0, 2, 0, ....
The segment:
Starts along a diagonal direction (top-left to bottom-right, bottom-right to top-left, top-right to bottom-left, or bottom-left to top-right).
Continues the sequence in the same diagonal direction.
Makes at most one clockwise 90-degree turn to another diagonal direction while maintaining the sequence.


Return the length of the longest V-shaped diagonal segment. If no valid segment exists, return 0.

 

Example 1:

Input: grid = [[2,2,1,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]

Output: 5

Explanation:



The longest V-shaped diagonal segment has a length of 5 and follows these coordinates: (0,2) → (1,3) → (2,4), takes a 90-degree clockwise turn at (2,4), and continues as (3,3) → (4,2).

Example 2:

Input: grid = [[2,2,2,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]

Output: 4

Explanation:



The longest V-shaped diagonal segment has a length of 4 and follows these coordinates: (2,3) → (3,2), takes a 90-degree clockwise turn at (3,2), and continues as (2,1) → (1,0).

Example 3:

Input: grid = [[1,2,2,2,2],[2,2,2,2,0],[2,0,0,0,0],[0,0,2,2,2],[2,0,0,2,0]]

Output: 5

Explanation:



The longest V-shaped diagonal segment has a length of 5 and follows these coordinates: (0,0) → (1,1) → (2,2) → (3,3) → (4,4).

Example 4:

Input: grid = [[1]]

Output: 1

Explanation:

The longest V-shaped diagonal segment has a length of 1 and follows these coordinates: (0,0).

 

Constraints:

n == grid.length
m == grid[i].length
1 <= n, m <= 500
grid[i][j] is either 0, 1 or 2.
*/
class Solution {
    private static final int[] hx = {1, 1, -1, -1};
    private static final int[] hy = {1, -1, -1, 1};
    private int m, n;
    private int[][][][] dp;
    private int[][] grid;

    private int dfs(int x, int y, int dir, int hasTurned, int target){
        int nx = x + hx[dir], ny = y + hy[dir];
        if(nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] != target)
            return 0;
        
        int res = dp[nx][ny][dir][hasTurned];
        if(res != -1)
            return res;
        
        res = dfs(nx, ny, dir, hasTurned, 2 - target) + 1;
        if(hasTurned == 0)
            res = Math.max(res, dfs(nx, ny, (dir + 1) % 4, 1, 2 - target) + 1);
        
        dp[nx][ny][dir][hasTurned] = res;
        return res;
    }

    public int lenOfVDiagonal(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        dp = new int[m][n][4][2];

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                for(int k = 0; k < 4; k++)
                    for(int l = 0; l < 2; l++)
                        dp[i][j][k][l] = -1;
        
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    for(int dir = 0; dir < 4; dir++){
                        res = Math.max(res, dfs(i, j, dir, 0, 2) + 1);
                    }
                }
            }
        }

        return res;
    }
}
