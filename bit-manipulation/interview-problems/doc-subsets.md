# Subsets (Bit Manipulation)

## Problem Statement

Given an integer array `nums` containing unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets.

---

## Intuition

Every subset can be represented using a binary number.

For an array of size `n`, there are `2ⁿ` possible subsets. Each bit in a binary number determines whether the corresponding element is included in the subset.

- Bit = `1` → Include the element.
- Bit = `0` → Exclude the element.

---

## Approach

1. Compute the total number of subsets as `2ⁿ`.
2. Iterate from `0` to `2ⁿ - 1`.
3. Treat each number as a bitmask.
4. For every bit that is set, include the corresponding array element in the current subset.
5. Add the constructed subset to the answer.

---

## Dry Run

**Input:**

```text
nums = [1, 2, 3]
```

Bitmask representation:

```text
000 → []
001 → [1]
010 → [2]
011 → [1, 2]
100 → [3]
101 → [1, 3]
110 → [2, 3]
111 → [1, 2, 3]
```

Output:

```text
[
  [],
  [1],
  [2],
  [1,2],
  [3],
  [1,3],
  [2,3],
  [1,2,3]
]
```

---

## Time Complexity

- **Time:** `O(n × 2ⁿ)`
- **Space:** `O(1)` (excluding the output list).

---

## Key Takeaway

A bitmask provides a compact way to represent a subset. Since there are `2ⁿ` binary numbers with `n` bits, iterating through all bitmasks naturally generates every possible subset exactly once.
