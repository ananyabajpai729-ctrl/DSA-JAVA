# Prime Factorization Using Smallest Prime Factor (SPF)

## Problem Statement

Given multiple integers, return the prime factorization of each number.

---

## Intuition

Finding prime factors by checking every number up to `√N` for each query is inefficient when there are many queries.

Instead, preprocess the **Smallest Prime Factor (SPF)** for every number up to the maximum query using a modified Sieve of Eratosthenes.

Once the SPF array is built, repeatedly divide a number by its smallest prime factor until it becomes `1`.

---

## Approach

1. Find the maximum value among all queries.
2. Build an SPF array where `spf[i]` stores the smallest prime factor of `i`.
3. For each query:
   - Repeatedly add `spf[num]` to the answer.
   - Divide `num` by `spf[num]`.
   - Continue until `num` becomes `1`.

---

## Dry Run

**Input:**

```text
queries = [12, 18]
```

SPF array (relevant values):

```text
spf[12] = 2
spf[6]  = 2
spf[3]  = 3

spf[18] = 2
spf[9]  = 3
spf[3]  = 3
```

Factorization:

```text
12
→ 2
→ 6
→ 2
→ 3

Factors = [2, 2, 3]
```

```text
18
→ 2
→ 9
→ 3
→ 3

Factors = [2, 3, 3]
```

Output:

```text
[
  [2, 2, 3],
  [2, 3, 3]
]
```

---

## Time Complexity

Let:

- `M` = maximum value among all queries
- `Q` = number of queries

- **Building SPF:** `O(M log log M)` (or approximately `O(M log log M)` using the sieve)
- **Factorizing each number:** `O(log N)` (each division removes at least one prime factor)
- **Overall:** `O(M log log M + Q × log M)`

**Space:** `O(M)` for the SPF array.

---

## Key Takeaway

The **Smallest Prime Factor (SPF)** technique is ideal when multiple prime factorization queries need to be answered. Although preprocessing takes time, each query is answered efficiently by repeatedly dividing by the stored smallest prime factor.
