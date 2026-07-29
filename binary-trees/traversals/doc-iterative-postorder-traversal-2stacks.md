# Binary Tree Postorder Traversal (Iterative - Two Stacks)

## Problem Statement

Given the root of a binary tree, return its **postorder traversal**.

In postorder traversal, nodes are visited in the following order:

```text
Left → Right → Root
```

The challenge here is to perform the traversal **iteratively**, without using recursion.

---

## Intuition

Postorder is the trickiest DFS traversal to implement iteratively because a node can only be visited **after both of its children have been processed**.

Instead of trying to directly produce:

```text
Left → Right → Root
```

we use a clever trick.

First, generate the order:

```text
Root → Right → Left
```

Then reverse it.

Reversing gives:

```text
Left → Right → Root
```

To achieve this efficiently:

- **Stack 1** is used to traverse the tree.
- **Stack 2** stores the nodes in reverse postorder.
- Finally, popping everything from Stack 2 produces the required postorder traversal.

---

## Approach

1. If the tree is empty, return an empty list.
2. Push the root into **Stack 1**.
3. While Stack 1 is not empty:
   - Pop a node from Stack 1.
   - Push it into Stack 2.
   - Push its **left child** into Stack 1.
   - Push its **right child** into Stack 1.
4. Once Stack 1 becomes empty:
   - Pop every node from Stack 2.
   - Add its value to the answer.
5. The resulting order is the postorder traversal.

---

## Why Push Left Before Right?

Since a stack follows **Last In, First Out (LIFO)**:

```text
Push Left

↓

Push Right

↓

Right gets processed first
```

So Stack 1 processes nodes in:

```text
Root → Right → Left
```

Stack 2 reverses this order automatically, producing:

```text
Left → Right → Root
```

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

Initial:

```text
Stack 1

[1]

Stack 2

[]
```

---

### Step 1

Pop `1`.

Push into Stack 2.

Push left and right into Stack 1.

```text
Stack 1

[2,3]

Stack 2

[1]
```

---

### Step 2

Pop `3`.

Push into Stack 2.

```text
Stack 1

[2]

Stack 2

[1,3]
```

---

### Step 3

Pop `2`.

Push into Stack 2.

Push `4` and `5`.

```text
Stack 1

[4,5]

Stack 2

[1,3,2]
```

---

### Step 4

Pop `5`.

```text
Stack 2

[1,3,2,5]
```

---

### Step 5

Pop `4`.

```text
Stack 2

[1,3,2,5,4]
```

---

Now Stack 1 is empty.

Pop everything from Stack 2:

```text
4

5

2

3

1
```

Final answer:

```text
[4,5,2,3,1]
```

---

## Stack Visualization

```text
Stack 1              Stack 2

[1]                  []

↓

[]                   [1]

↓

[2,3]                [1]

↓

[2]                  [1,3]

↓

[4,5]                [1,3,2]

↓

[]                   [1,3,2,5,4]

↓

Pop Stack 2

↓

[4,5,2,3,1]
```

---

## Time Complexity

- **Time:** `O(n)`

  Every node is pushed and popped once from each stack.

- **Space:** `O(n)`

  Two stacks together may store all nodes in the worst case.

---

## Key Takeaway

The two-stack approach works because it transforms a difficult traversal into an easier one.

Instead of directly producing:

```text
Left → Right → Root
```

we first generate:

```text
Root → Right → Left
```

using Stack 1.

Then Stack 2 reverses this sequence automatically:

```text
Root → Right → Left

↓

Reverse

↓

Left → Right → Root
```

A simple way to remember it is:

> **First build the traversal in reverse, then let the second stack flip it into the correct postorder sequence.**

Although there is also a more space-efficient **one-stack iterative solution**, the two-stack approach is much easier to understand and is a great stepping stone before learning the optimized version.
