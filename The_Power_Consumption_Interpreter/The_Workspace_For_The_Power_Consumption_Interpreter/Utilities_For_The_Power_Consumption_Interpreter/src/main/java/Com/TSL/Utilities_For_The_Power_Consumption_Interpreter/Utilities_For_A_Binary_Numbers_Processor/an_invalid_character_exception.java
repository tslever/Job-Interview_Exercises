package Com.TSL.Utilities_For_The_Power_Consumption_Interpreter.Utilities_For_A_Binary_Numbers_Processor;


/**
 * an_invalid_character_exception represents the structure for an invalid-character exception, which is thrown when a Binary Numbers Processor encounters an invalid character in a buffered reader.
 * 
 * @author Tom Lever
 * @version 0.0
 * @since 12/28/21
 */

public class an_invalid_character_exception extends Exception {

    
    /**
     * an_invalid_character_exception(String The_Error_Message) is the one-argument constructor for an_invalid_character_exception, which passes an error message to the constructor of Exception.
     * 
     * @param The_Error_Message
     */
    
    public an_invalid_character_exception(String The_Error_Message) {
        
        super(The_Error_Message);
        
    }
    
}