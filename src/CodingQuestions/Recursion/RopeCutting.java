public class RopeCutting {

    public static void main(String[] args) {
        System.out.println(ropecut(23, 11, 9, 12));
        System.out.println(ropecut(9, 2, 2, 2));
    }

    public static int ropecut(int n, int a, int b, int c){
        if(n==0){
            return 0 ;
        }
        if(n<0){
            return -1;
        }
        int res = Math.max(Math.max(ropecut(n-a, a, b, c), ropecut(n-b, a, b, c)), ropecut(n-c, a, b, c));
        return res<0?-1:res+1;
    }
    
}
