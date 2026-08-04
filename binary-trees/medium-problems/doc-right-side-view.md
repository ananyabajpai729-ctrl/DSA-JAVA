# Binary Tree Right Side View

## Problem Statement

Given the root of a binary tree, imagine yourself standing on its right side.

Return the values of the nodes that are visible from top to bottom.

---

## Intuition

The key observation is that for every level of the tree, we only need **one node**—the first node that would be visible from the right side.

Instead of traversing the tree level by level, we can use **DFS** with a small trick:

- Visit the **right child first**.
- Then visit the left child.

This way, the first node we encounter at every level is guaranteed to be the rightmost node of that level.

To keep track of whether we've already visited a particular level, we compare the current level with the size of the answer list.

If:

```text
ans.size() == currentLevel
```

it means this is the **first node** we've reached at this depth, so it belongs in the right side view.

---

## Approach

Create an empty answer list.

Perform a DFS starting from the root with level `0`.

For every node:

- If the node is `null`, return.
- If the current level equals the size of the answer list, add the node's value.
- Visit the right subtree.
- Then visit the left subtree.

Since the right subtree is always explored first, the first node encountered at every level is exactly the node visible from the right side.

Finally, return the answer list.

---

## Dry Run

**Input**

```text
        1
       / \
      2   3
       \   \
        5   4
```

---

### Start

Visit:

```text
1
```

Level:

```text
0
```

Answer:

```text
[1]
```

---

### Go Right

Visit:

```text
3
```

Level:

```text
1
```

Answer:

```text
[1,3]
```

---

### Go Right Again

Visit:

```text
4
```

Level:

```text
2
```

Answer:

```text
[1,3,4]
```

---

### Backtrack

Visit:

```text
2
```

Level:

```text
1
```

Level 1 already has a node.

Ignore it.

---

Visit:

```text
5
```

Level:

```text
2
```

Level 2 already has a node.

Ignore it.

---

Final Answer:

```text
[1,3,4]
```

---

## Time Complexity

- **Time:** `O(n)`

  Every node is visited exactly once.

- **Space:** `O(h)`

  Due to the recursion stack, where `h` is the height of the tree.

---

## Key Takeaway

The trick in this problem isn't the DFS itself—it's the **order of traversal**.

Normally, preorder traversal follows:

```text
Root

↓

Left

↓

Right
```

Here, we simply swap the order:

```text
Root

↓

Right

↓

Left
```

Because of this, the first node encountered at every depth is always the rightmost node.

I also found the condition

```java
if(ans.size() == level)
```

quite elegant. Instead of maintaining a separate set or map to track visited levels, the answer list itself tells us whether we've already recorded a node for that depth. If the current level hasn't been reached before, this must be the first—and therefore the visible—node from the right side.
