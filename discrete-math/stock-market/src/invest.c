
#include <stdio.h>

// Define boolean type
typedef enum {false, true} bool;


/**
 * Print table's row.
 * @param period: Period
 * @param price: Current price
 * @param cash: Current money available
 * @param shares: Current shares available
 * @param value: Equivalent money
 **/
void print_line(int period, float price, float cash, float shares, float value) {
    printf("%4d %9.3f %10.2f %10.2f %10.2f\n", 
            period, price, cash, shares, value);
}

/**
 * Main program
 *
 * @return: Exit code
 **/
int main(void) {
    /* Tracking variables */
    int goes_up = 1;
    int goes_down = 1;
    float curr_price, prev_price;
    bool can_buy = true;
    bool can_sell = false;
    int strategy = 3;   // For Dilbert's rule set at 3
    /* Table variables */
    int period = 1;
    float cash = 10000.0;
    float shares = 0.00;
    float value = cash;

    /* Print header and first row */
    if (scanf("%f", &curr_price) != EOF) {
        prev_price = curr_price;

        printf("%s %7s %8s %12s %8s\n", 
               "period", "price", "cash", "shares", "value");
        printf("-----------------------------------------------\n");
        print_line(period, curr_price, cash, shares, value);
        period++;
    }

    /* Read prices from file */
    while (scanf("%f", &curr_price) != EOF) {
        if (prev_price < curr_price) {
            /* Buy */
            if (strategy <= goes_down && can_buy) {
                shares = cash / curr_price;
                cash = 0.0;
                can_buy = false;
                can_sell = true;
            }

            /* Reset and update trackers */
            goes_down = 1;
            goes_up++;
        } else if (curr_price < prev_price) {
            /* Sell */
            if (strategy <= goes_up && can_sell) {
                cash = shares * curr_price;
                shares = 0.0;
                can_buy = true;
                can_sell = false;
            }

            /* Reset and update trackers */
            goes_up = 1;
            goes_down++;
        } else {
            /* Reset trackers */
            goes_up = 1;
            goes_down = 1;
        }

        /* Recalculate value */
        if (shares == 0.0) 
            value = cash;
        else
            value = shares * curr_price;

        /* Print current row */
        print_line(period, curr_price, cash, shares, value);

        /* Update trackers */
        prev_price = curr_price;
        period++;
    }

    return 0;
}