package codingquestions.TwoPointerTechnique;

public class AllocateMinimumNumberOfPages {
    public static void main(String[] args) {
        int[] arr ={10,5,30,1,2,5,10,10};
        System.out.println(allocatePagesnaiveMethod(arr, arr.length, 3));
        System.out.println(minPagesusingBinarySearch(arr, arr.length, 3));
        int[] arr1 = {10,5,20};
        System.out.println(minPagesusingBinarySearch(arr1, arr1.length, 2));
    }

    //naive solution basically it takes ologn space
    public static int allocatePagesnaiveMethod(int[] arr,int n, int k){
        if(k==1)
            return sum(arr,0,n-1);    
        if(n==1) return arr[0];
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            res = Math.min(res, Math.max(allocatePagesnaiveMethod(arr,i, k-1),sum(arr,i,n-1)));
        }
        return res;
    
    }

    public static int sum(int[] arr,int b, int e){
        int s =0;
        for(int i=b;i<=e;i++) s+=arr[i];
        return s;
    }

    // the time complexity
    public static int minPagesusingBinarySearch(int arr[], int n, int k){
        int sum =0;
        int max =0;
        for(int i:arr){
            sum+=i;
            max=Math.max(max,i);
        }
        int low=max, high =sum, res=0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(isFeasible(arr,n,k,mid)){
                res=mid;
                high = mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return res;

    }

    // O(nlog(sum))
    public static boolean isFeasible(int[] arr, int n, int k, int ans){
        int req =1,sum=0;
        for(int i=0;i<n;i++){
            if(sum+arr[i]>ans){
                req++;
                sum=arr[i];
            }
            else{
                sum+=arr[i];
            }
        }
        return req<=k;
    }


    
}


