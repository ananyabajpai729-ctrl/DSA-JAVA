# Reverse a Stack Using Recursion

## Problem Statement

Given a stack, reverse its elements using recursion without using any additional data structure.

---

## Approach

The idea is to use recursion to remove all elements from the stack and then rebuild it in reverse order.

The process consists of two steps:

1. Pop all elements recursively until the stack becomes empty.
2. While returning from recursion, insert each removed element at the bottom of the stack.

Since the first element removed from the top is inserted last, the order of the stack gets reversed.

---

## Intuition

Suppose the stack is:

```text
Top
↓
4
3
2
1
```

First, recursively remove all elements:

```text
4 → 3 → 2 → 1
```

The stack becomes empty.

Now, while backtracking:

- Insert `1` at the bottom.
- Insert `2` at the bottom.
- Insert `3` at the bottom.
- Insert `4` at the bottom.

The final stack becomes:

```text
Top
↓
1
2
3
4
```

which is the reverse of the original stack.

---

## Algorithm

1. Recursively pop elements until the stack becomes empty.
2. Store each popped element temporarily.
3. Reverse the remaining stack recursively.
4. Insert the stored element at the bottom of the stack.
5. Repeat until all elements are reinserted.

---

## Dry Run

### Initial Stack

```text
Top
↓
4
3
2
1
```

### Recursive Removal

```text
Pop 4
Pop 3
Pop 2
Pop 1
```

Stack becomes:

```text
Empty
```

### Backtracking

```text
Insert 1 at bottom
→ [1]

Insert 2 at bottom
→ [2, 1]

Insert 3 at bottom
→ [3, 2, 1]

Insert 4 at bottom
→ [4, 3, 2, 1]
```

Result:

```text
Top
↓
1
2
3
4
```

---

## Time Complexity

Each element may require traversing the current stack while being inserted at the bottom.

```text
O(N²)
```

---

## Space Complexity

The recursive call stack stores at most `N` function calls.

```text
O(N)
```

---

## Key Learning

This problem demonstrates how recursion can be used as an implicit stack to perform operations that would normally require an auxiliary data structure.

The crucial idea is:

```text
Reverse Stack
=
Remove Everything Recursively
+
Insert Each Element At The Bottom During Backtracking
```

---

## Pattern

This belongs to the family of:

- Recursion on Stack
- Backtracking
- Insert at Bottom of Stack

Understanding this pattern helps in solving:

- Insert at Bottom of Stack
- Reverse Stack
- Sort Stack Using Recursion
- Delete Middle Element of Stack
