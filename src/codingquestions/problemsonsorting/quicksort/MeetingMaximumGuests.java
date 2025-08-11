package codingquestions.problemsonsorting.quicksort;

import java.util.Arrays;

public class MeetingMaximumGuests {
    
    public static void main(String[] args) {
        
    }

    public static int maxMeetingGuests(int[] arr, int[] dep){
        Arrays.sort(arr);Arrays.sort(dep);
        int i=0,j=0,res=1,curr=1;
        while(i<arr.length && j<arr.length){
            if(arr[i]<dep[j]){
                curr++;i++;
            }else{
                curr--;j++;
            }
            res=Math.max(curr,res);
        }
        return res;
    }
}
