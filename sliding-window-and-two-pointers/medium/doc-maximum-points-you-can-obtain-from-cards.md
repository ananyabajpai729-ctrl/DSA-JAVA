# Maximum Points You Can Obtain from Cards

## Problem Statement

You are given an integer array `cardPoints` and an integer `k`.

You can pick exactly `k` cards, taking each card either from the beginning or the end of the array.

Return the maximum score you can obtain.

---

## Intuition

At first glance, it feels like there are many possible combinations of taking cards from the front and back.

The trick is to realize that every valid choice can be represented as:

- Take some cards from the **front**
- Take the remaining cards from the **back**

So instead of trying every combination recursively, we can start with the case where we take all `k` cards from the front. Then, one by one, we replace cards from the front with cards from the back and keep track of the best score.

This lets us explore all possible splits in linear time.

---

## Approach

- Calculate the sum of the first `k` cards.
- This represents taking all cards from the front.
- Initialize the answer with this sum.
- Now, iterate `k` times:
  - Remove one card from the end of the front portion.
  - Add one card from the end of the array.
  - Update the maximum score.
- After considering every possible split between front and back picks, return the maximum score.

---

## Dry Run

**Input:**

```text
cardPoints = [1,2,3,4,5,6,1]
k = 3
```

Initially:

```text
Take first 3 cards

[1,2,3]

Sum = 6
```

Replace one front card with one back card:

```text
Remove 3
Add 1

[1,2] + [1]

Sum = 4
```

Replace again:

```text
Remove 2
Add 6

[1] + [6,1]

Sum = 8
```

Replace once more:

```text
Remove 1
Add 5

[6,5,1]

Sum = 12
```

Maximum score:

```text
12
```

---

## Time Complexity

- **Time:** `O(k)`
- **Space:** `O(1)`

---

## Key Takeaway

This problem looks like a sliding window question, but instead of maintaining a window inside the array, we are **sliding our selection between the two ends**.

A useful observation is that there are only `k + 1` possible ways to split the picks:

```text
k from front, 0 from back
k-1 from front, 1 from back
k-2 from front, 2 from back
...
0 from front, k from back
```

Evaluating each split by updating the sum incrementally gives an efficient `O(k)` solution without exploring every possible combination.
