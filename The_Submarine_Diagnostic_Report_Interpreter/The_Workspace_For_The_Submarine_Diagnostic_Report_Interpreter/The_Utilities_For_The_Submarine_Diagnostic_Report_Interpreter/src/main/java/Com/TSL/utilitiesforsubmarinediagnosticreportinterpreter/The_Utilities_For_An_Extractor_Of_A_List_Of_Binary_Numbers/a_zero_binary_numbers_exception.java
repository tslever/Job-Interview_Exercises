package com.tsl.utilitiesforsubmarinediagnosticreportinterpreter.The_Utilities_For_An_Extractor_Of_A_List_Of_Binary_Numbers;


/**
 * a_zero_binary_numbers_exception represents the structure for an zero binary numbers exception, which is thrown when an extractor of a list of binary numbers extracts zero binary numbers.
 * 
 * @author Tom Lever
 * @version 0.0
 * @since 01/04/21
 */

public class a_zero_binary_numbers_exception extends Exception {

    
    /**
     * a_zero_binary_numbers_exception(String The_Error_Message) is the one-argument constructor for a_zero_binary_numbers_exception, which passes an error message to the constructor of Exception.
     * 
     * @param The_Error_Message
     */
    
    public a_zero_binary_numbers_exception(String The_Error_Message) {
        
        super(The_Error_Message);
        
    }
    
}