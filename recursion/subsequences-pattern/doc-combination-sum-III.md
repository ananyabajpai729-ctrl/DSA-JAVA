# Combination Sum III

## Problem Statement

Find all possible combinations of `k` distinct numbers from `1` to `9` such that their sum is equal to `n`.

Each number can be used **at most once**, and no duplicate combinations are allowed.

---

## Intuition

We try each number from `1` to `9` and decide whether to include it in the current combination.

Since each number can only be used once, the next recursive call starts from the next number (`i + 1`).

Whenever the remaining sum becomes `0` and exactly `k` numbers have been chosen, we have found a valid combination.

---

## Approach

1. Start with the number `1`.
2. Iterate from the current number to `9`.
3. Add the current number to the combination.
4. Recurse with:
   - Remaining sum reduced.
   - Next number (`i + 1`).
5. Backtrack by removing the last chosen number.
6. Stop recursion if:
   - Remaining sum becomes non-positive.
   - More than `k` numbers have been chosen.

---

## Dry Run

**Input:**

```text
k = 3
n = 7
```

Possible exploration:

```text
[1]
 ├── [1,2]
 │     └── [1,2,4] ✓
 ├── [1,3]
 └── ...
```

Output:

```text
[
  [1,2,4]
]
```

---

## Time Complexity

- **Time:** Exponential (backtracking)
- **Space:** `O(k)` recursion stack (excluding output)

---

## Key Takeaway

This is a **Backtracking + Choice from Loop** problem.

The important observations are:

- Numbers are chosen only once (`i + 1`).
- Stop exploring when the remaining sum is no longer positive.
- A combination is valid only if both the **sum** and the **size (`k`)** conditions are satisfied.
