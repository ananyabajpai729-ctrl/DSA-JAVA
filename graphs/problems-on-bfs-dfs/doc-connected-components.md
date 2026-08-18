# Number of Connected Components in an Undirected Graph

## Problem Statement

We are given `V` vertices and a list of edges.

We need to find how many connected components are present in the graph.

A connected component is basically a group of nodes where we can reach every node from the other nodes in that group.

## Pattern

**Graph + DFS + Connected Components**

## Intuition

This is basically the same idea as the previous **Number of Provinces** problem.

I just need to find how many separate groups of nodes are present.

So I can go through every node and check:

> Have I already visited this node?

If yes, then it belongs to a component I already explored.

If no, then this must be a new component.

So I increase the count and run DFS from that node.

The DFS will visit all the nodes connected to it.

So:

```text
unvisited node
      ↓
  count++
      ↓
    DFS
      ↓
visit the whole component
```

## Approach

First, I create an adjacency list for all `V` nodes:

```java
List<List<Integer>> adj = new ArrayList<>();

for(int i = 0; i < V; i++){
    adj.add(new ArrayList<>());
}
```

Then I go through the given edges.

For every edge:

```text
[u, v]
```

I add `v` to `u`'s list and `u` to `v`'s list because the graph is undirected.

```java
adj.get(u).add(v);
adj.get(v).add(u);
```

After building the graph, I create a `visited` array.

Then I check every node:

```java
for(int i = 0; i < V; i++){
    if(!vis[i]){
        count++;
        dfs(adj, i, vis);
    }
}
```

Whenever I find an unvisited node, I know that I have found a new connected component.

The DFS then visits the entire component so that I don't count it again.

## DFS

The DFS is simple:

```java
private void dfs(List<List<Integer>> adj, int node, boolean[] vis){
    vis[node] = true;

    for(int neighbour : adj.get(node)){
        if(!vis[neighbour]){
            dfs(adj, neighbour, vis);
        }
    }
}
```

First mark the current node as visited.

Then visit all its unvisited neighbours.

Because DFS keeps going through neighbours, it eventually reaches every node connected to the starting node.

## Dry Run

Suppose we have:

```text
V = 6

Edges:
[0,1]
[1,2]
[3,4]
```

The graph looks like:

```text
0 --- 1 --- 2

3 --- 4

5
```

So there are three components:

```text
{0, 1, 2}
{3, 4}
{5}
```

Initially:

```text
count = 0
```

Start with node `0`.

It is unvisited, so:

```text
count = 1
```

DFS visits:

```text
0 → 1 → 2
```

Now `0`, `1`, and `2` are all visited.

Next, `1` and `2` are skipped because they are already visited.

Then we reach node `3`.

It is unvisited:

```text
count = 2
```

DFS visits:

```text
3 → 4
```

Finally, node `5` is unvisited:

```text
count = 3
```

It has no neighbours, so DFS just visits `5`.

Final answer:

```text
3
```

## Time Complexity

Building the adjacency list takes **O(E)** because we go through every edge once.

DFS visits every vertex and every edge once:

**O(V + E)**

So the total time complexity is:

**O(V + E)**

## Space Complexity

The adjacency list stores all the edges:

**O(V + E)**

The `vis` array takes:

**O(V)**

The recursion stack can also go up to `O(V)` in the worst case.

So overall:

**O(V + E)**

## Key Takeaway

The main thing to remember is:

> **Every time I start DFS from an unvisited node, I have found one new connected component.**

The general pattern is:

```text
for every node:
    if not visited:
        count++
        DFS/BFS
```

The DFS itself isn't counting anything.

It is just making sure that **every node belonging to that component gets marked visited**, so I don't count the same component again.
