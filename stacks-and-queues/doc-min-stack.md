# Min Stack

## Problem Statement

Design a stack that supports the following operations in constant time:

- `push(x)` – Push an element onto the stack.
- `pop()` – Remove the top element.
- `top()` – Return the top element.
- `getMin()` – Retrieve the minimum element currently in the stack.

All operations should run in **O(1)** time.

---

## Intuition

Instead of maintaining a separate stack for minimum values, store a **modified value** whenever a new minimum is pushed.

Maintain a variable `mini` that always stores the current minimum.

- If the new value is greater than the current minimum, push it normally.
- If the new value becomes the new minimum, push an encoded value:
  ```text
  encoded = 2 × value − mini
  ```
  and update `mini`.

During `pop()`, if the popped value is smaller than `mini`, it indicates an encoded value. The previous minimum can then be restored using:

```text
previousMin = 2 × mini − encoded
```

---

## Approach

1. Maintain:
   - A stack of `long` values.
   - A variable `mini` storing the current minimum.
2. During `push`:
   - If the stack is empty, initialize `mini`.
   - If the new value is smaller than or equal to `mini`, push the encoded value and update `mini`.
   - Otherwise, push the value normally.
3. During `pop`:
   - If the popped value is encoded, recover the previous minimum.
4. During `top`:
   - If the top value is encoded, the actual top is `mini`.
5. `getMin()` simply returns `mini`.

---

## Dry Run

**Operations:**

```text
push(5)
push(3)
push(7)
```

Stack contents:

```text
5
1   (encoded value for 3)
7
```

Current minimum:

```text
3
```

`top()`

```text
Returns 7
```

`pop()`

```text
Removes 7
Minimum remains 3
```

`pop()`

```text
Pops encoded value (1)

Restore previous minimum:
2 × 3 − 1 = 5
```

Current minimum:

```text
5
```

---

## Time Complexity

| Operation | Complexity |
|-----------|------------|
| Push | `O(1)` |
| Pop | `O(1)` |
| Top | `O(1)` |
| getMin | `O(1)` |

**Space:** `O(n)`

---

## Key Takeaway

By storing an encoded value whenever a new minimum is inserted, the stack can track and restore previous minimum values without requiring an additional stack, achieving **O(1)** time for all operations while using only a single stack.
