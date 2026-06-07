# Aggressive Cows

## Approach

We need to place `k` cows in the given stalls such that the minimum distance between any two cows is as large as possible.

The key observation is:

- If we can place all cows with a minimum distance `d`, then we can also place them with any smaller distance.
- If we cannot place all cows with distance `d`, then any larger distance will also be impossible.

This monotonic behavior allows us to apply Binary Search on the answer.

For each candidate distance, we greedily place cows:

- Place the first cow in the first stall.
- Place the next cow in the first stall that is at least `d` units away from the last placed cow.
- Continue until all stalls are checked.

If we can place at least `k` cows, the distance is valid and we try a larger distance. Otherwise, we try a smaller one.

## Algorithm

1. Sort the stall positions.
2. Set the Binary Search range:
   - `start = 1`
   - `end = lastStall - firstStall`
3. For each candidate distance:
   - Place cows greedily.
   - Count how many cows can be placed.
4. If at least `k` cows can be placed:
   - Store the distance as a possible answer.
   - Search for a larger distance.
5. Otherwise:
   - Search for a smaller distance.
6. Return the largest valid minimum distance.

## Example

**Input**

```java
nums = [1, 2, 4, 8, 9]
k = 3
```

**Execution**

- Distance = 3
  - Place cows at positions 1, 4, 8
  - Total cows placed = 3
  - Valid

- Try a larger distance.

- Distance = 4
  - Place cows at positions 1, 8
  - Total cows placed = 2
  - Not valid

Largest valid minimum distance = 3

**Output**

```java
3
```

## Time Complexity

- **O(n log n + n × log D)**

Where:

- `n` = number of stalls
- `D` = maximum possible distance between two stalls

The array is sorted once in `O(n log n)`, and each Binary Search step requires a linear scan of the stalls.

## Space Complexity

- **O(1)**

Ignoring the space used by the sorting algorithm.
