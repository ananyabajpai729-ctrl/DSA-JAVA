# Lowest Common Ancestor of a Binary Tree

## Problem Statement

Given the root of a binary tree and two nodes `p` and `q`, return their **Lowest Common Ancestor (LCA)**.

The Lowest Common Ancestor is the lowest node in the tree that has both `p` and `q` as descendants (a node can be a descendant of itself).

---

## Intuition

The recursive nature of trees makes this problem surprisingly elegant.

Think about what happens while exploring a subtree:

- If neither `p` nor `q` exists there, return `null`.
- If one of them exists, return that node.
- If both exist in different branches, then the current node is where their paths meet for the first time, making it the Lowest Common Ancestor.

The beautiful part is that the recursion itself carries this information back to the parent. Every recursive call answers one simple question:

> "Did I find `p`, `q`, or neither in my subtree?"

Once a node receives answers from both its left and right subtrees, it has enough information to determine whether it is the LCA.

---

## Approach

Create a recursive function.

For every node:

- If the node is `null`, return `null`.
- If the current node is either `p` or `q`, return the current node.

Now recursively search:

- the left subtree.
- the right subtree.

There are three possible situations:

- Both recursive calls return non-null.
  - One target was found in each subtree.
  - The current node is the Lowest Common Ancestor.

- Only one recursive call returns non-null.
  - Both targets lie in the same subtree.
  - Simply return that node upwards.

- Both return `null`.
  - Neither target exists in this subtree.
  - Return `null`.

The answer naturally propagates back to the root.

---

## Dry Run

**Input**

```text
            3
          /   \
         5     1
        / \   / \
       6   2 0   8
          / \
         7   4
```

Find:

```text
p = 5

q = 1
```

---

Start at:

```text
3
```

Search left:

```text
returns 5
```

Search right:

```text
returns 1
```

Both sides return a node.

Therefore,

```text
LCA = 3
```

---

### Another Example

Find:

```text
p = 5

q = 4
```

Traversal:

```text
5

↓

Left returns null

↓

Right subtree eventually returns 4
```

At node `5`:

```text
left = null

right = 4
```

Since one recursive call returns the current target (`5`) and the other finds `4`, node `5` is the first place where both nodes are present.

Answer:

```text
5
```

---

## Time Complexity

- **Time:** `O(n)`

  In the worst case, every node is visited once.

- **Space:** `O(h)`

  Due to the recursion stack, where `h` is the height of the tree.

---

## Key Takeaway

This is one of those recursive solutions that looks almost magical until you understand what each recursive call is actually returning.

Instead of searching for the Lowest Common Ancestor directly, every recursive call simply reports one of three things:

```text
Found p

or

Found q

or

Found nothing
```

The parent then combines these answers.

```text
Left subtree

↓

Current Node

↓

Right subtree
```

If both left and right return a valid node, the current node is exactly where the two search paths meet, making it the Lowest Common Ancestor.

I also liked how little state is required. There's no need to store paths from the root or maintain extra data structures. The recursion itself carries all the information needed back up the tree, making the solution both concise and elegant.
