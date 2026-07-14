package codingquestions.slidingwindow;

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int ans = 0;
        int low = 0;
        int count = k;
        for (int high = 1; high < s.length() - 1; high++) {
            char ch = s.charAt(high);

            if (ch != s.charAt(high - 1)) {
                if (count > 0) {
                    ch = s.charAt(high - 1);
                    count--;
                } else {
                    low = high;
                    count = k;
                }
            }

            ans = Math.max(ans, high - low + 1);
        }

        return ans;
    }
}
