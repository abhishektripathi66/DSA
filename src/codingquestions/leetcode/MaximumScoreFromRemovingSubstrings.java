package codingquestions.leetcode;
/**
 * 1717. Maximum Score From Removing Substrings
Solved
Medium
Topics
premium lock icon
Companies
Hint
You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.

 

Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.
Example 2:

Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20
 

Constraints:

1 <= s.length <= 105
1 <= x, y <= 104
s consists of lowercase English letters.
 */
public class MaximumScoreFromRemovingSubstrings {
    
    public static void main(String[] args) {
        
    }
    
    public int maximumGain(String s, int x, int y) {
        if(x>y){
            return removePairs(s,"ab",x,y);
        }
        return removePairs(s,"ba",y,x);
    }

    private int removePairs(String s, String pattern,int high,int low){
            int score=0;
            
            StringBuilder sb = new StringBuilder();
            for(char ch:s.toCharArray()){
                sb.append(ch);

                int length = sb.length();
                if(length>=2 && sb.charAt(length-1)==pattern.charAt(1) && sb.charAt(length-2)==pattern.charAt(0)){
                    score+=high;
                    sb.setLength(length-2);
                }
            }
            StringBuilder sb1 = new StringBuilder();
            for(char ch:sb.toString().toCharArray()){
                sb1.append(ch);

                int length = sb1.length();
                if(length>=2 && sb1.charAt(length-1)==pattern.charAt(0) && sb1.charAt(length-2)==pattern.charAt(1)){
                    score+=low;
                    sb1.setLength(length-2);
                }
            }


            return score;
    }

    //fast solution
    public int maximumGain1(String s, int x, int y) {
        int res = 0;
        char[] letters = s.toCharArray();
        int n = letters.length;
        char a = 'a', b = 'b';
        int aCnt = 0, bCnt = 0;
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
            a = 'b';
            b = 'a';
        }
        for (int i = 0; i < n; i++) {
            if (letters[i] == a) {
                aCnt++;
            } else if (letters[i] == b) {
                if (aCnt > 0) {
                    aCnt--;
                    res += x;
                } else {
                    bCnt++;
                }
            } else {
                res += Math.min(aCnt, bCnt) * y;
                aCnt = 0;
                bCnt = 0;
            }
        }
        if (aCnt!= 0) {
            res += Math.min(aCnt, bCnt) * y;
        }

        return res;
    }
}
