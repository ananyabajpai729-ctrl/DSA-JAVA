# Search in a Linked List

## Approach

To determine whether a given key exists in a linked list, we simply traverse the list from the head node to the end.

At each node:

- Compare the node's value with the target key.
- If a match is found, return `true` immediately.
- Otherwise, move to the next node.

If the traversal reaches the end of the list without finding the key, return `false`.

## Algorithm

1. Create a pointer `currNode` and initialize it to `head`.
2. Traverse the linked list while `currNode` is not `null`.
3. For each node:
   - If `currNode.val == key`, return `true`.
   - Otherwise, move to the next node.
4. If the end of the list is reached, return `false`.

## Example

**Input**

```text
Linked List: 1 -> 2 -> 3 -> 4 -> 5
Key: 3
```

**Execution**

```text
1 ≠ 3
2 ≠ 3
3 = 3
```

Key found.

**Output**

```java
true
```

### Another Example

**Input**

```text
Linked List: 1 -> 2 -> 3 -> 4 -> 5
Key: 7
```

**Execution**

```text
1 ≠ 7
2 ≠ 7
3 ≠ 7
4 ≠ 7
5 ≠ 7
```

Reached the end of the list without finding the key.

**Output**

```java
false
```

## Time Complexity

- **O(n)**

Where:

- `n` = number of nodes in the linked list.

In the worst case, we may need to traverse the entire list.

## Space Complexity

- **O(1)**

Only a single pointer is used for traversal.
