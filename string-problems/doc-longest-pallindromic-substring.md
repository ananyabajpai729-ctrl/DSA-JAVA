# Longest Palindromic Substring

## Approach

A palindrome reads the same forward and backward.

Instead of checking every possible substring, we treat each character as the center of a palindrome and expand outward as long as the characters on both sides match.

There are two possible palindrome centers:

1. **Odd-length palindrome** → centered on a single character.
   
   ```text
   aba
    ^
   ```

2. **Even-length palindrome** → centered between two characters.
   
   ```text
   abba
    ^^
   ```

For every index, we expand around both types of centers and keep track of the longest palindrome found.

## Algorithm

1. Initialize:
   - `start = 0`
   - `end = 0`
2. For every index `i`:
   - Find the longest odd-length palindrome centered at `i`.
   - Find the longest even-length palindrome centered between `i` and `i + 1`.
3. Take the maximum of the two lengths.
4. If this palindrome is longer than the current answer:
   - Update the start and end indices.
5. Return the substring between `start` and `end`.

## Expand Around Center

For a given center:

- Compare characters on both sides.
- If they match, expand outward.
- Stop when:
  - The indices go out of bounds, or
  - The characters no longer match.

The palindrome length is:

```text
right - left - 1
```

because the pointers move one step beyond the valid palindrome before the loop ends.

## Example

**Input**

```java
s = "babad"
```

**Execution**

Centers checked:

```text
b
a
b
a
d
```

At index `2`:

```text
bab
```

is a palindrome of length `3`.

Another palindrome is:

```text
aba
```

also of length `3`.

The algorithm returns one of the longest palindromes.

**Output**

```java
"bab"
```

### Another Example

**Input**

```java
s = "cbbd"
```

**Execution**

Even-length center:

```text
bb
^^
```

Longest palindrome:

```text
"bb"
```

**Output**

```java
"bb"
```

## Time Complexity

- **O(n²)**

For each character, we may expand across the entire string in the worst case.

## Space Complexity

- **O(1)**

Only a few variables are used; no extra data structures are required.

## Why Update Start and End Like This?

When a palindrome of length `maxLen` is centered at index `i`:

```java
start = i - (maxLen - 1) / 2;
end = i + maxLen / 2;
```

These formulas correctly handle both:

- Odd-length palindromes

```text
aba
 ^
```

- Even-length palindromes

```text
abba
 ^^
```

allowing the same logic to work for both cases.
