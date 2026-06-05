# Minimum Number of Days to Make m Bouquets

## Approach

To make `m` bouquets, each bouquet requires `k` adjacent flowers. A flower can only be used if it has bloomed by a given day.

The key observation is:

- If it is possible to make all required bouquets on a certain day, then it will also be possible on any later day.
- If it is not possible on a certain day, then it will not be possible on any earlier day.

This monotonic behavior makes Binary Search a perfect fit.

For every candidate day, we check whether we can form at least `m` bouquets by counting consecutive bloomed flowers.

## Algorithm

1. Check if the total number of flowers required (`m × k`) exceeds the number of available flowers.
   - If yes, return `-1`.
2. Find the minimum and maximum bloom day in the array.
3. Apply Binary Search on the range `[minDay, maxDay]`.
4. For each middle day:
   - Count how many bouquets can be formed using flowers that have bloomed on or before that day.
   - If at least `m` bouquets can be formed:
     - Store the day as a possible answer.
     - Search for a smaller valid day.
   - Otherwise:
     - Search for a larger day.
5. Return the minimum valid day found.

## Example

**Input**

```java
bloomDay = [1,10,3,10,2]
m = 3
k = 1
```

**Execution**

- Day 5:
  - Bloomed flowers = [1, 3, 2]
  - Bouquets formed = 3
  - Valid day

- Try smaller days.

- Day 3:
  - Bloomed flowers = [1, 3, 2]
  - Bouquets formed = 3
  - Still valid

- Day 2:
  - Bouquets formed = 2
  - Not enough

Minimum valid day = 3

**Output**

```java
3
```

## Time Complexity

- **O(n × log D)**

Where:

- `n` = number of flowers
- `D` = `maxBloomDay - minBloomDay`

For each Binary Search step, we traverse the entire array once.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
