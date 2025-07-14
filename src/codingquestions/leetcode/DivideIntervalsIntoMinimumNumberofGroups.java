package codingquestions.leetcode;

import java.util.Arrays;

/**
 * 2406. Divide Intervals Into Minimum Number of Groups
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a 2D integer array intervals where intervals[i] = [lefti, righti] represents the inclusive interval [lefti, righti].
 * <p>
 * You have to divide the intervals into one or more groups such that each interval is in exactly one group, and no two intervals that are in the same group intersect each other.
 * <p>
 * Return the minimum number of groups you need to make.
 * <p>
 * Two intervals intersect if there is at least one common number between them. For example, the intervals [1, 5] and [5, 8] intersect.
 **/
public class DivideIntervalsIntoMinimumNumberofGroups {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;
        int[] start_times = new int[n];
        int[] end_times = new int[n];

        // Extract start and end times
        for (int i = 0; i < n; i++) {
            start_times[i] = intervals[i][0];
            end_times[i] = intervals[i][1];
        }

        // Sort start and end times
        Arrays.sort(start_times);
        Arrays.sort(end_times);
        int end_ptr = 0, group_count = 0;
        // Traverse through the start times
        for (int start : start_times) {
            if (start > end_times[end_ptr]) {
                end_ptr++;
            } else {
                group_count++;
            }
        }
        return group_count;
    }
}


       
