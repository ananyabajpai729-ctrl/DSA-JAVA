# Maximum Meetings in One Room

## Problem Statement

You are given two arrays:

- `start[]` where `start[i]` is the start time of the `i-th` meeting.
- `end[]` where `end[i]` is the end time of the `i-th` meeting.

Only one meeting can be conducted in the room at a time.

Return the **maximum number of meetings** that can be accommodated.

---

## Intuition

The goal is to fit as many meetings as possible into a single room.

A natural thought might be to choose the meeting that starts first or the meeting with the shortest duration. Unfortunately, neither strategy always produces the optimal answer.

The greedy insight is:

> **Always pick the meeting that finishes the earliest.**

A meeting that ends earlier frees up the room sooner, leaving the maximum possible time for future meetings.

Once we've committed to a meeting, choosing the one with the earliest finishing time never hurts our chances of scheduling more meetings later.

---

## Approach

- Create a list containing each meeting's:
  - End time
  - Start time
  - Original index (not needed for counting, but useful if the problem asks for the meeting order).
- Sort the meetings by their end times.
- Maintain:
  - `lastEnd` → ending time of the last selected meeting.
  - `count` → number of meetings selected.
- Traverse the sorted meetings:
  - If the current meeting starts **strictly after** the last selected meeting ends (`start > lastEnd`):
    - Select the meeting.
    - Increment the count.
    - Update `lastEnd`.

Finally, return the total count.

---

## Dry Run

**Input:**

```text
start = [1,3,0,5,8,5]

end   = [2,4,6,7,9,9]
```

After sorting by end time:

```text
(1,2)

(3,4)

(0,6)

(5,7)

(8,9)

(5,9)
```

Processing:

```text
Choose (1,2)

Count = 1

lastEnd = 2

----------------

Choose (3,4)

Count = 2

lastEnd = 4

----------------

Skip (0,6)

Starts before the previous meeting finishes.

----------------

Choose (5,7)

Count = 3

lastEnd = 7

----------------

Choose (8,9)

Count = 4

lastEnd = 9

----------------

Skip (5,9)
```

Output:

```text
4
```

---

## Time Complexity

- **Time:** `O(n log n)`

  Sorting the meetings dominates the running time.

- **Space:** `O(n)`

  Used to store the meeting information.

---

## Key Takeaway

This is one of the most classic **Greedy** problems.

The important observation is:

> **A meeting that finishes earlier gives you more opportunities to schedule future meetings.**

That's why sorting by **end time** leads to the optimal solution.

A quick checklist for interval scheduling problems:

- Earliest starting meeting ❌
- Shortest meeting ❌
- Earliest finishing meeting ✅

Whenever you're asked to maximize the number of non-overlapping intervals, this greedy strategy should be your first instinct.
