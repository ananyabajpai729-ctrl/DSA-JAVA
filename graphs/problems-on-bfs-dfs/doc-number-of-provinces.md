# Number of Provinces

## Problem Statement

We are given a matrix where:

```text
isConnected[i][j] = 1
```

means person/city `i` and `j` are directly connected.

A province is basically a group of nodes that are connected to each other directly or indirectly.

We need to find the number of provinces.

## Pattern

**Graph + DFS + Connected Components**

## Intuition

The first thing I need to notice is that this is basically a graph problem.

Each person/city can be treated as a **node**.

If two of them are connected, there is an **edge** between them.

So the problem becomes:

> How many connected components are there in this graph?

For every node, if I haven't visited it yet, I start a DFS from it.

That DFS will visit the whole group connected to that node.

So every time I start a new DFS, I have found one new province.

## Approach

The input is given as an adjacency matrix:

```text
isConnected
```

I first convert it into an adjacency list because it makes the DFS easier to work with.

For every connection, I add the nodes to each other's list:

```java
adj.get(i).add(j);
adj.get(j).add(i);
```

Then I create a `visited` array:

```java
boolean[] vis = new boolean[V];
```

Now I go through every node.

```java
for(int i = 0; i < V; i++){
    if(!vis[i]){
        ans++;
        dfs(vis, i, adj);
    }
}
```

If the node is already visited, it belongs to a province that I have already counted.

If it isn't visited, I haven't explored that province yet.

So:

```text
unvisited node
      ↓
   ans++
      ↓
    DFS
      ↓
visit the whole province
```

## DFS

The DFS is pretty straightforward:

```java
private void dfs(boolean[] vis, int node, List<List<Integer>> adj){
    vis[node] = true;

    for(int neighbour : adj.get(node)){
        if(!vis[neighbour]){
            dfs(vis, neighbour, adj);
        }
    }
}
```

First I mark the current node as visited.

Then I look at all its neighbours.

If a neighbour hasn't been visited, I continue DFS from there.

Eventually, every node belonging to that connected component gets visited.

## Dry Run

Suppose the connections are:

```text
1 --- 2        3
|              |
|              |
4              5
```

So there are two separate groups:

```text
Province 1: 1, 2, 4

Province 2: 3, 5
```

Initially:

```text
vis = [false, false, false, false, false]
ans = 0
```

Start at node `1`.

It isn't visited, so:

```text
ans = 1
```

DFS visits:

```text
1 → 2 → 4
```

Now those nodes are marked visited.

Then the outer loop reaches node `2` and node `4`, but both are already visited, so I don't start another DFS.

Next, node `3` is unvisited.

So:

```text
ans = 2
```

DFS visits:

```text
3 → 5
```

Now every node is visited.

Final answer:

```text
2
```

## Time Complexity

Let `V` be the number of nodes.

Building the adjacency list takes **O(V²)** because we go through the whole `V × V` matrix.

The DFS itself takes **O(V + E)**.

So overall, because the input itself is a `V × V` matrix:

**O(V²)**

## Space Complexity

The adjacency list takes **O(V + E)** space.

The visited array takes **O(V)**.

The DFS recursion can also use up to **O(V)** stack space in the worst case.

So overall:

**O(V + E)**

Since the graph can have up to `O(V²)` edges, this can become **O(V²)**.

## Key Takeaway

The main thing I want to remember here is:

> **Number of provinces = number of connected components.**

So whenever I see a problem where nodes are grouped into separate connected groups, I should think:

```text
Graph
 ↓
Connected Components
 ↓
DFS / BFS
```

And the simple way to count them is:

```text
for every node:
    if not visited:
        count++
        DFS/BFS from it
```

Each new DFS means I have discovered one completely new component.
