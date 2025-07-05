Quick Sort

Description

Quick Sort is a divide-and-conquer algorithm that selects a pivot element and partitions the array into two sub-arrays:

Elements less than the pivot

Elements greater than the pivot

It then recursively applies the same strategy to the sub-arrays.

Steps:

Choose a pivot (typically the last element).

Partition the array:

Place elements less than the pivot to the left.

Place elements greater than the pivot to the right.

Recursively apply the above steps to the left and right sub-arrays.

Time Complexity:

Best Case: O(n log n)

Average Case: O(n log n)

Worst Case: O(n^2) (when the pivot is consistently the smallest/largest element)

Space Complexity:

O(log n) due to the recursive call stack.

Advantages:

✅ Faster in practice for most datasets.✅ In-place sorting, requires little additional memory.✅ Cache-friendly.

Limitations:

❌ Not stable (does not preserve the order of equal elements).❌ Worst-case complexity can degrade to O(n^2).

Use Cases:

Large datasets where space optimization is important.

General-purpose efficient sorting.

