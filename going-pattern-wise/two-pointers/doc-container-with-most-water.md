# Container With Most Water

## Problem Statement

Given an array `height`, where each element represents the height of a vertical line, find two lines that together with the x-axis form a container capable of holding the maximum amount of water.

Return the maximum area of water the container can store.

---

## Intuition

A brute-force solution would try every possible pair of lines, calculate the area, and return the maximum. This takes `O(n²)` time.

Since the width is initially at its maximum, we start with one pointer at each end of the array.

For every pair of lines:

```text
Area = Width × Minimum Height
```

The width always decreases as the pointers move, so the only way to potentially obtain a larger area is by increasing the **shorter height**.

This leads to the key observation:

- Moving the **taller** line cannot increase the area because the shorter line still limits the container.
- Therefore, always move the pointer pointing to the **shorter** line.

---

## Approach

- Initialize:
  - `left = 0`
  - `right = n - 1`
- While `left < right`:
  - Compute the current width.
  - Find the smaller of the two heights.
  - Calculate the area.
  - Update the maximum area.
  - Move the pointer pointing to the shorter line.
- Continue until the two pointers meet.

---

## Dry Run

**Input:**

```text
height = [1,8,6,2,5,4,8,3,7]
```

Processing:

```text
left = 0 (1)
right = 8 (7)

Width = 8

Area = 8 × 1 = 8

Move left (shorter line)

----------------

left = 1 (8)
right = 8 (7)

Width = 7

Area = 7 × 7 = 49

Maximum = 49

Move right (shorter line)

Continue...
```

Final Answer:

```text
49
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Key Takeaway

This is one of the most important **Two Pointer** problems because the movement of the pointers is driven by a mathematical observation.

The area is calculated as:

```text
Area = Width × Minimum Height
```

Moving the taller line is never beneficial because:

- The width decreases.
- The shorter line still limits the height.

So, the only chance of finding a larger area is to replace the **shorter** line with a potentially taller one.

Whenever you encounter problems involving **two ends of a sorted or ordered structure** where pointer movement can be justified logically, think about the **Two Pointer** technique instead of checking every pair.
