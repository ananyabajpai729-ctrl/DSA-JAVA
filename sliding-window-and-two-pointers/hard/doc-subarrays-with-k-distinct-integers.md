# Subarrays with K Different Integers

## Problem Statement

Given an integer array `nums` and an integer `k`, return the number of subarrays that contain **exactly `k` distinct integers**.

---

## Intuition

Counting subarrays with **exactly `k` distinct elements** directly is quite difficult.

Instead, we use one of the most useful sliding window tricks:

```text
Exactly(k) = AtMost(k) - AtMost(k - 1)
```

If we can count the number of subarrays containing **at most `k` distinct integers**, then subtracting those containing **at most `k - 1` distinct integers** leaves us with only the subarrays containing exactly `k` distinct integers.

A sliding window is perfect for counting the "at most" version because we can easily maintain a valid window using a frequency map.

---

## Approach

- Write a helper function that counts subarrays having **at most `k` distinct integers**.
- Maintain a sliding window using two pointers.
- Use a `HashMap` to store the frequency of each integer inside the current window.
- Expand the window by moving the `right` pointer.
- If the number of distinct integers exceeds `k`:
  - Shrink the window from the left.
  - Decrease frequencies.
  - Remove an element from the map once its frequency becomes zero.
- For every valid window ending at `right`, all starting positions from `left` to `right` form valid subarrays.

So we add:

```text
right - left + 1
```

to the answer.

Finally,

```text
Answer = AtMost(k) - AtMost(k - 1)
```

---

## Dry Run

**Input:**

```text
nums = [1,2,1,2,3]
k = 2
```

Calculation:

```text
AtMost(2) = 12

AtMost(1) = 5
```

Therefore,

```text
Exactly(2) = 12 - 5 = 7
```

The valid subarrays are:

```text
[1,2]
[2,1]
[1,2]
[1,2,1]
[2,1,2]
[1,2,1,2]
[2,3]
```

Output:

```text
7
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(k)`

The frequency map stores at most `k + 1` distinct integers before the window is shrunk.

---

## Key Takeaway

This problem is one of the most important applications of the **At Most K** sliding window technique.

Whenever you see:

- Exactly `K` distinct elements
- Exactly `K` odd numbers
- Exactly `K` ones
- Exactly `K` occurrences

ask yourself whether you can rewrite it as:

```text
Exactly(K) = AtMost(K) - AtMost(K - 1)
```

If the **At Most** version can be solved using a sliding window, you've usually found the optimal solution.

This same pattern appears in:

- Binary Subarrays With Sum
- Count Number of Nice Subarrays
- Subarrays with K Different Integers

Recognizing this transformation is one of the biggest milestones in mastering sliding window problems.
