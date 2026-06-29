# Sudoku Solver

## Problem Statement

Given a partially filled `9 × 9` Sudoku board, fill the empty cells (`'.'`) so that the completed board satisfies all Sudoku rules:

- Each row contains digits `1` to `9` exactly once.
- Each column contains digits `1` to `9` exactly once.
- Each `3 × 3` sub-grid contains digits `1` to `9` exactly once.

It is guaranteed that the input has a unique solution.

---

## Intuition

We solve the Sudoku one empty cell at a time.

For every empty cell, we try placing digits from `1` to `9`. A digit is placed only if it doesn't violate any Sudoku rule.

If a choice eventually leads to an invalid state, we undo the placement (backtrack) and try the next digit.

---

## Approach

1. Traverse the board to find the first empty cell (`'.'`).
2. Try placing digits `1` to `9`.
3. Before placing a digit, check whether it is safe:
   - Not present in the same row.
   - Not present in the same column.
   - Not present in the corresponding `3 × 3` sub-grid.
4. If the placement is valid, place the digit and recursively solve the remaining board.
5. If no digit works, backtrack by resetting the cell to `'.'`.
6. If no empty cells remain, the Sudoku is solved.

---

## Dry Run

Suppose the first empty cell is:

```text
5 3 .
6 . .
. 9 8
```

Possible attempts:

```text
Try 1 ✗
Try 2 ✓
```

Place `2` and recursively solve the rest of the board.

If a later cell cannot be filled, remove `2` and continue trying `3`, `4`, ..., `9`.

---

## Time Complexity

- **Time:** `O(9^(E))`, where `E` is the number of empty cells.
- **Space:** `O(E)` recursion stack.

Although the worst-case complexity is exponential, the Sudoku constraints prune a large number of invalid possibilities, making backtracking practical.

---

## Key Takeaway

This is a classic **Backtracking + Constraint Checking** problem.

The important idea is to fill one empty cell at a time, verify the placement using Sudoku rules, and backtrack whenever a choice leads to an invalid configuration.
