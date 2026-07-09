# Next Smaller Element

## Problem Statement

Given an array of integers, find the **Next Smaller Element (NSE)** for every element.

The Next Smaller Element of an element is the first smaller element present on its right. If no such element exists, return `-1` for that position.

---

## Intuition

Traverse the array from **right to left** while maintaining a **monotonic increasing stack**.

- Elements greater than or equal to the current element cannot be its Next Smaller Element, so they are removed.
- After removing them, the top of the stack (if it exists) is the nearest smaller element on the right.
- Push the current element onto the stack for future comparisons.

---

## Approach

1. Traverse the array from right to left.
2. Remove all elements from the stack that are greater than or equal to the current element.
3. If the stack is empty, the answer is `-1`; otherwise, the top of the stack is the Next Smaller Element.
4. Push the current element onto the stack.
5. Repeat for every element.

---

## Dry Run

**Input:**

```text
arr = [4, 8, 5, 2, 25]
```

Processing from right to left:

```text
25 → Stack: []         NSE = -1
      Push 25

2  → Pop 25
      Stack: []        NSE = -1
      Push 2

5  → Stack: [2]        NSE = 2
      Push 5

8  → Stack: [2, 5]     NSE = 5
      Push 8

4  → Pop 8
      Pop 5
      Stack: [2]       NSE = 2
      Push 4
```

Output:

```text
[2, 5, 2, -1, -1]
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Key Takeaway

A **monotonic increasing stack** keeps only useful candidates for the Next Smaller Element. Since each element is pushed and popped at most once, the algorithm runs in linear time.
