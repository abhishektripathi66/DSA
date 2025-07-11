public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(findMajority(new int[]{8,3,4,8,8}));
    }

    public static int findMajority(int[] nums){
        int count =0;
        for(int a:nums){
            for(int b:nums){
                if(a==b)
                count++;
            }
            count--;
            if(count> nums.length/2){
                System.out.println(a); 
                return a;
            }
               

        }
        System.out.println(-1);
        return -1;
    }
    
}
