/**
1942. The Number of the Smallest Unoccupied Chair
Solved
Medium
Topics
Companies
Hint
There is a party where n friends numbered from 0 to n - 1 are attending. There is an infinite number of chairs in this party that are numbered from 0 to infinity. When a friend arrives at the party, they sit on the unoccupied chair with the smallest number.

For example, if chairs 0, 1, and 5 are occupied when a friend comes, they will sit on chair number 2.
When a friend leaves the party, their chair becomes unoccupied at the moment they leave. If another friend arrives at that same moment, they can sit in that chair.

You are given a 0-indexed 2D integer array times where times[i] = [arrivali, leavingi], indicating the arrival and leaving times of the ith friend respectively, and an integer targetFriend. All arrival times are distinct.

Return the chair number that the friend numbered targetFriend will sit on.
**/
import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        
        // List of arrivals with friend index
        List<int[]> arrivals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrivals.add(new int[]{times[i][0], i});
        }
        
        // Sort friends by arrival time
        arrivals.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        // Min-Heap to track available chairs
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.add(i);
        }

        // Priority queue to track when chairs are freed
        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // Iterate through each friend based on arrival
        for (int[] arrival : arrivals) {
            int arrivalTime = arrival[0];
            int friendIndex = arrival[1];
            
            // Free chairs that are vacated before the current arrival time
            while (!leavingQueue.isEmpty() && leavingQueue.peek()[0] <= arrivalTime) {
                availableChairs.add(leavingQueue.poll()[1]);
            }
            
            // Assign the smallest available chair
            int chair = availableChairs.poll();
            
            // If this is the target friend, return their chair number
            if (friendIndex == targetFriend) {
                return chair;
            }
            
            // Mark the chair as being used until the friend's leave time
            leavingQueue.add(new int[]{times[friendIndex][1], chair});
        }
        
        return -1; // Should never reach here
    }
}
