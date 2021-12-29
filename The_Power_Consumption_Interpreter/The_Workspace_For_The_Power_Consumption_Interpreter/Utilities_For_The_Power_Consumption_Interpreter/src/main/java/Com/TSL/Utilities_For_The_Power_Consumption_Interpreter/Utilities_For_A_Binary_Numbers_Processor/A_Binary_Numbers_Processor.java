package Com.TSL.Utilities_For_The_Power_Consumption_Interpreter.Utilities_For_A_Binary_Numbers_Processor;


import Com.TSL.Utilities_For_The_Power_Consumption_Interpreter.A_Set_Of_Binary_Numbers_Statistics;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * A_Binary_Numbers_Processor represents the structure for a binary numbers processor, which may provide a set of binary numbers statistics based on a buffered reader.
 * 
 * @author Tom Lever
 * @version 0.0
 * @since 12/28/21
 */

public class A_Binary_Numbers_Processor {

    

    /**
     * forms_a_two_character_new_line_sequence indicates whether a previous character and a present character form a two-character new-line sequence (i.e., "\r\n").
     * 
     * @param The_Previous_Character
     * @param The_Present_Character
     * @return
     */
    
    private boolean forms_a_two_character_new_line_sequence(char The_Previous_Character, char The_Present_Character) {
        
        if ((The_Previous_Character == '\r') && (The_Present_Character == '\n')) {
            return true;
        }
        else {
            return false;
        }
        
    }
    
    
    /**
     * is_a_bit indicates whether or not a character is a bit (i.e., 0 or 1).
     * 
     * @param The_Previous_Character
     * @return
     */
    
    private boolean is_a_bit(char The_Previous_Character) {
        
        if ((The_Previous_Character == '0') || (The_Previous_Character == '1')) {
            return true;
        }
        else {
            return false;
        }
        
    }
    
    /**
     * is_a_new_line_character indicates whether or not a character is a new-line character (i.e., '\r' or '\n').
     * @param The_Present_Character
     * @return
     */
    
    private boolean is_a_new_line_character(char The_Present_Character) {
        
        if ((The_Present_Character == '\n') || (The_Present_Character == '\r')) {
            return true;
        }
        else {
            return false;
        }
        
    }
   
    
    /**
     * provides_a_set_of_binary_numbers_statistics_based_on provides a set of binary numbers statistics based on a buffered reader.
     * 
     * @param The_Buffered_Reader
     * @return
     * @throws an_inconsistent_number_of_bits_exception
     * @throws an_invalid_character_exception
     * @throws IOException
     */
    
    public A_Set_Of_Binary_Numbers_Statistics provides_a_set_of_binary_numbers_statistics_based_on(BufferedReader The_Buffered_Reader) throws an_inconsistent_number_of_bits_exception, an_invalid_character_exception, IOException {
        
        ArrayList<Integer> The_List_Of_Frequencies_Of_0 = new ArrayList<Integer>();
        ArrayList<Integer> The_List_Of_Frequencies_Of_1 = new ArrayList<Integer>();        
        int The_Number_Of_Bits_In_The_Present_Binary_Number = 0;
        int The_Number_Of_Binary_Numbers_Considered = 0;
        int The_Maximum_Number_Of_Bits_In_A_Binary_Number = 0;
        int The_Present_Position_In_A_Line = 0;
        int The_Present_Character_As_An_Integer = -1;
        char The_Present_Character = '\0';
        char The_Previous_Character = '\0';
        
        while ((The_Present_Character_As_An_Integer = The_Buffered_Reader.read()) != -1) {
            
            The_Present_Character = (char)The_Present_Character_As_An_Integer;
            
            if (forms_a_two_character_new_line_sequence(The_Previous_Character, The_Present_Character)) {
                
                // We have already considered any binary number in the line that this sequence terminates; we move on to the next line.
                
            }
            
            else if (is_a_new_line_character(The_Present_Character)) {
                
                The_Number_Of_Binary_Numbers_Considered++;
                
                if (The_Number_Of_Binary_Numbers_Considered == 1) {
                    
                    The_Maximum_Number_Of_Bits_In_A_Binary_Number = The_Number_Of_Bits_In_The_Present_Binary_Number;
                    
                }
                
                else if (The_Number_Of_Bits_In_The_Present_Binary_Number != The_Maximum_Number_Of_Bits_In_A_Binary_Number) {
                    
                    throw new an_inconsistent_number_of_bits_exception("The number of bits in Binary Number " + The_Number_Of_Binary_Numbers_Considered + ", " + The_Number_Of_Bits_In_The_Present_Binary_Number + ", and the maximum number of bits in a binary number, " + The_Maximum_Number_Of_Bits_In_A_Binary_Number + ", are inconsistent.");
                    
                }
                
                The_Number_Of_Bits_In_The_Present_Binary_Number = 0;
                
                The_Present_Position_In_A_Line = 0;
                
            }
            
            else if (The_Present_Character == '0') {
                
                if (The_List_Of_Frequencies_Of_0.size() == The_Present_Position_In_A_Line) {
                    
                    The_List_Of_Frequencies_Of_0.add(1);
                    The_List_Of_Frequencies_Of_1.add(0);
                    
                }
                
                else {
                    
                    Integer The_Frequency = The_List_Of_Frequencies_Of_0.get(The_Present_Position_In_A_Line);
                    The_List_Of_Frequencies_Of_0.set(The_Present_Position_In_A_Line, The_Frequency + 1);
                    
                }
                
                The_Present_Position_In_A_Line++;
                The_Number_Of_Bits_In_The_Present_Binary_Number++;
                
            }
            
            else if (The_Present_Character == '1') {
                
                if (The_List_Of_Frequencies_Of_1.size() == The_Present_Position_In_A_Line) {
                    
                    The_List_Of_Frequencies_Of_0.add(0);
                    The_List_Of_Frequencies_Of_1.add(1);
                    
                }
                
                else {
                    
                    Integer The_Frequency = The_List_Of_Frequencies_Of_1.get(The_Present_Position_In_A_Line);
                    The_List_Of_Frequencies_Of_1.set(The_Present_Position_In_A_Line, The_Frequency + 1);
                    
                }
                
                The_Present_Position_In_A_Line++;
                The_Number_Of_Bits_In_The_Present_Binary_Number++;
                
            }
            
            else {
                
                throw new an_invalid_character_exception("The Power Consumption Interpreter encountered an invalid character.");
                
            }
            
            The_Previous_Character = The_Present_Character;
            
        }
        
        if (is_a_bit(The_Previous_Character)) {
            
            The_Number_Of_Binary_Numbers_Considered++;
            
        }
        
        The_Buffered_Reader.close();
        
        return new A_Set_Of_Binary_Numbers_Statistics(The_List_Of_Frequencies_Of_0, The_List_Of_Frequencies_Of_1, The_Number_Of_Binary_Numbers_Considered);
        
    }
    
}