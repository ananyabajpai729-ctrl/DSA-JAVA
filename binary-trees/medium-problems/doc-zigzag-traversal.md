# Binary Tree Zigzag Level Order Traversal

## Problem Statement

Given the root of a binary tree, return the **zigzag level order traversal** of its nodes' values.

The first level should be traversed from left to right, the second from right to left, the third from left to right again, and so on.

---

## Intuition

This problem is nothing but a slight modification of the normal **Level Order Traversal (BFS)**.

The queue works exactly the same way—we still process one level at a time.

The only difference is how we store the nodes of the current level.

- If the current level is traversed from left to right, simply append every node to the end.
- If the direction is right to left, insert every new node at the beginning of the list.

A boolean flag is enough to remember the current direction. After finishing one level, simply flip the flag.

One thing I found interesting is that we don't actually traverse the tree in reverse. The BFS order always remains the same. We only change how we **store** the values for that level.

---

## Approach

Create an answer list and return it immediately if the tree is empty.

Maintain a queue for the normal level order traversal and insert the root.

Maintain a boolean flag to represent the traversal direction.

While the queue is not empty:

- Store the current queue size, as it represents one complete level.
- Create a new list for the current level.
- Process exactly `size` nodes.
- Remove one node from the queue.
- If the flag is `false`, insert the value at the end.
- Otherwise, insert it at the beginning.
- Push the left and right children into the queue if they exist.

After processing the entire level:

- Add the level to the answer.
- Flip the direction flag.

Finally, return the answer.

---

## Dry Run

**Input:**

```text
        3
       / \
      9   20
         /  \
        15   7
```

### Level 1

Direction:

```text
Left → Right
```

Level:

```text
[3]
```

Queue:

```text
9, 20
```

---

### Level 2

Direction:

```text
Right → Left
```

Instead of appending,

```text
9 → [9]

20 → [20, 9]
```

Level:

```text
[20, 9]
```

Queue:

```text
15, 7
```

---

### Level 3

Direction:

```text
Left → Right
```

Level:

```text
[15, 7]
```

Final Answer:

```text
[
 [3],
 [20,9],
 [15,7]
]
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Key Takeaway

This problem taught me that sometimes the traversal itself doesn't need to change—only the way we **record** the answer does.

The BFS remains identical to the normal level order traversal:

```text
Take one level

↓

Process every node

↓

Push their children
```

The only additional logic is deciding whether to place the current value at the front or the back of the current level.

So instead of thinking,

> "How do I traverse the tree in zigzag order?"

it's easier to think,

> "How do I build each level in zigzag order?"

That small shift in perspective makes the solution much simpler.
