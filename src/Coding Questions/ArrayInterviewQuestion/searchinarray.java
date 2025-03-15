package ArrayInterviewQuestion;

// /Write a program to to check if an array contains a number in Java.

//int[] intArray = {1,2,3,4,5,6};
//searchInArray(intArray, 6); // 5
public class searchinarray {
    
    public static void main(String[] args) {
        searchinarray sa = new searchinarray();
        sa.searchValue(new int[]{1,2,3,4,5,6,7}, 7);
        sa.searchValue(new int[]{1,2,3,4,5,6,7}, 8);
    }

    public int searchValue(int[] intArray, int valueToSearch){
       
        
        for(int i=0;i<intArray.length;i++){
            if(intArray[i]==valueToSearch){
                System.out.println(valueToSearch+" is found at index "+i);
                 return i;
            }
        }
        System.out.println(valueToSearch+" is not found int the array");
        return -1;
        
    }
}
