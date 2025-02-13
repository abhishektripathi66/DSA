/**
 * Problem Statement:
 * Given an array of integers, find the first number that has a duplicate.
 * If no duplicate exists, return an empty result.
 * The solution should be implemented using Java Streams.
 *
 * This question was asked in a technical interview for a Senior Software Engineer role
 * at a big international bank.
 *
 * Example:
 * Input: [3, -1, 0, 4, -1, 3, 2]
 * Output: -1
 *
 * Input: [5, 0, 1, 5, -2, 0]
 * Output: 5
 *
 * Input: [1, 2, 3, 4]
 * Output: No duplicates
 */

import java.util.*;
import java.util.stream.*;

public class FirstDuplicateFinder {
    public static OptionalInt findFirstDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        return Arrays.stream(nums)
                .filter(n -> !seen.add(n)) // Filter elements that are already seen
                .findFirst(); // Return OptionalInt, which can be empty if no duplicate is found
    }

    public static void main(String[] args) {
        int[] nums = {3, -1, 0, 4, -1, 3, 2};
        OptionalInt result = findFirstDuplicate(nums);
        System.out.println("First duplicate: " +
                (result.isPresent() ? result.getAsInt() : "No duplicates"));
    }
}
