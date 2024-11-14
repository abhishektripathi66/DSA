public class sumdigit{

    public static void main(String[] args) {
        var ds = new sumdigit();
        System.out.println(ds.digitSum(121));
    }
    public int digitSum(int n) {
        if(n<0) return -1;
        if(n>=0 && n<10) return n;
        return n%10+digitSum(n/10);
    }
}