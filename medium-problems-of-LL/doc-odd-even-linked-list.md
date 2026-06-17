# Odd Even Linked List

## Approach

The goal is to group all nodes at **odd indices** together, followed by all nodes at **even indices**, while preserving their original relative order.

Instead of creating new lists, we can rearrange the existing links using two pointers:

- `fst` → traverses the odd-positioned nodes.
- `sec` → traverses the even-positioned nodes.

We also store:

- `head1` → head of the odd list.
- `head2` → head of the even list.

As we traverse the linked list:

- Connect odd nodes to the next odd node.
- Connect even nodes to the next even node.

Finally, attach the even list after the odd list.

## Algorithm

1. Handle edge cases:
   
   ```java
   head == null || head.next == null
   ```

2. Initialize:

   ```java
   fst = head
   sec = head.next
   head1 = head
   head2 = head.next
   ```

3. Traverse while an even node and its next node exist:
   
   - Link odd nodes together.
   - Link even nodes together.
   - Move both pointers forward.

4. Connect the last odd node to the head of the even list.

5. Return the head of the odd list.

## Example

### Input

```text
1 -> 2 -> 3 -> 4 -> 5
```

### Initial Lists

```text
Odd  : 1
Even : 2
```

### After Rearrangement

```text
Odd  : 1 -> 3 -> 5
Even : 2 -> 4
```

### Final Connection

```text
1 -> 3 -> 5 -> 2 -> 4
```

**Output**

```text
1 -> 3 -> 5 -> 2 -> 4
```

---

### Another Example

**Input**

```text
2 -> 1 -> 3 -> 5 -> 6 -> 4 -> 7
```

**Output**

```text
2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4
```

## Why Does This Work?

At each iteration:

```java
fst.next = fst.next.next;
```

connects the current odd node to the next odd node.

Similarly:

```java
sec.next = sec.next.next;
```

connects the current even node to the next even node.

This gradually splits the original list into:

```text
Odd-index list
Even-index list
```

without creating any extra nodes.

At the end:

```java
fst.next = head2;
```

joins both lists together.

## Time Complexity

- **O(n)**

Each node is visited at most once.

## Space Complexity

- **O(1)**

The rearrangement is performed in-place using only a few pointers.

## Small Observation

This problem is based on **node positions**, not node values.

For example:

```text
1 -> 8 -> 3 -> 6 -> 5
```

Odd-index nodes:

```text
1, 3, 5
```

Even-index nodes:

```text
8, 6
```

The values themselves being odd or even have no relevance to the solution.
