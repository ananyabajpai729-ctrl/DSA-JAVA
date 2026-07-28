# Binary Tree Traversals in One Iteration

## Problem Statement

Given the root of a binary tree, return all three traversals:

- **Inorder** (Left → Root → Right)
- **Preorder** (Root → Left → Right)
- **Postorder** (Left → Right → Root)

The challenge is to generate **all three traversals in a single traversal of the tree**, instead of performing three separate DFS traversals.

---

## Intuition

Normally, we write three recursive functions:

- One for preorder
- One for inorder
- One for postorder

Each traversal visits the same node at a different stage of recursion.

Think about what happens during recursion for a node:

```text
Enter node

↓

Visit left subtree

↓

Visit right subtree

↓

Return
```

A node is actually encountered **three different times** during recursion:

1. **Before** exploring the left subtree → Preorder
2. **After** finishing the left subtree → Inorder
3. **After** finishing the right subtree → Postorder

Instead of using recursion, we can explicitly store this "stage" of each node in a stack.

---

## Approach

Maintain a stack containing:

```text
(Node, State)
```

where:

- State `1` → First visit (Preorder)
- State `2` → Second visit (Inorder)
- State `3` → Third visit (Postorder)

### State 1

When a node is seen for the first time:

- Add it to **Preorder**
- Push the same node back with state `2`
- Traverse its left child next

---

### State 2

After returning from the left subtree:

- Add it to **Inorder**
- Push the same node back with state `3`
- Traverse its right child

---

### State 3

After returning from the right subtree:

- Add it to **Postorder**

The node is now completely processed.

---

## Dry Run

Consider:

```text
        1
       / \
      2   3
```

Initially:

```text
Stack

[(1,1)]
```

---

### Pop (1,1)

Preorder:

```text
[1]
```

Push:

```text
(1,2)

(2,1)
```

Stack:

```text
[(1,2),(2,1)]
```

---

### Pop (2,1)

Preorder:

```text
[1,2]
```

Push:

```text
(2,2)
```

---

### Pop (2,2)

Inorder:

```text
[2]
```

Push:

```text
(2,3)
```

---

### Pop (2,3)

Postorder:

```text
[2]
```

---

### Pop (1,2)

Inorder:

```text
[2,1]
```

Push:

```text
(1,3)

(3,1)
```

---

### Pop (3,1)

Preorder:

```text
[1,2,3]
```

---

### Pop (3,2)

Inorder:

```text
[2,1,3]
```

---

### Pop (3,3)

Postorder:

```text
[2,3]
```

---

### Pop (1,3)

Postorder:

```text
[2,3,1]
```

Final traversals:

```text
Preorder

[1,2,3]

----------------

Inorder

[2,1,3]

----------------

Postorder

[2,3,1]
```

---

## Time Complexity

- **Time:** `O(n)`

  Every node is pushed and popped exactly three times (a constant factor), so the overall complexity remains linear.

- **Space:** `O(n)`

  Used by the stack in the worst case (skewed tree).

---

## Key Takeaway

The key insight is that **recursive DFS naturally visits each node three times**:

```text
            Node

        (1) Enter

            │
            ▼

        Left Subtree

            │
            ▼

      (2) Back Again

            │
            ▼

       Right Subtree

            │
            ▼

      (3) Final Exit
```

These three moments correspond exactly to:

```text
State 1 → Preorder

State 2 → Inorder

State 3 → Postorder
```

By storing the traversal **state** along with each node in the stack, we can simulate recursion and compute **all three traversals in a single pass**.

This is a classic example of replacing the **implicit recursion stack** with an **explicit stack**, while preserving the order in which recursive calls would have been executed.
