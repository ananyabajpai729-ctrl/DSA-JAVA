# Job Sequencing Problem

## Problem Statement

You are given a list of jobs, where each job has:

- A unique ID
- A deadline
- A profit

Each job takes **exactly one unit of time** to complete.

Only one job can be performed at a time, and a job must be completed **on or before its deadline**.

Return:

- The maximum number of jobs that can be completed.
- The maximum profit that can be earned.

---

## Intuition

The first instinct might be to perform jobs in the order of their deadlines.

However, that doesn't always maximize profit.

The greedy observation is:

> **Always try to perform the most profitable jobs first.**

But there's another challenge:

Even after choosing a profitable job, **where should we place it?**

The answer is:

> **Schedule it as late as possible before its deadline.**

Why?

If we finish a job earlier than necessary, we unnecessarily occupy an earlier time slot that could have been used by another job with a tighter deadline.

Scheduling profitable jobs as late as possible keeps earlier slots available for future jobs.

---

## Approach

- Sort all jobs in **descending order of profit**.
- Find the maximum deadline to determine the timeline.
- Create a `schedule[]` array where each index represents one unit of time.
- Initially, every slot is empty (`-1`).
- Process jobs one by one:
  - Starting from the job's deadline, move backwards.
  - Find the latest free slot.
  - If one exists:
    - Schedule the job.
    - Increase the job count.
    - Add its profit.
- Return both the total number of scheduled jobs and the total profit.

---

## Dry Run

**Input:**

```text
Jobs

ID  Deadline  Profit

1      4        20

2      1        10

3      1        40

4      1        30
```

After sorting by profit:

```text
Job 3

Profit = 40

Deadline = 1

----------------

Job 4

Profit = 30

Deadline = 1

----------------

Job 1

Profit = 20

Deadline = 4

----------------

Job 2

Profit = 10

Deadline = 1
```

Scheduling:

```text
Time

1 2 3 4

----------------

Job 3

Slot 1 is free

Schedule it

----------------

Job 4

Slot 1 occupied

Cannot schedule

----------------

Job 1

Slot 4 is free

Schedule it

----------------

Job 2

Slot 1 occupied

Cannot schedule
```

Final schedule:

```text
Time

1 → Job 3

4 → Job 1
```

Output:

```text
Jobs Completed = 2

Profit = 60
```

---

## Time Complexity

- **Time:** `O(n log n + n × D)`

Where:

- `n` = number of jobs
- `D` = maximum deadline

- `O(n log n)` for sorting.
- In the worst case, each job may scan backward through all available time slots.

- **Space:** `O(D)`

Used for the scheduling array.

---

## Key Takeaway

This problem uses **two greedy ideas together**:

1. **Pick the highest-profit jobs first.**
2. **Schedule each selected job as late as possible before its deadline.**

The second idea is just as important as the first.

Suppose a job has deadline `5`.

Instead of scheduling it at time `1`:

```text
❌

1 2 3 4 5

J _ _ _ _
```

schedule it at the **latest possible slot**:

```text
✅

1 2 3 4 5

_ _ _ _ J
```

This preserves earlier slots for jobs that **must** finish sooner.

A useful interview clue is:

> Whenever you see **deadlines + profits + one task at a time**, think of **sorting by profit** and **placing each job in the latest available slot**.
