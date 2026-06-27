# Word Search

## Problem Statement

Given an `m × n` grid of characters and a string `word`, determine if the word exists in the grid.

The word can be formed by moving **up, down, left, or right**, and each cell can be used **only once** in a single path.

---

## Intuition

We start searching from every cell in the grid.

If a cell matches the current character of the word, we continue exploring its four neighboring cells for the next character.

To ensure a cell is not reused in the same path, we temporarily mark it as visited. After exploring all possible paths, we restore its original value (backtracking).

---

## Approach

1. Iterate through every cell of the board.
2. Start a DFS if the current cell could be the starting character.
3. During DFS:
   - Check if the current character matches.
   - Mark the cell as visited.
   - Explore all four directions.
   - Restore the cell before returning.
4. If all characters of the word are matched, return `true`.

---

## Dry Run

**Input:**

```text
Board:

A B C E
S F C S
A D E E

Word = "ABCCED"
```

Path followed:

```text
A → B → C → C → E → D
```

All characters are matched, so the answer is:

```text
true
```

---

## Time Complexity

- **Time:** `O(M × N × 4^L)`
  - `M × N` starting positions.
  - At most `4` choices for each character of length `L`.

- **Space:** `O(L)`
  - Recursion stack depth is at most the length of the word.

---

## Key Takeaway

This is a classic **Grid Backtracking** problem.

The important idea is to **mark a cell as visited before exploring its neighbors and restore it afterward**. This allows us to reuse the same board for different search paths while ensuring a cell isn't used twice in a single path.
