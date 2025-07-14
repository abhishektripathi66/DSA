Merge Sort

Description

Merge Sort is a stable, divide-and-conquer algorithm that divides the array into halves, recursively sorts each half,
and then merges them back in sorted order.

Steps:

Divide the unsorted list into two approximately equal halves.

Recursively sort both sublists.

Merge the sorted sublists into a single sorted list.

Time Complexity:

Best Case: O(n log n)

Average Case: O(n log n)

Worst Case: O(n log n)

Space Complexity:

O(n) due to temporary arrays used during merging.

Advantages:

✅ Stable sort (preserves the order of equal elements).✅ Consistent O(n log n) performance.✅ Excellent for sorting linked
lists.

Limitations:

❌ Requires additional space proportional to the array size.❌ Slower for small datasets due to overhead of recursive
calls and merging.

Use Cases:

Sorting linked lists.

Datasets requiring stable sorting.

Large datasets where guaranteed O(n log n) performance is needed.