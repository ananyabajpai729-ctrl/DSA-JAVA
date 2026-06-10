# Search a 2D Matrix II

## Approach

The matrix is sorted in two ways:

1. Each row is sorted from left to right.
2. Each column is sorted from top to bottom.

A useful observation is that the top-right element helps eliminate either an entire row or an entire column in one step.

- If the current element is equal to the target, we have found the answer.
- If the current element is smaller than the target, all elements in that row to the left are also smaller, so we move down to the next row.
- If the current element is greater than the target, all elements below it in the same column are also greater, so we move left.

This allows us to efficiently search the matrix without checking every element.

## Algorithm

1. Start from the top-right corner of the matrix.
2. While the current position is within the matrix:
   - If the current element equals the target, return `true`.
   - If the current element is smaller than the target, move down.
   - If the current element is greater than the target, move left.
3. If the search goes out of bounds, return `false`.

## Example

**Input**

```java
matrix = [
  [1, 4, 7, 11, 15],
  [2, 5, 8, 12, 19],
  [3, 6, 9, 16, 22],
  [10,13,14,17,24],
  [18,21,23,26,30]
]

target = 5
```

**Execution**

- Start at `15`
- 15 > 5 → move left
- 11 > 5 → move left
- 7 > 5 → move left
- 4 < 5 → move down
- 5 == 5 → target found

**Output**

```java
true
```

## Time Complexity

- **O(n + m)**

Where:

- `n` = number of rows
- `m` = number of columns

In each step, either the row index increases or the column index decreases.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
