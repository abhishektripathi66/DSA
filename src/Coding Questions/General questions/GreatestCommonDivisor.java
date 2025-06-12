public class GreatestCommonDivisor {
    
    public static void main(String[] args) {
        System.out.println(gcd(10,15));
        System.out.println(gcd1(15,10));
    }

    // time complexity: O(min(a,b)) Space complexity: O(1)
    public static int gcd(int a, int b){
        int res = Math.min(a, b);
        while(res>0){
            if(a%res==0 && b%res==0){
                return res;
            }
            res--;
        }
        return res;
    }

    // time complexity: O(log(min(a,b))) Space complexity: O(1)
    // using Euclidean algorithm
    // if a and b are both 0, then gcd is undefined, but we can return 0
    // if a is 0, then gcd is b
    public static int gcd1(int a,int b){
        if(b==0) return a;
        else return gcd1(b,a%b);
    }
}
