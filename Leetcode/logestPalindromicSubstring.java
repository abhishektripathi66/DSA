class logestPalindromicSubstring {
    public String longestPalindrome(String s) {
        
         if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0, 1);
        s = "#" + s.replaceAll("", "#") + "#";
        int[] dp = new int[s.length()];
        int center = 0;
        int right = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < right) {
                dp[i] = Math.min(right - i, dp[2 * center - i]);
            }

            while (i - dp[i] - 1 >= 0 && i + dp[i] + 1 < s.length() && s.charAt(i - dp[i] - 1) == s.charAt(i + dp[i] + 1)) {
                dp[i]++;
            }

            if (i + dp[i] > right) {
                center = i;
                right = i + dp[i];
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxStr = s.substring(i - dp[i], i + dp[i] + 1).replaceAll("#", "");
            }
        }

        return maxStr;
    }
}
