# Letter Combinations of a Phone Number

## Problem Statement

Given a string containing digits from `2` to `9`, return all possible letter combinations that the number could represent based on the telephone keypad.

---

## Intuition

Each digit maps to a set of letters. For every digit, we try each possible letter and recursively move to the next digit.

Once all digits have been processed, the current string forms one valid combination.

---

## Approach

1. Store the keypad mapping for digits `2` to `9`.
2. Start recursion from the first digit.
3. For the current digit, iterate through all its mapped letters.
4. Append a letter to the current string.
5. Recurse for the next digit.
6. Backtrack by removing the last appended letter.

---

## Dry Run

**Input:**

```text
digits = "23"
```

Mappings:

```text
2 → abc
3 → def
```

Generated combinations:

```text
ad
ae
af
bd
be
bf
cd
ce
cf
```

---

## Time Complexity

- **Time:** `O(4^N)` (each digit can have at most 4 letters)
- **Space:** `O(N)` recursion stack (excluding output)

---

## Key Takeaway

This is a **Backtracking + Choice from Loop** problem.

At every digit, try each possible letter, recurse for the next digit, and backtrack to explore the remaining choices.
