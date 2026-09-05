# Alien Dictionary

## Problem Statement

We are given a dictionary of words sorted according to some unknown alien alphabet.

We know there are `K` different characters.

Our job is to figure out one possible ordering of those characters.

For example, if:

`wrd1 = "abc"`

and:

`wrd2 = "abd"`

The first different characters are:

`c` and `d`

Since `"abc"` comes before `"abd"` in the dictionary, we know:

`c → d`

So `c` comes before `d` in the alien alphabet.

## Pattern

**Topological Sort + BFS + Indegree**

The slightly tricky part is that we first have to **build the graph** from the words.

## Intuition

The words are already sorted.

So I don't need to compare every word with every other word.

I only need to compare **adjacent words**.

For every pair of neighbouring words, I look for the first position where they are different.

That first difference tells me something about the alien alphabet.

For example:

`"baa"`

`"abcd"`

The first characters are different:

`b` and `a`

Since `"baa"` comes before `"abcd"`, I know:

`b → a`

After collecting all these relationships, the problem becomes a normal topological sort.

So the overall thought process is:

`Words → find character relationships → build graph → topological sort`

## Approach

### 1. Compare adjacent words

I compare:

`dict[i]`

with:

`dict[i + 1]`

For each pair, I go character by character.

I stop at the **first different character**.

For example:

`"wrt"`

`"wrf"`

The first two characters are the same:

`w = w`

`r = r`

Then:

`t != f`

So I get:

`t → f`

I don't care about the characters after that.

The first difference is enough to tell me the ordering.

### 2. Build the graph

Characters are the nodes.

If I find:

`a → b`

I add an edge from `a` to `b`.

The conversion:

`char - 'a'`

turns a character into an index.

For example:

`'a' - 'a' = 0`

`'b' - 'a' = 1`

`'c' - 'a' = 2`

and so on.

This lets me use arrays and adjacency lists easily.

### 3. Calculate indegrees

Once the graph is built, I calculate the indegree of every character.

Then I put all characters with:

`indegree == 0`

into the queue.

These are the characters that don't have anything that needs to come before them.

### 4. Run Kahn's Algorithm

Now it's just the same BFS topological sort I've already used.

Take a character from the queue and put it into `topo`.

Then go through its neighbours and reduce their indegrees.

If a neighbour reaches `0`, add it to the queue.

### 5. Build the answer

The `topo` array contains character indices.

So I convert them back into characters using:

`(char)(topo[i] + 'a')`

Then I build the final string using `StringBuilder`.

## Dry Run

Suppose the dictionary is:

    w
    r
    t
    f

with relationships:

    w → r
    r → t
    t → f

The indegrees are:

    w → 0
    r → 1
    t → 1
    f → 1

So initially:

`Queue = [w]`

Process `w`.

`r` now has indegree `0`.

    Queue = [r]

Process `r`.

`t` now has indegree `0`.

    Queue = [t]

Process `t`.

`f` now has indegree `0`.

    Queue = [f]

Process `f`.

So:

`topo = [w, r, t, f]`

and the answer is:

`"wrtf"`

## Why Only the First Different Character?

This is probably the most important part of the problem.

Suppose:

`word1 = "abcd"`

`word2 = "abef"`

We compare:

`a = a`

`b = b`

`c != e`

So we learn:

`c → e`

We don't continue checking `d` and `f`.

Why?

Because the first different character is what decides which word comes first.

Everything after that doesn't tell us anything useful about the ordering between these two words.

## Why Compare Only Adjacent Words?

Because the dictionary is already sorted.

If I compare every possible pair, I'm doing unnecessary work.

The ordering information I need can be extracted from neighbouring words.

So:

`word[0] vs word[1]`

`word[1] vs word[2]`

`word[2] vs word[3]`

and so on.

## What If There Is a Cycle?

Suppose the relationships become:

`a → b`

`b → c`

`c → a`

Now there is no character with indegree `0`.

The BFS cannot process all `K` characters.

That's why the code checks:

`if(index != K) return "";`

If fewer than `K` characters were processed, there is a cycle, so no valid ordering exists.

## One Thing to Be Careful About

There is one edge case worth remembering in this problem.

Suppose we have:

`["abc", "ab"]`

The first word starts with the second word, but is longer.

This cannot be a valid dictionary ordering.

For the standard Alien Dictionary problem, this case should be handled explicitly.

Your current code doesn't check for it.

Apart from this invalid-prefix case, the main approach you're using is correct.

## Time Complexity

Let the total number of characters across all words be `C`.

Comparing adjacent words takes roughly **O(C)** overall.

Building the graph takes **O(C)**.

The topological sort takes **O(K + E)**, where `E` is the number of character relationships.

So overall:

**O(C + K + E)**

Since there can be at most `K²` possible character relationships, the graph part is manageable.

## Space Complexity

**O(K + E)**

The adjacency list stores the character relationships.

The `indegree` array takes `O(K)`.

The queue and topological order also take `O(K)`.

So overall:

**O(K + E)**

## Key Takeaway

This problem looks like a string problem at first, but the real trick is:

> Turn the information hidden in the sorted words into a graph.

The process is:

`Compare adjacent words`

↓

`Find first different character`

↓

`Create edge between those characters`

↓

`Calculate indegrees`

↓

`Kahn's Algorithm`

↓

`Get the alien character order`

So whenever a problem gives me **ordering/dependency information** and asks me to find a valid order, I should start thinking about **topological sort**.
