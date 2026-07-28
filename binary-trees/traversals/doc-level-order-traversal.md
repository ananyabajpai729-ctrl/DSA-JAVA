# Binary Tree Level Order Traversal

## Problem Statement

Given the root of a binary tree, return the **level order traversal** of its nodes' values.

The nodes should be grouped level by level, starting from the root.

---

## Intuition

Unlike DFS traversals (Preorder, Inorder and Postorder), where we explore one branch completely before moving to another, here we need to visit the tree **level by level**.

This is exactly what **Breadth-First Search (BFS)** is designed for.

A **queue** naturally fits this traversal because it follows the **First In, First Out (FIFO)** principle:

- The first node discovered at a level is the first one to be processed.
- As we process nodes, we add their children to the queue, which automatically become the next level to process.

---

## Approach

1. If the tree is empty, return an empty list.
2. Create a queue and insert the root node.
3. While the queue is not empty:
   - Store the current queue size.
   - This represents the number of nodes in the current level.
   - Process exactly these many nodes:
     - Remove a node from the queue.
     - Add its value to the current level.
     - Push its left child (if present).
     - Push its right child (if present).
4. After processing all nodes of the current level, add the level to the final answer.
5. Continue until the queue becomes empty.

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

Initial queue:

```text
[3]
```

---

### Level 1

Process one node.

```text
Remove 3

Level = [3]

Add 9

Add 20
```

Queue:

```text
[9,20]
```

Answer:

```text
[[3]]
```

---

### Level 2

Process two nodes.

```text
Remove 9

Level = [9]

----------------

Remove 20

Level = [9,20]

Add 15

Add 7
```

Queue:

```text
[15,7]
```

Answer:

```text
[[3],

[9,20]]
```

---

### Level 3

Process two nodes.

```text
Remove 15

Level = [15]

----------------

Remove 7

Level = [15,7]
```

Queue:

```text
[]
```

Final answer:

```text
[[3],

[9,20],

[15,7]]
```

---

## Queue Visualization

```text
Initial

[3]

↓

Process 3

↓

[9,20]

↓

Process 9 and 20

↓

[15,7]

↓

Process 15 and 7

↓

[]
```

Notice how the queue always contains the **next level** waiting to be processed.

---

## Time Complexity

- **Time:** `O(n)`

  Every node is inserted into and removed from the queue exactly once.

- **Space:** `O(n)`

  In the worst case, the queue may contain all nodes of the widest level of the tree.

---

## Key Takeaway

Level Order Traversal is simply **Breadth-First Search (BFS)** applied to a binary tree.

The most important observation is:

> At any point, the queue contains exactly the nodes of the current level (and gradually fills with the next level).

By storing the queue's size before processing a level,

```text
size = queue.size()
```

we know exactly how many nodes belong to that level, allowing us to group them together.

Unlike DFS, which explores:

```text
Root

↓

Left

↓

Left...

```

BFS explores:

```text
Level 0

↓

Level 1

↓

Level 2

↓

...
```

Whenever you encounter phrases like:

- **Level order**
- **Shortest path in an unweighted graph**
- **Minimum number of moves**
- **Nearest neighbour**
- **Nodes at distance K**

you should immediately think of **BFS using a queue**.
