# Split Array Largest Sum

## Approach

We need to split the array into exactly `k` non-empty subarrays such that the largest subarray sum is minimized.

The key observation is:

- If a certain maximum subarray sum is valid, then any larger value will also be valid.
- If a value is too small to create at most `k` partitions, any smaller value will also fail.

This monotonic behavior allows us to use Binary Search on the answer.

For a given maximum allowed sum, we greedily form subarrays:

- Keep adding elements to the current subarray while the sum stays within the limit.
- If adding the next element exceeds the limit, start a new partition.
- Count the total number of partitions formed.

If the number of partitions is less than or equal to `k`, we try to minimize the answer further. Otherwise, we increase the allowed sum.

## Algorithm

1. Find:
   - The maximum element in the array (`maxElement`).
   - The total sum of the array (`totalSum`).
2. Set the Binary Search range:
   - `start = maxElement`
   - `end = totalSum`
3. For each candidate maximum sum:
   - Count how many partitions are required.
4. If the required partitions are less than or equal to `k`:
   - Search for a smaller valid answer.
5. Otherwise:
   - Search for a larger answer.
6. Return the minimum possible largest subarray sum.

## Example

**Input**

```java
nums = [7, 2, 5, 10, 8]
k = 2
```

**Execution**

- Maximum allowed sum = 21
  - Partitions: [7,2,5] and [10,8]
  - Total partitions = 2
  - Valid

- Try a smaller value.

- Maximum allowed sum = 17
  - Partitions: [7,2,5], [10], [8]
  - Total partitions = 3
  - Not valid

The minimum valid largest subarray sum is `18`.

**Output**

```java
18
```

## Time Complexity

- **O(n × log S)**

Where:

- `n` = size of the array
- `S` = sum of all elements in the array

For each Binary Search step, we traverse the entire array once to count partitions.

## Space Complexity

- **O(1)**

Only a few extra variables are used.
