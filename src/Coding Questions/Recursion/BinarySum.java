import java.math.BigInteger;

public class BinarySum {
    
    /*
     * Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
     * 
     */
    public static void main(String[] args) {
        var classname = new BinarySum();
        System.out.println(classname.addBinary("1010",  "1011"));
    }

    public String addBinary(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger sum = x.add(y);
        return sum.toString(2);
    }

}
