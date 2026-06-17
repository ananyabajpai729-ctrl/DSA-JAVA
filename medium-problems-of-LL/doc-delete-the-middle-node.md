# Delete the Middle Node of a Linked List

## Approach

To delete the middle node efficiently, we use the **Tortoise and Hare** technique.

We maintain two pointers:

- **Turtle (Slow Pointer)** → moves one step at a time.
- **Hare (Fast Pointer)** → moves two steps at a time.

Additionally, we introduce a **dummy node** before the head.

The purpose of the dummy node is to position the turtle **one node before the middle node**, making deletion straightforward.

When the hare reaches the end of the list:

- The turtle will be just before the middle node.
- We can remove the middle node by updating a single pointer.

## Algorithm

1. Create a dummy node pointing to the head.

   ```java
   dummy -> head
   ```

2. Initialize:

   ```java
   turtle = dummy
   hare = dummy
   ```

3. Move:
   
   ```java
   turtle = turtle.next
   hare = hare.next.next
   ```

   while:

   ```java
   hare.next != null &&
   hare.next.next != null
   ```

4. After the loop:
   
   ```java
   turtle.next
   ```

   points to the middle node.

5. Delete the middle node:

   ```java
   turtle.next = turtle.next.next;
   ```

6. Return:

   ```java
   dummy.next
   ```

## Example

### Input

```text
1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6
```

### Pointer Movement

| Turtle | Hare |
|----------|----------|
| dummy | dummy |
| 1 | 3 |
| 3 | 7 |
| 4 | 2 |

The loop stops.

Current position:

```text
1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6
          ^
       turtle
```

`turtle.next` is the middle node (`7`).

### Delete

```text
4 -> 7 -> 1
```

becomes

```text
4 ------> 1
```

### Output

```text
1 -> 3 -> 4 -> 1 -> 2 -> 6
```

## Single Node Case

### Input

```text
1
```

After creating the dummy node:

```text
dummy -> 1
```

The loop does not execute.

Deletion:

```java
turtle.next = turtle.next.next;
```

becomes:

```text
dummy -> null
```

### Output

```text
[]
```

which is the expected result.

## Why Use a Dummy Node?

Without a dummy node, the turtle would stop **at the middle node**.

However, to delete a node in a singly linked list, we need access to the **previous node**.

Using:

```java
ListNode dummy = new ListNode(0, head);
```

ensures that the turtle naturally stops one node before the middle, allowing easy deletion.

## Time Complexity

```text
O(n)
```

The linked list is traversed only once.

## Space Complexity

```text
O(1)
```

Only a few pointers are used.
