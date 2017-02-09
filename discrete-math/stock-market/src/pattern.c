
#include <stdio.h>

// Define boolean type
typedef enum {false, true} bool;


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

    /* Print first row */
    if (scanf("%f", &curr_price) != EOF) {
        prev_price = curr_price;
        printf("%.3f\n", curr_price);
    }

    /* Read prices from file */
    while (scanf("%f", &curr_price) != EOF) {
        if (prev_price < curr_price) {
            /* Buy */
            if (3 <= goes_down && can_buy) printf("%.3f\tbuy\n", curr_price);
            else                           printf("%.3f\n", curr_price);

            /* Reset and update trackers */
            goes_down = 1;
            goes_up++;
        } else if (curr_price < prev_price && can_sell) {
            /* Sell */
            if (3 <= goes_up && can_sell) printf("%.3f\tsell\n", curr_price);
            else                          printf("%.3f\n", curr_price);

            /* Reset and update trackers */
            goes_up = 1;
            goes_down++;
        } else
            printf("%.3f\n", curr_price);

        /* Update tracker */
        prev_price = curr_price;
    }
    
    return 0;
}