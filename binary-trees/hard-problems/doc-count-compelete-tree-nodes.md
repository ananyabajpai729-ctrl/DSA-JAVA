# Count Complete Tree Nodes

## Problem Statement

Given the root of a **complete binary tree**, return the total number of nodes.

A complete binary tree is a tree where:

- Every level except possibly the last is completely filled.
- All nodes in the last level are as far left as possible.

---

## Intuition

The brute force solution is straightforward:

- Traverse every node.
- Count them.

That takes **O(n)** time.

However, the tree is **complete**, which gives us extra information that we can exploit.

A complete binary tree has an interesting property:

- If the height obtained by continuously moving left equals the height obtained by continuously moving right, then the tree is actually a **perfect binary tree**.

For a perfect binary tree, we don't need to count every node.

We can directly use the formula:

```text
Number of Nodes = 2^height - 1
```

If the heights are not equal, then the tree isn't perfect.

In that case, we recursively count the left and right subtrees.

This allows us to skip traversing entire perfect subtrees.

---

## Approach

If the tree is empty, return `0`.

Compute:

- the leftmost height.
- the rightmost height.

If both heights are equal:

- The tree is perfect.
- Return

```text
2^height - 1
```

Otherwise:

- Count the current node.
- Recursively count the left subtree.
- Recursively count the right subtree.

Return their sum.

---

## Dry Run

**Input**

```text
        1
      /   \
     2     3
    / \   /
   4   5 6
```

---

### Step 1

Compute heights.

Left height:

```text
1

↓

2

↓

4
```

Height = **3**

Right height:

```text
1

↓

3
```

Height = **2**

Since:

```text
3 ≠ 2
```

the tree is **not perfect**.

Recursively count both subtrees.

---

### Left Subtree

```text
      2
     / \
    4   5
```

Left height = Right height = **2**

This is a perfect tree.

Count directly:

```text
2² − 1 = 3
```

---

### Right Subtree

```text
    3
   /
  6
```

Not perfect.

Count recursively.

Result:

```text
2
```

---

Final Answer

```text
1 + 3 + 2 = 6
```

---

## Why Does Equal Height Mean a Perfect Tree?

For a **complete binary tree**,

if

```text
Left Height == Right Height
```

then every level must already be completely filled.

For example,

```text
        1
      /   \
     2     3
    / \   / \
   4  5  6  7
```

Left height:

```text
1 → 2 → 4
```

Right height:

```text
1 → 3 → 7
```

Both are `3`.

Since the tree is complete, this guarantees it is also perfect.

So instead of visiting all seven nodes, we simply compute:

```text
2³ − 1 = 7
```

---

## Time Complexity

- **Time:** `O(log² n)`

  At each recursive call, computing the left and right heights takes `O(log n)`. Since the recursion itself goes down at most `O(log n)` levels in a complete binary tree, the total complexity becomes:

```text
O(log n × log n)
```

- **Space:** `O(log n)`

  Due to the recursion stack.

---

## Key Takeaway

The biggest lesson from this problem is that **tree properties can help you avoid traversing the entire tree**.

Normally, counting nodes requires visiting every node:

```text
O(n)
```

But because the tree is **complete**, we can recognize when a subtree is actually perfect.

```text
Left Height

↓

Right Height

↓

Equal?

↓

Perfect Tree

↓

Use Formula
```

Instead of recursively counting every node, we instantly compute:

```java
(1 << height) - 1
```

which is equivalent to:

```text
2^height - 1
```

I found this problem interesting because it combines recursion with a mathematical observation. Rather than optimizing the recursion itself, the optimization comes from recognizing when recursion isn't needed at all.
