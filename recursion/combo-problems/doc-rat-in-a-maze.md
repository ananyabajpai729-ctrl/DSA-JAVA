# Rat in a Maze

## Problem Statement

Given an `N × N` maze represented by a binary matrix, find all possible paths from the top-left cell `(0, 0)` to the bottom-right cell `(N-1, N-1)`.

- `1` represents an open cell.
- `0` represents a blocked cell.
- The rat can move **Down (D), Up (U), Right (R),** and **Left (L)**.
- A cell cannot be visited more than once in the same path.

Return all valid paths as strings.

---

## Intuition

Starting from the source cell, we try moving in all four possible directions.

Whenever we visit a cell, we temporarily mark it as visited so that we don't revisit it in the current path and create a cycle.

If we reach the destination, the current path is added to the answer. After exploring a path, we restore the cell and remove the last move to explore other possibilities.

---

## Approach

1. Start DFS from `(0, 0)`.
2. If the current cell is invalid or blocked, return.
3. If the destination is reached, store the current path.
4. Mark the current cell as visited.
5. Explore all four directions:
   - Down (`D`)
   - Up (`U`)
   - Right (`R`)
   - Left (`L`)
6. Backtrack by:
   - Removing the last move.
   - Restoring the current cell.

---

## Dry Run

**Input:**

```text
1 0 0
1 1 0
0 1 1
```

Possible path:

```text
(0,0)
  ↓
(1,0)
  →
(1,1)
  ↓
(2,1)
  →
(2,2)
```

Path string:

```text
DRDR
```

---

## Time Complexity

- **Time:** `O(4^(N²))` (worst case)
- **Space:** `O(N²)` (recursion stack + visited path)

---

## Key Takeaway

This is a **Grid Backtracking** problem.

The main idea is to **mark a cell as visited before exploring its neighbors and restore it while backtracking**. This prevents cycles and allows the same cell to be used in different valid paths.
