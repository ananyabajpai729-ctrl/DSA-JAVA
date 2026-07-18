# Longest Substring Without Repeating Characters (Optimized)

## Problem Statement

Given a string `s`, return the length of the longest substring that contains **no repeating characters**.

---

## Intuition

A sliding window naturally fits this problem because we need a **contiguous substring** with all unique characters.

A common solution uses a `HashMap` to store character frequencies and shrinks the window one step at a time whenever a duplicate appears.

This solution goes one step further.

Instead of moving the `left` pointer one position at a time, we remember the **last index where every character was seen**.

So when a duplicate is encountered, we can **jump the left pointer directly** to the position after its previous occurrence.

This avoids unnecessary iterations while still maintaining a valid window.

---

## Approach

- Create an array `hash` of size `256` to store the last occurrence of each character.
- Initialize every entry to `-1`, indicating that no character has been seen yet.
- Maintain two pointers:
  - `left` → start of the current window.
  - `right` → expands the window.
- For every character:
  - Check whether it was previously seen **inside the current window**.
  - If yes, move `left` directly to:

```text
lastOccurrence + 1
```

- Update the maximum window length.
- Store the current index as the latest occurrence of that character.

---

## Dry Run

**Input:**

```text
s = "abcabcbb"
```

Processing:

```text
Window = "abc"

Length = 3

----------------

Current character = 'a'

Last occurrence = 0

Move left to 1

Window = "bca"

Length = 3

----------------

Current character = 'b'

Last occurrence = 1

Move left to 2

Window = "cab"

Continue...
```

Longest substring:

```text
"abc"
```

Output:

```text
3
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

The array has a fixed size of `256`, so the extra space is constant.

---

## Key Takeaway

The biggest optimization here is replacing **frequency counting** with **last occurrence tracking**.

Instead of shrinking the window character by character, we directly jump the left pointer to the only position where the window can become valid again.

A useful condition to remember is:

```text
if(lastOccurrence >= left)
```

This means the previous occurrence lies **inside the current window**, making the current window invalid.

Also notice the update:

```java
left = Math.max(left, lastOccurrence + 1);
```

Using `Math.max` is important because the previous occurrence might already be **outside** the current window. We should never move the `left` pointer backwards.

This optimization reduces unnecessary work while keeping the solution linear, making it the preferred approach for this problem.
