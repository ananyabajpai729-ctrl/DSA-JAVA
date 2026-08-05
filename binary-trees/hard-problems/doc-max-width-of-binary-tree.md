# Maximum Width of Binary Tree

## Problem Statement

Given the root of a binary tree, return the **maximum width** among all levels of the tree.

The width of a level is calculated as the distance between the leftmost and rightmost non-null nodes, **including the null nodes that would exist between them** in a complete binary tree.

---

## Intuition

If we simply count the number of nodes at each level, we'll get the wrong answer because missing nodes also contribute to the width.

For example,

```text
        1
       / \
      2   3
     /     \
    4       7
```

The last level has only two nodes (`4` and `7`), but its width is actually **4** because the missing positions between them are counted.

To handle this, we imagine the tree as if it were stored in an array like a complete binary tree.

Every node gets an index:

```text
Root = 0

Left Child  = 2*i + 1

Right Child = 2*i + 2
```

Now the width of any level simply becomes:

```text
lastIndex - firstIndex + 1
```

Since width is calculated level by level, **BFS** is the most natural traversal.

---

## Approach

Create a queue that stores:

- the current node
- its index in the imaginary complete binary tree

Start by pushing:

```text
(root, 0)
```

Perform a normal Level Order Traversal.

For every level:

- Record the index of the first node.
- Normalize all indices by subtracting this minimum index.
- Store the normalized index of the first and last node.
- Push the children using:

```text
Left  → 2 * index + 1

Right → 2 * index + 2
```

After processing the level,

```text
width = last - first + 1
```

Update the maximum width.

The normalization step is important because the indices can become extremely large in deep trees.

---

## Dry Run

**Input**

```text
        1
       / \
      2   3
     /     \
    4       7
```

---

### Level 0

Queue:

```text
(1,0)
```

Width:

```text
0 - 0 + 1 = 1
```

---

### Level 1

Children:

```text
2 → 1

3 → 2
```

Queue:

```text
(2,1)

(3,2)
```

Width:

```text
2 - 1 + 1 = 2
```

---

### Level 2

Children:

```text
4 → 3

7 → 6
```

Queue:

```text
(4,3)

(7,6)
```

Normalize indices:

```text
minIndex = 3

4 → 0

7 → 3
```

Width:

```text
3 - 0 + 1 = 4
```

Maximum width:

```text
4
```

---

## Why Normalize the Indices?

Imagine a highly skewed tree.

The indices grow like:

```text
0

2

6

14

30

62
```

After many levels, these values can exceed the range of an integer.

However, while calculating the width of a level, we only care about the **relative distance** between nodes.

So we subtract the first index of the level from every node:

```java
currIndex = p.idx - minIndex;
```

Now every level starts from zero:

```text
0

1

2

...
```

This prevents integer overflow while keeping the width calculation unchanged.

---

## Time Complexity

- **Time:** `O(n)`

  Every node is visited exactly once.

- **Space:** `O(n)`

  In the worst case, the queue stores an entire level of the tree.

---

## Key Takeaway

The clever part of this problem isn't the BFS—it's assigning **imaginary indices** to the nodes.

Instead of thinking about the actual tree, imagine placing it inside a complete binary tree.

```text
Root

↓

Index 0

↓

Left = 2i + 1

Right = 2i + 2
```

Once every node has an index, finding the width becomes as simple as:

```text
lastIndex - firstIndex + 1
```

Another subtle but important optimization is **index normalization**. Although the absolute indices can become extremely large in deep trees, the width only depends on the distance between nodes at the same level. By resetting the first node's index to zero at every level, we avoid overflow without affecting the final answer.

I found this problem interesting because it combines two ideas—a standard level order traversal and the indexing scheme of a complete binary tree—to solve something that initially looks much more complicated.
