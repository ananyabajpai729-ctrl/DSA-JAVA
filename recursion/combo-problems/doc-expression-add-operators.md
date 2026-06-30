# Expression Add Operators

## Problem Statement

Given a string containing only digits and an integer `target`, insert the operators `'+'`, `'-'`, and `'*'` between the digits so that the resulting expression evaluates to the target value.

Return all such valid expressions.

---

## Intuition

We build the expression one number at a time.

At each step, we choose a substring to form the next number and try inserting each of the three operators before it.

The tricky part is handling multiplication, since it has higher precedence than addition and subtraction. Instead of evaluating the entire expression repeatedly, we keep track of the **current result** and the **last operand**, allowing us to correctly adjust the value when a `'*'` operator is used.

---

## Approach

1. Start from the first digit.
2. Form every possible number by extending the current substring.
3. If it's the first number, start the expression without any operator.
4. Otherwise, recursively try:
   - Addition (`+`)
   - Subtraction (`-`)
   - Multiplication (`*`) by adjusting the previous operand.
5. Skip numbers with leading zeros (except `"0"`).
6. When all digits are used, add the expression if its value equals the target.

---

## Dry Run

**Input:**

```text
num = "123"
target = 6
```

Possible expressions explored:

```text
1+2+3 = 6 ✓
1*2*3 = 6 ✓
1+23 = 24
12-3 = 9
```

Output:

```text
["1+2+3", "1*2*3"]
```

---

## Time Complexity

- **Time:** `O(4ⁿ)`
- **Space:** `O(n)` recursion stack (excluding the output list).

The exponential complexity comes from trying different ways to split the string and insert operators.

---

## Key Takeaway

This is a **Backtracking** problem with expression evaluation.

The key idea is to maintain the **current expression value** and the **last operand**, which allows multiplication to be handled correctly without evaluating the entire expression every time.
