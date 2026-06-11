# Rotate String

## Approach

To determine whether `goal` can be obtained by rotating `s`, we first check if both strings have the same length. If their lengths differ, no rotation can make them equal.

The key observation is that every possible rotation of a string is present as a substring of the string concatenated with itself.

For example:

```text
s = "abcde"

s + s = "abcdeabcde"
```

All rotations of `"abcde"` appear inside `"abcdeabcde"`:

```text
abcde
bcdea
cdeab
deabc
eabcd
```

Therefore, if `goal` is a valid rotation of `s`, it must be a substring of `s + s`.

## Algorithm

1. Check if the lengths of `s` and `goal` are equal.
2. If not, return `false`.
3. Create a new string by concatenating `s` with itself.
4. Check whether `goal` exists as a substring in the concatenated string.
5. Return the result.

## Example

**Input**

```java
s = "abcde"
goal = "cdeab"
```

**Execution**

```text
s + s = "abcdeabcde"
```

Since `"cdeab"` exists in `"abcdeabcde"`, the rotation is valid.

**Output**

```java
true
```

## Time Complexity

- **O(n²)** in the worst case, depending on the internal implementation of `contains()`.

## Space Complexity

- **O(n)**

Additional space is used for the concatenated string `s + s`.
