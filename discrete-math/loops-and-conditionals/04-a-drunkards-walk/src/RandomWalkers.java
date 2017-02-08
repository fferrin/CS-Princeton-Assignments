
/**
 * Created by Fuuccker on 08/02/17.
 */
public class RandomWalkers {
    double meanSquaredDistance;

    /**
     * Constructor.
     *
     * @param number of steps
     * @param number of test cases
     */
    public RandomWalkers(int N, int T) {
        meanSquaredDistance = 0;
        for (int t = 0; t < T; t++) {
            RandomWalker r = new RandomWalker(N);
            meanSquaredDistance += r.getSquaredDistance();
        }
        meanSquaredDistance /= T;
    }

    /**
     * Return the mean squared distance from the origin to the final position of
     * all the tests.
     *
     * @return the mean squared distance
     */
    public double getMeanSquaredDistance() { return meanSquaredDistance; }

    /**
     * Main program.
     *
     * @param args input values from command line
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            try {
                Integer.parseInt(args[0]);
                Integer.parseInt(args[1]);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input.");
                System.exit(-1);
            }

            int N = Integer.parseInt(args[0]);
            int T = Integer.parseInt(args[0]);
            if (0 <= N && 1 <= T) {
                RandomWalkers r = new RandomWalkers(N, T);
                System.out.println("mean squared distance = " + r.getMeanSquaredDistance());
            } else {
                System.out.println("Invalid input.");
                System.exit(-1);
            }
        } else {
            System.out.println("Invalid input.");
            System.exit(-1);
        }
    }
}
