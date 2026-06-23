# Pow(x, n)

## Approach

The task is to compute:

```text
xⁿ
```

efficiently.

A straightforward approach would multiply `x` exactly `n` times:

```text
x × x × x × ...
```

which takes:

```text
O(n)
```

time.

This solution uses **Binary Exponentiation (Exponentiation by Squaring)**, reducing the complexity to:

```text
O(log n)
```

by repeatedly squaring the base and halving the exponent.

## Key Idea

For an even exponent:

```text
xⁿ = (x²)ⁿᐟ²
```

Example:

```text
2⁸ = (2²)⁴
```

Instead of performing 8 multiplications, we reduce the problem size by half.

For an odd exponent:

```text
xⁿ = x × xⁿ⁻¹
```

Example:

```text
2⁵ = 2 × 2⁴
```

which immediately becomes an even exponent problem.

## Algorithm

### Base Cases

```java
if(N == 0) return 1.0;
if(N == 1) return x;
```

Because:

```text
x⁰ = 1
x¹ = x
```

---

### Even Exponent

If:

```java
N % 2 == 0
```

then:

```java
return helper(x * x, N / 2);
```

This transforms:

```text
xⁿ → (x²)ⁿᐟ²
```

---

### Odd Exponent

If:

```java
N % 2 != 0
```

then:

```java
return x * helper(x, N - 1);
```

This removes one power of `x` and converts the problem into an even exponent case.

---

### Negative Powers

For:

```text
x⁻ⁿ
```

we use:

```text
x⁻ⁿ = 1 / xⁿ
```

Code:

```java
if(N < 0){
    return 1.0 / helper(x, -N);
}
```

## Example

### Input

```text
x = 2
n = 10
```

### Recursive Calls

```text
helper(2,10)
→ helper(4,5)

helper(4,5)
→ 4 * helper(4,4)

helper(4,4)
→ helper(16,2)

helper(16,2)
→ helper(256,1)

helper(256,1)
→ 256
```

Backtracking:

```text
4 × 256 = 1024
```

### Output

```text
1024
```

## Example 2

### Input

```text
x = 2
n = -2
```

Compute:

```text
2² = 4
```

Then:

```text
1 / 4
```

### Output

```text
0.25
```

## Why Use `long`?

A very important edge case is:

```text
n = Integer.MIN_VALUE
```

which is:

```text
-2147483648
```

If we try:

```java
-n
```

using an `int`, overflow occurs because:

```text
2147483648
```

cannot fit inside an `int`.

Therefore:

```java
long N = n;
```

is used before handling negative powers.

This safely allows:

```java
-N
```

without overflow.

## Time Complexity

Each recursive call reduces the exponent significantly.

```text
O(log n)
```

## Space Complexity

Due to recursion stack:

```text
O(log n)
```

## Small Observation

Your updated solution correctly fixes the most common bug in this problem:

```java
long N = n;
```

Many submissions fail for:

```text
x = 2.0
n = -2147483648
```

because:

```java
-n
```

overflows when `n` is an `int`.

By converting to `long` first, your solution handles all valid test cases safely.

## Pattern

This problem is a classic example of:

```text
Binary Exponentiation
```

also known as:

```text
Exponentiation by Squaring
```

A technique frequently used in:

- Fast Power
- Modular Exponentiation
- Matrix Exponentiation
- Number Theory
- Competitive Programming
