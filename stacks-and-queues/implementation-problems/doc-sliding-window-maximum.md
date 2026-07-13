# Sliding Window Maximum

## Problem Statement

Given an integer array `nums` and an integer `k`, return an array containing the maximum element in every sliding window of size `k`.

---

## Intuition

Instead of scanning every window to find its maximum, maintain a **monotonic decreasing deque** of indices.

- The front of the deque always stores the index of the maximum element for the current window.
- Smaller elements at the back are removed because they can never become the maximum while a larger element is present.

---

## Approach

1. Traverse the array from left to right.
2. Remove indices from the front that are outside the current window.
3. Remove indices from the back whose values are smaller than the current element.
4. Add the current index to the back of the deque.
5. Once the first window is formed (`i >= k - 1`), the front of the deque represents the maximum element of that window.
6. Repeat for all windows.

---

## Dry Run

**Input:**

```text
nums = [1, 3, -1, -3, 5, 3, 6, 7]
k = 3
```

Processing:

```text
Window [1, 3, -1]      → Max = 3
Window [3, -1, -3]     → Max = 3
Window [-1, -3, 5]     → Max = 5
Window [-3, 5, 3]      → Max = 5
Window [5, 3, 6]       → Max = 6
Window [3, 6, 7]       → Max = 7
```

Output:

```text
[3, 3, 5, 5, 6, 7]
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(k)`

---

## Key Takeaway

A **monotonic decreasing deque** stores only useful candidates for the maximum. Each index is inserted and removed at most once, allowing the maximum of every sliding window to be found in linear time.
