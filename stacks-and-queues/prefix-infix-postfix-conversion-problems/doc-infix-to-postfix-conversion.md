# Infix to Postfix Conversion

## Problem Statement

Given an infix expression containing operands, operators (`+`, `-`, `*`, `/`, `^`), and parentheses, convert it into its equivalent postfix (Reverse Polish Notation) expression.

---

## Intuition

A postfix expression places operators after their operands, eliminating the need for parentheses during evaluation.

A stack is used to temporarily store operators while processing the expression. Operators are popped based on their precedence and associativity before the current operator is pushed.

---

## Approach

1. Traverse the expression from left to right.
2. If the current character is an operand, append it directly to the result.
3. If it is `'('`, push it onto the stack.
4. If it is `')'`, pop and append operators until `'('` is encountered.
5. If it is an operator:
   - Pop operators with higher precedence.
   - For left-associative operators (`+`, `-`, `*`, `/`), also pop operators of equal precedence.
   - For the right-associative operator (`^`), do **not** pop operators of equal precedence.
   - Push the current operator onto the stack.
6. After processing the expression, append all remaining operators from the stack.

---

## Dry Run

**Input:**

```text
A+(B*C)-D
```

Processing:

```text
A      → Output: A
+      → Stack: +
(      → Stack: +(
B      → Output: AB
*      → Stack: +(* 
C      → Output: ABC
)      → Output: ABC*
       → Stack: +
-      → Output: ABC*+
       → Stack: -
D      → Output: ABC*+D
End    → Output: ABC*+D-
```

Final postfix expression:

```text
ABC*+D-
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Key Takeaway

A stack efficiently manages operators while respecting precedence and associativity. The special handling of the exponent operator (`^`) ensures its **right associativity**, while all other operators remain **left associative**, producing the correct postfix expression.
