# Reverse Linked List

## Approach

To reverse a linked list, we need to change the direction of every link.

For each node:

- Store the next node before breaking the link.
- Reverse the current node's pointer.
- Move both pointers forward.

We maintain two pointers:

- `prevNode` → points to the already reversed part of the list.
- `currNode` → points to the node currently being processed.

As we iterate through the list, the reversed portion keeps growing until all nodes have been processed.

## Algorithm

1. Handle edge cases:
   - If the list is empty or contains only one node, return `head`.
2. Initialize:
   
   ```java
   prevNode = null
   currNode = head
   ```
   
3. While `currNode` is not `null`:
   - Store the next node.
   - Reverse the link.
   - Move `prevNode` forward.
   - Move `currNode` forward.
4. After the loop, `prevNode` points to the new head.
5. Return `prevNode`.

## Example

**Input**

```text
1 -> 2 -> 3 -> 4 -> 5 -> null
```

### Iteration 1

```text
Current = 1

null <- 1    2 -> 3 -> 4 -> 5
```

### Iteration 2

```text
null <- 1 <- 2    3 -> 4 -> 5
```

### Iteration 3

```text
null <- 1 <- 2 <- 3    4 -> 5
```

### Iteration 4

```text
null <- 1 <- 2 <- 3 <- 4    5
```

### Iteration 5

```text
null <- 1 <- 2 <- 3 <- 4 <- 5
```

**Output**

```text
5 -> 4 -> 3 -> 2 -> 1 -> null
```

## Why Does This Work?

Before changing a node's pointer, we save its next node:

```java
ListNode temp = currNode.next;
```

This ensures we don't lose access to the remaining list.

Then we reverse the link:

```java
currNode.next = prevNode;
```

and move both pointers forward.

Repeating this process for every node reverses the entire linked list.

## Time Complexity

- **O(n)**

Each node is visited exactly once.

## Space Complexity

- **O(1)**

Only a few pointers are used regardless of the list size.

## Pattern

This is the standard **Iterative Linked List Reversal** technique and serves as the foundation for many linked list problems such as:

- Reverse Linked List II
- Palindrome Linked List
- Reorder List
- Reverse Nodes in k-Group
- Add Two Numbers II
