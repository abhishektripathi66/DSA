# Overview of the Fibonacci Search (FS) Code in Java 💻

## What's Happening in the Code? ❓

The provided Java code implements Fibonacci Search, an efficient search algorithm for sorted arrays. Let me walk you
through the details!

### 1. **Setting the Initial Indices** 📌

First, we initialize three Fibonacci numbers:

* `fib2` → The second-to-last Fibonacci number before the largest one (`fib = 13`), so `fib2 = 8`.
* `fib1` → The number before `fib2`, so `fib1 = 5`.
* `fib` → The largest Fibonacci number found in the first step (`fib = 13`).

```
int fib2 = 0;  // (fib(n-2))
int fib1 = 1;  // (fib(n-1))
int fib = fib2 + fib1;  // (fib(n))
```

We also define `offset = -1`, which helps adjust the indices correctly.

```
int offset = -1;
```

### 2. Preparing the Fibonacci Numbers 🔢

Next, we find the smallest **Fibonacci number** that is greater than or equal to the size of the array. This helps us
determine how to divide the array during the search. Example: If the array has `n = 10` elements, we use the Fibonacci
number `13` because it is the smallest number larger than `10`.

```java
// Finding the smallest Fibonacci number greater than or equal to n
while(fib<n){
fib2 =fib1;
fib1 =fib;
fib =fib2 +fib1;
}
```

### 3. **Choosing the First Search Point** 🎯

The first index to check is **(offset + fib2)** because `fib2` represents the best initial position based on the
Fibonacci numbers.

```java
while (fib > 1) {
    int i = Math.min(offset + fib2, n - 1);
  
    //the remaning code ...
```

### 4. **Comparing Values** 🔍

At this point, we check three possibilities:

* **If the value at the index matches the target** ✅ → We’ve found the element, success!
* **If the value is less than the target** ⬆️ → The target must be on the **right** side. We update `offset` and reduce
  the Fibonacci numbers.
* **If the value is greater than the target** ⬇️ → The target must be on the **left** side. We reduce `fib` to search a
  smaller portion of the array.

```java
    if (arr[i] < target) {  // The element is on the righ
        fib = fib1;
        fib1 = fib2;
        fib2 = fib - fib1;
        offset = i;
    } else if (arr[i] > target) {  // The element is on the left
        fib = fib2;
        fib1 -= fib2;
        fib2 = fib - fib1;
    } else {  // Found the target
        return i;
    }
}
```

### 5. **Shrinking the Range with Fibonacci** 🔄

If the element is not found, we **update the Fibonacci numbers** to focus on the correct part of the array:

* `fib = fib1` OR `fib = fib2`
* `fib1 = fib2` OR `fib1 -= fib2`
* `fib2 = fib - fib1`

This maintains the structure of the search and progressively reduces the range, similar to binary search, but based on
Fibonacci steps.

### 6. **Repeating the Process Until Found** 🔁

We continue checking indices and shrinking the Fibonacci numbers until:

1. The target is found 🎉
2. The search range becomes `1` and no more elements are left to check ❌

### **7. Special Case: The Last Element** 🏁

If only one element remains in the array and it matches the target, we return its index.
Otherwise, it means the target  **is not in the array** , and we return `-1` to indicate  **not found** .

```java
if (fib1 == 1 && arr[offset + 1] == target) {
    return offset + 1;
}

return -1;  // Element not found

```

### 8. **Main Method** 💪

Finally, the `main` method demonstrates the Fibonacci Search by creating a sample sorted array and searching for a
specific target value. This allows us to see the algorithm in action and verify its correctness.

1. **We define a sorted array**  → The algorithm works only on sorted arrays, so we create one.
2. **We set a target value**  → This is the number we are trying to find.
3. **We call `fibonacciSearch`**  → The function is executed to locate the target.
4. **We print the result**  → If found, we display its index; otherwise, we indicate it wasn’t found.

```java
public static void main(String[] args) {
    int[] arr = {1, 3, 7, 10, 14, 20, 25, 30, 35, 40}; // Sorted array
    int target = 20; // The value to search for

    int result = fibonacciSearch(arr, target); // Perform Fibonacci Search

    if (result != -1) {
        System.out.println("Element found at index: " + result);
    } else {
        System.out.println("Element not found.");
    }
}

```

This `main` method ensures that the Fibonacci Search runs correctly and provides a simple test case for verification.

## What Happens When You Run It? ⏳

1. The sorted array is created with predefined values.
2. The Fibonacci Search function is called with the target value.
3. The algorithm generates Fibonacci numbers until the closest one greater than or equal to the array length is found.
4. The search starts from the smallest index possible, updating Fibonacci numbers as needed.
5. The algorithm moves through the array, comparing elements and adjusting the search range accordingly.
6. If the target is found, the function returns its index.
7. If the target is not in the array, the function returns `-1`, indicating the value was not found.
8. The result is printed in the console, showing whether the number was located and at which index.

### Example Output: ✅

If you run the code, you might see an output like:

```
Element found at index 6
```

This output shows the index of the searched value.

## Fun Fact: 🧐

Despite being inspired by the famous Fibonacci sequence, it's not used much in practice! The idea of using Fibonacci
numbers to divide the array is mathematically elegant, but in most cases, binary search is more efficient and easier to
implement.
But calm down! It's still useful in cases where memory access times are unequal, such as in hierarchical memory
systems (for example, reading from old magnetic tapes), where access to closer elements is less costly.

### Created by

José Neto
