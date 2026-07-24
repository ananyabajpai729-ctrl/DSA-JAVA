# Jump Game II

## Problem Statement

You are given an integer array `nums` where each element represents the **maximum jump length** from that position.

Return the **minimum number of jumps** required to reach the last index.

It is guaranteed that the last index is always reachable.

---

## Intuition

Unlike **Jump Game I**, where we only checked whether the end was reachable, here we want to reach it using the **fewest jumps**.

A tempting approach is to always jump to the farthest possible index. However, that isn't always optimal.

Instead, think of each jump as giving you a **range of indices** that you can explore.

Within the current range, keep track of the farthest position you could reach with the **next jump**.

Once you've explored the entire current range, you **must** make another jump. At that moment, jump to the farthest reachable position you've discovered.

This is exactly like a **Breadth First Search (BFS)** on the array, except we don't explicitly use a queue.

---

## Approach

- Maintain three variables:
  - `currentEnd` → the farthest index reachable using the current number of jumps.
  - `farthest` → the farthest index reachable while exploring the current range.
  - `jumps` → number of jumps taken.
- Traverse the array until the second last element:
  - Update `farthest` using:

```text
farthest = max(farthest, i + nums[i])
```

- If the current index reaches `currentEnd`:
  - We've explored every position reachable with the current jump.
  - Increment the jump count.
  - Extend the range by setting:

```text
currentEnd = farthest
```

- Return the total number of jumps.

---

## Dry Run

**Input:**

```text
nums = [2,3,1,1,4]
```

Processing:

```text
Initially

jumps = 0

currentEnd = 0

farthest = 0

----------------

i = 0

farthest = 2

Reached currentEnd

Jump = 1

currentEnd = 2

----------------

i = 1

farthest = 4

----------------

i = 2

farthest = 4

Reached currentEnd

Jump = 2

currentEnd = 4
```

The last index is now within the reachable range.

Output:

```text
2
```

---

### Another Example

```text
nums = [2,3,0,1,4]
```

Processing:

```text
Jump 1

Reach up to index 2

----------------

While exploring indices 1 and 2

Farthest becomes 4

----------------

Jump 2

Reach the last index
```

Output:

```text
2
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Key Takeaway

The important insight is that **we don't decide the next jump immediately**.

Instead, every jump gives us a **window of reachable indices**.

```text
Current Jump

|-----------|

Explore every index here

↓

Find the farthest possible position

↓

Take the next jump only after finishing this window
```

Think of it like expanding levels in **BFS**:

- One jump lets you reach all indices in the current range.
- While exploring that range, you determine the range for the next jump.
- When you finish the current level (`i == currentEnd`), you've exhausted all possibilities for the current jump, so you increment the jump count.

This greedy strategy guarantees the minimum number of jumps because each jump is delayed until you've explored every option available within the current reachable range.
