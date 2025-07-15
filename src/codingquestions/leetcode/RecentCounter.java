package codingquestions.leetcode;

/**
 * 933. Number of Recent Calls
 * Solved
 * Easy
 * Topics
 * Companies
 * You have a RecentCounter class which counts the number of recent requests within a certain time frame.
 * <p>
 * Implement the RecentCounter class:
 * <p>
 * RecentCounter() Initializes the counter with zero recent requests.
 * int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].
 * It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
 */

public class RecentCounter {
    private static final int[] records = new int[10000]; //
    private int start;
    private int end;

    public RecentCounter() {
        start = 0;
        end = 0;
    }

    public int ping(int t) {
        while (start < end && (t - records[start] > 3000)) {
            start++; // if the difference in time is greater than 3000ms, 
            // than increase the value of start unitl it's equal or less than 3000ms.
        }
        records[end++] = t; // Inserting the current time at the end
        return end - start; // Returning the answer including the element added just now.
    }
}
