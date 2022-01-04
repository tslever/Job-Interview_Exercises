package Com.TSL.The_Utilities_For_The_Submarine_Diagnostic_Report_Interpreter;


import Com.TSL.The_Utilities_For_The_Submarine_Diagnostic_Report_Interpreter.The_Utilities_For_An_Extractor_Of_A_List_Of_Binary_Numbers.an_extractor_of_a_list_of_binary_numbers;
import Com.TSL.The_Utilities_For_The_Submarine_Diagnostic_Report_Interpreter.The_Utilities_For_An_Extractor_Of_A_List_Of_Binary_Numbers.an_inconsistent_number_of_bits_exception;
import Com.TSL.The_Utilities_For_The_Submarine_Diagnostic_Report_Interpreter.The_Utilities_For_An_Extractor_Of_A_List_Of_Binary_Numbers.an_invalid_character_exception;
import java.io.IOException;
import org.junit.jupiter.api.Test;


class a_test_for_an_extractor_of_a_list_of_binary_numbers {
		
	@Test
	void tests_extracts_using_the_diagnostic_report_with_an_inconsistent_number_of_bits() {
		
		System.out.println("Running a_test_for_an_extractor_of_a_list_of_binary_numbers.tests_extracts_using_the_diagnostic_report_with_an_inconsistent_number_of_bits");
		
		String The_Path_To_The_Diagnostic_File = "resources/The_Diagnostic_Report_With_An_Inconsistent_Number_Of_Bits.txt";
		
		try {
			(new an_extractor_of_a_list_of_binary_numbers()).extracts_a_list_of_binary_numbers_from_the_diagnostic_report_at(The_Path_To_The_Diagnostic_File);
			System.out.println("Extracting a list of binary numbers succeeded.\n");
		}
		catch (an_inconsistent_number_of_bits_exception The_Inconsistent_Number_Of_Bits_Exception) {
			System.out.println("The extractor found an inconsistent number of bits when trying to read a line.\n");
		}
		catch (an_invalid_character_exception The_Invalid_Character_Exception) {
			System.out.println("The extractor found an invalid character when trying to read a line.\n");
		}
		
		catch (IOException The_IO_Exception) {
			System.out.println("A BufferedReader threw an IOException when trying to read a line.\n");
		}
		
	}
	
	
	@Test
	void tests_extracts_using_the_diagnostic_report_with_an_invalid_character() {
		
		System.out.println("Running a_test_for_an_extractor_of_a_list_of_binary_numbers.tests_extracts_using_the_diagnostic_report_with_an_invalid_character");
		
		String The_Path_To_The_Diagnostic_File = "resources/The_Diagnostic_Report_With_An_Invalid_Character.txt";
		
		try {
			(new an_extractor_of_a_list_of_binary_numbers()).extracts_a_list_of_binary_numbers_from_the_diagnostic_report_at(The_Path_To_The_Diagnostic_File);
			System.out.println("Extracting a list of binary numbers succeeded.\n");
		}
		catch (an_inconsistent_number_of_bits_exception The_Inconsistent_Number_Of_Bits_Exception) {
			System.out.println("The extractor found an inconsistent number of bits when trying to read a line.\n");
		}
		catch (an_invalid_character_exception The_Invalid_Character_Exception) {
			System.out.println("The extractor found an invalid character when trying to read a line.\n");
		}
		
		catch (IOException The_IO_Exception) {
			System.out.println("A BufferedReader threw an IOException when trying to read a line.\n");
		}
		
	}
	
	
	@Test
	void tests_extracts_using_the_diagnostic_report_with_zero_errors() {
		
		System.out.println("Running a_test_for_an_extractor_of_a_list_of_binary_numbers.tests_extracts_using_the_diagnostic_report");
		
		String The_Path_To_The_Diagnostic_File = "resources/The_Diagnostic_Report.txt";
		
		try {
			(new an_extractor_of_a_list_of_binary_numbers()).extracts_a_list_of_binary_numbers_from_the_diagnostic_report_at(The_Path_To_The_Diagnostic_File);
			System.out.println("Extracting a list of binary numbers succeeded.\n");
		}
		catch (an_inconsistent_number_of_bits_exception The_Inconsistent_Number_Of_Bits_Exception) {
			System.out.println("The extractor found an inconsistent number of bits when trying to read a line.\n");
		}
		catch (an_invalid_character_exception The_Invalid_Character_Exception) {
			System.out.println("The extractor found an invalid character when trying to read a line.\n");
		}
		
		catch (IOException The_IO_Exception) {
			System.out.println("A BufferedReader threw an IOException when trying to read a line.\n");
		}
		
	}
	
}