# Find Minimum in Rotated Sorted Array

## Approach

The array is sorted in ascending order and then rotated at some pivot. Even after rotation, one part of the array remains sorted.

Using Binary Search, we can locate the minimum element without scanning the entire array.

At each step:

- If `nums[mid] <= nums[end]`, the minimum lies in the left half (including `mid`).
- Otherwise, the minimum lies in the right half.

The search continues until `start` and `end` point to the same element, which is the minimum value in the array.

## Algorithm

1. Initialize `start = 0` and `end = nums.length - 1`.
2. While `start < end`:
   - Calculate `mid`.
   - If `nums[mid] <= nums[end]`, move `end` to `mid`.
   - Otherwise, move `start` to `mid + 1`.
3. When the loop ends, `start` points to the minimum element.
4. Return `nums[start]`.

## Example

**Input**

```java
nums = [4,5,6,7,0,1,2]
```

**Execution**

- start = 0, end = 6
- mid = 3 → nums[3] = 7
- 7 > 2, minimum lies in the right half

- start = 4, end = 6
- mid = 5 → nums[5] = 1
- 1 <= 2, minimum lies in the left half (including mid)

- start = 4, end = 5
- mid = 4 → nums[4] = 0
- 0 <= 1, move end to 4

- start = end = 4

**Output**

```java
0
```

## Time Complexity

- **O(log n)**

The search space is halved in every iteration.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
