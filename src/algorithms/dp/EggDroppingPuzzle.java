package algorithms.dp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class EggDroppingPuzzle {
    
    public static void main(String[] args){
        int floors = 10;
        int eggs = 2;
        System.out.println("Minimum trials: " + EggDroppingPuzzleRec(floors, eggs));


        int[][] memo = new int[floors+1][eggs+1];
        for(int[] row: memo)
            Arrays.fill(row, -1);
        System.out.println("Minimum trials: " + EggDroppingPuzzleMemo(floors, eggs, memo));

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

}
