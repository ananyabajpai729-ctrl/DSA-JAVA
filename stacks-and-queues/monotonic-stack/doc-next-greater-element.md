# Next Greater Element

## Problem Statement

Given an array of integers, find the **Next Greater Element (NGE)** for every element.

The Next Greater Element of an element is the first greater element present on its right. If no such element exists, return `-1` for that position.

---

## Intuition

While traversing the array from right to left, maintain a **monotonic decreasing stack**.

- Elements smaller than or equal to the current element cannot be its Next Greater Element, so they are removed.
- After removing them, the top of the stack (if it exists) is the nearest greater element on the right.
- Finally, push the current element onto the stack for future comparisons.

---

## Approach

1. Traverse the array from right to left.
2. Remove all elements from the stack that are less than or equal to the current element.
3. If the stack is empty, the answer is `-1`; otherwise, the top of the stack is the Next Greater Element.
4. Push the current element onto the stack.
5. Repeat for every element.

---

## Dry Run

**Input:**

```text
arr = [4, 5, 2, 10]
```

Processing from right to left:

```text
10 → Stack: []          NGE = -1
      Push 10

2  → Stack: [10]        NGE = 10
      Push 2

5  → Pop 2
      Stack: [10]       NGE = 10
      Push 5

4  → Stack: [10, 5]     NGE = 5
      Push 4
```

Output:

```text
[5, 10, 10, -1]
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Key Takeaway

A **monotonic decreasing stack** ensures that each element is pushed and popped at most once. By removing all smaller or equal elements before processing the current element, the stack's top always represents the nearest greater element on the right.
