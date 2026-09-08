package codingquestions.slidingwindow;

public class MinimumSizeSubarraySum {

    static int minSubArrayLen(int[] arr, int target) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];

            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= arr[left];
                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
