# Diameter of Binary Tree

## Problem Statement

Given the root of a binary tree, return the **diameter** of the tree.

The diameter of a binary tree is the **length of the longest path between any two nodes**. This path may or may not pass through the root.

The length of a path is measured by the **number of edges** between the two nodes.

---

## Intuition

The longest path passing through any node is formed by:

- The deepest path in its left subtree.
- The deepest path in its right subtree.

If we know the heights of both subtrees, then the diameter passing through that node is simply:

```text
leftHeight + rightHeight
```

Since every node can potentially be the highest point of the longest path, we compute this value for every node and keep the maximum.

The good news is that while computing the height of each subtree, we already have all the information needed to update the diameter. So, both tasks can be completed in a **single DFS traversal**.

---

## Approach

Create a recursive helper function that returns the height of a subtree.

For every node:

1. If the node is `null`, return `0`.
2. Recursively compute the height of the left subtree.
3. Recursively compute the height of the right subtree.
4. The longest path passing through the current node is:

```text
leftHeight + rightHeight
```

5. Update the global diameter if this path is longer than the current maximum.
6. Return the height of the current subtree:

```text
1 + max(leftHeight, rightHeight)
```

After traversing the entire tree, the stored diameter is the answer.

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

### Leaf Nodes

```text
4

Height = 1

Diameter through node = 0
```

```text
5

Height = 1

Diameter through node = 0
```

```text
3

Height = 1

Diameter through node = 0
```

---

### Node 2

```text
Left Height = 1

Right Height = 1

Diameter through node = 2

Height = 2
```

Current diameter:

```text
2
```

---

### Root 1

```text
Left Height = 2

Right Height = 1

Diameter through node = 3

Height = 3
```

Maximum diameter:

```text
3
```

Output:

```text
3
```

The longest path is:

```text
4 → 2 → 1 → 3
```

which contains **3 edges**.

---

## Recursive Call Flow

```text
height(node)

│

├── Compute left height

│

├── Compute right height

│

├── Diameter through node

│      = leftHeight + rightHeight

│

├── Update global diameter

│

└── Return

1 + max(leftHeight, rightHeight)
```

Notice that the height is returned to the parent, while the diameter is updated independently as a side effect.

---

## Time Complexity

- **Time:** `O(n)`

  Every node is visited exactly once.

- **Space:** `O(h)`

  Where `h` is the height of the tree due to the recursive call stack.

- Best case (balanced tree): `O(log n)`
- Worst case (skewed tree): `O(n)`

---

## Key Takeaway

The diameter is **not necessarily the height of the tree**, nor does it always pass through the root.

Instead, every node asks:

> **"If I were the highest point of the longest path, how long would that path be?"**

The answer is simply:

```text
Longest path through node

=

Left Height

+

Right Height
```

As the recursion computes heights from the leaves upward, each node gets the information it needs to evaluate its own contribution to the diameter.

```text
Leaves return heights

↓

Parents compute their heights

↓

Each parent updates the longest path seen so far

↓

Root finishes with the maximum diameter
```

A common pattern in tree problems is to let recursion **return one piece of information** (here, the height) while simultaneously **updating another global answer** (the diameter). This allows both computations to be completed in a single traversal instead of making repeated passes over the tree.
