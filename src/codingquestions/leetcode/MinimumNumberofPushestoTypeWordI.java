package codingquestions.leetcode;
/*

new pr update
3014. Minimum Number of Pushes to Type Word I

Solved
Easy

Given a string word containing distinct lowercase English letters,
we need to remap the keys 2 to 9 to minimize the number of pushes
required to type the word.

The first 8 characters require 1 push each.
The next 8 characters require 2 pushes each.
The next 8 characters require 3 pushes each, and so on.

So:
1st set  -> 8 * 1
2nd set  -> 8 * 2
3rd set  -> 8 * 3
...

For n characters:
set = n / 8
rem = n % 8

Total:
8 * (1 + 2 + ... + set) + rem * (set + 1)

Using:
1 + 2 + ... + set = set * (set + 1) / 2

Time Complexity: O(1)
Space Complexity: O(1)

Example:
word = "xycdefghij"
n = 10

First 8 characters -> 8 * 1 = 8
Remaining 2 characters -> 2 * 2 = 4

Total = 12
*/

public class MinimumNumberofPushestoTypeWordI {
    public int minimumPushes(String word) {
        int n = word.length();

        int set = n / 8;
        int rem = n % 8;

        return 8 * set * (set + 1) / 2 + (set + 1) * rem;
    }
}

