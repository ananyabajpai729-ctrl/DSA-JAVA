# Search a 2D Matrix

## Approach

The matrix has two important properties:

1. Each row is sorted in ascending order.
2. The first element of each row is greater than the last element of the previous row.

Because of these properties, the entire matrix can be treated as a single sorted 1D array.

Instead of performing Binary Search on each row separately, we apply Binary Search directly on the virtual 1D array and convert the index back to its corresponding row and column.

For a given index `mid`:

```text
row = mid / numberOfColumns
col = mid % numberOfColumns
```

This allows us to access the correct element in the matrix while maintaining the efficiency of Binary Search.

## Algorithm

1. Treat the matrix as a sorted 1D array of size `rows × columns`.
2. Initialize:
   - `start = 0`
   - `end = rows × columns - 1`
3. While `start <= end`:
   - Calculate `mid`.
   - Convert `mid` into row and column indices.
   - Compare the element with the target.
4. If the target is found, return `true`.
5. If the current element is greater than the target, search the left half.
6. Otherwise, search the right half.
7. If the search ends without finding the target, return `false`.

## Example

**Input**

```java
matrix = [
  [1, 3, 5, 7],
  [10, 11, 16, 20],
  [23, 30, 34, 60]
]

target = 3
```

**Execution**

- Total elements = 12
- mid = 5 → matrix[1][1] = 11
- 11 > 3, search left half

- mid = 2 → matrix[0][2] = 5
- 5 > 3, search left half

- mid = 1 → matrix[0][1] = 3
- Target found

**Output**

```java
true
```

## Time Complexity

- **O(log(m × n))**

Where:

- `m` = number of rows
- `n` = number of columns

Binary Search is performed on all elements of the matrix.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
