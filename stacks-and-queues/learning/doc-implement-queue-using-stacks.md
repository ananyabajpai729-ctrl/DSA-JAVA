# Implement Queue Using Two Stacks

## Problem Statement

Implement a queue using two stacks. Support the following operations:

- `push(x)` – Insert an element at the rear of the queue.
- `pop()` – Remove and return the front element.
- `peek()` – Return the front element without removing it.
- `empty()` – Check whether the queue is empty.

---

## Intuition

A queue follows **FIFO**, while a stack follows **LIFO**.

To preserve the queue order, move all elements from the first stack to the second stack, insert the new element, and then move everything back. This ensures that the front of the queue is always at the top of the first stack.

---

## Approach

1. Transfer all elements from `s1` to `s2`.
2. Push the new element into `s1`.
3. Move all elements back from `s2` to `s1`.
4. The top of `s1` always represents the front of the queue, making `pop()` and `peek()` straightforward.

---

## Dry Run

Operations:

```text
push(1)
s1 = [1]

push(2)
Move 1 → s2
Push 2 → s1
Move 1 back

s1 (top → bottom):
1
2

push(3)

s1 (top → bottom):
1
2
3
```

Queue representation:

```text
Front → 1 2 3 ← Rear
```

- `pop()` → `1`
- `peek()` → `2`

This matches the FIFO behavior of a queue.

---

## Time Complexity

| Operation | Time |
|-----------|------|
| Push | `O(n)` |
| Pop | `O(1)` |
| Peek | `O(1)` |
| Empty | `O(1)` |

**Space:** `O(n)`

---

## Key Takeaway

By rearranging the elements during every `push()`, the oldest element always stays on the top of the primary stack. This makes `pop()` and `peek()` constant-time operations while trading off a linear-time insertion.
