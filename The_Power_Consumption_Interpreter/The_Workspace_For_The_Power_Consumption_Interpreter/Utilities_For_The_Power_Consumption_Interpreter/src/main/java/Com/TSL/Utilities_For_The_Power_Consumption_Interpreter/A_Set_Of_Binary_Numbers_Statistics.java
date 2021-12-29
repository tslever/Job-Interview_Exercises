package Com.TSL.Utilities_For_The_Power_Consumption_Interpreter;


import java.util.ArrayList;


/**
 * A_Set_Of_Binary_Numbers_Statistics represents the structure for a set of binary numbers statistics, including a list of frequencies of 0 among binary numbers, a list of frequencies of 1 among binary numbers, and a number of binary numbers considered.
 * 
 * @author Tom Lever
 * @version 0.0
 * @since 12/28/21
 */

public class A_Set_Of_Binary_Numbers_Statistics {

    
    private ArrayList<Integer> List_Of_Frequencies_Of_0;
    private ArrayList<Integer> List_Of_Frequencies_Of_1;
    private int Number_Of_Binary_Numbers_Considered;
    
    
    /**
     * A_Set_Of_Binary_Numbers_Statistics(...) is the three-parameter constructor for A_Set_Of_Binary_Numbers_Statistics, which assigns actual parameters to corresponding instance variables.
     * 
     * @param The_Frequencies_Of_0_To_Use
     * @param The_Frequencies_Of_1_To_Use
     * @param The_Number_Of_Binary_Numbers_To_Use
     */
    
    public A_Set_Of_Binary_Numbers_Statistics(ArrayList<Integer> The_Frequencies_Of_0_To_Use, ArrayList<Integer> The_Frequencies_Of_1_To_Use, int The_Number_Of_Binary_Numbers_To_Use) {
        
        this.List_Of_Frequencies_Of_0 = The_Frequencies_Of_0_To_Use;
        this.List_Of_Frequencies_Of_1 = The_Frequencies_Of_1_To_Use;
        this.Number_Of_Binary_Numbers_Considered = The_Number_Of_Binary_Numbers_To_Use;
        
    }
    
    
    /**
     * provides_its_list_of_frequencies_of_0 provides the list of frequencies of 0 among binary numbers that is stored in this set of statistics.
     *     
     * @return
     */
    
    public ArrayList<Integer> provides_its_list_of_frequencies_of_0() {
        
        return this.List_Of_Frequencies_Of_0;
        
    }

    
    /**
     * provides_its_list_of_frequencies_of_1 provides the list of frequencies of 1 among binary numbers that is stored in this set of statistics.
     *     
     * @return
     */
    
    public ArrayList<Integer> provides_its_list_of_frequencies_of_1() {
        
        return this.List_Of_Frequencies_Of_1;
        
    }
    
    
    /**
     * provides_its_number_of_binary_numbers_considered provides the number of binary numbers considered that is stored in this set of statistics.
     *     
     * @return
     */    
    
    public int provides_its_number_of_binary_numbers_considered() {
        
        return this.Number_Of_Binary_Numbers_Considered;
        
    }
    
}