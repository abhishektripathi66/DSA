/*
1970. Last Day Where You Can Still Cross
Solved
Hard
Topics
premium lock icon
Companies
Hint
There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.

Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).

You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).

Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.

 

Example 1:


Input: row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
Output: 2
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 2.
Example 2:


Input: row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]
Output: 1
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 1.
Example 3:


Input: row = 3, col = 3, cells = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]
Output: 3
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 3.
 

Constraints:

2 <= row, col <= 2 * 104
4 <= row * col <= 2 * 104
cells.length == row * col
1 <= ri <= row
1 <= ci <= col
All the values of cells are unique.
*/
class Solution {
    int[] hx = {0, 1, 0, -1};
    int[] hy = {1, 0, -1, 0};

    boolean check(int[][] cells, int row, int col, int x){
        int[][] grid = new int[row][col];
        for(int i = 0; i <= x; i++)
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        
        boolean[][] vis = new boolean[row][col];
        Queue<Integer> q = new LinkedList<>(); // (i, j) -> i * col + j
        for(int j = 0; j < col; j++){
            if(grid[0][j] == 0){
                vis[0][j] = true;
                q.add(j);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            int u = cur / col, v = cur % col;
            for(int dir = 0; dir < 4; dir++){
                int nu = u + hx[dir], nv = v + hy[dir];
                if(nu >= 0 && nu < row && nv >= 0 && nv < col && grid[nu][nv] != 1 && !vis[nu][nv]){
                    vis[nu][nv] = true;
                    q.add(nu * col + nv);
                }
            }
        }

        for(int j = 0; j < col; j++)
            if(vis[row - 1][j])
                return true;
        
        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        // Bsearch + bfs
        int l = 0, r = cells.length - 1, res = 0, mid = 0;
        while(l <= r){
            mid = (l + r) / 2;
            if(check(cells, row, col, mid)){
                res = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }
        return res + 1;
    }
}
