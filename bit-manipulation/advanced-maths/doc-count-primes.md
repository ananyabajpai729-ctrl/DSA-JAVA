# Count Primes (Sieve of Eratosthenes)

## Problem Statement

Given an integer `n`, return the number of prime numbers that are **strictly less than** `n`.

---

## Intuition

Instead of checking each number individually for primality, mark the multiples of every prime as non-prime.

Initially, assume every number is prime. Starting from `2`, whenever a prime is found, mark all of its multiples as non-prime. The remaining unmarked numbers are primes.

---

## Approach

1. Create a boolean array `isPrime` and mark every number as prime.
2. Mark `0` and `1` as non-prime.
3. Iterate from `2` to `√n`.
4. If the current number is prime, mark all its multiples (starting from `i²`) as non-prime.
5. Count the remaining prime numbers.

---

## Dry Run

**Input:**

```text
n = 10
```

Initially:

```text
2 3 4 5 6 7 8 9
P P P P P P P P
```

Using `2`:

```text
2 3 4 5 6 7 8 9
P P X P X P X X
```

Using `3`:

```text
2 3 4 5 6 7 8 9
P P X P X P X X
```

Remaining primes:

```text
2, 3, 5, 7
```

Answer:

```text
4
```

---

## Time Complexity

- **Time:** `O(n log log n)`
- **Space:** `O(n)`

---

## Key Takeaway

The Sieve of Eratosthenes efficiently finds all prime numbers up to a limit by eliminating multiples of each prime. Starting from `i²` avoids redundant work since smaller multiples have already been marked by previous primes.
