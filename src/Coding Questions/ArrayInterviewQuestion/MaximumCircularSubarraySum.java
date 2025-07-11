public class MaximumCircularSubarraySum {
    

    public static void main(String[] args) {
        
        System.out.println(naivemethod(new int[]{5,-2,3,4}));

    }

    public static int naivemethod(int[] arr){

        int count=0,countmax=0;
        for(int i=0;i<arr.length;i++){
            int j=i+1;
            count=arr[i];
            if(j>arr.length-1) j=0;
            while(j!=i){
                
                count+=arr[j];
                countmax=Math.max(count,countmax);
                j++;
                if(j>arr.length-1) j=0;
            }
            countmax=Math.max(count,countmax);
        }
        return countmax;


    }

    public static int effmethod(int[] arr){

        int[] minsubarrysum=new int[arr.length];
        int minsum = arr[0];
        minsubarrysum[0]=arr[0];
        int[] minsubarry = new int[arr.length];
        for(int i=1;i<arr.length;i++){
            minsum+=arr[i];
            minsubarrysum[]


        }



    }
}
