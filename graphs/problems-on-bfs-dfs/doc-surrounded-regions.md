# Surrounded Regions

## Problem Statement

Given a board containing `X` and `O`, replace all the `O`s that are completely surrounded by `X` with `X`.

An `O` should **not** be changed if it is connected to the boundary of the board.

## Pattern

**BFS + Boundary Traversal**

## Intuition

The first thing I need to notice is that an `O` can only be surrounded if it is **not connected to the boundary**.

So instead of checking every `O` and asking:

> "Is this surrounded?"

I can reverse the thinking:

> "Which `O`s are definitely safe and should stay `O`?"

Any `O` on the boundary is safe.

And if another `O` is connected to a boundary `O`, that one is also safe because there is a path from it to the outside.

So I start BFS from **all boundary `O`s**.

I temporarily mark all these safe cells as `S`.

After that, any `O` still left must be surrounded, so I change it to `X`.

## Approach

First, I check all four boundaries of the board.

Whenever I find an `O`, I change it to `S` and put it into the queue.

For example, for the top row:

```java
if(board[0][i] == 'O'){
    board[0][i] = 'S';
    q.add(new int[]{0, i});
}
```

I do the same for:

* top row
* left column
* right column
* bottom row

I use `S` as a temporary marker for:

> This `O` is safe and should not be changed.

### BFS

Now the queue contains all the boundary `O`s.

I run BFS from them.

If a neighbouring cell is also `O`, I mark it as `S` and add it to the queue:

```java
if(nr >= 0 && nr < m &&
   nc >= 0 && nc < n &&
   board[nr][nc] == 'O'){

    board[nr][nc] = 'S';
    q.add(new int[]{nr, nc});
}
```

This finds every `O` that is connected to the boundary.

## Dry Run

Consider:

```text
X X X X
X O O X
X X O X
X O X X
```

The `O` at `(3,1)` is on the boundary, so it is safe.

The `O`s connected to it would also be safe if there were any.

But the group in the middle:

```text
O O
  O
```

is not connected to the boundary.

So after marking the boundary-connected `O`s as `S`, we might have:

```text
X X X X
X O O X
X X O X
X S X X
```

There are no middle `O`s connected to the boundary, so the remaining `O`s are surrounded.

We change them to `X`:

```text
X X X X
X X X X
X X X X
X O X X
```

Finally, the `S` becomes `O` again.

## Final Step

After BFS:

```java
if(board[i][j] == 'S'){
    board[i][j] = 'O';
}else if(board[i][j] == 'O'){
    board[i][j] = 'X';
}
```

So:

```text
S → O
O → X
X → X
```

This works because every `S` was proven to be connected to the boundary.

## Why start from the boundary?

This is the main trick of the problem.

If I start BFS from every inner `O`, I would have to figure out whether it can somehow reach the boundary.

Instead, I start from the boundary and find all the `O`s that **can reach the boundary**.

Everything else can safely be changed to `X`.

So the thought process is:

```text
Boundary O's
     ↓
BFS
     ↓
Find all connected O's
     ↓
Mark them safe
     ↓
Remaining O's are surrounded
     ↓
Change them to X
```

## Time Complexity

**O(m × n)**

I visit each cell at most a constant number of times.

The boundary traversal, BFS, and final traversal are all within `O(m × n)`.

## Space Complexity

**O(m × n)** in the worst case.

The queue can contain many cells if a large part of the board is connected to the boundary.

## Key Takeaway

The main thing I want to remember is:

> Don't try to find the surrounded `O`s directly. Find the `O`s that are connected to the boundary. Everything else can be changed.

This is a useful pattern:

```text
Problem asks:
"Which cells are trapped?"

Think:
"Which cells are NOT trapped?"

Start from the boundary and work inward.
```
