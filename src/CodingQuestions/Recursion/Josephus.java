public class Josephus {

    public static void main(String[] args) {
        System.out.println(josephus(6, 3));
        System.out.println(josephus(5, 3));
        System.out.println(josephus(4, 3));
    }
    
    public static int josephus(int n, int k){
        if(n==1){
            return 0;
        }


        return (josephus(n-1, k)+k)%n;     
    }
}
