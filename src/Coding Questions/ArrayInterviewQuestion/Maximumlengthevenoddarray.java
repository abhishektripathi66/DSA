public class Maximumlengthevenoddarray {
    

    public static void main(String[] args) {
        System.out.println(maxlengthoddeven(new int[]{10,12,14,7,8}));
        System.out.println(maxlengthoddeven(new int[]{7,10,13,14}));
        System.out.println(maxlengthoddeven(new int[]{10,12,8,4}));
    }

    public static int maxlengthoddeven(int[] arr){

        int count=1,maxcount=1;
        for(int i=1;i<arr.length;i++){
                if((arr[i]%2==0 && arr[i-1]%2!=0) || (arr[i]%2!=0 && arr[i-1]%2==0)){
                    count+=1;
                    maxcount = Math.max(count,maxcount);
                }
                else{
                    count=1;

                }
            }
        return maxcount;
    }
    
}
