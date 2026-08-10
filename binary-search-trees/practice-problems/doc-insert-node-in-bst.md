# Insert into a Binary Search Tree

## Problem Statement

Given the root of a Binary Search Tree (BST) and an integer `val`, insert a new node with value `val` into the BST.

Return the root of the modified tree.

It is guaranteed that `val` does not already exist in the tree.

---

## Intuition

A Binary Search Tree maintains the property:

```text
Left Subtree  < Root < Right Subtree
```

To insert a new value, we simply follow the same path we would take while searching for it.

- If the value is smaller than the current node, move to the left.
- If the value is larger, move to the right.

Eventually, we'll reach a position where the required child is `null`. That is exactly where the new node should be inserted.

Unlike searching, we don't stop when we find the value—we stop when we find the **empty position where the value belongs**.

---

## Approach

If the tree is empty:

- Create a new node and return it as the root.

Otherwise:

- Start from the root.
- Traverse the tree iteratively.

At each node:

- If the value is smaller:
  - Move to the left child.
  - If the left child is `null`, insert the new node there and stop.
- Otherwise:
  - Move to the right child.
  - If the right child is `null`, insert the new node there and stop.

Finally, return the original root.

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

Insert:

```text
5
```

---

### Step 1

Current:

```text
4
```

Since

```text
5 > 4
```

Move right.

---

### Step 2

Current:

```text
7
```

Since

```text
5 < 7
```

Move left.

---

Left child is `null`.

Insert:

```text
        4
      /   \
     2     7
    / \   /
   1   3 5
```

Return the root.

---

## Time Complexity

- **Time:** `O(h)`

  where `h` is the height of the BST.

  - Balanced BST: `O(log n)`
  - Skewed BST: `O(n)`

- **Space:** `O(1)`

  The solution is iterative and uses only a single pointer.

---

## Key Takeaway

Insertion in a BST is essentially the same as searching.

The only difference is **when we stop**.

For searching:

```text
Keep moving

↓

Stop when value is found
```

For insertion:

```text
Keep moving

↓

Stop when the required child is null

↓

Insert the new node there
```

I liked this problem because it shows how the BST property guides every decision. At each node, only one subtree can possibly contain the correct insertion position, so we never need to explore both sides. This makes the algorithm efficient and very easy to implement iteratively.
