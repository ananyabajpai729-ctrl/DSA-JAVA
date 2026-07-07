# Postfix to Prefix Conversion

## Problem Statement

Given a postfix expression containing operands and operators, convert it into its equivalent prefix expression.

---

## Intuition

In a postfix expression, every operator appears after its operands, while in a prefix expression, the operator appears before its operands.

By traversing the postfix expression from **left to right**, operands are pushed onto a stack. Whenever an operator is encountered, the top two operands are combined into a prefix expression and pushed back onto the stack.

---

## Approach

1. Traverse the postfix expression from left to right.
2. If the current character is an operand, push it onto the stack.
3. If it is an operator:
   - Pop the top two expressions from the stack.
   - Let the first popped expression be the **right operand** and the second popped expression be the **left operand**.
   - Form a new prefix expression:
     ```text
     operator leftOperand rightOperand
     ```
   - Push the new expression back onto the stack.
4. After processing the entire expression, the stack contains the final prefix expression.

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
+      → +AB
C      → Push
*      → *+ABC
```

Final output:

```text
*+ABC
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Key Takeaway

A stack helps reconstruct the expression by combining the top two operands whenever an operator is encountered. Since postfix naturally provides operands before their operator, a single left-to-right traversal is sufficient to build the equivalent prefix expression.
