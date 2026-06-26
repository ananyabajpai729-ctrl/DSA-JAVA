# Combination Sum II

## Problem Statement

Given a collection of candidate numbers (which may contain duplicates) and a target integer `target`, return all **unique combinations** where the chosen numbers sum to the target.

Each number in the array **may be used at most once** in each combination.

---

## Approach

This problem is solved using **backtracking**.

Unlike **Combination Sum I**, where an element can be reused multiple times, here every element can be chosen only once.

To avoid duplicate combinations:

- Sort the array.
- Skip duplicate elements at the same recursion level.
- Stop exploring a branch if the current element becomes larger than the remaining target.

---

## Intuition

Consider:

```text
candidates = [10,1,2,7,6,1,5]
target = 8
```

After sorting:

```text
[1,1,2,5,6,7,10]
```

Suppose we have already explored combinations starting with the **first** `1`.

If we again start with the **second** `1`, we will generate exactly the same combinations.

To prevent this, we ignore duplicate values occurring at the same recursion level.

---

## Recursion Tree (Simplified)

### Input

```text
candidates = [1,2,5]
target = 5
```

```text
                 []
          /       |       \
         1        2        5
      /   \       |        |
     2     5      5      [5]
    /      |
 [1,2]   [1,5]
```

Valid combinations:

```text
[5]
```

If the target were:

```text
3
```

then:

```text
[1,2]
```

would be generated.

---

## Algorithm

1. Sort the array.
2. Iterate through the candidates starting from the current index.
3. Skip duplicate values at the same recursion level.
4. If the current value exceeds the remaining target, stop exploring further.
5. Include the current element in the combination.
6. Recurse for the next index (`i + 1`) since each element can be used only once.
7. Backtrack by removing the last chosen element.

---

## Dry Run

### Input

```text
candidates = [1,1,2,5]
target = 3
```

Sorted array:

```text
[1,1,2,5]
```

Start with first `1`:

```text
[1]
```

Choose `2`:

```text
[1,2]
Remaining = 0
```

Store the combination.

Backtrack.

At the root level:

```text
First 1 explored
Second 1 skipped
```

because it would produce the same combinations.

Output:

```text
[
 [1,2]
]
```

---

## Why Sorting is Necessary

Sorting places duplicate values together.

```text
Before Sorting

1 2 1 5
```

```text
After Sorting

1 1 2 5
```

Now duplicate values become adjacent, making them easy to detect and skip.

---

## Why Do We Skip Duplicates?

Suppose:

```text
[1,1,2]
```

If we choose:

```text
First 1 → 2
```

and later also choose:

```text
Second 1 → 2
```

both produce:

```text
[1,2]
```

Skipping duplicate values at the same recursion level prevents generating identical combinations.

---

## Why Do We Break When Current Element > Remaining?

Since the array is sorted:

```text
Current > Remaining
```

implies

```text
All subsequent elements are also greater.
```

Therefore, no valid combination can be formed.

This pruning significantly reduces unnecessary recursive calls.

---

## Why Does This Work?

For every recursive call, we choose one candidate and recursively search for the remaining target using only the elements that come after it.

Sorting, duplicate skipping, and pruning together ensure that:

- Every valid combination is generated.
- No combination is repeated.
- Unnecessary recursion is avoided.

---

## Time Complexity

The recursion explores subsets of the array.

Worst-case complexity is exponential:

```text
O(2^N)
```

although pruning often makes it much faster in practice.

---

## Space Complexity

Recursive stack:

```text
O(N)
```

Extra space for storing the answer depends on the number of valid combinations.

---

## Key Learning

This problem introduces the **Choice from Loop** backtracking pattern.

Instead of making only two choices (Take / Not Take), we iterate through all available candidates and recursively choose one at a time.

To solve problems with duplicate elements:

- Sort the input.
- Skip duplicates at the same recursion level.
- Backtrack after exploring each choice.

---

## Pattern

- Backtracking
- Choice from Loop
- Combination Generation
- Duplicate Handling
- Pruning

Similar Problems:

- Combination Sum
- Subsets II
- Permutations II
- Palindrome Partitioning
- Letter Combinations of a Phone Number

---

## Core Insight

The solution relies on three important ideas:

- **Sort** the array to group duplicates together.
- **Skip duplicate values** at the same recursion level to avoid repeated combinations.
- **Move to the next index (`i + 1`)** after choosing an element so that each number is used at most once.
