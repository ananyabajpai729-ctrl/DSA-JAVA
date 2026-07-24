# Candy

## Problem Statement

There are `n` children standing in a line.

Each child has a rating given in the array `ratings`.

You must distribute candies such that:

- Every child receives **at least one candy**.
- A child with a **higher rating than an adjacent child** must receive **more candies** than that neighbor.

Return the **minimum number of candies** required.

---

## Intuition

At first glance, it feels like we should decide the candies for each child individually.

However, notice that the ratings form **slopes**:

- Increasing sequence → candies should keep increasing.
- Decreasing sequence → candies should keep decreasing when viewed from the peak.
- Equal ratings → no relationship exists, so both children can simply receive one candy.

Instead of storing candies for every child, we only need to measure:

- the length of the **uphill (peak)**, and
- the length of the **downhill (valley)**.

The only tricky part is the **peak child**.

It gets counted in both the increasing and decreasing sequences, so we subtract the smaller slope once to avoid double counting.

---

## Approach

- Initially, give every child **one candy**.

```text
candies = n
```

- Traverse the ratings array.

### Case 1: Equal ratings

- No ordering constraint exists.
- Move to the next child.

### Case 2: Increasing slope

- Count how long the increasing sequence is.
- Each next child receives one more candy than the previous.
- Add these extra candies to the answer.

### Case 3: Decreasing slope

- Count the decreasing sequence.
- Similarly, add the required extra candies.

### Peak Adjustment

The peak child belongs to **both** slopes.

Subtract:

```text
min(peak, valley)
```

because that portion was counted twice.

---

## Dry Run

**Input:**

```text
ratings = [1,2,3,2,1]
```

Initially:

```text
Everyone gets 1 candy

Candies = 5
```

Increasing slope:

```text
1 → 2 → 3

peak = 2

Extra candies:

+1

+2

Candies = 8
```

Decreasing slope:

```text
3 → 2 → 1

valley = 2

Extra candies:

+1

+2

Candies = 11
```

Peak counted twice:

```text
Subtract min(2,2)

Candies = 9
```

Distribution:

```text
1 2 3 2 1
```

Total:

```text
9
```

---

### Another Example

```text
ratings = [1,0,2]
```

Processing:

```text
Base candies = 3

Downhill:

1 → 0

+1

----------------

Uphill:

0 → 2

+1

----------------

Subtract overlap

1
```

Final candies:

```text
5
```

Distribution:

```text
2 1 2
```

---

## Time Complexity

- **Time:** `O(n)`

  Every child is processed at most once.

- **Space:** `O(1)`

  No additional array is required.

---

## Key Takeaway

The clever observation is that **ratings naturally form mountains**.

Instead of assigning candies one child at a time, think in terms of:

```text
Increasing slope

↓

Peak

↓

Decreasing slope
```

For an uphill of length `u`:

```text
1 2 3 ... (u + 1)
```

the extra candies contributed are:

```text
1 + 2 + ... + u
```

Similarly, a downhill of length `d` contributes:

```text
1 + 2 + ... + d
```

The peak belongs to **both** slopes, so we subtract:

```text
min(uphill, downhill)
```

This ensures the peak receives enough candies to satisfy **both sides**, while avoiding double counting.

This is one of the most elegant greedy solutions because it achieves the optimal answer in **O(n)** time using **constant extra space**, without maintaining a separate candies array.
