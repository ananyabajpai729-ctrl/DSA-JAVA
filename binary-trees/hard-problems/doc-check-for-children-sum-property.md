# Children Sum Property

## Problem Statement

Given the root of a binary tree, determine whether the tree satisfies the **Children Sum Property**.

A binary tree satisfies this property if, for every non-leaf node:

```text
Node Value = Left Child Value + Right Child Value
```

If a child is missing, its value is considered `0`.

Return `true` if every node satisfies this condition, otherwise return `false`.

---

## Intuition

Every node only depends on its immediate children.

So instead of comparing entire subtrees, we simply visit each node once and verify:

```text
Current Node

↓

Left Child + Right Child
```

If the values match, we continue.

The moment we find a node where this condition is violated, we can immediately return `false`.

Since every node needs to be checked exactly once, a **Level Order Traversal (BFS)** works naturally.

---

## Approach

If the tree is empty, return `true`.

Create a queue and push the root.

Perform a Level Order Traversal.

For every node:

- If it is a leaf node, continue.
- Compute the sum of its children.
- Treat missing children as contributing `0`.
- If the child sum is not equal to the current node's value, return `false`.
- Push the existing children into the queue.

If the traversal completes without finding any violation, return `true`.

---

## Dry Run

**Input**

```text
        10
       /  \
      8    2
     / \
    3   5
```

---

Visit:

```text
10
```

Children sum:

```text
8 + 2 = 10 ✓
```

---

Visit:

```text
8
```

Children sum:

```text
3 + 5 = 8 ✓
```

---

Visit:

```text
2
```

Leaf node.

Skip.

---

Visit:

```text
3
```

Leaf node.

Skip.

---

Visit:

```text
5
```

Leaf node.

Skip.

Traversal completes.

Output:

```text
true
```

---

### Example 2

```text
      10
     /  \
    7    2
```

Children sum:

```text
7 + 2 = 9
```

Since

```text
9 ≠ 10
```

Return:

```text
false
```

---

## Time Complexity

- **Time:** `O(n)`

  Every node is visited exactly once.

- **Space:** `O(n)`

  In the worst case, the queue stores an entire level of the tree.

---

## Key Takeaway

This problem is simpler than many tree problems because each node only depends on its **immediate children**.

The algorithm boils down to repeating one check for every non-leaf node:

```text
Current Node

↓

Left Value + Right Value

↓

Should be equal
```

I chose a Level Order Traversal here because it lets me process every node exactly once in a straightforward manner. An equally valid recursive (DFS) solution also exists, since the property is local to each node.

Another small detail is handling missing children. Instead of writing separate cases, we simply treat a missing child as contributing `0` to the sum, which keeps the logic clean and consistent.
