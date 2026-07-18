# Linked List Cycle

## Problem Statement

Given the `head` of a singly linked list, determine whether the linked list contains a cycle.

Return `true` if a cycle exists, otherwise return `false`.

---

## Intuition

Imagine two runners on a circular track.

- One runner (**Turtle**) moves one step at a time.
- The other runner (**Hare**) moves two steps at a time.

If there is **no cycle**, the faster runner will eventually reach the end of the list.

If there **is** a cycle, the faster runner will eventually lap the slower one, meaning both pointers will point to the same node.

This idea is known as **Floyd's Cycle Detection Algorithm** or the **Tortoise and Hare Algorithm**.

---

## Approach

- Initialize two pointers:
  - `turtle` moves one node at a time.
  - `hare` moves two nodes at a time.
- Continue traversing while `hare` and `hare.next` are not `null`.
- In each iteration:
  - Move `turtle` one step.
  - Move `hare` two steps.
- If both pointers ever point to the same node, a cycle exists.
- If the faster pointer reaches the end of the list, there is no cycle.

---

## Dry Run

**Input:**

```text
3 → 2 → 0 → -4
     ↑       ↓
     └───────┘
```

Processing:

```text
Initially

Turtle = 3

Hare = 3

----------------

Step 1

Turtle = 2

Hare = 0

----------------

Step 2

Turtle = 0

Hare = 2

----------------

Step 3

Turtle = -4

Hare = -4

Pointers meet ✓
```

Output:

```text
true
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Key Takeaway

This problem introduces one of the most elegant linked list algorithms: **Floyd's Cycle Detection**.

The idea isn't specific to linked lists—it works whenever two pointers move at different speeds.

A simple way to remember it is:

- 🐢 **Turtle** moves **1 step**.
- 🐇 **Hare** moves **2 steps**.

If a cycle exists, the hare is guaranteed to catch the turtle inside the loop. If no cycle exists, the hare simply reaches the end of the list.

Whenever a linked list problem asks you to detect a cycle without using extra memory, this should be your first thought.
