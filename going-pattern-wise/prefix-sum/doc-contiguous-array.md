# Contiguous Array

## Problem Statement

Given a binary array `nums`, return the length of the longest contiguous subarray containing an equal number of `0`s and `1`s.

---

## Intuition

A subarray has an equal number of `0`s and `1`s if their contributions cancel each other out.

To make this easy to track:

- Treat every `1` as `+1`.
- Treat every `0` as `-1`.

Now, instead of counting zeros and ones separately, maintain a running sum called `count`.

If the same `count` appears again at a later index, it means the total change between those two indices is zero. In other words, the subarray between them contains an equal number of `0`s and `1`s.

To quickly find previous occurrences of a `count`, store its first occurrence in a `HashMap`.

---

## Approach

- Initialize `count = 0`.
- Create a `HashMap` to store the first index where each `count` occurs.
- Insert:

```text
count = 0  →  index = -1
```

This handles subarrays starting from index `0`.

- Traverse the array:
  - Add `1` to `count` if the current element is `1`.
  - Subtract `1` if the current element is `0`.
- If the current `count` has been seen before:
  - The subarray between the previous index and the current index has equal numbers of `0`s and `1`s.
  - Update the maximum length.
- Otherwise, store the current index as the first occurrence of that `count`.

---

## Dry Run

**Input:**

```text
nums = [0,1,0]
```

Processing:

```text
Start:

count = 0
Map = {0 : -1}

Index 0 → 0

count = -1

Store (-1, 0)

Index 1 → 1

count = 0

Already seen at index -1

Length = 1 - (-1) = 2

Index 2 → 0

count = -1

Already seen at index 0

Length = 2 - 0 = 2
```

Maximum length:

```text
2
```

Output:

```text
2
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

The map stores the first occurrence of each unique prefix count.

---

## Key Takeaway

This problem is a beautiful application of the **Prefix Sum + HashMap** pattern.

Instead of directly counting zeros and ones, transform the problem into tracking a running balance:

```text
1 → +1

0 → -1
```

Whenever the same running balance appears again, the sum between those two indices is zero, which means the subarray contains an equal number of `0`s and `1`s.

A useful clue for this pattern is when a problem asks for the **longest subarray where two quantities are balanced or equal**. Converting the quantities into `+1` and `-1` often turns it into a prefix sum problem.
