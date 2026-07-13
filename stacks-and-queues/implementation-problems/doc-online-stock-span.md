# Online Stock Span

## Problem Statement

Design a data structure that receives the daily stock price and returns the stock span for the current day.

The **stock span** is the maximum number of consecutive days (ending today) for which the stock price was less than or equal to today's price.

---

## Intuition

For every new price, all previous prices that are **less than or equal to** it contribute to its span and will never be useful again for future queries.

Maintain a **monotonic decreasing stack** where each entry stores:

```text
(price, span)
```

Instead of counting previous days one by one, merge the spans of all smaller or equal prices into the current span.

---

## Approach

1. Initialize the span of the current price as `1`.
2. While the stack is not empty and the top price is less than or equal to the current price:
   - Add the top element's span to the current span.
   - Remove it from the stack.
3. Push the pair `(currentPrice, currentSpan)` onto the stack.
4. Return the computed span.

---

## Dry Run

**Input:**

```text
Prices = [100, 80, 60, 70, 60, 75, 85]
```

Processing:

```text
100 → Span = 1

80  → Span = 1

60  → Span = 1

70  → Pop 60
       Span = 2

60  → Span = 1

75  → Pop 60
       Pop 70
       Span = 4

85  → Pop 75
       Pop 80
       Span = 6
```

Output:

```text
[1, 1, 1, 2, 1, 4, 6]
```

---

## Time Complexity

- **Time:** `O(1)` amortized per query (`O(n)` over `n` queries)
- **Space:** `O(n)`

---

## Key Takeaway

Instead of storing every previous price individually, store each price along with the span it already represents. When a larger price arrives, the spans of all smaller or equal prices can be merged in one step, making each price pushed and popped at most once.
