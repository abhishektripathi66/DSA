import java.util.*;

/**
 * LeetCode Dynamic Programming Solutions
 * This file contains solutions for various DP problems with both memoization and tabulation approaches
 * 
 * Problems included:
 * 1D DP: Climbing Stairs, House Robber, Word Break, Coin Change, Longest Increasing Subsequence
 * Multidimensional DP: Triangle, Minimum Path Sum, Unique Paths II, Longest Palindromic Substring, Interleaving String
 */
public class LeetcodeSolutions {
    
    public static void main(String[] args) {
        // Test all solutions
        testAllSolutions();
    }
    
    // ==================== 1D DP PROBLEMS ====================
    
    /**
     * 70. Climbing Stairs
     * You are climbing a staircase. It takes n steps to reach the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     */
    
    // Memoization approach
    public static int climbStairsMemo(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return climbStairsHelper(n, memo);
    }
    
    private static int climbStairsHelper(int n, int[] memo) {
        if (n <= 2) return n;
        if (memo[n] != -1) return memo[n];
        
        memo[n] = climbStairsHelper(n - 1, memo) + climbStairsHelper(n - 2, memo);
        return memo[n];
    }
    
    // Tabulation approach
    public static int climbStairsTab(int n) {
        if (n <= 2) return n;
        
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
    }
    
    /**
     * 198. House Robber
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them
     * is that adjacent houses have security systems connected and it will automatically contact the police if two
     * adjacent houses were broken into on the same night.
     */
    
    // Memoization approach
    public static int robMemo(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return robHelper(nums, 0, memo);
    }
    
    private static int robHelper(int[] nums, int index, int[] memo) {
        if (index >= nums.length) return 0;
        if (memo[index] != -1) return memo[index];
        
        int rob = nums[index] + robHelper(nums, index + 2, memo);
        int notRob = robHelper(nums, index + 1, memo);
        
        memo[index] = Math.max(rob, notRob);
        return memo[index];
    }
    
    // Tabulation approach
    public static int robTab(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        
        return dp[nums.length - 1];
    }
    
    /**
     * 139. Word Break
     * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into
     * a space-separated sequence of one or more dictionary words.
     */
    
    // Memoization approach
    public static boolean wordBreakMemo(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return wordBreakHelper(s, wordSet, 0, memo);
    }
    
