# Palindrome Linked List

## Approach

A linked list is a palindrome if it reads the same forward and backward.

Since linked lists do not support backward traversal, we use a three-step approach:

1. Find the middle of the linked list.
2. Reverse the second half.
3. Compare the first half with the reversed second half.

If all corresponding nodes match, the linked list is a palindrome.

## Algorithm

### Step 1: Find the Middle

Use the **Tortoise and Hare** technique:

- `turtle` moves one step.
- `hare` moves two steps.

When the loop ends, `turtle` points to the middle node.

### Step 2: Reverse the Second Half

Reverse the list starting from:

```java
mid.next
```

This allows us to traverse the second half in reverse order.

### Step 3: Compare Both Halves

Initialize:

```java
fst = head
sec = reversedSecondHalf
```

Traverse both halves simultaneously:

- If values differ, return `false`.
- Otherwise, continue moving forward.

If all nodes match, return `true`.

## Example

### Palindrome List

**Input**

```text
1 -> 2 -> 2 -> 1
```

### Find Middle

```text
1 -> 2 -> 2 -> 1
     ^
    mid
```

### Reverse Second Half

```text
2 -> 1
```

becomes

```text
1 -> 2
```

### Compare

```text
1 == 1
2 == 2
```

All nodes match.

**Output**

```java
true
```

---

### Non-Palindrome List

**Input**

```text
1 -> 2
```

Comparison:

```text
1 != 2
```

**Output**

```java
false
```

## Why Compare Only Until `sec == null`?

After reversing:

```text
First Half  : 1 -> 2 -> 3
Second Half : 3 -> 2 -> 1
```

(or one node shorter for odd-length lists)

The reversed second half contains all nodes that need verification.

Once:

```java
sec == null
```

every required comparison has been completed.

## Time Complexity

### Finding the Middle

```text
O(n)
```

### Reversing the Second Half

```text
O(n)
```

### Comparing Both Halves

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

The solution reverses the list in-place and uses only a few pointers.

## Pattern

This problem combines three classic linked list techniques:

1. **Fast & Slow Pointers** → Find the middle.
2. **Iterative Reversal** → Reverse the second half.
3. **Two-Pointer Comparison** → Check palindrome property.

These patterns frequently appear in advanced linked list problems such as:

- Reorder List
- Reverse Linked List II
- Twin Sum of Linked List
- Fold / Unfold Linked List
