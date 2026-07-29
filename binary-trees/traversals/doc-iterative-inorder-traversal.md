# Binary Tree Inorder Traversal (Iterative)

## Problem Statement

Given the root of a binary tree, return its **inorder traversal**.

In inorder traversal, nodes are visited in the following order:

```text
Left → Root → Right
```

The challenge here is to perform the traversal **iteratively**, without using recursion.

---

## Intuition

In the recursive solution, the function keeps calling itself on the left child until it reaches the leftmost node. While doing so, the recursive call stack remembers every ancestor so it can return to them later.

In the iterative approach, we replace this **implicit recursion stack** with an **explicit stack**.

The idea is simple:

> **Keep moving left while storing every node you pass.**

Once there is no left child left to explore:

- Visit the most recent ancestor.
- Then move to its right subtree.
- Repeat the same process.

---

## Approach

1. Create an empty stack.
2. Start with the root node.
3. Repeat until both the current node is `null` and the stack becomes empty:
   - If the current node exists:
     - Push it onto the stack.
     - Move to its left child.
   - Otherwise:
     - Pop the top node from the stack.
     - Visit it by adding its value to the answer.
     - Move to its right child.
4. Continue until there are no nodes left to process.

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

Initial:

```text
Current = 1

Stack = []
```

---

### Step 1

Push `1`.

```text
Stack

[1]
```

Move left.

```text
Current = null
```

---

### Step 2

Current is null.

Pop `1`.

Visit it.

```text
Answer

[1]
```

Move to right child.

```text
Current = 2
```

---

### Step 3

Push `2`.

```text
Stack

[2]
```

Move left.

```text
Current = 3
```

---

### Step 4

Push `3`.

```text
Stack

[2,3]
```

Move left.

```text
Current = null
```

---

### Step 5

Pop `3`.

Visit it.

```text
Answer

[1,3]
```

Move right.

```text
Current = null
```

---

### Step 6

Pop `2`.

Visit it.

```text
Answer

[1,3,2]
```

Traversal complete.

---

## Stack Visualization

```text
Move Left

Current = 1

Stack

[1]

↓

Move Left

Current = null

↓

Pop 1

Visit

↓

Move Right

Current = 2

↓

Push 2

↓

Push 3

↓

Pop 3

Visit

↓

Pop 2

Visit
```

The stack stores the ancestors while we explore the leftmost path.

---

## Time Complexity

- **Time:** `O(n)`

  Every node is pushed and popped exactly once.

- **Space:** `O(n)`

  In the worst case (a skewed tree), the stack may contain all nodes.

---

## Key Takeaway

The iterative inorder traversal mimics recursion using a stack.

The process always follows this cycle:

```text
Go Left

↓

Visit Node

↓

Go Right
```

A useful mental model is:

> **Keep walking left and remember every node you pass. When you can't go left anymore, backtrack to the most recent node, visit it, and then explore its right subtree.**

Unlike iterative preorder, where we visit a node immediately after popping it, inorder **delays visiting** a node until its entire left subtree has been processed.

This is why the stack is essential—it remembers all the nodes waiting to be visited after their left subtree is finished.
