# Implement Stack Using a Single Queue

## Problem Statement

Implement a stack using only a single queue. Support the following operations:

- `push(x)` – Push an element onto the stack.
- `pop()` – Remove and return the top element.
- `top()` – Return the top element without removing it.
- `empty()` – Check whether the stack is empty.

---

## Intuition

A queue follows **FIFO**, whereas a stack follows **LIFO**.

To simulate a stack, after inserting a new element into the queue, rotate all previous elements to the back. This moves the newly inserted element to the front, allowing it to be removed first.

---

## Approach

1. Insert the new element into the queue.
2. Rotate the existing elements by repeatedly removing the front element and adding it to the back.
3. The newly inserted element becomes the front of the queue.
4. `pop()` and `top()` simply operate on the front of the queue.

---

## Dry Run

Operations:

```text
push(1)
Queue: [1]

push(2)
Add 2 → [1, 2]
Rotate once → [2, 1]

push(3)
Add 3 → [2, 1, 3]
Rotate twice → [3, 2, 1]
```

Now:

```text
Front → [3, 2, 1]
```

- `pop()` → `3`
- `top()` → `2`

This matches the LIFO behavior of a stack.

---

## Time Complexity

| Operation | Time |
|-----------|------|
| Push | `O(n)` |
| Pop | `O(1)` |
| Top | `O(1)` |
| Empty | `O(1)` |

**Space:** `O(n)`

---

## Key Takeaway

A stack can be implemented using a single queue by rotating the queue after every insertion. This ensures that the most recently added element always remains at the front, making `pop()` and `top()` constant-time operations.
