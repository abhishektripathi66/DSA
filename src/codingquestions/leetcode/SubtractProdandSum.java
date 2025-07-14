/***
 *
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.


 Example 1:

 Input: n = 234
 Output: 15
 Explanation:
 Product of digits = 2 * 3 * 4 = 24
 Sum of digits = 2 + 3 + 4 = 9
 Result = 24 - 9 = 15
 Example 2:

 Input: n = 4421
 Output: 21
 Explanation:
 Product of digits = 4 * 4 * 2 * 1 = 32
 Sum of digits = 4 + 4 + 2 + 1 = 11
 Result = 32 - 11 = 21

 Runtime: 0 ms, faster than 100.00% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
 Memory Usage: 41.3 MB, less than 17.66% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
 *
 */
public class SubtractProdandSum {

    public static void main(String[] args) {

    }

    public int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;
        while (n > 0) {
            int num = n % 10;
            sum += num;
            prod *= num;
            n = n / 10;
        }

        return prod - sum;
    }
}
