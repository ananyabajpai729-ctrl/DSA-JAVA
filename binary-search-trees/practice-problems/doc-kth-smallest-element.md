# Kth Smallest Element in a BST

## Problem Statement

Given the root of a Binary Search Tree (BST) and an integer `k`, return the **kth smallest value** in the tree.

---

## Intuition

The important observation here is the relationship between a BST and **inorder traversal**.

For a BST:

```text
Left Subtree < Root < Right Subtree
```

If we perform an inorder traversal:

```text
Left → Root → Right
```

we will visit the nodes in **sorted order**.

For example:

```text
        5
       / \
      3   7
     / \   \
    2   4   8
```

Inorder traversal gives:

```text
2 3 4 5 7 8
```

So the:

```text
1st smallest → 2
2nd smallest → 3
3rd smallest → 4
4th smallest → 5
```

Therefore, we simply need to perform an inorder traversal and count the nodes we visit.

When the count becomes `k`, we've found the kth smallest element.

---

## Approach

Maintain two variables:

```java
int count = 0;
int result = -1;
```

Perform an inorder traversal.

For every node:

1. Traverse its left subtree.
2. Visit the current node.
3. Increment `count`.
4. If `count == k`, store the current node's value.
5. Traverse the right subtree.

Because inorder traversal of a BST produces values in sorted order, the node encountered at position `k` is the kth smallest element.

---

## Dry Run

Consider:

```text
        5
       / \
      3   7
     / \   \
    2   4   8
```

Suppose:

```text
k = 3
```

Inorder traversal:

```text
2 → 3 → 4 → 5 → 7 → 8
```

Track the count:

```text
Visit 2
count = 1

Visit 3
count = 2

Visit 4
count = 3
```

Since:

```text
count == k
```

we store:

```text
result = 4
```

Answer:

```text
4
```

---

## Why Does Inorder Traversal Work?

This is one of the most important BST properties to remember.

For a normal binary tree:

```text
Inorder ≠ necessarily sorted
```

But for a BST:

```text
Left < Root < Right
```

Therefore, when we visit:

```text
Left → Root → Right
```

the values naturally come out in increasing order.

So you can immediately think:

```text
BST + kth smallest

↓

Inorder traversal

↓

kth visited node
```

Similarly:

```text
BST + kth largest

↓

Reverse inorder

↓

Right → Root → Left
```

---

## One Small Detail in Your Code

Your recursion is:

```java
inorder(root.left, k);

count++;

if(count == k){
    result = root.val;
    return;
}

inorder(root.right, k);
```

Once you've found the kth element, you return from that particular recursive call.

Because `result` is already set, the remaining recursion doesn't affect the answer.

So your solution works correctly.

One possible improvement would be to stop the entire traversal once the answer has been found, but that's an optimization rather than a correctness issue.

For example, you could check:

```java
if(result != -1) return;
```

before continuing the recursion.

---

## Time Complexity

- **Time:** `O(h + k)`

  We traverse down the tree and visit nodes until reaching the kth smallest element.

  In the worst case, this becomes `O(n)`.

- **Space:** `O(h)`

  Due to the recursion stack.

---

## Key Takeaway

This problem is a great example of how recognizing a **tree property** can completely simplify a problem.

You don't need to sort the values separately.

You don't need an extra array.

You just use:

```text
BST property
     ↓
Inorder traversal
     ↓
Sorted order
     ↓
kth visited node
```

The pattern worth remembering is:

> **Inorder traversal of a BST gives the elements in ascending order.**

And the mirror image is:

> **Reverse inorder traversal gives the elements in descending order.**

So whenever you see a BST question involving **smallest, largest, sorted order, predecessor, successor, kth smallest, or kth largest**, inorder/reverse-inorder should immediately come to mind.
