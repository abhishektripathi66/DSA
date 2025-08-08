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

Best Case: O(n log n){ this occurs only if the pivot is in the center and the elements are divided equally}

Average Case: O(n log n){
    this happens generally when we have n/10 elements on one side and 9n/10 elements on the other side.
}

Worst Case: O(n^2) (when the pivot is consistently the smallest/largest element){ this happens only if there are smallest or largest elements in the one part of the pivot and a single elemnt in the other part, so it keeps on dividing, i.e, always the array has n-1 elements}{
    for example take input from 0 to 4., so the sorting will be like
    01234
    0 and 1234
    0 1 234
    0 1 2 34
    0 1 2 3 4
}

Space Complexity:

O(log n) due to the recursive call stack.

Advantages:

✅ Faster in practice for most datasets.
✅ In-place sorting, requires little additional memory.(if we consider the array then its in place because we are not mostly using the temp array in case Lomuto or Hoare partition, where as when we consider the stack recursive calls then it takes the extra space).
✅ Cache-friendly.
✅ Tail Recursive.

Limitations:

❌ Not stable (does not preserve the order of equal elements).❌ Worst-case complexity can degrade to O(n^2).

Use Cases:

Large datasets where space optimization is important.

General-purpose efficient sorting.

Parition is key Function( Naive, Lomuto, Hoare)

on an Average Hoare's partition is 3 times faster than the Lomuto Parititon but both are not stable 
we use the Naives approach to handle the stability

if the array is sorted
i. both lomuto and hoare turns into worst.
ii. Random Function is used to generate the random pivot, and that random pivot is swapped with the start element for the Hoare's partition and is swapped with the end element for the Lomuto's Algorithm

Tail Call Elimination in QuickSort 
tail recusive function if we are not doing anything after the recursive call. we add a go to function if its the last statement and then we go back to parent function, so there is no need to keep track of it.
we can do Tail call elminitation for the large part.