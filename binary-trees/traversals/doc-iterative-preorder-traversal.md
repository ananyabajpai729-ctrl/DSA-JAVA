# Binary Tree Preorder Traversal (Iterative)

## Problem Statement

Given the root of a binary tree, return its **preorder traversal**.

In preorder traversal, nodes are visited in the following order:

```text
Root → Left → Right
```

The challenge here is to perform the traversal **iteratively**, without using recursion.

---

## Intuition

In the recursive solution, the call stack automatically remembers which nodes we need to visit next.

Without recursion, we need to simulate this behaviour ourselves.

A **stack** is the perfect replacement because it follows the **Last In, First Out (LIFO)** principle, just like recursive function calls.

The only subtle part is the insertion order.

Since the stack pops the most recently added element first, we must:

1. Push the **right child** first.
2. Push the **left child** afterwards.

This ensures the left child is processed before the right child, preserving the preorder sequence.

---

## Approach

1. If the tree is empty, return an empty list.
2. Create a stack and push the root node.
3. While the stack is not empty:
   - Pop the top node.
   - Visit it by adding its value to the answer.
   - Push its right child (if present).
   - Push its left child (if present).
4. Continue until the stack becomes empty.

---

## Dry Run

**Input:**

```text
        1
       / \
      2   3
     / \
    4   5
```

Initial stack:

```text
[1]
```

---

### Step 1

Pop:

```text
1
```

Answer:

```text
[1]
```

Push:

```text
Right → 3

Left → 2
```

Stack:

```text
[3,2]
```

---

### Step 2

Pop:

```text
2
```

Answer:

```text
[1,2]
```

Push:

```text
Right → 5

Left → 4
```

Stack:

```text
[3,5,4]
```

---

### Step 3

Pop:

```text
4
```

Answer:

```text
[1,2,4]
```

Stack:

```text
[3,5]
```

---

### Step 4

Pop:

```text
5
```

Answer:

```text
[1,2,4,5]
```

Stack:

```text
[3]
```

---

### Step 5

Pop:

```text
3
```

Answer:

```text
[1,2,4,5,3]
```

Stack:

```text
[]
```

Traversal complete.

---

## Stack Visualization

```text
Initial

[1]

↓

Pop 1

Push 3

Push 2

↓

[3,2]

↓

Pop 2

Push 5

Push 4

↓

[3,5,4]

↓

Pop 4

↓

[3,5]

↓

Pop 5

↓

[3]

↓

Pop 3

↓

[]
```

Notice that although **3** was pushed before **2**, the stack processes **2** first because it was pushed last.

---

## Time Complexity

- **Time:** `O(n)`

  Every node is pushed and popped exactly once.

- **Space:** `O(n)`

  In the worst case (a skewed tree), the stack may contain all nodes.

---

## Key Takeaway

The iterative preorder traversal is simply a simulation of recursive DFS using an explicit stack.

The most important trick is remembering the push order:

```text
Push Right

↓

Push Left
```

Since a stack is **Last In, First Out (LIFO)**, the left child is popped first, giving the required preorder sequence:

```text
Root

↓

Left

↓

Right
```

A simple way to remember this is:

> **Visit now, save the right child for later, and immediately continue with the left child.**

This is why we always push the **right child before the left child**.
