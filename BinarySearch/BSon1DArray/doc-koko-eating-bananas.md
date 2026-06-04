# Koko Eating Bananas

## Approach

Koko can choose an eating speed `k` bananas per hour. Our goal is to find the minimum speed that allows her to finish all banana piles within `h` hours.

The key observation is:

- If a certain speed can finish all bananas within `h` hours, then any higher speed can also do it.
- If a speed is too slow, any smaller speed will also be too slow.

This creates a monotonic search space, making Binary Search an ideal solution.

For each candidate speed, we calculate the total hours required to finish all piles using:

```java
Math.ceil((double) pile / speed)
```

If the total hours are within the limit, we try a smaller speed. Otherwise, we increase the speed.

## Algorithm

1. Find the maximum pile size.
2. Set the search range:
   - `start = 1`
   - `end = maxPile`
3. While `start <= end`:
   - Calculate `mid` as the current eating speed.
   - Compute the total hours needed at this speed.
   - If the hours are within `h`:
     - Store the speed as a possible answer.
     - Search for a smaller valid speed.
   - Otherwise:
     - Search for a larger speed.
4. Return the minimum valid speed found.

## Example

**Input**

```java
piles = [3, 6, 7, 11]
h = 8
```

**Execution**

- Speed = 6
  - Hours = 1 + 1 + 2 + 2 = 6
  - Valid, try smaller speed

- Speed = 3
  - Hours = 1 + 2 + 3 + 4 = 10
  - Too slow

- Speed = 4
  - Hours = 1 + 2 + 2 + 3 = 8
  - Valid

Search ends.

**Output**

```java
4
```

## Time Complexity

- **O(n × log m)**

Where:

- `n` = number of piles
- `m` = maximum pile size

For each Binary Search step, we traverse all piles once.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
