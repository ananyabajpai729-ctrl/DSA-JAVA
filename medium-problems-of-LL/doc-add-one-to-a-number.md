# Add One to a Number Represented by a Linked List

## Approach

The digits of the number are stored in a linked list from **most significant digit to least significant digit**.

For example:

```text
1 -> 2 -> 9
```

represents:

```text
129
```

Since addition starts from the last digit, traversing the list directly is inconvenient.

The idea is:

1. Reverse the linked list.
2. Add `1` to the first node.
3. Propagate the carry if required.
4. Reverse the list again.
5. If a carry remains after processing all digits, create a new leading node.

## Algorithm

### Step 1: Reverse the List

```text
1 -> 2 -> 9
```

becomes:

```text
9 -> 2 -> 1
```

Now the least significant digit is at the front.

---

### Step 2: Add One

Traverse the reversed list:

```java
sum = track.val + 1;
```

Two cases arise:

#### Case 1: No Carry

```text
2 + 1 = 3
```

Update the node and stop.

#### Case 2: Carry Generated

```text
9 + 1 = 10
```

Store:

```text
0
```

and continue to the next node.

---

### Step 3: Reverse Again

Restore the original order after all updates.

---

### Step 4: Handle Remaining Carry

If every digit was `9`, a carry remains.

Example:

```text
9 -> 9 -> 9
```

After processing:

```text
0 -> 0 -> 0
```

A new node is inserted:

```text
1 -> 0 -> 0 -> 0
```

## Example 1

### Input

```text
1 -> 2 -> 3
```

### Reverse

```text
3 -> 2 -> 1
```

### Add One

```text
4 -> 2 -> 1
```

### Reverse Again

```text
1 -> 2 -> 4
```

### Output

```text
1 -> 2 -> 4
```

---

## Example 2

### Input

```text
1 -> 2 -> 9
```

### Reverse

```text
9 -> 2 -> 1
```

### Add One

```text
0 -> 3 -> 1
```

### Reverse Again

```text
1 -> 3 -> 0
```

### Output

```text
1 -> 3 -> 0
```

---

## Example 3

### Input

```text
9 -> 9 -> 9
```

### Reverse

```text
9 -> 9 -> 9
```

### Add One

```text
0 -> 0 -> 0
```

Carry still remains.

### Add New Head

```text
1 -> 0 -> 0 -> 0
```

### Output

```text
1 -> 0 -> 0 -> 0
```

## Time Complexity

### Reverse List

```text
O(n)
```

### Add One

```text
O(n)
```

### Reverse Again

```text
O(n)
```

Overall:

```text
O(n)
```

## Space Complexity

```text
O(1)
```

The operations are performed in-place using a few pointers.

## Small Observation

The variable:

```java
flag
```

is used to track whether a carry remains after processing all digits.

If the traversal finishes with:

```java
flag == 1
```

it means every digit was converted to `0` during carry propagation:

```text
9 -> 9 -> 9
```

becomes:

```text
0 -> 0 -> 0
```

and an extra leading `1` must be inserted.

This is what correctly handles cases where the number grows in length after adding one.
