# Merge Two BSTs

## Problem Statement

Given two BSTs, return all their elements in one sorted list.

## Pattern

**BST + Inorder + Two Pointers**

## Intuition

The first thing I noticed is that both trees are BSTs.

And for a BST, inorder traversal gives the elements in sorted order.

So instead of trying to merge the trees directly, I can do:

```text
BST 1 → inorder → sorted list
BST 2 → inorder → sorted list
```

For example:

```text
    3                 6
   / \               / \
  1   5             4   8
```

Inorder gives:

```text
[1, 3, 5]       [4, 6, 8]
```

Now I just have to merge these two sorted lists.

## Approach

First, I use inorder traversal on both trees:

```java
inorder(p, arr1);
inorder(q, arr2);
```

Now both `arr1` and `arr2` are sorted.

Then I keep two pointers:

```java
int i = 0, j = 0;
```

`i` is for `arr1` and `j` is for `arr2`.

I compare the current elements of both lists.

If `arr1[i]` is smaller, I add it and move `i`.

Otherwise, I add `arr2[j]` and move `j`.

```java
if (arr1.get(i) <= arr2.get(j)) {
    ans.add(arr1.get(i++));
} else {
    ans.add(arr2.get(j++));
}
```

Once one list finishes, I just add whatever is left in the other list.

## Dry Run

Suppose the two BSTs give:

```text
arr1 = [1, 3, 5]
arr2 = [4, 6, 8]
```

Start with:

```text
i → 1
j → 4
```

`1 < 4`, so take `1`.

```text
ans = [1]
```

Now:

```text
i → 3
j → 4
```

`3 < 4`, so take `3`.

```text
ans = [1, 3]
```

Now:

```text
i → 5
j → 4
```

`4 < 5`, so take `4`.

```text
ans = [1, 3, 4]
```

Continue the same way:

```text
5 → take 5
6 → take 6
8 → take 8
```

Final answer:

```text
[1, 3, 4, 5, 6, 8]
```

## Time Complexity

Let `n` and `m` be the number of nodes in the two BSTs.

Inorder traversal visits every node once:

```text
O(n + m)
```

Then I merge the two lists, which also takes:

```text
O(n + m)
```

So overall:

**O(n + m)**

## Space Complexity

I store the inorder elements of both trees and the final answer.

So the extra space is:

**O(n + m)**

The recursive inorder calls also use stack space depending on the height of the trees.

## Key Takeaway

The main thing I want to remember from this problem is:

```text
BST
 ↓
Inorder traversal
 ↓
Sorted list
 ↓
Merge with two pointers
```

So if I see two BSTs and need their elements in sorted order, I should immediately think about **inorder traversal first**.
