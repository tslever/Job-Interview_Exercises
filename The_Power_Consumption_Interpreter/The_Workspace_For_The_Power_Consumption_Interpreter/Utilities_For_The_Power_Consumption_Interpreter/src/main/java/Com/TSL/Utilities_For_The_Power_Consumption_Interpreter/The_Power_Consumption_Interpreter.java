package Com.TSL.Utilities_For_The_Power_Consumption_Interpreter;


import Com.TSL.Utilities_For_The_Power_Consumption_Interpreter.Utilities_For_A_Binary_Numbers_Processor.A_Binary_Numbers_Processor;
import Com.TSL.Utilities_For_The_Power_Consumption_Interpreter.Utilities_For_A_Binary_Numbers_Processor.an_inconsistent_number_of_bits_exception;
import Com.TSL.Utilities_For_The_Power_Consumption_Interpreter.Utilities_For_A_Binary_Numbers_Processor.an_invalid_character_exception;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * The_Power_Consumption_Interpreter encapsulates the entry point of this program, which presents a power consumption based on a diagnostic report.
 * 
 * @author Tom Lever
 * @version 0.0
 * @since 12/28/21
 */

public class The_Power_Consumption_Interpreter {

    /**
     * main represents the entry point of this program, which presents a power consumption based on a diagnostic report.
     * 
     * Preconditions:
     * The path relative to the directory of the project Utilities_For_The_Power_Consumption_Interpreter of a diagnostic report with ASCII characters is provided as a command-line argument.
     * The diagnostic report consists of binary numbers. Each binary number lives on its own line, has the same length as any other binary number, and is represented by 0's and 1's.
     * 
     * @param args
     */
    
    public static void main(String[] args) throws an_inconsistent_number_of_bits_exception, an_invalid_character_exception, FileNotFoundException, IOException {

        String The_Path_To_The_Diagnostic_Report = args[0];
        
        BufferedReader The_Buffered_Reader_For_The_Diagnostic_Report = (new An_Input_Manager()).provides_a_buffered_reader_corresponding_to_the_diagnostic_report_at(The_Path_To_The_Diagnostic_Report);
        
        A_Set_Of_Binary_Numbers_Statistics The_Set_Of_Binary_Numbers_Statistics = (new A_Binary_Numbers_Processor()).provides_a_set_of_binary_numbers_statistics_based_on(The_Buffered_Reader_For_The_Diagnostic_Report);
        
        A_Submarine_Statistics_Assembler The_Submarine_Statistics_Assembler = new A_Submarine_Statistics_Assembler();
        double The_Gamma_Rate = The_Submarine_Statistics_Assembler.provides_the_gamma_rate_based_on(The_Set_Of_Binary_Numbers_Statistics);
        double The_Epsilon_Rate = The_Submarine_Statistics_Assembler.provides_the_epsilon_rate_based_on(The_Set_Of_Binary_Numbers_Statistics);
        
        double The_Power_Consumption = The_Gamma_Rate * The_Epsilon_Rate;
        
        System.out.printf("The power consumption of the submarine corresponding to the diagnostic report at\n\"" + The_Path_To_The_Diagnostic_Report + "\"\nis %.0f.", The_Power_Consumption);
    }
    
}