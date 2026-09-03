# Topological Sort - DFS

## Problem Statement

We are given a directed acyclic graph (DAG) and need to return a topological ordering of its vertices.

In a topological ordering, if there is an edge:

`u → v`

then `u` should come before `v`.

## Pattern

**DFS + Stack + Topological Sort**

## Intuition

The interesting part here is when to put a node into the answer.

If I visit a node, I first need to finish all the nodes that come after it.

So I do DFS on all its neighbours first.

Only after all its neighbours are done, I push the current node into the stack.

Basically:

`Visit node → visit all neighbours → push node`

Because the nodes are pushed after their neighbours, when I later pop the stack, the order gets reversed and I get the topological ordering.

## Approach

I keep a `visited` array so that I don't process the same node again.

For every unvisited node, I start DFS.

Inside DFS:

1. Mark the current node as visited.
2. Visit all its unvisited neighbours.
3. Once all neighbours are finished, push the current node into the stack.

After all DFS calls are complete, I pop the stack one by one and put the nodes into the answer array.

## Dry Run

Consider:

    0 → 1
    0 → 2
    1 → 3
    2 → 3

Start DFS from `0`.

I go to `1`.

From `1`, I go to `3`.

`3` has no unvisited neighbours, so I push `3`.

Then I finish `1`, so I push `1`.

Now I go to `2`.

`3` is already visited, so I don't visit it again.

Then I finish `2`, so I push `2`.

Finally I finish `0`, so I push `0`.

The stack from bottom to top is:

`3, 1, 2, 0`

When I pop everything, I get:

`0, 2, 1, 3`

This is a valid topological ordering.

## Why Do We Push After DFS?

This is the main thing to remember.

Suppose we have:

`0 → 1`

If I push `0` immediately when I visit it, I might get:

`0, 1`

But with the stack approach, I first finish `1`:

`push 1`

Then finish `0`:

`push 0`

So the stack contains them in reverse order:

`1, 0`

And when I pop:

`0, 1`

which is what we want.

So:

> A node is pushed only after all the nodes reachable from it have been processed.

## Why Use a Stack?

The DFS naturally gives us the nodes in a kind of reverse order.

For an edge:

`u → v`

`v` gets pushed before `u`.

So the stack looks like:

`v, u`

When I pop it, I get:

`u, v`

which puts the source before the destination.

## What About Multiple Components?

The graph might not be fully connected.

For example:

    0 → 1

    2 → 3

So I can't just start DFS from `0`.

That's why I loop through every vertex.

If the vertex hasn't been visited, I start another DFS from it.

This makes sure every node gets included.

## Time Complexity

**O(V + E)**

Every vertex is visited once and every edge is checked once during DFS.

Pushing and popping the `V` nodes from the stack also takes `O(V)`.

## Space Complexity

**O(V)**

The `visited` array takes `O(V)` space.

The stack contains all `V` nodes in the worst case.

The DFS recursion stack can also go up to `O(V)`.

## Key Takeaway

The main thing to remember is:

> In DFS topological sort, push a node only after all its neighbours are finished.

So the pattern is:

`DFS → finish neighbours → push node → pop stack`

Also, topological sorting only makes sense for a **DAG**. If the graph has a cycle, a topological ordering is not possible.
