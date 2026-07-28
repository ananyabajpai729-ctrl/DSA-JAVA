# Binary Tree Inorder Traversal

## Problem Statement

Given the root of a binary tree, return its **inorder traversal**.

In inorder traversal, nodes are visited in the following order:

```text
Left → Root → Right
```

---

## Intuition

Unlike preorder, where we visit the node immediately, inorder waits until the **entire left subtree has been processed**.

The idea is simple:

> **Explore everything on the left first, then visit the current node, and finally explore the right subtree.**

Since every subtree is itself a binary tree, we recursively apply the same rule at every node.

---

## Approach

Create a recursive helper function.

For every node:

1. If the node is `null`, return.
2. Traverse the left subtree.
3. Visit the current node by adding its value to the answer.
4. Traverse the right subtree.

The recursion ensures that all nodes are visited in **Left → Root → Right** order.

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

Visit 1

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

Visit 3

↓

Go Right

null

↓

Back to 2

↓

Visit 2
```

Inorder traversal:

```text
[1,3,2]
```

---

### Recursive Call Flow

```text
helper(1)

│

├── helper(null)

│

├── Visit 1

│

└── helper(2)

      │

      ├── helper(3)

      │      │

      │      ├── helper(null)

      │      ├── Visit 3

      │      └── helper(null)

      │

      ├── Visit 2

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

Inorder traversal follows a single rule:

```text
Left

↓

Root

↓

Right
```

The important idea is that **the current node waits** until its entire left subtree has been processed.

Think of each node as saying:

```text
"First let my left child finish,

then I'll visit myself,

and finally I'll let my right child take over."
```

One interesting property of inorder traversal is that for a **Binary Search Tree (BST)**, it visits the nodes in **sorted (ascending) order**. This is why inorder traversal is frequently used in BST-related problems.
