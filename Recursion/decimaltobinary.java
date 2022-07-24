public class decimaltobinary {
    
    public static void main(String[] args) {
        var d = new decimaltobinary();
        System.out.println(d.dec2binary(8));
    }

    public int dec2binary(int a) {
        if(a<0) return -1;
        if(a==0) return 0;
        return a%2+10*dec2binary(a/2);

    }
}
