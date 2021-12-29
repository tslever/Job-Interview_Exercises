package Com.TSL.Utilities_For_The_Power_Consumption_Interpreter;


import java.lang.Math;
import java.util.ArrayList;


/**
 * A_Submarine_Statistics_Assembler represents the structure for a submarine statistics assembler, which may provide a gamma rate or an epsilon rate based on a set of binary numbers statistics.
 * 
 * @author Tom Lever
 * @version 0.0
 * @since 12/28/21
 */

public class A_Submarine_Statistics_Assembler {

    
    /**
     * provides_the_gamma_rate_based_on provides the gamma rate based on a set of binary numbers statistics.
     * 
     * @param The_Set_Of_Binary_Numbers_Statistics
     * @return
     */
    
    public double provides_the_gamma_rate_based_on(A_Set_Of_Binary_Numbers_Statistics The_Set_Of_Binary_Numbers_Statistics) {
        
        ArrayList<Integer> The_Gamma_Rate_As_A_List_Of_Bits = new ArrayList<Integer>();
        
        ArrayList<Integer> The_List_Of_Frequencies_Of_0 = The_Set_Of_Binary_Numbers_Statistics.provides_its_list_of_frequencies_of_0();
        ArrayList<Integer> The_List_Of_Frequencies_Of_1 = The_Set_Of_Binary_Numbers_Statistics.provides_its_list_of_frequencies_of_1();
        
        for (int i = 0; i < The_List_Of_Frequencies_Of_1.size(); i++) {
            
            if (The_List_Of_Frequencies_Of_1.get(i) >= The_List_Of_Frequencies_Of_0.get(i)) {
                
                The_Gamma_Rate_As_A_List_Of_Bits.add(1);
                
            }
            
            else {
                
                The_Gamma_Rate_As_A_List_Of_Bits.add(0);
                
            }
            
        }
        
        double The_Gamma_Rate_As_A_Decimal_Double = 0.0;
        
        for (int i = 0; i < The_Gamma_Rate_As_A_List_Of_Bits.size(); i++) {
            
            The_Gamma_Rate_As_A_Decimal_Double += (double)The_Gamma_Rate_As_A_List_Of_Bits.get(i) * Math.pow(2.0, The_Gamma_Rate_As_A_List_Of_Bits.size() - i - 1);
            
        }
        
        return The_Gamma_Rate_As_A_Decimal_Double;
        
    }
    
    
    /**
     * provides_the_epsilon_rate_based_on provides the epsilon rate based on a set of binary numbers statistics.
     * 
     * @param The_Set_Of_Binary_Numbers_Statistics
     * @return
     */
    
    public double provides_the_epsilon_rate_based_on(A_Set_Of_Binary_Numbers_Statistics The_Set_Of_Binary_Numbers_Statistics) {
        
        ArrayList<Integer> The_Epsilon_Rate_As_A_List_Of_Bits = new ArrayList<Integer>();
        
        ArrayList<Integer> The_List_Of_Frequencies_Of_0 = The_Set_Of_Binary_Numbers_Statistics.provides_its_list_of_frequencies_of_0();
        ArrayList<Integer> The_List_Of_Frequencies_Of_1 = The_Set_Of_Binary_Numbers_Statistics.provides_its_list_of_frequencies_of_1();
        
        for (int i = 0; i < The_List_Of_Frequencies_Of_1.size(); i++) {
            
            if (The_List_Of_Frequencies_Of_1.get(i) < The_List_Of_Frequencies_Of_0.get(i)) {
                
                The_Epsilon_Rate_As_A_List_Of_Bits.add(1);
                
            }
            
            else {
                
                The_Epsilon_Rate_As_A_List_Of_Bits.add(0);
                
            }
            
        }
        
        double The_Epsilon_Rate_As_A_Decimal_Double = 0.0;
        
        for (int i = 0; i < The_Epsilon_Rate_As_A_List_Of_Bits.size(); i++) {
            
            The_Epsilon_Rate_As_A_Decimal_Double += (double)The_Epsilon_Rate_As_A_List_Of_Bits.get(i) * Math.pow(2.0, The_Epsilon_Rate_As_A_List_Of_Bits.size() - i - 1);
            
        }
        
        return The_Epsilon_Rate_As_A_Decimal_Double;
        
    }
    
}