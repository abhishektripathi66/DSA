/*
2048. Next Greater Numerically Balanced Number
Solved
Medium
Topics
premium lock icon
Companies
Hint
An integer x is numerically balanced if for every digit d in the number x, there are exactly d occurrences of that digit in x.

Given an integer n, return the smallest numerically balanced number strictly greater than n.

 

Example 1:

Input: n = 1
Output: 22
Explanation: 
22 is numerically balanced since:
- The digit 2 occurs 2 times. 
It is also the smallest numerically balanced number strictly greater than 1.
Example 2:

Input: n = 1000
Output: 1333
Explanation: 
1333 is numerically balanced since:
- The digit 1 occurs 1 time.
- The digit 3 occurs 3 times. 
It is also the smallest numerically balanced number strictly greater than 1000.
Note that 1022 cannot be the answer because 0 appeared more than 0 times.
Example 3:

Input: n = 3000
Output: 3133
Explanation: 
3133 is numerically balanced since:
- The digit 1 occurs 1 time.
- The digit 3 occurs 3 times.
It is also the smallest numerically balanced number strictly greater than 3000.
 

Constraints:

0 <= n <= 106
*/
class Solution {
    private boolean isBalance(int x){
        int[] cnt = new int[10];
        while(x > 0){
            cnt[x % 10]++;
            x /= 10;
        }
        for(int i = 0; i < 10; i++){
            if(cnt[i] > 0 && cnt[i] != i)
                return false;
        }
        return true;
    }

    public int nextBeautifulNumber(int n) {
        while(true){
            n++;
            if(isBalance(n))
                return n;
        }
    }
}
