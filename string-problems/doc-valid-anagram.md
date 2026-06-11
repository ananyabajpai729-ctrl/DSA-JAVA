# Valid Anagram

## Approach

Two strings are anagrams if they contain the same characters with the same frequencies.

Since the strings consist of lowercase English letters, we can use a frequency array of size `26` instead of a HashMap.

The idea is:

- Traverse both strings simultaneously.
- Increment the count for characters in `s`.
- Decrement the count for characters in `t`.
- If the strings are anagrams, all frequencies will become `0` by the end.

This approach is both simple and efficient.

## Algorithm

1. If the lengths of the two strings are different, return `false`.
2. Create an integer array of size `26` to store character frequencies.
3. Traverse both strings:
   - Increment the count for the current character in `s`.
   - Decrement the count for the current character in `t`.
4. Traverse the frequency array.
5. If any value is not `0`, return `false`.
6. Otherwise, return `true`.

## Example

**Input**

```java
s = "anagram"
t = "nagaram"
```

**Execution**

Frequency updates:

```text
a → +1, -1
n → +1, -1
a → +1, -1
g → +1, -1
r → +1, -1
a → +1, -1
m → +1, -1
```

All character frequencies become:

```text
[0, 0, 0, ..., 0]
```

**Output**

```java
true
```

### Another Example

**Input**

```java
s = "rat"
t = "car"
```

After updating frequencies, some counts remain non-zero.

**Output**

```java
false
```

## Time Complexity

- **O(n)**

We traverse both strings once and then scan a fixed-size array of 26 elements.

## Space Complexity

- **O(1)**

The frequency array has a constant size of 26.
