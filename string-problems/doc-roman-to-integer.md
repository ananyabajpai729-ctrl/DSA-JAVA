# Roman to Integer

## Approach

Roman numerals are usually written from largest value to smallest value and can be added directly.

However, there are special cases where a smaller numeral appears before a larger one:

```text
IV = 4
IX = 9
XL = 40
XC = 90
CD = 400
CM = 900
```

In such cases, the smaller value is subtracted from the larger value.

The idea is:

- Traverse the string from left to right.
- If the current numeral has a smaller value than the next numeral, treat them as a subtractive pair.
- Otherwise, simply add the current numeral's value.

## Algorithm

1. Initialize `ans = 0`.
2. Traverse the string using an index `i`.
3. If:
   
   ```text
   value(current) < value(next)
   ```
   
   then:
   
   - Add:
   
     ```text
     value(next) - value(current)
     ```
   
   - Move forward by 2 positions.
4. Otherwise:
   - Add the value of the current numeral.
   - Move forward by 1 position.
5. Return the final answer.

## Example

**Input**

```java
s = "MCMIV"
```

**Execution**

```text
M  = 1000
CM = 900
IV = 4
```

Total:

```text
1000 + 900 + 4 = 1904
```

**Output**

```java
1904
```

### Another Example

**Input**

```java
s = "LVIII"
```

**Execution**

```text
L = 50
V = 5
I = 1
I = 1
I = 1
```

Total:

```text
50 + 5 + 1 + 1 + 1 = 58
```

**Output**

```java
58
```

## Time Complexity

- **O(n)**

Each character is processed at most once.

## Space Complexity

- **O(1)**

Only a few variables are used.

## Why the Subtractive Check Works

For a valid Roman numeral, a smaller value appearing before a larger value always represents subtraction.

For example:

```text
I before V  → 4
I before X  → 9
X before L  → 40
C before M  → 900
```

So whenever:

```java
getValue(s.charAt(i)) < getValue(s.charAt(i + 1))
```

we can safely evaluate the pair together and skip both characters.
