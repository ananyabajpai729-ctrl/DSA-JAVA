# Stack Implementation Using Dynamic Array

## Problem Statement

Implement a stack using a dynamic array (`ArrayList`) supporting the following operations:

- `push(x)` – Insert an element onto the stack.
- `pop()` – Remove and return the top element.
- `top()` – Return the top element without removing it.
- `isEmpty()` – Check whether the stack is empty.

---

## Intuition

A stack follows the **Last In, First Out (LIFO)** principle.

Since an `ArrayList` allows efficient insertion and deletion at the end, its last element naturally represents the top of the stack.

---

## Approach

- **Push:** Add the element to the end of the list.
- **Pop:** Remove and return the last element.
- **Top:** Return the last element without removing it.
- **isEmpty:** Check whether the list contains any elements.

---

## Dry Run

Operations:

```text
push(10)
push(20)
push(30)
```

Stack:

```text
[10, 20, 30]
          ↑ Top
```

`pop()`

```text
Returns: 30

Stack:
[10, 20]
      ↑ Top
```

`top()`

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
| Pop | `O(1)` |
| Top | `O(1)` |
| isEmpty | `O(1)` |

**Space:** `O(n)`

---

## Key Takeaway

Using a dynamic array (`ArrayList`) is one of the simplest ways to implement a stack. By treating the end of the list as the top of the stack, all stack operations can be performed efficiently in constant time (amortized for `push`).
