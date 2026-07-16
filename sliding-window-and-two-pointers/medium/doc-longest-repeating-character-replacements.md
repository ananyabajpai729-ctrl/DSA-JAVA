# Longest Repeating Character Replacement

## Problem Statement

Given a string `s` consisting of uppercase English letters and an integer `k`, you can replace at most `k` characters.

Return the length of the longest substring that can be made of the same character after performing at most `k` replacements.

---

## Intuition

The key observation is that we don't need every character in the window to be the same—we only need to know **how many characters are different from the most frequent character**.

Suppose the current window has a length of `L`, and the most frequent character appears `maxFreq` times.

Then the remaining characters,

```text
L - maxFreq
```

are the ones that must be replaced to make the entire window consist of the same character.

As long as this value is less than or equal to `k`, the window is valid. Otherwise, we shrink it from the left until it becomes valid again.

---

## Approach

- Initialize a sliding window using two pointers.
- Maintain a frequency array of size `26` to count the occurrence of each character inside the current window.
- While expanding the window:
  - Update the frequency of the current character.
  - Keep track of the maximum frequency (`maxFreq`) seen inside the current window.
- If the number of required replacements,

  ```text
  Window Length - maxFreq
  ```

  exceeds `k`, shrink the window from the left.
- After every valid window, update the maximum length.

---

## Dry Run

**Input:**

```text
s = "AABABBA"
k = 1
```

Processing:

```text
Window = "AABA"

Length = 4
maxFreq = 3 ('A')

Replacements Needed = 4 - 3 = 1 ✓

Expand...

Window = "AABAB"

Length = 5
maxFreq = 3

Replacements Needed = 5 - 3 = 2 ✗

Shrink from the left until the window becomes valid again.
```

Output:

```text
4
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

The frequency array has a fixed size of `26`.

---

## Key Takeaway

This problem introduces a powerful sliding window trick: instead of directly checking whether all characters are equal, calculate **how many characters need to be changed**.

The formula

```text
Window Length - Maximum Frequency
```

tells us the minimum number of replacements required to make the entire window consist of a single repeating character.

Whenever a problem asks for the **longest window that can be made valid after modifying at most `k` elements**, this pattern is worth considering.
