# Fruit Into Baskets

## Problem Statement

You are given an array `fruits`, where each number represents a type of fruit.

You have two baskets, and each basket can hold only one type of fruit. Starting from any tree, collect fruits from consecutive trees until you encounter a third fruit type.

Return the maximum number of fruits that can be collected.

---

## Intuition

Since we can carry **at most two types of fruits**, our window remains valid as long as it contains no more than two distinct fruit types.

The moment a third fruit type appears, the window becomes invalid. Instead of starting over, we simply move the left pointer until only two fruit types remain in the window again.

A `HashMap` helps us keep track of how many fruits of each type are currently inside the window.

---

## Approach

- Initialize two pointers, `left` and `right`, to represent the sliding window.
- Use a `HashMap` to store the frequency of each fruit type in the current window.
- Expand the window by moving the `right` pointer.
- Whenever a fruit enters the window, update its frequency.
- If the window contains more than two distinct fruit types:
  - Keep removing fruits from the left.
  - Decrease their frequencies.
  - Remove a fruit type from the map once its frequency becomes zero.
- After restoring the validity of the window, update the maximum number of fruits collected.

---

## Dry Run

**Input:**

```text
fruits = [1,2,1,2,3]
```

Processing:

```text
Window = [1,2,1,2]     ✓ Types = {1,2}

Add 3

Window = [1,2,1,2,3]   ✗ Three fruit types

Move left until only two types remain.

Window = [2,3]
```

Maximum valid window:

```text
[1,2,1,2]
```

Output:

```text
4
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

Although a `HashMap` is used, it stores at most **three fruit types** at any time (before shrinking), so the extra space remains constant.

---

## Key Takeaway

This is another classic **variable-size sliding window** problem where the validity of the window depends on the number of **distinct elements** it contains. Whenever the constraint is violated, shrink the window just enough to restore validity instead of rebuilding it from scratch.

A useful pattern to remember is that if a problem asks for the **longest contiguous subarray containing at most `K` distinct elements**, a sliding window combined with a frequency map is usually the optimal approach.
