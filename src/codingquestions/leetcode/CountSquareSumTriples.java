/*
1925. Count Square Sum Triples
Solved
Easy
Topics
premium lock icon
Companies
Hint
A square triple (a,b,c) is a triple where a, b, and c are integers and a2 + b2 = c2.

Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.

 

Example 1:

Input: n = 5
Output: 2
Explanation: The square triples are (3,4,5) and (4,3,5).
Example 2:

Input: n = 10
Output: 4
Explanation: The square triples are (3,4,5), (4,3,5), (6,8,10), and (8,6,10).
 

Constraints:

1 <= n <= 250
*/
class Solution {
    public int countTriples(int n) {
        int res = 0;
        for(int a = 1; a <= n; a++){
            for(int b = 1; b <= n; b++){
                int cc = a * a + b * b;
                int c = (int)Math.sqrt((double)cc);
                res += ((c <= n && c * c == cc) ? 1 : 0);
            }
        }
        return res;
    }
}
