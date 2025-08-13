package codingquestions.leetcode;

// NEW SOLUTION
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)
            return false;
        
        double x = Math.log10(n) / Math.log10(3);
        return x == (int)x;
    }
}

public class PowerOfThree {

    public static void main(String[] args) {
        var x = new PowerOfThree();
        System.out.println(x.isPowerOfThree(9));
    }

    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        } else if (n == 0) {
            return false;
        } else if (n % 3 != 0) {
            return false;
        } else {
            return isPowerOfThree(n / 3);
        }
    }
}
