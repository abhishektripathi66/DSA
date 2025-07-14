public class ClimbingStairs {

    public static void main(String[] args) {
        var cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(44));
        System.out.println(cs.climbStairs2(44));
    }

    public int climbStairs(int n) {
        int p[] = new int[n + 1];
        p[0] = 1;
        p[1] = 1;
        for (int i = 2; i <= n; i++) {
            p[i] = p[i - 1] + p[i - 2];
        }
        return p[n];
    }

    public int climbStairs2(int n) {

        if (n == 0 || n == 1) return 1;
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }
}
