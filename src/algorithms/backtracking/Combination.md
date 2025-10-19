
# Combination Sum III — LeetCode 216

### 🧩 Problem Intuition
We need to find all unique combinations of **k** numbers from 1 to 9 that sum up to a given number **n**.  
Each number can be used **only once**, and the order of numbers doesn’t matter.  

The key idea is to **explore all possible combinations** of numbers while keeping track of:
- The current list of chosen numbers  
- The current sum of those numbers  
- The next number to try (to avoid duplicates)

---

### ⚙️ Approach — Backtracking
The approach is based on **backtracking**, where we:
1. Start from number `1` and move forward till `9`.  
2. At each step, decide whether to **include** a number in the current combination.  
3. If the combination reaches size `k`, we check if its sum equals `n`.  
   - If yes → we store that combination.  
   - If not → backtrack (undo the last choice).  
4. Continue exploring the next possible numbers.

This ensures all valid combinations are generated without repetition.

---

### 🧠 Key Points
- Backtracking explores every possible subset efficiently.  
- We only go forward (`i + 1`) to avoid reusing previous numbers.  
- The recursion automatically handles the addition and removal of elements.

---

### ⏱️ Complexity
- **Time Complexity:** `O(k * C(9, k))`  
- **Space Complexity:** `O(k)` for recursion depth.

---

### ✅ Summary
Used **backtracking** to systematically build and test combinations until the valid ones that sum to `n` are found.

