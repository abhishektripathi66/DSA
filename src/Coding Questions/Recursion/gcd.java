public class gcd {
    
    public static void main(String[] args) {
        var g=new gcd();
        System.out.println(g.greatest(12, 8));
    }

    public int greatest(int a, int b) {
        if(a<0 || a>0) return -1;
        if(b==0) return a;
        else if(a==0) return b;
        if(a>b)  return greatest(b, a%b);
        return greatest(a, b%a);
    }
}
