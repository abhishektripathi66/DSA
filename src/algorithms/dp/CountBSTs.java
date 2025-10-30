package algorithms.dp;

import java.util.Arrays;

public class CountBSTs {
    public static void main(String[] args) {
        int n = 3; //number of nodes (0, 1, 2)

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println("Number of BSTs with " + n + " nodes: " + countBSTsMemo(n, memo));

    }

    private static int countBSTsMemo(int n, int[] memo){
        //Base case: with just one node
        if(n<=1)
            return 1;

        //return already computed result
        if (memo[n] != -1) 
            return memo[n];

        int total = 0;

        //For each node i (from 1 to n),
        //The number of BSTs with i as
        //root = memo[i - 1] (number of BSTs possible on the left side) × memo[n - i] (number of BSTs possible on the right side)

        //consider each number as root
        for (int root = 1; root <= n; root++) {
            int left = countBSTsMemo(root - 1, memo);
            int right = countBSTsMemo(n - root, memo);
            total += left * right;
        }

        //store result and return
        return memo[n] = total;
    }
}
