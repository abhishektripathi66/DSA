/*
 * Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

 

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.
 */
public class LastCommonPrefix {

    public static void main(String[] args) {
        var lcp = new LastCommonPrefix();
        lcp.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) return "";
        else if (strs.length == 1) return strs[0];
        int smallest = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[smallest].length() > strs[i].length()) smallest = i;
        }
        int j = 0;
        String test = "";
        String test1 = "";
        boolean prefixPresent = true;

        while (prefixPresent) {
            if (test.equalsIgnoreCase(strs[smallest])) return test;
            test = test + strs[smallest].charAt(j) + "";
            System.out.println(test);
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].startsWith(test)) {
                    prefixPresent = false;
                    return test1;
                }
            }
            j += 1;
            test1 = test;
        }

        return test1;
    }
}
