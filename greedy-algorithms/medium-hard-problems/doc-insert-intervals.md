# Insert Interval

## Problem Statement

You are given a list of **non-overlapping intervals** sorted by their start times, along with a new interval.

Insert the new interval into the list such that:

- The intervals remain sorted.
- Any overlapping intervals are merged.

Return the updated list of intervals.

---

## Intuition

Since the intervals are **already sorted** and **do not overlap**, we don't need to compare the new interval with every interval multiple times.

Instead, every interval falls into exactly one of three categories:

1. **Completely before** the new interval.
2. **Overlapping** with the new interval.
3. **Completely after** the new interval.

We can process these three regions one by one.

The only place where any work is required is the overlapping region, where we keep expanding the new interval to absorb every interval that intersects it.

---

## Approach

Traverse the intervals in three phases.

### Phase 1: Add non-overlapping intervals before the new interval

As long as an interval ends before the new interval starts,

```text
interval.end < newInterval.start
```

it can never overlap.

Simply add it to the answer.

---

### Phase 2: Merge all overlapping intervals

While an interval starts before the new interval ends,

```text
interval.start <= newInterval.end
```

the two intervals overlap.

Expand the new interval:

```text
start = min(start, interval.start)

end = max(end, interval.end)
```

This keeps one continuously growing merged interval.

---

### Phase 3: Add the merged interval

After all overlaps have been processed,

the updated `newInterval` represents the fully merged interval.

Add it to the answer.

---

### Phase 4: Add the remaining intervals

Every remaining interval starts after the merged interval ends,

so they cannot overlap.

Append them directly.

---

## Dry Run

**Input:**

```text
intervals = [[1,3],[6,9]]

newInterval = [2,5]
```

### Phase 1

```text
[1,3]

Ends after new interval starts

Cannot add yet
```

No intervals are added.

---

### Phase 2

Merge:

```text
[1,3]

+

[2,5]

↓

[1,5]
```

---

### Phase 3

Add:

```text
[1,5]
```

---

### Phase 4

Remaining interval:

```text
[6,9]
```

Final answer:

```text
[[1,5],[6,9]]
```

---

### Another Example

```text
intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]

newInterval = [4,8]
```

Processing:

```text
Before

[1,2]

----------------

Merge

[3,5]

[6,7]

[8,10]

↓

[3,10]

----------------

After

[12,16]
```

Output:

```text
[[1,2],[3,10],[12,16]]
```

---

## Time Complexity

- **Time:** `O(n)`

  Each interval is processed exactly once.

- **Space:** `O(n)`

  Used to store the resulting intervals.

---

## Key Takeaway

The sorted nature of the input is what makes this problem simple.

Instead of checking every pair of intervals, we divide the array into three regions:

```text
No Overlap

↓

Overlap

↓

No Overlap
```

Only the middle region requires merging.

The new interval keeps expanding as long as overlaps exist:

```text
[2,5]

↓

[1,5]

↓

[1,7]

↓

[1,10]
```

Once an interval no longer overlaps, every remaining interval will also be non-overlapping because the list is sorted.

This "before → merge → after" pattern is a common technique for interval insertion and interval merging problems.
