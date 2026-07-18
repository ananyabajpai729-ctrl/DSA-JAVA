# Two Sum II - Input Array Is Sorted

## Problem Statement

Given a **1-indexed** sorted array `numbers` and an integer `target`, find two numbers whose sum equals `target`.

Return their **1-based indices**.

It is guaranteed that exactly one solution exists.

---

## Intuition

Since the array is already sorted, we don't need a `HashMap`.

Instead, place one pointer at the beginning and another at the end.

- If the current sum is too small, we need a larger value, so move the **left pointer** forward.
- If the current sum is too large, we need a smaller value, so move the **right pointer** backward.
- If the sum equals the target, we've found the answer.

The sorted order guarantees that moving pointers in this way never skips the correct solution.

---

## Approach

- Initialize:
  - `left = 0`
  - `right = n - 1`
- While `left < right`:
  - Compute the current sum.
  - If the sum equals the target, return the **1-based indices**.
  - If the sum is greater than the target, move the right pointer left.
  - Otherwise, move the left pointer right.
- Since the problem guarantees a solution, the loop will always find it.

---

## Dry Run

**Input:**

```text
numbers = [2,7,11,15]
target = 9
```

Processing:

```text
left = 0 (2)
right = 3 (15)

Sum = 17

Too large

Move right

----------------

left = 0 (2)
right = 2 (11)

Sum = 13

Too large

Move right

----------------

left = 0 (2)
right = 1 (7)

Sum = 9

Target found
```

Output:

```text
[1,2]
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Key Takeaway

This is one of the most fundamental **Two Pointer** problems.

Whenever you have:

- A **sorted array**
- A target value
- The task is to find a pair satisfying a condition

think about placing one pointer at each end of the array.

The sorted order lets you eliminate impossible pairs efficiently:

- If the sum is **too small**, increase it by moving the left pointer.
- If the sum is **too large**, decrease it by moving the right pointer.

This simple idea reduces the solution from `O(n²)` to `O(n)` while using constant extra space.
