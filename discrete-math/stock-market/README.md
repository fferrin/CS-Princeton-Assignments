Stock Market
=====================

Write a program to predict the performance of various stocks.

**Part 0: Read in the data.** The following program reads in a sequence of stock
prices and prints them out.

```
#include <stdio.h>
int main(void) {
    float price;
    while (scanf("%f", &price) != EOF)
        printf("%7.3f\n", price);
    return 0;
}
```

Type the program exactly as is; save as `input.c`; and compile with `gcc input.c`.
To read in the data from a file named `stock15.txt`, type `a.out < stock15.txt`.
You can also test your program on `stock1000.txt`, a larger file that contains
real data.

**Part 1: Plot.** Write a program `plot.c` to display the stock values
graphically instead of just printing the values. Round the stock price down to
the nearest integer, and print that number of `*`'s. The correct output is:

```
**************************
*************************
*************************
*************************
*************************
***************************
****************************
**************************
*************************
*************************
*************************
*************************
**************************
*************************
*************************
```

**Part 2: Detect a pattern.** Write a program to identify specific trends in the
data. Dilbert the Day Trader believes that if the stock goes up 3 (or more)
consecutive time periods and then down in the next period, then it is a good
time to sell the stock. Analogously, Dilbert believes that if the stock goes
down 3 consecutive time periods and then up in the next period, then it is a
good time to buy the stock. Write a program `pattern.c` that prints out the time
period and stock price, along with the word `buy` or `sell` according to
Dilbert's rule. The output should look like this:

```
   1    26.375
   2    25.500
   3    25.125
   4    25.000
   5    25.250    buy
   6    27.125
   7    28.250
   8    26.000    sell
   9    25.500
  10    25.000
  11    25.125    buy
  12    25.250
  13    26.375
  14    25.500    sell
  15    25.500
```

**Part 3: Invest.** Write a program `invest.c` to determine how much money you
would have won or lost using Dilbert's rule. You start with $10,000.00 cash.
Assume that you will convert all of your cash to stock when Dilbert's rule
signals you to buy, and that you will convert all of your stock to cash when
Dilbert's rule signals you to sell. For each time period, print out the price,
cash, shares owned, and portfolio value. The value of your portfolio is cash
plus the number of shares multiplied by the price per share. (For simplicity,
assume that you can buy fractional amounts of stock, and there are no
transaction fees.) For `stock15.txt`, the correct output is:

```
period   price     cash       shares    value
-----------------------------------------------
   1    26.375   10000.00       0.00   10000.00
   2    25.500   10000.00       0.00   10000.00
   3    25.125   10000.00       0.00   10000.00
   4    25.000   10000.00       0.00   10000.00
   5    25.250       0.00     396.04   10000.00
   6    27.125       0.00     396.04   10742.57
   7    28.250       0.00     396.04   11188.12
   8    26.000   10297.03       0.00   10297.03
   9    25.500   10297.03       0.00   10297.03
  10    25.000   10297.03       0.00   10297.03
  11    25.125       0.00     409.83   10297.03
  12    25.250       0.00     409.83   10348.26
  13    26.375       0.00     409.83   10809.32
  14    25.500   10450.72       0.00   10450.72
  15    25.500   10450.72       0.00   10450.72
```

---------------------
*[From COS 126, Princeton University]*