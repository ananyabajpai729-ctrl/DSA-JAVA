# Range Sum Query - Immutable

## Problem Statement

Given an integer array `nums`, process multiple queries of the form:

```text
sumRange(left, right)
```

where you need to return the sum of elements between indices `left` and `right` (both inclusive).

Since the array never changes, we can preprocess it once to answer every query efficiently.

---

## Intuition

If we calculate the sum from the beginning of the array up to every index, we can reuse those values instead of adding elements repeatedly for each query.

This leads us to the **Prefix Sum** technique.

For every index `i`, store:

```text
prefix[i] = nums[0] + nums[1] + ... + nums[i]
```

Now, to find the sum between `left` and `right`:

- The prefix sum till `right` contains everything we need.
- It also contains the elements before `left`.
- So, subtract the prefix sum till `left - 1`.

This gives the required range sum in constant time.

---

## Approach

### Preprocessing

- Store the given array.
- Convert it into a prefix sum array.
- Starting from index `1`, keep adding the previous prefix sum.

```text
arr[i] = arr[i] + arr[i - 1]
```

### Answering Queries

If the range starts from index `0`:

```text
answer = prefix[right]
```

Otherwise:

```text
answer = prefix[right] - prefix[left - 1]
```

---

## Dry Run

**Input:**

```text
nums = [1,2,3,4,5]
```

Prefix Sum Array:

```text
Index : 0  1  2  3  4
Value : 1  3  6 10 15
```

Query:

```text
left = 1
right = 3
```

Calculation:

```text
prefix[3] - prefix[0]

10 - 1 = 9
```

Subarray:

```text
[2,3,4]
```

Output:

```text
9
```

---

## Time Complexity

### Constructor

- **Time:** `O(n)`

### Each Query

- **Time:** `O(1)`

### Space Complexity

- **Space:** `O(1)` *(excluding the input array, since the prefix sums are stored in-place).*

---

## Key Takeaway

Whenever you have **multiple range sum queries on an immutable array**, think of **Prefix Sum**.

The preprocessing takes linear time only once, after which every query can be answered in constant time using:

```text
Range Sum = Prefix[right] - Prefix[left - 1]
```

This idea forms the foundation for many advanced data structures like **Fenwick Trees (Binary Indexed Trees)** and **Segment Trees**, which extend the concept to handle dynamic updates as well.
