/**
 * 657. Robot Return to Origin
 * Solved
 * Easy
 * Topics
 * premium lock icon
 * Companies
 * There is a robot starting at the position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
 * <p>
 * You are given a string moves that represents the move sequence of the robot where moves[i] represents its ith move. Valid moves are 'R' (right), 'L' (left), 'U' (up), and 'D' (down).
 * <p>
 * Return true if the robot returns to the origin after it finishes all of its moves, or false otherwise.
 * <p>
 * Note: The way that the robot is "facing" is irrelevant. 'R' will always make the robot move to the right once, 'L' will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: moves = "UD"
 * Output: true
 * Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.
 * Example 2:
 * <p>
 * Input: moves = "LL"
 * Output: false
 * Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= moves.length <= 2 * 104
 * moves only contains the characters 'U', 'D', 'L' and 'R'.
 */

public class ReturnRobotToOrigin {

    public static void main(String[] args) {

    }

    public boolean judgeCircle(String moves) {
        int a = 0, b = 0;

        char[] c = moves.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if ('U' == c[i]) {
                a += 1;
            } else if ('D' == c[i]) {
                a -= 1;
            } else if ('L' == c[i]) {
                b -= 1;
            } else if ('R' == c[i]) {
                b += 1;
            }
        }
        if (a == 0 && b == 0) return true;
        return false;
    }

}
