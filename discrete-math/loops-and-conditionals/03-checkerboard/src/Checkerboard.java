
import java.util.ArrayList;

/**
 * Compilation:  javac Checkerboard.java
 * Execution:    java Checkerboard N
 * Dependencies:
 *
 * print an N-by-N "checkerboard" pattern like the one below: a total of `N^2`
 * asterisks, where each row has `2N` characters (alternating between asterisks
 * and spaces).
 *
 * Created by Fuuccker on 07/02/17.
 */
public class Checkerboard {

    /**
     * Check if the input is valid.
     *
     * @param value N
     * @return true if the input is valid. False otherwise
     */
    public boolean validInput(String[] input) {
        if (input.length != 1) return false;

        try { Integer.parseInt(input[0]); }
        catch (NumberFormatException ex) { return false; }

        if (Integer.parseInt(input[0]) < 0) return false;

        return true;
    }

    /**
     * Make the board.
     *
     * @param size N of the board
     * @return string array with the board
     */
    private String[] makeBoard(int N) {
        ArrayList<String> s = new ArrayList<>();
        String first  = new String(new char[2*N]).replace("\0\0", "* ");
        String second = new String(new char[2*N]).replace("\0\0", " *");

        for (int i = 0; i < N; i++)
            if ((i % 2) == 0) s.add(first);
            else              s. add(second);

        return s.toArray(new String[s.size()]);
    }

    /**
     * Draw the board.
     *
     * @param size N of the board
     */
    public void draw(int N) {
        for (String s : makeBoard(N))
            System.out.println(s);
    }

    /**
     * Main program.
     *
     * @param args input values from command line
     */
    public static void main(String[] args) {
        Checkerboard c = new Checkerboard();

        if (c.validInput(args)) c.draw(Integer.parseInt(args[0]));
        else                    System.out.println("Invalid input.");
    }
}
