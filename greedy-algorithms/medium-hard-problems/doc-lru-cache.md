# LRU Cache

## Problem Statement

Design a data structure that supports the following operations in **O(1)** time:

- `get(key)` → Return the value of the key if it exists, otherwise return `-1`.
- `put(key, value)` → Insert or update the key-value pair. If the cache exceeds its capacity, remove the **Least Recently Used (LRU)** item.

---

## Intuition

The challenge is that we need to perform **both searching and updating the usage order in constant time**.

Using only a `HashMap` allows us to find elements quickly, but it cannot maintain the order of usage.

Using only a linked list maintains the order but searching for a key becomes `O(n)`.

The solution is to combine both:

- **HashMap** → Instantly locate a node using its key.
- **Doubly Linked List** → Maintain the order of recently used items.

The most recently used (MRU) item is always kept at the **front** of the list, while the least recently used (LRU) item stays at the **back**.

Whenever a key is accessed or updated, it becomes the most recently used, so we move it to the front.

---

## Data Structures Used

### HashMap

```text
key → Node
```

Allows direct access to any cache entry in `O(1)`.

---

### Doubly Linked List

```text
Head <-> Most Recently Used ... Least Recently Used <-> Tail
```

Two dummy nodes (`head` and `tail`) simplify insertion and deletion because every real node always has both a previous and next node.

---

## Approach

### `addNode()`

Insert a node immediately after the head.

```text
Head

↓

[new]

↓

Old First Node
```

This marks the node as **Most Recently Used**.

---

### `deleteNode()`

Remove a node from anywhere in the list by reconnecting its neighbouring nodes.

```text
Prev <-> Node <-> Next

↓

Prev <--------> Next
```

Since it's a doubly linked list, deletion takes `O(1)`.

---

### `get(key)`

- If the key doesn't exist, return `-1`.
- Otherwise:
  - Retrieve the node from the HashMap.
  - Remove it from its current position.
  - Move it to the front.
  - Return its value.

Accessing an element makes it the **Most Recently Used**.

---

### `put(key, value)`

- If the key already exists:
  - Remove its old node.
- If the cache is full:
  - Remove the node just before the tail.
  - This is the Least Recently Used item.
- Insert the new node at the front.
- Store its reference in the HashMap.

---

## Dry Run

**Capacity = 2**

### put(1,1)

```text
Head ⇄ [1] ⇄ Tail
```

Map:

```text
1 → Node(1)
```

---

### put(2,2)

```text
Head ⇄ [2] ⇄ [1] ⇄ Tail
```

Most recent is `2`.

---

### get(1)

Move `1` to the front.

```text
Head ⇄ [1] ⇄ [2] ⇄ Tail
```

Return:

```text
1
```

---

### put(3,3)

Cache is full.

Remove the least recently used node.

```text
Remove [2]
```

Insert `3`.

```text
Head ⇄ [3] ⇄ [1] ⇄ Tail
```

Cache now contains:

```text
1, 3
```

---

### get(2)

`2` no longer exists.

Return:

```text
-1
```

---

## Time Complexity

| Operation | Complexity |
|-----------|-----------:|
| `get()` | `O(1)` |
| `put()` | `O(1)` |
| **Space** | `O(capacity)` |

---

## Key Takeaway

The entire design relies on combining the strengths of two data structures:

- **HashMap** provides **constant-time lookup**.
- **Doubly Linked List** provides **constant-time insertion and deletion**.

Neither data structure alone can solve the problem efficiently, but together they achieve `O(1)` for every operation.

The key invariant is:

```text
Head
↓

Most Recently Used

↓

...

↓

Least Recently Used

↓

Tail
```

Every time a key is accessed or inserted:

- Move it to the **front**.

Whenever the cache exceeds its capacity:

- Remove the node just before the **tail**.

This combination of a **HashMap + Doubly Linked List** is a classic interview pattern and appears in many cache and system design problems.

---

## Visual Representation

```text
HashMap

1 ─────────────┐
2 ───────┐     │
          │     │
          ▼     ▼

Head ⇄ [2] ⇄ [1] ⇄ Tail
        MRU        LRU
```

The HashMap tells us **where** a node is, while the linked list tells us **how recently** it was used.
