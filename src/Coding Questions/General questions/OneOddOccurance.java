public class OneOddOccurance {

    public static void main(String[] args) {
        System.out.println(findOddOccurrenceOptimized(new int[]{7,3,7,7,7}));
        System.out.println(findOddOccurrence(new int[]{7,3,7,7,7}));
    }

    // time complexity: O(n^2)
    // space complexity: O(1)
    public static int findOddOccurrence(int[] arr) {
        
        for(int i=0;i<arr.length;i++){
            int count=0;
            for(int j=0;j<arr.length;j++){
                if(arr[i]==arr[j]) count++;
            }
            if(count % 2 != 0) {
                return arr[i]; // Return the element that occurs an odd number of times
            }
        }
        return -1;
    }

    // time complexity: O(n)
    // space complexity: O(1)
    public static int findOddOccurrenceOptimized(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num; // XOR operation
        }
        return result; // The result will be the element that occurs an odd number of times
    }
    
    
}
