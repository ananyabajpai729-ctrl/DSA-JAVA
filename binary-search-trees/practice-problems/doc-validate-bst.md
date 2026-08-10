# Validate Binary Search Tree

## Problem Statement

Given the root of a binary tree, determine whether it is a valid Binary Search Tree (BST).

A valid BST must satisfy:

```text
All values in the left subtree < current node < all values in the right subtree
```

This condition must hold for **every node** in the tree.

---

## Intuition

At first, it might seem enough to check:

```text
left child < root < right child
```

But that's **not sufficient**.

Consider:

```text
        5
       / \
      3   7
     / \
    2   6
```

At node `3`:

```text
2 < 3 < 6
```

So locally, everything looks correct.

But `6` is inside the **left subtree of 5**, so it must also satisfy:

```text
6 < 5
```

which is false.

Therefore, we need to keep track of the **valid range of values** that every node is allowed to have.

---

## Approach

For every node, maintain two boundaries:

```text
min = smallest value the node can have

max = largest value the node can have
```

Initially, the root can contain any valid integer:

```text
Long.MIN_VALUE < root.val < Long.MAX_VALUE
```

When moving to the left subtree:

```text
min stays the same

max becomes root.val
```

because every value in the left subtree must be smaller than the current node.

When moving to the right subtree:

```text
min becomes root.val

max stays the same
```

because every value in the right subtree must be greater than the current node.

So the recursive calls become:

```java
helper(root.left, min, root.val)
```

and

```java
helper(root.right, root.val, max)
```

---

## The Important Check

At every node:

```java
if(root.val <= min || root.val >= max)
    return false;
```

If the node falls outside its allowed range, the tree is not a valid BST.

Otherwise, recursively validate both subtrees.

---

## Dry Run

Consider:

```text
        5
       / \
      3   7
     / \
    2   4
```

Start with:

```text
root = 5

range = (-∞, +∞)
```

Since:

```text
-∞ < 5 < +∞
```

valid.

---

### Left Subtree

For node `3`:

```text
range = (-∞, 5)
```

Since:

```text
-∞ < 3 < 5
```

valid.

Its left child gets:

```text
(-∞, 3)
```

Its right child gets:

```text
(3, 5)
```

So:

```text
2 → (-∞,3) ✓

4 → (3,5) ✓
```

---

### Right Subtree

For node `7`:

```text
range = (5,+∞)
```

Since:

```text
5 < 7 < +∞
```

valid.

Every node satisfies its allowed range.

Therefore:

```text
true
```

---

## Why `min` and `max` Are Necessary

Consider this tree:

```text
        5
       / \
      3   7
       \
        6
```

When we reach `6`, we don't just know that:

```text
6 > 3
```

We also know that because `6` is in the left subtree of `5`:

```text
6 < 5
```

So its valid range is:

```text
3 < 6 < 5
```

which is impossible.

Our range check catches this immediately:

```java
if(root.val <= min || root.val >= max)
    return false;
```

For node `6`:

```text
min = 3
max = 5

6 >= 5
```

Therefore:

```text
false
```

---

## Why Use `long` Instead of `int`?

Your code starts with:

```java
helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
```

This is a good choice.

Suppose the tree contains:

```text
Integer.MIN_VALUE
```

If we used:

```java
Integer.MIN_VALUE
```

as the initial lower boundary, the comparison could incorrectly reject a perfectly valid node.

Using `Long.MIN_VALUE` and `Long.MAX_VALUE` gives us boundaries outside the entire `int` range.

---

## Time Complexity

- **Time:** `O(n)`

  Every node may need to be visited once.

- **Space:** `O(h)`

  Due to the recursion stack, where `h` is the height of the tree.

---

## Key Takeaway

The main idea isn't simply:

```text
left child < root < right child
```

It's:

> **Every node must lie within the range imposed by all of its ancestors.**

As we move down the tree, we keep narrowing that range.

```text
             5
        (-∞, +∞)
          /   \
         3     7
      (-∞,5) (5,+∞)
       / \
      2   4
   (-∞,3) (3,5)
```

This is a really useful pattern for BST problems:

```text
BST validation
       ↓
Maintain valid range
       ↓
Left  → (min, root.val)
Right → (root.val, max)
```

And notice how this builds nicely on the previous BST problems you've done: instead of **using** the BST property to search or insert, here we're checking whether the tree actually **satisfies** that property globally.
