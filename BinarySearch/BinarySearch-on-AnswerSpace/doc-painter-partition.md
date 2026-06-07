# Painter's Partition Problem

## Approach

We are given `A` painters and an array where each element represents the length of a board. Every painter can only paint contiguous boards, and each unit length takes `B` units of time.

The goal is to minimize the time required to paint all boards.

The key observation is:

- If a certain maximum workload can be assigned to the painters, then any larger workload will also be possible.
- If a workload is not feasible, any smaller workload will also be infeasible.

This monotonic property allows us to use Binary Search on the answer.

For a given maximum workload, we greedily assign boards to the current painter until adding another board would exceed the limit. At that point, we assign a new painter.

If the number of painters required is less than or equal to `A`, the workload is feasible.

## Algorithm

1. Find:
   - The maximum board length (`maxBoard`).
   - The total length of all boards (`totalLength`).
2. Set the Binary Search range:
   - `start = maxBoard`
   - `end = totalLength`
3. For each candidate workload:
   - Count how many painters are required.
4. If the required painters are less than or equal to `A`:
   - Search for a smaller workload.
5. Otherwise:
   - Search for a larger workload.
6. The final answer is:
   
   ```text
   minimumWorkload × B
   ```

7. Return the result modulo `10000003`.

## Example

**Input**

```java
A = 2
B = 5
C = [1, 10]
```

**Execution**

- Workload = 10
  - Painter 1 → [1]
  - Painter 2 → [10]
  - Painters required = 2
  - Valid

- Any smaller workload is not possible because one board has length 10.

Minimum workload = 10

Total time:

```text
10 × 5 = 50
```

**Output**

```java
50
```

## Time Complexity

- **O(n × log S)**

Where:

- `n` = number of boards
- `S` = sum of all board lengths

For each Binary Search step, we traverse the array once to count the required painters.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
