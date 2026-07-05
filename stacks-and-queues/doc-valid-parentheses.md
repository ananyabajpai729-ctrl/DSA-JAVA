# Valid Parentheses

## Problem Statement

Given a string containing only the characters `'('`, `')'`, `'{'`, `'}'`, `'['`, and `']'`, determine whether the input string is valid.

A string is valid if:
- Every opening bracket has a corresponding closing bracket of the same type.
- Brackets are closed in the correct order.
- Every closing bracket has a matching opening bracket.

---

## Intuition

A stack is ideal for matching brackets because it follows the **LIFO (Last In, First Out)** principle.

- When an opening bracket is encountered, push it onto the stack.
- When a closing bracket is encountered, it must match the most recent unmatched opening bracket (the top of the stack).
- If it doesn't match or the stack is empty, the string is invalid.

---

## Approach

1. Create an empty stack.
2. Traverse the string character by character.
3. If the current character is an opening bracket, push it onto the stack.
4. Otherwise:
   - If the stack is empty, return `false`.
   - Pop the top element and check if it matches the current closing bracket.
5. After processing the entire string, the stack should be empty for the string to be valid.

---

## Dry Run

**Input:**

```text
s = "{[()]}"
```

Stack operations:

```text
'{' → Push → {
'[' → Push → {[
'(' → Push → {[(
')' → Pop '(' ✓
']' → Pop '[' ✓
'}' → Pop '{' ✓
```

Stack is empty.

Output:

```text
true
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(n)`

---

## Key Takeaway

The stack always stores unmatched opening brackets. Each closing bracket must match the bracket at the top of the stack, ensuring both correct pairing and proper nesting.
