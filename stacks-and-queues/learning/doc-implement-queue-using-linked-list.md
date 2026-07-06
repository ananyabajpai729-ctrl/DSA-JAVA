# Implement Queue Using Linked List

## Problem Statement

Implement a queue using a singly linked list supporting the following operations:

- `push(x)` – Insert an element at the rear of the queue.
- `pop()` – Remove and return the front element.
- `peek()` – Return the front element without removing it.
- `isEmpty()` – Check whether the queue is empty.

---

## Intuition

A queue follows the **FIFO (First In, First Out)** principle.

Using a singly linked list, maintain two pointers:

- **start** → Front of the queue.
- **end** → Rear of the queue.

This allows insertion at the rear and deletion from the front in constant time.

---

## Approach

1. Maintain pointers to the front (`start`) and rear (`end`) of the queue.
2. For `push`, create a new node and attach it to the rear.
3. For `pop`, remove the front node and move the front pointer ahead.
4. For `peek`, return the value at the front.
5. Maintain a `size` variable to support `isEmpty()` efficiently.

---

## Dry Run

**Operations:**

```text
push(10)
push(20)
push(30)
```

Queue:

```text
Front              Rear
  ↓                  ↓
10 → 20 → 30
```

`pop()`

```text
Returns: 10
```

Queue:

```text
Front         Rear
  ↓             ↓
20 → 30
```

`peek()`

```text
Returns: 20
```

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Push | `O(1)` |
| Pop | `O(1)` |
| Peek | `O(1)` |
| isEmpty | `O(1)` |

**Space:** `O(n)`

---

## Key Takeaway

Maintaining both **front** and **rear** pointers allows all queue operations to be performed in constant time. Elements are inserted at the rear and removed from the front, preserving the FIFO order.
