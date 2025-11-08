package algorithms.dp;

import java.util.Arrays;


/*
 * Count Number of Unique Binary Search Trees (BSTs)
 *
 * Given 'n' distinct nodes labeled from 1 to n, find the total number of unique Binary Search Trees (BSTs)
 * that can be constructed using all nodes exactly once.
 *
 * Each BST must satisfy the binary search property:
 *   - All nodes in the left subtree of a root are smaller than the root.
 *   - All nodes in the right subtree of a root are greater than the root.
 *
 * For every node i (1 ≤ i ≤ n) chosen as the root:
 *   Number of BSTs = (Number of BSTs in left subtree) × (Number of BSTs in right subtree)
 *   → dp[n] = Σ (dp[i - 1] * dp[n - i]) for i = 1 to n
 *
 * Base Cases:
 *   dp[0] = 1  // Empty tree
 *   dp[1] = 1  // Single node tree
 *
 * This problem is closely related to the Catalan numbers sequence.
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 *
 * Example:
 *   n = 3
 *   → Total unique BSTs = 5
 *
 *   Possible BST structures:
 *     1         1          2          3          3
 *      \         \        / \        /          /
 *       2         3      1   3      1          2
 *        \       /                   \        /
 *         3     2                     2      1
 */

public class CountBSTs {
    public static void main(String[] args) {
        int n = 3; //number of nodes (0, 1, 2)

        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        System.out.println("Number of BSTs with " + n + " nodes: " + countBSTsMemo(n, memo));
        System.out.println("Number of BSTs with " + n + " nodes: " + countBSTTabulation(n));


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

    private static int countBSTTabulation(int n) {

        if (n == 0) // Edge case
            return 1;
        

        int[] dp = new int[n + 1];
        dp[0] = 1;  // Empty tree
        dp[1] = 1;  // Single node tree

        //fill dp from 2 to n
        for (int nodes = 2; nodes <= n; nodes++) {
            dp[nodes] = 0;
            for (int root = 1; root <= nodes; root++) {
                int left = dp[root - 1];
                int right = dp[nodes - root];
                dp[nodes] += left * right;
            }
        }

        return dp[n];
    }
}
