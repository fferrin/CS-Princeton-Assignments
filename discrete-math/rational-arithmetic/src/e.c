
/**
 * Compilation:  gcc e.c rat.c
 *               gcc e.c ratbetter.c
 * Execution:    ./e N
 * Dependencies: rat.c ratbetter.c
 *
 * Calculates first N terms of the Taylor series expansion of e.
 * 
 * Created by Fuuccker on 10/02/17.
 */
#include <stdio.h>
#include <stdlib.h>
#include "../include/RAT.h"


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
 * @return: 0 if everything is OK. -1 otherwise.
 */
int main(int argc, char **argv) {
    /* Check for bad input */
    if (argc != 2) {
        printf("Bad input.");
        return -1;
    } else {
        /* Check for bad input */
        if (!is_number(argv[1])) {
            printf("Bad input.\n");
            return -1;
        }

        /* Initialize variables */
        int fact = 1;
        Rational r = RATinit(1, 1);

        /* Print first argv[1] terms of the Taylor series expansion of e */
        for (int i = 1; i <= atoi(argv[1]); i++) {
            fact *= i;
            RATshow(r);
            r = RATadd(r, RATinit(1, fact));
        }
        printf("\n");
    }
    return 0;
}