# Predecessor and Successor in BST

**Pattern:** BST — Ordered Search

## Problem Statement

Given a Binary Search Tree and a key, find:

* **Predecessor:** the largest value smaller than `key`
* **Successor:** the smallest value greater than `key`

Return them in this order:

```text
[predecessor, successor]
```

If either one doesn't exist, return `-1`.

## Intuition

The interesting part here is that we don't need to traverse the entire tree.

Because this is a BST:

```text
left < root < right
```

I can use this property to move towards the answer.

For the **successor**, I want the smallest value that is still greater than `key`.

For the **predecessor**, I want the largest value that is still smaller than `key`.

So while traversing, whenever I find a possible answer, I save it and continue searching in the direction that could give me a **closer** answer.

## Approach

### Finding the Successor

Start from the root.

If:

```java
root.data <= key
```

then this node cannot be the successor because the successor must be strictly greater than `key`.

So I move right:

```java
root = root.right;
```

If:

```java
root.data > key
```

then this node is a possible successor.

I save it:

```java
successor = root.data;
```

But I don't stop because there might be a smaller value greater than `key` in the left subtree.

So I move left:

```java
root = root.left;
```

### Finding the Predecessor

The logic is basically the mirror image.

If:

```java
root.data < key
```

then this node is a possible predecessor.

I save it and move right:

```java
pred = root.data;
root = root.right;
```

Why right?

Because I want to find a value that is **larger than the current predecessor but still smaller than `key`**.

If:

```java
root.data >= key
```

then this node cannot be the predecessor, so I move left.

## Dry Run

Consider:

```text
          8
        /   \
       4     12
      / \    / \
     2   6  10  14
        / \
       5   7
```

Suppose:

```text
key = 6
```

### Successor

Start at `8`.

`8 > 6`

So `8` is a possible successor.

```text
successor = 8
```

Move left.

At `4`:

```text
4 <= 6
```

So it cannot be the successor.

Move right → `6`.

At `6`:

```text
6 <= 6
```

Again, not a successor.

Move right → `7`.

`7 > 6`, so:

```text
successor = 7
```

Move left and eventually finish.

So:

```text
successor = 7
```

### Predecessor

Start again from the root.

At `8`:

```text
8 >= 6
```

So move left.

At `4`:

```text
4 < 6
```

Possible predecessor:

```text
pred = 4
```

Move right.

At `6`:

```text
6 >= 6
```

Move left.

At `5`:

```text
5 < 6
```

Better predecessor:

```text
pred = 5
```

So:

```text
predecessor = 5
successor = 7
```

Result:

```text
[5, 7]
```

## Time Complexity

**O(h)**

We perform two BST searches, and each search follows only one path from the root.

So the total is:

```text
O(h) + O(h) = O(h)
```

For a balanced BST, `h = O(log n)`.

In the worst case of a completely skewed BST:

```text
h = O(n)
```

## Space Complexity

**O(1)** auxiliary space.

The solution is iterative and only uses a few variables. No recursion stack or additional data structure is needed.

## Key Takeaway

For BST problems involving **closest smaller/larger values**, think about the direction in which the answer can improve.

* `current < key` → possible **predecessor**, go right
* `current > key` → possible **successor**, go left
* `current == key` → move toward the appropriate subtree

The main idea is:

> **Save a valid candidate, then keep searching for a better one.**

This lets us find predecessor and successor without traversing the entire BST.
