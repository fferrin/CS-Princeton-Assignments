
#include <stdio.h>


/**
 * Main program
 *
 * @return: Exit code
 **/
int main(void) {
    float price;

    /* Read prices from file */
    while (scanf("%f", &price) != EOF) {
        /* Print stock market prices */
        for (int i = 0; i < (int) price; i++) 
            printf("%c", '*');
        printf("\n");
    }

    return 0;
}