
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for Checkerboard.java class.
 *
 * Created by Fuuccker on 07/02/17.
 */
public class CheckerboardTest {

    @Test
    public void test_validInput() {
        Checkerboard c = new Checkerboard();

        // Check invalid input
        assertFalse(c.validInput(new String[]{"-1"}));
        assertFalse(c.validInput(new String[]{"1.0"}));
        assertFalse(c.validInput(new String[]{"s"}));
        assertFalse(c.validInput(new String[]{"1", "2"}));

        // Check valid input
        assertTrue(c.validInput(new String[]{"0"}));
        assertTrue(c.validInput(new String[]{"100"}));
    }

    @Test
    public void test_draw() {
        Checkerboard c = new Checkerboard();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        String result = "* \n";
        c.draw(1);
        assertEquals(result, outContent.toString());

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        result = "* * \n * *\n";
        c.draw(2);
        assertEquals(result, outContent.toString());
        System.setOut(null);

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        result = "* * * \n * * *\n* * * \n";
        c.draw(3);
        assertEquals(result, outContent.toString());
        System.setOut(null);

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        result = "* * * * \n * * * *\n* * * * \n * * * *\n";
        c.draw(4);
        assertEquals(result, outContent.toString());
        System.setOut(null);

        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        result = "* * * * * \n * * * * *\n* * * * * \n * * * * *\n* * * * * \n";
        c.draw(5);
        assertEquals(result, outContent.toString());
        System.setOut(null);
    }
}