# Rotate List

## Approach

To rotate a linked list to the right by `k` positions, we can think of moving the last `k` nodes to the front.

A naive approach would perform one rotation at a time, resulting in:

```text
O(n × k)
```

Instead, we can do it efficiently in three steps:

1. Find the length of the list.
2. Convert the list into a circular linked list.
3. Break the circle at the correct position.

## Algorithm

### Step 1: Find Length and Tail

Traverse the list to find:

- Total number of nodes.
- The last node (`tailNode`).

```java
int length = 1;
ListNode tailNode = head;
```

Example:

```text
1 -> 2 -> 3 -> 4 -> 5
```

Length:

```text
5
```

Tail:

```text
5
```

---

### Step 2: Form a Circular List

Connect the tail back to the head:

```java
tailNode.next = head;
```

Now:

```text
1 -> 2 -> 3 -> 4 -> 5
^                   |
|___________________|
```

---

### Step 3: Reduce Unnecessary Rotations

Rotating by:

```text
k = length
```

returns the same list.

Therefore:

```java
k = k % length;
```

Example:

```text
length = 5
k = 12
```

becomes:

```text
k = 2
```

---

### Step 4: Find the New Tail

After rotating right by `k`, the new tail is located at:

```text
length - k
```

positions from the beginning.

```java
int steps = length - k;
```

Move:

```java
newTail = head;
```

for:

```java
steps - 1
```

iterations.

---

### Step 5: Break the Circle

The node after `newTail` becomes the new head:

```java
ListNode newHead = newTail.next;
```

Break the cycle:

```java
newTail.next = null;
```

Return:

```java
newHead
```

## Example

### Input

```text
1 -> 2 -> 3 -> 4 -> 5
k = 2
```

### Circular List

```text
1 -> 2 -> 3 -> 4 -> 5
^                   |
|___________________|
```

### New Tail Position

```text
length = 5
k = 2

steps = 5 - 2 = 3
```

New tail:

```text
1 -> 2 -> 3 -> 4 -> 5
          ^
       newTail
```

### New Head

```text
1 -> 2 -> 3 -> 4 -> 5
               ^
            newHead
```

### Break the Cycle

```text
4 -> 5 -> 1 -> 2 -> 3
```

### Output

```text
4 -> 5 -> 1 -> 2 -> 3
```

## Example 2

### Input

```text
0 -> 1 -> 2
k = 4
```

### Effective Rotation

```text
k = 4 % 3 = 1
```

### Output

```text
2 -> 0 -> 1
```

## Why Use a Circular List?

Instead of manually shifting nodes:

```text
5 -> 1 -> 2 -> 3 -> 4
```

we temporarily connect:

```text
tail -> head
```

forming a cycle.

Then the problem becomes:

```text
Find the correct place to cut the circle.
```

This greatly simplifies the implementation.

## Time Complexity

### Find Length

```text
O(n)
```

### Find New Tail

```text
O(n)
```

Overall:

```text
O(n)
```

## Space Complexity

```text
O(1)
```

Only a few pointers are used.

## Small Observation

The line:

```java
k = k % length;
```

is crucial.

Without it, a test case like:

```text
1 -> 2 -> 3 -> 4 -> 5
k = 1000000
```

would require unnecessary rotations.

Since every `length` rotations return the list to its original state, we only care about:

```text
k mod length
```

which keeps the solution efficient regardless of how large `k` is. 
