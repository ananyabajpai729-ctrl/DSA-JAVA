# Add Two Numbers

## Approach

The digits of the numbers are stored in reverse order in two linked lists.

For example:

```text
2 -> 4 -> 3
```

represents:

```text
342
```

Similarly:

```text
5 -> 6 -> 4
```

represents:

```text
465
```

Since the least significant digit appears first, we can simulate the same process used in elementary addition:

- Add corresponding digits.
- Include any carry from the previous step.
- Store the resulting digit.
- Carry the overflow to the next position.

A dummy node is used to simplify construction of the result list.

## Algorithm

1. Create a dummy node.

   ```java
   ListNode dummy = new ListNode(0);
   ```

2. Maintain:
   
   ```java
   current
   ```
   
   to build the answer list.

3. Keep a variable:
   
   ```java
   carry
   ```

4. Traverse while:
   
   ```java
   l1 != null ||
   l2 != null ||
   carry != 0
   ```

5. Extract current digits:
   
   ```java
   v1 = l1 != null ? l1.val : 0;
   v2 = l2 != null ? l2.val : 0;
   ```

6. Compute:
   
   ```java
   sum = v1 + v2 + carry;
   ```

7. Update carry:
   
   ```java
   carry = sum / 10;
   ```

8. Store the current digit:
   
   ```java
   sum % 10
   ```

9. Move pointers forward.

10. Return:
    
    ```java
    dummy.next
    ```

## Example

### Input

```text
l1 = 2 -> 4 -> 3
l2 = 5 -> 6 -> 4
```

Represented numbers:

```text
342 + 465
```

### Iteration 1

```text
2 + 5 + 0 = 7
```

Result:

```text
7
```

Carry:

```text
0
```

---

### Iteration 2

```text
4 + 6 + 0 = 10
```

Digit:

```text
0
```

Carry:

```text
1
```

Result:

```text
7 -> 0
```

---

### Iteration 3

```text
3 + 4 + 1 = 8
```

Result:

```text
7 -> 0 -> 8
```

### Output

```text
7 -> 0 -> 8
```

which represents:

```text
807
```

---

## Example 2

### Input

```text
l1 = 9 -> 9 -> 9
l2 = 1
```

### Processing

```text
9 + 1 = 10
```

```text
9 + 0 + 1 = 10
```

```text
9 + 0 + 1 = 10
```

Remaining carry:

```text
1
```

### Output

```text
0 -> 0 -> 0 -> 1
```

which represents:

```text
1000
```

## Why the Loop Uses `carry != 0`

The condition:

```java
while (l1 != null || l2 != null || carry != 0)
```

ensures that any leftover carry is processed.

Without:

```java
carry != 0
```

a case like:

```text
9 + 1
```

would incorrectly produce:

```text
0
```

instead of:

```text
0 -> 1
```

## Time Complexity

```text
O(max(n, m))
```

Where:

- `n` = length of `l1`
- `m` = length of `l2`

Each node is processed exactly once.

## Space Complexity

```text
O(max(n, m))
```

The result linked list stores the sum and may contain up to:

```text
max(n, m) + 1
```

nodes.

## Pattern

This is a classic example of:

```text
Linked List Simulation + Carry Propagation
```

The same carry-handling idea is commonly used in:

- Add Binary
- Add Strings
- Multiply Strings
- Add One to Number Represented by Linked List
