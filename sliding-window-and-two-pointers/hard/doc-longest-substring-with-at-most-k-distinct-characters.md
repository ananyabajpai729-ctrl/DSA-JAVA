# Longest Substring with At Most K Distinct Characters

## Problem Statement

Given a string `s` and an integer `k`, return the length of the longest substring that contains **at most `k` distinct characters**.

---

## Intuition

Our window is valid as long as it contains **at most `k` distinct characters**.

Every time we expand the window by moving the `right` pointer, a new character enters the window. If this introduces a `(k + 1)`-th distinct character, the window becomes invalid.

Instead of restarting, we gradually move the `left` pointer, removing characters from the window until only `k` distinct characters remain.

A `HashMap` helps us keep track of the frequency of each character currently inside the window. Once a character's frequency becomes zero, it no longer belongs to the window, so we remove it from the map.

---

## Approach

- Initialize two pointers, `left` and `right`, to represent the sliding window.
- Maintain a `HashMap` storing the frequency of characters inside the current window.
- Expand the window by moving the `right` pointer.
- Add the current character to the map.
- If the number of distinct characters exceeds `k`:
  - Keep shrinking the window from the left.
  - Decrease the frequency of the leftmost character.
  - Remove it from the map if its frequency becomes zero.
- Once the window becomes valid again, update the maximum window length.
- Continue until the entire string has been processed.

---

## Dry Run

**Input:**

```text
s = "aaabbccd"
k = 2
```

Processing:

```text
Window = "aaabb"

Distinct = {a, b} ✓

Length = 5

Add 'c'

Window = "aaabbc"

Distinct = {a, b, c} ✗

Shrink from the left...

Window = "bbc"

Distinct = {b, c} ✓

Continue expanding...
```

Longest valid window:

```text
"aaabb"
```

Output:

```text
5
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(k)`

The map stores at most `k + 1` distinct characters before the window is shrunk.

---

## Key Takeaway

This is a classic **variable-size sliding window** problem where the validity of the window depends on the number of **distinct elements**.

The standard template is:

- Expand the window.
- If the condition is violated, **keep shrinking until it becomes valid again**.
- Update the answer using the valid window.

This exact pattern is reused in many problems like:

- Fruit Into Baskets
- Longest Substring with At Most Two Distinct Characters
- Longest Substring with At Most K Distinct Characters

Once you're comfortable with this template, all of these problems become small variations of the same idea.
