# Detect Cycle in a Directed Graph - BFS

## Problem Statement

We are given a directed graph and need to check whether it contains a cycle.

Return `true` if a cycle exists, otherwise return `false`.

## Pattern

**BFS + Indegree + Kahn's Algorithm**

## Intuition

This is basically the same Kahn's Algorithm I used for topological sort.

The difference is that here I don't actually care about the topological order.

I only care about **how many nodes I am able to process**.

The idea is:

- Find all nodes with indegree `0`.
- Put them into the queue.
- Process them and reduce the indegree of their neighbours.
- Whenever a neighbour becomes `0`, put it into the queue.

If there is no cycle, eventually I should be able to process **all `V` nodes**.

But if there is a cycle, the nodes inside that cycle will always have some incoming edge from another node in the cycle.

So their indegree will never become `0`.

That means they will never enter the queue.

## Approach

First, I calculate the indegree of every node.

Then I put all nodes with:

`indegree == 0`

into the queue.

I keep processing the queue.

Every time I remove a node, I increase `index`.

So `index` basically tells me:

> How many nodes have I successfully processed?

For every neighbour of the current node, I decrease its indegree.

If its indegree becomes `0`, I add it to the queue.

At the end:

- If `index == V` → all nodes were processed → no cycle.
- If `index != V` → some nodes were left behind → cycle exists.

That's why the final line is:

`return index != V`

## Dry Run

Consider a graph with a cycle:

    0 → 1 → 2
        ↑     |
        |_____|

The indegrees are:

    0 → 0
    1 → 2
    2 → 1

Only `0` has indegree `0`.

So:

`Queue = [0]`

Process `0`.

Its neighbour `1` has its indegree reduced:

`2 → 1`

But it still isn't `0`.

So `1` doesn't enter the queue.

The queue is now empty.

We only processed:

`index = 1`

But:

`V = 3`

So:

`index != V`

Therefore, there is a cycle.

## What Happens Without a Cycle?

Consider:

    0 → 1 → 2

Indegrees:

    0 → 0
    1 → 1
    2 → 1

Start with:

`Queue = [0]`

Process `0`.

Indegree of `1` becomes `0`.

    Queue = [1]

Process `1`.

Indegree of `2` becomes `0`.

    Queue = [2]

Process `2`.

Now:

`index = 3`

and:

`V = 3`

So:

`index == V`

No cycle exists.

## Why Does This Detect a Cycle?

The important observation is:

> A cycle prevents its nodes from ever having indegree `0`.

For example:

    0 → 1
    ↑   ↓
    └───2

Every node in the cycle depends on another node in the same cycle.

So there is no starting node with indegree `0` inside the cycle.

Kahn's Algorithm gets stuck there.

## Why Use `index`?

I don't actually need to store the topological order.

I only need to know how many nodes were processed.

So instead of an answer array, I just use:

`index`

Every time a node is removed from the queue:

`index++`

At the end, I compare it with `V`.

## Time Complexity

**O(V + E)**

Calculating all the indegrees takes `O(V + E)`.

Then BFS processes every vertex and edge at most once.

## Space Complexity

**O(V + E)** if counting the adjacency list as part of the graph representation.

The extra space used by the algorithm itself is **O(V)**:

- `indegree[]` → `O(V)`
- queue → `O(V)`

So:

**Total space: O(V + E)**  
**Auxiliary space: O(V)**

## Key Takeaway

This is basically:

**Kahn's Algorithm + one observation**

If I can process all `V` nodes:

`index == V → no cycle`

If some nodes are left unprocessed:

`index != V → cycle exists`

So the pattern to remember is:

`indegree 0 → BFS → reduce indegrees → count processed nodes`

and finally:

`processed nodes < V → cycle`
