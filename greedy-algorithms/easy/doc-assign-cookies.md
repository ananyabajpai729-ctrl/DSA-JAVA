# Assign Cookies

## Problem Statement

You are given:

- An array `g`, where `g[i]` represents the minimum cookie size required to satisfy the `i-th` child.
- An array `s`, where `s[j]` represents the size of the `j-th` cookie.

Each child can receive **at most one cookie**, and each cookie can be assigned to **only one child**.

Return the **maximum number of satisfied children**.

---

## Intuition

At first, it may seem reasonable to try every possible assignment of cookies to children.

However, to maximize the number of satisfied children, we should avoid wasting large cookies on children who can already be satisfied with smaller ones.

The greedy idea is:

- Give the **smallest available cookie** that can satisfy the **least greedy child**.

If the current cookie is too small, it cannot satisfy this child or any greedier child, so we discard it and try the next larger cookie.

This strategy ensures that larger cookies are preserved for children who actually need them.

---

## Approach

- Sort both arrays:
  - `g` (children's greed factors)
  - `s` (cookie sizes)
- Use two pointers:
  - `i` → current child.
  - `j` → current cookie.
- While both pointers are within bounds:
  - If the current cookie satisfies the current child:
    - Count the child as satisfied.
    - Move to the next child.
  - Regardless, move to the next cookie since each cookie can only be used once.
- Return the total number of satisfied children.

---

## Dry Run

**Input:**

```text
g = [1,2,3]
s = [1,1]
```

After sorting:

```text
Children : [1,2,3]

Cookies  : [1,1]
```

Processing:

```text
Child needs 1

Cookie = 1 ✓

Satisfied = 1

----------------

Child needs 2

Cookie = 1 ✗

Too small

No cookies left
```

Output:

```text
1
```

---

### Another Example

```text
g = [1,2]

s = [1,2,3]
```

Processing:

```text
Child 1 ← Cookie 1 ✓

Child 2 ← Cookie 2 ✓

Satisfied = 2
```

Output:

```text
2
```

---

## Time Complexity

- **Time:** `O(n log n + m log m)`

Sorting both arrays dominates the complexity.

- **Space:** `O(1)`

Ignoring the space used by the sorting algorithm.

---

## Key Takeaway

This is a classic **Greedy** problem.

The strategy is simple:

> **Always satisfy the least demanding child with the smallest possible cookie.**

Why?

- Using a larger cookie than necessary doesn't increase the number of satisfied children.
- Saving larger cookies gives you a better chance of satisfying greedier children later.

A good sign that a greedy approach might work is when making the **locally optimal choice** (smallest suitable cookie) naturally leads to the **globally optimal answer** (maximum satisfied children).

This "sort both arrays + two pointers" pattern appears in many interval matching and assignment problems.
