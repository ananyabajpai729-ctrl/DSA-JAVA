# Root to Leaf Paths

## Problem Statement

Given the root of a binary tree, return all possible paths from the root to every leaf node.

Each path should contain the sequence of node values encountered from the root to a leaf.

---

## Intuition

Every root-to-leaf path can be viewed as one journey through the tree.

As we move down the tree, we keep adding the current node to our path.

Eventually, we'll reach a leaf node. At that point, the current path represents one complete answer, so we store it.

However, after exploring one branch, we need to return and explore another one. This means we must remove the last node before going back to the parent.

This is a classic **Backtracking** pattern:

```text
Choose

↓

Explore

↓

Undo the choice
```

---

## Approach

Create an answer list to store all the paths.

Maintain another list called `path` that represents the current path from the root to the current node.

Perform a DFS.

For every node:

- If the node is `null`, return.
- Add the current node to the path.
- If it is a leaf node:
  - Store a copy of the current path in the answer.
- Otherwise:
  - Explore the left subtree.
  - Explore the right subtree.
- Before returning to the parent, remove the last node from the path.

Finally, return the answer.

---

## Dry Run

**Input**

```text
        1
       / \
      2   3
       \
        5
```

---

Start:

```text
Path:

[1]
```

---

Go Left

```text
Path:

[1,2]
```

---

Go Right

```text
Path:

[1,2,5]
```

Node `5` is a leaf.

Store:

```text
[1,2,5]
```

Backtrack:

```text
Path:

[1,2]
```

Backtrack again:

```text
Path:

[1]
```

---

Go Right

```text
Path:

[1,3]
```

Node `3` is a leaf.

Store:

```text
[1,3]
```

Final Answer:

```text
[
 [1,2,5],
 [1,3]
]
```

---

## Time Complexity

- **Time:** `O(n)`

  Every node is visited exactly once. Copying the path at each leaf contributes additional work proportional to the path length, so the total complexity is often expressed as `O(n + L × h)`, where `L` is the number of leaf nodes and `h` is the height of the tree.

- **Space:** `O(h)`

  Due to the recursion stack and the current path list, where `h` is the height of the tree.

  (The output list is not included in the auxiliary space.)

---

## Key Takeaway

This problem introduced me to one of the most common recursion patterns: **Backtracking**.

The recursive function maintains a single path throughout the traversal.

```text
Add current node

↓

Explore children

↓

Remove current node
```

The last step is the most important.

If we don't remove the current node before returning, the path from one branch would incorrectly carry over into another branch.

Another subtle point is that when we reach a leaf, we store:

```java
new ArrayList<>(path)
```

instead of simply storing `path`.

This creates a copy of the current path. Otherwise, every answer would point to the same list, and later modifications during backtracking would change all the stored paths as well.

This problem helped me understand that recursion isn't just about moving forward—it's equally about **cleanly undoing your choices while returning**, which is exactly what backtracking is all about.
