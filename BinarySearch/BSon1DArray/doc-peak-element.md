# Find Peak Element

## Approach

A peak element is an element that is greater than its adjacent elements. Since the array may contain multiple peaks, we only need to find any one of them.

Using Binary Search, we compare the middle element with its next element:

- If `nums[mid] > nums[mid + 1]`, we are on a decreasing slope, so a peak must exist on the left side (including `mid`).
- If `nums[mid] < nums[mid + 1]`, we are on an increasing slope, so a peak must exist on the right side.

By repeatedly reducing the search space, we eventually reach a peak element.

## Algorithm

1. Initialize `start = 0` and `end = nums.length - 1`.
2. While `start < end`:
   - Calculate `mid`.
   - If `nums[mid] > nums[mid + 1]`, move `end` to `mid`.
   - Otherwise, move `start` to `mid + 1`.
3. When `start == end`, a peak element has been found.
4. Return `start`.

## Example

**Input**

```java
nums = [1, 2, 3, 1]
```

**Execution**

- start = 0, end = 3
- mid = 1 → nums[1] = 2
- 2 < 3, move right

- start = 2, end = 3
- mid = 2 → nums[2] = 3
- 3 > 1, move left

- start = end = 2

**Output**

```java
2
```

The element at index `2` is `3`, which is greater than its adjacent elements.

## Time Complexity

- **O(log n)**

The search space is halved in every iteration.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
