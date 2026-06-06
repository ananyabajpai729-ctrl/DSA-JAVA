# Capacity To Ship Packages Within D Days

## Approach

We need to find the minimum ship capacity that allows all packages to be shipped within the given number of days.

The key observation is:

- If a certain capacity is sufficient to ship all packages within `days`, then any larger capacity will also work.
- If a capacity is not sufficient, any smaller capacity will also fail.

This monotonic behavior allows us to use Binary Search on the answer.

For a given capacity, we simulate the shipping process:

- Keep adding packages to the current shipment while the capacity allows.
- If adding a package exceeds the capacity, start a new day.
- Count the total number of days required.

If the required days are within the limit, we try a smaller capacity. Otherwise, we increase the capacity.

## Algorithm

1. Find:
   - The maximum package weight (`maxWeight`).
   - The total weight of all packages (`totalWeight`).
2. Set the Binary Search range:
   - `start = maxWeight`
   - `end = totalWeight`
3. For each candidate capacity:
   - Simulate the shipping process.
   - Calculate the number of days required.
4. If the packages can be shipped within the given days:
   - Search for a smaller capacity.
5. Otherwise:
   - Search for a larger capacity.
6. Return the minimum valid capacity.

## Example

**Input**

```java
weights = [1,2,3,4,5,6,7,8,9,10]
days = 5
```

**Execution**

- Capacity = 15
  - Required days = 5
  - Valid capacity

- Try smaller capacities.

- Capacity = 14
  - Required days > 5
  - Not valid

Minimum valid capacity = 15

**Output**

```java
15
```

## Time Complexity

- **O(n × log S)**

Where:

- `n` = number of packages
- `S` = sum of all package weights

For every Binary Search step, we traverse the entire array once.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
