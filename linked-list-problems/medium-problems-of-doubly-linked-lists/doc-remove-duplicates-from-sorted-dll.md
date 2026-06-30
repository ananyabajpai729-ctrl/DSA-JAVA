# Remove Duplicates from a Sorted Doubly Linked List

## Approach

Since the doubly linked list is already **sorted**, all duplicate values appear consecutively.

This allows us to remove duplicates efficiently by:

- Keeping one occurrence of each value.
- Skipping all subsequent nodes with the same value.
- Reconnecting the remaining nodes properly.

The key idea is to use two pointers:

- `currNode` → points to the current unique value.
- `nextNode` → moves ahead to find the next distinct value.

## Algorithm

1. Handle edge cases:

   ```java
   if(head == null || head.next == null)
   ```

2. Start from the head:

   ```java
   currNode = head;
   ```

3. For each node:

   - Move `nextNode` forward while duplicates exist.

   ```java
   while(nextNode != null &&
         currNode.val == nextNode.val)
   ```

4. Once a different value is found:

   ```java
   currNode.next = nextNode;
   ```

5. Fix the backward link:

   ```java
   nextNode.prev = currNode;
   ```

   (if `nextNode` exists)

6. Move to the next unique node.

7. Continue until the end of the list.

## Example

### Input

```text
1 <-> 1 <-> 2 <-> 3 <-> 3 <-> 4 <-> 4 <-> 4
```

### Processing

#### First Group

```text
1 <-> 1
```

Skip duplicates and keep one:

```text
1
```

---

#### Second Group

```text
2
```

Already unique.

---

#### Third Group

```text
3 <-> 3
```

Keep one occurrence.

---

#### Fourth Group

```text
4 <-> 4 <-> 4
```

Keep one occurrence.

### Output

```text
1 <-> 2 <-> 3 <-> 4
```

## Pointer Visualization

### Before

```text
curr
 |
1 <-> 1 <-> 1 <-> 2
       ^
     next
```

### Skip Duplicates

```text
curr
 |
1 <-> 1 <-> 1 <-> 2
                 ^
              next
```

### Reconnect

```text
1 <-------------> 2
```

Duplicate nodes are bypassed.

## Why Does This Work?

Because the list is sorted:

```text
1 1 1 2 2 3 3 4
```

all duplicates are adjacent.

Therefore, once a different value is encountered:

```java
currNode.val != nextNode.val
```

we know it is the next unique node.

No extra data structure is required.

## Time Complexity

```text
O(n)
```

Each node is visited at most once.

## Space Complexity

```text
O(1)
```

Only a few pointers are used.

## Small Observation

The statement:

```java
currNode.next = nextNode;
```

removes all duplicate nodes in one shot.

For example:

```text
1 <-> 1 <-> 1 <-> 1 <-> 2
```

after the inner loop:

```text
nextNode -> 2
```

and a single assignment:

```java
currNode.next = nextNode;
```

skips all four duplicate nodes at once.

Similarly:

```java
nextNode.prev = currNode;
```

restores the backward link, ensuring the doubly linked list remains valid after deletion.
