
/**
 * Rational Arithmetic interface.
 * 
 * Created by Fuuccker on 09/02/17.
 */

/* struct for rational numbers */
typedef struct { unsigned int num; unsigned int den; } Rational;


/**
 * Create a Rational type
 * @param numerator: Numerator of rational number.
 * @param denominator: Denominator of rational number.
 *
 * @returns Rational variable.
 */
Rational RATinit(unsigned int numerator, unsigned int denominator);

/**
 * Print formated rational number.
 * @param r: Rational number.
 */
    void RATshow(Rational r);

/**
 * Sum two rational numbers.
 * @param r1: First operand.
 * @param r2: Second operand.
 *
 * @returns sum of r1 and r2.
 */
Rational RATadd(Rational r1, Rational r2);

/**
 * Multiplicate two rational numbers.
 * @param r1: First operand.
 * @param r2: Second operand.
 *
 * @returns product of r1 and r2.
 */
Rational RATmul(Rational r1, Rational r2);