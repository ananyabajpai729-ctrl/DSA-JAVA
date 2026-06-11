# Isomorphic Strings

## Approach

Two strings are said to be **isomorphic** if the characters in one string can be replaced to get the other string while maintaining a one-to-one mapping.

Instead of using HashMaps, this solution uses two arrays to track the last seen position of each character.

For every pair of characters:

- If their previously recorded positions are different, the mapping is inconsistent, so the strings are not isomorphic.
- Otherwise, update both positions with the current index.

Using `i + 1` instead of `i` helps distinguish between characters that have never been seen before (default value `0`) and characters seen at index `0`.

## Algorithm

1. Create two arrays of size `256` to store the last seen positions of characters.
2. Traverse both strings simultaneously.
3. For each character pair:
   - Compare their stored positions.
   - If the positions differ, return `false`.
4. Update both arrays with the current index + 1.
5. If the traversal completes without conflicts, return `true`.

## Example

**Input**

```java
s = "egg"
t = "add"
```

**Execution**

| Index | s[i] | t[i] | map1 Value | map2 Value |
|---------|---------|---------|---------|---------|
| 0 | e | a | 0 | 0 |
| 1 | g | d | 0 | 0 |
| 2 | g | d | 2 | 2 |

All corresponding positions match throughout the traversal.

**Output**

```java
true
```

### Another Example

**Input**

```java
s = "foo"
t = "bar"
```

**Execution**

At index `2`:

```text
o → previously mapped
r → not previously mapped
```

The stored positions differ, indicating an inconsistent mapping.

**Output**

```java
false
```

## Time Complexity

- **O(n)**

We traverse both strings exactly once.

## Space Complexity

- **O(1)**

The two arrays have a fixed size of `256`, independent of the input length.
