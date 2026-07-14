# The Celebrity Problem

## Problem Statement

Given an `n × n` matrix `M`, where:

- `M[i][j] = 1` means person `i` knows person `j`.
- `M[i][j] = 0` means person `i` does not know person `j`.

Return the index of the celebrity if one exists, otherwise return `-1`.

A celebrity:
- Knows **no one**.
- Is **known by everyone else**.

---

## Intuition

A celebrity can be identified by eliminating non-celebrities one by one.

Using two pointers:

- If person `top` knows person `bottom`, then `top` cannot be the celebrity.
- Otherwise, `bottom` cannot be the celebrity.

After repeatedly eliminating candidates, only one possible celebrity remains. Finally, verify whether this person satisfies the celebrity conditions.

---

## Approach

1. Initialize two pointers:
   - `top = 0`
   - `bottom = n - 1`
2. While `top < bottom`:
   - If `top` knows `bottom`, eliminate `top`.
   - Else if `bottom` knows `top`, eliminate `bottom`.
   - Otherwise, eliminate both.
3. The remaining person is the only possible celebrity.
4. Verify:
   - They know nobody.
   - Everyone else knows them.
5. Return the index if valid; otherwise return `-1`.

---

## Dry Run

**Input:**

```text
M =
[
 [0,1,1],
 [0,0,0],
 [0,1,0]
]
```

Elimination:

```text
top = 0, bottom = 2

0 knows 2 → eliminate 0

top = 1, bottom = 2

2 knows 1 → eliminate 2

Candidate = 1
```

Verification:

```text
Person 1 knows nobody.
Everyone knows person 1.
```

Output:

```text
1
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Key Takeaway

The elimination phase guarantees that only one potential celebrity remains by discarding at least one candidate in every comparison. A final verification pass confirms whether the remaining person actually satisfies the celebrity conditions.
