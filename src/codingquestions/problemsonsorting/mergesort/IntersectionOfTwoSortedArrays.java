package codingquestions.problemsonsorting.mergesort;

public class IntersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1= {10,20,20,40,60};
        int[] arr2 = {2,20,20,20};
        findIntersection(arr1, arr2);
        findUnion(arr1, arr2);

    }
    // we are using the merge sort to find the commong elements between the two arrays but print only once
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

    // using the merge sort we are finding the elements that are the union of both the array but print only once
    public static void findUnion(int[] arr1, int[] arr2){
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length){
            if(i>0 && arr1[i]==arr1[i-1]){i++; continue;}
            if(j>0 && arr2[j]==arr1[j-1]){j++; continue;}
            if(arr1[i]<arr2[j]){
                    System.out.println(arr1[i++]);
            } 
            else if(arr1[i]>arr2[j]){
                System.out.println(arr2[j++]);
            }
            else{
                System.out.println(arr1[i++]); j++;
            }

        }
        while(i<arr1.length){
            System.out.println(arr1[i++]);
        }
        while(j<arr2.length){
            System.out.println(arr2[j++]);
        }
    }
}
