# Trapping Rain Water

## Problem Statement

Given an array `height[]` representing the elevation map where the width of each bar is `1`, compute how much rainwater can be trapped after raining.

---

## Intuition

The water trapped at any index depends on the shorter of the tallest bars to its left and right.

Instead of precomputing the tallest bars for every index, use two pointers along with the maximum heights seen so far from both ends.

- If the left bar is shorter, the trapped water depends only on `maxLeft`.
- Otherwise, it depends only on `maxRight`.

This allows the answer to be computed in a single traversal.

---

## Approach

1. Initialize two pointers:
   - `left` at the beginning.
   - `right` at the end.
2. Maintain:
   - `maxLeft` = tallest bar seen from the left.
   - `maxRight` = tallest bar seen from the right.
3. While `left <= right`:
   - If `height[left] <= height[right]`:
     - Update `maxLeft` if needed.
     - Otherwise, add `maxLeft - height[left]` to the answer.
     - Move `left` forward.
   - Otherwise:
     - Update `maxRight` if needed.
     - Otherwise, add `maxRight - height[right]` to the answer.
     - Move `right` backward.
4. Return the total trapped water.

---

## Dry Run

**Input:**

```text
height = [4, 2, 0, 3, 2, 5]
```

Processing:

```text
Left = 4, Right = 5
maxLeft = 4

Move left:
2 → Water = 4 - 2 = 2
0 → Water = 4 - 0 = 4
3 → Water = 4 - 3 = 1
2 → Water = 4 - 2 = 2

Total = 2 + 4 + 1 + 2 = 9
```

Output:

```text
9
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Key Takeaway

By always processing the pointer at the **smaller height**, we know that side is the limiting boundary for trapped water. Tracking only the maximum height seen from each side eliminates the need for extra arrays, resulting in an efficient `O(n)` time and `O(1)` space solution.
