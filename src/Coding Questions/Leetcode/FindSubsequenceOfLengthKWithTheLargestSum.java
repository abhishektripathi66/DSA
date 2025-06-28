/*
2099. Find Subsequence of Length K With the Largest Sum
Solved
Easy
Topics
premium lock icon
Companies
Hint
You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.
Example 2:

Input: nums = [-1,-2,3,4], k = 3
Output: [-1,3,4]
Explanation: 
The subsequence has the largest sum of -1 + 3 + 4 = 6.
Example 3:

Input: nums = [3,4,3,3], k = 2
Output: [3,4]
Explanation:
The subsequence has the largest sum of 3 + 4 = 7. 
Another possible subsequence is [4, 3].
 

Constraints:

1 <= nums.length <= 1000
-105 <= nums[i] <= 105
1 <= k <= nums.length
*/
import java.util.Comparator;
import java.util.Vector;

class Pair {
    private int first;
    private int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
    public int getFirst(){
        return first;
    }
    public int getSecond(){
        return second;
    }
}

class SortByFirst implements Comparator <Pair>{
    public int compare(Pair pair1, Pair pair2) {
        if(pair1.getFirst() < pair2.getFirst())
            return -1;
        
        if(pair1.getFirst() > pair2.getFirst())
            return 1;
        
        return 0;
    }
}

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        Vector<Pair> vector = new Vector<>();
        for(int i = 0; i < nums.length; i++){
            vector.add(new Pair(nums[i], i));
        }

        Collections.sort(vector, new SortByFirst());
        Vector<Integer> indices = new Vector<>();
        for(int i = nums.length - k; i < nums.length; i++)
            indices.add(vector.get(i).getSecond());
        
        Collections.sort(indices);
        int[] res = new int[k];
        for(int i = 0; i < k; i++)
            res[i] = nums[indices.get(i)];
        
        return res;
    }
}
