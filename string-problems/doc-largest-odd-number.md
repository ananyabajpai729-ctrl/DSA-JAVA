# Largest Odd Number in String

## Approach

To obtain the largest odd-numbered substring, we need the substring to end with an odd digit.

Since we want the **largest** possible substring, we should keep as many digits as possible from the beginning and only remove digits from the end if necessary.

The idea is simple:

- Traverse the string from right to left.
- Find the first odd digit.
- Return the substring from the beginning up to that digit.
- If no odd digit exists, return an empty string.

As soon as an odd digit is found, we have the largest possible odd-numbered substring.

## Algorithm

1. Start traversing the string from the last character.
2. Convert the current character into a digit.
3. Check whether the digit is odd.
4. If it is odd:
   - Return the substring from index `0` to `i`.
5. If no odd digit is found after the traversal:
   - Return an empty string.

## Example

**Input**

```java
num = "35427"
```

**Execution**

- Start from the end.
- Digit `7` is odd.
- Return substring from index `0` to `4`.

**Output**

```java
"35427"
```

### Another Example

**Input**

```java
num = "4206"
```

**Execution**

- 6 → even
- 0 → even
- 2 → even
- 4 → even

No odd digit exists.

**Output**

```java
""
```

## Time Complexity

- **O(n)**

In the worst case, we traverse the entire string once.

## Space Complexity

- **O(1)**

Ignoring the space required for the returned substring.
