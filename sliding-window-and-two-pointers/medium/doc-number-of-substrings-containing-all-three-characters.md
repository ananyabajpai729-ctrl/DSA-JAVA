# Number of Substrings Containing All Three Characters

## Problem Statement

Given a string `s` consisting only of `'a'`, `'b'`, and `'c'`, return the number of substrings that contain at least one occurrence of all three characters.

---

## Intuition

A substring becomes **valid** as soon as it contains all three characters: `'a'`, `'b'`, and `'c'`.

An interesting observation is that once a window is valid, **every extension of that window to the right is also valid** because adding more characters cannot remove an existing `'a'`, `'b'`, or `'c'`.

So, if the current valid window ends at index `right`, then all substrings ending from `right` to the end of the string are valid.

Instead of counting them one by one, we add them all at once:

```text
n - right
```

where `n` is the length of the string.

---

## Approach

- Maintain a sliding window using two pointers.
- Use an array of size `3` to store the frequency of `'a'`, `'b'`, and `'c'`.
- Expand the window by moving the `right` pointer.
- Whenever the window contains all three characters:
  - Add

```text
n - right
```

to the answer since every longer substring starting at the current `left` will also be valid.
  - Shrink the window from the left to look for more valid starting positions.
- Continue until the entire string has been processed.

---

## Dry Run

**Input:**

```text
s = "abcabc"
```

Processing:

```text
Window = "abc" ✓

All substrings starting at left = 0 and ending at
indices 2, 3, 4, 5 are valid.

Count += 6 - 2 = 4

Shrink from left...

Window becomes invalid.

Continue expanding...
```

Output:

```text
10
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

The frequency array stores counts for only three characters.

---

## Key Takeaway

This problem introduces another useful sliding window insight:

Once a window satisfies the required condition, **every larger window formed by extending it to the right also satisfies the condition**.

Instead of checking each of those substrings individually, count them together using:

```text
n - right
```

This pattern is common in problems asking for the **number of valid subarrays or substrings** rather than just the longest or shortest one.
