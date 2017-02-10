
/**
 * Created by Fuuccker on 09/02/17.
 */
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>


/* Define boolean type */
typedef enum {false, true} bool;


/**
 * Check if given char is a number.
 * @param number[]: char input
 * 
 * @returns true is char is a number. False otherwise
 */
bool is_number(char number[]) {
    int i = 0;

    //checking for negative numbers
    if (number[0] == '-') 
        i = 1;
    for (; number[i] != 0; i++) {
        //if (number[i] > '9' || number[i] < '0')
        if (!isdigit(number[i]))
            return false;
    }
    return true;
}

/**
 * Main program
 *
 * @return: 0 if everything was OK. -1 otherwise.
 **/
int main(int argc, char *argv[]) {
    /* Check for bad input */
    if (argc != 5) {
        printf("Bad input.\n");
        return -1;
    } else {
        /* Check for bad input */
        for (int i = 1; i < argc; i++)
            if (!is_number(argv[i])) {
                printf("Bad input.\n");
                return -1;
            }

        /* Parameters of the `linear congruential random number generator` */
        int a, b, c, M;
        /* Parameter for iterate twice as fast as the original */
        int c2;
        int length = 0;

        a = atoi(argv[1]);
        b = atoi(argv[2]);
        c = atoi(argv[3]);
        M = atoi(argv[4]);
        c2 = c;

        /* Find match value */
        do {
            c = (a * c + b) % M;
            c2 = (a * ((a * c2 + b) % M) + b) % M;
        } while (c != c2);

        /* Measure cycle's length */
        do {
            c = (a * c + b) % M;
            length++;
        } while (c != c2);

        printf("Cycle length is %d.\n", length);
        return 0;
    }
}