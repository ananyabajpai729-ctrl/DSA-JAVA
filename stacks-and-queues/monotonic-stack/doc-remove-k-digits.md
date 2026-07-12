# Remove K Digits

## Problem Statement

Given a non-negative integer `num` represented as a string and an integer `k`, remove `k` digits from the number so that the resulting number is the smallest possible.

---

## Intuition

To obtain the smallest possible number, larger digits should be removed whenever a smaller digit appears after them.

A **monotonic increasing stack** helps maintain the smallest possible sequence of digits. Whenever the current digit is smaller than the top of the stack and removals are still allowed, the larger digit is removed.

---

## Approach

1. Traverse each digit of the number.
2. While:
   - the stack is not empty,
   - the top digit is greater than the current digit,
   - and `k > 0`,
   
   remove the top digit from the stack.
3. Push the current digit onto the stack.
4. If removals are still left after traversal, remove digits from the end of the stack.
5. Construct the answer from the stack.
6. Remove leading zeros from the resulting number.
7. If no digits remain, return `"0"`.

---

## Dry Run

**Input:**

```text
num = "1432219"
k = 3
```

Processing:

```text
1 → [1]

4 → [1,4]

3 → Remove 4
     [1,3]

2 → Remove 3
     [1,2]

2 → [1,2,2]

1 → Remove 2
     [1,2,1]

9 → [1,2,1,9]
```

Result:

```text
1219
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Key Takeaway

A monotonic increasing stack ensures that larger digits are removed as soon as a smaller digit appears, producing the lexicographically smallest possible number. If removals remain after processing all digits, the remaining digits are removed from the end since they have the greatest positional impact.
