# Course Schedule II

## Problem Statement

We have `numCourses` courses and some prerequisites.

For example:

`[1, 0]`

means:

`0 → 1`

So I have to finish course `0` before course `1`.

This time, instead of just checking whether all courses can be finished, I have to return a valid order in which I can take them.

If it is impossible because of a cycle, return an empty array.

## Pattern

**Topological Sort + BFS + Indegree (Kahn's Algorithm)**

## Intuition

This is basically the same idea as **Course Schedule**.

There, I only needed to answer:

> Can I finish all the courses?

Here I need the actual order.

So instead of just counting how many courses I process, I put every processed course into `ans`.

A course with indegree `0` has no pending prerequisites, so I can take it.

After taking it, I reduce the indegree of all courses that depend on it.

Whenever one of those courses reaches indegree `0`, it is ready too.

So the queue keeps giving me courses that I can take next.

## Approach

First, I build the graph.

For every prerequisite:

`[a, b]`

I add:

`b → a`

because `b` has to be completed before `a`.

I also increase:

`indegree[a]`

Then I put all courses with indegree `0` into the queue.

Now I start BFS.

For every course I take from the queue:

1. Put it into `ans`.
2. Increase `index`.
3. Go through all courses depending on it.
4. Decrease their indegree.
5. If a course reaches indegree `0`, add it to the queue.

At the end, I check `index`.

If:

`index == numCourses`

then every course was processed, so `ans` contains a valid order.

Otherwise, some courses were never processed, which means there is a cycle.

In that case I return an empty array.

## Dry Run

Suppose:

`numCourses = 4`

and:

`prerequisites = [[1,0], [2,0], [3,1], [3,2]]`

The graph is:

    0 → 1 → 3
    ↓       ↑
    2 ──────┘

Initial indegrees:

    0 → 0
    1 → 1
    2 → 1
    3 → 2

Only `0` has indegree `0`.

So:

`Queue = [0]`

Take `0`.

    ans = [0]

Now indegrees of `1` and `2` become `0`.

    Queue = [1, 2]

Take `1`.

    ans = [0, 1]

Its neighbour is `3`.

`indegree[3]` goes from `2 → 1`.

Take `2`.

    ans = [0, 1, 2]

Now `3`'s indegree becomes:

`1 → 0`

So `3` enters the queue.

Take `3`.

    ans = [0, 1, 2, 3]

Now:

`index == numCourses`

so this is a valid answer.

## What If There Is a Cycle?

Suppose:

    0 → 1
    ↑   ↓
    └───2

The courses inside the cycle can never reach indegree `0`.

So they never enter the queue.

At the end, `index` will be smaller than `numCourses`.

For example:

`index = 1`

`numCourses = 3`

Therefore:

`index != numCourses`

and I return:

`new int[0]`

## Why Does the Order Work?

Whenever I put a course into `ans`, its indegree is `0`.

That means all of its prerequisites have already been processed.

So putting it next in the answer is safe.

This is basically what topological sorting guarantees:

If:

`b → a`

then `b` will appear before `a` in the answer.

## Time Complexity

**O(V + E)**

Where:

- `V` = number of courses
- `E` = number of prerequisites

Building the graph takes `O(V + E)` and the BFS processes every course and edge at most once.

## Space Complexity

**O(V + E)**

The adjacency list stores the `E` prerequisite edges, along with `V` lists.

The other structures take `O(V)`:

- `indegree[]` → `O(V)`
- queue → `O(V)`
- answer array → `O(V)`

So overall:

**O(V + E)**

## Key Takeaway

This is the same pattern as **Course Schedule**, except now I actually keep the processed nodes.

The thought process is:

`Prerequisites → Directed Graph`

`No prerequisites → indegree 0`

`indegree 0 → put in queue`

`Process → reduce neighbours' indegree`

`indegree becomes 0 → ready for the queue`

And finally:

`processed all courses → return the order`

`couldn't process all → cycle → return empty array`
