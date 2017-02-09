
#include <stdio.h>


/**
 * Main program
 *
 * @return: Exit code
 **/
int main(void) {
    float price;

    /* Read prices from file */
    while (scanf("%f", &price) != EOF) 
        printf("%7.3f\n", price);

    return 0;
}