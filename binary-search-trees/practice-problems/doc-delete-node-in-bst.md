# Delete Node in a Binary Search Tree

## Problem Statement

Given the root of a Binary Search Tree (BST) and a key, delete the node with that key and return the root of the modified BST.

The BST property must remain valid after deletion.

---

## Intuition

Searching and inserting in a BST were relatively straightforward because we could use the BST property to decide whether to go left or right.

Deletion is slightly trickier because after removing a node, we need to make sure the tree is still a valid BST.

There are **three cases** depending on the node we want to delete.

### Case 1: The node is a leaf

Example:

```text
    5
   /
  3
```

If we delete `3`, we can simply remove it.

```text
    5
```

So we return `null`.

---

### Case 2: The node has only one child

Example:

```text
    5
   /
  3
 /
2
```

If we delete `3`, we can directly connect its parent to its only child.

```text
    5
   /
  2
```

So:

- No left child → return the right child.
- No right child → return the left child.

---

### Case 3: The node has two children

This is the interesting case.

Example:

```text
        5
       / \
      3   7
         / \
        6   8
```

Suppose we want to delete `5`.

We cannot simply remove it because both subtrees need to remain connected.

Instead, we find the **inorder successor**.

The inorder successor is the **smallest value in the right subtree**.

Here:

```text
Right subtree:

      7
     / \
    6   8
```

The smallest value is:

```text
6
```

So we replace `5` with `6`.

```text
        6
       / \
      3   7
         / \
        6   8
```

Now we have two `6`s, so we recursively delete the original `6` from the right subtree.

Final tree:

```text
        6
       / \
      3   7
           \
            8
```

The BST property is preserved.

---

## Approach

First, recursively search for the node we want to delete using the BST property.

```text
key < root.val

↓

Go left
```

```text
key > root.val

↓

Go right
```

Once we find the node, handle the three cases.

### Case 1: Leaf

```java
if(root.left == null && root.right == null)
    return null;
```

### Case 2: Only right child

```java
if(root.left == null)
    return root.right;
```

### Case 3: Only left child

```java
if(root.right == null)
    return root.left;
```

### Case 4: Two children

Find the smallest node in the right subtree.

This is the inorder successor.

```java
TreeNode successor = findMin(root.right);
```

Copy its value into the current node:

```java
root.val = successor.val;
```

Then delete the original successor from the right subtree:

```java
root.right = deleteNode(root.right, successor.val);
```

Finally, return the current root.

---

## Dry Run

Consider:

```text
        5
       / \
      3   7
         / \
        6   8
```

Delete:

```text
5
```

### Step 1

Current node:

```text
5
```

We found the node.

It has:

```text
left  → 3
right → 7
```

So it has two children.

---

### Step 2

Find the minimum in the right subtree:

```text
      7
     / \
    6   8
```

The leftmost node is:

```text
6
```

So:

```text
successor = 6
```

---

### Step 3

Replace the value:

```text
        6
       / \
      3   7
         / \
        6   8
```

---

### Step 4

Delete the original `6` from the right subtree.

Final tree:

```text
        6
       / \
      3   7
           \
            8
```

---

## Why Do We Use the Minimum of the Right Subtree?

This is an important BST observation.

The replacement value must satisfy:

```text
all values in left subtree < replacement < all values in right subtree
```

The smallest value in the right subtree is guaranteed to be larger than everything in the left subtree while being the closest possible value to the deleted node.

That's why the **inorder successor** works.

We could also use the opposite approach:

> Find the largest value in the left subtree.

That would be the **inorder predecessor**, and it would work as well.

---

## The `findMin()` Function

Your helper:

```java
private TreeNode findMin(TreeNode root){
    if(root.left != null){
        root = findMin(root.left);
    }
    return root;
}
```

simply keeps moving left until there is no more left child.

In a BST:

```text
        8
       / \
      4   12
     / \
    2   6
```

The smallest element is always found by following:

```text
8 → 4 → 2
```

So the helper returns `2`.

This could also be written iteratively, but your recursive version is perfectly fine.

---

## Time Complexity

- **Time:** `O(h)`

  where `h` is the height of the BST.

  - Balanced BST → `O(log n)`
  - Skewed BST → `O(n)`

- **Space:** `O(h)`

  Due to the recursive calls.

---

## Key Takeaway

Deletion in a BST becomes much easier when you break it into cases:

```text
Node to delete
       |
       ├── Leaf
       |     ↓
       |   Delete it
       |
       ├── One child
       |     ↓
       |   Connect child to parent
       |
       └── Two children
             ↓
        Find successor
             ↓
        Replace value
             ↓
        Delete successor
```

The most important case to understand is the **two-child case**.

Instead of physically moving an entire subtree around, we replace the node's value with its inorder successor and then delete that successor from where it originally existed.

I think this is a good example of how BST problems build on each other. Search taught us how to use the BST ordering, insertion used the same idea to find an empty position, and deletion adds one more layer: **using the inorder successor/predecessor to preserve that ordering after removing a node.**
