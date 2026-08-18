# Rotting Oranges

## Problem Statement

We are given a grid where:

```text
0 → empty cell
1 → fresh orange
2 → rotten orange
```

Every minute, a rotten orange makes its adjacent fresh oranges rotten.

We need to find the minimum number of minutes needed to rot all the oranges.

If some fresh oranges can never become rotten, return `-1`.

## Pattern

**Multi-Source BFS**

## Intuition

The important thing here is that **all rotten oranges start spreading at the same time**.

So I can't just start BFS from one rotten orange.

I put **all the rotten oranges into the queue initially**.

Then I process the queue level by level.

Each level represents one minute.

For example:

```text
Initially:
2   1   1

After 1 minute:
2   2   1

After 2 minutes:
2   2   2
```

So the queue is basically helping me simulate the passing of time.

## Approach

First, I go through the whole grid.

While doing that:

* Count how many fresh oranges there are.
* Put all rotten oranges into the queue.

```java
if(grid[i][j] == 1) fresh++;

if(grid[i][j] == 2) {
    q.add(new int[]{i, j});
}
```

I also keep the four possible directions:

```java
int[][] dirs = {
    {0, 1},
    {0, -1},
    {1, 0},
    {-1, 0}
};
```

These represent:

```text
       up
       ↑
left ← cell → right
       ↓
      down
```

Then I start BFS.

```java
while(!q.isEmpty() && fresh > 0)
```

As long as there are rotten oranges to process and some fresh oranges are still left.

### Processing one minute

This line is important:

```java
int k = q.size();
```

`k` tells me how many rotten oranges are currently in the queue.

I process exactly those oranges in this round.

Any fresh orange that becomes rotten gets added to the queue, but it won't be processed until the **next** round.

After processing the current level:

```java
minutes++;
```

So one BFS level = one minute.

### Rotting a neighbouring orange

For every rotten orange, I check its four neighbours.

If a neighbour is fresh:

```java
if(grid[nr][nc] == 1)
```

I make it rotten immediately:

```java
grid[nr][nc] = 2;
```

Then:

```java
fresh--;
q.add(new int[]{nr, nc});
```

I decrease the number of fresh oranges and add this newly rotten orange to the queue.

Marking it as rotten immediately is important because otherwise the same orange could get added to the queue more than once.

## Dry Run

Consider:

```text
2 1 1
0 1 1
1 0 1
```

Initially:

```text
fresh = 6
queue = [(0,0)]
minutes = 0
```

### Minute 1

The rotten orange at `(0,0)` makes `(0,1)` rotten.

```text
2 2 1
0 1 1
1 0 1
```

Now:

```text
fresh = 5
minutes = 1
```

### Minute 2

The orange at `(0,1)` spreads to `(0,2)` and `(1,1)`.

```text
2 2 2
0 2 1
1 0 1
```

Now:

```text
fresh = 3
minutes = 2
```

The newly rotten oranges are now in the queue and will be processed in the next round.

This continues until either:

```text
fresh = 0
```

or there are no more rotten oranges that can spread.

## What if some oranges cannot be reached?

This is why I keep track of `fresh`.

After BFS finishes:

```java
return fresh == 0 ? minutes : -1;
```

If `fresh == 0`, everything became rotten.

Otherwise, some fresh oranges were never reached, so I return `-1`.

## Time Complexity

If the grid has `R × C` cells:

**O(R × C)**

Each cell is added to the queue at most once and processed at most once.

The initial grid traversal also takes `O(R × C)`.

## Space Complexity

**O(R × C)** in the worst case.

The queue can contain many cells at once.

The `dirs` array only contains four directions, so that is constant space.

## Key Takeaway

The main thing I want to remember is:

> **When multiple sources are spreading something at the same time, think Multi-Source BFS.**

And when the problem talks about time/steps:

```text
Queue contains current level
        ↓
Process current level
        ↓
Add newly reached cells
        ↓
Move to next level
        ↓
minutes++
```

So here:

```text
Multiple rotten oranges
          ↓
    Multi-source BFS
          ↓
   One level = 1 minute
```
