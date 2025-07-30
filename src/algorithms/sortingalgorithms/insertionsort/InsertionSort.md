Insertion Sort

Description

Insertion Sort builds the final sorted array one item at a time by comparing and inserting each new element into its
correct position among the already sorted elements.

Steps:

Start from the second element.

Compare it with previous elements.

Shift larger elements one position ahead.

Insert the current element at its correct position.

Time Complexity:

Best Case: O(n) (when already sorted) example [10,20,30,50]

Average Case: O(n^2)

Worst Case: O(n^2) (if array is sorted in reverse order) example[50,30,20,10]

Space Complexity:

O(1)

Advantages:

✅ Simple to implement.
✅ Efficient for small and nearly sorted datasets.✅ Stable sort (maintains relative order of equal
elements).
✅ In Place and Stable (in place means if it doesnt use any auxiliary space or array)

Limitations:

❌ Inefficient on large unsorted datasets.

Use Cases:

Small or nearly sorted datasets.

Online sorting where elements arrive over time.