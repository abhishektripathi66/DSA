Bucket Sort

Description

Bucket Sort is a distribution-based sorting algorithm. It divides the input range
into multiple "buckets", distributes elements into these buckets, sorts each bucket
individually, and finally concatenates the buckets to form the sorted output.

This algorithm works best when the input values are uniformly distributed across
a known range.

Steps:

1. Find the minimum and maximum values in the array.
2. Choose a bucket size and compute the number of buckets:
   bucketCount = ((max - min) / bucketSize) + 1
3. Create empty buckets (typically lists).
4. Distribute each element into its bucket:
   bucketIndex = (value - min) / bucketSize
5. Sort each bucket (commonly using insertion sort or a built-in stable sort).
6. Concatenate all buckets in order back into the array.

Time Complexity:

Best Case: O(n)
{this occurs when the elements are uniformly distributed so each bucket is small,
and the total cost of sorting buckets is minimal}

Average Case: O(n + Σ sort(bucket_i)) ≈ O(n)
{often close to linear when distribution is near-uniform and buckets remain small}

Worst Case: O(n^2)
{this happens if most or all elements fall into a single bucket, which makes the
per-bucket sorting behave like sorting an array of size n}

Space Complexity:

O(n + k)
{extra space is used for the buckets; total elements stored across buckets is n,
and k is the number of buckets}

Advantages:

✅ Can approach linear time for uniformly distributed data.
✅ Simple concept and easy to implement.
✅ Works well for bounded numeric ranges.

Limitations:

❌ Requires extra memory (not in-place).
❌ Performance depends heavily on bucket size and input distribution.
❌ Worst-case can degrade to O(n^2).

Use Cases:

Numeric data where the range is known or can be estimated.
Data that is roughly uniformly distributed (normalized scores, measurements, etc.).

Notes:

Choosing bucketSize is important:

- Too small -> many buckets (higher memory overhead).
- Too large -> fewer buckets (buckets become large, sorting becomes slower).

This repository implementation supports negative values by shifting indices using min.
