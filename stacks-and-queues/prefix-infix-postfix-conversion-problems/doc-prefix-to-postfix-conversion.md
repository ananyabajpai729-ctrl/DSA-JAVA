# Prefix to Postfix Conversion

## Problem Statement

Given a prefix expression containing operands and operators, convert it into its equivalent postfix expression.

---

## Intuition

In a prefix expression, every operator appears before its operands, whereas in a postfix expression, every operator appears after its operands.

By traversing the prefix expression from **right to left**, operands are encountered before their operator. A stack stores intermediate postfix expressions, which are combined whenever an operator is found.

---

## Approach

1. Traverse the prefix expression from right to left.
2. If the current character is an operand, push it onto the stack.
3. If it is an operator:
   - Pop the top two postfix expressions.
   - Form a new postfix expression:
     ```text
     operand1 operand2 operator
     ```
   - Push the new expression back onto the stack.
4. After processing the entire expression, the stack contains the final postfix expression.

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
-          → AK-

C          → Push
B          → Push
/          → BC/

A          → Push
-          → ABC/-

*          → ABC/-AK-*
```

Final output:

```text
ABC/-AK-*
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Key Takeaway

Processing the prefix expression from **right to left** ensures operands are available before their operator. By repeatedly combining the top two postfix expressions with the current operator, the equivalent postfix expression is constructed efficiently using a stack.
