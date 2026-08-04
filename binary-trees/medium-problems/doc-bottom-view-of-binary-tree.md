# Bottom View of Binary Tree

## Problem Statement

Given the root of a binary tree, return the **Bottom View** of the binary tree.

The bottom view consists of the last node visible at every vertical column when the tree is viewed from below.

---

## Intuition

This problem is almost identical to the **Top View** problem.

Just like before, every node belongs to a particular vertical line.

```text
Left Child  → line - 1

Root        → line

Right Child → line + 1
```

The only difference is what we store.

In Top View, we wanted the **first** node encountered for every vertical line, so we only inserted into the map if that line wasn't already present.

Here, we want the **bottommost** node. Since a Level Order Traversal (BFS) processes nodes from top to bottom, every time we encounter a node on the same vertical line, it is at the same or a lower level than the previous one.

So instead of checking whether the line already exists, we simply overwrite the value in the map.

By the end of the traversal, the map naturally contains the last node seen for every vertical line, which is exactly the bottom view.

---

## Approach

Create an answer list.

Maintain:

- A queue storing the node along with its vertical line.
- A TreeMap mapping each vertical line to its latest visible node.

Push the root with vertical line `0`.

Perform a normal BFS.

For every node:

- Remove it from the queue.
- Store its value in the TreeMap for its vertical line.
- Unlike Top View, always overwrite the existing value.
- Push the left child with `line - 1`.
- Push the right child with `line + 1`.

After the traversal, the TreeMap contains the bottommost node for every vertical line.

Iterate through the map from left to right and build the answer.

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

Map:

```text
0 → 1
```

---

Visit:

```text
2 (line -1)
```

Map:

```text
-1 → 2

 0 → 1
```

---

Visit:

```text
3 (line 1)
```

Map:

```text
-1 → 2

 0 → 1

 1 → 3
```

---

Visit:

```text
4 (line 0)
```

Overwrite:

```text
-1 → 2

 0 → 4

 1 → 3
```

---

Visit:

```text
5 (line 1)
```

Overwrite:

```text
-1 → 2

 0 → 4

 1 → 5
```

---

Final Answer:

```text
[2,4,5]
```

---

## Time Complexity

- **Time:** `O(n log n)`

  Every node is processed once, and each insertion into the `TreeMap` takes `O(log n)`.

- **Space:** `O(n)`

  The queue and map together store at most all the nodes.

---

## Key Takeaway

This problem is essentially the opposite of **Top View**.

The traversal remains exactly the same:

```text
Level Order Traversal (BFS)

↓

Track each node's vertical line

↓

Store it in a TreeMap
```

The only change is what happens when we encounter another node in the same vertical line.

- **Top View:** Keep the first node and ignore the rest.
- **Bottom View:** Keep replacing the previous node so that the last one remains.

That one small change completely changes the answer while the overall algorithm stays almost identical. I found it helpful to think of Bottom View as simply "Top View with overwriting instead of checking."
