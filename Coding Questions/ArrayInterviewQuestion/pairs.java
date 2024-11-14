package ArrayInterviewQuestion;

public class pairs {
    
    public static void main(String[] args) {
        System.out.println(pairs.pairSum(new int[]{1,2,3,4,5,6,4,7,8,9,5,1,0,11,2,-1}, 10));
    }

    public static String pairSum(int[] myArray, int sum) {
        
        String s ="";
        for(int i=0;i<myArray.length;i++){
            for(int j=i+1;j<myArray.length;j++){
                if(myArray[i]+myArray[j]==sum){
                    s=s+myArray[i]+":"+myArray[j]+" ";
                }
            }
        }
        return s;
  }
}
