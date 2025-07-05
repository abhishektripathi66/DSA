/*
 * Rat in a Maze Problem
 *
 * Given an N×N maze represented by a grid of 0s and 1s, find a path from top-left
 * (0,0) to bottom-right (N-1,N-1). You can move only down or right through cells
 * marked with 1 (open path).
 *
 * This solution uses backtracking to explore possible paths.
 *
 * Time Complexity: O(2^(N×N)) worst case (each cell can lead to two directions), but isSafe() reduces exploration.
 * Auxiliary Space Complexity: O(N×N) for the solution matrix and recursion stack.
 *
 * Example:
 * maze = [
 *  [1,0,0,0],
 *  [1,1,0,1],
 *  [0,1,0,0],
 *  [1,1,1,1]
 * ]
 * Output path marks the route from start to finish.
 */



public class RatInMaze {

    static int N = 4; // Maze size (NxN)
    static int[][] maze = {
        {1, 0, 0, 0},
        {1, 1, 0, 1},
        {0, 1, 0, 0},
        {1, 1, 1, 1}
    };

    static int[][] sol = new int[N][N];

    public static void main(String[] args) {
        if (ratInMazeRec(0, 0)) {
            printSolution();
        } else {
            System.out.println("No path found.");
        }
    }

    private static boolean ratInMazeRec(int i, int j) {
        if (i == N - 1 && j == N - 1 && maze[i][j] == 1) { //reached at end
            sol[i][j] = 1;
            return true;
        }

        if (isSafe(i, j)) { //if current step is valid, explore possible path from there
            sol[i][j] = 1;

            // move down
            if (ratInMazeRec(i + 1, j)) {
                return true;
            }

            // move right
            if (ratInMazeRec(i, j + 1)) {
                return true;
            }

            // backtrack because no valid path from current position
            sol[i][j] = 0;
            return false;
        }

        return false;
    }

    //to check open path within matrix
    private static boolean isSafe(int i, int j) {
        return (i >= 0 && i < N && j >= 0 && j < N && maze[i][j] == 1);
    }

    private static void printSolution() {
        System.out.println("Solution path (1 = path):");
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                System.out.print(sol[r][c] + " ");
            }
            System.out.println();
        }
    }
}
