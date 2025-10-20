package codingquestions.leetcode;
import java.util.*;

class SumOfBeautyOfAllSubstring {
    public int beautySum(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            HashMap<Character, Integer> map = new HashMap<>();

            for (int j = i; j < s.length(); j++) {
                String prefix = s.substring(i,j);
                
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch,0)+1);

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int e : map.values()) {
                    if (e < min) {
                        min = e;
                    }

                    if (e > max) {
                        max = e;
                    }
                }

                if (max - min > 0) {
                    count += max - min;
                }
            }
        }

        return count;
    }
}