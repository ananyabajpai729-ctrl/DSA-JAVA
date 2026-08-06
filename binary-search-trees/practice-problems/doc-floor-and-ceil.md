# Floor and Ceil in a Binary Search Tree

## Problem Statement

Given the root of a Binary Search Tree (BST) and an integer `key`, find:

- **Floor** → the greatest value in the BST that is less than or equal to the key.
- **Ceil** → the smallest value in the BST that is greater than or equal to the key.

If either doesn't exist, return `-1` for that value.

---

## Intuition

The ordering property of a BST makes this problem much easier.

```text
Left Subtree  < Root < Right Subtree
```

Instead of checking every node, we can gradually improve our answer while traversing the tree.

### Finding the Floor

The floor is the **largest value ≤ key**.

- If the current node is greater than the key, it cannot be the floor, so move left.
- If the current node is smaller than the key, it is a valid candidate for the floor. Store it and try to find an even larger valid value by moving right.
- If the current node equals the key, we've found the best possible floor.

### Finding the Ceil

The ceil is the **smallest value ≥ key**.

- If the current node is smaller than the key, it cannot be the ceil, so move right.
- If the current node is greater than the key, it is a valid candidate for the ceil. Store it and try to find an even smaller valid value by moving left.
- If the current node equals the key, we've found the best possible ceil.

Although both operations are very similar, I found it easier to think of them separately because one searches for the **largest smaller value**, while the other searches for the **smallest larger value**.

---

## Approach

Initialize:

```text
floor = -1

ceil = -1
```

### Find Floor

Start from the root.

While the current node is not `null`:

- If the current value equals the key:
  - Store it as the floor.
  - Stop searching.
- If the current value is smaller than the key:
  - Update the floor.
  - Move to the right subtree.
- Otherwise:
  - Move to the left subtree.

---

### Find Ceil

Again, start from the root.

While the current node is not `null`:

- If the current value equals the key:
  - Store it as the ceil.
  - Stop searching.
- If the current value is greater than the key:
  - Update the ceil.
  - Move to the left subtree.
- Otherwise:
  - Move to the right subtree.

Finally, return both values.

---

## Dry Run

**Input**

```text
        8
      /   \
     4     12
    / \    / \
   2   6  10 14
```

Key:

```text
9
```

---

### Finding Floor

Current:

```text
8
```

Since

```text
8 < 9
```

Store:

```text
floor = 8
```

Move right.

---

Current:

```text
12
```

Since

```text
12 > 9
```

Move left.

---

Current:

```text
10
```

Since

```text
10 > 9
```

Move left.

Reach `null`.

Final Floor:

```text
8
```

---

### Finding Ceil

Current:

```text
8
```

Since

```text
8 < 9
```

Move right.

---

Current:

```text
12
```

Since

```text
12 > 9
```

Store:

```text
ceil = 12
```

Move left.

---

Current:

```text
10
```

Since

```text
10 > 9
```

Update:

```text
ceil = 10
```

Move left.

Reach `null`.

Final Ceil:

```text
10
```

Answer:

```text
[8,10]
```

---

## Time Complexity

- **Time:** `O(h)`

  where `h` is the height of the BST.

  - Balanced BST: `O(log n)`
  - Skewed BST: `O(n)`

- **Space:** `O(1)`

  The solution is completely iterative and uses only a few variables.

---

## Key Takeaway

This problem highlights how the BST property lets us search intelligently instead of scanning the entire tree.

For the **floor**, every time we move right, we've found a better candidate.

```text
Current < Key

↓

Possible Floor

↓

Go Right
```

For the **ceil**, every time we move left, we've found a better candidate.

```text
Current > Key

↓

Possible Ceil

↓

Go Left
```

One thing I noticed is that the logic for floor and ceil is almost a mirror image of each other. The only difference is the comparison and the direction of movement. Once I understood that symmetry, the implementation became much easier to remember.
