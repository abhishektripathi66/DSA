package ArrayInterviewQuestion;

public class MinimumGroupFlipsToMakeSame {

    public static void main(String[] args) {
        minflipseff(new int[]{1,1,0,0,0,1});
        minflipseff(new int[]{1,1,0,0,0,1,1,1,0,0,1});
        minflipseff(new int[]{0,0,1,1,0,0,0,1,1,0,0});
        minflipseff(new int[]{0,0,1,1,1,0,0,0,0,1,1});
        minflipseff(new int[]{1,1,0,0,0,0,1,1,1,1,0});
    }

    // The implementation says that the difference between the count of sets of 0's and 1's either 1 or zero.
    // we have to basically find the first switch in the group and that group needs to be flipped.
    // The time complexity is O(n) and space complexity is O(1).
    // The implementation is efficient and works well for the problem.
    public static void minflipseff(int[] arr){
        
        System.out.println("--------------START-----------");
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]!=arr[i-1]){
                if(arr[i]!=arr[0]) System.out.print("From "+i+" to ");
                else System.out.println(i-1);
            }
        }
        if(arr[arr.length-1]!=arr[0]) System.out.println(arr.length-1);
        
        System.out.println("--------------END-----------");
    }

    
    
}
