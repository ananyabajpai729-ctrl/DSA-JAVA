# Balanced Binary Tree

## Problem Statement

Given the root of a binary tree, determine whether it is **height-balanced**.

A binary tree is considered balanced if, for **every node**, the difference between the heights of its left and right subtrees is at most:

```text
1
```

Return `true` if the tree is balanced, otherwise return `false`.

---

## Intuition

A straightforward approach would be:

- Calculate the height of the left subtree.
- Calculate the height of the right subtree.
- Check if their difference is at most 1.
- Repeat this for every node.

However, this repeatedly computes the heights of the same subtrees, leading to an **O(n²)** solution in the worst case.

Instead, we can compute the height **and** verify whether the subtree is balanced in a single recursive traversal.

The trick is to use a special value:

```text
-1
```

to indicate that a subtree is already unbalanced.

As soon as we encounter `-1`, we immediately stop further computation and propagate the failure upwards.

---

## Approach

Create a recursive helper function that returns:

- The height of the subtree if it is balanced.
- `-1` if the subtree is unbalanced.

For every node:

1. If the node is `null`, return `0`.
2. Compute the height of the left subtree.
3. If the left subtree returned `-1`, immediately return `-1`.
4. Compute the height of the right subtree.
5. If the right subtree returned `-1`, immediately return `-1`.
6. If the height difference exceeds `1`, return `-1`.
7. Otherwise, return:

```text
1 + max(leftHeight, rightHeight)
```

Finally, the tree is balanced if the helper function does **not** return `-1`.

---

## Dry Run

**Input:**

```text
        1
       / \
      2   3
     /
    4
```

### Leaf Nodes

```text
4

Height = 1

3

Height = 1
```

---

### Node 2

```text
Left Height = 1

Right Height = 0

Difference = 1

Balanced

Height = 2
```

---

### Root 1

```text
Left Height = 2

Right Height = 1

Difference = 1

Balanced

Height = 3
```

Output:

```text
true
```

---

### Unbalanced Example

```text
        1
       /
      2
     /
    3
```

Processing:

```text
Node 3

Height = 1

↓

Node 2

Height = 2

↓

Node 1

Left Height = 2

Right Height = 0

Difference = 2

Return -1
```

Output:

```text
false
```

---

## Recursive Call Flow

```text
helper(node)

│

├── Compute left height

│

├── If left == -1

│      Return -1

│

├── Compute right height

│

├── If right == -1

│      Return -1

│

├── If |left - right| > 1

│      Return -1

│

└── Return

1 + max(left, right)
```

Notice how an unbalanced subtree immediately stops further unnecessary computation.

---

## Time Complexity

- **Time:** `O(n)`

  Every node is visited exactly once.

- **Space:** `O(h)`

  Where `h` is the height of the tree due to the recursive call stack.

- Best case (balanced tree): `O(log n)`
- Worst case (skewed tree): `O(n)`

---

## Key Takeaway

The biggest optimization is combining **height calculation** and **balance checking** into a single recursion.

Instead of writing two separate recursive functions, one function performs both jobs.

The special value:

```text
-1
```

acts as a signal meaning:

> **"This subtree is already unbalanced. Stop calculating heights and propagate the failure upwards."**

You can think of the recursion like this:

```text
Leaves compute height

↓

Parents verify balance

↓

If balanced

Return height

↓

If unbalanced

Return -1 immediately
```

This pattern of using a **special return value** to propagate failure is very common in tree problems. It helps avoid repeated work and reduces the solution from **O(n²)** to **O(n)**.
