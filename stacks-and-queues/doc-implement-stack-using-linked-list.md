# Implement Stack Using Linked List

## Problem Statement

Implement a stack using a singly linked list supporting the following operations:

- `push(x)` – Insert an element onto the stack.
- `pop()` – Remove and return the top element.
- `top()` – Return the top element without removing it.
- `isEmpty()` – Check whether the stack is empty.

---

## Intuition

A stack follows the **LIFO (Last In, First Out)** principle.

Using a singly linked list, the **head** node naturally represents the top of the stack.

- **Push:** Insert the new node at the head.
- **Pop:** Remove the head node.
- **Top:** Return the value of the head node.

Since all operations are performed at the head, each takes constant time.

---

## Approach

1. Maintain a pointer to the head of the linked list.
2. For `push`, create a new node and insert it before the current head.
3. For `pop`, remove the head node and update the head pointer.
4. For `top`, return the value stored at the head.
5. Maintain a `size` variable to support `isEmpty()` efficiently.

---

## Dry Run

**Operations:**

```text
push(10)
push(20)
push(30)
```

Stack:

```text
Top
 ↓
30 → 20 → 10
```

`pop()`

```text
Returns: 30
```

Stack:

```text
Top
 ↓
20 → 10
```

`top()`

```text
Returns: 20
```

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Push | `O(1)` |
| Pop | `O(1)` |
| Top | `O(1)` |
| isEmpty | `O(1)` |

**Space:** `O(n)`

---

## Key Takeaway

Using the head of a singly linked list as the top of the stack allows all stack operations to be performed in constant time without requiring element shifting or traversal.
