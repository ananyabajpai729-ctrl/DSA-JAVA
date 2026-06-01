# Search Insert Position

## Approach

The array is already sorted, so Binary Search can be used to find the target efficiently.

Instead of only searching for the target, we keep track of the first position where an element is greater than or equal to the target. This position will either:

- Be the index of the target if it exists.
- Be the correct insertion position if the target is not present.

A variable `ans` is initialized to `nums.length`, which handles the case where the target is greater than all elements in the array.

## Algorithm

1. Initialize `left = 0` and `right = nums.length - 1`.
2. Initialize `ans = nums.length`.
3. Find the middle element.
4. If `nums[mid] >= target`:
   - Update `ans = mid`.
   - Search in the left half to find an earlier valid position.
5. Otherwise, search in the right half.
6. Continue until the search space becomes empty.
7. Return `ans`.

## Example

**Input**

```java
nums = [1, 3, 5, 6]
target = 5
```

**Execution**

- mid = 1 → nums[1] = 3
- 3 < 5, search right half

- mid = 2 → nums[2] = 5
- nums[2] >= 5, update ans = 2
- Search left half for an earlier valid position

- Search ends

**Output**

```java
2
```

## Time Complexity

- **O(log n)**

The search space is halved in every iteration.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
