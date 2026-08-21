# Detect Cycle in an Undirected Graph - DFS

## Problem Statement

We are given an undirected graph and need to check whether it contains a cycle.

Return `true` if a cycle exists, otherwise return `false`.

## Pattern

**DFS + Cycle Detection**

## Intuition

This is basically the same idea as the BFS version.

The important thing is that in an undirected graph, finding an already visited neighbour does not automatically mean there is a cycle.

For example:

    0 --- 1

If I go from `0` to `1`, then `1` will see `0` as an already visited neighbour.

But that's completely normal because `0` is the node we came from.

So while doing DFS, I keep track of the **parent** of the current node.

Then the rule is:

> If I find an already visited neighbour and that neighbour is not my parent, then there is a cycle.

## Approach

I use DFS and pass the parent along with the current node.

The DFS function basically gets:

`node + parent`

For the starting node, the parent is `-1` because it doesn't have one.

When I find an unvisited neighbour, I call DFS on that neighbour and make the current node its parent.

For example:

`dfs(neighbour, node)`

So if I go:

`0 → 1 → 2`

then:

- parent of `1` is `0`
- parent of `2` is `1`

Now if `2` sees `1` again, that's fine because `1` is its parent.

But if `2` sees some other already visited node, then I know there is a cycle.

## Cycle Detection

The important part is:

`if neighbour is already visited && neighbour != parent`

Then I return `true`.

For example:

        0
       / \
      1---2

Suppose DFS reaches `2` from `1`.

So:

`current = 2`

`parent = 1`

When `2` sees `1`, that's okay because it is the parent.

But when `2` sees `0`, `0` is already visited and:

`0 != 1`

So a cycle exists.

## Dry Run

Consider:

        0
       / \
      1---2

Start DFS from `0`.

`0` is marked visited.

Go to `1`.

`1` is marked visited and its parent is `0`.

From `1`, we see `0`.

That's the parent, so we ignore it.

Then we go to `2`.

`2` is marked visited and its parent is `1`.

Now `2` sees `0`.

`0` is already visited and it is not the parent of `2`.

So we found a cycle.

Return `true`.

The `true` keeps travelling back through the recursive calls until `isCycle()` returns `true`.

## What About Disconnected Graphs?

The graph might have multiple components.

For example:

        0 --- 1        2 --- 3

So I can't just start DFS from `0`.

I loop through every vertex.

If it is already visited, I skip it.

If it isn't visited, I start a new DFS from there.

This makes sure every component is checked.

## BFS vs DFS

The idea is basically the same in both versions.

**BFS:**

`queue stores (node, parent)`

**DFS:**

`parent is passed as a function parameter`

Everything else is almost the same.

## Time Complexity

**O(V + E)**

Every vertex is visited once and every edge is checked while going through the adjacency lists.

## Space Complexity

**O(V)**

The `visited` array takes `O(V)` space.

The recursive DFS calls can also go as deep as `V` in the worst case, so the recursion stack can take `O(V)` space.

## Key Takeaway

The main thing to remember is:

> In an undirected graph, an already visited neighbour is a cycle only when that neighbour is not the parent.

For DFS:

`DFS(node, parent)`

and:

`visited neighbour + neighbour != parent → cycle`

So the BFS and DFS versions are using the **same idea**, just storing the parent differently.
