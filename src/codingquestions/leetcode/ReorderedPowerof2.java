/**
869. Reordered Power of 2
Solved
Medium
Topics
premium lock icon
Companies
You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this so that the resulting number is a power of two.

 

Example 1:

Input: n = 1
Output: true
Example 2:

Input: n = 10
Output: false
 

Constraints:

1 <= n <= 109
**/

class Solution {
    private int[] countOf(int n){
        int[] cnt = new int[10];
        while(n > 0){
            cnt[n % 10]++;
            n /= 10; 
        }
        return cnt;
    }

    private boolean isEqual(int[] a, int[] b){
        for(int i = 0; i < 10; i++)
            if(a[i] != b[i])
                return false;
        
        return true;
    }

    public boolean reorderedPowerOf2(int n) {
        int[] cnt = countOf(n);
        for(int i = 1; i <= 1000000000; i *= 2){
            if(isEqual(cnt, countOf(i)))
                return true;
        }
        return false;
    }
}
