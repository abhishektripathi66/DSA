package codingquestions.problemsonsorting;

public class IntersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1= {10,20,20,40,60};
        int[] arr2 = {2,20,20,20};
        findIntersection(arr1, arr2);

    }

    public static void findIntersection(int[] arr1, int[] arr2){
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length){
            if(i>0 && arr1[i]==arr1[i-1]){i++; continue;}
            if(arr1[i]==arr2[j]){
                    System.out.println(arr1[i]);
                    i++;j++;
            
            }
            else if(arr1[i]>arr2[j]) j++;
            else i++;

        }
    }
}
