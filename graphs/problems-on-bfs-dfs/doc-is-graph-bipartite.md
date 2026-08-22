# Is Graph Bipartite? - DFS

## Problem Statement

We are given a graph and need to check whether it is **bipartite**.

A graph is bipartite if we can divide its nodes into two groups such that no two connected nodes are in the same group.

I can think of the two groups as two colors:

`0` and `1`

## Pattern

**Graph + DFS + Coloring**

## Intuition

The main idea is pretty simple:

> Try to color the graph using only two colors.

Whenever I visit a node, I give it a color.

Then all of its neighbours have to get the **opposite** color.

So:

`0 → neighbours get 1`

and:

`1 → neighbours get 0`

If I ever find a neighbour that already has the **same** color as the current node, then something is wrong.

That means the graph cannot be divided into two groups.

## Approach

I create a `color` array.

Initially, every node has color `-1`, which means:

> This node hasn't been colored yet.

Then I go through every node.

If a node is still `-1`, I start DFS from it and give it color `0`.

Inside DFS, I look at all its neighbours.

If the neighbour hasn't been colored yet, I give it the opposite color.

The opposite color is simply:

`1 - col`

So:

- if current color is `0`, neighbour gets `1`
- if current color is `1`, neighbour gets `0`

If the neighbour is already colored, I check whether it has the same color as the current node.

If it does, I return `false`.

## Dry Run

Consider this graph:

    0 --- 1
    |     |
    |     |
    3 --- 2

Start with node `0`.

Give it color `0`.

Its neighbours `1` and `3` must get color `1`.

So:

    0(0) --- 1(1)
     |
     |
    3(1)

Now visit `1`.

Its neighbour `2` hasn't been colored, so it gets the opposite color:

`2 → 0`

Now we have:

    0(0) --- 1(1)
     |         |
     |         |
    3(1) --- 2(0)

Everything is fine because every edge connects different colors.

So this graph is bipartite.

## What Happens If There Is a Conflict?

Consider a triangle:

    0
   / \
  1---2

Start with:

`0 → color 0`

Then its neighbours get:

`1 → color 1`

`2 → color 1`

But `1` and `2` are also connected.

Now both of them have color `1`.

So we have two connected nodes with the same color.

That means the graph is not bipartite.

## Why `1 - col`?

This is just a simple way of switching between the two colors.

If:

`col = 0`

then:

`1 - col = 1`

And if:

`col = 1`

then:

`1 - col = 0`

So every time I move from one node to its neighbour, I automatically switch the color.

## What About Disconnected Graphs?

The graph might have multiple separate components.

For example:

    0 --- 1        2 --- 3

Starting DFS only from `0` would completely miss the second component.

That's why I loop through every node.

If `color[i] == -1`, it means this component hasn't been visited yet, so I start another DFS.

## Time Complexity

**O(V + E)**

Every node is visited once and every edge is checked while going through the neighbours.

## Space Complexity

**O(V)**

The `color` array takes `O(V)` space.

The DFS recursion can also go up to `O(V)` in the worst case.

## Key Takeaway

The main thing I want to remember is:

> A graph is bipartite if I can color it using two colors such that every edge connects nodes of different colors.

The pattern is:

`Uncolored node → give it a color → neighbours get opposite color`

And if I ever get:

`same color + connected → not bipartite`
