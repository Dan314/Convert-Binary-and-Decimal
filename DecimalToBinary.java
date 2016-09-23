/**
 * DecimalToBinary.java checks for validity of input,
 * and if valid, converts the decimal representation of the number
 * to a decimal representation.
 */

public class DecimalToBinary {
    /**
     * Convert does the calculation for number conversion
     * @param Decimal base-10 number as a string
     * @return conversion of number to base-2
     */
    protected static String Convert(String Decimal) {
        try {Double.parseDouble(Decimal);}                                 // attempt to parse string
        catch (NumberFormatException e) {return "Invalid entry.";}         // error parsing number; invalid user input

        int decimal_point_index = Decimal.indexOf(".");                    // location of decimal point, if applicable
                         // whole number ends at decimal point, or end of number if there is no decimal point
        int cut_off = (decimal_point_index == -1) ? Decimal.length() : decimal_point_index;
        long whole_num_value = Long.parseLong(Decimal.substring(0, cut_off));       // get the whole number as string

        double fraction_value = -1;                                // initialize fractional value
        if(decimal_point_index != -1)                              // get fraction value if there exists a decimal point
            fraction_value = Double.parseDouble(Decimal.substring(decimal_point_index, Decimal.length()));

        String result = "";                                                // init string to return as result
                         // can convert the whole number directly to binary (can't with fraction)
        result += Long.toBinaryString(whole_num_value);
        result += ".";
        boolean continues = true;                                     // fraction continues past 10 binary digits

        if(fraction_value != -1) {                                    // if user entered fractional part of number:
            for(int i = 0; i < 10; i++) {                             // print maximum of 10 digits after '.' to console
                fraction_value *= 2;                                  // multiply current value by 2
                // exactly equal to 1, no remainder, so can end loop:
                if(fraction_value == 1.0) {result += "1";  continues = false;  break;}
                // concat 1 as remainder, take leftover as new fractional value:
                else if(fraction_value > 1.0) {result += "1";  fraction_value -= 1.0;}
                else {result += "0";}                                      // value is less than 1; append a 0
            }
            if(continues) result += "...";                                 // fraction continues past printed digits
        }

        else result += "0";                                                // no fractional value; just print as xyz.0
        return result;                                                     // return string value of base-2 number
    }
}
