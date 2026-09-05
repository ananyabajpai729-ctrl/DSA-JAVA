# Find Eventual Safe States

## Problem Statement

We are given a directed graph.

A node is called a **safe node** if starting from that node, we can never get stuck in a cycle.

We need to return all the safe nodes in increasing order.

## Pattern

**BFS + Indegree + Kahn's Algorithm**

## Intuition

At first, this problem looks a little different from the usual cycle detection.

But the main idea is:

> A node is safe if it eventually reaches a node that has no outgoing edges.

For example:

    0 → 1 → 2

Here `2` has no outgoing edges, so `2` is safe.

Since `1` only leads to `2`, `1` is also safe.

And `0` is safe too.

But if we have:

    0 → 1 → 2
        ↑   ↓
        └───┘

Then `1` and `2` are part of a cycle, so they aren't safe.

And `0` isn't safe either because it eventually reaches that cycle.

## The Trick

I can use Kahn's Algorithm, but I need to reverse the graph.

Normally, if I have:

`u → v`

I store:

`u → v`

Here I reverse it:

`v → u`

Why?

Because I want to start from the nodes that have **no outgoing edges**.

These are the nodes with no dependencies on other nodes, and they are immediately safe.

After finding one safe node, I can look backwards and see which other nodes lead to it.

## Approach

First, I create a reversed graph.

For every original edge:

`i → v`

I store:

`v → i`

At the same time, I increase:

`indegree[i]++`

Here, `indegree[i]` is basically keeping track of how many outgoing edges the original node `i` has.

So a node with:

`indegree[i] == 0`

is a terminal node in the original graph.

I put all such nodes into the queue.

Then I run BFS.

Whenever I remove a safe node from the queue, I look at all the nodes that can reach it.

For each of those nodes, I decrease its indegree.

If its indegree becomes `0`, that means all of its outgoing paths lead to safe nodes.

So that node is safe too, and I add it to the queue.

Finally, I sort the safe nodes because the question wants them in increasing order.

## Dry Run

Consider:

    0 → 1
    1 → 2
    2

`2` has no outgoing edges.

So:

`indegree[2] = 0`

and we start with:

`Queue = [2]`

Now process `2`.

In the reversed graph, `1` points to `2`, so we find `1`.

Its indegree decreases to `0`.

So:

`Queue = [1]`

Process `1`.

Now `0` becomes `0` indegree.

So:

`Queue = [0]`

Process `0`.

All three nodes are safe:

`[0, 1, 2]`

## What Happens With a Cycle?

Consider:

    0 → 1
    1 → 2
    2 → 1

Here `1` and `2` form a cycle.

Neither of them has `0` outgoing edges.

So neither gets added to the initial queue.

Only `0` might be processed if it eventually leads into the cycle, but `1` and `2` will remain stuck.

Therefore, they are not added to the answer.

This is the same idea as cycle detection with Kahn's Algorithm:

> Nodes trapped in a cycle never become indegree `0`.

## Why Reverse the Graph?

This is probably the most important part of this problem.

Suppose:

`0 → 1`

If `1` is known to be safe, then `0` might also be safe.

So after processing `1`, I want to quickly find:

> Which nodes point to `1`?

That's exactly what the reversed graph gives me.

Original:

`0 → 1`

Reversed:

`1 → 0`

Now, when I process `1`, I can directly reach `0`.

## Why Sort at the End?

The BFS doesn't necessarily process nodes in increasing order.

For example, the answer could be collected as:

`[2, 0, 1]`

All three could still be safe.

But the problem asks for the answer in increasing order.

So I use:

`Collections.sort(ans)`

to get:

`[0, 1, 2]`

## Time Complexity

**O(V + E)** for building the reversed graph and doing BFS.

Then we sort the safe nodes.

So including the sorting:

**O(V + E + V log V)**

which can also be written as:

**O(E + V log V)**

## Space Complexity

**O(V + E)**

The reversed adjacency list stores all the edges.

The `indegree` array takes `O(V)`.

The queue can contain up to `O(V)` nodes.

The answer list can also contain `O(V)` nodes.

So overall:

**O(V + E)**

## Key Takeaway

The main thing to remember here is:

> Safe nodes eventually lead to a terminal node, while unsafe nodes eventually lead to a cycle.

So I:

`Reverse the graph`

↓

`Find terminal nodes (indegree 0)`

↓

`BFS backwards`

↓

`Keep finding nodes that only lead to safe nodes`

↓

`Sort the answer`

The important trick is **reversing the edges** so that from a safe node, I can find all the nodes that can reach it.
