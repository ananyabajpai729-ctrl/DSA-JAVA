# 01 Matrix

## Problem Statement

Given a matrix containing only `0`s and `1`s, return a matrix where each cell contains the distance to its nearest `0`.

The distance is measured using the four directions:

```text
up, down, left, right
```

## Pattern

**Multi-Source BFS**

## Intuition

My first thought could be:

> For every `1`, run BFS and find the nearest `0`.

But that would be very slow because we'd be starting a BFS from many cells.

A better way is to think in reverse.

Instead of asking:

```text
How far is each 1 from a 0?
```

I can ask:

```text
What happens if all 0s start spreading at the same time?
```

All the `0`s become starting points.

The first time a cell gets reached, that distance is automatically the shortest distance to a `0`.

That's exactly what BFS is good at.

## Approach

First, I put all the `0`s into the queue.

```java
if(mat[i][j] == 0){
    q.add(new int[]{i,j});
}
```

For every `1`, I mark it as:

```java
mat[i][j] = -1;
```

I use `-1` to mean:

```text
Not visited yet
```

So I don't need a separate visited array.

### BFS

Now the queue already contains all the `0`s.

```text
0 0 0
0 0 0
0 0 0
```

These are all level 0 nodes.

For every cell removed from the queue, I check its four neighbours.

```java
for(int[] d : dirs)
```

If a neighbour is `-1`, it means we haven't assigned its distance yet.

So:

```java
mat[nr][nc] = mat[r][c] + 1;
```

Then I push it into the queue.

```java
q.add(new int[]{nr, nc});
```

The nice thing is that the first time we reach a cell is always through the shortest path because BFS explores level by level.

## Dry Run

Suppose:

```text
0 0 0
0 1 0
1 1 1
```

Initially:

```text
Queue:
(0,0) (0,1) (0,2)
(1,0)       (1,2)

Matrix:

0  0  0
0 -1  0
-1 -1 -1
```

The middle cell:

```text
(1,1)
```

is adjacent to a `0`.

So it becomes:

```text
1
```

Matrix:

```text
0 0 0
0 1 0
-1 -1 -1
```

Next level spreads further:

```text
0 0 0
0 1 0
1 2 1
```

This becomes the final answer.

## Why does BFS give the shortest distance?

Because BFS explores cells level by level.

```text
Level 0 → all 0s
Level 1 → distance 1
Level 2 → distance 2
Level 3 → distance 3
```

The first time a cell gets reached, we already know we've found the shortest possible distance.

So there is no need to revisit it later.

## Time Complexity

Let:

```text
m = number of rows
n = number of columns
```

Every cell is added to the queue at most once.

So:

**Time Complexity: O(m × n)**

## Space Complexity

In the worst case, the queue can contain many cells.

So:

**Space Complexity: O(m × n)**

## Key Takeaway

The thing I want to remember from this problem is:

> When there are multiple starting points and I need the shortest distance from any of them, think Multi-Source BFS.

The pattern looks like:

```text
All sources
     ↓
Put them into the queue together
     ↓
Run BFS
     ↓
First time a cell is reached
     ↓
Shortest distance found
```

This is the same core idea used in problems like:

* Rotting Oranges
* Nearest Exit
* Distance to nearest source
* Fire spread / infection spread type problems

The only difference is what the "source" represents. Here, the sources are all the `0`s.
