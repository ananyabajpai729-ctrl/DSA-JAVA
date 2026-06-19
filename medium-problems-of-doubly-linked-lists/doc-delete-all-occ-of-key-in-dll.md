# Delete All Occurrences of a Given Key in a Doubly Linked List

## Approach

Given a doubly linked list and a target value, we need to remove **all nodes whose value equals the target**.

A doubly linked list is particularly convenient for deletion because each node has access to both:

```text
prev
next
```

allowing us to reconnect neighboring nodes in constant time.

To simplify edge cases such as deleting the head node, we introduce a **dummy node** before the actual head.

## Algorithm

1. Create a dummy node pointing to the head.

   ```java
   dummy -> head
   ```

2. Update:

   ```java
   head.prev = dummy
   ```

   if the list is not empty.

3. Traverse the list using `currNode`.

4. Whenever a node contains the target value:

   - Store:
     
     ```java
     prevNode = currNode.prev
     temp = currNode.next
     ```

   - Remove the node:
     
     ```java
     prevNode.next = temp
     ```

   - Fix the backward link:
     
     ```java
     temp.prev = prevNode
     ```

     (only if `temp` exists)

   - Disconnect the deleted node.

5. Continue traversal.

6. Before returning:
   
   - Remove the dummy node's effect.
   - Make the new head's `prev` pointer `null`.

7. Return:

   ```java
   dummy.next
   ```

## Example

### Input

```text
1 <-> 2 <-> 3 <-> 2 <-> 4
target = 2
```

### Delete First 2

```text
1 <-> 3 <-> 2 <-> 4
```

### Delete Second 2

```text
1 <-> 3 <-> 4
```

### Output

```text
1 <-> 3 <-> 4
```

---

## Example 2

### Input

```text
2 <-> 2 <-> 2
target = 2
```

### After Deletions

```text
null
```

### Output

```text
[]
```

## Why Use a Dummy Node?

Consider:

```text
2 <-> 3 <-> 4
```

If the target is:

```text
2
```

the head itself must be deleted.

Without a dummy node, special handling would be required.

Using:

```java
dummy -> head
```

allows all deletions to follow the exact same logic.

## Time Complexity

```text
O(n)
```

Each node is visited once.

## Space Complexity

```text
O(1)
```

Only a few pointers are used.

## Small Observation

A subtle but important part of the solution is:

```java
if(dummy.next != null){
    dummy.next.prev = null;
}
```

During processing, the first valid node may still have:

```text
prev -> dummy
```

attached to it.

This final step restores the proper doubly linked list structure by ensuring the new head has:

```text
prev = null
```

which is required for a valid DLL.

## Pattern

This problem demonstrates a common linked list technique:

```text
Dummy Node + Pointer Rewiring
```

The same pattern is frequently used in:

- Remove Nth Node From End
- Delete Node in Linked List
- Remove Linked List Elements
- Partition List
- Merge Linked Lists
