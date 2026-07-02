# Single Number

## Problem Statement

Given a non-empty array of integers where every element appears exactly twice except for one element, find that single element.

The solution must run in linear time and use constant extra space.

---

## Intuition

XOR has two important properties:

- `x ^ x = 0`
- `x ^ 0 = x`

Since every duplicate appears exactly twice, their XOR becomes `0`. The only value left after XOR-ing all elements is the unique element.

---

## Approach

1. Initialize the answer with the first element.
2. XOR it with every remaining element.
3. Duplicate numbers cancel each other out.
4. Return the final XOR value.

---

## Dry Run

**Input:**

```text
nums = [4, 1, 2, 1, 2]
```

XOR progression:

```text
4
4 ^ 1 = 5
5 ^ 2 = 7
7 ^ 1 = 6
6 ^ 2 = 4
```

Output:

```text
4
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Key Takeaway

The key observation is that XOR cancels out duplicate values:

```text
a ^ a = 0
```

After XOR-ing every element in the array, only the element that appears once remains.
