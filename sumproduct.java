import java.util.Arrays;

public class sumproduct {
    
        public static void main(String[] args) {
            int[] b = new int[10];
            b[0]=1;
            System.out.println(Arrays.toString(b));
            int[] a = {1,2,3,4,5,6,7,8,9,10};
            var sp = new sumproduct();
            // sp.sumandproduct(a);
            // sp.pairarray(a);
            // sp.revresearray2(a);
        }

        public void sumandproduct(int[] a ) {
            int sum=0;
            int product =1;
            for(int i=0;i<a.length;i++){
                sum +=a[i];
                product*=a[i];

            }
            System.out.println("The product is "+product+" and the sum is "+sum);
        }

        public void pairarray(int[] a){
            for(int i=0;i<a.length;i++){
                for(int j=0;j<a.length;j++){
                    System.out.println(a[i]+""+a[j]);
                }
            }
        }

        public void reverseArray(int[] a){
            int[] b = new int[a.length];
            int c= a.length-1;
            for(int i=0;i<a.length;i++){
                    b[c--]=a[i];
            }
            System.out.println(Arrays.toString(b));
        }

        public void revresearray2(int[] a) {

            for(int i=0;i<a.length/2;i++){
                int temp = a[a.length-1-i];
                a[a.length-1-i]=a[i];
                a[i]=temp;
            }
            System.out.println(Arrays.toString(a));
            
        }

        
}
