import java.util.Arrays;
import java.util.Stack;

/**
 * 735. Asteroid Collision
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * We are given an array asteroids of integers representing asteroids in a row.
 * <p>
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * <p>
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 **/

class AsteriodCollision {

    //mysolution
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            if (a > 0) {
                stack.push(a);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -a) {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(a);
                }

                if (stack.peek() == -a) {
                    stack.pop();
                }
            }
        }

        int[] res = new int[stack.size()];
        int i = stack.size() - 1;

        while (!stack.isEmpty()) {
            res[i--] = stack.pop();
        }

        return res;
    }

    //best solution
    public int[] asteroidCollisionbest(int[] asteroids) {
        int previous = 0, current = 1;
        while (current < asteroids.length) {
            if (previous < 0 || asteroids[previous] < 0 || asteroids[current] > 0) {
                asteroids[++previous] = asteroids[current++];
            } else if (asteroids[previous] == -asteroids[current]) {
                previous--;
                current++;
            } else if (asteroids[previous] > -asteroids[current]) {
                current++;
            } else {
                previous--;
            }
        }

        return previous < 0 ? new int[0] : Arrays.copyOfRange(asteroids, 0, previous + 1);
    }

}
