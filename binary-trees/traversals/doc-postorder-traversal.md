# Binary Tree Postorder Traversal

## Problem Statement

Given the root of a binary tree, return its **postorder traversal**.

In postorder traversal, nodes are visited in the following order:

```text
Left → Right → Root
```

---

## Intuition

Postorder is the opposite of preorder in one important aspect:

> **The current node is visited only after both of its subtrees have been completely processed.**

Think of it as a bottom-up traversal.

A node waits for its left child to finish, then its right child, and only then does it add itself to the answer.

Since every subtree follows the same rule, recursion is the most natural approach.

---

## Approach

Create a recursive helper function.

For every node:

1. If the node is `null`, return.
2. Traverse the left subtree.
3. Traverse the right subtree.
4. Visit the current node by adding its value to the answer.

Because the node is processed last, the traversal naturally becomes **Left → Right → Root**.

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

↓

Go Left

null

↓

Go Right

2

↓

Go Left

3

↓

Go Left

null

↓

Go Right

null

↓

Visit 3

↓

Back to 2

↓

Go Right

null

↓

Visit 2

↓

Back to 1

↓

Visit 1
```

Postorder traversal:

```text
[3,2,1]
```

---

### Recursive Call Flow

```text
helper(1)

│

├── helper(null)

│

└── helper(2)

      │

      ├── helper(3)

      │      │

      │      ├── helper(null)

      │      ├── helper(null)

      │      └── Visit 3

      │

      ├── helper(null)

      │

      └── Visit 2

↓

Visit 1
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

Postorder traversal always follows:

```text
Left

↓

Right

↓

Root
```

Unlike preorder and inorder, the current node is processed **only after both children are completely finished**.

You can think of every node saying:

```text
"Let my left subtree finish.

Then let my right subtree finish.

Only then will I visit myself."
```

This bottom-up nature makes postorder especially useful for problems where a parent depends on information from its children, such as:

- Deleting an entire tree
- Computing subtree heights
- Calculating subtree sums
- Evaluating expression trees
- Dynamic programming on trees

A good way to remember the three DFS traversals is:

```text
Preorder  : Root → Left → Right

Inorder   : Left → Root → Right

Postorder : Left → Right → Root
```

The only thing that changes is **when the current node is processed** during the recursive call.
