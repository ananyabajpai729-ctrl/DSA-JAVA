# Sum of Beauty of All Substrings

## Approach

The **beauty** of a string is defined as:

```text
(maximum character frequency) - (minimum character frequency)
```

considering only the characters that appear in the substring.

To calculate the beauty of all substrings:

- Fix a starting index `i`.
- Extend the substring one character at a time using index `j`.
- Maintain the frequency of characters in the current substring using a `HashMap`.
- After adding each character, find:
  - The maximum frequency.
  - The minimum frequency.
- Add `(maxFrequency - minFrequency)` to the final answer.

This way, every possible substring is processed exactly once.

## Algorithm

1. Initialize `sum = 0`.
2. For every starting index `i`:
   - Create an empty frequency map.
3. For every ending index `j ≥ i`:
   - Add `s[j]` to the frequency map.
   - Traverse all frequencies in the map:
     - Find the minimum frequency.
     - Find the maximum frequency.
   - Add `(maxi - mini)` to the answer.
4. Return the final sum.

## Example

**Input**

```java
s = "aabcb"
```

**Some Substrings**

```text
"a"      → beauty = 0
"aa"     → beauty = 0
"aab"    → frequencies: {a=2, b=1}
           beauty = 2 - 1 = 1

"aabc"   → frequencies: {a=2, b=1, c=1}
           beauty = 2 - 1 = 1
```

Summing the beauty of all substrings gives:

**Output**

```java
5
```

## Time Complexity

- **O(n² × k)**

Where:

- `n` = length of the string
- `k` = number of distinct characters in the current substring

For each substring, we iterate through the frequency map to find the minimum and maximum frequencies.

Since the problem uses lowercase English letters:

```text
k ≤ 26
```

Therefore, the complexity is effectively:

```text
O(26 × n²)
≈ O(n²)
```

## Space Complexity

- **O(k)**

The frequency map stores at most the distinct characters present in the substring.

For lowercase English letters:

```text
O(26) ≈ O(1)
```

## Small Optimization

Since the string contains only lowercase English letters, a frequency array can be used instead of a `HashMap`:

```java
int[] freq = new int[26];
```

This avoids HashMap overhead and usually runs faster while keeping the same overall complexity.
