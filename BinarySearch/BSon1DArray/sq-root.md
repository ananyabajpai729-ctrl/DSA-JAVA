# Square Root of a Number (Floor Value)

## Approach

The square root of a number `n` is the value whose square is equal to `n`. If `n` is not a perfect square, we need to return the floor value of its square root.

Instead of checking every number from `1` to `n`, we can use Binary Search to find the largest number whose square is less than or equal to `n`.

For each middle value:

- If `mid * mid <= n`, it can be a possible answer, so we store it and search for a larger valid value.
- If `mid * mid > n`, we search in the left half.

A `long` variable is used for `mid` to avoid overflow when calculating `mid * mid`.

## Algorithm

1. Initialize `start = 1` and `end = n`.
2. Maintain a variable `ans` to store the current valid square root.
3. Find the middle value.
4. If `mid * mid <= n`:
   - Update `ans = mid`.
   - Search in the right half for a larger valid value.
5. Otherwise:
   - Search in the left half.
6. Continue until the search space becomes empty.
7. Return `ans`.

## Example

**Input**

```java
n = 28
```

**Execution**

- mid = 14 → 14² = 196 > 28
- Search left half

- mid = 7 → 7² = 49 > 28
- Search left half

- mid = 3 → 3² = 9 ≤ 28
- Store ans = 3
- Search right half

- mid = 5 → 5² = 25 ≤ 28
- Store ans = 5
- Search right half

- mid = 6 → 6² = 36 > 28
- Search left half

Search ends.

**Output**

```java
5
```

Since √28 ≈ 5.29, the floor value is `5`.

## Time Complexity

- **O(log n)**

The search space is halved in every iteration.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
