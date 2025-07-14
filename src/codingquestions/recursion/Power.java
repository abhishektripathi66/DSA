package codingquestions.recursion;

public class Power {

    public static void main(String[] args) {
        var p = new Power();
        System.out.println(p.powers(2, 10));
    }

    public int powers(int n, int m) {
        if (m < 0) return -1;
        if (m == 0) return 1;
        return n * powers(n, m - 1);
    }
}
