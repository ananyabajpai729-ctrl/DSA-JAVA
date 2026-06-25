# Check if a Subsequence with Target Sum Exists

## Problem Statement

Given an array `nums` and an integer `k`, determine whether there exists at least one subsequence whose sum is equal to `k`.

Return:

```text
true
```

if such a subsequence exists, otherwise return:

```text
false
```

---

## Approach

This problem uses the classic **Take / Not Take** recursion pattern.

For every element, we have two choices:

1. Include the current element in the subsequence.
2. Exclude the current element from the subsequence.

Instead of counting all valid subsequences, we only need to know whether at least one valid subsequence exists.

Therefore, we can use logical OR (`||`) between the two recursive choices.

---

## Intuition

Consider:

```text
nums = [1, 2, 3]
k = 5
```

Possible subsequences:

```text
[]
[1]
[2]
[3]
[1,2]
[1,3]
[2,3]
[1,2,3]
```

Their sums:

```text
0
1
2
3
3
4
5
6
```

Since:

```text
[2,3] → 5
```

the answer is:

```text
true
```

---

## Recursion Tree

### Input

```text
nums = [1, 2]
k = 3
```

```text
                    k=3
                  /     \
            Take 1     Skip 1
             k=2         k=3
            /   \       /   \
      Take2  Skip2  Take2  Skip2
       k=0    k=2    k=1    k=3
```

As soon as:

```text
k = 0
```

we have found a valid subsequence and can return `true`.

---

## Algorithm

At every index:

### Include Current Element

Reduce the remaining target:

```text
k = k - nums[index]
```

and move to the next index.

### Exclude Current Element

Keep the target unchanged and move to the next index.

### Base Cases

#### Valid Subsequence Found

```text
k == 0
```

Return:

```text
true
```

#### End of Array Reached

```text
index == nums.length
```

Return:

```text
k == 0
```

---

## Dry Run

### Input

```text
nums = [1, 2, 3]
k = 5
```

### Recursive Path

```text
Take 1 → k = 4
Skip 2 → k = 4
Take 3 → k = 1
```

Not valid.

Another path:

```text
Skip 1 → k = 5
Take 2 → k = 3
Take 3 → k = 0
```

Valid subsequence found.

Return:

```text
true
```

---

## Why Does This Work?

For every element, recursion explores both possibilities:

```text
Take it
OR
Skip it
```

This guarantees that every possible subsequence is examined.

If any path reaches:

```text
k == 0
```

a valid subsequence exists.

---

## Time Complexity

Each element creates two recursive branches:

```text
Take
Not Take
```

Total states:

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

There are three common subsequence recursion patterns:

### Print Subsequences

```text
Store every valid subsequence
```

### Count Subsequences

```text
Return number of valid subsequences
```

### Check Existence

```text
Return true if at least one valid subsequence exists
```

This problem belongs to the third category.

---

## Pattern

- Recursion
- Backtracking
- Subsequence Problems
- Take / Not Take Pattern

Similar problems:

- Subset Sum
- Partition Equal Subset Sum
- Target Sum
- Combination Sum
- Count Subsequences with Sum K

---

## Core Insight

For every element:

```text
Take it
OR
Leave it
```

Using:

```java
take || notTake
```

allows recursion to stop as soon as one valid subsequence is found, making it ideal for existence-check problems.
