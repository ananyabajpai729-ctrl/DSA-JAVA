# Row with Maximum 1s

## Approach

Since each row of the matrix is sorted, all `0`s appear before the `1`s.

Instead of counting the number of `1`s by traversing every row, we use Binary Search to find the first occurrence of `1` in each row.

Once the first `1` is found, the number of `1`s in that row can be calculated as:

```text
number of 1s = totalColumns - firstOneIndex
```

We keep track of the row having the maximum count of `1`s and return its index.

## Algorithm

1. Initialize:
   - `count_max = 0`
   - `ans = -1`
2. For each row:
   - Find the first occurrence of `1` using Binary Search.
   - Calculate the number of `1`s in the row.
3. If the current row has more `1`s than the previous maximum:
   - Update `count_max`.
   - Store the row index.
4. After processing all rows, return the stored index.

## Finding the First 1

Using Binary Search:

- If `arr[mid] == 1`, store the index and continue searching in the left half.
- If `arr[mid] == 0`, search in the right half.

This gives the leftmost occurrence of `1`.

## Example

**Input**

```java
mat = {
    {0, 0, 1, 1},
    {0, 1, 1, 1},
    {0, 0, 0, 1}
}
```

**Execution**

| Row | First 1 Index | Number of 1s |
|------|------|------|
| 0 | 2 | 2 |
| 1 | 1 | 3 |
| 2 | 3 | 1 |

The maximum number of `1`s is found in row `1`.

**Output**

```java
1
```

## Time Complexity

- **O(n × log m)**

Where:

- `n` = number of rows
- `m` = number of columns

A Binary Search is performed on each row.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
