# Binary Search (Recursive)

## Approach

Since the array is sorted, we can use Binary Search to find the target efficiently.

At each step, we calculate the middle index and compare the middle element with the target.

* If they are equal, return the index.
* If the target is greater, search in the right half.
* If the target is smaller, search in the left half.

This process continues recursively until the target is found or the search space becomes empty.

## Algorithm

1. Calculate the middle index of the current range.
2. If `nums[mid] == target`, return `mid`.
3. If `nums[mid] < target`, recursively search the right half.
4. Otherwise, recursively search the left half.
5. If `start > end`, return `-1`.

## Example

**Input**

```java
nums = [1, 3, 5, 7, 9]
target = 7
```

**Execution**

* mid = 2 → nums[2] = 5
* 7 > 5, search right half
* mid = 3 → nums[3] = 7
* Target found at index 3

**Output**

```java
3
```

## Time Complexity

* **O(log n)**

The search space is reduced to half in every recursive call.

## Space Complexity

* **O(log n)**

Recursive calls use the function call stack.
