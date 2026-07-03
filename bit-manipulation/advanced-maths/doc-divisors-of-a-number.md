# Find All Divisors of a Number

## Problem Statement

Given an integer `n`, return all of its divisors in sorted order.

---

## Intuition

A divisor always comes in a pair.

If `i` divides `n`, then `n / i` is also a divisor.

Instead of checking every number from `1` to `n`, we only need to iterate up to `√n`. For every divisor found, its paired divisor can be obtained in constant time.

---

## Approach

1. Iterate from `1` to `√n`.
2. If `i` divides `n`:
   - Add `i`.
   - If `i` is not the square root of `n`, also add `n / i`.
3. Sort the collected divisors.
4. Convert the list to an array and return it.

---

## Dry Run

**Input:**

```text
n = 36
```

Iteration:

```text
i = 1 → 1, 36
i = 2 → 2, 18
i = 3 → 3, 12
i = 4 → 4, 9
i = 5 → Not a divisor
i = 6 → 6 (only once since 6 × 6 = 36)
```

Collected:

```text
[1, 36, 2, 18, 3, 12, 4, 9, 6]
```

After sorting:

```text
[1, 2, 3, 4, 6, 9, 12, 18, 36]
```

---

## Time Complexity

- **Finding divisors:** `O(√n)`
- **Sorting:** `O(k log k)`, where `k` is the number of divisors.
- **Space:** `O(k)`

---

## Key Takeaway

Every divisor greater than `√n` has a corresponding divisor smaller than `√n`. By checking only up to the square root and adding divisor pairs together, the search space is reduced from `O(n)` to `O(√n)`.
