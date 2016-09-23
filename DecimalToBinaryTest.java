import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DecimalToBinaryTest {

    @Test
    public static void testConvert() throws AssertionError {
        String test_str;

        // Testing a letter
        test_str = DecimalToBinary.Convert("z");
        org.testng.Assert.assertEquals(test_str, "Invalid entry.");

        // Testing 2 decimal points
        test_str = DecimalToBinary.Convert("52.64.1");
        org.testng.Assert.assertEquals(test_str, "Invalid entry.");

        // Testing a short input
        test_str = DecimalToBinary.Convert("8");
        org.testng.Assert.assertEquals(test_str, "1000.0");

        // Testing input with only 0's and 1's
        test_str = DecimalToBinary.Convert("10010101");
        org.testng.Assert.assertEquals(test_str, "100110001011110111110101.0");

        // Testing a short input with decimal point
        test_str = DecimalToBinary.Convert("72.15");
        org.testng.Assert.assertEquals(test_str, "1001000.0010011001...");

        // Testing a medium length input
        test_str = DecimalToBinary.Convert("478329843");
        org.testng.Assert.assertEquals(test_str, "11100100000101011101111110011.0");

        // Testing a long input with decimal point
        test_str = DecimalToBinary.Convert("7846325836485543.8235682438523408");
        org.testng.Assert.assertEquals(test_str, "11011111000000011000100011000010001101001001110100111.1101001011...");

        System.out.println("Decimal to Binary tests completed successfully.");
    }
}
