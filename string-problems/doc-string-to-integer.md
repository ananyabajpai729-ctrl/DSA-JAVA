# String to Integer (atoi)

## Approach

The goal is to convert a string into a 32-bit signed integer while following the rules of the `atoi` function.

The conversion process consists of four main steps:

1. Ignore leading whitespaces.
2. Determine the sign (`+` or `-`).
3. Read consecutive digits and build the number.
4. Handle overflow by clamping the result within the 32-bit integer range.

While constructing the number, we check for overflow **before** performing:

```java
ans = ans * 10 + digit;
```

This prevents the integer from exceeding the valid range.

## Algorithm

1. If the string is empty, return `0`.
2. Skip all leading spaces.
3. Check for an optional sign:
   - `'+'` → positive
   - `'-'` → negative
4. Traverse the digits:
   - Stop when a non-digit character is encountered.
   - Convert the character into its numeric value.
   - Check whether adding the digit would cause overflow.
5. If overflow occurs:
   - Return `Integer.MAX_VALUE` for positive numbers.
   - Return `Integer.MIN_VALUE` for negative numbers.
6. Return the final number multiplied by its sign.

## Example

**Input**

```java
s = "   -42"
```

**Execution**

```text
Skip spaces
→ "-42"

Sign = -1

Read digits:
4 → ans = 4
2 → ans = 42

Result = -42
```

**Output**

```java
-42
```

### Another Example

**Input**

```java
s = "4193 with words"
```

**Execution**

```text
Read digits:
4 → 41 → 419 → 4193

Encounter ' '
Stop parsing
```

**Output**

```java
4193
```

### Overflow Example

**Input**

```java
s = "91283472332"
```

During conversion, the value exceeds the 32-bit signed integer limit.

**Output**

```java
2147483647
```

(`Integer.MAX_VALUE`)

## Overflow Check Explained

Before appending a new digit, we verify:

```java
ans > Integer.MAX_VALUE / 10
```

If true, multiplying by `10` will definitely overflow.

We also check:

```java
ans == Integer.MAX_VALUE / 10 && digit > 7
```

because:

```text
Integer.MAX_VALUE = 2147483647
```

The last valid digit is `7`.

Any digit greater than `7` would exceed the allowed range.

## Time Complexity

- **O(n)**

The string is traversed at most once.

## Space Complexity

- **O(1)**

Only a few variables are used regardless of input size.

## Why Use `digit > 7`?

The maximum positive 32-bit integer is:

```text
2147483647
```

So when:

```text
ans = 214748364
```

the largest digit we can safely append is:

```text
7
```

Any digit greater than `7` would overflow, which is why the condition uses:

```java
digit > 7
```

and immediately returns the appropriate boundary value.
