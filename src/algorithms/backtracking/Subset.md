
# Subsets (Unique Subsets)

## 💡 Idea
Generate all unique subsets from an array that may contain duplicates using an **iterative approach**.

## ⚙️ Approach
1. Sort the array to handle duplicates easily.  
2. For each number:
   - Copy all existing subsets.
   - Add the current number to each copy.
   - If it's a duplicate, start from the last new subsets only.

## ⏱️ Complexity
- **Time:** O(N × 2^N)  
- **Space:** O(N × 2^N)

## 🧩 Example
Input: `[1,2,2]`  
Output: `[[], [1], [2], [1,2], [2,2], [1,2,2]]`;
