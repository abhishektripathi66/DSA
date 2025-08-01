package codingquestions.twopointertechnique;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {10,20,30,40,50};
        int[] arr2 = {5,15,25,35,45};
        System.out.println(medianofTwoSortedArrays(arr1, arr2));
        System.out.println(medianUsingBinarySearch(arr1, arr2));
        int[] arr3 ={1,2,3,4,5,6};
        int[] arr4={10,20,30,40,50};
        System.out.println(medianofTwoSortedArrays(arr3,arr4));
        System.out.println(medianUsingBinarySearch(arr3, arr4));
    }

    public static double medianofTwoSortedArrays(int[] arr1,int[] arr2){

        int i=0,j=0,k=0;
        int[] arr = new int[arr1.length+arr2.length];
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]>arr2[j]){
                arr[k++]=arr2[j++];
            }
            else if(arr1[i]<arr2[j]){
                arr[k++]=arr1[i++];
            }
            else{
                arr[k++]=arr1[i++];
                arr[k++]=arr2[j++];
            }
        }
        while(i<arr1.length){
            arr[k++]=arr1[i++];
        }
        while(j<arr2.length){
            arr[k++]=arr2[j++];
        }

        if(arr.length%2==0){
            return (arr[arr.length/2-1]+arr[arr.length/2])/2.0;
        }
        else{
            return arr[arr.length/2];
        }

    }
    
    //time complexity O(logn)
    public static double medianUsingBinarySearch(int[] arr1, int[] arr2){
        int n1= arr1.length,n2=arr2.length;
        int begin1=0,end1=n1;
        while(begin1<=end1){
            int i1= (begin1+end1)/2;
            int i2=(n1+n2+1)/2-i1;
            int min1 = (i1==n1)?Integer.MAX_VALUE:arr1[i1];
            int max1 = (i1==0)?Integer.MIN_VALUE:arr1[i1-1];
            int min2 = (i2==n2)?Integer.MAX_VALUE:arr2[i2];
            int max2 = (i2==0)?Integer.MIN_VALUE:arr2[i2-1];
            if(max1<=min2 && max2<=min1){
                if((n1+n2)%2==0) return ((double) Math.max(max1,max2)+Math.min(min1,min2))/2;
                else return (double) Math.max(max1,max2);
            }
            else if(max1>min2) end1=i1-1;
            else begin1=i1+1;
        }
        return -1.0;
    }
}
