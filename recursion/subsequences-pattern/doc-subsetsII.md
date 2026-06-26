# Subsets II

## Problem Statement

Given an integer array `nums` that may contain duplicate elements, return all possible **unique subsets** (the power set).

The solution must not contain duplicate subsets.

---

## Intuition

If the array contains duplicate values, generating all subsets directly can produce repeated subsets.

To avoid this:

- Sort the array so that duplicate elements become adjacent.
- While iterating, skip duplicate elements at the same recursion level.

This ensures that every unique subset is generated exactly once.

---

## Approach

1. Sort the input array.
2. Add the current subset to the answer.
3. Iterate through the remaining elements.
4. Skip duplicate values at the same recursion level.
5. Include the current element and recurse for the remaining elements.
6. Backtrack by removing the last added element.

---

## Dry Run

**Input:**

```text
nums = [1,2,2]
```

After sorting:

```text
[1,2,2]
```

Generated subsets:

```text
[]
[1]
[1,2]
[1,2,2]
[2]
[2,2]
```

Notice that the second `2` is skipped when it would generate a duplicate subset.

---

## Time Complexity

- **Time:** `O(2^N)` (worst case)
- **Space:** `O(N)` (recursion stack, excluding output)

---

## Key Takeaway

When duplicate elements are present:

- **Sort the array first.**
- **Skip duplicate elements at the same recursion level** using:

```java
if (i > index && nums[i] == nums[i - 1]) continue;
```

This is a classic **Backtracking + Choice from Loop** problem where duplicate handling is the main trick.
