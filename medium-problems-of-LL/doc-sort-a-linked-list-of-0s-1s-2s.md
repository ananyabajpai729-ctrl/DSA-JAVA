# Sort a Linked List of 0s, 1s and 2s

## Approach

Since the linked list contains only three distinct values:

```text
0, 1, 2
```

we can avoid using a general sorting algorithm.

The idea is to create three separate linked lists:

- One for nodes containing `0`
- One for nodes containing `1`
- One for nodes containing `2`

As we traverse the original list, each node is appended to its corresponding list.

Finally, we connect the three lists together in the order:

```text
0-list -> 1-list -> 2-list
```

which produces the sorted linked list.

## Algorithm

1. Create three dummy nodes:
   
   ```java
   zeroListHead
   oneListHead
   twoListHead
   ```

2. Maintain tail pointers for each list:
   
   ```java
   temp0
   temp1
   temp2
   ```

3. Traverse the original linked list:
   
   - If the node value is `0`, append it to the 0-list.
   - If the node value is `1`, append it to the 1-list.
   - If the node value is `2`, append it to the 2-list.

4. Connect the lists:
   
   ```java
   temp0.next = (oneListHead.next != null)
                ? oneListHead.next
                : twoListHead.next;

   temp1.next = twoListHead.next;
   temp2.next = null;
   ```

5. Return the head of the sorted list.

## Example

### Input

```text
1 -> 0 -> 2 -> 1 -> 0 -> 2
```

### After Distribution

```text
0-list:
0 -> 0

1-list:
1 -> 1

2-list:
2 -> 2
```

### After Connecting

```text
0 -> 0 -> 1 -> 1 -> 2 -> 2
```

### Output

```text
0 -> 0 -> 1 -> 1 -> 2 -> 2
```

## Edge Case

### Input

```text
0 -> 2 -> 2
```

### Distribution

```text
0-list:
0

1-list:
empty

2-list:
2 -> 2
```

Since the 1-list is empty, the 0-list is connected directly to the 2-list:

```text
0 -> 2 -> 2
```

which is the correct sorted order.

## Why Dummy Nodes?

Dummy nodes make insertion straightforward.

Instead of checking:

```java
if(head == null)
```

for every insertion, we can always append using the tail pointers.

This keeps the code clean and avoids special-case handling.

## Time Complexity

```text
O(n)
```

The linked list is traversed exactly once.

## Space Complexity

```text
O(1)
```

Only a few pointers and three dummy nodes are used.

## Small Observation

This solution **reuses the existing nodes** instead of creating new ones.

For example:

```text
Original:
1 -> 0 -> 2
```

The nodes themselves are moved between the three temporary lists, and only the `next` pointers are modified.

This makes the solution both space-efficient and faster than approaches that create new nodes.
