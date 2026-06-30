# Middle of the Linked List

## Approach

This problem can be solved efficiently using the **Tortoise and Hare** technique.

We use two pointers:

- **Turtle (Slow Pointer)** → moves one step at a time.
- **Hare (Fast Pointer)** → moves two steps at a time.

Since the hare moves twice as fast as the turtle:

- By the time the hare reaches the end of the list,
- The turtle will be standing at the middle node.

This allows us to find the middle in a single traversal.

## Algorithm

1. Initialize two pointers:
   - `turtle = head`
   - `hare = head`
2. Traverse the list while:
   
   ```java
   hare != null && hare.next != null
   ```
   
3. Move:
   
   ```java
   turtle = turtle.next;
   hare = hare.next.next;
   ```
   
4. When the loop ends:
   - `turtle` points to the middle node.
5. Return `turtle`.

## Example

**Input**

```text
1 -> 2 -> 3 -> 4 -> 5
```

**Execution**

| Step | Turtle | Hare |
|--------|--------|--------|
| Start | 1 | 1 |
| 1 | 2 | 3 |
| 2 | 3 | 5 |

Hare reaches the end.

**Output**

```text
3
```

---

### Even Length Case

**Input**

```text
1 -> 2 -> 3 -> 4 -> 5 -> 6
```

**Execution**

| Step | Turtle | Hare |
|--------|--------|--------|
| Start | 1 | 1 |
| 1 | 2 | 3 |
| 2 | 3 | 5 |
| 3 | 4 | null |

**Output**

```text
4
```

The problem specifies that when there are two middle nodes, we should return the **second middle node**, which this approach naturally does.

## Why Does This Work?

The hare moves twice as fast as the turtle.

```text
Turtle: 1 step
Hare:   2 steps
```

So when the hare has covered the entire list, the turtle has covered exactly half of it.

```text
Distance covered by turtle = n / 2
```

which places it at the middle node.

## Time Complexity

- **O(n)**

The linked list is traversed only once.

## Space Complexity

- **O(1)**

Only two pointers are used.

## Pattern

This is one of the most important applications of the **Tortoise and Hare Algorithm**, which is also used in:

- Finding the middle of a linked list
- Detecting cycles in a linked list
- Finding the starting point of a cycle
- Checking if a linked list is a palindrome
- Happy Number problems
