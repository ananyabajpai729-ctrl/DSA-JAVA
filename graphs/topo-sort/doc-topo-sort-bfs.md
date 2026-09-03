# Topological Sort - BFS (Kahn's Algorithm)

## Problem Statement

We are given a directed acyclic graph (DAG) and need to return a topological ordering of its vertices.

If there is an edge:

`u → v`

then `u` should come before `v` in the answer.

## Pattern

**BFS + Indegree + Topological Sort**

## Intuition

This time instead of using DFS, I can look at the graph in terms of **indegree**.

Indegree simply means:

> How many edges are coming into this node?

For example:

`0 → 1`

Here:

- indegree of `0` = `0`
- indegree of `1` = `1`

If a node has indegree `0`, nothing needs to come before it.

So I can take it first.

After taking a node, I remove its outgoing edges conceptually by decreasing the indegree of all its neighbours.

If some neighbour's indegree becomes `0`, it is now ready to be taken.

That's basically the whole idea.

## Approach

First, I calculate the indegree of every node.

For every edge:

`i → neighbour`

I increase:

`indegree[neighbour]++`

Then I put every node whose indegree is `0` into the queue.

These are the nodes that can be processed immediately.

Now I start BFS.

I take a node from the queue and put it into the answer.

Then I look at all its neighbours.

Since I have now processed this node, I decrease the indegree of each neighbour by `1`.

If a neighbour's indegree becomes `0`, I add it to the queue.

I keep doing this until the queue becomes empty.

## Dry Run

Consider:

    0 → 1
    0 → 2
    1 → 3
    2 → 3

Initial indegrees:

    0 → 0
    1 → 1
    2 → 1
    3 → 2

Only `0` has indegree `0`, so:

`Queue = [0]`

Take `0`.

Answer:

`[0]`

Now reduce the indegree of `1` and `2`:

    1 → 0
    2 → 0
    3 → 2

Both `1` and `2` can now go into the queue.

`Queue = [1, 2]`

Take `1`.

`3`'s indegree becomes:

`2 → 1`

Take `2`.

Now `3`'s indegree becomes:

`1 → 0`

So `3` goes into the queue.

Finally:

`Answer = [0, 1, 2, 3]`

This is a valid topological ordering.

## Why Does Indegree Help?

The whole trick is:

> `indegree = 0` means there is nothing left that needs to come before this node.

So that node is ready.

Every time I process a node, I reduce the indegree of the nodes after it.

When one of them reaches `0`, it becomes ready too.

So it keeps going like:

`indegree 0 → process → reduce neighbours → new indegree 0 → process`

## What About Multiple Starting Nodes?

There can be more than one node with indegree `0`.

For example:

    0 → 2
    1 → 2

Both `0` and `1` have indegree `0`.

So both can be added to the queue.

The queue handles this naturally.

And because there can be multiple valid topological orders, different orders can still be correct.

## DFS vs BFS Topological Sort

I have now seen both ways.

### DFS

`DFS → finish node → push into stack → pop stack`

### BFS / Kahn's Algorithm

`Calculate indegree → take indegree 0 → reduce neighbours`

The final ordering can be different, and that's completely fine as long as it follows the topological ordering rules.

## Time Complexity

**O(V + E)**

First I calculate all indegrees by going through every edge.

Then BFS processes every node and every edge again.

So overall it is `O(V + E)`.

## Space Complexity

**O(V)**

The indegree array takes `O(V)` space and the queue can contain up to `O(V)` nodes.

The answer array also takes `O(V)` space.

## Key Takeaway

The main thing I want to remember about Kahn's Algorithm is:

> A node with indegree `0` is ready to be processed.

So:

`indegree 0 → queue → process node → decrease neighbours' indegrees → add new 0-indegree nodes`

This is the BFS way of doing topological sort.
