# Lemonade Change

## Problem Statement

At a lemonade stand, each lemonade costs **$5**.

Customers pay with either **$5, $10, or $20** bills, in the given order.

Initially, you have no money.

Return `true` if you can provide the correct change to every customer. Otherwise, return `false`.

---

## Intuition

Since customers arrive one by one, we must make the best decision **at that moment** without knowing future payments.

The greedy idea is simple:

- A `$5` bill never requires change, so just keep it.
- A `$10` bill requires one `$5` as change.
- A `$20` bill requires `$15` as change.

For a `$20` bill, there are two possible ways to give change:

- `$10 + $5`
- `$5 + $5 + $5`

Whenever possible, we should **prefer giving one `$10` and one `$5`**.

Why?

Because `$5` bills are the most valuable—they are the only way to provide change for future `$10` bills. Preserving them gives us more flexibility later.

---

## Approach

- Maintain two counters:
  - `drawer5` → number of `$5` bills.
  - `drawer10` → number of `$10` bills.
- Traverse each customer's bill:
  - If it's `$5`, add it to the drawer.
  - If it's `$10`:
    - A `$5` bill is required as change.
    - If none exists, return `false`.
  - If it's `$20`:
    - Prefer giving one `$10` and one `$5`.
    - Otherwise, give three `$5` bills.
    - If neither is possible, return `false`.
- If every customer is served successfully, return `true`.

---

## Dry Run

**Input:**

```text
bills = [5,5,5,10,20]
```

Processing:

```text
Customer pays 5

Drawer:

5s = 1

10s = 0

----------------

Customer pays 5

5s = 2

----------------

Customer pays 5

5s = 3

----------------

Customer pays 10

Give one 5

5s = 2

10s = 1

----------------

Customer pays 20

Give one 10 and one 5

5s = 1

10s = 0
```

All customers are served successfully.

Output:

```text
true
```

---

### Another Example

```text
bills = [5,5,10,10,20]
```

When the last customer pays `$20`:

```text
Need $15 change

Only two $10 bills available

No $5 bill remains

Cannot provide change
```

Output:

```text
false
```

---

## Time Complexity

- **Time:** `O(n)`
- **Space:** `O(1)`

---

## Key Takeaway

This is a classic **Greedy** problem where each decision is made immediately.

The important greedy choice is:

> **Whenever handling a `$20` bill, give `$10 + $5` before giving three `$5` bills.**

This works because:

- `$5` bills are essential for making change for future `$10` payments.
- `$10` bills are only useful when paired with a `$5` to make `$15` change.

Preserving as many `$5` bills as possible increases the chances of successfully serving future customers.

A common pattern in greedy problems is to **preserve the most flexible resource** for future decisions. Here, that resource is the `$5` bill.
