# Max Consecutive Ones III

## Problem Statement
Given a binary array nums and an integer k, find the size of the largest subarray of consecutive `1`s after flipping at most `k` zeroes.

---

## Intuition
The window remains valid as long as there are at most k zeroes, as soon as the number of zeroes exceed k, the window is invalid.
So in case of an invalid window, we start moving the left pointer and start chucking away the extra zeroes as and when we get them.
Finally, it is upto us to keep this new subarray length or the previous one, because it is possible(and this is the fear which stands in the way of my sliding window intuition) that after expanding and then deleting from left side, we end up with a shorter window.
So don't worry, we only take the best length.

---

## Approach
Initialise left and right pointers and maxLen
Initialise a variable to count zeroes
Start by placing both pointers at the first element, iterate till right pointer reaches end of the array.
If the element is zero, we increase zeroCount
now if zeroCount is more than k, we start bidding goodbye to our leftmost elements.
If leftmost element is a zero, decrease zeroCount by 1
Keep increasing left pointer till the condition remains true
find maxLen by comparing it with `right - left + 1`
return maxLen

---

## Dry Run

**Input:**

```text
nums = [1,1,1,0,0,0,1,1,1,1,0]
k = 2
```

Window expansion:

```text
[1,1,1,0,0]      → 2 zeros ✓

Add another 0

[1,1,1,0,0,0]    → 3 zeros ✗

Shrink from left until only 2 zeros remain.

Continue expanding...

Longest valid window length = 6
```

Output:

```text
6
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Key Takeaway

Initially I was worried that shrinking the window might discard the optimal answer.

The key realization was that every valid window is considered before shrinking, so even if the current window becomes shorter, the best answer has already been recorded.
