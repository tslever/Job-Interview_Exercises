package com.tsl.utilitiesforsubmarinediagnosticreportinterpreter.The_Utilities_For_An_Extractor_Of_A_List_Of_Binary_Numbers;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * an_extractor_of_a_list_of_binary_numbers represents an extractor of a list of binary numbers from a diagnostic report.
 * 
 * @author Tom Lever
 * @version 0.0
 * @since 12/29/21
 */

public class an_extractor_of_a_list_of_binary_numbers {

	
    int Number_Of_Bits_In_A_Binary_Number = -1;
	
    
    /**
     * checks_the_characters_of checks the characters of a binary number to see if they are all 0's or 1's.
     * 
     * @param The_Binary_Number
     * @throws an_invalid_character_exception
     */
	
	private void checks_the_characters_of(String The_Binary_Number) throws an_invalid_character_exception {
		
		for (int i = 0; i < The_Binary_Number.length(); i++) {
			
			char The_Character = The_Binary_Number.charAt(i);
			
			if ((The_Character != '0') && (The_Character != '1')) {
				
				throw new an_invalid_character_exception("A proposed binary number contains an invalid character.");
				
			}
			
		}
		
	}
	
	
	/**
	 * checks_the_number_of_bits_of checks to make sure a binary number does not differ in its number of bits from a first read binary number.
	 * 
	 * @param The_Binary_Number
	 * @throws an_inconsistent_number_of_bits_exception
	 */
	
	private void checks_the_number_of_bits_of(String The_Binary_Number) throws an_inconsistent_number_of_bits_exception {
		
		if (The_Binary_Number.length() != this.Number_Of_Bits_In_A_Binary_Number) {
			
			throw new an_inconsistent_number_of_bits_exception("A binary number differs in its number of bits from the first read binary number.");
			
		}
		
	}
	
	
	/**
	 * extracts_a_list_of_binary_numbers_from_the_diagnostic_report_at extracts a list of binary numbers from the diagnostic report at a provided path.
	 * 
	 * @param The_Path_To_The_Diagnostic_Report
	 * @return
	 * @throws an_inconsistent_number_of_bits_exception
	 * @throws an_invalid_character_exception
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	public ArrayList<String> extracts_a_list_of_binary_numbers_from_the_diagnostic_report_at(String The_Path_To_The_Diagnostic_Report) throws a_zero_binary_numbers_exception, an_inconsistent_number_of_bits_exception, an_invalid_character_exception, FileNotFoundException, IOException {
		
		ArrayList<String> The_List_Of_Binary_Numbers = new ArrayList<String>();
		
        FileReader The_File_Reader = new FileReader(The_Path_To_The_Diagnostic_Report);
        
        BufferedReader The_Buffered_Reader = new BufferedReader(The_File_Reader);
        
        String The_Binary_Number = "";
        
        if (The_Buffered_Reader.ready()) {
        	
        	The_Binary_Number = The_Buffered_Reader.readLine();
        	
        	The_List_Of_Binary_Numbers.add(The_Binary_Number);
        	
        	this.checks_the_characters_of(The_Binary_Number);
        	
        	this.Number_Of_Bits_In_A_Binary_Number = The_Binary_Number.length();
        	
        }
        
        while (The_Buffered_Reader.ready()) {
        	
        	The_Binary_Number = The_Buffered_Reader.readLine();
        	
        	this.checks_the_characters_of(The_Binary_Number);
        	
        	this.checks_the_number_of_bits_of(The_Binary_Number);
        	
        	The_List_Of_Binary_Numbers.add(The_Binary_Number);
        	
        }
        
        The_Buffered_Reader.close();
        
        if (The_List_Of_Binary_Numbers.isEmpty()) {
        	
        	throw new a_zero_binary_numbers_exception("An extractor of a list of binary numbers extracted zero binary numbers.");
        	
        }
		
        return The_List_Of_Binary_Numbers;
        
	}
	
	
}