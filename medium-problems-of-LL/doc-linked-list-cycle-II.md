# Linked List Cycle II

## Approach

This problem extends the classic **Cycle Detection** problem.

Instead of simply determining whether a cycle exists, we must find the node where the cycle begins.

We use **Floyd's Tortoise and Hare Algorithm** in two phases:

### Phase 1: Detect the Cycle

- `turtle` moves one step at a time.
- `hare` moves two steps at a time.

If the two pointers meet, a cycle exists.

### Phase 2: Find the Starting Node

Once the pointers meet:

1. Move `turtle` back to the head.
2. Keep `hare` at the meeting point.
3. Move both pointers one step at a time.
4. The node where they meet again is the starting node of the cycle.

## Algorithm

1. Initialize:

   ```java
   turtle = head
   hare = head
   ```

2. Move:
   
   ```java
   turtle = turtle.next
   hare = hare.next.next
   ```

3. If the pointers meet:
   - Reset `turtle` to `head`.
4. Move both pointers one step at a time:

   ```java
   turtle = turtle.next
   hare = hare.next
   ```

5. The node where they meet is the cycle's starting node.
6. If no cycle is found, return `null`.

## Example

**Input**

```text
3 -> 2 -> 0 -> -4
     ^         |
     |_________|
```

Cycle starts at node `2`.

### Phase 1

| Step | Turtle | Hare |
|--------|--------|--------|
| Start | 3 | 3 |
| 1 | 2 | 0 |
| 2 | 0 | 2 |
| 3 | -4 | -4 |

Pointers meet.

### Phase 2

Reset turtle:

```text
Turtle = head (3)
Hare = meeting point (-4)
```

Move both one step at a time:

```text
3  -> 2
-4 -> 2
```

They meet at:

```text
2
```

**Output**

```java
Node with value 2
```

## Why Does This Work?

Let:

```text
L = distance from head to cycle start
C = length of cycle
x = distance from cycle start to meeting point
```

When the pointers meet:

```text
Distance travelled by hare
= 2 × (distance travelled by turtle)
```

After simplifying the equations:

```text
L = C - x
```

This means:

- The distance from the head to the cycle start
- Equals the distance from the meeting point to the cycle start (within the cycle)

Therefore, if:

- One pointer starts from the head
- One pointer starts from the meeting point

and both move one step at a time, they will meet exactly at the cycle's starting node.

## Time Complexity

- **O(n)**

The list is traversed at most a constant number of times.

## Space Complexity

- **O(1)**

Only two pointers are used.

## Pattern

This is one of the most famous applications of **Floyd's Cycle Detection Algorithm** and is a must-know linked list technique for interviews.

Related problems:

- Linked List Cycle
- Middle of the Linked List
- Happy Number
- Find Duplicate Number
- Circular Array Loop
