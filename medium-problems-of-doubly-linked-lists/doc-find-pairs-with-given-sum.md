# Find Pairs with Given Sum in a Sorted Doubly Linked List

## Approach

Since the doubly linked list is already **sorted**, we can use the **Two Pointer Technique** similar to the classic "Two Sum in Sorted Array" problem.

We maintain:

- `left` → starts from the beginning of the list.
- `right` → starts from the end of the list.

At each step:

- If the sum equals the target, store the pair.
- If the sum is smaller than the target, move `left` forward.
- If the sum is greater than the target, move `right` backward.

Because the list is sorted, these movements help us efficiently search for valid pairs without checking every combination.

## Algorithm

### Step 1: Initialize Pointers

```java
left = head;
right = head;
```

Move `right` to the last node:

```java
while(right.next != null){
    right = right.next;
}
```

---

### Step 2: Search for Pairs

Continue while the pointers do not cross:

```java
while(left != right && right.next != left)
```

Compute:

```java
currentSum = left.val + right.val;
```

---

### Step 3: Handle Cases

#### Sum Equals Target

Store the pair:

```java
[left.val, right.val]
```

Then move both pointers:

```java
left = left.next;
right = right.prev;
```

---

#### Sum Less Than Target

We need a larger sum.

Move:

```java
left = left.next;
```

---

#### Sum Greater Than Target

We need a smaller sum.

Move:

```java
right = right.prev;
```

---

## Example

### Input

```text
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
target = 7
```

### Initial Pointers

```text
L                             R
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
```

```text
1 + 9 = 10
```

Too large → move `right`.

---

```text
L                       R
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
```

```text
1 + 8 = 9
```

Too large → move `right`.

---

```text
L                 R
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
```

```text
1 + 6 = 7
```

Pair found:

```text
[1, 6]
```

Move both pointers.

---

```text
    L         R
1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
```

```text
2 + 5 = 7
```

Pair found:

```text
[2, 5]
```

### Output

```text
[[1, 6], [2, 5]]
```

## Why Does This Work?

Because the list is sorted:

- Moving `left` forward always increases the sum.
- Moving `right` backward always decreases the sum.

This allows us to eliminate large portions of the search space without checking every pair.

## Time Complexity

```text
O(n)
```

Each pointer moves at most once across the list.

## Space Complexity

```text
O(1)
```

Ignoring the space required for storing the output pairs.

## Small Observation

The condition:

```java
while(left != right && right.next != left)
```

is important because pointers in a doubly linked list can cross each other.

For example:

```text
1 <-> 2 <-> 3 <-> 4
      L    R
```

After one more movement:

```text
1 <-> 2 <-> 3 <-> 4
         R    L
```

At this point, all possible pairs have already been checked, so the loop should stop.

This condition correctly handles both:

- Odd-length lists (`left == right`)
- Even-length lists (`right.next == left`)
