package Leetcode;

/*
 * 
 * Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).

 

Example 1:

Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].
Example 2:

Input: low = 8, high = 10
Output: 1
Explanation: The odd numbers between 8 and 10 are [9].
 

Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Odd Numbers in an Interval Range.
Memory Usage: 40.5 MB, less than 78.36% of Java online submissions for Count Odd Numbers in an Interval Range.
 */
public class CountOddNumbers {
    
    public static void main(String[] args) {
        var con = new CountOddNumbers();
        System.out.println(con.countOdds(10, 4));
    }

    public int countOdds(int low, int high) {
        //To find total number of elements between high and low
        int i = high-low;
        // if both high and low are even then i/2 is number of elements
        if(low%2==0 && high%2==0){
            return i/2;
        }
        //else return only +1;
        else{
            i = i/2+1;
            return i;
        }
    }
}
