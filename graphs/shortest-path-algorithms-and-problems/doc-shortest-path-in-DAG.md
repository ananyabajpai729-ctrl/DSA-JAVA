# Shortest Path in a DAG

## Problem Statement

We are given a **Directed Acyclic Graph (DAG)** with `N` nodes and `M` weighted edges.

Each edge looks like:

`u → v` with weight `wt`

We need to find the shortest distance from node `0` to every other node.

If a node cannot be reached from `0`, return `-1` for that node.

## Pattern

**Topological Sort + Shortest Path + Relaxation**

## Intuition

This is different from the previous shortest path problem.

There, all edges had the same weight, so BFS worked.

Here the edges can have different weights.

But we are told the graph is a **DAG**, and that gives us a nice trick:

> Get the nodes in topological order, then calculate the shortest distances in that order.

I first find a topological ordering using Kahn's Algorithm.

Then I go through the nodes in that order.

For every node, I try to improve the distance of its neighbours.

This is called **relaxing an edge**, but the idea is simply:

> "If going through this node gives me a shorter path to the neighbour, update the distance."

## Approach

### 1. Build the adjacency list

For every edge:

`u → v` with weight `wt`

I store both pieces of information:

- neighbour = `v`
- weight = `wt`

So my adjacency list contains:

`{neighbour, weight}`

rather than just the neighbour.

### 2. Find the topological order

I use Kahn's Algorithm.

First, calculate the indegree of every node.

Then put all nodes with:

`indegree == 0`

into the queue.

Process them using BFS and keep adding them to `topo`.

At the end, `topo` contains the nodes in topological order.

### 3. Start distance from node 0

Initially, I don't know the distance to any node:

`dist = [INF, INF, INF, ...]`

Then:

`dist[0] = 0`

because the distance from node `0` to itself is `0`.

### 4. Relax the edges

Now I go through the nodes in topological order.

For every neighbour:

`neighbour = it[0]`

and:

`wt = it[1]`

I check:

`dist[node] + wt < dist[neighbour]`

If this is true, I found a shorter way to reach that neighbour.

So I update its distance.

I only do this if `dist[node]` isn't `Integer.MAX_VALUE`, because otherwise the node isn't reachable from `0`.

### 5. Convert unreachable nodes

After everything is processed, any node whose distance is still:

`Integer.MAX_VALUE`

was never reachable from node `0`.

So I change it to:

`-1`

## Dry Run

Consider:

    0 --2--> 1
    |        |
    4        3
    ↓        ↓
    2 --1--> 3

Edges:

`0 → 1 (2)`

`0 → 2 (4)`

`1 → 3 (3)`

`2 → 3 (1)`

One possible topological order is:

`[0, 1, 2, 3]`

Initially:

`dist = [0, INF, INF, INF]`

### Process 0

`0 → 1` with weight `2`

So:

`dist[1] = 2`

`0 → 2` with weight `4`

So:

`dist[2] = 4`

Now:

`dist = [0, 2, 4, INF]`

### Process 1

`1 → 3` with weight `3`

So:

`dist[3] = 2 + 3 = 5`

Now:

`dist = [0, 2, 4, 5]`

### Process 2

`2 → 3` with weight `1`

Going through `2` gives:

`4 + 1 = 5`

It's not smaller than the current `5`, so nothing changes.

Final:

`[0, 2, 4, 5]`

## Why Does Topological Order Help?

This is the main idea of the problem.

If I process a node in topological order, all the nodes that can come before it have already been processed.

So by the time I reach a node, I have already considered the paths coming into it.

Then I can safely use its distance to update the nodes after it.

For example:

`0 → 1 → 2`

Topological order:

`0, 1, 2`

I process `0` first and find the distance to `1`.

Then I process `1` and use its already calculated distance to find the distance to `2`.

That's why the order matters.

## Why Doesn't Normal BFS Work Here?

Because the edge weights aren't necessarily the same.

For example:

    0 --10--> 1
    |
    2
    ↓
    2 --2--> 1

BFS might reach `1` through the edge of weight `10` first.

But the actual shortest path is:

`0 → 2 → 1`

with distance:

`2 + 2 = 4`

So with weighted edges, normal BFS isn't enough.

Since this graph is a DAG, topological ordering gives us another way to handle the shortest path.

## What Does Relaxation Mean?

The word sounds more complicated than it is.

This:

`if(dist[node] + wt < dist[neighbour])`

basically means:

> "Is it cheaper to reach the neighbour by going through this node?"

If yes:

`update the distance`

That's all relaxation means here.

## Why Check `dist[node] != Integer.MAX_VALUE`?

Suppose there is a node that cannot be reached from `0`.

Its distance stays:

`Integer.MAX_VALUE`

If I blindly did:

`Integer.MAX_VALUE + wt`

I'd be doing calculations with a value that really means "unreachable".

So I first check:

`dist[node] != Integer.MAX_VALUE`

Only reachable nodes are used for relaxing edges.

## Time Complexity

**O(N + M)**

Building the adjacency list takes `O(N + M)`.

Topological sorting takes `O(N + M)`.

The final pass through the topological order checks every edge once, which is also `O(N + M)`.

So overall:

**O(N + M)**

## Space Complexity

**O(N + M)**

The adjacency list stores all `M` edges.

The indegree array takes `O(N)`.

The queue takes `O(N)` in the worst case.

The topological order list takes `O(N)`.

The distance array takes `O(N)`.

So overall:

**O(N + M)**

## Key Takeaway

The pattern here is:

**DAG + weighted edges + shortest path**

Think:

`Topological Sort`

↓

`Start dist[0] = 0`

↓

`Process nodes in topological order`

↓

`Relax every outgoing edge`

↓

`Unreachable → -1`

The important difference from the previous shortest path problem is:

**Unweighted graph → BFS**

**Weighted DAG → Topological Sort + Relaxation**
