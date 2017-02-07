
import java.util.Arrays;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test for RGBtoCMYK.java class.
 *
 * Created by Fuuccker on 06/02/17.
 */
public class RGBtoCMYKTest {

    @Test
    public void test_validInput() {
        RGBtoCMYK rgb = new RGBtoCMYK();

        // Check different input lengths
        assertFalse(rgb.validInput(new String[]{}));
        assertFalse(rgb.validInput(new String[]{"1"}));
        assertFalse(rgb.validInput(new String[]{"1", "2", "3", "4"}));

        // Check when the input isn't three integers
        assertFalse(rgb.validInput(new String[]{"a", "2", "3"}));
        assertFalse(rgb.validInput(new String[]{"1", "a", "3"}));
        assertFalse(rgb.validInput(new String[]{"1", "2", "a"}));
        assertFalse(rgb.validInput(new String[]{"a", "b", "3"}));
        assertFalse(rgb.validInput(new String[]{"a", "2", "c"}));
        assertFalse(rgb.validInput(new String[]{"1", "b", "c"}));
        assertFalse(rgb.validInput(new String[]{"a", "b", "c"}));
        assertFalse(rgb.validInput(new String[]{"1.1", "2", "3"}));

        // Check when numbers are out of range
        assertFalse(rgb.validInput(new String[]{"-1", "2", "3"}));
        assertFalse(rgb.validInput(new String[]{"1", "256", "3"}));

        // Check good input
        assertTrue(rgb.validInput(new String[]{"0", "255", "100"}));
    }

    @Test
    public void test_convertRGB() {
        RGBtoCMYK rgb   = new RGBtoCMYK();
        double[] result;

        // RGB = (75, 0, 130)
        // =>
        // CMYK = (0.423076923076923, 1.0, 0.0, 0.4901960784313726)
        result = new double[]{0.423076923076923,
                              1.0,
                              0.0,
                              0.4901960784313726};
        assertTrue(Arrays.equals(result, rgb.convert(75, 0, 130)));

        // RGB = (0, 0, 0) => CMYK = (0.0, 0.0, 0.0, 1.0)
        result = new double[]{0.0, 0.0, 0.0, 1.0};
        assertTrue(Arrays.equals(result, rgb.convert(0, 0, 0)));

        // RGB = (255, 255, 255) => CMYK = (0.0, 0.0, 0.0, 0.0)
        result = new double[]{0.0, 0.0, 0.0, 0.0};
        assertTrue(Arrays.equals(result, rgb.convert(255, 255, 255)));

        // RGB = (255, 255, 255) => CMYK = (0.0, 0.0, 0.0, 0.0)
        result = new double[]{0.0, 0.0, 0.0, 0.0};
        assertTrue(Arrays.equals(result, rgb.convert(255, 255, 255)));

        // RGB = (0, 128, 255) => CMYK = (1.0, 0.4980392156862745, 0.0, 0.0)
        result = new double[]{1.0, 0.4980392156862745, 0.0, 0.0};
        System.out.println(rgb.convert(0, 128, 255)[1]);
        assertTrue(Arrays.equals(result, rgb.convert(0, 128, 255)));
    }
}