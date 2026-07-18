# 3Sum

## Problem Statement

Given an integer array `nums`, return all the unique triplets:

```text
[a, b, c]
```

such that:

```text
a + b + c = 0
```

The solution set must not contain duplicate triplets.

---

## Intuition

A brute-force solution would try every possible triplet, resulting in an `O(n³)` algorithm.

A better observation is that if the array is sorted, we can fix one element and search for the remaining two using the **Two Pointer** technique.

For every element `nums[i]`, we now need to find two numbers whose sum is:

```text
-nums[i]
```

Since the remaining part of the array is sorted, two pointers can find this pair in linear time.

The only extra challenge is avoiding duplicate triplets, which is handled by skipping repeated values.

---

## Approach

- Sort the array.
- Iterate through each element and treat it as the first element of the triplet.
- Skip duplicate values of `nums[i]` to avoid generating identical triplets.
- Place:
  - `left = i + 1`
  - `right = n - 1`
- While `left < right`:
  - Compute the sum of the three elements.
  - If the sum is `0`:
    - Store the triplet.
    - Move both pointers.
    - Skip duplicate values on both sides.
  - If the sum is greater than `0`, move the `right` pointer left.
  - Otherwise, move the `left` pointer right.
- Continue until every possible first element has been processed.

---

## Dry Run

**Input:**

```text
nums = [-1,0,1,2,-1,-4]
```

After sorting:

```text
[-4,-1,-1,0,1,2]
```

Processing:

```text
Fix -4

Need pair with sum = 4

No valid pair

----------------

Fix -1

left = -1
right = 2

Sum = 0 ✓

Triplet:

[-1,-1,2]

Move both pointers

----------------

left = 0
right = 1

Sum = 0 ✓

Triplet:

[-1,0,1]

Skip duplicates

Continue...
```

Output:

```text
[
 [-1,-1,2],
 [-1,0,1]
]
```

---

## Time Complexity

- **Time:** `O(n²)`

Sorting takes `O(n log n)`, while the outer loop combined with the two-pointer search takes `O(n²)`.

- **Space:** `O(1)`

Ignoring the space required to store the output.

---

## Key Takeaway

This problem is a classic extension of the **Two Pointer** pattern.

The main idea is:

1. **Sort the array.**
2. **Fix one element.**
3. **Solve a Two Sum problem on the remaining elements using two pointers.**

Another important lesson is handling duplicates carefully:

- Skip duplicate values for the fixed element.
- After finding a valid triplet, skip duplicate values for both pointers.

This "sort + fix one element + two pointers" strategy is the foundation for solving many related problems, including **3Sum Closest**, **4Sum**, and the general **K-Sum** family of problems.
