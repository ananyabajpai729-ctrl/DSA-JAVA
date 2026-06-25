# Count Subsequences with Target Sum

## Problem Statement

Given an array `nums` and an integer `k`, count the number of subsequences whose sum is equal to `k`.

A subsequence is formed by choosing elements while maintaining their relative order.

---

## Approach

This problem follows the classic **Take / Not Take** recursion pattern.

For every element, we have two choices:

1. Exclude the current element from the subsequence.
2. Include the current element in the subsequence.

We recursively explore both possibilities and keep track of the current sum.

When all elements have been processed, we check whether the accumulated sum equals the target `k`.

---

## Intuition

Consider:

```text
nums = [1, 2]
k = 3
```

For each element:

```text
Take it
OR
Don't take it
```

This creates a binary recursion tree.

The subsequence:

```text
[1, 2]
```

produces:

```text
1 + 2 = 3
```

so it contributes to the answer.

---

## Recursion Tree

### Input

```text
nums = [1, 2]
k = 3
```

```text
                    sum = 0
                   /       \
             Skip 1       Take 1
             sum=0         sum=1
             /  \          /   \
        Skip2 Take2   Skip2   Take2
         0      2       1       3
```

Leaf sums:

```text
0
2
1
3
```

Only:

```text
3
```

matches the target.

Answer:

```text
1
```

---

## Algorithm

For every index:

### Choice 1: Exclude Current Element

Move to the next index without changing the sum.

### Choice 2: Include Current Element

Add the current element to the sum and move to the next index.

### Base Case

When:

```text
index == nums.length
```

all decisions have been made.

If:

```text
sum == k
```

increment the count.

---

## Dry Run

### Input

```text
nums = [1, 2, 1]
k = 2
```

Possible subsequences:

```text
[]
[1]
[2]
[1]
[1,2]
[1,1]
[2,1]
[1,2,1]
```

Their sums:

```text
0
1
2
1
3
2
3
4
```

Valid subsequences:

```text
[2]
[1,1]
```

Answer:

```text
2
```

---

## Why Does This Work?

For every element, recursion explores both possibilities:

```text
Take
Not Take
```

By the time we reach the end of the array, every possible subsequence has been generated exactly once.

Whenever the resulting sum equals `k`, we count it.

---

## Time Complexity

Each element contributes two choices:

```text
Take
Not Take
```

Total recursive calls:

```text
O(2^N)
```

---

## Space Complexity

Maximum recursion depth:

```text
O(N)
```

---

## Key Learning

Whenever a problem involves generating or counting subsequences, think:

```text
Take Current Element
OR
Skip Current Element
```

This is one of the most important recursion patterns and forms the basis for many backtracking and dynamic programming problems.

---

## Pattern

- Recursion
- Backtracking
- Subsequences
- Take / Not Take Pattern

Similar problems:

- Print All Subsequences
- Subset Sum
- Combination Sum
- Partition Equal Subset Sum
- Target Sum

---

## Core Insight

Each element has exactly two choices:

```text
Include it
Exclude it
```

Therefore, the recursion naturally forms a binary tree with:

```text
2^N
```

possible subsequences.
