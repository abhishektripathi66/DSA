package codingquestions.slidingwindow;

import java.util.*;

public class LongestSubstringWithKUniques {

    public static int longestKSubstr(String s, int k) {
        int ans = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();

        int low = 0;

        for (int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() > k) {
                char left = s.charAt(low);

                map.put(left, map.get(left) - 1);

                if (map.get(left) == 0) {
                    map.remove(left);
                }

                low++;
            }

            if (map.size() == k) {
                ans = Math.max(ans, high - low + 1);
            }
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}
