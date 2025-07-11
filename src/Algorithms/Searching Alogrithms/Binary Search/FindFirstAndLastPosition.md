# Find First and Last Position of Element in Sorted Array

## Problem Description

Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given target value. If target is not found in the array, return `[-1, -1]`.

## Examples

```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Input: nums = [1,1,1,1,1], target = 1
Output: [0,4]
```

## Key Concepts

### 1. Binary Search Variations

This problem teaches two important variations of binary search:

- **Leftmost Binary Search**: Find the first occurrence of an element
- **Rightmost Binary Search**: Find the last occurrence of an element

### 2. Why Two Binary Searches?

When an element appears multiple times in a sorted array, a standard binary search might find any occurrence, not necessarily the first or last one. We need specialized versions to find the boundaries.

## Algorithm Approach

### Method 1: Two Binary Searches (Recommended)

1. **Find First Position (Leftmost Binary Search)**

   - Use binary search to find target
   - When target is found, continue searching left half
   - Keep track of the leftmost position where target was found

2. **Find Last Position (Rightmost Binary Search)**
   - Use binary search to find target
   - When target is found, continue searching right half
   - Keep track of the rightmost position where target was found

### Method 2: Single Binary Search + Linear Expansion

1. Use standard binary search to find any occurrence
2. Expand leftward to find first position
3. Expand rightward to find last position

## Time and Space Complexity

- **Time Complexity**: O(log n) - Two binary searches
- **Space Complexity**: O(1) - Constant extra space

## Step-by-Step Walkthrough

Let's trace through the example: `nums = [5,7,7,8,8,10], target = 8`

### Finding First Position (8):

```
Initial: left=0, right=5, mid=2
nums[2] = 7 < 8 → left = 3

left=3, right=5, mid=4
nums[4] = 8 == 8 → firstPosition = 4, right = 3

left=3, right=3, mid=3
nums[3] = 8 == 8 → firstPosition = 3, right = 2

left=3, right=2 → loop ends
Result: firstPosition = 3
```

### Finding Last Position (8):

```
Initial: left=0, right=5, mid=2
nums[2] = 7 < 8 → left = 3

left=3, right=5, mid=4
nums[4] = 8 == 8 → lastPosition = 4, left = 5

left=5, right=5, mid=5
nums[5] = 10 > 8 → right = 4

left=5, right=4 → loop ends
Result: lastPosition = 4
```

## Common Mistakes to Avoid

1. **Not handling edge cases**: Empty array, null array
2. **Integer overflow**: Use `left + (right - left) / 2` instead of `(left + right) / 2`
3. **Incorrect loop condition**: Should be `left <= right` not `left < right`
4. **Forgetting to update position**: Must update position when target is found

## Learning Points

### 1. Binary Search Variations

- **Standard**: Find any occurrence
- **Leftmost**: Find first occurrence
- **Rightmost**: Find last occurrence

### 2. When to Use Each Variation

- **Standard**: When you just need to know if element exists
- **Leftmost**: When you need the first occurrence (like this problem)
- **Rightmost**: When you need the last occurrence (like this problem)

### 3. Pattern Recognition

This pattern appears in many problems:

- Find insertion position
- Find range of elements
- Count occurrences
- Find closest element

## Related Problems

1. **Search Insert Position** (LeetCode 35)
2. **Find Peak Element** (LeetCode 162)
3. **Search in Rotated Sorted Array** (LeetCode 33)
4. **Find Minimum in Rotated Sorted Array** (LeetCode 153)

## Implementation Tips

1. **Always handle edge cases first**
2. **Use descriptive variable names** (firstPosition, lastPosition)
3. **Add comments explaining the logic**
4. **Test with various cases**: single element, all same elements, target not found

## Practice Questions

1. How would you modify this to find the count of occurrences?
2. What if the array has duplicates but not necessarily the target?
3. How would you handle the case where target appears only once?

## Advanced Variations

1. **Find K-th occurrence**: Modify to find the k-th occurrence of target
2. **Find closest element**: Find the element closest to target
3. **Find range in rotated array**: Apply this to rotated sorted arrays

This problem is excellent for understanding binary search variations and is commonly asked in technical interviews!
