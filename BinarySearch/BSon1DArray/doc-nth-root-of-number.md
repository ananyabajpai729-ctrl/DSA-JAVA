# Find Nth Root of a Number

## Approach

The task is to find an integer `x` such that:

```text
xⁿ = M
```

If no such integer exists, we return `-1`.

Instead of checking every number from `1` to `M`, we use Binary Search to efficiently find the answer.

For each middle value:

- Compute `midⁿ`.
- If it equals `M`, we have found the Nth root.
- If it is smaller than `M`, search in the right half.
- If it is greater than `M`, search in the left half.

To avoid unnecessary calculations, we stop computing powers as soon as the result exceeds `M`.

## Algorithm

1. Initialize `start = 1` and `end = M`.
2. While `start <= end`:
   - Find the middle value `mid`.
   - Calculate `midⁿ`.
   - If `midⁿ == M`, return `mid`.
   - If `midⁿ < M`, search in the right half.
   - Otherwise, search in the left half.
3. If no valid root is found, return `-1`.

## Example 1

**Input**

```java
N = 3
M = 27
```

**Execution**

- mid = 14 → 14³ > 27
- Search left half

- mid = 7 → 7³ > 27
- Search left half

- mid = 3 → 3³ = 27

**Output**

```java
3
```

## Example 2

**Input**

```java
N = 4
M = 69
```

No integer exists such that:

```text
x⁴ = 69
```

**Output**

```java
-1
```

## Time Complexity

- **O(N × log M)**

For every Binary Search step, we may calculate up to `N` multiplications.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
