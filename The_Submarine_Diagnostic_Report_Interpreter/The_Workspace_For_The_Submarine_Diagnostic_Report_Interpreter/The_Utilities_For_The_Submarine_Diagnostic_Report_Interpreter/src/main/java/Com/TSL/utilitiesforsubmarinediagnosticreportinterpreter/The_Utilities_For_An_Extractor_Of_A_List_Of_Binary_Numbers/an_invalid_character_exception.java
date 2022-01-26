package com.tsl.utilitiesforsubmarinediagnosticreportinterpreter.The_Utilities_For_An_Extractor_Of_A_List_Of_Binary_Numbers;


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