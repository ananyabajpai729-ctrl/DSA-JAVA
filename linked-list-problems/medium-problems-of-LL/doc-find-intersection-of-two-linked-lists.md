# Intersection of Two Linked Lists

## Approach

To find the intersection node of two linked lists, we use a clever **two-pointer technique**.

The main challenge is that the two lists may have different lengths.

Instead of calculating lengths separately, we let both pointers traverse both lists:

- `fst` starts from `headA`
- `sec` starts from `headB`

When a pointer reaches the end of its list, it jumps to the head of the other list.

This ensures that both pointers travel the same total distance:

```text
Length(A) + Length(B)
```

As a result:

- If an intersection exists, the pointers will meet at the intersection node.
- If no intersection exists, both pointers will eventually become `null`.

## Algorithm

1. Handle the edge case where either list is empty.
2. Initialize:

   ```java
   fst = headA;
   sec = headB;
   ```

3. Traverse until both pointers become equal:

   ```java
   while(fst != sec)
   ```

4. Move the pointers:

   ```java
   fst = (fst == null) ? headB : fst.next;
   sec = (sec == null) ? headA : sec.next;
   ```

5. Return the meeting node.

## Example

### Input

```text
List A:
4 -> 1
      \
       8 -> 4 -> 5

List B:
5 -> 6 -> 1
          \
           8 -> 4 -> 5
```

### First Pass

```text
fst travels:
4 -> 1 -> 8 -> 4 -> 5 -> null

sec travels:
5 -> 6 -> 1 -> 8 -> 4 -> 5 -> null
```

Since the lists have different lengths, they do not meet yet.

### After Switching Heads

```text
fst starts from headB
sec starts from headA
```

Now both have travelled the same total distance.

They eventually meet at:

```text
8
```

### Output

```text
Node with value 8
```

## Why Does This Work?

Let:

```text
a = unique part of List A
b = unique part of List B
c = common intersection part
```

Then:

```text
Length(A) = a + c
Length(B) = b + c
```

After switching heads:

```text
fst travels = a + c + b
sec travels = b + c + a
```

Both distances are equal:

```text
a + b + c
```

Therefore, the pointers align perfectly and meet at the intersection node.

If no intersection exists:

```text
fst → null
sec → null
```

at the same time.

## Time Complexity

```text
O(n + m)
```

Where:

- `n` = length of List A
- `m` = length of List B

Each pointer traverses at most both lists once.

## Space Complexity

```text
O(1)
```

No extra data structures are used.

## Small Observation

The beauty of this solution is that it avoids:

- Computing lengths
- Using a HashSet
- Extra memory

The head-switching trick automatically compensates for any difference in list lengths, making it one of the cleanest linked list solutions in DSA.
