
/**
 * Improved Rational Arithmetic implementation.
 * 
 * Created by Fuuccker on 10/02/17.
 */
#include <stdio.h>
#include "../include/RAT.h"


/**
 * Calculate greatest common divisor between two numbers.
 * @param a: First number.
 * @param b: Second number.
 *
 * @returns: Greatest common divisor between a and b.
 */
int gcd(int a, int b) {
    if (a == 0) return b;
    return gcd(b % a, a);
}

/**
 * Create a Rational type
 * @param numerator: Numerator of rational number.
 * @param denominator: Denominator of rational number.
 *
 * @returns Rational variable.
 */
Rational RATinit(unsigned int numerator, unsigned int denominator) {
    Rational r;
    int GCD;
    
    GCD = gcd(numerator, denominator);
    /* Simplificates fraction */
    r.num = numerator / GCD;
    r.den = denominator / GCD;

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
    /* Given r1 = a/b and r2 = c/d, create r1_tmp = a/d and r2_tmp = c/b. Any
       common factor between a and d will be simplified. Same for c and d.
       In this way, all possible fractions are simplified and it avoid overflow */
    Rational r1_tmp = RATinit(r1.num, r2.den);
    Rational r2_tmp = RATinit(r2.num, r1.den);

    num = r1_tmp.num*r2_tmp.num;
    den = r1_tmp.den*r2_tmp.den;

    return RATinit(num, den);
}