# Generate All Binary Strings Without Consecutive 1s

## Problem Statement

Generate all binary strings of length `N` such that no two consecutive `1`s appear in the string.

---

## Approach

This problem can be solved using **recursion and backtracking**.

At every position, we have two choices:

- Append `'0'` (always allowed)
- Append `'1'` (allowed only if the previous character is `'0'` or the string is currently empty)

Instead of generating all binary strings and filtering invalid ones later, we enforce the constraint during generation itself.

---

## Intuition

For a binary string:

```text
...0
```

the next character can be:

```text
0
1
```

But for:

```text
...1
```

the next character can only be:

```text
0
```

Otherwise, we would create consecutive `1`s.

By applying this rule at every recursive call, we generate only valid strings.

---

## Recursion Tree (N = 3)

```text
                    ""
                 /      \
               0          1
             /   \         \
           00    01        10
          / \    / \      /  \
       000 001 010  ✗   100 101
```

The branch producing `"011"` is never explored because it contains consecutive `1`s.

Generated strings:

```text
000
001
010
100
101
```

---

## Algorithm

1. Start with an empty string.
2. Always append `'0'` and recurse.
3. Append `'1'` only when:
   - the string is empty, or
   - the last character is `'0'`.
4. When the length becomes `N`, add the string to the answer list.
5. Continue until all valid strings are generated.

---

## Dry Run

### Input

```text
N = 2
```

### Recursive Calls

```text
""
├── "0"
│   ├── "00"
│   └── "01"
│
└── "1"
    └── "10"
```

### Output

```text
["00", "01", "10"]
```

---

## Why Does This Work?

The recursion builds strings one character at a time.

Since a `'1'` is only added when the previous character is not `'1'`, every generated string automatically satisfies the condition.

Invalid strings are never explored.

---

## Time Complexity

Let `K` be the number of valid binary strings generated.

Each valid string is constructed exactly once.

```text
O(K × N)
```

In the worst case:

```text
K < 2^N
```

Therefore:

```text
O(N × 2^N)
```

---

## Space Complexity

Recursive stack depth:

```text
O(N)
```

Answer storage:

```text
O(K × N)
```

---

## Key Learning

This problem demonstrates **constraint-based backtracking**.

Instead of generating all possibilities and checking validity later, we prevent invalid choices from being made in the first place.

---

## Pattern

- Recursion
- Backtracking
- Generate All Possibilities
- Constraint-Based Generation

Similar problems:

- Generate Parentheses
- N-Queens
- Letter Combinations of a Phone Number
- Combination Sum
- Palindrome Partitioning
