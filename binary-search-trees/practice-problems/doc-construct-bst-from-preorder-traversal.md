# Construct BST from Preorder Traversal

**Pattern:** Binary Search Tree + Recursion + Range Constraints

## Problem Statement

Given the preorder traversal of a Binary Search Tree, construct the original BST and return its root.

For a BST:

```text
left subtree < root < right subtree
```

This property is what makes reconstruction possible.

## Intuition

At first, it looks like we need to figure out which elements belong to the left subtree and which belong to the right subtree.

But since this is a BST, every node has a valid range where it can exist.

So instead of searching for subtree boundaries, I keep track of:

```text
min → smallest value allowed
max → largest value allowed
```

I also maintain a single pointer `i` into the preorder array.

The important observation is that preorder always gives us:

```text
Root → Left → Right
```

So whenever `preorder[i]` fits inside the current range, it must be the next node of that subtree.

If it doesn't fit, I simply return `null` **without moving `i`**. That means the same value can be considered by the parent call, where it might actually belong.

## Approach

I use a recursive helper:

```text
builder(preorder, min, max)
```

### 1. Check if we've processed everything

```java
if(i >= preorder.length) return null;
```

### 2. Check whether the current value belongs here

```java
int val = preorder[i];

if(val < min || val > max)
    return null;
```

If the value is outside the allowed range, it belongs to some other subtree, so we return without incrementing `i`.

### 3. Create the current node

If the value is valid, consume it:

```java
i++;
TreeNode curr = new TreeNode(val);
```

### 4. Build the left subtree

For the left subtree, values must be smaller than the current node:

```java
curr.left = builder(preorder, min, curr.val);
```

So its range becomes:

```text
[min, curr.val]
```

### 5. Build the right subtree

For the right subtree, values must be greater than the current node:

```java
curr.right = builder(preorder, curr.val, max);
```

So its range becomes:

```text
[curr.val, max]
```

The initial call allows every possible integer:

```java
builder(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
```

## Dry Run

Consider:

```text
preorder = [8, 5, 1, 7, 10, 12]
```

The first value is `8`, so it becomes the root.

```text
        8
```

Now the left subtree can contain values less than `8`.

`5` fits, so:

```text
        8
       /
      5
```

For `5`'s left subtree, values must be less than `5`.

`1` fits:

```text
        8
       /
      5
     /
    1
```

The next value is `7`.

It doesn't belong in `1`'s subtree because its allowed range has already become too restrictive, so that recursive call returns `null` **without consuming `7`**.

Then `7` is considered for `5`'s right subtree, where it is valid:

```text
        8
       /
      5
     / \
    1   7
```

Eventually, `10` becomes the right child of `8`, and `12` becomes the right child of `10`:

```text
        8
       / \
      5   10
     / \    \
    1   7    12
```

The important part of the dry run is what happens when a value doesn't fit:

```text
Doesn't fit current range
        ↓
return null
        ↓
don't increment i
        ↓
parent gets to consider the same value
```

That's the trick that lets us reconstruct the tree in one pass.

## Time Complexity

**O(n)**

Each value in the preorder array is consumed exactly once.

Even though there are recursive calls that return `null`, we don't repeatedly scan the array to find subtree boundaries.

## Space Complexity

**O(h)** auxiliary space, where `h` is the height of the BST.

This comes from the recursion stack.

In the worst case, the BST can become completely skewed:

```text
8
 \
  10
    \
     12
       \
        15
```

Then `h = n`, so the worst-case space becomes **O(n)**.

For a reasonably balanced BST, the height is `O(log n)`.

## Key Takeaway

The main trick is **using the BST property as a range constraint**.

Instead of asking:

> "Where does the left subtree end?"

I can ask:

> "Does the current preorder value belong in this subtree's valid range?"

If yes → build the node.

If no → return without consuming the value.

This is a useful pattern to remember for BST problems: **the BST property can often be converted into a min/max range constraint.**
