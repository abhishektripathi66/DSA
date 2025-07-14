import java.util.HashMap;
import java.util.HashSet;

/**
 * 1207. Unique Number of Occurrences
 * Solved
 * Easy
 * Topics
 * Companies
 * Hint
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 * <p>
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 * <p>
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */

public class UniqueOcurances {

    //mysolution

    public boolean uniqueOccurrences(int[] arr) {

        HashMap<Integer, Integer> a = new HashMap<>();

        //add count of each in the map
        for (int i : arr) {
            a.put(i, a.getOrDefault(i, 0) + 1);
        }

        //add the values in set to get uniqueness;
        HashSet<Integer> b = new HashSet<>();
        for (Integer i :
                a.values()) {

            // fetching the values of the HashMap
            // one at a time and comparing with
            // the value to be checked
            if (!b.add(i))
                return false;
        }

        return true;


    }

    //best solution
    public boolean bestuniqueOccurrences(int[] arr) {

        // Step 1: Determine the maximum value in the array to size the counting array
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num > maxVal) maxVal = num;
            if (num < minVal) minVal = num;
        }

        // Offset for negative values
        int offset = -minVal;
        int range = maxVal - minVal + 1;

        // Step 2: Create and populate the count array
        int[] count = new int[range];
        for (int num : arr) {
            count[num + offset]++;
        }

        // Step 3: Create an array to check if counts are unique
        int[] occurrenceCount = new int[arr.length + 1];
        // The length + 1 to handle up to arr.length occurrences

        for (int c : count) {
            if (c > 0) {
                if (occurrenceCount[c] > 0) {
                    return false; // Duplicate count found
                }
                occurrenceCount[c]++;
            }
        }

        return true;

    }
}
