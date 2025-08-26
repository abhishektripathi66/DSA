
package codingquestions.leetcode;

public class IsPowerOfFour {

    public static void main(String[] args) {
        var po4 = new IsPowerOfFour();
        System.out.println(po4.isPowerOfFour2(16));
        System.out.println();
    }

    public boolean isPowerOfFour2(int n) {

        int back = n;
        if (back == 0) return false;
        if (back > 0) {
            while (back > 1) {
                int rem = back % 4;
                if (rem == 0) {
                    back = back / 4;
                } else return false;
            }
        } else {
            while (back < 0) {
                int rem = back % 4;
                if (rem == 0) {
                    back = back / 4;
                } else return false;
            }
        }
        return true;
    }
    public boolean isPowerOfFour(int n) {
        if(n <= 0)
            return false;

        /**
        4 ^ x = n
        log4(n) = x
        log(n) / log(4) = x
        */
        double x = Math.log10(n) / Math.log10(4);
        return x == (int)x;
    }
}
