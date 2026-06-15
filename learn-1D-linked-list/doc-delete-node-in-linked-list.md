# Delete Node in a Linked List

## Approach

In this problem, we are **not given the head of the linked list**. Instead, we are given direct access to the node that needs to be deleted.

Because we cannot reach the previous node, the usual deletion technique cannot be used.

The trick is:

- Copy the value of the next node into the current node.
- Make the current node point to the node after the next node.
- Disconnect the original next node.

This effectively removes the target node from the list without needing access to the head.

## Algorithm

1. Store a reference to the next node.
2. Copy the next node's value into the current node.
3. Update the current node's `next` pointer to skip the next node.
4. Disconnect the skipped node.

## Example

**Input**

```text
4 -> 5 -> 1 -> 9
     ^
   delete
```

The node containing `5` is given.

**Execution**

Copy value from the next node:

```text
4 -> 1 -> 1 -> 9
```

Skip the next node:

```text
4 -> 1 -> 9
```

**Output**

```text
4 -> 1 -> 9
```

## Why Does This Work?

Suppose the given node is:

```text
5 -> 1 -> 9
^
node
```

After copying:

```text
1 -> 1 -> 9
^
node
```

After updating the pointer:

```text
1 -> 9
^
node
```

The original node with value `1` becomes unreachable and is effectively deleted.

From the list's perspective, the node containing `5` has disappeared.

## Time Complexity

- **O(1)**

Only a few pointer updates are performed.

## Space Complexity

- **O(1)**

No extra data structures are used.
