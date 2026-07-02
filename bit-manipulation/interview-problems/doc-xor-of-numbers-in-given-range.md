# XOR of Numbers in a Given Range

## Problem Statement

Given two integers `L` and `R`, find the XOR of all numbers in the range `[L, R]`.

---

## Intuition

Instead of XOR-ing every number from `L` to `R`, we use the fact that:

```text
XOR(1...R) ^ XOR(1...(L-1)) = XOR(L...R)
```

This works because the common prefix (`1` to `L-1`) cancels out due to the property:

```text
x ^ x = 0
```

The XOR from `1` to `N` follows a repeating pattern based on `N % 4`, allowing it to be computed in constant time.

---

## Approach

1. Create a helper function to compute `XOR(1...N)` using the pattern:
   - `N % 4 == 0` → `N`
   - `N % 4 == 1` → `1`
   - `N % 4 == 2` → `N + 1`
   - `N % 4 == 3` → `0`
2. Compute:
   ```text
   XOR(L...R) = XOR(1...R) ^ XOR(1...(L-1))
   ```
3. Return the result.

---

## Dry Run

**Input:**

```text
L = 3
R = 6
```

Using the helper:

```text
XOR(1...6) = 7
XOR(1...2) = 3
```

Answer:

```text
7 ^ 3 = 4
```

Verification:

```text
3 ^ 4 ^ 5 ^ 6 = 4
```

---

## Time Complexity

- **Time:** `O(1)`
- **Space:** `O(1)`

---

## Key Takeaway

Instead of iterating through the range, compute the XOR from `1` to `N` in constant time using the repeating `N % 4` pattern. The required range XOR is then obtained by XOR-ing the prefix results.
