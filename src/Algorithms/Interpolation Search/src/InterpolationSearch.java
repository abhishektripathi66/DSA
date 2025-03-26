import java.util.*;
public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int value){
        int high = arr.length - 1;
        int low = 0;

        while (value >=arr[low] && value <=arr[high] && high >= low) {
            if (arr[low] == arr[high]){ // Avoid division by zero
                if (arr[low] == value)
                    return low;
                else
                    return -1;
            }

            int probe = low + ((high - low) * (value - arr[low])) / (arr[high] - arr[low]); // Formula for the probing(guessing).

            if(probe < low || probe > high) // Prevent out-of-bounds errors
            return -1;

            if(arr[probe] == value){
                return probe;
            }
            else if(arr[probe] < value){
                low = probe + 1;
            }
            else{
                high = probe - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int len = sc.nextInt();
        int[] arr = new int[len];

        System.out.println("Enter array elements: ");
        for (int i = 0; i < len; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter value to be searched: ");
        int value = sc.nextInt();

        int index = interpolationSearch(arr, value);

        if(index == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " + index);
    }
}