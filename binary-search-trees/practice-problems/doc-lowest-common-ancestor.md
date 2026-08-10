# Lowest Common Ancestor of a BST

## Problem Statement

Given the root of a Binary Search Tree (BST) and two nodes `p` and `q`, find their **Lowest Common Ancestor (LCA)**.

The Lowest Common Ancestor is the lowest node in the tree that has both `p` and `q` as descendants.

A node can also be considered a descendant of itself.

---

## Intuition

The key here is that this is a **BST**, so we can use its ordering property.

For every node:

```text
left subtree < root < right subtree
```

Now look at the current `root` and compare it with `p` and `q`.

### Case 1: Both `p` and `q` are smaller

If:

```text
root.val > p.val
root.val > q.val
```

then both nodes must be in the **left subtree**.

So we move left:

```java
return lowestCommonAncestor(root.left, p, q);
```

---

### Case 2: Both `p` and `q` are larger

If:

```text
root.val < p.val
root.val < q.val
```

then both nodes must be in the **right subtree**.

So we move right:

```java
return lowestCommonAncestor(root.right, p, q);
```

---

### Case 3: They split around the current root

Otherwise, we have reached the LCA.

This includes situations where:

```text
p < root < q
```

or:

```text
q < root < p
```

It also includes the case where:

```text
root == p
```

or:

```text
root == q
```

because one of the nodes itself can be the LCA.

Therefore:

```java
return root;
```

---

## Dry Run

Consider:

```text
          6
        /   \
       2     8
      / \   / \
     0   4 7   9
        / \
       3   5
```

Suppose:

```text
p = 2
q = 8
```

Start at:

```text
root = 6
```

We have:

```text
2 < 6
8 > 6
```

The nodes are on **different sides** of `6`.

Therefore:

```text
LCA = 6
```

---

### Another Example

Suppose:

```text
p = 3
q = 5
```

Start at:

```text
root = 6
```

Both are smaller:

```text
3 < 6
5 < 6
```

So move left.

```text
        6
       /
      2
       \
        4
       / \
      3   5
```

Now:

```text
root = 2
```

Both are larger:

```text
3 > 2
5 > 2
```

Move right.

Now:

```text
root = 4
```

We have:

```text
3 < 4
5 > 4
```

They split around `4`.

Therefore:

```text
LCA = 4
```

---

## Why This Is Better Than the General Binary Tree Solution

Earlier, you solved LCA for a **normal binary tree** using:

```java
TreeNode left = lowestCommonAncestor(root.left, p, q);
TreeNode right = lowestCommonAncestor(root.right, p, q);
```

That approach had to search **both subtrees** because a normal binary tree gives us no information about where `p` and `q` might be.

But a BST gives us ordering information.

So instead of:

```text
Search left
AND
Search right
```

we can decide:

```text
Both smaller → left

Both larger → right

Otherwise → current node is LCA
```

That's the big advantage of recognizing that the tree is a BST.

---

## Complexity

At every step, we move to only **one child**.

Therefore:

- **Time:** `O(h)`
- **Space:** `O(h)` because of recursion

where `h` is the height of the BST.

For a balanced BST:

```text
O(log n)
```

For a completely skewed BST:

```text
O(n)
```

---

## Key Takeaway

The pattern to remember is:

```text
BST + LCA

        root
       /    \
    smaller  larger

Both p,q smaller?
        ↓
      go left

Both p,q larger?
        ↓
      go right

Otherwise
        ↓
   root is LCA
```

So your intuition here is exactly what you want to develop for BST questions:

> **Don't treat a BST like a normal binary tree. Use the ordering property to eliminate half the tree at every step.**
