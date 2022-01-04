package Com.TSL.The_Utilities_For_The_Submarine_Diagnostic_Report_Interpreter;


import Com.TSL.The_Utilities_For_The_Submarine_Diagnostic_Report_Interpreter.The_Utilities_For_An_Extractor_Of_A_List_Of_Binary_Numbers.a_zero_binary_numbers_exception;
import Com.TSL.The_Utilities_For_The_Submarine_Diagnostic_Report_Interpreter.The_Utilities_For_An_Extractor_Of_A_List_Of_Binary_Numbers.an_extractor_of_a_list_of_binary_numbers;
import Com.TSL.The_Utilities_For_The_Submarine_Diagnostic_Report_Interpreter.The_Utilities_For_An_Extractor_Of_A_List_Of_Binary_Numbers.an_inconsistent_number_of_bits_exception;
import Com.TSL.The_Utilities_For_The_Submarine_Diagnostic_Report_Interpreter.The_Utilities_For_An_Extractor_Of_A_List_Of_Binary_Numbers.an_invalid_character_exception;
import java.io.IOException;
import java.util.ArrayList;


/**
 * The_Submarine_Diagnostic_Report_Interpreter encapsulates the entry point of this program, which presents submarine statistics based on a diagnostic report.
 * 
 * @author Tom Lever
 * @version 1.0
 * @since 12/29/21
 */

public class The_Submarine_Diagnostic_Report_Interpreter {

	
    /**
     * main represents the entry point of this program, which presents submarine statistics based on a diagnostic report.
     * 
     * Preconditions:
     * The path relative to the directory of the project The_Utilities_For_The_Submarine_Diagnostic_Report_Interpreter of a diagnostic report is provided as a command-line argument.
     * The diagnostic report consists of binary numbers. Each binary number lives on its own line, has the same length as any other binary number, and is represented by 0's and 1's.
     * 
     * @param args
     */
    
    public static void main(String[] args) throws a_zero_binary_numbers_exception, an_inconsistent_number_of_bits_exception, an_invalid_character_exception, IOException {

        String The_Path_To_The_Diagnostic_Report = args[0];
        
        ArrayList<String> The_List_Of_Binary_Numbers = (new an_extractor_of_a_list_of_binary_numbers()).extracts_a_list_of_binary_numbers_from_the_diagnostic_report_at(The_Path_To_The_Diagnostic_Report);
        
        a_generator_of_submarine_statistics The_Generator_Of_Submarine_Statistics = new a_generator_of_submarine_statistics(The_List_Of_Binary_Numbers);
        
        System.out.printf("The power consumption of the submarine corresponding to the diagnostic report at\n\"" + The_Path_To_The_Diagnostic_Report + "\"\nis %.0f.\n\n", The_Generator_Of_Submarine_Statistics.provides_the_submarines_power_consumption());
        
        System.out.printf("The life-support rating of the submarine corresponding to the diagnostic report at\n\"" + The_Path_To_The_Diagnostic_Report + "\"\nis %.0f.", The_Generator_Of_Submarine_Statistics.provides_the_submarines_life_support_rating());
        
    }
    
}