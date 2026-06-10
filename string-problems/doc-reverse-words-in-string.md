# Reverse Words in a String

## Approach

The goal is to reverse the order of words while removing any extra spaces.

Instead of splitting the string into an array of words, we traverse the string from right to left.

- Skip any trailing or extra spaces.
- Identify a complete word.
- Append the word to the result.
- Add a single space between consecutive words.

Using a `StringBuilder` helps build the final string efficiently.

## Algorithm

1. Remove leading and trailing spaces using `trim()`.
2. Initialize a pointer at the end of the string.
3. While the pointer is within the string:
   - Skip any spaces.
   - Mark the end of the current word.
   - Move left until the beginning of the word is reached.
   - Extract the word and append it to the result.
   - Add a space before the word if the result already contains words.
4. Return the final string.

## Example

**Input**

```java
s = "  the sky   is blue  "
```

**Execution**

- Start from the end.
- Extract `"blue"` → Result: `"blue"`
- Extract `"is"` → Result: `"blue is"`
- Extract `"sky"` → Result: `"blue is sky"`
- Extract `"the"` → Result: `"blue is sky the"`

**Output**

```java
"blue is sky the"
```

## Time Complexity

- **O(n)**

Each character is visited at most once while traversing the string.

## Space Complexity

- **O(n)**

The `StringBuilder` stores the reversed sentence.
