# Intuition

At first glance, this problem looks very similar to Kadane's Algorithm for Maximum Subarray Sum.

But there is one twist that changes everything:

> Negative numbers can turn the smallest product into the largest product in a single multiplication.

For example:

```text
[-2, 3, -4]
```

When we reach `-4`:

```text
(-2 × 3) × (-4) = 24
```

A negative product suddenly becomes the maximum product.

This means tracking only the maximum product is not enough.

We must also keep track of the minimum product because a negative number can flip its role and make it the next maximum product.

# Approach

We maintain three variables:

- `maxPro` → Maximum product ending at the current index.
- `minPro` → Minimum product ending at the current index.
- `res` → Overall maximum product found so far.

### Step 1: Initialize

The first element itself becomes:

- Current maximum product
- Current minimum product
- Final answer

### Step 2: Traverse the Array

For every element `curr`:

#### If `curr` is negative

Swap `maxPro` and `minPro`.

Why?

Because multiplying by a negative number reverses the order:

- Largest positive product can become the smallest negative product.
- Smallest negative product can become the largest positive product.

#### Update Maximum Product

Either:
- Start a new subarray from `curr`
- Extend the previous maximum product

So:

```text
maxPro = max(curr, maxPro × curr)
```

#### Update Minimum Product

Similarly:

```text
minPro = min(curr, minPro × curr)
```

This minimum product is important because it might become the next maximum product after encountering another negative number.

#### Update the Answer

The maximum product ending at the current position could be the best answer seen so far.

So:

```text
res = max(res, maxPro)
```

# Why This Works

At every index, we keep track of:

- The best product ending here (`maxPro`)
- The worst product ending here (`minPro`)

Whenever a negative number appears, these two values can exchange roles.

This ensures that no potentially optimal product is lost during traversal.

Instead of recomputing products for every subarray, we carry forward exactly the information needed to build the answer in a single pass.

# Complexity

- Time complexity:

$$O(n)$$

We traverse the array exactly once.

- Space complexity:

$$O(1)$$

Only a few variables are used regardless of the input size.
