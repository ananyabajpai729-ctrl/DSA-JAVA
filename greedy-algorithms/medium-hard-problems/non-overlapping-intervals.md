# Non-overlapping Intervals

## Problem Statement

You are given an array of intervals.

Return the **minimum number of intervals** you need to remove so that the remaining intervals are non-overlapping.

Two intervals are considered non-overlapping if:

```text
current.start >= previous.end
```

---

## Intuition

At first, it feels like we should decide **which interval to remove** whenever two intervals overlap.

A much better way to think about it is:

> **Which interval should we keep?**

Whenever two intervals overlap, we should keep the interval that **finishes earlier**.

Why?

Because an interval that ends earlier leaves more room for future intervals, increasing our chances of fitting more intervals without conflicts.

This is the exact same greedy idea used in the **Maximum Meetings** problem.

---

## Approach

- Sort all intervals by their **ending time**.
- Assume the first interval is selected.
- Store its ending time in `end`.
- Traverse the remaining intervals:
  - If the current interval starts after or exactly when the previous selected interval ends,

```text
start >= end
```

there is no overlap.

Keep the interval and update `end`.

- Otherwise,
  - the interval overlaps,
  - remove it by increasing the answer count.

Finally, return the number of removed intervals.

---

## Dry Run

**Input:**

```text
intervals =

[[1,2],[2,3],[3,4],[1,3]]
```

After sorting by end time:

```text
[1,2]

[2,3]

[1,3]

[3,4]
```

Processing:

```text
Keep [1,2]

end = 2

----------------

[2,3]

2 >= 2

Keep

end = 3

----------------

[1,3]

1 < 3

Overlap

Remove it

Removed = 1

----------------

[3,4]

3 >= 3

Keep
```

Output:

```text
1
```

---

### Another Example

```text
intervals =

[[1,2],[1,2],[1,2]]
```

Sorted:

```text
[1,2]

[1,2]

[1,2]
```

Processing:

```text
Keep first interval.

Second overlaps.

Remove.

Third overlaps.

Remove.
```

Output:

```text
2
```

---

## Time Complexity

- **Time:** `O(n log n)`

  Sorting dominates the complexity.

- **Space:** `O(1)`

  Ignoring the space used by sorting.

---

## Key Takeaway

This problem is actually the **inverse** of interval scheduling.

Instead of asking:

> *"How many intervals can I keep?"*

it asks:

> *"How many intervals must I remove?"*

The greedy strategy remains exactly the same:

> **Always keep the interval that finishes earliest.**

Suppose two intervals overlap:

```text
A: ─────────────

B: ─────
```

Keeping **B** is always the better choice because it frees up the timeline sooner, giving future intervals a higher chance of fitting.

That's why sorting by **end time** leads to the optimal solution.

A good interview pattern to remember is:

- **Maximum Meetings**
- **Activity Selection**
- **Non-overlapping Intervals**

All three rely on the same greedy principle:

> **Choose the interval with the earliest finishing time.**
