# Remove Outermost Parentheses

## Approach

A primitive valid parentheses string is a valid parentheses sequence that cannot be divided into smaller valid parentheses strings.

The idea is to keep track of the current nesting depth using a variable `level`.

- When we encounter `'('`, the nesting depth increases.
- When we encounter `')'`, the nesting depth decreases.
- The outermost parentheses of each primitive are the ones responsible for moving the depth from `0 → 1` and from `1 → 0`.
- These outermost parentheses are skipped, while all inner parentheses are added to the result.

A `StringBuilder` is used to efficiently build the answer without creating multiple string objects.

## Algorithm

1. Initialize:
   - `level = 0`
   - An empty `StringBuilder`.
2. Traverse the string character by character.
3. If the current character is `'('`:
   - Increase `level`.
   - Add it to the result only if `level > 1`.
4. If the current character is `')'`:
   - Decrease `level`.
   - Add it to the result only if `level > 0`.
5. Convert the `StringBuilder` to a string and return it.

## Example

**Input**

```java
s = "(()())(())"
```

**Execution**

Primitive strings:

```text
(()())
(())
```

After removing the outermost parentheses:

```text
()()
()
```

Combined result:

```text
()()()
```

**Output**

```java
"()()()"
```

## Time Complexity

- **O(n)**

The string is traversed exactly once.

## Space Complexity

- **O(n)**

The `StringBuilder` stores the resulting string.
