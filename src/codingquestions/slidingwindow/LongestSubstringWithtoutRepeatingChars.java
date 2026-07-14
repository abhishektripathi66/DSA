package SlidingWindow;

import java.util.*;

public class LongestSubstringwithtoutRepeatingChars {
    static public int lengthOfLongestSubstring(String s) {
        int ans = -1;
        int low = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int high = 0; high < s.length(); high++) {

            char ch = s.charAt(high);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.get(ch) >= 1) {
                char red = s.charAt(low);
                map.put(red, map.get(red) - 1);

                if (map.get(red) == 0) {
                    map.remove(red);
                }
                low++;
            }

            // if(map.containsKey(s.charAt(high)) && map.get(s.charAt(high))>=1){
            // map.remove(s.charAt(low));
            // low++;
            // }

            ans = Math.max(ans, high - low + 1);

        }

        return ans;
    }

    static int brute(String s) {
        int ans = -1;
        int low = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int high = 0; high < s.length(); high++) {
            char ch = s.charAt(high);
            if(map.containsKey(ch)){
                low = Math.max(low,map.get(ch)+1);
            }

            map.put(ch, high);
            ans= Math.max(ans, high-low+1);

        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println(brute("pwwkew"));
    }

}
