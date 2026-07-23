# Jump Game

## Problem Statement

You are given an integer array `nums` where each element represents the **maximum jump length** from that position.

Determine whether you can reach the **last index** starting from the first index.

Return `true` if it is possible; otherwise, return `false`.

---

## Intuition

Instead of thinking about **where to jump next**, think about **how far you can currently reach**.

As you traverse the array, keep track of the **farthest index** that can be reached so far.

- If you arrive at an index that is **beyond** this reachable range, it means you were never able to reach that position, so the answer is immediately `false`.
- Otherwise, update the farthest reachable index using the current jump length.

If you successfully process the entire array, then the last index is reachable.

---

## Approach

- Initialize:
  - `limit = 0` → the farthest reachable index.
- Traverse the array from left to right.
- For each index:
  - If `i > limit`, return `false` because this position cannot be reached.
  - Otherwise, update:

```text
limit = max(limit, i + nums[i])
```

- If the traversal finishes, return `true`.

---

## Dry Run

**Input:**

```text
nums = [2,3,1,1,4]
```

Processing:

```text
Initially

limit = 0

----------------

i = 0

Reach = 0 + 2 = 2

limit = 2

----------------

i = 1

Reach = 1 + 3 = 4

limit = 4

----------------

i = 2

Already reachable

limit remains 4

----------------

i = 3

Still reachable

----------------

i = 4

Reached the last index ✓
```

Output:

```text
true
```

---

### Another Example

**Input:**

```text
nums = [3,2,1,0,4]
```

Processing:

```text
limit = 3

Reach index 3

nums[3] = 0

limit stays 3

Next index = 4

4 > limit

Cannot reach index 4
```

Output:

```text
false
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Key Takeaway

The greedy idea is:

> **At every position, remember only the farthest index you can reach.**

You never need to simulate individual jumps or explore multiple paths.

A single variable (`limit`) captures all the information you need.

A useful way to think about it is:

```text
Reachable Range

0 -------- limit
```

As long as your current index stays within this range, you can continue expanding it.

The moment you encounter:

```text
i > limit
```

you've found a position that was never reachable, so there's no way to reach the end either.

This "farthest reachable index" pattern is one of the most common greedy techniques for array traversal problems.
