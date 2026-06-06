# Kth Missing Positive Number

## Approach

Since the array is sorted, we can use Binary Search instead of checking every positive number one by one.

For any index `i`, the number of missing positive integers before `arr[i]` is:

```text
arr[i] - (i + 1)
```

This formula works because if no numbers were missing, the element at index `i` would be exactly `i + 1`.

Using Binary Search, we find the last position where the count of missing numbers is still less than `k`. Once the search is complete, we can directly calculate the answer.

## Algorithm

1. Initialize `start = 0` and `end = arr.length - 1`.
2. While `start <= end`:
   - Find the middle index.
   - Calculate the number of missing elements before `arr[mid]`:
     
     ```text
     missing = arr[mid] - (mid + 1)
     ```
     
   - If `missing < k`, search in the right half.
   - Otherwise, search in the left half.
3. After the loop, `end` points to the last index where the missing count is less than `k`.
4. Return:

```text
k + end + 1
```

## Example

**Input**

```java
arr = [2, 3, 4, 7, 11]
k = 5
```

**Execution**

| Index | Value | Missing Count |
|--------|--------|--------------|
| 0 | 2 | 1 |
| 1 | 3 | 1 |
| 2 | 4 | 1 |
| 3 | 7 | 3 |
| 4 | 11 | 6 |

- The first position where missing count becomes at least `5` is index `4`.
- Therefore, `end = 3`.

Answer:

```text
k + end + 1
= 5 + 3 + 1
= 9
```

**Output**

```java
9
```

The missing positive numbers are:

```text
1, 5, 6, 8, 9, 10, ...
```

The 5th missing positive number is `9`.

## Time Complexity

- **O(log n)**

Binary Search is used on the sorted array.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
