# Binary Tree Preorder Traversal

## Problem Statement

Given the root of a binary tree, return its **preorder traversal**.

In preorder traversal, nodes are visited in the following order:

```text
Root → Left → Right
```

---

## Intuition

The name itself tells us the order:

> **Visit the current node first, then recursively explore its left subtree, followed by its right subtree.**

Every subtree is itself a binary tree, so the exact same logic applies recursively.

This makes preorder traversal a natural fit for recursion.

---

## Approach

Create a recursive helper function.

For every node:

1. If the node is `null`, return.
2. Visit the current node by adding its value to the answer.
3. Traverse the left subtree.
4. Traverse the right subtree.

The recursion automatically ensures that every subtree is processed in preorder.

---

## Dry Run

**Input:**

```text
        1
         \
          2
         /
        3
```

Processing:

```text
Start at 1

Visit 1

↓

Go Left

null

↓

Go Right

2

Visit 2

↓

Go Left

3

Visit 3

↓

Left = null

↓

Right = null
```

Preorder traversal:

```text
[1,2,3]
```

---

### Recursive Call Flow

```text
helper(1)

Visit 1

│

├── helper(null)

│

└── helper(2)

      Visit 2

      │

      ├── helper(3)

      │      Visit 3

      │

      └── helper(null)
```

---

## Time Complexity

- **Time:** `O(n)`

  Every node is visited exactly once.

- **Space:** `O(h)`

  Where `h` is the height of the tree.

- Best case (balanced tree): `O(log n)`
- Worst case (skewed tree): `O(n)`

---

## Key Takeaway

Preorder traversal always follows one simple rule:

```text
Root

↓

Left

↓

Right
```

Think of recursion as asking every node to perform the same three steps:

```text
Visit yourself

↓

Tell your left child to do the same

↓

Tell your right child to do the same
```

Since every subtree follows the same pattern, recursion naturally traverses the entire tree in preorder without requiring any additional data structures.
