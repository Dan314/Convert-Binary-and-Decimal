import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Run.java prompts the user for input,
 * calls the appropriate function in another file,
 * and outputs the result to standard output.
 * This process loops until the user requests to quit.
 */
public class Run {
    
    /**
     * main handles the input/output of the program
     * @param args not used
     */
    public static void main(String[] args) throws AssertionError {
//        BinaryToDecimalTest.testConvert();                    // Uncomment this line to run Binary to Decimal tests
//        DecimalToBinaryTest.testConvert();                    // "                        " Decimal to Binary tests
        Scanner input = new Scanner(System.in);                     // create Scanner to get input
        String input_str;                                           // holds user input string
        boolean binary;
        System.out.println("Note: type q + RETURN at any time to quit the program.\n");
        while(true) {
            input_str = "invalid";                                  // initialize input string with invalid data
            char c = input_str.charAt(0);
            while( (c != 'b') && (c != 'd') && (c != 'q') ) {       // user must choose binary, decimal or quit
                System.out.print("Will you be entering a (b)inary or (d)ecimal number? > ");    // user prompt
                try {input_str = input.nextLine().toLowerCase();}   // get next line of input, if there is one
                catch (NoSuchElementException e) {System.exit(0);}  // no input from user / file
                c = input_str.charAt(0);                            // 1st character of string
            }
            if(input_str.startsWith("q")) break;                    // user chooses option 'quit'

            binary = input_str.startsWith("b");                     // true if user chose 'binary to decimal'
            System.out.printf("Please enter a %s number to convert > ",
                    binary ? "binary" : "decimal");                 // ternary operator
            try {input_str = input.nextLine().trim();}              // get input
            catch (NoSuchElementException e) {break;}
            if( (input_str.equals("")) || (input_str.startsWith("q")) ) {break;}  // user quits program
                                                                // calls the convert function in the appropriate file:
            if(binary) {System.out.printf("Decimal Representation: " + BinaryToDecimal.Convert(input_str));}
            else {System.out.printf("Binary Representation: " + DecimalToBinary.Convert(input_str));}
            System.out.println("\n\n");
        }
        System.exit(0);                                             // exit program
    }
}
