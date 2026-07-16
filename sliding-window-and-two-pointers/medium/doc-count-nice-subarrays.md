# Count Number of Nice Subarrays

## Problem Statement

Given an integer array `nums` and an integer `k`, return the number of contiguous subarrays that contain exactly `k` odd numbers.

---

## Intuition

Directly counting subarrays with **exactly `k` odd numbers** is not straightforward.

Instead, we use the same trick as in **Binary Subarrays With Sum**:

```text
Exactly(k) = AtMost(k) - AtMost(k - 1)
```

So, we first count all subarrays containing **at most `k` odd numbers**, then subtract those containing **at most `k - 1` odd numbers**. The remaining subarrays are precisely the ones having exactly `k` odd numbers.

The sliding window works because the number of odd elements inside the window changes predictably as we expand or shrink it.

---

## Approach

- Create a helper function that counts the number of subarrays containing at most `k` odd numbers.
- Maintain a sliding window using `left` and `right`.
- Whenever an odd number enters the window, increment `oddCount`.
- If `oddCount` becomes greater than `k`, move the `left` pointer until the window becomes valid again.
- Every valid window ending at `right` contributes:

```text
right - left + 1
```

valid subarrays.

- Finally, compute:

```text
Answer = AtMost(k) - AtMost(k - 1)
```

---

## Dry Run

**Input:**

```text
nums = [1,1,2,1,1]
k = 3
```

Calculation:

```text
AtMost(3) = 14

AtMost(2) = 12
```

Therefore,

```text
Exactly(3) = 14 - 12 = 2
```

The valid subarrays are:

```text
[1,1,2,1]
[1,2,1,1]
```

Output:

```text
2
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Key Takeaway

This problem reinforces one of the most important sliding window patterns:

```text
Exactly(K) = AtMost(K) - AtMost(K - 1)
```

Whenever a problem asks for subarrays with **exactly** a certain number of occurrences (odd numbers, distinct elements, binary sum, etc.), think about whether it is easier to count subarrays satisfying an **"at most"** condition and subtract the overlap.

This trick appears frequently in sliding window problems and is worth remembering.
