# Flood Fill

## Problem Statement

Given a grid of colors, a starting cell `(sr, sc)` and a new color, change the starting cell and all the connected cells having the same original color to the new color.

## Pattern

**BFS + Grid Traversal**

## Intuition

This is basically the same thing as the flood fill tool in a drawing app.

I start from one cell and need to reach all the connected cells that have the same color.

So I can treat the grid like a graph where from every cell I can move in four directions:

```text
       up
       ↑
left ← cell → right
       ↓
      down
```

I use BFS starting from `(sr, sc)`.

Whenever I find a neighbouring cell with the original color, I change its color and put it into the queue.

## Approach

First, I save the original color:

```java
int target = image[sr][sc];
```

I need this because after I start changing cells, I still need to know which cells originally had the target color.

Then I change the starting cell:

```java
image[sr][sc] = color;
```

There is one important edge case:

```java
if(target == color) return image;
```

If the new color is already the same as the original color, there is nothing to do.

Then I put the starting cell into the queue:

```java
q.add(new int[]{sr, sc});
```

Now I keep taking cells from the queue and checking their four neighbours.

If a neighbour is inside the grid and still has the original color:

```java
if(nr >= 0 && nr < image.length &&
   nc >= 0 && nc < image[0].length &&
   image[nr][nc] == target)
```

I change its color and add it to the queue:

```java
image[nr][nc] = color;
q.add(new int[]{nr, nc});
```

An important detail is that I change the color **when I add the cell to the queue**.

This prevents the same cell from being added multiple times by different neighbours.

## Dry Run

Suppose:

```text
1 1 1
1 1 0
1 0 1
```

Starting cell:

```text
(sr, sc) = (1, 1)
```

and new color:

```text
2
```

The starting cell has color `1`, so:

```text
target = 1
```

Start changing from `(1,1)`:

```text
1 1 1
1 2 0
1 0 1
```

Now BFS checks the neighbours of `(1,1)`.

The connected `1`s are changed to `2` and added to the queue.

Eventually we get:

```text
2 2 2
2 2 0
2 0 1
```

The `0`s are ignored because they don't have the target color.

The `1` at the bottom-right also stays `1` because it isn't connected to our starting cell.

## Why don't we need `size = q.size()` here?

In the previous **Rotting Oranges** problem, we needed:

```java
int size = q.size();
```

because we cared about **minutes**.

Each BFS level represented one minute.

Here, we don't care how many levels the BFS takes. We only care about visiting all connected cells.

So we can simply do:

```java
while(!q.isEmpty())
```

and keep processing until there is nothing left.

This is a useful distinction to remember:

```text
Need distance / time / levels?
        ↓
Process BFS level by level

Just need to visit everything?
        ↓
Normal BFS is enough
```

## Time Complexity

**O(R × C)**

In the worst case, every cell can be part of the connected region.

Each cell is added to the queue at most once.

## Space Complexity

**O(R × C)**

In the worst case, the queue can contain a large number of cells.

## Key Takeaway

The main idea is:

```text
Start from the given cell
        ↓
Check its 4 neighbours
        ↓
If neighbour has the original color
        ↓
Change its color
        ↓
Put it in the queue
        ↓
Repeat
```

The thing I want to remember from this problem is:

> **For connected regions in a grid, think BFS/DFS.**

And unlike Rotting Oranges, **I don't need to track BFS levels here because there is no time/distance involved.**
