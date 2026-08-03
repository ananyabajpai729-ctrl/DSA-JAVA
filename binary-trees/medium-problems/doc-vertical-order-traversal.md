# Vertical Order Traversal of a Binary Tree

## Problem Statement

Given the root of a binary tree, return its **vertical order traversal**.

For every node:

- The root starts at coordinates `(0, 0)`.
- The left child is at `(x - 1, y + 1)`.
- The right child is at `(x + 1, y + 1)`.

The output should follow these rules:

1. Columns are ordered from left to right.
2. Within the same column, nodes are ordered from top to bottom.
3. If multiple nodes share the same position `(x, y)`, they should be sorted by their value.

---

## Intuition

The first challenge is that every node now has **coordinates** instead of just a level.

While traversing the tree, every node needs to remember:

- its vertical column (`x`)
- its level (`y`)

This naturally suggests using **Level Order Traversal (BFS)**, because BFS already visits nodes level by level.

However, simply storing nodes column-wise isn't enough.

Suppose two nodes end up at exactly the same position:

```text
      1
     / \
    2   3
     \ /
      5 4
```

Both `5` and `4` lie at `(0,2)`.

The answer should be:

```text
[4,5]
```

instead of the order in which BFS visits them.

That is why a **Priority Queue** is used for every `(vertical, level)` pair.

---

## Approach

Maintain three pieces of information for every node:

- the node itself
- its vertical index (`x`)
- its level (`y`)

using the custom `Pair` class.

Perform a normal BFS.

For every node:

- Insert it into a nested `TreeMap`.

The structure becomes:

```text
Vertical

↓

Level

↓

Priority Queue of node values
```

Specifically,

```text
TreeMap

↓

TreeMap

↓

PriorityQueue
```

This ensures:

- verticals remain sorted
- levels remain sorted
- nodes at the same position remain sorted by value

After BFS finishes:

- Traverse the outer TreeMap (columns).
- Traverse each inner TreeMap (levels).
- Remove every element from the PriorityQueue.
- Build one column at a time.

Finally return the answer.

---

## Dry Run

**Input**

```text
        3
       / \
      9   20
         /  \
        15   7
```

Coordinates:

```text
        (0,0)

      /       \

 (-1,1)      (1,1)

            /      \

        (0,2)    (2,2)
```

---

### BFS

Store:

```text
Vertical -1

↓

Level 1

↓

9
```

---

```text
Vertical 0

↓

Level 0

↓

3

↓

Level 2

↓

15
```

---

```text
Vertical 1

↓

Level 1

↓

20
```

---

```text
Vertical 2

↓

Level 2

↓

7
```

---

Reading the TreeMaps from left to right gives:

```text
[
 [9],
 [3,15],
 [20],
 [7]
]
```

---

### Example with Same Position

```text
        1
       / \
      2   3
       \ /
        5 4
```

Coordinates:

```text
5 → (0,2)

4 → (0,2)
```

Priority Queue stores:

```text
4

5
```

instead of

```text
5

4
```

So the final vertical traversal remains correctly sorted.

---

## Data Structure Used

```text
TreeMap<Vertical,

    TreeMap<Level,

        PriorityQueue<Node Values>

    >

>
```

Each layer solves one sorting requirement.

- TreeMap (Outer) → Vertical ordering
- TreeMap (Inner) → Level ordering
- PriorityQueue → Value ordering for identical positions

---

## Time Complexity

- **Time:** `O(n log n)`

  Every node is inserted into ordered data structures (`TreeMap` and `PriorityQueue`), each requiring logarithmic time.

- **Space:** `O(n)`

  The queue and nested maps together store every node exactly once.

---

## Key Takeaway

This problem is less about tree traversal and more about **choosing the right data structure**.

The BFS itself is straightforward.

The real challenge is satisfying all three ordering rules simultaneously:

```text
Column

↓

Level

↓

Node Value
```

Instead of sorting everything at the end, the nested data structure maintains these orderings automatically during traversal.

One thing I found interesting is that each layer of the data structure has a single responsibility:

```text
TreeMap
→ keeps columns sorted

↓

TreeMap
→ keeps levels sorted

↓

PriorityQueue
→ keeps nodes with identical coordinates sorted
```

Once I understood why each structure existed, the implementation became much easier to reason about.
