# Find the Duplicate Number

## Problem Statement

Given an array `nums` containing `n + 1` integers where each integer is in the range `[1, n]`, return the duplicate number.

The duplicate may appear more than once, but there is only one duplicate value.

You must solve the problem **without modifying the array** and using **constant extra space**.

---

## Intuition

The brilliant trick in this problem is to stop thinking of `nums` as an array.

Instead, think of each index as a node, where the value at that index tells you where to go next.

```text
next = nums[current]
```

For example:

```text
nums = [1,3,4,2,2]

Index:  0 → 1 → 3 → 2 → 4
                   ↑     ↓
                   └─────┘
```

Since there are `n + 1` indices but only `n` possible values, two indices must point to the same value.

This creates a **cycle**.

Once we recognize the array as a linked structure with a cycle, we can apply **Floyd's Tortoise and Hare Algorithm**.

The duplicate number is exactly the **entry point of the cycle**.

---

## Approach

### Phase 1: Detect the Cycle

- Initialize:
  - `slow = nums[0]`
  - `fast = nums[0]`
- Move:
  - `slow` one step at a time.
  - `fast` two steps at a time.
- Continue until both pointers meet inside the cycle.

### Phase 2: Find the Cycle Entrance

- Reset `slow` back to the beginning.
- Keep `fast` at the meeting point.
- Move both pointers one step at a time.
- The node where they meet again is the duplicate number.

---

## Dry Run

**Input:**

```text
nums = [1,3,4,2,2]
```

Visualizing the array:

```text
0 → 1 → 3 → 2 → 4
          ↑     ↓
          └─────┘
```

### Phase 1

```text
slow = 1

fast = 1

----------------

slow = 3

fast = 2

----------------

slow = 2

fast = 2

Pointers meet ✓
```

### Phase 2

```text
Reset slow = nums[0] = 1

fast stays at 2

----------------

slow = 3

fast = 4

----------------

slow = 2

fast = 2

Meet at 2
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

This is one of the most famous applications of **Floyd's Cycle Detection Algorithm** outside linked lists.

The key observation is:

```text
Index → nums[index]
```

Every index points to exactly one next index, effectively creating a linked structure.

Because there are **`n + 1` indices but only `n` possible destinations**, a cycle is guaranteed to exist.

The duplicate number is precisely the **entry point of that cycle**.

A useful interview habit is to ask yourself:

> *"Can this array be interpreted as a graph where every node has exactly one outgoing edge?"*

If yes, there's a good chance that **Floyd's Tortoise and Hare Algorithm** can solve the problem in constant extra space.
