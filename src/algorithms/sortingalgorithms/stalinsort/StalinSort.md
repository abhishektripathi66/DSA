# Stalin Sort

## Description
Stalin Sort is a humorous and unconventional sorting algorithm.  
Instead of rearranging elements, it **removes any element that violates the non-decreasing order**.

Only elements that maintain the sorted order are allowed to remain — the rest are simply discarded.

> This algorithm is primarily used for **educational and illustrative purposes**.

---

## Algorithm Steps
1. Start with the first element and keep it.
2. Traverse the array from left to right.
3. For each element:
   - If it is **greater than or equal to** the last kept element, keep it.
   - Otherwise, remove it.
4. Continue until the end of the array.

---

## Time Complexity
| Case | Complexity |
|-----|------------|
| Best Case | O(n) |
| Average Case | O(n) |
| Worst Case | O(n) |

---

## Space Complexity
- **O(n)** (to store the remaining elements)

---

## Advantages
- ✅ Extremely simple to understand and implement  
- ✅ Runs in linear time  
- ✅ No complex data structures required  
- ✅ Useful for demonstrating greedy decision-making  

---

## Limitations
- ❌ Does **not actually sort** the array  
- ❌ Loses data by removing elements  
- ❌ Not suitable for real-world sorting tasks  
- ❌ Not stable in the traditional sorting sense  

---

## Use Cases
- Educational demonstrations of algorithm behavior  
- Humor / novelty algorithms in open-source projects  
- Teaching greedy strategies and constraints  
- Algorithm discussions and comparisons  

---

## Example
**Input:**  
