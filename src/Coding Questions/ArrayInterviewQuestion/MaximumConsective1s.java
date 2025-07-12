public class MaximumConsective1s {

    public static void main(String[] args) {
        System.out.println(consective1s(new int[]{0,1,1,0,1,0}));
        System.out.println(consective1s(new int[]{1,1,1,1}));
        System.out.println(consective1s(new int[]{1,0,1,1,0,1,1,1,1}));
    }

    public static int consective1s(int[] arr){
        int count=0;
        int maxcount=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1) count++;
            else{
                maxcount = Math.max(maxcount,count);
                count=0;
            }

        }
        maxcount = Math.max(maxcount, count);
        return maxcount;
    }
    
}
