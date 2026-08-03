# Top View of Binary Tree

## Problem Statement

Given the root of a binary tree, return the **Top View** of the binary tree.

The top view consists of the first node visible at every vertical column when the tree is viewed from above.

---

## Intuition

This problem is much simpler once you realize that it is based on **vertical columns**.

Similar to Vertical Order Traversal, every node belongs to a particular vertical line.

```text
Left Child  → line - 1

Root        → line

Right Child → line + 1
```

Since we need the **topmost** node in every vertical line, **Level Order Traversal (BFS)** immediately comes to mind.

The first time we visit a particular vertical line during BFS, we are guaranteed to be at the smallest level for that line. Any node encountered later in the same column will always lie below it and therefore cannot be part of the top view.

So the idea is simple:

- Traverse level by level.
- Keep track of each node's vertical line.
- If this vertical line hasn't been seen before, store the node.
- Otherwise, ignore it.

I liked this problem because it felt like a simplified version of Vertical Order Traversal. There was no need for nested maps or priority queues anymore—just remembering the **first node** for every column was enough.

---

## Approach

Create an answer list.

If the tree is empty, return it immediately.

Maintain:

- A queue storing the node along with its vertical line.
- A TreeMap mapping each vertical line to its first visible node.

Push the root with vertical line `0`.

Perform BFS.

For every node:

- Remove it from the queue.
- If its vertical line is not already present in the map, store the node value.
- Push the left child with `line - 1`.
- Push the right child with `line + 1`.

After the traversal, the TreeMap already stores the columns from left to right.

Simply iterate through its values and build the final answer.

---

## Dry Run

**Input**

```text
        1
       / \
      2   3
       \
        4
         \
          5
```

Vertical lines:

```text
        0

     -1    1

       0

        1
```

---

### BFS

Visit:

```text
1 (line 0)
```

Store:

```text
0 → 1
```

---

Visit:

```text
2 (line -1)
```

Store:

```text
-1 → 2
```

---

Visit:

```text
3 (line 1)
```

Store:

```text
1 → 3
```

---

Visit:

```text
4 (line 0)
```

Line `0` already exists.

Ignore it.

---

Visit:

```text
5 (line 1)
```

Line `1` already exists.

Ignore it.

---

Final TreeMap:

```text
-1 → 2

 0 → 1

 1 → 3
```

Answer:

```text
[2,1,3]
```

---

## Time Complexity

- **Time:** `O(n log n)`

  Every node is processed once, and each insertion into the `TreeMap` takes `O(log n)`.

- **Space:** `O(n)`

  The queue and map together store at most all the nodes.

---

## Key Takeaway

The important realization in this problem is that **BFS naturally gives us the topmost node first**.

Since BFS processes nodes level by level, the first node encountered for any vertical line is guaranteed to be visible from the top.

That means we don't need to keep every node in a column like we did in Vertical Order Traversal.

Instead, we simply remember:

```text
First node seen in each vertical line

↓

Ignore every other node in that line
```

I also noticed how similar this problem is to Vertical Order Traversal. The only difference is that there we had to preserve **every node** in sorted order, whereas here we only care about the **first** one. Once that clicked, the solution became much cleaner.
