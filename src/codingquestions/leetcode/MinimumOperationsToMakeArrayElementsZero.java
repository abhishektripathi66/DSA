/*
3495. Minimum Operations to Make Array Elements Zero
Solved
Hard
Topics
premium lock icon
Companies
Hint
You are given a 2D array queries, where queries[i] is of the form [l, r]. Each queries[i] defines an array of integers nums consisting of elements ranging from l to r, both inclusive.

In one operation, you can:

Select two integers a and b from the array.
Replace them with floor(a / 4) and floor(b / 4).
Your task is to determine the minimum number of operations required to reduce all elements of the array to zero for each query. Return the sum of the results for all queries.

 

Example 1:

Input: queries = [[1,2],[2,4]]

Output: 3

Explanation:

For queries[0]:

The initial array is nums = [1, 2].
In the first operation, select nums[0] and nums[1]. The array becomes [0, 0].
The minimum number of operations required is 1.
For queries[1]:

The initial array is nums = [2, 3, 4].
In the first operation, select nums[0] and nums[2]. The array becomes [0, 3, 1].
In the second operation, select nums[1] and nums[2]. The array becomes [0, 0, 0].
The minimum number of operations required is 2.
The output is 1 + 2 = 3.

Example 2:

Input: queries = [[2,6]]

Output: 4

Explanation:

For queries[0]:

The initial array is nums = [2, 3, 4, 5, 6].
In the first operation, select nums[0] and nums[3]. The array becomes [0, 3, 4, 1, 6].
In the second operation, select nums[2] and nums[4]. The array becomes [0, 3, 1, 1, 1].
In the third operation, select nums[1] and nums[2]. The array becomes [0, 0, 0, 1, 1].
In the fourth operation, select nums[3] and nums[4]. The array becomes [0, 0, 0, 0, 0].
The minimum number of operations required is 4.
The output is 4.

 

Constraints:

1 <= queries.length <= 105
queries[i].length == 2
queries[i] == [l, r]
1 <= l < r <= 109
*/
class Solution {
    private long solveHelper(long a, long b){
        long l = 1, r = 3, s = 1, res = 0;

        while(l <= b){
            r = l * 4 - 1;
            long start = Math.max(l, a);
            long end = Math.min(r, b);

            if(start <= end)
                res += (end - start + 1) * s;
            
            l *= 4;
            s++;
        }
        return res;
    }

    public long minOperations(int[][] queries) {
        long res = 0;
        for(int i = 0; i < queries.length; i++){
            long ans = solveHelper(queries[i][0], queries[i][1]);
            res += (ans + 1) /2;
        }
        return res;
    }
}
