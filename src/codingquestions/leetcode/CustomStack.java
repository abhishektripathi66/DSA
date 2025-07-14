/**
 * 1381. Design a Stack With Increment Operation
 * Solved
 * Medium
 * Topics
 * Companies
 * Hint
 * Design a stack that supports increment operations on its elements.
 * <p>
 * Implement the CustomStack class:
 * <p>
 * CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack.
 * void push(int x) Adds x to the top of the stack if the stack has not reached the maxSize.
 * int pop() Pops and returns the top of the stack or -1 if the stack is empty.
 * void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.
 **/

public class CustomStack {

    int[] cs;
    int lastem = 0;

    public CustomStack(int maxSize) {
        cs = new int[maxSize];
    }

    public void push(int x) {
        if (lastem == -1) lastem = 0;
        if (lastem < cs.length) {
            cs[lastem] = x;
            lastem++;
            // System.out.println(cs[lastem]);
        }
    }

    public int pop() {

        if (lastem > 0) {
            int x = cs[--lastem];
            return x;
        } else return -1;
    }

    public void increment(int k, int val) {

        int i = 0;
        System.out.println(val);
        if (k >= cs.length) k = cs.length;
        while (i < k) {
            System.out.println(i + ": " + cs[i]);

            cs[i] = cs[i] + val;
            i++;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
