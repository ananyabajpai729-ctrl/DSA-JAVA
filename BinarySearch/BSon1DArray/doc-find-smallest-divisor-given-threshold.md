# Find the Smallest Divisor Given a Threshold

## Approach

We need to find the smallest divisor such that the sum of:

```text
ceil(nums[i] / divisor)
```

for all elements in the array is less than or equal to the given threshold.

The key observation is:

- As the divisor increases, the resulting sum decreases.
- As the divisor decreases, the resulting sum increases.

This creates a monotonic search space, which allows us to use Binary Search on the possible divisor values.

For each candidate divisor, we calculate the total division sum and check whether it satisfies the threshold condition.

## Algorithm

1. Find the maximum element in the array.
2. Set the search range:
   - `start = 1`
   - `end = maxElement`
3. While `start <= end`:
   - Calculate the middle divisor.
   - Compute the sum of `ceil(nums[i] / divisor)` for all elements.
   - If the sum is within the threshold:
     - Store the divisor as a possible answer.
     - Search for a smaller valid divisor.
   - Otherwise:
     - Search for a larger divisor.
4. Return the smallest valid divisor.

## Example

**Input**

```java
nums = [1, 2, 5, 9]
threshold = 6
```

**Execution**

- Divisor = 5
  - Sum = 1 + 1 + 1 + 2 = 5
  - Valid, try smaller divisor

- Divisor = 3
  - Sum = 1 + 1 + 2 + 3 = 7
  - Exceeds threshold

- Divisor = 4
  - Sum = 1 + 1 + 2 + 3 = 7
  - Exceeds threshold

Smallest valid divisor = 5

**Output**

```java
5
```

## Time Complexity

- **O(n × log M)**

Where:

- `n` = size of the array
- `M` = maximum element in the array

For each Binary Search step, we traverse the entire array once.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