    private static boolean wordBreakHelper(String s, Set<String> wordSet, int start, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];
        
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordSet.contains(s.substring(start, end)) && 
                wordBreakHelper(s, wordSet, end, memo)) {
                memo[start] = true;
                return true;
            }
        }
        
        memo[start] = false;
        return false;
    }
    
    // Tabulation approach
    public static boolean wordBreakTab(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
    
    /**
     * 322. Coin Change
     * You are given an integer array coins representing coins of different denominations and an integer amount
     * representing a total amount of money. Return the fewest number of coins that you need to make up that amount.
     */
    
    // Memoization approach
    public static int coinChangeMemo(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -1);
        int result = coinChangeHelper(coins, amount, memo);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private static int coinChangeHelper(int[] coins, int amount, int[] memo) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (memo[amount] != -1) return memo[amount];
        
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = coinChangeHelper(coins, amount - coin, memo);
            if (result != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }
        
        memo[amount] = minCoins;
        return minCoins;
    }
    
    // Tabulation approach
    public static int coinChangeTab(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    /**
     * 300. Longest Increasing Subsequence
     * Given an integer array nums, return the length of the longest strictly increasing subsequence.
     */
    
    // Memoization approach
    public static int lengthOfLISMemo(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        int maxLength = 0;
        
        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, lengthOfLISHelper(nums, i, memo));
        }
        
        return maxLength;
    }
    
    private static int lengthOfLISHelper(int[] nums, int index, int[] memo) {
        if (memo[index] != -1) return memo[index];
        
        int maxLength = 1;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                maxLength = Math.max(maxLength, 1 + lengthOfLISHelper(nums, i, memo));
            }
        }
        
        memo[index] = maxLength;
        return maxLength;
    }
    
    // Tabulation approach
    public static int lengthOfLISTab(int[] nums) {
        if (nums.length == 0) return 0;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        return maxLength;
    }
    
    // ==================== MULTIDIMENSIONAL DP PROBLEMS ====================
    
    /**
     * 120. Triangle
     * Given a triangle array, return the minimum path sum from top to bottom.
     */
    
    // Memoization approach
    public static int minimumTotalMemo(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] memo = new int[n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return minimumTotalHelper(triangle, 0, 0, memo);
    }
    
    private static int minimumTotalHelper(List<List<Integer>> triangle, int row, int col, int[][] memo) {
        if (row == triangle.size()) return 0;
        if (memo[row][col] != -1) return memo[row][col];
        
        int current = triangle.get(row).get(col);
        int left = minimumTotalHelper(triangle, row + 1, col, memo);
        int right = minimumTotalHelper(triangle, row + 1, col + 1, memo);
        
        memo[row][col] = current + Math.min(left, right);
        return memo[row][col];
    }
    
    // Tabulation approach
    public static int minimumTotalTab(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        // Fill the last row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }
        
        // Fill from bottom to top
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        
        return dp[0][0];
    }
    
    /**
     * 64. Minimum Path Sum
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right,
     * which minimizes the sum of all numbers along its path.
     */
    
    // Memoization approach
    public static int minPathSumMemo(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return minPathSumHelper(grid, 0, 0, memo);
    }
    
    private static int minPathSumHelper(int[][] grid, int i, int j, int[][] memo) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        if (memo[i][j] != -1) return memo[i][j];
        
        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        
        if (j + 1 < grid[0].length) {
            right = minPathSumHelper(grid, i, j + 1, memo);
        }
        if (i + 1 < grid.length) {
            down = minPathSumHelper(grid, i + 1, j, memo);
        }
        
        memo[i][j] = grid[i][j] + Math.min(right, down);
        return memo[i][j];
    }
    
    // Tabulation approach
    public static int minPathSumTab(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        dp[0][0] = grid[0][0];
        
        // Fill first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        // Fill first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        // Fill rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    /**
     * 63. Unique Paths II
     * You are given an m x n integer array obstacleGrid. There is a robot initially located at the top-left corner.
     * The robot tries to move to the bottom-right corner. The robot can only move either down or right at any point in time.
     * An obstacle and space is marked as 1 or 0 respectively in obstacleGrid.
     */
    
    // Memoization approach
    public static int uniquePathsWithObstaclesMemo(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return uniquePathsWithObstaclesHelper(obstacleGrid, 0, 0, memo);
    }
    
    private static int uniquePathsWithObstaclesHelper(int[][] obstacleGrid, int i, int j, int[][] memo) {
        if (i >= obstacleGrid.length || j >= obstacleGrid[0].length || obstacleGrid[i][j] == 1) {
            return 0;
        }
        if (i == obstacleGrid.length - 1 && j == obstacleGrid[0].length - 1) {
            return 1;
        }
        if (memo[i][j] != -1) return memo[i][j];
        
        int right = uniquePathsWithObstaclesHelper(obstacleGrid, i, j + 1, memo);
        int down = uniquePathsWithObstaclesHelper(obstacleGrid, i + 1, j, memo);
        
        memo[i][j] = right + down;
        return memo[i][j];
    }
    
    // Tabulation approach
    public static int uniquePathsWithObstaclesTab(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if (obstacleGrid[0][0] == 1) return 0;
        
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        // Fill first row
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        // Fill first column
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            }
        }
        
        // Fill rest of the grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[m - 1][n - 1];
    }
    
    /**
     * 5. Longest Palindromic Substring
     * Given a string s, return the longest palindromic substring in s.
     */
    
    // Memoization approach
    public static String longestPalindromeMemo(String s) {
        int n = s.length();
        boolean[][] memo = new boolean[n][n];
        int start = 0, maxLength = 1;
        
        // All single characters are palindromes
        for (int i = 0; i < n; i++) {
            memo[i][i] = true;
        }
        
        // Check for palindromes of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                memo[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        
        // Check for palindromes of length > 2
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && memo[i + 1][j - 1]) {
                    memo[i][j] = true;
                    if (len > maxLength) {
                        start = i;
                        maxLength = len;
                    }
                }
            }
        }
        
        return s.substring(start, start + maxLength);
    }
    
    // Tabulation approach (same as memoization for this problem)
    public static String longestPalindromeTab(String s) {
        return longestPalindromeMemo(s); // Same implementation
    }
    
    /**
     * 97. Interleaving String
     * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
     */
    
    // Memoization approach
    public static boolean isInterleaveMemo(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return isInterleaveHelper(s1, s2, s3, 0, 0, memo);
    }
    
    private static boolean isInterleaveHelper(String s1, String s2, String s3, int i, int j, Boolean[][] memo) {
        if (i + j == s3.length()) return true;
        if (memo[i][j] != null) return memo[i][j];
        
        boolean result = false;
        
        if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            result = isInterleaveHelper(s1, s2, s3, i + 1, j, memo);
        }
        
        if (!result && j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            result = isInterleaveHelper(s1, s2, s3, i, j + 1, memo);
        }
        
        memo[i][j] = result;
        return result;
    }
    
    // Tabulation approach
    public static boolean isInterleaveTab(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        
        // Fill first row
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // Fill first column
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        
        // Fill rest of the grid
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                           (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        
        return dp[s1.length()][s2.length()];
    }
    
    // ==================== TESTING METHODS ====================
    
    public static void testAllSolutions() {
        System.out.println("=== Testing All LeetCode DP Solutions ===\n");
        
        // Test 1D DP problems
        testClimbingStairs();
        testHouseRobber();
        testWordBreak();
        testCoinChange();
        testLongestIncreasingSubsequence();
        
        // Test Multidimensional DP problems
        testTriangle();
        testMinimumPathSum();
        testUniquePathsWithObstacles();
        testLongestPalindromicSubstring();
        testInterleavingString();
        
        System.out.println("=== All Tests Completed ===");
    }
    
    private static void testClimbingStairs() {
        System.out.println("Testing Climbing Stairs (n=5):");
        System.out.println("Memoization: " + climbStairsMemo(5));
        System.out.println("Tabulation: " + climbStairsTab(5));
        System.out.println();
    }
    
    private static void testHouseRobber() {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println("Testing House Robber: " + Arrays.toString(nums));
        System.out.println("Memoization: " + robMemo(nums));
        System.out.println("Tabulation: " + robTab(nums));
        System.out.println();
    }
    
    private static void testWordBreak() {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println("Testing Word Break: s=\"" + s + "\", wordDict=" + wordDict);
        System.out.println("Memoization: " + wordBreakMemo(s, wordDict));
        System.out.println("Tabulation: " + wordBreakTab(s, wordDict));
        System.out.println();
    }
    
    private static void testCoinChange() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Testing Coin Change: coins=" + Arrays.toString(coins) + ", amount=" + amount);
        System.out.println("Memoization: " + coinChangeMemo(coins, amount));
        System.out.println("Tabulation: " + coinChangeTab(coins, amount));
        System.out.println();
    }
    
    private static void testLongestIncreasingSubsequence() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Testing Longest Increasing Subsequence: " + Arrays.toString(nums));
        System.out.println("Memoization: " + lengthOfLISMemo(nums));
        System.out.println("Tabulation: " + lengthOfLISTab(nums));
        System.out.println();
    }
    
    private static void testTriangle() {
        List<List<Integer>> triangle = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        );
        System.out.println("Testing Triangle:");
        System.out.println("Memoization: " + minimumTotalMemo(triangle));
        System.out.println("Tabulation: " + minimumTotalTab(triangle));
        System.out.println();
    }
    
    private static void testMinimumPathSum() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println("Testing Minimum Path Sum:");
        System.out.println("Memoization: " + minPathSumMemo(grid));
        System.out.println("Tabulation: " + minPathSumTab(grid));
        System.out.println();
    }
    
    private static void testUniquePathsWithObstacles() {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println("Testing Unique Paths II:");
        System.out.println("Memoization: " + uniquePathsWithObstaclesMemo(obstacleGrid));
        System.out.println("Tabulation: " + uniquePathsWithObstaclesTab(obstacleGrid));
        System.out.println();
    }
    
    private static void testLongestPalindromicSubstring() {
        String s = "babad";
        System.out.println("Testing Longest Palindromic Substring: \"" + s + "\"");
        System.out.println("Memoization: " + longestPalindromeMemo(s));
        System.out.println("Tabulation: " + longestPalindromeTab(s));
        System.out.println();
    }
    
    private static void testInterleavingString() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println("Testing Interleaving String:");
        System.out.println("s1=\"" + s1 + "\", s2=\"" + s2 + "\", s3=\"" + s3 + "\"");
        System.out.println("Memoization: " + isInterleaveMemo(s1, s2, s3));
        System.out.println("Tabulation: " + isInterleaveTab(s1, s2, s3));
        System.out.println();
    }
}
