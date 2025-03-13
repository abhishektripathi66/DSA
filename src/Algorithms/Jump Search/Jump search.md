# Jump Search Algorithm
Jump Search is an efficient searching algorithm used to find an element in a **sorted array**. It works by jumping ahead by a fixed number of steps instead of searching linearly, making it faster than linear search but slightly slower than binary search.

## **How Jump Search Works**
1. Choose a **jump step size** = `√(array length)`.
2. Jump forward by the step size until the element at the current position **exceeds** or **matches** the target.
3. If the element exceeds the target, perform a **linear search** within the previous block.
4. If the element is found, return its index; otherwise, return `-1`.

## **Time Complexity**
- **Best Case:** `O(1)` (If the first jump lands on the target)
- **Average Case:** `O(√n)`
- **Worst Case:** `O(√n)`

## **Prerequisites**
- The array must be **sorted in ascending order**.
- If the array is not sorted, Jump Search **will not work correctly**.

## **Implementation**
Here's a **Java implementation** of the Jump Search algorithm:

### **Java Code**
```java
import java.util.*;

public class JumpSearch {
    /**
     * Performs Jump Search on a sorted array.
     * @param arr The sorted array to search in
     * @param target The element to find
     * @return The index of the element if found, otherwise -1
     */
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n)); // Step size
        int prev = 0;

        // Jump in steps of 'step' until we find a block where target could be
        while (prev < n && arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return -1; // Element is not present
            }
        }

        // Linear search in the identified block
        while (prev < Math.min(step, n)) {
            if (arr[prev] == target) {
                return prev; // Return index if found
            }
            prev++;
        }

        return -1; // Element not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {2, 3, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int[] testCases = {23, 72, 5, 91, 100};
        
        for (int target : testCases) {
            int result = jumpSearch(sortedArray, target);
            if (result != -1) {
                System.out.println("Element " + target + " found at index: " + result);
            } else {
                System.out.println("Element " + target + " not found in the array.");
            }
        }
    }
}
```

## **Advantages of Jump Search**
✅ Faster than linear search (`O(n)`).  
✅ Requires **less computation** than binary search for **large arrays**.  
✅ Works well when **random access to elements is possible**.

## **Limitations**
❌ Requires a **sorted array**.  
❌ Not as fast as **binary search** (`O(log n)`).  
❌ Choosing the **optimal step size** is crucial for performance.

## **Applications**
- Searching in **large sorted datasets**.
- Used in **index-based** search structures.
- Applied in **block-based searching mechanisms**.

## **Conclusion**
Jump Search is a useful algorithm that balances speed and simplicity. It is particularly effective when **binary search is not feasible** due to **expensive midpoint calculations**. However, it should only be used when the dataset is **sorted** and random access is possible. 🚀