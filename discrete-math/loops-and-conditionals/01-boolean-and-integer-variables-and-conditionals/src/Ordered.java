
/**
 * Compilation:  javac Ordered.java
 * Execution:    java Ordered 1 2 3
 * Dependencies:
 *
 * Check if three integers are either in strictly ascending order or in strictly
 * descending order. Returns true in that case and false otherwise.
 *
 * Created by Fuuccker on 06/02/17.
 */
public class Ordered {

    /**
     * Check if three integers are either in strictly ascending or descending
     * order.
     *
     * @param a first integer
     * @param b second integer
     * @param c third integer
     * @return true if numbers are in strictly ascending or descending order.
     * False otherwise.
     */
    public boolean isOrdered(int a, int b, int c) {
        if ((a < b && b < c) || (c < b && b < a)) return true;
        else                                      return false;
    }

    /**
     * Check if the input is valid.
     *
     * @param input of the program.
     * @return true if the input is valid. False otherwise.
     */
    public boolean validInput(String[] input) {
        if (input.length != 3) return false;

        try {
            Integer.parseInt(input[0]);
            Integer.parseInt(input[1]);
            Integer.parseInt(input[2]);
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }

    /**
     * Main program.
     *
     * @param args input values from command line.
     */
    public static void main(String[] args) {
        Ordered o = new Ordered();

        if (o.validInput(args)) {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = Integer.parseInt(args[2]);

            System.out.println(o.isOrdered(a, b, c));
        } else
            System.out.println("Invalid input.");
    }
}
