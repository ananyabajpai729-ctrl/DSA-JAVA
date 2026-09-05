# Shortest Path in an Undirected Graph

## Problem Statement

We are given an undirected graph with `N` nodes and `M` edges.

Every edge has a weight of `1`.

We need to find the shortest distance from node `0` to every other node.

If a node cannot be reached from node `0`, its distance should be `-1`.

## Pattern

**BFS + Shortest Path in an Unweighted Graph**

## Intuition

Since every edge has the same weight `1`, BFS is a good fit here.

Whenever I move from one node to one of its neighbours, the distance increases by `1`.

So if:

`distance[node] = 3`

then going to one of its neighbours would give:

`distance[neighbour] = 4`

BFS helps me explore the graph level by level, so I'm basically moving through the graph in increasing distance.

I keep an array `ans` where:

`ans[i] = shortest distance from 0 to i`

Initially, I don't know the distance to any node, so I fill it with `Integer.MAX_VALUE`.

Then:

`ans[0] = 0`

because the distance from node `0` to itself is `0`.

## Approach

First, I build the adjacency list.

Since the graph is undirected, for an edge:

`u - v`

I add both:

`u → v`

and:

`v → u`

Then I start BFS from node `0`.

For every node I remove from the queue, I check all its neighbours.

If going through the current node gives a shorter distance:

`ans[node] + 1 < ans[it]`

then I update the neighbour's distance and put it into the queue.

After BFS is finished, any node whose distance is still `Integer.MAX_VALUE` was never reached.

So I change those values to `-1`.

## Dry Run

Consider:

    0 --- 1 --- 3
    |
    2

Start from `0`.

Initially:

    ans = [0, INF, INF, INF]

Queue:

`[0]`

Process `0`.

Its neighbours are `1` and `2`.

So:

    ans = [0, 1, 1, INF]

Queue:

`[1, 2]`

Process `1`.

Its neighbour `3` can be reached in:

`ans[1] + 1 = 2`

So:

    ans = [0, 1, 1, 2]

Process `2`.

Nothing new is found.

Process `3`.

Nothing new is found.

Final answer:

`[0, 1, 1, 2]`

## Why BFS?

This is the main thing to remember.

When every edge has the same weight, moving one edge always costs `1`.

So BFS explores:

`distance 0`

then:

`distance 1`

then:

`distance 2`

then:

`distance 3`

and so on.

That's why BFS can be used to find the shortest path in an **unweighted graph**.

If the edges had different weights, normal BFS wouldn't be enough.

## Why Do I Check the Distance Again?

The condition:

`ans[node] + 1 < ans[it]`

means:

> Is the path I'm currently taking shorter than the distance I already have for this neighbour?

If yes, update it.

For this particular unweighted graph, BFS already gives shortest distances, so this condition will normally update a node when we first reach it.

Still, the condition makes the distance logic explicit.

## What About Unreachable Nodes?

Suppose:

    0 --- 1

    2 --- 3

Starting from `0`, nodes `2` and `3` can never be reached.

Their distances stay:

`Integer.MAX_VALUE`

So at the end I convert them to:

`-1`

Final answer:

`[0, 1, -1, -1]`

## Time Complexity

**O(N + M)**

Building the adjacency list takes `O(N + M)`.

During BFS, every node and every edge is processed at most a constant number of times.

## Space Complexity

**O(N + M)**

The adjacency list stores all `M` edges.

The distance array takes `O(N)`.

The queue can contain up to `O(N)` nodes.

So overall:

**O(N + M)**

## Key Takeaway

The main pattern to remember is:

> **Shortest path + every edge has the same weight → think BFS.**

The thought process is:

`Start from source`

↓

`BFS level by level`

↓

`Moving to neighbour costs +1`

↓

`Store shortest distance`

↓

`Unreachable → -1`

If the graph is unweighted, BFS is usually the first thing I should think about for shortest path.
