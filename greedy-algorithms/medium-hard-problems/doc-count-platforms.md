# Minimum Platforms

## Problem Statement

Given the arrival and departure times of `n` trains, determine the **minimum number of platforms** required at the railway station so that no train has to wait.

A platform becomes free only after a train departs.

If a train arrives at the exact time another train departs, **a new platform is still required** (i.e., `arrival <= departure` is considered overlapping).

---

## Intuition

Instead of tracking which train occupies which platform, think about **how many trains are present at the station at any moment**.

Every:

- **Arrival** increases the number of occupied platforms.
- **Departure** decreases the number of occupied platforms.

If we process all events in chronological order, the **maximum number of trains present simultaneously** is exactly the minimum number of platforms required.

Sorting the arrival and departure times separately allows us to simulate this efficiently using two pointers.

---

## Approach

- Sort both:
  - `Arrival[]`
  - `Departure[]`
- Maintain two pointers:
  - `i` → next arriving train.
  - `j` → next departing train.
- Keep a variable `count` representing the number of platforms currently occupied.
- Traverse both arrays:
  - If the next train arrives **before or at** the earliest departure:
    - One more platform is occupied.
    - Increment `count`.
    - Move the arrival pointer.
  - Otherwise:
    - A train departs and frees a platform.
    - Decrement `count`.
    - Move the departure pointer.
- After every event, update the maximum value of `count`.
- Return this maximum.

---

## Dry Run

**Input:**

```text
Arrival   = [900, 940, 950, 1100, 1500, 1800]

Departure = [910, 1200, 1120, 1130, 1900, 2000]
```

After sorting:

```text
Arrival

900 940 950 1100 1500 1800

Departure

910 1120 1130 1200 1900 2000
```

Processing:

```text
900 arrives

Platforms in use = 1

Maximum = 1

----------------

910 departs

Platforms in use = 0

----------------

940 arrives

Platforms in use = 1

----------------

950 arrives

Platforms in use = 2

----------------

1100 arrives

Platforms in use = 3

Maximum = 3

----------------

1120 departs

Platforms in use = 2

...
```

The maximum number of occupied platforms at any point is:

```text
3
```

Output:

```text
3
```

---

## Time Complexity

- **Time:** `O(n log n)`

  Sorting the arrival and departure arrays dominates the complexity.

- **Space:** `O(1)`

  Ignoring the space used by the sorting algorithm.

---

## Key Takeaway

The greedy insight is:

> **Process events in chronological order instead of assigning platforms individually.**

Each event changes only one thing:

- Arrival → one more platform needed.
- Departure → one platform becomes free.

The answer is simply the **maximum number of trains present simultaneously**.

This "sort both arrays + two pointers" technique is common in interval overlap problems, such as:

- Minimum Platforms
- Meeting Rooms
- Maximum Overlapping Intervals
- Employee Scheduling

---

## Note

Your logic is correct, but the initialization can be made cleaner.

Instead of:

```java
int platforms = 1;
int count = 0;
```

you can simply write:

```java
int platforms = 0;
int count = 0;
```

The first arrival will increase `count` to `1`, and `platforms` will naturally become `1`. This avoids relying on an initial value and makes the implementation a bit more intuitive.
