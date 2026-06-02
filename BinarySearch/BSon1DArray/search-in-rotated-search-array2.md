# Search in Rotated Sorted Array II

## Approach

The array is originally sorted but has been rotated, and it may contain duplicate elements.

To search efficiently, we use a modified Binary Search. At every step, one half of the array is guaranteed to be sorted. We determine which half is sorted and check whether the target lies within that range.

The tricky part is handling duplicates. When `nums[start]`, `nums[mid]`, and `nums[end]` are all equal, we cannot determine which half is sorted. In this case, we shrink the search space by moving both pointers inward.

## Algorithm

1. Initialize `start` and `end`.
2. Find the middle index.
3. If `nums[mid] == target`, return `true`.
4. If `nums[start] == nums[mid] == nums[end]`:
   - Increment `start`.
   - Decrement `end`.
5. Otherwise, determine which half is sorted:
   - If the left half is sorted:
     - Check if the target lies in that range.
     - Search the appropriate half.
   - Else, the right half is sorted:
     - Check if the target lies in that range.
     - Search the appropriate half.
6. If the search space becomes empty, return `false`.

## Example

**Input**

```java
nums = [2,5,6,0,0,1,2]
target = 0
```

**Execution**

- mid = 3 → nums[3] = 0
- Target found

**Output**

```java
true
```

## Time Complexity

- **Average Case:** `O(log n)`
- **Worst Case:** `O(n)`

The worst case occurs when many duplicate elements force us to shrink the search space one element at a time.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
