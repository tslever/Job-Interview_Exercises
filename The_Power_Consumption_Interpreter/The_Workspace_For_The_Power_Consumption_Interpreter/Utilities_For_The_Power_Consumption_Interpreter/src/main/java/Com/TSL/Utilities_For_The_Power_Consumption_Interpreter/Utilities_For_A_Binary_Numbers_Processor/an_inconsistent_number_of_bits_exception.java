package Com.TSL.Utilities_For_The_Power_Consumption_Interpreter.Utilities_For_A_Binary_Numbers_Processor;


/**
 * an_inconsistent_number_of_bits_exception represents the structure for an inconsistent line length exception, which is thrown when a binary number has a number of bits that is inconsistent with a maximum number of bits.
 * 
 * @author Tom Lever
 * @version 0.0
 * @since 12/28/21
 */

public class an_inconsistent_number_of_bits_exception extends Exception {

    
    /**
     * an_inconsistent_number_of_bits_exception(String The_Error_Message) is the one-argument constructor for an_inconsistent_number_of_bits_exception, which passes an error message to the constructor of Exception.
     * 
     * @param The_Error_Message
     */
    
    public an_inconsistent_number_of_bits_exception(String The_Error_Message) {
        
        super(The_Error_Message);
        
    }
    
}