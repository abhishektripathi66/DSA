public class ReflectionMirror {

    public static void main(String[] args) {
        ReflectionMirror.mirrorReflection(3, 1);
    }

    public static int mirrorReflection(int p, int q) {
        while (((p | q) & 1) == 0) {
            p >>= 1;
            q >>= 1;
        }

        return (q & 1) + ((p & 1) ^ 1);

    }

    public int reverse(int x) {
        if (x > 2147483647 || x < -2147483648) return 0;

        StringBuffer sb = new StringBuffer(Integer.toString(x));
        sb.reverse();
        return Integer.valueOf(sb.toString());
    }
}
