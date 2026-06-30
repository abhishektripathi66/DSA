/*
1545. Find Kth Bit in Nth Binary String
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given two positive integers n and k, the binary string Sn is formed as follows:

S1 = "0"
Si = Si - 1 + "1" + reverse(invert(Si - 1)) for i > 1
Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).

For example, the first four strings in the above sequence are:

S1 = "0"
S2 = "011"
S3 = "0111001"
S4 = "011100110110001"
Return the kth bit in Sn. It is guaranteed that k is valid for the given n.

 

Example 1:

Input: n = 3, k = 1
Output: "0"
Explanation: S3 is "0111001".
The 1st bit is "0".
Example 2:

Input: n = 4, k = 11
Output: "1"
Explanation: S4 is "011100110110001".
The 11th bit is "1".
 

Constraints:

1 <= n <= 20
1 <= k <= 2n - 1
*/
class Solution {
    public char findKthBit(int n, int k) {
        System.out.println(n + " " + k);
        if(n == 1){
            assert(k == 1);
            return '0';
        }

        // mid
        if(k == (1 << (n - 1))) return '1';

        // left
        if(k < (1 << (n - 1)))
            return findKthBit(n - 1, k);

        // right
        return (char)('0' + (int)('1' - findKthBit(n - 1, (1 << n) - k)));
    }
}
