# Maximum Nesting Depth of the Parentheses

## Approach

The nesting depth of a parentheses string represents the maximum number of open parentheses that are active at any point.

We can track this using a counter:

- When we encounter `'('`, increase the current depth.
- When we encounter `')'`, decrease the current depth.
- After every update, maintain the maximum depth seen so far.

The highest value reached by the counter is the answer.

## Algorithm

1. Initialize:
   - `depth = 0` to track the current nesting level.
   - `maxDepth = 0` to store the maximum depth encountered.
2. Traverse the string character by character.
3. If the current character is `'('`:
   - Increment `depth`.
4. If the current character is `')'`:
   - Decrement `depth`.
5. Update `maxDepth` with the maximum of its current value and `depth`.
6. Return `maxDepth`.

## Example

**Input**

```java
s = "(1+(2*3)+((8)/4))+1"
```

**Execution**

```text
(
depth = 1

(
depth = 2

(
depth = 3
```

The maximum value reached by `depth` is:

```text
3
```

**Output**

```java
3
```

## Time Complexity

- **O(n)**

We traverse the string exactly once.

## Space Complexity

- **O(1)**

Only a few variables are used.

## Small Improvement

Instead of:

```java
int maxDepth = Integer.MIN_VALUE;
```

you can initialize:

```java
int maxDepth = 0;
```

Since the nesting depth can never be negative, `0` is a more natural starting value and makes the code easier to understand.
