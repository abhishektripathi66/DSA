package codingquestions.leetcode;

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
public class ReorderedPowerof2 {
 
    public boolean reorderedPowerOf2(int n) {
        //creating an array to hold the count of the digits in n
        int[] count = countOf(n);
        // with the constraints provided we can see that the max power can be of 31, so we calulate the digits for each power and compare with the 
        for(int i=0;i<31;i++){
            int power = 1<<i;
            int[] count1 = countOf(power);
            if(isequal(count1,count)) return true;
        }
        return false;
    }

   // Solution 2
    public boolean reorderedPowerOf22(int n) {
        int[] cnt = countOf(n);
        for(int i = 1; i <= 1000000000; i *= 2){
            if(isequal(cnt, countOf(i)))
                return true;
        }
        return false;
     }
  
     // check if both the arrays have equal values or not
     public static boolean isequal(int[] arr1, int[] arr2){
        for(int i=0;i<10;i++){
           if(arr1[i]!=arr2[i]) return false;
        }
        return true;
     }
 
     // counting the digits 
     private int[] countOf(int n){
        int[] cnt = new int[10];
        while(n > 0){
            cnt[n % 10]++;
            n /= 10; 
        }
        return cnt;
    }
}

