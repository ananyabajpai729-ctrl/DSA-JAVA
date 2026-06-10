# Find a Peak Element II

## Approach

A peak element in a 2D matrix is an element that is strictly greater than its adjacent neighbors.

Instead of searching every cell, we use Binary Search on the columns.

For a given middle column:

1. Find the row containing the maximum element in that column.
2. Compare this element with its left and right neighbors.
3. If it is greater than both neighbors, it is a peak.
4. If the left neighbor is greater, a peak must exist in the left half.
5. Otherwise, a peak must exist in the right half.

By always moving towards the larger neighboring value, we gradually narrow down the search space until a peak is found.

## Algorithm

1. Initialize:
   - `start = 0`
   - `end = numberOfColumns - 1`
2. While `start <= end`:
   - Find the middle column.
   - Locate the row having the maximum element in that column.
   - Check the left and right neighbors.
3. If the current element is greater than both neighbors:
   - Return its position.
4. If the left neighbor is greater:
   - Search the left half.
5. Otherwise:
   - Search the right half.
6. If no peak is found, return `[-1, -1]`.

## Example

**Input**

```java
mat = [
  [10, 20, 15],
  [21, 30, 14],
  [7, 16, 32]
]
```

**Execution**

- Middle column = 1
- Maximum element in column 1 is `30` at row 1

```text
Left  = 21
Current = 30
Right = 14
```

Since:

```text
30 > 21
30 > 14
```

A peak is found.

**Output**

```java
[1, 1]
```

## Time Complexity

- **O(n × log m)**

Where:

- `n` = number of rows
- `m` = number of columns

For each Binary Search step, we scan one column to find its maximum element.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
