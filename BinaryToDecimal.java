import java.math.BigDecimal;

/**
 * BinaryToDecimal.java checks for validity of input,
 * and if valid, converts the binary representation of the number
 * to a decimal representation.
 */
public class BinaryToDecimal {

    /**
     * Convert does the calculation for number conversion
     * @param Binary base-2 number as a string
     * @return conversion of number to base-10
     */
    protected static String Convert(String Binary) {
        try {Double.parseDouble(Binary);}                                  // attempt to parse string
        catch (NumberFormatException e) {return "Invalid entry.";}         // error parsing number; invalid user input
        for(int idx = 0; idx < Binary.length(); idx++) {                   // iterate through each character
            char curr_char = Binary.charAt(idx);                           // get current character
            if(curr_char != '0' && curr_char != '1' && curr_char != '.')   // must be a 0, 1 or '.'
                return "Invalid entry.";
        }

        BigDecimal Result = new BigDecimal("0.0");                         // initialize resulting number
        // maximum exponent is number of digits before decimal point minus 1
        int exp = Binary.contains(".") ? Binary.indexOf(".") - 1 : Binary.length() - 1;
        Binary = Binary.replaceAll("[\\p{P}]", "");                        // regex: take out decimal point

        for(int idx = 0; idx < Binary.length(); idx++, exp--) {            // for each character and decreasing exponent
            int currDigit = Integer.parseInt(String.valueOf(Binary.charAt(idx)));      // parse integer value
            // add to result based on location in number (farther left => higher exponent)
            Result = Result.add(new BigDecimal(currDigit * Math.pow(2, exp)));
        }
        return Result.toPlainString();                                     // return string value of base-10 number
    }
}
