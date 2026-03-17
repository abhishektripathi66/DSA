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
