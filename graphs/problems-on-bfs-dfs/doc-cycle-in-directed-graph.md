# Detect Cycle in a Directed Graph - DFS

## Problem Statement

We are given a directed graph and need to check whether it contains a cycle.

Return `true` if there is a cycle, otherwise return `false`.

## Pattern

**DFS + Cycle Detection + Path Tracking**

## Intuition

For a directed graph, just checking whether a neighbour was already visited is not enough.

A node might have been visited earlier from some completely different path.

What I actually care about is:

> Is the neighbour already present in my current DFS path?

That's why I use two arrays:

- `vis` → have I ever visited this node?
- `pathVis` → is this node currently in my DFS path?

If during DFS I reach a node whose `pathVis` is already `true`, I have come back to a node that is already in my current path.

That means there is a cycle.

## Approach

I start DFS from every unvisited node.

When I enter a node, I mark both:

`vis[node] = true`

and

`pathVis[node] = true`

Then I check all its neighbours.

### If the neighbour is not visited

I continue DFS from that neighbour.

If that DFS finds a cycle, I return `true`.

### If the neighbour is already in the current path

If:

`pathVis[it] == true`

then I have found a cycle.

For example:

    0 → 1 → 2
        ↑     |
        |_____|

When DFS reaches `2` and sees `1` again, `pathVis[1]` is still `true`.

So there is a cycle.

### Removing a node from the current path

Once I finish exploring all neighbours of a node, I do:

`pathVis[node] = false`

This is important.

It means:

> I'm done exploring this path, so this node is no longer part of my current DFS path.

The node stays `vis[node] = true` because I have still visited it.

## Dry Run

Consider:

    0 → 1 → 2
        ↑     |
        |_____|

Start DFS from `0`.

First:

`vis[0] = true`

`pathVis[0] = true`

Go to `1`.

Now:

`vis[1] = true`

`pathVis[1] = true`

Go to `2`.

Now:

`vis[2] = true`

`pathVis[2] = true`

From `2`, we find an edge back to `1`.

`1` is already visited.

But more importantly:

`pathVis[1] == true`

So `1` is already part of the current DFS path.

Therefore, a cycle exists.

Return `true`.

## Why Do We Need Two Arrays?

This is the main part to remember.

Suppose we have:

    0 → 1

    2 → 1

There is no cycle here.

Suppose DFS finishes the path:

`0 → 1`

After finishing `1`, we set:

`pathVis[1] = false`

Later we start DFS from `2`.

When `2` reaches `1`, `1` is already visited.

But:

`pathVis[1] == false`

So this is **not** a cycle.

This is why `vis` and `pathVis` have different jobs.

`vis`:

> Have I ever seen this node?

`pathVis`:

> Is this node part of the path I'm currently exploring?

## What About Disconnected Graphs?

The graph can have multiple components.

So I go through every node.

If a node hasn't been visited yet, I start a new DFS from it.

This makes sure every component gets checked.

## Time Complexity

**O(V + E)**

Every node is visited once and every edge is checked once during DFS.

## Space Complexity

**O(V)**

The `vis` and `pathVis` arrays take `O(V)` space.

The DFS recursion stack can also go up to `O(V)` in the worst case.

## Key Takeaway

The important difference between directed and undirected cycle detection is:

### Undirected Graph

We usually keep track of the **parent**.

`visited neighbour + neighbour != parent → cycle`

### Directed Graph

We keep track of the **current DFS path**.

`visited neighbour + neighbour is still in path → cycle`

So for directed graphs, remember:

`vis → visited at some point`

`pathVis → currently in my DFS path`

And:

`pathVis[neighbour] == true → cycle`
