
// Author: Priyank Vora
// Description: Find the maximum in each sliding window of size k in an array
// Example: Input: [1,3,-1,-3,5,3,6,7], k = 3 => Output: [3,3,5,5,6,7]

import java.util.*;

public class slidingWindowMax {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];

        //We are using Array deque here
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove indices out of window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove smaller numbers in k range as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            // Add max value to result once window is fully seen
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }
}

// In the main class use the below code to see the expected output

// int[] input = {1, 3, -1, -3, 5, 3, 6, 7};
//         int k = 3;
//         int[] output = maxSlidingWindow(input, k);
//         System.out.println("Sliding Window Maximum: " + Arrays.toString(output));
