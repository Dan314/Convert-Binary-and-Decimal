import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BinaryToDecimalTest {

    @Test
    public static void testConvert() throws AssertionError {
        String test_str;

        // Testing a letter
        test_str = BinaryToDecimal.Convert("a");
        org.testng.Assert.assertEquals(test_str, "Invalid entry.");

        // Testing 2 decimal points
        test_str = BinaryToDecimal.Convert("10.1.1");
        org.testng.Assert.assertEquals(test_str, "Invalid entry.");

        // Testing a digit not equal to 0 nor 1
        test_str = BinaryToDecimal.Convert("1011010108010001");
        org.testng.Assert.assertEquals(test_str, "Invalid entry.");

        // Testing a valid short input
        test_str = BinaryToDecimal.Convert("1");
        org.testng.Assert.assertEquals(test_str, "1.0");

        // Testing short input with a decimal point
        test_str = BinaryToDecimal.Convert("0.1");
        org.testng.Assert.assertEquals(test_str, "0.5");

        // Testing medium length input
        test_str = BinaryToDecimal.Convert("10100");
        org.testng.Assert.assertEquals(test_str, "20.0");

        // Testing medium length input with decimal point
        test_str = BinaryToDecimal.Convert("00100.00100");
        org.testng.Assert.assertEquals(test_str, "4.125");

        // Testing long input with decimal point
        test_str = BinaryToDecimal.Convert("101000101111101010110100.101001");
        org.testng.Assert.assertEquals(test_str, "10681012.640625");

        System.out.println("Binary to Decimal tests completed successfully.");
    }
}
