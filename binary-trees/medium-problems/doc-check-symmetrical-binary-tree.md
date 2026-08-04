# Symmetric Tree

## Problem Statement

Given the root of a binary tree, determine whether it is symmetric around its center.

A tree is symmetric if its left subtree is a mirror reflection of its right subtree.

---

## Intuition

At first glance, it might seem like we need to compare the left and right subtrees directly.

However, symmetry isn't about checking whether the subtrees are identical—it's about checking whether they are **mirror images** of each other.

For two nodes to be mirrors:

- Their values must be equal.
- The left child of one should match the right child of the other.
- The right child of one should match the left child of the other.

This naturally leads to a recursive solution where we compare two nodes at a time instead of traversing one subtree independently.

---

## Approach

Create a helper function that takes two nodes.

For every pair of nodes:

- If either node is `null`, they are symmetric only if both are `null`.
- If their values are different, return `false`.
- Recursively compare:
  - the left child of the first node with the right child of the second.
  - the right child of the first node with the left child of the second.

In the main function:

- If the tree is empty, return `true`.
- Otherwise, start the recursion using the root's left and right children.

If every mirrored pair matches, the tree is symmetric.

---

## Dry Run

**Input**

```text
        1
      /   \
     2     2
    / \   / \
   3  4  4   3
```

Start by comparing:

```text
2 ↔ 2
```

Values match.

Now compare:

```text
3 ↔ 3
```

Values match.

Then compare:

```text
4 ↔ 4
```

Values match.

Every mirrored pair satisfies the condition.

Output:

```text
true
```

---

### Example 2

```text
        1
      /   \
     2     2
      \     \
       3     3
```

Compare:

```text
Left child of first 2

↓

null
```

with

```text
Right child of second 2

↓

3
```

One node is `null` while the other isn't.

The recursion immediately returns:

```text
false
```

---

## Time Complexity

- **Time:** `O(n)`

  Every node is visited exactly once.

- **Space:** `O(h)`

  Due to the recursion stack, where `h` is the height of the tree.

---

## Key Takeaway

The biggest lesson from this problem is understanding the difference between **same** and **mirror**.

For checking whether two trees are identical, we compare:

```text
Left ↔ Left

Right ↔ Right
```

For symmetry, we instead compare:

```text
Left ↔ Right

Right ↔ Left
```

That single change is what transforms a "Same Tree" solution into a "Symmetric Tree" solution.

I also liked how the recursion directly models the definition of a mirror. Instead of trying to visualize the entire tree at once, we simply keep asking:

> "Are these two nodes mirror images of each other?"

If the answer is yes for every pair, the entire tree is symmetric.
