# Queue Implementation Using Dynamic Array

## Problem Statement

Implement a queue using a dynamic array (`ArrayList`) supporting the following operations:

- `push(x)` – Insert an element at the rear of the queue.
- `pop()` – Remove and return the front element.
- `peek()` – Return the front element without removing it.
- `isEmpty()` – Check whether the queue is empty.

---

## Intuition

A queue follows the **First In, First Out (FIFO)** principle.

Elements are inserted at the rear and removed from the front. An `ArrayList` can be used to simulate this behavior by adding elements at the end and removing the first element.

---

## Approach

- **Push:** Add the element to the end of the list.
- **Pop:** Remove and return the first element.
- **Peek:** Return the first element without removing it.
- **isEmpty:** Check whether the list is empty.

---

## Dry Run

Operations:

```text
push(10)
push(20)
push(30)
```

Queue:

```text
Front → [10, 20, 30] ← Rear
```

`pop()`

```text
Returns: 10

Queue:
Front → [20, 30] ← Rear
```

`peek()`

```text
Returns: 20
```

`isEmpty()`

```text
false
```

---

## Time Complexity

| Operation | Time |
|-----------|------|
| Push | `O(1)` (Amortized) |
| Pop | `O(n)` |
| Peek | `O(1)` |
| isEmpty | `O(1)` |

**Space:** `O(n)`

---

## Key Takeaway

Although an `ArrayList` can be used to implement a queue, removing the first element requires shifting all remaining elements one position to the left, making `pop()` an `O(n)` operation. For an efficient queue implementation, a circular array or linked list is preferred.
