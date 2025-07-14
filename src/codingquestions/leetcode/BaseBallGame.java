import java.util.ArrayList;
import java.util.List;

/**
 * 682. Baseball Game
 * Solved
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
 * <p>
 * You are given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
 * <p>
 * An integer x.
 * Record a new score of x.
 * '+'.
 * Record a new score that is the sum of the previous two scores.
 * 'D'.
 * Record a new score that is the double of the previous score.
 * 'C'.
 * Invalidate the previous score, removing it from the record.
 * Return the sum of all the scores on the record after applying all the operations.
 * <p>
 * The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ops = ["5","2","C","D","+"]
 * Output: 30
 * Explanation:
 * "5" - Add 5 to the record, record is now [5].
 * "2" - Add 2 to the record, record is now [5, 2].
 * "C" - Invalidate and remove the previous score, record is now [5].
 * "D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
 * "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
 * The total sum is 5 + 10 + 15 = 30.
 * Example 2:
 * <p>
 * Input: ops = ["5","-2","4","C","D","9","+","+"]
 * Output: 27
 * Explanation:
 * "5" - Add 5 to the record, record is now [5].
 * "-2" - Add -2 to the record, record is now [5, -2].
 * "4" - Add 4 to the record, record is now [5, -2, 4].
 * "C" - Invalidate and remove the previous score, record is now [5, -2].
 * "D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
 * "9" - Add 9 to the record, record is now [5, -2, -4, 9].
 * "+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
 * "+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
 * The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
 * Example 3:
 * <p>
 * Input: ops = ["1","C"]
 * Output: 0
 * Explanation:
 * "1" - Add 1 to the record, record is now [1].
 * "C" - Invalidate and remove the previous score, record is now [].
 * Since the record is empty, the total sum is 0.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= operations.length <= 1000
 * operations[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 104, 3 * 104].
 * For operation "+", there will always be at least two previous scores on the record.
 * For operations "C" and "D", there will always be at least one previous score on the record.
 */
public class BaseBallGame {

    public static void main(String[] args) {

    }

    public int calPoints(String[] operations) {
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 0; i < operations.length; i++) {
            if ("+".equalsIgnoreCase(operations[i])) {
                l.add(l.get(l.size() - 1) + l.get(l.size() - 2));
            } else if ("D".equalsIgnoreCase(operations[i])) {
                l.add(2 * l.get(l.size() - 1));
            } else if ("C".equalsIgnoreCase(operations[i])) {
                l.remove(l.size() - 1);
            } else {
                l.add(Integer.parseInt(operations[i]));
            }
        }
        int value = 0;
        for (int i = 0; i < l.size(); i++) {
            value += l.get(i);
        }
        return value;

    }
}
