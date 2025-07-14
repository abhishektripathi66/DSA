package codingquestions.recursion;

public class DecimalToBinary {

    public static void main(String[] args) {
        var d = new DecimalToBinary();
        d.dec2binary(8);
    }

    public int decToBinary(int a) {
        if (a < 0) return -1;
        if (a == 0) return 0;
        return a % 2 + 10 * decToBinary(a / 2);

    }
}
