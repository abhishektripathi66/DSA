package algorithms.dp;

import java.util.Arrays;

/*
 * Egg Dropping Puzzle
 *
 * Problem Statement:
 *   You are given a certain number of eggs (e) and a building with a given number of floors (f).
 *   The goal is to determine the minimum number of trials required in the worst case to find
 *   the critical floor (also called the threshold floor) — the lowest floor from which the egg starts breaking when dropped.
 *
 *   If an egg breaks when dropped from a certain floor, it would also break from all higher floors.
 *   If it doesn’t break, it would not break from any lower floor.
 *   The objective is to minimize the number of drops in the worst-case scenario.
 *
 * Recurrence Relation:
 *   dp[f][e] = 1 + min( max(dp[x - 1][e - 1], dp[f - x][e]) ) for all 1 ≤ x ≤ f
 *   where:
 *     - dp[x - 1][e - 1] → when egg breaks (test floors below)
 *     - dp[f - x][e]     → when egg doesn't break (test floors above)
 *     - +1               → current drop
 *
 * Example:
 *   Input: floors = 10, eggs = 2
 *   Output: Minimum number of trials = 4
 *
 * Explanation:
 *   The minimum number of drops required in the worst case is 4.
 *   That means, no matter which floor the egg starts breaking from, we can find the exact floor within 4 trials.
 */

public class EggDroppingPuzzle {
    
    public static void main(String[] args){
        int floors = 10;
        int eggs = 2;
        
        //Minimum trials in the worst case
        System.out.println("Minimum trials: " + EggDroppingPuzzleRec(floors, eggs));


        int[][] memo = new int[floors+1][eggs+1];
        for(int[] row: memo)
            Arrays.fill(row, -1);
        System.out.println("Minimum trials: " + EggDroppingPuzzleMemo(floors, eggs, memo));

        System.out.println("Minimum trials: " + EggDroppingPuzzleTabulation(floors, eggs));
    }

    //Time Complexity: O(2^f) roughly, Space Complexity: O(f) from recursion call stack
    private static int EggDroppingPuzzleRec(int f, int e){
        //base cases
        if(f==0 || f==1) //|| e > 0
            return f; // 0 floor → 0 trial, 1 floor → 1 trial
        if(e == 1) //&& f>0
            return f; //must try each floor sequentially
        
        int min = Integer.MAX_VALUE;

        // Try dropping from each floor and take min of worst-case results
        for (int x = 1; x <= f; x++) {

            //checking both possiblities
            int broken = EggDroppingPuzzleRec(x - 1, e - 1); //If egg breaks, try from x-1 floor with reamining eggs
            int notBroken = EggDroppingPuzzleRec(f - x, e);   //Egg doesn't break, try from f-x floor left above

            //We don't know which one will happen so we take max value from both possibilites and do +1 for current drop
            int worst = 1 + Math.max(broken, notBroken);
            min = Math.min(min, worst);
        }
       
        return min;
    }

    // Time Complexity: O(f² × e), Space Complexity: O(f × e) from memo table (f+1)×(e+1) + recursion depth O(f)
    private static int EggDroppingPuzzleMemo(int f, int e, int[][] memo) {
        // Base cases
        if (f == 0 || f == 1)
            return f;
        if (e == 1)
            return f;

        // If already computed, return stored value
        if (memo[f][e] != -1)
            return memo[f][e];

        int min = Integer.MAX_VALUE;

        // Try all floors from 1 to f
        for (int x = 1; x <= f; x++) {
            int broken, notBroken;

            // Use memoized values if available
            if (memo[x - 1][e - 1] != -1)
                broken = memo[x - 1][e - 1];
            else
                broken = EggDroppingPuzzleMemo(x - 1, e - 1, memo);

            if (memo[f - x][e] != -1)
                notBroken = memo[f - x][e];
            else
                notBroken = EggDroppingPuzzleMemo(f - x, e, memo);

            int worst = 1 + Math.max(broken, notBroken);
            min = Math.min(min, worst);
        }

        return memo[f][e] = min; // store result and return
    }

    // Time Complexity: O(f² × e), Space Complexity: O(f × e)
    private static int EggDroppingPuzzleTabulation(int floors, int eggs) {
        int[][] dp = new int[floors + 1][eggs + 1];

        // Base cases
        for (int f = 0; f <= floors; f++)
            dp[f][1] = f; // With 1 egg, need f trials

        for (int e = 1; e <= eggs; e++) {
            dp[0][e] = 0; // 0 floors → 0 trials
            dp[1][e] = 1; // 1 floor → 1 trial
        }

        // Fill the DP table
        for (int f = 2; f <= floors; f++) {
            for (int e = 2; e <= eggs; e++) {
                dp[f][e] = Integer.MAX_VALUE;

                for (int x = 1; x <= f; x++) {
                    int broken = dp[x - 1][e - 1];
                    int notBroken = dp[f - x][e];
                    int worst = 1 + Math.max(broken, notBroken);
                    dp[f][e] = Math.min(dp[f][e], worst);
                }
            }
        }

        return dp[floors][eggs];
    }

}
