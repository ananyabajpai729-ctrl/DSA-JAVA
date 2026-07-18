# Maximum Average Subarray I

## Problem Statement

Given an integer array `nums` and an integer `k`, find the contiguous subarray of length **exactly `k`** that has the maximum average, and return that average.

---

## Intuition

Since every valid subarray must contain **exactly `k` elements**, we don't need to consider windows of different sizes.

Instead, maintain a sliding window of size `k`:

- Add the new element entering the window.
- If the window grows larger than `k`, remove the leftmost element.
- Whenever the window size is exactly `k`, compare its sum with the best sum seen so far.

Finally, divide the maximum sum by `k` to obtain the maximum average.

Since `k` is fixed, maximizing the average is the same as maximizing the sum.

---

## Approach

- Initialize two pointers representing the window.
- Maintain the sum of the current window.
- Expand the window by moving the `right` pointer.
- If the window size exceeds `k`:
  - Remove the leftmost element from the sum.
  - Move the `left` pointer forward.
- Whenever the window size becomes exactly `k`:
  - Update the maximum sum.
- Return the maximum sum divided by `k`.

---

## Dry Run

**Input:**

```text
nums = [1,12,-5,-6,50,3]
k = 4
```

Processing:

```text
Window = [1,12,-5,-6]

Sum = 2

Maximum Sum = 2

----------------

Slide the window

Remove 1

Add 50

Window = [12,-5,-6,50]

Sum = 51

Maximum Sum = 51

----------------

Slide again

Remove 12

Add 3

Window = [-5,-6,50,3]

Sum = 42

Maximum Sum remains 51
```

Average:

```text
51 / 4 = 12.75
```

Output:

```text
12.75
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Key Takeaway

This is one of the most straightforward **Fixed-Size Sliding Window** problems.

Whenever a problem asks about a subarray or substring of **exactly `k` elements**, think of maintaining a window whose size never exceeds `k`.

The template is simple:

1. Expand the window.
2. If it becomes larger than `k`, remove the leftmost element.
3. Once the window size is exactly `k`, use it to update the answer.

Unlike variable-size sliding window problems, there is no need to repeatedly shrink the window based on a condition—the window size itself determines when to slide.
