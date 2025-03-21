# Linked List Sublist Checker

## Overview
This project checks whether one linked list (`A`) is a sublist of another linked list (`B`). It compares nodes from `A` against nodes in `B` and returns a result indicating whether `A` appears as a contiguous sequence within `B`.

---

## Functions Breakdown

### `isSublist()`
- **Purpose:** Determines whether `A` is a sublist of `B`.
- **How it works:**
  1. Compares each node of `B` with the head of `A`.
  2. If they match, continues comparing the next nodes of `A` and `B`.
  3. If `A` fully matches, returns `True`; otherwise, moves `B`'s pointer ahead and repeats.

### Helper Functions
- **`createLinkedList()`**: Builds a linked list from an array.
- **`printList()`**: Prints the linked list in a clean, readable format.

---

## Main Function Workflow

1. **Defines two linked lists:**
   - List `A` from an array
   - List `B` from an array
2. **Checks if `A` is a sublist of `B`.**
3. **Prints the result.**

---

## Example Output
```bash
List A: 1 -> 2 -> 3 -> null
List B: 4 -> 1 -> 2 -> 3 -> 5 -> null
Is A a sublist of B? Yes
