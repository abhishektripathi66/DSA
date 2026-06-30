1. Bucket Sort is a distribution-based sorting algorithm.
2. Average time complexity is O(n + k) when data is uniformly distributed.
3. Not an in-place sorting algorithm.
4. Works best for floating-point numbers.
5. Performance degrades when data is poorly distributed.
Overview

Bucket Sort is a distribution-based sorting algoritm that works by breaking up an array into a number of buckets. Then, each bucket is sorted individually using a diffenet sorting algorithm (here it was Insertion Sort). 
Bucket sort can also achieve a linear time compexity when the input data is already uniformly distributed across a range, making it more efficient in some cases as compared to Merge Sort or Quick Sort.

How It Works

Initialize an array of empty buckets
Distribute the elements in the input array into a bucket based on its value
Sort each bucket individually
Concatenate the sorted buckets back into the original array

Complexity Analysis
Average Time Complexity: O(n+k), where n is the size of the array and k is the number of buckets
Worst Case time Complexity: O(n^2) when all data is distributed into a single bucket

Space Complexity: O(n+k)

When to Use
Bucket Sort is useful when the input data is uniformly distributed, when memory isn't a strict constraint, and when sorting large sets of categorized data
## Bucket Sort(Java)

### Description

Bucket Sort is a **distribution-based sorting algorithm**.  
It distributes elements into multiple buckets, sorts each bucket individually,
and then combines all buckets to produce the final sorted array.
It works best when the input data is **uniformly distributed**.

---

## How the Algorithm Works (Step-by-Step)

Given an input array `arr` of size `n`:

1. **Find the maximum element** in the array.  
   This step takes `O(n)` time and is used to normalize elements so that they map safely
   to valid bucket indices.

2. **Create `n` empty buckets** using `ArrayList<Float>`.  
   Creating buckets takes `O(n)` space.

3. **Distribute elements into buckets** using the formula:

   ```java
   bucketIndex = (int)((arr[i] / max) * (n - 1));

  
 ## How the Algorithm Works  (for Range Based with Doubly Linked List)
 
1. **Find the maximum element** in the array.  
   This step takes `O(n)` time and is used to normalize elements so that they map safely
   to valid bucket indices.

2. **Calculate number of buckets**  
   ```java
   no_of_buckets = ceil(sqrt(n));

3. **Compute range of each bucket** using the formula:

   ```java
   range = ceil((max - min + 1) / no_of_buckets);
4. **Create buckets**Initialize an array of Doubly Linked Lists.

5. **Distribute elements into buckets**

   ```java
   bucketIndex = (arr[i] - min) / range;
6. **Sort each bucket**Uses Selection Sort on each linked list.

7. **Merge buckets**Combine all buckets back into the original array.
---

### Time Complexity:

- **Best Case:** O(n) (when elements are uniformly distributed)
- **Average Case:** O(n + k)
- **Worst Case:** O(n²) (when all elements fall into one bucket)

---

### Space Complexity:

- **O(n + k)**

---

### Advantages:

✅ Efficient for uniformly distributed data.  
✅ Useful for floating-point numbers.  
✅ Non-comparison-based sorting algorithm.

Doubly Linked List algorithms :
Supports negative numbers
Uses Doubly Linked List for flexible bucket storage
Simple and easy to understand implementation
Good performance for evenly distributed dat
---

### Limitations:

❌ Requires extra memory for buckets.  
❌ Performance degrades with non-uniform data.  
❌ Does not directly support negative numbers.

Doubly Linked List algorithms :
Performance depends on data distribution
Uses Selection Sort, which is inefficient for large datasets
Not suitable for floating-point numbers (without modification)
---

### Use Cases:

- Sorting floating-point values.  
- When data is evenly distributed over a range.  
- Educational purposes.
