# Asteroid Collision

## Problem Statement

Given an array of integers representing asteroids, where the absolute value denotes the size and the sign denotes the direction (`+` for right, `-` for left), determine the state of the asteroids after all collisions.

---

## Intuition

A collision is only possible when a right-moving asteroid is followed by a left-moving asteroid. To efficiently process these collisions, maintain a stack of asteroids that have survived so far.

When a new left-moving asteroid arrives, repeatedly compare it with the right-moving asteroid on the top of the stack until one of them is destroyed or no collision is possible.

---

## Approach

1. Traverse the asteroid array from left to right.
2. If the current asteroid is moving right, push it onto the stack.
3. If it is moving left:
   - Remove all smaller right-moving asteroids from the top of the stack.
   - If the top asteroid has the same size, remove it as both explode.
   - If the stack becomes empty or the top asteroid is also moving left, push the current asteroid.
   - Otherwise, the current asteroid is destroyed.
4. Convert the stack into the required result array.

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Key Takeaway

Although a collision may trigger multiple consecutive collisions, each asteroid is pushed onto the stack at most once and popped at most once. This ensures an overall linear time complexity while accurately simulating all possible collisions.
