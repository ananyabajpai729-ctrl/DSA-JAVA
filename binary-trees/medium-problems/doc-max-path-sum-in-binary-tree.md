# Binary Tree Maximum Path Sum

## Problem Statement

Given the root of a binary tree, return the **maximum path sum**.

A **path** is any sequence of connected nodes where each node appears at most once. The path does **not** have to pass through the root, and it can start and end at any nodes in the tree.

The path sum is the sum of all node values along that path.

---

## Intuition

At first glance, this problem looks very similar to **Diameter of Binary Tree**.

The difference is that instead of maximizing the **number of edges**, we now maximize the **sum of node values**.

For every node, there are two different questions we need to answer.

### 1. What is the best path that can be extended to my parent?

A parent can only continue through **one** of its children.

So we return:

```text
Node Value + max(Left Gain, Right Gain)
```

---

### 2. What is the best path with me as the highest node?

Here, we are allowed to use **both** children.

The path becomes:

```text
Left Gain

↓

Current Node

↓

Right Gain
```

Its sum is:

```text
Left Gain + Right Gain + Node Value
```

This path cannot be extended upwards because it branches into two directions, but it might be the maximum path in the entire tree.

So we update the global answer using this value.

---

## Why Ignore Negative Paths?

Suppose a subtree contributes:

```text
-8
```

Adding it would only decrease our path sum.

Instead, it is better to ignore it completely.

That's why we compute:

```java
left = Math.max(0, helper(root.left));
right = Math.max(0, helper(root.right));
```

A negative contribution is treated as `0`, meaning:

> **"Don't include this subtree in the path."**

---

## Approach

Create a recursive helper function.

For every node:

1. If the node is `null`, return `0`.
2. Compute the maximum gain from the left subtree.
3. Compute the maximum gain from the right subtree.
4. Ignore negative gains by replacing them with `0`.
5. Compute the best path passing through the current node:

```text
left + right + root.val
```

6. Update the global maximum path sum.
7. Return the maximum gain that can be extended to the parent:

```text
root.val + max(left, right)
```

---

## Dry Run

**Input:**

```text
        -10
        /  \
       9    20
           /  \
          15   7
```

---

### Node 15

```text
Left Gain = 0

Right Gain = 0

Current Path = 15

Max Sum = 15

Return = 15
```

---

### Node 7

```text
Current Path = 7

Return = 7
```

---

### Node 20

```text
Left Gain = 15

Right Gain = 7

Current Path

15 + 20 + 7

= 42

Max Sum = 42

Return

20 + max(15,7)

= 35
```

---

### Node 9

```text
Current Path = 9

Return = 9
```

---

### Root -10

```text
Left Gain = 9

Right Gain = 35

Current Path

9 + (-10) + 35

= 34

Max Sum remains

42
```

Output:

```text
42
```

The maximum path is:

```text
15 → 20 → 7
```

---

## Recursive Call Flow

```text
helper(node)

│

├── Compute left gain

│

├── Compute right gain

│

├── Ignore negative gains

│

├── Current Path

│      left + right + node

│

├── Update global maximum

│

└── Return

node + max(left, right)
```

Notice that the returned value and the updated value are **not the same**.

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

This problem introduces an important distinction between **what we return** and **what we calculate**.

For each node, we compute two different values:

### Value returned to the parent

A parent cannot continue through both children.

So we return only one branch:

```text
Node

↓

Better of Left or Right
```

```text
return

node + max(left, right)
```

---

### Value used to update the answer

At the current node, we are free to connect both subtrees.

```text
Left

↓

Node

↓

Right
```

```text
left + right + node
```

This path ends at the current node and cannot be extended upward, but it may be the best path in the entire tree.

A good mental model is:

```text
Return

=

Best branch

-------------------

Update Answer

=

Best complete path
```

This "return one value while updating another" pattern appears in several tree problems, including **Diameter of Binary Tree**, where recursion returns the **height** while updating the **diameter**. Here, recursion returns the **maximum gain** while updating the **maximum path sum**.
