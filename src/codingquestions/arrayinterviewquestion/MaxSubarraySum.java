package codingquestions.arrayinterviewquestion;

/*
 * Kadane's Algorithm to find the maximum sum of a subarray.
 * It iterates through the array, updating the maximum subarray sum as it goes.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Example: [4, 2, -8, 10, 2, 5, -2] → Maximum sum = 17
 */

class MaxSubarraySum {

    public static void main(String[] args) {
        int[] arr = {4, 2, -8, 10, 2, 5, -2};

        int maxSubarraySum = maxSubarraySum(arr);

        System.out.println("maxSubarraySum : " + maxSubarraySum);
    }

    private static int maxSubarraySum(int[] arr) {
        int maxEnding = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(arr[i], maxEnding + arr[i]);
            max = Math.max(max, maxEnding);
        }

        return max;
    }
}