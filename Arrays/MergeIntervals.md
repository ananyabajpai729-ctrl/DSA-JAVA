# Intuition

Imagine each interval as a meeting slot on a timeline.

If two meetings overlap, it doesn't make sense to keep them separate—we can simply merge them into one larger interval.

The challenge is that overlapping intervals may not be next to each other in the input.

So before merging anything, we first bring order to the chaos:

> Sort all intervals by their starting time.

Once sorted, any overlapping interval must appear right after the interval it overlaps with.

From there, we only need to compare the current interval with the next one and decide:

- Merge them if they overlap.
- Store the current interval and move on if they don't.

# Approach

### Step 1: Handle Edge Cases

If there are zero or one intervals, there is nothing to merge.

Simply return the input.

### Step 2: Sort the Intervals

Sort the intervals based on their starting values.

For example:

```text
[[8,10],[1,3],[2,6],[15,18]]
```

becomes

```text
[[1,3],[2,6],[8,10],[15,18]]
```

Now all potential overlaps are positioned next to each other.

### Step 3: Start with the First Interval

Treat the first interval as the current interval and add it to the answer list.

```text
currentInterval = intervals[0]
```

### Step 4: Check for Overlaps

For every next interval:

#### Case 1: Overlap Exists

If:

$$
nextStart \le currentEnd
$$

the intervals overlap.

Example:

```text
[1,3] and [2,6]
```

Since:

```text
2 ≤ 3
```

they overlap.

Merge them by extending the ending point:

```text
[1,6]
```

which means:

```text
currentInterval[1] = max(currentEnd, nextEnd)
```

---

#### Case 2: No Overlap

If:

$$
nextStart > currentEnd
$$

the intervals are completely separate.

Example:

```text
[1,6] and [8,10]
```

Since they don't overlap:

- Add the new interval to the answer.
- Make it the new current interval.

### Step 5: Return the Result

Convert the list of merged intervals back into a 2D array and return it.

# Why This Works

Sorting guarantees that:

- Every overlapping interval appears immediately after the interval it overlaps with.
- Once an interval doesn't overlap, no future interval can overlap with the previous merged interval.

This allows us to process the intervals in a single pass after sorting.

Instead of repeatedly checking every pair of intervals, we keep expanding the current merged interval whenever an overlap is found.

# Complexity

- Time complexity:

$$O(n \log n) + O(n)$$

where:

- $$O(n \log n)$$ is used for sorting the intervals.
- $$O(n)$$ is used for traversing and merging them.

Overall:

$$O(n \log n)$$

- Space complexity:

$$O(n)$$

In the worst case, none of the intervals overlap, so all intervals are stored in the answer list.
