public class power{
    
    public static void main(String[] args) {
        var p = new power();
        System.out.println(p.powers(2,10));
    }

    public int powers(int n,int m){
        if(m<0) return -1;
        if(m==0) return 1;
        return n*powers(n,m-1);
    }
}
