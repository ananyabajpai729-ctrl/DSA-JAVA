# Longest Common Prefix

## Approach

A clever observation is that after sorting the array of strings lexicographically:

- The strings that differ the most will become the first and the last strings in the sorted order.
- Any common prefix shared by all strings must also be shared by these two strings.

So instead of comparing every string with every other string, we:

1. Sort the array.
2. Compare only the first and last strings character by character.
3. The matching portion forms the longest common prefix.

## Algorithm

1. Sort the array of strings.
2. Store:
   - `first = strs[0]`
   - `last = strs[strs.length - 1]`
3. Compare both strings character by character.
4. If a mismatch is found:
   - Return the substring up to that index.
5. If all compared characters match:
   - Return the shorter string (or its entire length).

## Example

**Input**

```java
strs = ["flower", "flow", "flight"]
```

**After Sorting**

```java
["flight", "flow", "flower"]
```

**Comparison**

```text
flight
flow
^^
```

- Characters at index 0 and 1 match (`f`, `l`)
- Characters at index 2 differ (`i` vs `o`)

Longest common prefix:

```text
fl
```

**Output**

```java
"fl"
```

## Why Does This Work?

After sorting, the first and last strings are the most different strings in the array.

If these two strings share a prefix, every string lying between them in sorted order must also share that prefix. Therefore, finding the common prefix of just the first and last strings is enough.

## Time Complexity

- **O(n log n × m)**

Where:

- `n` = number of strings
- `m` = average length of a string

Sorting dominates the complexity.

## Space Complexity

- **O(1)**

Ignoring the space used internally by the sorting algorithm.
