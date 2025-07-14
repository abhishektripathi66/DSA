Interpolation Search Algorithm

Interpolation Search is an improved variant of Binary Search used to find the position of a target element within a
sorted and uniformly distributed array. It estimates the likely position of the target using the value of the key being
searched, which can make it faster than Binary Search for certain datasets.

How Interpolation Search Works

Calculate the estimated position:

pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low])

If arr[pos] matches the target, return pos.

If arr[pos] is less than the target, search in the upper sub-array (low = pos + 1).

If arr[pos] is greater than the target, search in the lower sub-array (high = pos - 1).

Repeat until the element is found or the search space becomes invalid.

Time Complexity

Best Case: O(1)

Average Case: O(log log n) (when data is uniformly distributed)

Worst Case: O(n) (when data is non-uniform)

Prerequisites

✅ Array must be sorted in ascending order.

✅ Data should be uniformly distributed for optimal performance.

Implementation

Java Code

public class InterpolationSearch {
/**

* Performs Interpolation Search on a sorted, uniformly distributed array.
* @param arr The sorted array to search in
* @param target The element to find
* @return The index of the element if found, otherwise -1
  */
  public static int interpolationSearch(int[] arr, int target) {
  int low = 0, high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (low == high) {
                if (arr[low] == target) {
                    return low;
                }
                return -1;
            }

            int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[pos] == target) {
                return pos;
            }

            if (arr[pos] < target) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }

        return -1;
  }

  public static void main(String[] args) {
  int[] sortedArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
  int[] testCases = {40, 90, 15, 100, 5};

        for (int target : testCases) {
            int result = interpolationSearch(sortedArray, target);
            if (result != -1) {
                System.out.println("Element " + target + " found at index: " + result);
            } else {
                System.out.println("Element " + target + " not found in the array.");
            }
        }
  }
  }

Advantages of Interpolation Search

✅ Faster than Binary Search for uniformly distributed data (O(log log n)).✅ Efficient for large, sorted numeric
datasets.✅ Simple implementation with low overhead.

Limitations

❌ Requires sorted data.❌ Performance degrades to O(n) if data is not uniformly distributed.❌ May encounter division by
zero if arr[high] == arr[low] without safeguards.

Applications

Large, sorted, uniformly distributed numeric datasets.

Index-based retrieval systems.

Search-heavy systems where data distribution is known.

Conclusion

Interpolation Search is a highly efficient searching algorithm under the right conditions (sorted and uniformly
distributed data), often outperforming Binary Search for such cases. It combines speed with simplicity, making it an
excellent choice for large datasets where Binary Search may not be optimal. 🚀