Boolean and integer variables and Conditionals
=====================

Write a program `Ordered.java` that reads in three integer command-line
arguments, `x`, `y`, and `z`. Define a boolean variable `isOrdered` whose value
is `true` if the three values are either in strictly ascending order
(`x < y < z`) or in strictly descending order (`x > y > z`), and `false`
otherwise. Print out the variable `isOrdered` using
`System.out.println(isOrdered)`.

```
% java Ordered 10 17 49
true
```

```
% java Ordered 49 17 10
true
```

```
% java Ordered 10 49 17
false
```

*[From COS 126, Princeton University]*
