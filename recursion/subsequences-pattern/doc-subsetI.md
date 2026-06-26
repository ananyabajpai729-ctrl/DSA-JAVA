# Subset Sums

## Problem Statement

Given an array `nums`, return the sum of every possible subset.

The order of the returned sums does not matter.

---

## Approach

This problem follows the classic **Take / Not Take** recursion pattern.

For every element, we have two choices:

1. Include the current element in the subset sum.
2. Exclude the current element from the subset sum.

Instead of storing the actual subset, we maintain only the **current sum** while exploring all possible subsets.

---

## Intuition

Consider:

```text
nums = [1,2]
```

Possible subsets are:

```text
[]
[1]
[2]
[1,2]
```

Their sums are:

```text
0
1
2
3
```

Our recursion explores every subset by deciding for each element whether to take it or not.

---

## Recursion Tree

### Input

```text
nums = [1,2]
```

```text
                     sum = 0
                    /       \
              Take 1      Skip 1
              sum = 1      sum = 0
             /     \       /      \
       Take2 Skip2 Take2 Skip2
       sum=3 sum=1 sum=2 sum=0
```

Subset sums obtained:

```text
3
1
2
0
```

---

## Algorithm

For every index:

### Choice 1: Take the Current Element

Add its value to the current sum.

```text
sum + nums[index]
```

Move to the next index.

---

### Choice 2: Do Not Take the Current Element

Keep the current sum unchanged.

Move to the next index.

---

### Base Case

When all elements have been processed:

```text
index == nums.length
```

Store the current sum.

---

## Dry Run

### Input

```text
nums = [2,3]
```

Recursive paths:

```text
Take 2
Take 3
Sum = 5
```

```text
Take 2
Skip 3
Sum = 2
```

```text
Skip 2
Take 3
Sum = 3
```

```text
Skip 2
Skip 3
Sum = 0
```

Output:

```text
[5,2,3,0]
```

(Order may vary.)

---

## Why Does This Work?

Each element has exactly two choices:

```text
Take
```

or

```text
Not Take
```

Since every element is processed independently, recursion generates all possible subsets.

Whenever a subset is fully constructed, its accumulated sum is stored.

---

## Time Complexity

Every element creates two recursive branches.

Total recursive calls:

```text
O(2^N)
```

---

## Space Complexity

Recursive call stack:

```text
O(N)
```

The output list stores one sum for every subset:

```text
O(2^N)
```

---

## Key Learning

This problem is a variation of the **Power Set** problem.

Instead of storing the subset itself, we carry only its running sum.

This reduces the amount of work done at each recursive call while still exploring every possible subset.

---

## Core Insight

Every element contributes in one of two ways:

```text
Take it
```

or

```text
Leave it
```

By maintaining a running sum instead of the actual subset, we efficiently compute the sum of every possible subset while still exploring all `2^N` combinations.
