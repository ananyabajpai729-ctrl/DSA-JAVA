# Boundary Traversal of Binary Tree

## Problem Statement

Given the root of a binary tree, return its **boundary traversal** in an anti-clockwise direction.

The boundary consists of:

- The root node.
- The left boundary (excluding leaf nodes).
- All the leaf nodes from left to right.
- The right boundary (excluding leaf nodes), traversed in reverse order.

---

## Intuition

This isn't a problem that can be solved using a single tree traversal.

Instead, it's easier to think of the boundary as four separate parts:

1. Root
2. Left Boundary
3. Leaf Nodes
4. Right Boundary (in reverse)

One important observation is that **leaf nodes should appear exactly once**. Since the leaf traversal already collects every leaf, the left and right boundary traversals deliberately skip leaf nodes to avoid duplicates.

---

## Approach

Create an empty answer list.

If the tree is empty, return it immediately.

If the root itself is **not a leaf**, add it to the answer. (For a single-node tree, the root will be added later as a leaf.)

### Step 1: Traverse the Left Boundary

Start from `root.left`.

While the current node exists:

- Ignore it if it is a leaf.
- Otherwise, add it to the answer.
- Prefer moving to the left child.
- If there is no left child, move to the right child.

This keeps us on the outer boundary of the tree.

---

### Step 2: Collect All Leaf Nodes

Perform a DFS.

Whenever a leaf node is encountered:

- Add it to the answer.
- Stop exploring further.

Otherwise:

- Visit the left subtree.
- Visit the right subtree.

This naturally collects all leaves from left to right.

---

### Step 3: Traverse the Right Boundary

Start from `root.right`.

Similar to the left boundary:

- Ignore leaf nodes.
- Prefer moving right.
- Otherwise move left.

Store these nodes in a temporary list.

Finally, traverse the temporary list in reverse order and append it to the answer.

---

## Dry Run

**Input:**

```text
            1
          /   \
         2     3
        / \     \
       4   5     6
          / \   /
         7   8 9
```

---

### Root

```text
1
```

Answer:

```text
[1]
```

---

### Left Boundary

Traverse:

```text
2
```

(Node `4` is skipped because it is a leaf.)

Answer:

```text
[1,2]
```

---

### Leaf Nodes

DFS visits:

```text
4

7

8

9
```

Answer:

```text
[1,2,4,7,8,9]
```

---

### Right Boundary

Traversal:

```text
3 → 6
```

Temporary list:

```text
[3,6]
```

Reverse it:

```text
[6,3]
```

Final Answer:

```text
[1,2,4,7,8,9,6,3]
```

---

## Edge Case

### Single Node Tree

```text
    1
```

The root is also a leaf.

Instead of adding it twice,

```java
if(!isLeaf(root))
    ans.add(root.data);
```

ensures the root is added only once during the leaf traversal.

Output:

```text
[1]
```

---

## Time Complexity

- **Time:** `O(n)`

  Every node is visited at most once.

- **Space:** `O(h)`

  Due to the recursive DFS call stack, where `h` is the height of the tree.

  An additional `O(h)` space is used for storing the right boundary temporarily.

---

## Key Takeaway

The biggest lesson from this problem is to **decompose a complicated traversal into smaller independent traversals**.

Instead of searching for one magical traversal that visits the boundary correctly, treat each part separately:

```text
Root

↓

Left Boundary
(excluding leaves)

↓

All Leaf Nodes

↓

Right Boundary
(excluding leaves, reversed)
```

Each helper function has only one responsibility, making the implementation much simpler and easier to debug.

Another subtle but important detail is avoiding duplicate leaf nodes. Since the leaf traversal already visits every leaf, the boundary traversals intentionally skip them, ensuring every boundary node appears exactly once.
