package GreedyAlgorithms;

import java.util.Arrays;
import java.util.Comparator;


/*
 * Activity Selection Problem 
 * 
 * Given n activities with start and end time and we have to find out maximum number of activities completed
 * without overlapping with each other.
 *
 * Time Complexity: O(n log n) for sorting
 * Auxilliary Space Complexity: O(1) (ignoring input)
 *
 * Example:
 *    Activities = [(1, 3), (2, 4), (3, 5), (0, 6), (5, 7), (8, 9), (5, 9)]
 *    → Max non-overlapping = 4 (which are (1,3), (3,5), (5,7), (8,9))
 */


public class ActivitySelection {

    // Activity class to store start and end time
    static class Activity {
        int start, end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Activity[] activities = {
            new Activity(1, 3),
            new Activity(2, 4),
            new Activity(3, 5),
            new Activity(0, 6),
            new Activity(5, 7),
            new Activity(8, 9),
            new Activity(5, 9)
        };

        int maxActivities = selectMaxActivities(activities);

        System.out.println("Maximum number of non-overlapping activities: " + maxActivities);
    }

    private static int selectMaxActivities(Activity[] activities) {
        //sort activities based on their end time (earliest finishing first)
        Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

        int count = 1;  // always select the first activity because it has minimal completion time
        int lastEnd = activities[0].end;

        //iterate through remaining activities
        for (int i = 1; i < activities.length; i++) {
            // select activity if its start time is after or equal to last selected end time
            if (activities[i].start >= lastEnd) {
                count++;
                lastEnd = activities[i].end;
            }
        }

        return count;
    }
}