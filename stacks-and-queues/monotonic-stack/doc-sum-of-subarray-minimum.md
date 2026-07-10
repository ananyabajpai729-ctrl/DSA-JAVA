# Sum of Subarray Minimums

## Problem Statement

Given an integer array `arr`, return the sum of the minimum value of every possible subarray. Since the answer can be very large, return it modulo `10^9 + 7`.

---

## Intuition

Instead of finding the minimum for every subarray separately, calculate **how many subarrays consider each element as their minimum**.

For every element:

- Find the **Previous Smaller or Equal Element (PSEE)**.
- Find the **Next Smaller Element (NSE)**.

These boundaries determine all subarrays in which the current element is the minimum.

---

## Approach

1. Compute the **Previous Smaller or Equal Element (PSEE)** for every index using a monotonic increasing stack.
2. Compute the **Next Smaller Element (NSE)** using another monotonic increasing stack.
3. For each index:
   - `left = i - PSEE[i]`
   - `right = NSE[i] - i`
4. The number of subarrays in which `arr[i]` is the minimum is:
   ```text
   left × right
   ```
5. Add the contribution of the current element:
   ```text
   arr[i] × left × right
   ```
6. Return the total sum modulo `10^9 + 7`.

---

## Dry Run

**Input:**

```text
arr = [3, 1, 2, 4]
```

Computed boundaries:

```text
PSEE = [-1, -1, 1, 2]
NSE  = [1, 4, 4, 4]
```

Contributions:

```text
3 → left = 1, right = 1
Contribution = 3 × 1 × 1 = 3

1 → left = 2, right = 3
Contribution = 1 × 2 × 3 = 6

2 → left = 1, right = 2
Contribution = 2 × 1 × 2 = 4

4 → left = 1, right = 1
Contribution = 4 × 1 × 1 = 4
```

Total:

```text
17
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Key Takeaway

The key insight is to compute each element's **contribution** instead of evaluating every subarray. Monotonic increasing stacks efficiently find the nearest smaller boundaries, allowing the number of subarrays where an element is the minimum to be calculated in linear time.

**Note:** To handle duplicate values correctly:
- **PSEE** uses **Previous Smaller or Equal**.
- **NSE** uses **Next Smaller**.

This asymmetric tie-breaking ensures every subarray is counted exactly once.
