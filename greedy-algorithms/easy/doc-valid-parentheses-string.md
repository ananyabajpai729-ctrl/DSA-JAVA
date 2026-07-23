# Valid Parenthesis String

## Problem Statement

Given a string `s` containing `'('`, `')'`, and `'*'`, determine whether it can represent a valid parentheses string.

The character `'*'` can be treated as:

- `'('`
- `')'`
- an empty string `""`

Return `true` if the string can be made valid; otherwise, return `false`.

---

## Intuition

The challenge comes from the wildcard `'*'`, which can represent three different things.

Trying every possibility would lead to an exponential number of combinations.

Instead, we track the **range of possible unmatched opening brackets** after processing each character.

We maintain:

- `minOpen` → the **minimum** possible number of unmatched `'('`.
- `maxOpen` → the **maximum** possible number of unmatched `'('`.

As we process each character, this range changes depending on what the character could represent.

If at any point even the **maximum** possible number of open brackets becomes negative, there are too many closing brackets and the string can never become valid.

---

## Approach

- Initialize:
  - `minOpen = 0`
  - `maxOpen = 0`
- Traverse the string:
  - If the character is `'('`:
    - Both minimum and maximum unmatched opens increase.
  - If it is `')'`:
    - Both decrease.
  - If it is `'*'`:
    - It could act as:
      - `')'` → decrease `minOpen`
      - `'('` → increase `maxOpen`
- If `maxOpen` becomes negative, return `false` immediately.
- Since unmatched opens cannot be negative, clamp:

```text
minOpen = max(minOpen, 0)
```

- After processing the entire string:
  - If `minOpen == 0`, a valid interpretation exists.

---

## Dry Run

**Input:**

```text
s = "(*)"
```

Processing:

```text
Character '('

minOpen = 1

maxOpen = 1

----------------

Character '*'

minOpen = 0

maxOpen = 2

----------------

Character ')'

minOpen = -1 → clamp to 0

maxOpen = 1
```

End of string:

```text
minOpen = 0
```

Output:

```text
true
```

---

### Another Example

```text
s = "(*))"
```

Processing:

```text
'('

min = 1

max = 1

----------------

'*'

min = 0

max = 2

----------------

')'

min = -1 → 0

max = 1

----------------

')'

min = -1 → 0

max = 0
```

Output:

```text
true
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Key Takeaway

The clever idea is that we **don't need to decide what each `'*'` represents immediately**.

Instead, we keep track of a **range**:

- `minOpen` = the fewest unmatched `'('` we could have.
- `maxOpen` = the most unmatched `'('` we could have.

Every `'*'` widens this range because it has multiple possible meanings.

Two important observations make the algorithm work:

- If `maxOpen < 0`, even the most optimistic interpretation has too many `')'`, so the answer is immediately `false`.
- If `minOpen` becomes negative, we reset it to `0` because we can always interpret some previous `'*'` as an empty string or `'('` to avoid having negative unmatched opens.

This is a beautiful example of a **Greedy** algorithm: instead of exploring every possibility, we maintain the range of all valid possibilities, achieving a linear-time solution.
