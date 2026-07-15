# Longest Substring Without Repeating Characters (Optimized)

## Problem Statement

Given a string `s`, return the length of the longest substring that contains no repeating characters.

---

## Intuition

In the previous approach, whenever a duplicate character was found, we moved the left pointer one step at a time until the duplicate was removed.

A better observation is that we already know **where each character was last seen**. Instead of shrinking the window character by character, we can directly move the left pointer to the position just after the previous occurrence of the duplicate.

This avoids unnecessary iterations while still maintaining a valid window.

---

## Approach

- Create an array `hash` of size `256` to store the last index where each character appeared.
- Initialize every value to `-1`, indicating that no character has been seen yet.
- Maintain a sliding window using `left` and `right`.
- For each character:
  - If it has already appeared inside the current window, move `left` directly to one position after its previous occurrence.
  - Update the maximum window length.
  - Store the current index of the character in the `hash` array.
- Continue until the end of the string.

---

## Dry Run

**Input:**

```text
s = "abba"
```

Processing:

```text
Window = "a"        ✓ Length = 1

Window = "ab"       ✓ Length = 2

Next character = 'b'

Previous 'b' found at index 1

Move left directly to index 2

Window = "b"

Next character = 'a'

Previous 'a' is before the current window,
so no need to move left.

Window = "ba"
```

Output:

```text
2
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

(The hash array has a fixed size of 256.)

---

## Key Takeaway

Instead of storing frequencies, this approach stores the **last seen index** of every character. This allows the left pointer to jump directly to the correct position whenever a duplicate is encountered, making the implementation cleaner and more efficient while still using the sliding window pattern.

Whenever a problem involves duplicates and the position of the previous occurrence is enough to restore the window, storing the **last occurrence** is often a better choice than maintaining frequencies.
