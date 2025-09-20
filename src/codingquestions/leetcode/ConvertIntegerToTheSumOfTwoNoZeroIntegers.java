/*
1317. Convert Integer to the Sum of Two No-Zero Integers
Solved
Easy
Topics
premium lock icon
Companies
Hint
No-Zero integer is a positive integer that does not contain any 0 in its decimal representation.

Given an integer n, return a list of two integers [a, b] where:

a and b are No-Zero integers.
a + b = n
The test cases are generated so that there is at least one valid solution. If there are many valid solutions, you can return any of them.

 

Example 1:

Input: n = 2
Output: [1,1]
Explanation: Let a = 1 and b = 1.
Both a and b are no-zero integers, and a + b = 2 = n.
Example 2:

Input: n = 11
Output: [2,9]
Explanation: Let a = 2 and b = 9.
Both a and b are no-zero integers, and a + b = 11 = n.
Note that there are other valid answers as [8, 3] that can be accepted.
 

Constraints:

2 <= n <= 104
*/
class Solution {
    private boolean isNoZero(int n){
        if(n == 0)
            return false;

        while(n > 0){
            if(n % 10 == 0)
                return false;
            
            n /= 10;
        }
        return true;
    }

    public int[] getNoZeroIntegers(int n) {
        int[] res = new int[2];
        for(int i = 1; i < n; i++){
            if(isNoZero(i) && isNoZero(n - i)){
                res[0] = i;
                res[1] = n - i;
                break;
            }
        }
        return res;
    }
}
