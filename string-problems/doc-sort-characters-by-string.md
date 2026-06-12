# Sort Characters By Frequency

## Approach

The goal is to rearrange the characters of the string in decreasing order of their frequencies.

Since the input contains ASCII characters, we can use a fixed-size 2D array of size `128`:

- `freq[i][0]` stores the character's ASCII value.
- `freq[i][1]` stores its frequency.

After counting the occurrences of each character:

1. Sort the array in descending order based on frequency.
2. Append each character to the result as many times as it appears.

The characters with the highest frequencies will therefore appear first in the final string.

## Algorithm

1. Create a `128 × 2` array to store characters and their frequencies.
2. Traverse the string:
   - Store the character's ASCII value.
   - Increment its frequency.
3. Sort the frequency array in descending order of frequency.
4. Traverse the sorted array:
   - Stop when a frequency becomes `0`.
   - Append the character to the result according to its frequency.
5. Return the constructed string.

## Example

**Input**

```java
s = "tree"
```

**Frequency Count**

```text
t → 1
r → 1
e → 2
```

**After Sorting**

```text
e → 2
t → 1
r → 1
```

**Result**

```text
eetr
```

(`eert` is also a valid answer.)

**Output**

```java
"eetr"
```

## Time Complexity

- **O(n + k log k)**

Where:

- `n` = length of the string
- `k` = size of the character set (`128`)

Since `k` is fixed, this effectively behaves like **O(n)**.

## Space Complexity

- **O(k)**

The frequency array stores information for all ASCII characters. Since `k = 128` is constant, the space complexity is effectively **O(1)**.
