package codingquestions.slidingwindow;

public class MaxSumSubarray {

    static int maxSubarraySum(int[] arr, int k) {
        if (k > arr.length) return 0;
        int ans = 0;
        int sum = 0;
        ans = sum;
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                sum += arr[i];
                ans = sum;
                continue;
            }
            sum += arr[i] - arr[i - k];
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
