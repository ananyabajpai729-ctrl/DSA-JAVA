# Average Waiting Time (Shortest Job First)

## Problem Statement

You are given an array `bt[]` where `bt[i]` represents the burst time (execution time) of the `i-th` process.

All processes arrive at the same time.

Return the **average waiting time** if the processes are executed using the **Shortest Job First (SJF)** scheduling algorithm.

---

## Intuition

Since every process arrives at the same time, the only thing that affects the waiting time is **the order in which we execute them**.

If a long process is executed first, every process behind it has to wait longer.

To minimise the total waiting time, the greedy choice is:

> **Always execute the shortest available process first.**

This prevents short jobs from getting stuck behind long ones, resulting in the minimum possible average waiting time.

---

## Approach

- Sort the burst times in increasing order.
- Maintain:
  - `waitingTime` → cumulative waiting time before the current process.
  - `sum` → total waiting time of all processes.
- Traverse the sorted array:
  - Add the previous process's burst time to `waitingTime`.
  - Add `waitingTime` to the total sum.
- Compute:

```text
Average Waiting Time = Total Waiting Time / Number of Processes
```

Return its floor value.

---

## Dry Run

**Input:**

```text
bt = [4, 3, 7, 1]
```

After sorting:

```text
[1, 3, 4, 7]
```

Processing:

```text
Process 1

Waiting = 0

Total = 0

----------------

Process 2

Waiting = 1

Total = 1

----------------

Process 3

Waiting = 1 + 3 = 4

Total = 5

----------------

Process 4

Waiting = 4 + 4 = 8

Total = 13
```

Average waiting time:

```text
13 / 4 = 3.25

Floor = 3
```

Output:

```text
3
```

---

## Time Complexity

- **Time:** `O(n log n)`

  Sorting dominates the complexity.

- **Space:** `O(1)`

  Ignoring the space used by the sorting algorithm.

---

## Key Takeaway

This is the classic **Shortest Job First (SJF)** greedy algorithm.

The greedy decision is simple:

> **Finish the smallest job first so that fewer processes spend time waiting.**

Imagine two jobs:

```text
10  2
```

If you execute them as:

```text
10 → 2
```

Waiting times are:

```text
0, 10

Total = 10
```

But if you execute:

```text
2 → 10
```

Waiting times become:

```text
0, 2

Total = 2
```

The second order is clearly better.

This idea extends naturally to any number of processes: **sorting by burst time always minimises the total (and therefore average) waiting time when all processes arrive together.**
