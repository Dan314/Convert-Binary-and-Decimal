import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BinaryToDecimalTest {

    @Test
    public static void testConvert() throws AssertionError {
        String test_str;

        test_str = BinaryToDecimal.Convert("a");
        org.testng.Assert.assertEquals(test_str, "Invalid entry.");

        test_str = BinaryToDecimal.Convert("10.1.1");
        org.testng.Assert.assertEquals(test_str, "Invalid entry.");

        test_str = BinaryToDecimal.Convert("1011010108010001");
        org.testng.Assert.assertEquals(test_str, "Invalid entry.");

        test_str = BinaryToDecimal.Convert("1");
        org.testng.Assert.assertEquals(test_str, "1.0");

        test_str = BinaryToDecimal.Convert("0.1");
        org.testng.Assert.assertEquals(test_str, "0.5");

        test_str = BinaryToDecimal.Convert("10100");
        org.testng.Assert.assertEquals(test_str, "20.0");

        test_str = BinaryToDecimal.Convert("00100.00100");
        org.testng.Assert.assertEquals(test_str, "4.125");

        test_str = BinaryToDecimal.Convert("101000101111101010110100.101001");
        org.testng.Assert.assertEquals(test_str, "10681012.640625");

        System.out.println("Binary to Decimal tests completed successfully.");
    }
}
