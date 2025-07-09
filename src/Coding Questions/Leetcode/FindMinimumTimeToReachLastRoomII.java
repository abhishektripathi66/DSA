/*
3342. Find Minimum Time to Reach Last Room II
Solved
Medium
Topics
Companies
Hint
There is a dungeon with n x m rooms arranged as a grid.

You are given a 2D array moveTime of size n x m, where moveTime[i][j] represents the minimum time in seconds when you can start moving to that room. You start from the room (0, 0) at time t = 0 and can move to an adjacent room. Moving between adjacent rooms takes one second for one move and two seconds for the next, alternating between the two.

Return the minimum time to reach the room (n - 1, m - 1).

Two rooms are adjacent if they share a common wall, either horizontally or vertically.

 

Example 1:

Input: moveTime = [[0,4],[4,4]]

Output: 7

Explanation:

The minimum time required is 7 seconds.

At time t == 4, move from room (0, 0) to room (1, 0) in one second.
At time t == 5, move from room (1, 0) to room (1, 1) in two seconds.
Example 2:

Input: moveTime = [[0,0,0,0],[0,0,0,0]]

Output: 6

Explanation:

The minimum time required is 6 seconds.

At time t == 0, move from room (0, 0) to room (1, 0) in one second.
At time t == 1, move from room (1, 0) to room (1, 1) in two seconds.
At time t == 3, move from room (1, 1) to room (1, 2) in one second.
At time t == 4, move from room (1, 2) to room (1, 3) in two seconds.
Example 3:

Input: moveTime = [[0,1],[1,2]]

Output: 4

 

Constraints:

2 <= n == moveTime.length <= 750
2 <= m == moveTime[i].length <= 750
0 <= moveTime[i][j] <= 109
*/

import java.util.PriorityQueue;

class State implements Comparable<State>{
    int x, y, dis;

    State(int x, int y, int dis){
        this.x = x;
        this.y = y;
        this.dis = dis;
    }

    public int compareTo(State other){
        return Integer.compare(this.dis, other.dis);
    }
}

public class FindMinimumTimeToReachLastRoomII {

    public int minTimeToReach(int[][] moveTime) {
        int m = moveTime.length, n = moveTime[0].length;
        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++)
                dist[i][j] = 2000000000;
        }
        dist[0][0] = 0;

        PriorityQueue<State> q = new PriorityQueue<>();

        q.offer(new State(0, 0, 0));
        int[] hx = {1, 0, -1, 0};
        int[] hy = {0, 1, 0, -1};

        while (!q.isEmpty()){
            State s = q.poll();
            if (visited[s.x][s.y]){
                continue;
            }

            visited[s.x][s.y] = true;
            for (int i = 0; i < 4; i++){
                int nx = s.x + hx[i];
                int ny = s.y + hy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n){
                    continue;
                }

                int newDist = Math.max(dist[s.x][s.y], moveTime[nx][ny]) + (s.x + s.y) % 2 + 1;
                if (dist[nx][ny] > newDist){
                    dist[nx][ny] = newDist;
                    q.offer(new State(nx, ny, newDist));
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}
