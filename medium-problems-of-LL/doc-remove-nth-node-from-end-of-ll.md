# Remove Nth Node From End of List

## Approach

Instead of first finding the length of the linked list and then locating the node to remove, we can solve the problem in a **single traversal** using the **Two Pointer Technique**.

We maintain:

- `hare` → moves ahead by `n + 1` nodes.
- `turtle` → starts from the same position.

Once the gap is established:

- Move both pointers together.
- When `hare` reaches the end, `turtle` will be positioned just before the node that needs to be removed.

A **dummy node** is used to simplify edge cases, especially when the head itself needs to be deleted.

## Algorithm

1. Create a dummy node pointing to `head`.

   ```java
   dummy -> head
   ```

2. Initialize:

   ```java
   turtle = dummy
   hare = dummy
   ```

3. Move `hare` ahead by `n + 1` positions.

4. Move both pointers together until:

   ```java
   hare == null
   ```

5. At this point:

   ```java
   turtle.next
   ```

   is the node to be removed.

6. Skip that node:

   ```java
   turtle.next = turtle.next.next;
   ```

7. Return:

   ```java
   dummy.next
   ```

## Example

### Input

```text
1 -> 2 -> 3 -> 4 -> 5
n = 2
```

### After Creating Gap

```text
turtle
  |
dummy -> 1 -> 2 -> 3 -> 4 -> 5
                     ^
                    hare
```

The gap between the pointers is `n + 1`.

### Move Together

Eventually:

```text
dummy -> 1 -> 2 -> 3 -> 4 -> 5
                ^ 
             turtle

hare = null
```

`turtle.next` points to node `4`.

### Delete Node

```text
3 -> 4 -> 5
```

becomes

```text
3 ------> 5
```

### Output

```text
1 -> 2 -> 3 -> 5
```

## Why Use a Dummy Node?

Consider:

```text
1 -> 2 -> 3
n = 3
```

The node to remove is the head itself.

Without a dummy node:

```text
head changes
```

which requires special handling.

With:

```java
ListNode dummy = new ListNode(0, head);
```

the deletion logic remains exactly the same for every case.

## Time Complexity

```text
O(n)
```

Only one traversal of the linked list is performed.

## Space Complexity

```text
O(1)
```

Only a few pointers are used.

## Small Observation

The reason the loop runs:

```java
for(int i = 0; i <= n; i++)
```

instead of:

```java
for(int i = 0; i < n; i++)
```

is that we want a gap of **n + 1 nodes** between `hare` and `turtle`.

This ensures that when `hare` reaches `null`, `turtle` is positioned **exactly one node before** the node that must be removed.
