package codingquestions.stack;

import java.util.*;

public class questions {

    // Q1) Leetcode 232. Implement Queue using Stacks.
    public class QueueUsingStack {

        private Stack<Integer> first;
        private Stack<Integer> second;

        public QueueUsingStack() {
            first = new Stack<>();
            second = new Stack<>();
        }

        public void add(int item) {
            first.push(item);
        }

        public int remove() throws Exception {
            while (!first.isEmpty()) {
                int element = first.pop();
                second.push(element);
                // second.push(first.pop());
            }

            int removed = second.pop();
            while (!second.isEmpty()) {
                first.push(second.pop());
            }

            return removed;
        }

        public int peek() throws Exception {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }

            int peeked = second.peek();

            while (!second.isEmpty()) {
                first.push(second.pop());
            }

            return peeked;
        }

        public boolean isEmpty() {
            return first.isEmpty();
        }
    }

    // Q2) Game of Two Stacks.
    public class TwoStacks {

        static int twoStacks(int x, int[] a, int[] b) {
            return twoStacks(x, a, b, 0, 0) - 1;
        }

        private static int twoStacks(int x, int[] a, int[] b, int sum, int count) {
            if (sum > x) {
                return count;
            }

            if (a.length == 0 || b.length == 0) {
                return count;
            }

            int ans1 = twoStacks(x, Arrays.copyOfRange(a, 1, a.length), b, sum + a[0], count + 1);
            int ans2 = twoStacks(x, a, Arrays.copyOfRange(b, 1, b.length), sum + b[0], count + 1);

            return Math.max(ans1, ans2);
        }
    }

    // Q3) Leetcode 20. Valid Parentheses.
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                }
                if (ch == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }

    // Q4) Leetcode 921. Minimum Add to Make Parentheses Valid.
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {

            if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }

}
