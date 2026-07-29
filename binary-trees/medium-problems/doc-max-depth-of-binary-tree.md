# Maximum Depth of Binary Tree

## Problem Statement

Given the root of a binary tree, return its **maximum depth**.

The maximum depth is the number of nodes along the longest path from the root down to the farthest leaf node.

---

## Intuition

The depth of a node depends entirely on the depths of its left and right subtrees.

For any node, we ask:

> **"What is the deepest path starting from me?"**

The answer is simply:

- Find the maximum depth of the left subtree.
- Find the maximum depth of the right subtree.
- Take the larger one and include the current node.

Since every subtree is itself a binary tree, the same question can be solved recursively.

---

## Approach

Create a recursive function `maxDepth()`.

For every node:

1. If the node is `null`, return `0`.
2. Recursively compute the depth of the left subtree.
3. Recursively compute the depth of the right subtree.
4. Return:

```text
1 + max(leftDepth, rightDepth)
```

The `+1` accounts for the current node itself.

---

## Dry Run

**Input:**

```text
        3
       / \
      9   20
         /  \
        15   7
```

Start from the leaves.

### Leaf Nodes

```text
9

Left = 0

Right = 0

Depth = 1
```

```text
15

Depth = 1
```

```text
7

Depth = 1
```

---

### Node 20

```text
Left Depth = 1

Right Depth = 1

Depth = 1 + max(1,1)

= 2
```

---

### Root 3

```text
Left Depth = 1

Right Depth = 2

Depth = 1 + max(1,2)

= 3
```

Final answer:

```text
3
```

---

## Recursive Call Flow

```text
maxDepth(3)

│

├── maxDepth(9)

│      ├── null → 0

│      ├── null → 0

│      └── return 1

│

└── maxDepth(20)

       │

       ├── maxDepth(15)

       │      return 1

       │

       ├── maxDepth(7)

       │      return 1

       │

       └── return 2

↓

return 3
```

Notice how recursion computes the answer **from the bottom up**.

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

The height (or depth) of a tree is a classic **divide-and-conquer** problem.

Every node solves the same smaller problem:

```text
"What is the height of my left subtree?"

"What is the height of my right subtree?"
```

Then combines the answers:

```text
Height = 1 + max(leftHeight, rightHeight)
```

You can visualize the computation as information flowing upward:

```text
Leaves

↓

Height = 1

↓

Parents compute using children

↓

Root computes the final answer
```

Whenever a tree problem asks for the **maximum**, **minimum**, or any property that depends on both subtrees, think recursively—let each subtree compute its own answer first, then combine the results at the current node.
