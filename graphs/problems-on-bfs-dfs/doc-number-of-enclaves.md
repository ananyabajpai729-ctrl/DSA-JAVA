# Number of Enclaves

## Problem Statement

We have a grid containing `0`s and `1`s.

- `0` means water
- `1` means land

A land cell is called an **enclave** if it cannot reach the boundary of the grid by moving through other land cells.

We have to count how many land cells are enclaves.

## Pattern

**BFS + Boundary Traversal**

## Intuition

Instead of trying to find which `1`s are trapped, I can think about it the other way:

> Which `1`s can escape?

Any `1` on the boundary can escape.

And if another `1` is connected to a boundary `1`, that one can escape too.

So I start BFS from all the boundary `1`s and mark every land cell that can reach the boundary.

After that, whatever `1`s are still left must be trapped.

So the idea is:

**Boundary `1`s → BFS → mark reachable land → count remaining `1`s**

## Approach

First, I check all four boundaries of the grid.

Whenever I find a `1`, I add it to the queue and change it to `-1`.

I use `-1` as a visited marker, so I don't need a separate `visited` array.

Then I run BFS from all these boundary cells.

For every cell taken from the queue, I check its four neighbours.

If the neighbour is a `1`, I know it is connected to the boundary, so I mark it as `-1` and add it to the queue.

Once BFS is finished, all the `1`s that could reach the boundary have been marked.

Finally, I go through the grid again and count the `1`s that are still there.

Those are the enclaves.

## Dry Run

Suppose the grid is:

    0 0 0 0
    1 0 1 0
    0 1 1 0
    0 0 0 0

The `1` on the left boundary can escape, so BFS starts from it.

The other `1`s are completely inside the grid and are not connected to the boundary.

After BFS, the boundary-connected land is marked as `-1`.

The remaining `1`s are the enclosed ones.

There are `3` of them, so the answer is `3`.

## Why Start From the Boundary?

This is the main trick in this problem.

If a land cell is connected to the boundary, it cannot be an enclave.

So instead of checking every land cell and asking whether it is trapped, I find all the cells that are definitely **not** trapped.

Then whatever is left must be an enclave.

This is basically the same idea as **Surrounded Regions**.

## Time Complexity

**O(m × n)**

I go through the grid a few times, and each cell can be visited at most once during BFS.

## Space Complexity

**O(m × n)**

In the worst case, the queue can contain many cells.

I don't need a separate `visited` array because I use `-1` directly in the grid.

## Key Takeaway

The main thing I want to remember is:

> When a problem asks for cells that are trapped, enclosed, or surrounded, try finding the cells that can reach the boundary instead.

**Boundary → BFS/DFS → mark reachable cells → whatever remains is trapped.**
