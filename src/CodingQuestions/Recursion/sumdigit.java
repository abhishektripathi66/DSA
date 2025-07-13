public class sumdigit{

    public static void main(String[] args) {
        var ds = new sumdigit();
        System.out.println(ds.digitSum(121,0));
    }
    public int digitSum(int n,int sum) {
        if( n<10) return sum+n;
        return digitSum(n/10,sum+n%10);
    }
}