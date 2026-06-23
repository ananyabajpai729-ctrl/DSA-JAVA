# Generate Parentheses

## Problem Statement

Given `n` pairs of parentheses, generate all combinations of well-formed parentheses.

---

## Approach

This problem can be solved using **recursion and backtracking**.

While constructing a string, we keep track of:

- `open` → number of opening brackets `'('` used so far
- `close` → number of closing brackets `')'` used so far

At every step:

- We can add `'('` if we still have opening brackets available.
- We can add `')'` only if it does not make the expression invalid.

The key constraint is:

```text
close ≤ open
```

because a closing bracket cannot appear before its matching opening bracket.

---

## Intuition

For:

```text
n = 3
```

we need a total length of:

```text
2 × n = 6
```

We start with:

```text
""
```

At each step:

- Add `'('` whenever possible.
- Add `')'` only if there are unmatched opening brackets available.

This ensures that every generated string remains valid throughout the recursion.

---

## Recursion Tree (n = 3)

```text
                    ""
                   (
                /      \
              ((        ()
            /   \      /   \
         (((   (()   ()(   ())
          |      |      |      |
       ((()   (())   ()()   ()))
```

Valid outputs:

```text
((()))
(()())
(())()
()(())
()()()
```

---

## Algorithm

1. Start with an empty string.
2. If `open < n`, add `'('` and recurse.
3. If `close < open`, add `')'` and recurse.
4. When the string length becomes `2 * n`, store it in the result.
5. Continue until all valid combinations are generated.

---

## Dry Run

### Input

```text
n = 2
```

### Recursive Calls

```text
""
|
(
|
((
|
(())
|
(())

and

()
|
()(
|
()()
```

### Output

```text
[
 "(())",
 "()()"
]
```

---

## Why Does This Work?

The recursion maintains two important rules:

### Rule 1

```text
open ≤ n
```

We cannot use more than `n` opening brackets.

### Rule 2

```text
close ≤ open
```

We cannot close more brackets than we have opened.

These rules guarantee that every generated string is valid.

---

## Time Complexity

The number of valid combinations is the **nth Catalan Number**:

```text
C(n) = (1 / (n + 1)) × (2n choose n)
```

Therefore:

```text
O(C(n))
```

Since each generated string has length:

```text
2n
```

the overall complexity is:

```text
O(C(n) × n)
```

---

## Space Complexity

### Recursive Stack

```text
O(n)
```

### Result Storage

```text
O(C(n) × n)
```

for storing all valid combinations.

---

## Key Learning

Instead of generating all possible sequences of `'('` and `')'` and checking validity later, we maintain validity during construction.

This dramatically reduces the search space.

---

## Pattern

This problem is a classic example of:

- Backtracking
- Constraint-Based Generation
- Recursion

Similar problems include:

- N-Queens
- Palindrome Partitioning
- Combination Sum
- Letter Combinations of a Phone Number
- Binary Strings Without Consecutive 1s

---

## Core Insight

A closing bracket can only be added when there is an unmatched opening bracket available.

```text
close < open
```

This single condition ensures that every generated string remains well-formed throughout the recursion.
