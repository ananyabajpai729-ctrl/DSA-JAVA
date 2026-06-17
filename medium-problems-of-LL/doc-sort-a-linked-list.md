# Sort List

## Approach

This problem asks us to sort a linked list in **O(n log n)** time.

Unlike arrays, linked lists do not support random access, making algorithms like Quick Sort less suitable. The ideal choice is **Merge Sort**, which naturally works well with linked lists.

The algorithm consists of three steps:

1. Find the middle of the linked list.
2. Split the list into two halves.
3. Recursively sort both halves and merge them back together.

## Algorithm

### Step 1: Find the Middle

Use the **Tortoise and Hare** technique:

- `turtle` moves one step.
- `hare` moves two steps.

When the loop ends, `turtle` points to the middle node.

```text
1 -> 4 -> 2 -> 3

turtle stops at 4
```

---

### Step 2: Split the List

```java
ListNode left = head;
ListNode right = mid.next;
mid.next = null;
```

This breaks the list into two independent halves.

```text
1 -> 4 -> null

2 -> 3 -> null
```

---

### Step 3: Recursively Sort

Sort both halves:

```java
left = sortList(left);
right = sortList(right);
```

Eventually each recursive call reaches:

```java
head == null || head.next == null
```

which represents an already sorted list.

---

### Step 4: Merge the Sorted Lists

Merge the two sorted halves using the standard merge procedure.

```text
1 -> 4

2 -> 3
```

becomes:

```text
1 -> 2 -> 3 -> 4
```

## Example

### Input

```text
4 -> 2 -> 1 -> 3
```

### Split

```text
4 -> 2

1 -> 3
```

### Further Split

```text
4    2

1    3
```

### Merge

```text
4 + 2 -> 2 -> 4

1 + 3 -> 1 -> 3
```

### Final Merge

```text
2 -> 4
1 -> 3
```

becomes:

```text
1 -> 2 -> 3 -> 4
```

### Output

```text
1 -> 2 -> 3 -> 4
```

## Why Merge Sort?

For linked lists:

- Finding the middle → **O(n)**
- Splitting → **O(1)**
- Merging → **O(n)**

Merge Sort avoids the random-access requirement of arrays and achieves the optimal complexity.

## Time Complexity

At every level:

```text
O(n)
```

work is done during merging.

The recursion depth is:

```text
O(log n)
```

Therefore:

```text
O(n log n)
```

## Space Complexity

### Auxiliary Space

```text
O(log n)
```

due to recursive function calls.

### Extra Linked List Space

```text
O(1)
```

No new nodes are created apart from a temporary dummy node used during merging.

## Small Observation

Your `findMiddle()` method returns the **first middle node** for even-length lists:

```text
1 -> 2 -> 3 -> 4
     ^
```

This is important because:

```java
ListNode right = mid.next;
mid.next = null;
```

splits the list into:

```text
1 -> 2

3 -> 4
```

giving two balanced halves and ensuring Merge Sort maintains its **O(n log n)** performance.
