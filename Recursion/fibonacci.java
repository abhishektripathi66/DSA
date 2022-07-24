public class fibonacci{

    public static void main(String[] args) {
        var f = new fibonacci();
        var fi = f.fibonaccipart(8);
        System.out.println(fi);
    }

    public int fibonaccipart(int n) {
        if(n<0) return -1;
        if(n==0) return 0;
        if(n==1) return 1;
        return fibonaccipart(n-1)+fibonaccipart(n-2);
    }
}