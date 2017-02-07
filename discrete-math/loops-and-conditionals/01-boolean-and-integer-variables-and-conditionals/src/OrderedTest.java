
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for Ordered.java class.
 *
 * Created by Fuuccker on 06/02/17.
 */
public class OrderedTest {

    @Test
    public void test_isOrdered() {
        Ordered o = new Ordered();

        // Particular tests
        assertTrue(o.isOrdered(1, 2, 3));
        assertTrue(o.isOrdered(3, 2, 1));
        assertFalse(o.isOrdered(2, 3, 1));
        assertFalse(o.isOrdered(2, 1, 3));
        assertFalse(o.isOrdered(1, 1, 3));
        assertFalse(o.isOrdered(1, 2, 2));
        assertFalse(o.isOrdered(3, 2, 3));
    }

    @Test
    public void test_validInput() {
        Ordered o = new Ordered();

        // Checking different input lengths
        assertFalse(o.validInput(new String[]{}));
        assertFalse(o.validInput(new String[]{"1"}));
        assertFalse(o.validInput(new String[]{"a"}));
        assertFalse(o.validInput(new String[]{"1", "2", "3", "4"}));
        assertFalse(o.validInput(new String[]{"a", "2", "3", "4"}));

        // Checking when the input isn't three integers
        assertFalse(o.validInput(new String[]{"a", "2", "3"}));
        assertFalse(o.validInput(new String[]{"1", "a", "3"}));
        assertFalse(o.validInput(new String[]{"1", "2", "a"}));
        assertFalse(o.validInput(new String[]{"a", "b", "3"}));
        assertFalse(o.validInput(new String[]{"a", "2", "c"}));
        assertFalse(o.validInput(new String[]{"1", "b", "c"}));
        assertFalse(o.validInput(new String[]{"a", "b", "c"}));
        assertFalse(o.validInput(new String[]{"1.1", "2", "3"}));

        // Checking good input
        assertTrue(o.validInput(new String[]{"1", "2", "3"}));
    }

    @Test
    public void test_assignment() {
        Ordered o = new Ordered();

        // Assignment tests
        assertTrue(o.isOrdered(10, 17, 49));
        assertTrue(o.isOrdered(49, 17, 10));
        assertFalse(o.isOrdered(10, 49, 17));
    }
}