# Find First and Last Position of Element in Sorted Array

## Approach

Since the array is sorted, Binary Search can be used to locate the target efficiently.

Instead of finding just one occurrence, we perform Binary Search twice:

1. Find the first occurrence of the target.
2. Find the last occurrence of the target.

Whenever the target is found:

- For the first occurrence, store the index and continue searching in the left half.
- For the last occurrence, store the index and continue searching in the right half.

This ensures that we find the extreme positions of the target in the array.

## Algorithm

### Finding the First Occurrence

1. Perform Binary Search.
2. If `nums[mid] == target`:
   - Store `mid` as a potential answer.
   - Continue searching in the left half.
3. If `nums[mid] < target`, search the right half.
4. Otherwise, search the left half.

### Finding the Last Occurrence

1. Perform Binary Search.
2. If `nums[mid] == target`:
   - Store `mid` as a potential answer.
   - Continue searching in the right half.
3. If `nums[mid] < target`, search the right half.
4. Otherwise, search the left half.

If the target is not found, return `[-1, -1]`.

## Example

**Input**

```java
nums = [5, 7, 7, 8, 8, 10]
target = 8
```

**Execution**

### First Occurrence

- Find `8` at index 4
- Continue searching left
- Find `8` at index 3
- No earlier occurrence exists

First position = 3

### Last Occurrence

- Find `8` at index 4
- Continue searching right
- No later occurrence exists

Last position = 4

**Output**

```java
[3, 4]
```

## Time Complexity

- **O(log n)** for finding the first occurrence.
- **O(log n)** for finding the last occurrence.

Overall: **O(log n)**

## Space Complexity

- **O(1)**

Only a few extra variables are used.
