# Sum of Subarray Ranges

## Problem Statement

Given an integer array `nums`, return the sum of the range of every subarray, where the range of a subarray is defined as:

```text
Maximum Element − Minimum Element
```

---

## Intuition

Instead of calculating the maximum and minimum for every subarray individually, compute the total contribution of each element as:

- a **maximum** in all subarrays where it is the largest element.
- a **minimum** in all subarrays where it is the smallest element.

The final answer is:

```text
Sum of Contributions as Maximum
-
Sum of Contributions as Minimum
```

---

## Approach

1. Compute the contribution of every element as the **minimum** using:
   - Previous Smaller or Equal Element (PSEE)
   - Next Smaller Element (NSE)

2. Compute the contribution of every element as the **maximum** using:
   - Previous Greater or Equal Element (PGEE)
   - Next Greater Element (NGE)

3. For each index:
   - Number of subarrays where it is the minimum:
     ```text
     (i - PSEE) × (NSE - i)
     ```
   - Number of subarrays where it is the maximum:
     ```text
     (i - PGEE) × (NGE - i)
     ```

4. Multiply the frequency by the element value to get its contribution.

5. Return:

```text
Sum(Max Contributions) - Sum(Min Contributions)
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Key Takeaway

The range of every subarray can be computed efficiently by treating each element independently. Monotonic stacks help find the nearest greater and smaller boundaries in linear time, allowing us to count how many subarrays consider an element as their minimum or maximum instead of examining every subarray individually.
