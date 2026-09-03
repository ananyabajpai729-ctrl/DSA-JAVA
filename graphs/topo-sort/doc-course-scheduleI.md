# Course Schedule

## Problem Statement

We have `numCourses` courses.

The `prerequisites` array tells us which course has to be completed before another course.

For example:

`[1, 0]`

means:

`0 → 1`

So course `0` needs to be completed before course `1`.

We need to check whether it is possible to finish all the courses.

If there is a cycle in the prerequisite graph, then some courses will always be waiting for each other, so we can't finish everything.

## Pattern

**Topological Sort + BFS + Indegree**

## Intuition

This is basically the same idea as detecting a cycle in a directed graph using Kahn's Algorithm.

The courses are the nodes.

The prerequisites are the directed edges.

For:

`[a, b]`

we have:

`b → a`

because `b` has to be done before `a`.

Now I can use indegree.

A course with indegree `0` has no pending prerequisites, so I can take that course first.

After taking it, I remove its effect from the courses that depend on it.

If all courses can eventually be processed, then I can finish all of them.

If some courses are left behind, there must be a cycle.

## Approach

First, I create an adjacency list.

For every prerequisite:

`[a, b]`

I add:

`b → a`

and increase:

`indegree[a]`

because course `a` has one more prerequisite.

Then I put all courses with:

`indegree == 0`

into the queue.

These are the courses I can take immediately.

Now I start BFS.

For every course I process:

- increase `index`
- look at all courses depending on it
- decrease their indegree
- if a course reaches indegree `0`, add it to the queue

At the end, I check whether I processed all courses.

`index == numCourses`

means I managed to finish every course.

Otherwise, some courses were stuck, which means there is a cycle.

## Dry Run

Suppose:

    prerequisites = [[1,0], [2,1]]

This means:

    0 → 1 → 2

Indegrees:

    0 → 0
    1 → 1
    2 → 1

So the queue starts with:

`[0]`

Process `0`.

Course `1` now has indegree `0`.

    Queue = [1]

Process `1`.

Course `2` now has indegree `0`.

    Queue = [2]

Process `2`.

Now:

`index = 3`

and:

`numCourses = 3`

So:

`index == numCourses`

Therefore, we can finish all courses.

Return:

`true`

## What If There Is a Cycle?

Suppose:

    0 → 1
    ↑   ↓
    └───2

Now every course in the cycle depends on another course in the same cycle.

None of them can reach indegree `0`.

So BFS gets stuck before processing all the courses.

For example:

`index = 1`

but:

`numCourses = 3`

Therefore:

`index != numCourses`

and we return `false`.

## Why Is the Edge `b → a`?

This part is worth remembering because it is easy to reverse it.

For:

`[a, b]`

the problem says:

> To take `a`, I first need to complete `b`.

So:

`b → a`

`b` comes first and `a` depends on it.

That's why the code does:

`adj.get(b).add(a)`

and:

`indegree[a]++`

## Why Does `index == numCourses` Matter?

I don't actually need the topological ordering here.

I only need to know whether **every course was processed**.

So `index` keeps track of how many courses I successfully processed.

If:

`index == numCourses`

then every course was possible to complete.

If:

`index < numCourses`

some courses were stuck because of a cycle.

## Time Complexity

**O(V + E)**

Here:

- `V` = number of courses
- `E` = number of prerequisites

Building the graph takes `O(V + E)` overall, and the BFS also processes every course and prerequisite edge at most once.

## Space Complexity

**O(V + E)** if we count the adjacency list.

The adjacency list stores all the prerequisite edges.

The extra space used by the algorithm is:

- `indegree[]` → `O(V)`
- queue → `O(V)`
- adjacency list → `O(V + E)`

So:

**Total Space: O(V + E)**

**Auxiliary Space: O(V + E)** if the graph itself is considered part of the data created by the solution.

## Key Takeaway

This problem is basically:

`Courses → Directed Graph`

`Prerequisite → Directed Edge`

Then:

`Indegree 0 → take course → reduce neighbours' indegrees`

Finally:

`processed courses == total courses → can finish`

So whenever I see a problem involving **prerequisites/dependencies and whether everything can be completed**, I should immediately think:

**Topological Sort / Cycle Detection**
