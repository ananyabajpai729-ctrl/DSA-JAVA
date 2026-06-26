# Combination Sum

## Problem Statement

Given an array of **distinct** integers `candidates` and a target value `target`, return all unique combinations where the chosen numbers sum to the target.

A candidate number may be chosen **multiple times**.

---

## Approach

This problem is solved using **recursion and backtracking**.

For every candidate, we have two choices:

1. **Take** the current candidate.
2. **Skip** the current candidate and move to the next one.

The important observation is:

- If we **take** a candidate, we stay at the same index because the same number can be used again.
- If we **skip** a candidate, we move to the next index.

---

## Intuition

Consider:

```text
candidates = [2,3,6,7]
target = 7
```

Starting from `2`:

```text
Take 2
Target becomes 5
```

Since we can reuse `2`, we again have the option to:

```text
Take 2
```

or

```text
Skip 2 and move to 3
```

This continues until the remaining target becomes either:

```text
0  → valid combination
```

or

```text
negative / no candidates left → invalid path
```

---

## Recursion Tree

### Input

```text
candidates = [2,3]
target = 5
```

```text
                    (0,5)
                   /     \
             Take 2     Skip 2
             (0,3)       (1,5)
            /    \       /    \
      Take2  Skip2  Take3  Skip3
      (0,1)  (1,3)  (1,2)   End
                |
             Take3
             (1,0)
```

Valid combination:

```text
[2,3]
```

---

## Algorithm

For every candidate:

### Choice 1: Take the Current Candidate

- Add it to the current combination.
- Reduce the remaining target.
- Stay at the same index because the element can be reused.

### Choice 2: Skip the Current Candidate

- Remove the previously added element (backtrack).
- Move to the next candidate.

### Base Case

When all candidates have been processed:

```text
index == candidates.length
```

If the remaining target is:

```text
0
```

store the current combination.

---

## Dry Run

### Input

```text
candidates = [2,3,6,7]
target = 7
```

One successful path:

```text
Take 2
Remaining = 5

Take 2
Remaining = 3

Skip 2

Take 3
Remaining = 0
```

Combination:

```text
[2,2,3]
```

Another path:

```text
Skip 2
Skip 3
Skip 6
Take 7
Remaining = 0
```

Combination:

```text
[7]
```

Output:

```text
[
 [2,2,3],
 [7]
]
```

---

## Backtracking Explained

When a candidate is chosen:

```text
Current combination

[2,2]
```

After exploring every possibility using it, we remove the last element:

```text
[2,2]
   ↓
[2]
```

This restores the previous state so that other combinations can be explored.

---

## Why Does This Work?

At every candidate, recursion explores two possibilities:

```text
Take it
Skip it
```

Taking keeps the index unchanged because reuse is allowed.

Skipping advances to the next candidate.

This guarantees that every valid combination is generated exactly once.

---

## Time Complexity

The exact complexity depends on the number of valid combinations.

In the worst case, the recursion explores an exponential number of states.

```text
O(2^T)
```

where `T` is related to the target value and branching factor.

It is commonly described as **exponential**.

---

## Space Complexity

### Recursive Stack

Maximum recursion depth is bounded by:

```text
O(target)
```

in the worst case (when repeatedly choosing the smallest candidate).

### Result Storage

Depends on the number of valid combinations.

---

## Key Learning

This problem introduces an important variation of the Take / Not Take pattern.

Normally:

```text
Take → index + 1
```

Here:

```text
Take → same index
```

because an element can be used multiple times.

---

## Pattern

- Recursion
- Backtracking
- Combination Generation
- Take / Not Take
- Unlimited Reuse of Elements

Similar problems:

- Combination Sum II
- Subset Sum
- Count Subsequences with Sum K
- Partition Equal Subset Sum
- Coin Change

---

## Core Insight

The recursion has two choices:

```text
Take Current Candidate
```

```text
Stay at the same index
```

or

```text
Skip Current Candidate
```

```text
Move to the next index
```

This simple difference—**staying on the same index after taking an element**—is what allows unlimited reuse and distinguishes this problem from standard subsequence generation.
