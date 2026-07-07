# Postfix to Infix Conversion

## Problem Statement

Given a postfix expression containing operands and operators, convert it into its equivalent infix expression.

---

## Intuition

In a postfix expression, every operator comes **after** its operands, whereas in an infix expression, the operator is placed **between** its operands.

By traversing the postfix expression from **left to right**, operands are pushed onto a stack. Whenever an operator is encountered, the top two expressions are combined into a new infix expression enclosed in parentheses.

---

## Approach

1. Traverse the postfix expression from left to right.
2. If the current character is an operand, push it onto the stack.
3. If it is an operator:
   - Pop the top two expressions.
   - Let the first popped expression be the **right operand** and the second popped expression be the **left operand**.
   - Form a new infix expression:
     ```text
     (leftOperand operator rightOperand)
     ```
   - Push the newly formed expression back onto the stack.
4. After processing the entire expression, the stack contains the final infix expression.

---

## Dry Run

**Input:**

```text
AB+C*
```

Processing:

```text
A      → Push
B      → Push
+      → (A+B)
C      → Push
*      → ((A+B)*C)
```

Final output:

```text
((A+B)*C)
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Key Takeaway

A stack efficiently reconstructs the expression by combining the top two operands whenever an operator is encountered. Wrapping each newly formed expression in parentheses preserves the correct order of operations in the resulting infix expression.
