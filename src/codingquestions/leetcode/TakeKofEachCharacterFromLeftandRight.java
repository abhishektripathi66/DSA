package codingquestions.leetcode.ds;

/**
 * 2516. Take K of Each Character From Left and Right
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. Each minute, you may take either the leftmost character of s, or the rightmost character of s.
 * <p>
 * Return the minimum number of minutes needed for you to take at least k of each character, or return -1 if it is not possible to take k of each character.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aabaaaacaabc", k = 2
 * Output: 8
 * Explanation:
 * Take three characters from the left of s. You now have two 'a' characters, and one 'b' character.
 * Take five characters from the right of s. You now have four 'a' characters, two 'b' characters, and two 'c' characters.
 * A total of 3 + 5 = 8 minutes is needed.
 * It can be proven that 8 is the minimum number of minutes needed.
 * Example 2:
 * <p>
 * Input: s = "a", k = 1
 * Output: -1
 * Explanation: It is not possible to take one 'b' or 'c' so return -1.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * s consists of only the letters 'a', 'b', and 'c'.
 * 0 <= k <= s.length
 */

public class TakeKofEachCharacterFromLeftandRight {

    public static void main(String[] args) {
        TakeKofEachCharacterFromLeftandRight tke = new TakeKofEachCharacterFromLeftandRight();
        System.out.println(tke.takeCharactersSolution("aabaaaacaabc", 2));
        System.out.println(tke.takeCharactersBestSolution("aabaaaacaabc", 2));
    }

    public int takeCharactersSolution(String s, int k) {
        int[] freq = new int[3];
        int n = s.length();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        if (freq[0] < k || freq[1] < k || freq[2] < k) {
            return -1;
        }

        int[] curr = new int[3];
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            curr[s.charAt(right) - 'a']++;

            while (left <= right && (curr[0] > freq[0] - k ||
                    curr[1] > freq[1] - k ||
                    curr[2] > freq[2] - k)) {
                curr[s.charAt(left) - 'a']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return n - maxLen;
    }

    public int takeCharactersBestSolution(String s, int k) {
        int[] arr = new int[3];
        char[] c = s.toCharArray();
        int cur, len = c.length;
        for (cur = 0; cur < len; cur++) {
            arr[c[cur] - 'a']++;
            if (arr[0] >= k && arr[1] >= k && arr[2] >= k) break;
        }
        if (cur == len) return -1;
        int count = cur + 1, min = count, end = len - 1;
        while (cur >= 0) {
            if (arr[c[cur] - 'a'] == k) {
                while (c[cur] != c[end]) {
                    arr[c[end] - 'a']++;
                    end--;
                    count++;
                }
                end--;
            } else {
                arr[c[cur] - 'a']--;
                count--;
                min = Math.min(count, min);
            }
            cur--;
        }
        return min;
    }
}
