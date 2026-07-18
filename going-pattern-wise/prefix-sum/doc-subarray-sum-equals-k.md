# Subarray Sum Equals K

## Problem Statement

Given an integer array `nums` and an integer `k`, return the total number of contiguous subarrays whose sum equals `k`.

---

## Intuition

A brute-force solution would try every possible subarray, resulting in an `O(n²)` solution.

Instead, think in terms of **Prefix Sums**.

Suppose the running sum up to the current index is:

```text
prefixSum = sum
```

If there exists a previous prefix sum equal to:

```text
sum - k
```

then the elements between those two prefix sums must add up to `k`.

So, instead of checking every subarray, we simply keep track of how many times each prefix sum has occurred.

Whenever we encounter `sum - k`, every previous occurrence contributes one valid subarray.

---

## Approach

- Initialize:
  - `sum = 0`
  - `count = 0`
  - A `HashMap` to store the frequency of each prefix sum.
- Insert:

```text
0 → 1
```

This accounts for subarrays starting from index `0`.

- Traverse the array:
  - Update the running prefix sum.
  - Check whether `sum - k` exists in the map.
  - If it does, add its frequency to the answer.
  - Store the current prefix sum by increasing its frequency.
- Return the total count.

---

## Dry Run

**Input:**

```text
nums = [1,1,1]
k = 2
```

Processing:

```text
Start:

Map = {0 : 1}

sum = 0

Index 0

sum = 1

Need sum - k = -1

Not found

Store 1

Map = {0:1, 1:1}

----------------

Index 1

sum = 2

Need sum - k = 0

Found once

count = 1

Store 2

----------------

Index 2

sum = 3

Need sum - k = 1

Found once

count = 2
```

Output:

```text
2
```

The valid subarrays are:

```text
[1,1]
[1,1]
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

The map stores the frequency of prefix sums encountered so far.

---

## Key Takeaway

This problem introduces one of the most important **Prefix Sum + HashMap** patterns.

The key observation is:

```text
Current Prefix Sum - Previous Prefix Sum = k
```

Rearranging gives:

```text
Previous Prefix Sum = Current Prefix Sum - k
```

So instead of searching through all previous indices, we simply ask:

> **"How many times have I already seen `sum - k`?"**

Every occurrence represents one valid subarray ending at the current index.

This pattern appears frequently in problems involving:

- Subarray sums
- Target differences
- Prefix balances
- Counting subarrays satisfying a condition

Recognizing the equation

```text
prefixSum - target
```

is often the biggest clue that a **Prefix Sum + HashMap** solution exists.
