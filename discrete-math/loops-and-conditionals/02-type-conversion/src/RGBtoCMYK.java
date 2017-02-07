
/**
 * Compilation:  javac RGBtoCMYK.java
 * Execution:    java RGBtoCMYK 1 2 3
 * Dependencies:
 *
 * Convert RGB integers to equivalent CMYK parameters.
 * The mathematical formulas for converting from RGB to an equivalent CMYK color
 * are:
 *
 * $ white = max \left \{ \frac{red}{255},
 *                       \frac{green}{255},
 *                       \frac{blue}{255}} \right \} $
 *
 * $ cyan = \left (white - \frac{red}{255} \right ) / white $
 *
 * $ magenta = \left (white - \frac{red}{255} \right ) / white $
 *
 * $ yellow = \left (white - \frac{red}{255} \right ) / white $
 *
 * $ black = (1 - white) $
 *
 * Created by Fuuccker on 06/02/17.
 */
public class RGBtoCMYK {

    /**
     * Check if the input is valid.
     *
     * @param RBG integer values.
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

        // Check if numbers are out of range
        for (int i = 0; i < 3; i++)
            if (Integer.parseInt(input[i]) < 0 ||
                255 <Integer.parseInt(input[i]))
                return false;

        return true;
    }

    /**
     * Convert RGB valus to equivalent CMYK values.
     *
     * @param R red value.
     * @param G green value.
     * @param B blue value.
     * @return array of doubles with CMYK values.
     */
    public double[] convert(int R, int G, int B) {
        double[] CMYK = new double[4];
        double R_ = (double) R / 255;
        double G_ = (double) G / 255;
        double B_ = (double) B / 255;

        double W = Math.max(Math.max(R_, G_), B_);
        // If RGB = (0, 0, 0), to avoid indetermination,
        // return (0.0, 0.0, 0.0, 1.0)
        if (W == 0.0)
            CMYK = new double[]{0.0, 0.0, 0.0, 1.0};
        else {
            CMYK[0] = (W - R_) / W;
            CMYK[1] = (W - G_) / W;
            CMYK[2] = (W - B_) / W;
            CMYK[3] = (1 - W);
        }
        return CMYK;

    }

    /**
     * Main program.
     *
     * @param args input values from command line.
     */
    public static void main(String[] args) {
        RGBtoCMYK rgb = new RGBtoCMYK();

        if (rgb.validInput(args)) {
            int R = Integer.parseInt(args[0]);
            int G = Integer.parseInt(args[1]);
            int B = Integer.parseInt(args[2]);

            double[] result = rgb.convert(R, G, B);
            System.out.println("cyan    = " + result[0]);
            System.out.println("magenta = " + result[1]);
            System.out.println("yellow  = " + result[2]);
            System.out.println("black   = " + result[3]);
        } else
            System.out.println("Invalid input.");
    }
}
