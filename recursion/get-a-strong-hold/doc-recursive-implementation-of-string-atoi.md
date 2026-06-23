# String to Integer (atoi) - Recursive Approach

## Approach

The goal is to convert a string into a 32-bit signed integer while following the rules of the `atoi` function:

1. Ignore leading whitespaces.
2. Determine the sign (`+` or `-`).
3. Read consecutive digits.
4. Stop when a non-digit character is encountered.
5. Handle integer overflow and underflow.

Instead of using an iterative loop to build the number, this solution uses **recursion** to process one digit at a time.

## Algorithm

### Step 1: Skip Leading Spaces

Move the index until a non-space character is found.

```java
while(i < s.length() && s.charAt(i) == ' ')
    i++;
```

---

### Step 2: Determine the Sign

If the current character is:

```text
'+'
```

the sign remains positive.

If the current character is:

```text
'-'
```

the sign becomes negative.

```java
sign = (s.charAt(i) == '-') ? -1 : 1;
```

---

### Step 3: Build the Number Recursively

The helper function processes one digit per recursive call.

Base case:

```java
if(i >= s.length() ||
   !Character.isDigit(s.charAt(i)))
```

At this point, no more valid digits remain.

Return:

```java
sign * num
```

---

### Step 4: Update the Number

For every digit:

```java
num = num * 10 + digit;
```

Example:

```text
"123"
```

Processing:

```text
1
12
123
```

---

### Step 5: Handle Overflow

Before continuing recursion:

```java
if(sign * num <= Integer.MIN_VALUE)
    return Integer.MIN_VALUE;

if(sign * num >= Integer.MAX_VALUE)
    return Integer.MAX_VALUE;
```

This ensures the result always remains within:

```text
[-2^31 , 2^31 - 1]
```

---

## Example 1

### Input

```text
"42"
```

### Recursive Calls

```text
num = 4
num = 42
```

End of string reached.

### Output

```text
42
```

---

## Example 2

### Input

```text
"   -42"
```

### After Trimming Spaces

```text
-42
```

Sign:

```text
-1
```

Processing:

```text
4
42
```

Apply sign:

```text
-42
```

### Output

```text
-42
```

---

## Example 3

### Input

```text
"4193 with words"
```

Processing stops at:

```text
' '
```

Number formed:

```text
4193
```

### Output

```text
4193
```

---

## Example 4

### Input

```text
"91283472332"
```

The value exceeds:

```text
Integer.MAX_VALUE
```

### Output

```text
2147483647
```

---

## Example 5

### Input

```text
"-91283472332"
```

The value is below:

```text
Integer.MIN_VALUE
```

### Output

```text
-2147483648
```

## Recursive Flow

For:

```text
"1234"
```

Calls occur as:

```text
helper(0,0)
    ↓
helper(1,1)
    ↓
helper(2,12)
    ↓
helper(3,123)
    ↓
helper(4,1234)
    ↓
return 1234
```

Each call extends the number by one digit.

## Time Complexity

```text
O(n)
```

Each character is processed once.

## Space Complexity

```text
O(n)
```

Due to the recursion stack.

## Small Observation

The reason `num` is declared as:

```java
long num
```

instead of:

```java
int num
```

is to safely detect overflow before it happens.

For example:

```text
2147483648
```

cannot be stored inside an `int`.

Using a `long` allows the program to build the number safely and clamp it to:

```java
Integer.MAX_VALUE
```

or

```java
Integer.MIN_VALUE
```

when required.

## Pattern

This problem demonstrates a classic:

```text
Recursion + Parsing + Overflow Handling
```

pattern where the recursive function gradually consumes the input while maintaining the current state (`index`, `number`, and `sign`).
