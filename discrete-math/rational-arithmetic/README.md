Rational Arithmetic
=====================

Implement a rational arithmetic package and a client program that uses it to
compute rational approximations to `e`. The purpose of this assignment is to
learn about type definitions, packaging interfaces and implementations, separate
compilation, and arithmetic overflow.

Rational numbers are numbers that can be represented as the ratio of two
integers, i.e., any number `p / q` where `p` and `q` are integers is a rational
number. C approximates non-integer rational numbers using floats or doubles, but
these types are imprecise representations. For this assignment, you will
represent rational numbers with a C structure that comprises two integers:


    struct { unsigned int num; unsigned int den; }


represents the rational number with numerator `num` and denominator `den`. When
a C type is used repeatedly for representing another, more abstract, type, it's
conventional to specify a new type name in a *type definition* as follows:

    typedef struct { unsigned int num; unsigned int den; } Rational;

This directive allows us to use rational numbers in C programs in much the same
way that we use other types, as in the following sample code:

    Rational a, b, c;
    a = RATinit(1, 3);
    b = RATinit(1, 4);
    c = RATadd(a, b);
    RATshow(c);

In this assignment, you will learn an important general method for implementing
and using new data types and their associated functions.

**Step 0.**  Copy the file `RAT.h` that contains the following code:

    typedef struct { unsigned int num; unsigned int den; } Rational;
    Rational RATinit(unsigned int numerator, unsigned int denominator);
        void RATshow(Rational r);
    Rational RATadd(Rational r1, Rational r2);
    Rational RATmul(Rational r1, Rational r2);

This file is called an *interface*. Its purpose is to precisely spell out what
the data type is (the possible values of variables having the type and functions
that manipulate such variables). In this case, we are saying that `Rational`
numbers are pairs of integers, and that we will have functions for: initializing
them; showing (printing) them; adding two of them and putting the result in a
third; and multiplying two of them and putting the result in a third.

**Step 1.**  Make a file named `rat.c` and write straightforward implementations
of all the functions. The first line of this file should include the interface,
as follows:

    #include "RAT.h"

This gives your function implementations access to the `Rational` type
definition, and provides a check that the functions that you write have the same
types of arguments and return values as promised in the interface. This file is
called the *implementation* of the data type.

**Step 2.** Write a program named `e.c` that uses your package to compute a
rational approximation to `e`, using the Taylor series expansion
`e = 1/0! + 1/1! + 1/2! + 1/3! + 1/4! + 1/5! + . . .` Print out the value that
you get after each term is added to the approximation. Read in an integer `n`
from standard input using `scanf()`, and print the first `n` approximations. The
output for `n = 6` is:

    1/1  2/1  5/2  32/12  780/288  93888/34560

In the present context we are interested in this program as an example of a
`client`: a program that uses the data type, but is implemented separately. To
use the `Rational` data type in `e.c`, make the first line

    #include "RAT.h"

Now, you can use variables of type `Rational` in your client program, **but be**
**sure to only access the data type through the interface functions**. Compile
your program jointly using `gcc rat.c e.c -o ../bin/e`, then `e` as usual.

**Step 3.** Develop an improved implementation `ratbetter.c` that staves off
overflow longer. A trivial way to do this would be to use `long int`, but that
is less helpful than you might think, so we consider algorithmic improvements.

A straightforward implementation of the rational arithmetic interface has two
flaws that will jump out at you as you add terms to the list above to get more
accurate approximations. You can't avoid overflow, but you can stave it off by
exercising sound judgment. For example, in the fourth term in the example above,
both numerator and denominator are divisible by `4`, so we would prefer to see
the result `8/3` instead of `32/12`. You can fix this problem with Euclid's
algorithm (see Sedgewick, p. 191), using it to change your package to adhere to
the convention that functions only returns rational numbers whose numerator and
denominator are relatively prime.

The second problem, which is more subtle, is *overflow*: The products formed by
the rational arithmetic functions might overflow, which leads to erroneous
results, even if the result *can* be represented. For example, `a/b × c/d` is
equal the reduced value of `ac/bd`, but either `ac` or `bd` might overflow
before the reduction, even though the reduced answer might represent no problem
(e.g., the naive method for computing `20/33 × 77/50 = 14/15` would overflow a
variable capable of storing only two digit integers). Similarly, `a/b + c/d` is
equal to the reduced value of `(ad + bc)/bd`, but either `ad`, `bc`, or `bd`
might overflow before the reduction, even though the reduced answer might
represent no problem (e.g., `7/20 + 7/30 = 7/12` would create intermediate
values as big as `600`).

---------------------
*[From COS 126: Introduction to Computer Science, Princeton University]*