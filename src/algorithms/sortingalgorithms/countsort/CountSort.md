## Counting Sort

### 1. Complexity
* **Worst Case:** $O(n + k)$.
* While generally considered linear, if the range of elements ($k$) is $O(n^2)$, the complexity effectively becomes **$O(n^2)$**.

### 2. Memory Efficiency
* Performs **minimum memory writes** to the original array.
* Unlike comparison sorts that move elements repeatedly, Counting Sort calculates the final position and writes each value back directly.

### 3. Classification
* **In-Place:** The basic version uses the original array for output (requires $O(k)$ auxiliary space for the frequency count).
* **Not Stable:** The simple iterative implementation does not preserve the relative order of duplicate elements.

