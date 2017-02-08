
import java.util.ArrayList;
import java.util.Random;

/**
 * Compilation:  javac RandomWalker.java
 * Execution:    java RandomWalker N
 * Dependencies:
 *
 * Simulates the motion of a random walker for N steps.
 *
 * Note: This process is a discrete version of a natural phenomenon known as
 * Brownian motion. It serves as a scientific model for an astonishing range of
 * physical processes from the dispersion of ink flowing in water, to the
 * formation of polymer chains in chemistry, to cascades of neurons firing in
 * the brain.
 *
 * Created by Fuuccker on 08/02/17.
 */
public class RandomWalker {
    public static final int NORTH = 0;
    public static final int SOUTH = 1;
    public static final int EAST  = 2;
    public static final int WEST  = 3;

    private int N;
    private int squaredDistance;
    private int[][] position;

    /**
     * Constructor.
     *
     * @param number of steps
     */
    public RandomWalker(int N) {
        this.N = N;
        position      = new int[N][2];
        int[] current = new int[]{0, 0};

        Random r = new Random();
        for (int i = 0; i < N; i++) {
            int step = r.nextInt(4);
            switch (step) {
                case NORTH:
                    current[1]++;
                    break;
                case SOUTH:
                    current[1]--;
                    break;
                case EAST:
                    current[0]++;
                    break;
                case WEST:
                    current[0]--;
                    break;
            }
            System.arraycopy(current, 0, position[i], 0, 2);
        }
        squaredDistance = current[0]*current[0] + current[1]*current[1];
    }

    /**
     * Return the squared distance from the origin to the final position.
     *
     * @return the squared distance
     */
    public int getSquaredDistance() { return squaredDistance; }

    /**
     * Print the position at each step.
     */
    public void printWalk() {
        for (int i = 0; i < N; i++)
            System.out.println("(" + position[i][0] + ", " + position[i][1] + ")");

        System.out.println("square distance = " + squaredDistance);
    }

    /**
     * Main program.
     *
     * @param args input value from command line
     */
    public static void main(String[] args) {
        if (args.length == 1) {
            try { Integer.parseInt(args[0]); }
            catch (NumberFormatException ex) {
                System.out.println("Invalid input.");
                System.exit(-1);
            }

            int N = Integer.parseInt(args[0]);
            if (0 <= N) {
                RandomWalker r = new RandomWalker(N);
                r.printWalk();
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
