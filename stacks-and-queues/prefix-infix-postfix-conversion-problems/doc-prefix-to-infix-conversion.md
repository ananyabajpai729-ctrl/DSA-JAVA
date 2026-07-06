# Prefix to Infix Conversion

## Problem Statement

Given a prefix expression containing operands and operators, convert it into its equivalent infix expression.

---

## Intuition

In a prefix expression, an operator appears before its operands.

By traversing the expression from **right to left**, operands are encountered before their corresponding operator. A stack is used to store partial infix expressions until an operator combines them into a larger expression.

---

## Approach

1. Traverse the prefix expression from right to left.
2. If the current character is an operand, push it onto the stack.
3. If it is an operator:
   - Pop the top two expressions from the stack.
   - Form a new infix expression:
     ```text
     (operand1 operator operand2)
     ```
   - Push the newly formed expression back onto the stack.
4. After processing all characters, the stack contains the final infix expression.

---

## Dry Run

**Input:**

```text
*-A/BC-/AKL
```

Processing:

```text
L          → Push
K          → Push
A          → Push
-          → (A-K)

C          → Push
B          → Push
/          → (B/C)

A          → Push
-          → (A-(B/C))

*          → ((A-(B/C))*(A-K))
```

Final output:

```text
((A-(B/C))*(A-K))
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Key Takeaway

Traversing the prefix expression from **right to left** ensures operands are available before their operator. A stack naturally builds larger infix expressions by repeatedly combining the top two operands whenever an operator is encountered.
