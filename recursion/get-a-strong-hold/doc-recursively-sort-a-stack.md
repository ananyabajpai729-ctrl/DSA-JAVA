# Sort a Stack Using Recursion

## Approach

The goal is to sort a stack **without using any extra data structure**.

The idea is similar to insertion sort:

1. Remove all elements from the stack recursively.
2. While returning from recursion, insert each element back into its correct sorted position.

This is achieved using two recursive functions:

- `helper()` → removes elements one by one.
- `insert()` → inserts an element into an already sorted stack.

## Algorithm

### Step 1: Empty the Stack Recursively

The `helper()` function pops the top element and recursively sorts the remaining stack.

```java
int temp = st.pop();
helper(st);
insert(st, temp);
```

At the deepest recursive call, the stack becomes empty.

---

### Step 2: Insert Elements in Sorted Order

The `insert()` function assumes the stack is already sorted.

If:

```java
st.isEmpty() || st.peek() <= ele
```

the element belongs on top.

```java
st.push(ele);
```

Otherwise:

1. Pop the top element.
2. Recursively find the correct position.
3. Push the removed element back.

```java
int val = st.pop();
insert(st, ele);
st.push(val);
```

This preserves the sorted order.

## Example

### Input Stack

```text
Top
↓
3
1
4
2
```

---

### Recursive Removal

Elements are popped in order:

```text
3
1
4
2
```

until:

```text
Stack = Empty
```

---

### Reinsertion Phase

Insert:

```text
2
```

Stack:

```text
2
```

---

Insert:

```text
4
```

Stack:

```text
2
4
```

---

Insert:

```text
1
```

Pop:

```text
4
2
```

Insert:

```text
1
```

Push back:

```text
2
4
```

Stack:

```text
1
2
4
```

---

Insert:

```text
3
```

Pop:

```text
4
```

Insert:

```text
3
```

Push back:

```text
4
```

Final Stack:

```text
1
2
3
4
```

## Recursive Visualization

### helper()

```text
helper(3,1,4,2)
    ↓
helper(1,4,2)
    ↓
helper(4,2)
    ↓
helper(2)
    ↓
helper()
```

The stack is now empty.

---

### insert()

Elements are inserted back in sorted order:

```text
2
↓
2,4
↓
1,2,4
↓
1,2,3,4
```

## Why Does This Work?

When `helper()` returns from recursion:

```text
Remaining stack is already sorted.
```

Therefore, each removed element only needs to be inserted into the correct position, exactly like insertion sort.

The recursion stack itself acts as the temporary storage.

## Time Complexity

For each element, we may traverse almost the entire sorted stack during insertion.

```text
O(n²)
```

## Space Complexity

Recursive call stack:

```text
O(n)
```

## Small Observation

The condition:

```java
st.peek() <= ele
```

ensures that smaller elements stay below larger elements.

As a result, after sorting:

```text
Bottom → Smallest
Top → Largest
```

Example:

```text
1
2
3
4
↑ Top
```

So the largest element ends up at the top of the stack.

## Pattern

This problem is a classic example of:

```text
Recursion + Backtracking on a Stack
```

The same idea is used in:

- Reverse a Stack
- Delete Middle Element of Stack
- Insert at Bottom of Stack
- Sort Stack Using Recursion
