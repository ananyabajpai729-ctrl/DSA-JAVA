# N-Queens

## Problem Statement

Given an integer `n`, place `n` queens on an `n × n` chessboard such that no two queens attack each other.

Return all possible valid board configurations.

---

## Intuition

Since each row must contain exactly one queen, we place queens **row by row**.

For each row, we try every column. Before placing a queen, we check whether the position is safe:

- No queen in the same column.
- No queen on the upper-left diagonal.
- No queen on the upper-right diagonal.

If the position is safe, we place the queen and move to the next row. If no valid placement exists, we backtrack and try another column.

---

## Approach

1. Initialize an empty chessboard filled with `'.'`.
2. Start placing queens from the first row.
3. For each column in the current row:
   - Check if placing a queen is safe.
   - Place the queen.
   - Recurse for the next row.
   - Remove the queen (backtracking).
4. When all rows are processed, store the current board configuration.

---

## Dry Run

**Input:**

```text
n = 4
```

One valid configuration:

```text
. Q . .
. . . Q
Q . . .
. . Q .
```

Another valid configuration:

```text
. . Q .
Q . . .
. . . Q
. Q . .
```

---

## Time Complexity

- **Time:** `O(N!)`
- **Space:** `O(N²)` for the board and `O(N)` recursion stack.

---

## Key Takeaway

This is a classic **Backtracking** problem.

The important idea is to place **one queen per row** and verify that it doesn't conflict with any previously placed queens. If a placement leads to a dead end, backtrack and try the next column.
