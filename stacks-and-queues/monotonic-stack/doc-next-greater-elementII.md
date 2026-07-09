# Next Greater Element II

## Problem Statement

Given a **circular array**, find the Next Greater Element (NGE) for every element.

The Next Greater Element of an element is the first greater element encountered while traversing to its right in a circular manner. If no such element exists, return `-1` for that position.

---

## Intuition

Since the array is circular, elements at the end may find their Next Greater Element at the beginning.

To simulate this, traverse the array **twice** from right to left. A monotonic decreasing stack stores potential Next Greater Elements.

During the first pass (the extra traversal), the stack is prepared with elements from the circular extension. During the second pass, the actual answers are computed.

---

## Approach

1. Traverse from index `2n - 1` down to `0`.
2. Convert the current index into the original array index using `i % n`.
3. Remove all elements from the stack that are less than or equal to the current element.
4. During the second traversal (`i < n`):
   - If the stack is empty, the answer is `-1`.
   - Otherwise, the top of the stack is the Next Greater Element.
5. Push the current element onto the stack.

---

## Dry Run

**Input:**

```text
nums = [1, 2, 1]
```

Traversal:

```text
Pass 1:
Build stack considering the circular array.

Pass 2:

1 → Next Greater = 2

2 → No greater element
     Answer = -1

1 → Next Greater = 2
```

Output:

```text
[2, -1, 2]
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Key Takeaway

Traversing the array twice effectively simulates its circular nature. A **monotonic decreasing stack** ensures each element is pushed and popped at most once, allowing all Next Greater Elements to be found in linear time.
