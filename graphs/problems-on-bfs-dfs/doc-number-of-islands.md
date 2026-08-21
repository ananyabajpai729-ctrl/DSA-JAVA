# Number of Islands

## Problem Statement

We are given a grid containing:

- `'1'` → land
- `'0'` → water

An island is a group of connected land cells.

Connections are allowed only in four directions:

- up
- down
- left
- right

We need to count the total number of islands.

## Pattern

**BFS + Grid Traversal**

## Intuition

The idea is pretty simple.

Whenever I find a `'1'`, it means I have discovered a new island.

So I:

- increase the island count
- start BFS from that cell
- visit the entire island
- mark all its cells as visited

This way, when I continue scanning the grid, I won't count the same island again.

So the thought process is:

`Found a new '1' → New island → BFS → Mark whole island visited`

## Approach

I go through every cell in the grid.

If I find a `'1'`:

- add it to the queue
- change it to `'0'`
- increase `count`

Now BFS starts.

For every cell removed from the queue, I check its four neighbours.

If a neighbour:

- is inside the grid
- and is `'1'`

then I:

- add it to the queue
- mark it as `'0'`

Marking it immediately is important because it prevents the same cell from being added multiple times.

I keep doing this until the queue becomes empty.

Then I continue scanning the grid.

## Dry Run

Suppose the grid is:

    1 1 0 0
    1 0 0 1
    0 0 1 1
    0 0 0 0

Start scanning.

The first `'1'` is found:

`count = 1`

BFS visits:

    1 1
    1

This whole group becomes visited.

Continue scanning.

Another `'1'` is found:

`count = 2`

BFS visits:

      1
    1 1

So there are two islands.

Answer = `2`

## Why Does BFS Work?

One BFS call visits all the cells belonging to one island.

So I only increase the count when I find the first cell of an unvisited island.

The BFS takes care of the rest.

## Time Complexity

**O(m × n)**

Every cell is visited at most once.

## Space Complexity

**O(m × n)**

In the worst case, many cells can be present in the queue.

I don't need a separate `visited` array because I directly change `'1'` into `'0'`.

## Key Takeaway

The thing to remember is:

> Every unvisited `'1'` means a new island.

Then:

`count++ → BFS → mark whole island visited`

This pattern appears in many grid problems:

- Number of Islands
- Flood Fill
- Rotting Oranges
- Enclaves
- Surrounded Regions
