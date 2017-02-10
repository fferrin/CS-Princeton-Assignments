Linear Congruential Random Number Generator
=====================

Implement C programs that can find the cycle length of a linear congruential
random number generator, using Floyd's algorithm.

The terms in the problem statement are likely to be unfamiliar to you, but they
are not difficult to understand and are described in detail below. In the end,
this assignment involves only a few lines of C code. In order to complete it,
you need to be able to write loops (`for` and `while`) and branch statements
(`if`-`else`) in C.

For the purposes of this assignment, a *linear congruential random number*
*generator* is defined in terms of four integers: the multiplicative constant
`a`, the additive constant `b`, the starting point or seed `c`, and the modulus
`M`. The purpose of the generator is to produce a sequence of integers between
`0` and `M-1` by starting with `x0 = c` and iterating:

![](https://latex.codecogs.com/gif.latex?x_%7Bn&plus;1%7D%20%3D%20%28ax_n%20&plus;%20b%29%20%5C%25%20M)

In C, the `%` operator means modulus or remainder: this keeps the iterates
between `0` and `M-1`. For example, the following table shows the sequences that
result for various choices of `a`, `b`, `c`, and `M`.

|a   |b   |c   |M   |x0  |x1  |x2  |x3  |x4  |x5  |x6  |x7  |x8  |x9  |x10 |x11 |x12 |
|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|
|1   |3   |0   |10  |0   |3   |6   |9   |2   |5   |8   |1   |4   |7   |0   |3   |6   |
|2   |1   |0   |10  |0   |1   |3   |7   |5   |1   |3   |7   |5   |1   |3   |7   |5   |
|22  |1   |0   |72  |0   |1   |23  |3   |67  |35  |51  |43  |11  |27  |19  |59  |3   |
|11  |37  |1   |100 |1   |48  |65  |52  |9   |36  |33  |0   |37  |44  |21  |68  |85  |
|8   |20  |10  |100 |10  |0   |20  |80  |60  |0   |20  |80  |60  |0   |20  |80  |60  |

As with the linear feedback shift register that we discussed in lecture, these
sequences are not random, but (for proper choices of the parameters) they
exhibit many properties of random sequences. For small values of the parameters,
the non-randomness is particularly evident: whenever we generate a value that we
have seen before, we enter into a cycle, where we continually generate the same
subsequence over and over again. In the first two examples above, the cycles are
`0-3-6-9-2-5-8-1-4-7-0` and `1-3-7-5-1`, of *lengths* `10` and `4`, respectively.
Since there are only `M` different possibilities, we always must enter such a
cycle, but we want to avoid short cycles.

Your first task is to write a program to print out the sequence for small `M`.
Your second task is to write a program to compute the cycle length for any `M`.

**Part 1a: Print iterates.** Write a C program that reads in four integers (`a`,
`b`, `c`, and `M` in this order) and prints out *the first* `M` *values* 
produced by the linear congruential random number generator for these 
parameters. Use a `for` loop and the following update formula:

![](https://latex.codecogs.com/gif.latex?x%20%3D%20%28ax%20&plus;%20b%29%5C%25M)

**Part 1b: Print iterates nicely.** Print the iterates in a nice table with *16*
*values per line* and *4 characters per iterate*. Use an `if` statement with the
`%` operator to print a newline character after every 16 iterations. Use an
appropriate **printf()** formatting instruction to get four characters per
iterate. Assume that `M` is `1,000` or less so that this is a sufficient amount
of space.

Name your program `trace.c`. Verify that it behaves as follows:

    ```
    % trace
    11 37 1 100

    1   48  65  52   9  36  33   0  37  44  21  68  85  72  29  56
    53  20  57  64  41  88   5  92  49  76  73  40  77  84  61   8
    25  12  69  96  93  60  97   4  81  28  45  32  89  16  13  80
    17  24   1  48  65  52   9  36  33   0  37  44  21  68  85  72
    29  56  53  20  57  64  41  88   5  92  49  76  73  40  77  84
    61   8  25  12  69  96  93  60  97   4  81  28  45  32  89  16
    13  80  17  24
    ```

*Perspective.* In practice, we often want random integers in a small range, say
between 0 and 9. Typically we do so by using a large `M` in a linear
congruential random number generator, and then use arithmetic to bring them down
into a small range. For example, the leading digits of the first 50 terms in the
sequence above are:

```
0 4 6 5 0 3 3 0 3 4 2 6 8 7 2 5 5 2 5 6 4 8 0 9 4 7 7 4 7 8 6 0 2 1 6 9 9 6 9 0 8 2 4 3 8 1 1 8 1 2
```

which is a random-looking sequence of integers between 0 and 9 (although the
pattern repeats itself every 50 iterations). But if we use this method for the
last example above, we get stuck in the cycle:

```
1 0 2 8 6 0 2 8 6 0 2 8 6 0 2 8 6 0 2 8 6 0 2 8 6 0 2 8 6 0 2 8 6 0 2 8 6 0 2 8 6 0 2 8 6 0 2 8 6 0
```

which is not a very random-looking sequence. This phenomenon can happen even for
huge `M`, so we are interested in knowing that our choice of parameters does not
lead to a small cycle.

**Floyd's algorithm.** The second part of this assignment is to implement a
method known as *Floyd's algorithm* for finding the cycle length or period.
Floyd's algorithm consists of two phases: (i) find a point on the cycle, and
(ii) compute the cycle length.

* **Phase I.** To find a point on the cycle, we use the following clever idea:
run two versions of the generator concurrently, one iterating twice as fast as
the other, until both versions have the same value. At some point, both of them
are on the cycle and we have a race on the cycle, with the gap between the
faster one and the slower one shrinking by one on each iteration. Eventually,
the faster one catches up to the slower one, and the two generators are at the
same point on the cycle.


|iteration|  0 |  1 | 23 |  3 | 67 | 35 | 51 | 43 | 11 | 27 | 19 | 59 |              |
|:-------:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:------------:|
|    0    | SF |    |    |    |    |    |    |    |    |    |    |    |              |
|    1    |    |  S |  F |    |    |    |    |    |    |    |    |    |              |
|    2    |    |    |  S |    |  F |    |    |    |    |    |    |    | **distance** |
|    3    |    |    |    |  S |    |    |  F |    |    |    |    |    |     **6**    |
|    4    |    |    |    |    |  S |    |    |    |  F |    |    |    |     **5**    |
|    5    |    |    |    |    |    |  S |    |    |    |    |  F |    |     **4**    |
|    6    |    |    |    |  F |    |    |  S |    |    |    |    |    |     **3**    |
|    7    |    |    |    |    |    |  F |    |  S |    |    |    |    |     **2**    |
|    8    |    |    |    |    |    |    |    |  F |  S |    |    |    |     **1**    |
|    9    |    |    |    |    |    |    |    |    |    | FS |    |    |     **0**    |

Above is an example of the process with `a = 22`, `b = 1`, `c = 0`, and `M = 72`.
In this example, the cycle is `3-67-35-51-43-11-27-19-59-3`, and its length is
`9`. Somewhat coincidentally, this happens to be equal to the number of steps
until the fast and slow generators first meet, but this will not be true in
general. The fast generator happens to be at `51` when the slow one first hits
the cycle at `3`. The fast one is six steps behind the slow one, and catches up,
one step at a time.

* **Phase II.** Once we know a value on the cycle, one more trip around the
cycle (back to that same value) will give us the cycle length. Continuing the
example above, we discovered from Phase I that `27` is in the cycle. After
another `9` iterations we are back at `27`, so we conclude the cycle length is
`9`.

|  0 |  1 |  2 |  3 |  4 |  5 |  6 |  7 |  8 |  9 |
|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|:--:|
| 27 | 19 | 59 |  3 | 67 | 35 | 51 | 43 | 11 | 27 |

**Part 2: Compute the cycle length.** Write a C program that reads in four
integers (`a`, `b`, `c`, and `M`) and prints out the cycle length of the linear
congruential random number generator for these parameters. (Warning: we no
longer assume that `M <= 1000`, as shown in some of the examples below.)

The C `while` loop makes the first phase of Floyd's algorithm (finding a point of
the cycle) easier to implement than to understand. You will be able to
accomplish this by changing your `for` loop in `trace.c` to a `while` loop,
defining a new variable for the fast generator, and making a few copies of the
code that you have. The second phase requires another variable to count the
number of steps, and another loop to go around the cycle.

Name your program `cycle.c`. Verify that it behaves as follows:

  ```
  % cycle
  22 1 0 72
  Cycle length is 9.

  % cycle
  123 456 789 1000000
  Cycle length is 50000.

  % cycle
  124 456 789 1000000
  Cycle length is 250.

  % cycle
  78 60 89 129024
  Cycle length is 7.
  ```

---------------------
*[From COS 126: Introduction to Computer Science, Princeton University]*