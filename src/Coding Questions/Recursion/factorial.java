public class factorial{
 
    /**
     * 
     */
    public static void main(String[] args) {
        var f=new factorial();
        var x = f.factorialpart(10);
        System.out.println(x);
    }

    public int factorialpart(int n) {
        System.out.println(n);
        if(n<0) return -1;
        if(n==0||n==1) return 1;
        return n*factorialpart(n-1);
    }
}