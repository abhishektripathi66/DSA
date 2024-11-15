/**
2501. Longest Square Streak in an Array
Solved
Medium
Topics
Companies
Hint
You are given an integer array nums. A subsequence of nums is called a square streak if:

The length of the subsequence is at least 2, and
after sorting the subsequence, each element (except the first element) is the square of the previous number.
Return the length of the longest square streak in nums, or return -1 if there is no square streak.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
  **/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
Intuition
The problem involves finding the longest "square streak" in a list of numbers, where each number in a streak is the square of the previous number. Observing the problem, one might realize that if we can store and reference each square root's streak length, we can build up streaks efficiently by iterating over a sorted list of numbers.

Approach
Sort the Array: Sorting the input list of numbers in ascending order ensures that smaller numbers and their squares appear before the larger squares in the list.
Initialize a Map: Use a map mp to keep track of the streak length for each number.
Iterate Through Numbers: For each number in the sorted list, calculate its integer square root.
If the number is a perfect square (i.e., the square of the square root equals the number) and the square root exists in the map, we can extend a streak.
Update the map entry for the current number to mp[_sqrt] + 1 to indicate it's part of an extended streak.
Track the Longest Streak: Update the result with the maximum streak length found during the iteration.
Finally, return the result, which represents the longest square streak.

Complexity
Time complexity:
Sorting takes O(nlogn), and iterating over the list to calculate the square root and update the map takes O(n), making the overall complexity O(nlogn).

Space complexity:
The map mp may store up to O(n) entries (for each unique number in nums), giving a space complexity of O(n).

Code Breakdown:
Sorting: Sorts the array in O(nlogn) to ensure that smaller squares are processed before larger ones.
Map Setup: A map mp tracks the length of streaks associated with each number.
Square Check and Update: For each number, we check if it’s a perfect square and if its square root has a streak in the map, extending that streak if both conditions are met. Otherwise, we initialize a new streak.
Result Calculation: The maximum streak length is updated continuously, so at the end, res contains the length of the longest square streak.
  **/
class Solution {
    public int longestSquareStreak(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        Arrays.sort(nums);
        int res = -1;

        for (int num : nums) {
            int sqrt = (int) Math.sqrt(num);

            if (sqrt * sqrt == num && mp.containsKey(sqrt)) {
                mp.put(num, mp.get(sqrt) + 1);
                res = Math.max(res, mp.get(num));
            } else {
                mp.put(num, 1);
            }
        }
        return res;
    }
}
