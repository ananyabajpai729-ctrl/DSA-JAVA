# Same Tree

## Problem Statement

Given the roots of two binary trees, determine whether they are **identical**.

Two trees are considered the same if:

- They have the same structure.
- The corresponding nodes have the same values.

Return `true` if both trees are identical, otherwise return `false`.

---

## Intuition

To determine whether two trees are identical, we compare them **node by node**.

For every pair of corresponding nodes, three conditions must hold:

1. Both nodes should exist.
2. Their values should be equal.
3. Their left and right subtrees should also be identical.

Since each subtree is itself a binary tree, we can recursively apply the same logic.

---

## Approach

Create a recursive function `isSameTree(p, q)`.

For every pair of nodes:

1. If both nodes are `null`, they match, so return `true`.
2. If one node is `null` and the other isn't, the structures differ, so return `false`.
3. Compare their values.
4. Recursively compare:
   - Their left subtrees.
   - Their right subtrees.
5. Return `true` only if all three conditions are satisfied:
   - Values are equal.
   - Left subtrees are identical.
   - Right subtrees are identical.

---

## Dry Run

### Input

```text
Tree 1               Tree 2

    1                   1
   / \                 / \
  2   3               2   3
```

---

### Root Nodes

```text
1 == 1

✓ Continue
```

---

### Left Subtrees

```text
2 == 2

✓ Continue
```

Their children:

```text
null == null

✓

null == null

✓
```

---

### Right Subtrees

```text
3 == 3

✓ Continue
```

Their children:

```text
null == null

✓

null == null

✓
```

Every comparison succeeds.

Output:

```text
true
```

---

### Different Example

```text
Tree 1               Tree 2

    1                   1
   /                     \
  2                       2
```

Comparison:

```text
Left child:

2 vs null

✗
```

Output:

```text
false
```

The structures differ even though the values are the same.

---

## Recursive Call Flow

```text
isSameTree(p, q)

│

├── Both null?

│      Yes → true

│

├── One null?

│      Yes → false

│

├── Values equal?

│      No → false

│

├── Compare left subtrees

│

├── Compare right subtrees

│

└── Return

valueMatch

AND

leftMatch

AND

rightMatch
```

The recursion proceeds in parallel on both trees.

---

## Time Complexity

- **Time:** `O(n)`

  Every corresponding pair of nodes is compared exactly once.

- **Space:** `O(h)`

  Where `h` is the height of the tree due to the recursive call stack.

- Best case (balanced trees): `O(log n)`
- Worst case (skewed trees): `O(n)`

---

## Key Takeaway

This problem is an example of **parallel recursion**.

Instead of traversing one tree, we traverse **two trees simultaneously**, comparing corresponding nodes at every step.

Each recursive call asks:

```text
Do these two nodes match?
```

If the answer is yes, it delegates the same question to their children:

```text
Current Nodes Match

↓

Compare Left Children

↓

Compare Right Children
```

The recursion stops immediately if:

- One tree has a node where the other doesn't.
- The values of corresponding nodes differ.

Only if **every pair of corresponding nodes** satisfies both the **structure** and **value** conditions do we conclude that the two trees are identical.
