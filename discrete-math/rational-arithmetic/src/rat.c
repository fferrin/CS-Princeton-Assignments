
/**
 * Rational Arithmetic implementation.
 * 
 * Created by Fuuccker on 09/02/17.
 */
#include <stdio.h>
#include "../include/RAT.h"


/**
 * Create a Rational type
 * @param numerator: Numerator of rational number.
 * @param denominator: Denominator of rational number.
 *
 * @returns Rational variable.
 */
Rational RATinit(unsigned int numerator, unsigned int denominator) {
    Rational r;

    r.num = numerator;
    r.den = denominator;

    return r;
}

/**
 * Print formated rational number.
 * @param r: Rational number.
 */
void RATshow(Rational r) { printf("%d/%d\t", r.num, r.den); }

/**
 * Sum two rational numbers.
 * @param r1: First operand.
 * @param r2: Second operand.
 *
 * @returns sum of r1 and r2.
 */
Rational RATadd(Rational r1, Rational r2) {
    int num, den;

    num = r1.num*r2.den + r1.den*r2.num;
    den = r1.den*r2.den;

    return RATinit(num, den);
}

/**
 * Multiplicate two rational numbers.
 * @param r1: First operand.
 * @param r2: Second operand.
 *
 * @returns product of r1 and r2.
 */
Rational RATmul(Rational r1, Rational r2) {
    int num, den;

    num = r1.num*r2.num;
    den = r1.den*r2.den;

    return RATinit(num, den);
}

