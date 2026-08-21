# Detect Cycle in an Undirected Graph - BFS

## Problem Statement

We are given an undirected graph and need to check whether the graph contains a cycle.

Return `true` if a cycle exists, otherwise return `false`.

## Pattern

**BFS + Cycle Detection**

## Intuition

The main thing that confused me here is that finding an already visited neighbour does **not** always mean there is a cycle.

For example:

    0 --- 1

If I go from `0` to `1`, then from `1` I will see `0` again.

But that's not a cycle. `0` is simply the node I came from.

So while doing BFS, I need to remember the **parent** of each node.

Then the idea becomes:

> If I find an already visited neighbour and that neighbour is not my parent, then there is a cycle.

## Approach

I use BFS and store two things in the queue:

- the current node
- its parent

So each queue element is basically:

`(node, parent)`

I start with:

`(startNode, -1)`

because the starting node doesn't have a parent.

While doing BFS, I look at all the neighbours of the current node.

If the neighbour hasn't been visited yet, I mark it visited and add it to the queue with the current node as its parent.

For example, if I reach node `2` from node `1`, I store:

`(2, 1)`

Now when I process `2`, seeing `1` again is completely fine because `1` is its parent.

But if I see some other already visited node, then there must be another path to that node.

That means there is a cycle.

## Cycle Detection

The important condition is:

`visited neighbour && neighbour != parent`

If this happens, I return `true`.

For example:

        0
       / \
      1---2

Suppose I reach `2` from `1`.

So:

`current = 2`

`parent = 1`

Now `2` sees `1`.

That's fine because `1` is the parent.

But if `2` sees `0` and `0` is already visited, then:

`0 != 1`

So there is a cycle.

## Dry Run

Consider:

        0
       / \
      1---2

Start BFS from `0`.

Queue:

`(0, -1)`

From `0`, I visit `1` and `2`.

Queue becomes:

`(1, 0), (2, 0)`

Now process `1`.

Its parent is `0`.

It sees `0`, but that's okay because `0` is its parent.

It also sees `2`.

`2` is already visited, and `2` is not the parent of `1`.

So we have found a cycle.

Return `true`.

## What About Disconnected Graphs?

The graph might have multiple separate components.

For example:

        0 --- 1        2 --- 3

So I can't just run BFS from node `0`.

I loop through all the vertices.

If a vertex is already visited, I skip it.

If it isn't visited, I start a new BFS from it.

This way every component gets checked.

## Time Complexity

**O(V + E)**

Every vertex is visited once and every edge is checked while going through the adjacency lists.

## Space Complexity

**O(V)**

The `visited` array takes `O(V)` space and the BFS queue can also contain up to `O(V)` nodes.

## Key Takeaway

The main thing to remember is:

> In an undirected graph, an already visited neighbour is not automatically a cycle.

I have to check whether that neighbour is my parent.

So the rule is:

`visited neighbour + not parent = cycle`

And for a disconnected graph:

`every unvisited node → start BFS`

That's the main pattern for detecting a cycle in an undirected graph using BFS.
