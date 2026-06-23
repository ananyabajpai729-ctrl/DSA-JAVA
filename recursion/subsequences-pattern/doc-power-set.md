# Power Set (Generate All Subsequences)

## Problem Statement

Given an array of integers, generate all possible subsets (the Power Set).

A subset can contain any combination of elements, including:

- No elements (empty subset)
- All elements

---

## Approach

This problem can be solved using **recursion and backtracking**.

For every element in the array, we have exactly two choices:

1. Include the element in the current subset.
2. Exclude the element from the current subset.

By exploring both choices for every element, we generate all possible subsets.

---

## Intuition

Consider:

```text
nums = [1, 2]
```

For element `1`:

```text
Include 1
Exclude 1
```

For element `2`:

```text
Include 2
Exclude 2
```

Combining these choices gives:

```text
[1,2]
[1]
[2]
[]
```

Every element contributes two possibilities, forming a binary decision tree.

---

## Recursion Tree

### Input

```text
[1, 2, 3]
```

```text
                        []
                     /      \
                   1          -
                 /   \      /   \
               2      -    2     -
              / \    / \  / \   / \
             3  -   3 -  3 -  3  -
```

Leaf nodes represent complete subsets.

Generated subsets:

```text
[1,2,3]
[1,2]
[1,3]
[1]
[2,3]
[2]
[3]
[]
```

---

## Algorithm

For each index:

### Include Current Element

Add the current element to the subset and move to the next index.

```text
Take the element
```

### Exclude Current Element

Remove the element (backtrack) and move to the next index.

```text
Skip the element
```

### Base Case

When:

```text
index == nums.length
```

all decisions have been made, so store the current subset.

---

## Dry Run

### Input

```text
nums = [1, 2]
```

### Recursive Calls

```text
[]
│
├── Include 1 → [1]
│   │
│   ├── Include 2 → [1,2]
│   │
│   └── Exclude 2 → [1]
│
└── Exclude 1 → []
    │
    ├── Include 2 → [2]
    │
    └── Exclude 2 → []
```

### Output

```text
[
 [1,2],
 [1],
 [2],
 []
]
```

---

## Backtracking Explained

When we include an element:

```text
subset = [1,2]
```

and finish exploring that branch, we must remove it before exploring the exclusion branch.

```text
subset.remove(last element)
```

This restores the subset to its previous state.

```text
[1,2]
   ↓
[1]
```

This process is called **backtracking**.

---

## Why Does This Work?

For every element:

```text
Take it
OR
Leave it
```

Since each element has exactly two choices, every possible subset is generated exactly once.

No subset is missed and no subset is repeated.

---

## Time Complexity

For `n` elements:

Each element has:

```text
2 choices
```

Therefore:

```text
Total subsets = 2ⁿ
```

Generating each subset requires copying it into the answer list.

Overall complexity:

```text
O(n × 2ⁿ)
```

---

## Space Complexity

### Recursive Stack

```text
O(n)
```

### Result Storage

Number of subsets:

```text
2ⁿ
```

Average subset size:

```text
O(n)
```

Therefore:

```text
O(n × 2ⁿ)
```

---

## Key Learning

Whenever a problem asks for:

```text
Generate all subsets
Generate all subsequences
Take or Not Take
```

think of the pattern:

```text
Include Current Element
Exclude Current Element
```

This forms a binary recursion tree.

---

## Pattern

This problem belongs to:

- Recursion
- Backtracking
- Power Set Generation
- Subsequences

Similar problems:

- Subset Sum
- Combination Sum
- Generate Parentheses
- Palindrome Partitioning
- Letter Combinations of a Phone Number

---

## Core Insight

Every element contributes exactly two possibilities:

```text
Include it
Exclude it
```

Therefore:

```text
Total subsets = 2ⁿ
```

which is the foundation of most subsequence-based recursion problems.
