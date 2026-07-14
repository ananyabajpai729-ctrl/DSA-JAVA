# LRU Cache

## Problem Statement

Design a data structure that supports the following operations in **O(1)** time:

- `get(key)` – Return the value associated with the key if it exists; otherwise return `-1`.
- `put(key, value)` – Insert or update a key-value pair. If the cache exceeds its capacity, remove the **Least Recently Used (LRU)** item.

---

## Intuition

To achieve constant time operations, combine two data structures:

- **HashMap** for direct access to nodes using their keys.
- **Doubly Linked List** to maintain the order of usage.

The most recently used (MRU) node is kept at the **front** of the list, while the least recently used (LRU) node stays at the **end**.

Whenever a key is accessed or updated, move its node to the front.

---

## Approach

1. Maintain a doubly linked list with two dummy nodes:
   - `head` → before the most recently used node.
   - `tail` → after the least recently used node.
2. Store each key and its corresponding node in a `HashMap`.
3. **get(key)**
   - If the key doesn't exist, return `-1`.
   - Otherwise, remove the node from its current position and move it to the front.
4. **put(key, value)**
   - If the key already exists, remove its current node.
   - If the cache is full, remove the node just before `tail` (the least recently used node).
   - Insert the new node immediately after `head`.
   - Update the map accordingly.

---

## Time Complexity

- **get()** : `O(1)`
- **put()** : `O(1)`
- **Space:** `O(capacity)`

---

## Key Takeaway

The `HashMap` provides instant access to cache entries, while the doubly linked list efficiently maintains the usage order. By combining both, recently accessed items can be moved to the front and the least recently used item can be removed from the end in constant time, satisfying all problem constraints.
