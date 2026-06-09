# K-th Element of Two Sorted Arrays

## 📝 Problem Description
Given two sorted arrays `a` and `b` of sizes `m` and `n` respectively, find the **k-th** smallest element of the combined sorted arrays. 

* **Time Complexity Requirement:** $\mathcal{O}(\log(\min(m, n)))$
* **Space Complexity Requirement:** $\mathcal{O}(1)$
* **Index Base:** 1-indexed (e.g., $k=1$ returns the absolute smallest element).

---

## 🚀 Solution Approach: Binary Search Optimization
Instead of merging the two arrays in $\mathcal{O}(m + n)$ time, this solution uses **binary search over the partition sizes**. 

The goal is to divide both arrays into a "left half" and a "right half" such that:
1. The left half contains exactly `k` elements in total.
2. Every element in the left half is less than or equal to every element in the right half.

### Partition Mechanics
We pick `mid1` elements from array `a` and `mid2` elements from array `b` such that:
$$\text{mid1} + \text{mid2} = k$$

We look at the boundary elements around our cuts:
* `l1`: Max element on the left side of array `a` (`a[mid1 - 1]`)
* `r1`: Min element on the right side of array `a` (`a[mid1]`)
* `l2`: Max element on the left side of array `b` (`b[mid2 - 1]`)
* `r2`: Min element on the right side of array `b` (`b[mid2]`)

A valid partition is found when:
$$\text{l1} \le \text{r2} \quad \text{and} \quad \text{l2} \le \text{r1}$$

Once this condition is met, the $k$-th smallest element is the maximum of the two left boundary elements: $\max(\text{l1}, \text{l2})$.

---

## 🔍 Critical Implementation Details

### 1. The Array Size Swap ($m > n$)
By ensuring that binary search runs on the **smaller array**, we keep the runtime bounded to the length of the smaller dataset. This protects the algorithm against edge cases where array `a` might be vastly larger than `b`.

### 2. Search Boundaries Setup
* **`low = Math.max(0, k - n)`**: If `k` is larger than the total length of array `b` (`n`), we are structurally forced to pick at least `k - n` elements from array `a`.
* **`high = Math.min(k, m)`**: We cannot choose more elements than the total capacity of array `a` (`m`), nor can we pick more than `k` elements.

### 3. Out-of-Bounds Protection
When the partition boundary falls on the absolute edge of an array (0 or maximum length), `Integer.MIN_VALUE` and `Integer.MAX_VALUE` act as safe conceptual buffers. They prevent `ArrayIndexOutOfBoundsException` errors while naturally satisfying or failing the cross-validation logic.

---

## 📊 Complexity Analysis

| Metric | Complexity | Rationale |
| :--- | :--- | :--- |
| **Time Complexity** | $\mathcal{O}(\log(\min(m, n)))$ | Binary search range halves on each iteration on the smaller array. |
| **Space Complexity** | $\mathcal{O}(1)$ | Only localized pointer/integer tracking values are retained in memory. |
