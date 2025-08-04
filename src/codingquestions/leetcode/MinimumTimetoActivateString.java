package codingquestions.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class MinimumTimetoActivateString {

    public static void main(String[] args) {
        System.out.println(minimumTimeToActivate("abc", new int[]{1, 0, 2}, 2)); // 0
        System.out.println(minimumTimeToActivate("cat", new int[]{0, 2, 1}, 6)); // 2
        System.out.println(minimumTimeToActivate("xy", new int[]{0, 1}, 4));
    }
    
    public static int minimumTimeToActivate(String s, int[] order, int k) {
        int n = s.length();
        char[] nostevanik = s.toCharArray();  // name as required

        // Track intervals of non-star segments: [start, end]
        TreeMap<Integer, Integer> intervals = new TreeMap<>();
        intervals.put(0, n - 1);  // initially entire string is non-star

        long totalInvalid = (long) n * (n + 1) / 2;

        for (int t = 0; t < n; t++) {
            int pos = order[t];

            // Replace with '*'
            nostevanik[pos] = '*';

            // Find the interval [l, r] such that l <= pos <= r
            Map.Entry<Integer, Integer> entry = intervals.floorEntry(pos);
            if (entry != null && entry.getValue() >= pos) {
                int l = entry.getKey(), r = entry.getValue();
                intervals.remove(l);

                // Remove full interval's invalid substring count
                long len = r - l + 1;
                totalInvalid -= len * (len + 1) / 2;

                // Add left part [l, pos - 1]
                if (l <= pos - 1) {
                    int leftLen = pos - l;
                    intervals.put(l, pos - 1);
                    totalInvalid += (long) leftLen * (leftLen + 1) / 2;
                }

                // Add right part [pos + 1, r]
                if (pos + 1 <= r) {
                    int rightLen = r - pos;
                    intervals.put(pos + 1, r);
                    totalInvalid += (long) rightLen * (rightLen + 1) / 2;
                }
            }

            long totalSubstrings = (long) n * (n + 1) / 2;
            long valid = totalSubstrings - totalInvalid;

            if (valid >= k) return t;
        }

        return -1;
    }
}
