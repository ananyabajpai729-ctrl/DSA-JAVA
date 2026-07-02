# Minimum Bit Flips to Convert Number

## Problem Statement

Given two integers `start` and `goal`, determine the minimum number of bit flips required to convert `start` into `goal`.

A bit flip changes a `0` to `1` or a `1` to `0`.

---

## Intuition

A bit needs to be flipped only if it differs in the two numbers.

Using the XOR (`^`) operation:

- Same bits → `0`
- Different bits → `1`

So, after computing:

```text
start ^ goal
```

every set bit (`1`) represents a position that must be flipped.

The problem therefore becomes counting the number of set bits in the XOR result.

---

## Approach

1. Compute `start ^ goal`.
2. Traverse all 32 bits of the integer.
3. Check the least significant bit using `num & 1`.
4. Add it to the count.
5. Right shift the number and continue.
6. Return the total count.

---

## Example

**Input**

```text
start = 10
goal = 7
```

Binary representation:

```text
10 = 1010
 7 = 0111
```

XOR:

```text
1010
0111
----
1101
```

There are `3` set bits in `1101`.

**Output**

```text
3
```

---

## Time Complexity

- **Time:** `O(32)` ≈ `O(1)`
- **Space:** `O(1)`

---

## Key Takeaway

The XOR operation directly highlights the bit positions that differ between two numbers. Counting the set bits in `start ^ goal` gives the minimum number of flips required.
