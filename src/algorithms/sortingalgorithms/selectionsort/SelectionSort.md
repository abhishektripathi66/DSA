Selection Sort

Description

Selection Sort repeatedly selects the minimum element from the unsorted portion and moves it to the beginning.

Steps:

Find the minimum element in the unsorted part.

Swap it with the first unsorted element.

Repeat until sorted.

Time Complexity:

Best, Average, Worst Case: O(n^2)

Space Complexity:

O(1)

Advantages:

✅ Simple and easy to implement.
✅ Makes minimum number of swaps.
✅ Does less memory writes compared to QuickSort, Merge Sort, Insertion Sort, etc But cycle sort is optimal in terms of memory writes.
✅ Basic idea for Heap Sort

Limitations:

❌ Inefficient on large datasets.

❌ Not stable

Use Cases:

Small datasets.

Situations where memory write operations are expensive.