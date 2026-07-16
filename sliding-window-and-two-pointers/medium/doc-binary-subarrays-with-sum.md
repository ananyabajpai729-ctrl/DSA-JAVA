# Binary Subarrays With Sum

## Problem Statement

Given a binary array `nums` and an integer `goal`, return the number of non-empty subarrays whose sum is exactly equal to `goal`.

---

## Intuition

Counting subarrays with **exactly** a given sum is difficult using a sliding window because there may be multiple valid starting positions for the same ending index.

Instead, we use a clever observation:

```text
Subarrays with sum = goal
=
Subarrays with sum ≤ goal
-
Subarrays with sum ≤ (goal - 1)
```

So, rather than counting exact sums directly, we write a helper function that counts the number of subarrays having sum **at most** a given value.

Since the array contains only `0`s and `1`s, expanding the window only increases (or keeps) the sum, making the sliding window approach valid.

---

## Approach

- Create a helper function that counts the number of subarrays with sum at most `goal`.
- Maintain a sliding window using two pointers.
- Expand the window by moving the `right` pointer and updating the current sum.
- If the sum exceeds `goal`, shrink the window from the left until it becomes valid again.
- For every valid window ending at `right`, all starting positions from `left` to `right` form valid subarrays.
- Therefore, add:

```text
right - left + 1
```

to the answer.

Finally,

```text
Answer = AtMost(goal) - AtMost(goal - 1)
```

---

## Dry Run

**Input:**

```text
nums = [1,0,1,0,1]
goal = 2
```

Count:

```text
AtMost(2) = 14

AtMost(1) = 10
```

Therefore,

```text
Exactly(2) = 14 - 10 = 4
```

The valid subarrays are:

```text
[1,0,1]
[1,0,1,0]
[0,1,0,1]
[1,0,1]
```

Output:

```text
4
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Key Takeaway

This problem introduces a very useful sliding window trick:

```text
Exactly(K) = AtMost(K) - AtMost(K - 1)
```

Instead of counting subarrays with an exact property directly, count those satisfying an easier **"at most"** condition and subtract the overlap.

This technique works well for binary arrays and many sliding window problems involving **exact counts**, where maintaining the exact condition during window expansion is difficult but maintaining an upper bound is easy.
