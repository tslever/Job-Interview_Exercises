package Com.TSL.Utilities_For_The_Power_Consumption_Interpreter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


/**
 * An_Input_Manager represents the structure for an input manager, which may provide a buffered reader corresponding to a diagnostic report at a path.
 * 
 * @author Tom Lever
 * @version 0.0
 * @since 12/28/21
 */

public class An_Input_Manager {

    
    /**
     * provides_a_buffered_reader_corresponding_to_the_diagnostic_report_at provides a buffered reader corresponding to a diagnostic report a path.
     * 
     * Preconditions: The path to a diagnostic report must be relative to the directory of the project Utilities_For_The_Power_Consumption_Interpreter.
     * 
     * @param The_Path_To_The_Diagnostic_Report
     * @return
     * @throws FileNotFoundException
     */
    
    public BufferedReader provides_a_buffered_reader_corresponding_to_the_diagnostic_report_at(String The_Path_To_The_Diagnostic_Report) throws FileNotFoundException {
        
        FileReader The_File_Reader = new FileReader(The_Path_To_The_Diagnostic_Report);
        return new BufferedReader(The_File_Reader);
        
    }
    
}