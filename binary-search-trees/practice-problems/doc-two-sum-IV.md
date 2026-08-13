# Two Sum IV - Input is a BST

## Problem Statement

Given a BST and a number `k`, check if there are two different nodes whose values add up to `k`.

Return `true` if such a pair exists, otherwise return `false`.

## Pattern

**BST + Two Pointers + BST Iterator**

## Intuition

The first thought for this problem is probably:

> "If I had a sorted array, I could just use two pointers."

For example:

```text
[2, 3, 4, 5, 7, 9]
 ↑              ↑
left           right
```

If the sum is too small, move `left`.

If the sum is too large, move `right`.

But here we have a BST, not an array.

The nice thing is that a BST can give me sorted values through inorder traversal.

So I can create:

* one iterator that gives values from **smallest to largest**
* another iterator that gives values from **largest to smallest**

Now I basically have two pointers, but instead of pointers into an array, they are pointers moving through the BST.

## Approach

I created a `BSTIterator` class.

It has a `reverse` variable which decides which direction the iterator should go.

### Normal iterator

When `reverse = false`, I want normal inorder traversal:

```text
left → root → right
```

So in `pushAll()` I keep going left:

```java
if(reverse){
    node = node.right;
}else{
    node = node.left;
}
```

This gives me:

```text
smallest → ... → largest
```

### Reverse iterator

When `reverse = true`, I do the opposite.

I keep going right first:

```text
right → root → left
```

So the values come out as:

```text
largest → ... → smallest
```

## How `next()` works

When I call:

```java
l.next()
```

I get the next smallest value.

When I call:

```java
r.next()
```

I get the next largest value.

After removing a node from the stack, I push the next path that needs to be visited:

```java
if(!reverse){
    pushAll(temp.right);
}else{
    pushAll(temp.left);
}
```

So I don't have to store the entire inorder traversal anywhere.

## Two Pointer Logic

I start with:

```java
int i = l.next();
int j = r.next();
```

So:

```text
i = smallest value
j = largest value
```

Then:

```java
while(i < j)
```

I check their sum.

### If sum == k

We found the pair:

```java
if(i + j == k) return true;
```

### If sum < k

The sum is too small.

So I need a bigger value.

Since `l` moves from small → large:

```java
i = l.next();
```

### If sum > k

The sum is too large.

So I need a smaller value.

Since `r` moves from large → small:

```java
j = r.next();
```

## Dry Run

Consider:

```text
        5
       / \
      3   6
     / \   \
    2   4   7
```

Suppose:

```text
k = 9
```

Normal iterator gives:

```text
2 → 3 → 4 → 5 → 6 → 7
```

Reverse iterator gives:

```text
7 → 6 → 5 → 4 → 3 → 2
```

Start:

```text
i = 2
j = 7
```

Their sum:

```text
2 + 7 = 9
```

So we immediately return:

```text
true
```

Another example, suppose:

```text
k = 10
```

Start:

```text
i = 2
j = 7

2 + 7 = 9
```

Too small, so move `i`:

```text
i = 3
j = 7

3 + 7 = 10
```

Found it.

## Time Complexity

**O(n)** in the worst case.

The iterators together may visit the nodes of the tree while looking for the pair.

Each node is processed at most once by the iterators.

## Space Complexity

**O(h)**

The stacks store paths through the BST.

Here `h` is the height of the tree.

For a balanced BST this is around:

```text
O(log n)
```

In the worst case, when the tree is completely skewed:

```text
O(n)
```

## Key Takeaway

The main thing I want to remember is that this is basically **Two Sum on a sorted array**, except I don't actually create the sorted array.

Instead:

```text
BST
 ↓
normal iterator      reverse iterator
small → large         large → small
       ↓                  ↓
       two pointers
             ↓
        check the sum
```

So the important connection is:

> **If I need two-pointer behaviour on a BST, I can use two BST iterators instead of converting the whole tree into an array.**
