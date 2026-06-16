# Linked List Cycle

## Approach

This problem is solved using the **Floyd's Cycle Detection Algorithm**, also known as the **Tortoise and Hare Algorithm**.

We use two pointers:

- **Turtle (Slow Pointer)** → moves one step at a time.
- **Hare (Fast Pointer)** → moves two steps at a time.

### Key Observation

- If there is **no cycle**, the hare will eventually reach the end of the linked list (`null`).
- If there **is a cycle**, the hare will eventually catch up to the turtle inside the cycle.

This happens because the hare moves faster and continuously gains one node on the turtle during each iteration.

## Algorithm

1. Initialize:
   
   ```java
   turtle = head
   hare = head
   ```

2. Traverse the list while:

   ```java
   hare != null && hare.next != null
   ```

3. Move the pointers:

   ```java
   turtle = turtle.next;
   hare = hare.next.next;
   ```

4. If both pointers meet:

   ```java
   turtle == hare
   ```

   return `true`.

5. If the loop ends, return `false`.

## Example

### Cycle Exists

**Input**

```text
3 -> 2 -> 0 -> -4
     ^         |
     |_________|
```

**Execution**

| Step | Turtle | Hare |
|--------|--------|--------|
| Start | 3 | 3 |
| 1 | 2 | 0 |
| 2 | 0 | 2 |
| 3 | -4 | -4 |

Pointers meet.

**Output**

```java
true
```

---

### No Cycle

**Input**

```text
1 -> 2 -> 3 -> 4 -> null
```

**Execution**

The hare eventually reaches `null`.

**Output**

```java
false
```

## Why Does This Work?

Imagine the cycle as a circular race track.

```text
Turtle → 1 step
Hare   → 2 steps
```

Every iteration, the hare gains:

```text
2 - 1 = 1 step
```

on the turtle.

Since they are moving inside a finite cycle, the hare must eventually catch up and land on the same node as the turtle.

Therefore:

```text
Cycle exists  ⇒  Pointers meet
No cycle      ⇒  Hare reaches null
```

## Time Complexity

- **O(n)**

In the worst case, each pointer traverses at most a linear number of nodes.

## Space Complexity

- **O(1)**

Only two pointers are used.

## Pattern

The **Tortoise and Hare Algorithm** is one of the most important linked list techniques and is commonly used for:

- Detecting a cycle
- Finding the starting node of a cycle
- Finding the middle of a linked list
- Checking whether a linked list is a palindrome
- Happy Number problems
