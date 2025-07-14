package codingquestions.leetcode;

import java.util.PriorityQueue;

/**
 * 2530. Maximal Score After Applying K Operations
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a 0-indexed integer array nums and an integer k. You have a starting score of 0.
 * <p>
 * In one operation:
 * <p>
 * choose an index i such that 0 <= i < nums.length,
 * increase your score by nums[i], and
 * replace nums[i] with ceil(nums[i] / 3).
 * Return the maximum possible score you can attain after applying exactly k operations.
 * <p>
 * The ceiling function ceil(val) is the least integer greater than or equal to val.
 **/
public class MaximalScoreAfterApplyingKOperations {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int x : nums)
            pq.offer(x);
        long score = 0;
        while (!pq.isEmpty() && k > 0) {
            score += pq.peek();
            int x = (int) Math.ceil(pq.poll() / 3.0);
            pq.add(x);
            k--;
        }
        return score;
    }
}
