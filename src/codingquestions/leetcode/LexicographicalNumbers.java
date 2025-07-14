package codingquestions.leetcode;

/*
386. Lexicographical Numbers
Solved
Medium
Topics
premium lock icon
Companies
Given an integer n, return all the numbers in the range [1, n] sorted in lexicographical order.

You must write an algorithm that runs in O(n) time and uses O(1) extra space. 

 

Example 1:

Input: n = 13
Output: [1,10,11,12,13,2,3,4,5,6,7,8,9]
Example 2:

Input: n = 2
Output: [1,2]
 

Constraints:

1 <= n <= 5 * 104
*/

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    private void recurse(int n, int cur, List<Integer> res) {
        if (cur > n)
            return;

        //cur <= n
        res.add(cur);
        recurse(n, cur * 10, res);
        if (cur % 10 != 9)
            recurse(n, cur + 1, res);
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        int cur = 1;
        recurse(n, cur, res);
        return res;
    }
}
