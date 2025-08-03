package codingquestions.leetcode;

public class TrionicArrayII {
    public int maxTrionicSubarraySum(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        int[] prefix = new int[n + 1];
        
        // Compute prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Try all valid centers (p)
        for (int p = 1; p < n - 2; p++) {
            // Find l such that nums[l...p] is strictly increasing
            int l = p;
            while (l > 0 && nums[l - 1] < nums[l]) {
                l--;
            }
            if (l == p) continue; // no increase

            // Find q such that nums[p...q] is strictly decreasing
            int q = p + 1;
            while (q < n && nums[q - 1] > nums[q]) {
                q++;
            }
            if (q == p + 1) continue; // no decrease

            // Find r such that nums[q...r] is strictly increasing
            int r = q;
            while (r + 1 < n && nums[r] < nums[r + 1]) {
                r++;
            }
            if (r == q) continue; // no increase

            // Compute sum from l to r
            int sum = prefix[r + 1] - prefix[l];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        TrionicArrayII solver = new TrionicArrayII();
        System.out.println(solver.maxTrionicSubarraySum(new int[]{0, -2, -1, -3, 0, 2, -1})); // -4
        System.out.println(solver.maxTrionicSubarraySum(new int[]{1, 4, 2, 7})); // 14
        System.out.println(solver.maxTrionicSubarraySum(new int[]{2, 993, -791, -635, -569})); // 0 → expected: 0, but it's actually a valid trionic with sum
    }
}
