# Word Ladder

## Problem Statement

We are given:

- a `beginWord`
- an `endWord`
- a list of allowed words

We need to transform `beginWord` into `endWord`.

In one step, we can change **only one character** of the current word.

Every intermediate word must exist in the given `wordList`.

We need to return the minimum number of words in the transformation sequence.

## Pattern

**BFS + Shortest Path**

## Intuition

The first thing to notice is that this is basically a shortest path problem.

Each word can be treated like a node.

Two words are connected if we can change one character of one word to get the other.

For example:

    hot → dot

They differ by only one character, so they are connected.

So I can think of the problem like:

    beginWord
        ↓
      words
        ↓
      words
        ↓
    endWord

Since I need the **shortest** transformation, BFS is a good fit.

The slightly tricky part is that the neighbours of a word aren't directly given.

I have to generate them by changing each character from `'a'` to `'z'`.

## Approach

First, I put all the words from `wordList` into a `HashSet`.

This makes checking whether a generated word exists very quick.

I start BFS with:

`(beginWord, 1)`

The `1` means that the starting word itself counts as the first word in the sequence.

For every word taken from the queue, I try changing each character.

For example, if the current word is:

`hot`

I can try changing the first character:

`aot, bot, cot, ... , zot`

Then I do the same for the second and third characters.

Whenever the generated word exists in the set, I add it to the queue with:

`steps + 1`

I also remove it from the set immediately.

This is important because I don't want the same word to be added to the queue multiple times.

## Dry Run

Suppose:

`beginWord = "hit"`

`endWord = "cog"`

and the words are:

`hot, dot, dog, lot, log, cog`

Start with:

    hit → 1

From `hit`, we can make:

    hot

So:

    hit → hot

Then:

    hot → dot
    hot → lot

BFS keeps exploring level by level.

One possible path is:

    hit
     ↓
    hot
     ↓
    dot
     ↓
    dog
     ↓
    cog

The number of words is:

`5`

So the answer is `5`.

## Why BFS?

This is the important part.

Every transformation has the same cost:

`1 step`

So BFS explores all words that are `1` step away first, then all words `2` steps away, then `3`, and so on.

Therefore, the first time we reach `endWord`, we have found the shortest transformation.

## Why Remove Words From the Set?

Suppose I find `hot`.

I immediately remove it from the set before adding it to the queue.

Otherwise, another word could generate `hot` again later and put another copy of it into the queue.

Removing it means:

> Once I have discovered this word, I don't need to discover it again.

It also prevents unnecessary BFS work.

## Time Complexity

Let:

- `N` = number of words
- `L` = length of each word

For every word, I try `26` possible characters at every one of its `L` positions.

So the main work is roughly:

**O(N × L × 26)**

Since `26` is constant, this is usually written as:

**O(N × L)**

There is also the cost of creating the new strings, but the main idea is still that every word is processed once and for every position we try all 26 letters.

## Space Complexity

**O(N)**

The `HashSet` stores the words and the BFS queue can also contain many words.

## Key Takeaway

The important thing to remember here is:

> When a problem asks for the minimum number of transformations and every transformation costs one step, think BFS.

And when the neighbours aren't directly given:

> Generate the possible neighbours and check which ones are actually valid.

For Word Ladder:

`word → change one character → generate new word → check HashSet → BFS`
