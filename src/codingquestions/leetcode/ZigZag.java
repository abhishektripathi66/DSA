package codingquestions.leetcode.ds;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 * <p>
 * Input: s = "A", numRows = 1
 * Output: "A"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consists of English letters (lower-case and upper-case), ',' and '.'.
 * 1 <= numRows <= 1000
 */
public class ZigZag {

    public static void main(String[] args) {
        ZigZag zz = new ZigZag();
        System.out.println(zz.convert("ABCD", 2));
    }

    public String convert(String s, int numRows) {
        //if number of rows is one then return as is
        if (numRows <= 1) return s;
        // create array to store string row wise
        String[] a = new String[numRows];
        //flag to check if to go from top down or bottom up
        boolean forward = true;
        //row count for array
        int rowcount = 0;

        for (int i = 0; i < numRows; i++) {
            a[i] = "";
        }
        for (int i = 0; i < s.length(); i++) {
            //if forward then in each index keep on adding the character and incrementing the rowcount else add ad decrement the rowcount
            if (forward) {
                a[rowcount] = a[rowcount] + s.charAt(i);
                rowcount++;
            } else {
                a[rowcount] = a[rowcount] + s.charAt(i);
                rowcount--;
            }
            // if the rowcount of array is equal max number of rows we have to start decrementing the rowci-ount
            if (rowcount == numRows) {
                //if more than 2 rows then we will make it false else itll be always true;
                if (numRows > 2) {
                    forward = false;
                }
                rowcount = rowcount - 2;
            }
            // if the rowcount is 0 and its still going bottom up then we have to reverse it.
            else if (rowcount == 0 && !forward) {
                forward = true;
            }


        }

        String toRetrun = "";
        for (int i = 0; i < numRows; i++) {
            toRetrun = toRetrun + a[i];
        }

        return toRetrun;


    }
}
