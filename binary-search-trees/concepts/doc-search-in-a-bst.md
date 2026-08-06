# Search in a Binary Search Tree

## Problem Statement

Given the root of a Binary Search Tree (BST) and an integer `val`, return the subtree rooted at the node whose value equals `val`.

If such a node does not exist, return `null`.

---

## Intuition

The biggest advantage of a Binary Search Tree is that we don't need to search every node.

A BST follows a simple property:

```text
Left Subtree  < Root < Right Subtree
```

So whenever we're standing at a node, there are only three possibilities:

- If the current node's value is equal to the target, we've found the answer.
- If the target is smaller, it can only exist in the left subtree.
- If the target is larger, it can only exist in the right subtree.

This allows us to eliminate half of the tree at every step, making the search much faster than searching a normal binary tree.

---

## Approach

Start from the root.

At every node:

- If the node is `null`, the value doesn't exist in the tree.
- If the current node's value equals the target, return the current node.
- If the target is smaller than the current node's value, recursively search the left subtree.
- Otherwise, recursively search the right subtree.

The recursion stops as soon as the value is found or the search reaches a `null` node.

---

## Dry Run

**Input**

```text
        4
      /   \
     2     7
    / \
   1   3
```

Target:

```text
2
```

---

### Step 1

Current node:

```text
4
```

Since

```text
2 < 4
```

move to the left subtree.

---

### Step 2

Current node:

```text
2
```

Target found.

Return the subtree rooted at `2`.

```text
    2
   / \
  1   3
```

---

### Example 2

Target:

```text
5
```

Traversal:

```text
4

↓

7

↓

null
```

Since the search reaches a `null` node, the value doesn't exist.

Return:

```text
null
```

---

## Time Complexity

- **Time:** `O(h)`

  where `h` is the height of the tree.

  - Best/Average Case (balanced BST): `O(log n)`
  - Worst Case (skewed BST): `O(n)`

- **Space:** `O(h)`

  Due to the recursion stack.

---

## Key Takeaway

The power of a Binary Search Tree lies in its ordering property.

Instead of checking every node like a normal binary tree, we use one comparison to decide which entire subtree can be ignored.

```text
Target < Current

↓

Go Left
```

```text
Target > Current

↓

Go Right
```

```text
Target == Current

↓

Answer Found
```

I liked how clean this solution is. Every recursive call reduces the search space by half in a balanced BST, making the search extremely efficient. It's a great example of how maintaining a special tree structure can significantly improve search operations.
