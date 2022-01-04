package Com.TSL.The_Utilities_For_The_Submarine_Diagnostic_Report_Interpreter;


import java.util.ArrayList;
import java.util.Arrays;


/**
 * a_generator_of_submarine_statistics represents the structure for a generator of submarine statistics based on a list of binary numbers.
 * These statistics include gamma rate, epsilon rate, power consumption, oxygen generator rating, carbon dioxide scrubber rating, and life support rating.
 * 
 * @author Tom Lever
 * @version 0.0
 * @since 12/29/21
 */

public class a_generator_of_submarine_statistics {

	
	private ArrayList<String> List_Of_Binary_Numbers;
	private int Number_Of_Bits_In_A_Binary_Number;
	
	
	/**
	 * a_generator_of_submarine_statistics(...) is the one-parameter constructor for a_generator_of_submarine_statistics, which stores a list of binary numbers and the number of a bits in a binary number in instance variables. 
	 * 
	 * @param The_List_Of_Binary_Numbers_To_Use
	 */
	
	public a_generator_of_submarine_statistics(ArrayList<String> The_List_Of_Binary_Numbers_To_Use) {
		
		this.List_Of_Binary_Numbers = The_List_Of_Binary_Numbers_To_Use;
		this.Number_Of_Bits_In_A_Binary_Number = The_List_Of_Binary_Numbers_To_Use.get(0).length();
		
	}	
	
	
	/**
	 * converts_to_double converts a rate (an array of bits) into a double.
	 * 
	 * @param The_Rate
	 * @return
	 */
	
    public double converts_to_a_double(int[] The_Rate) {
        
        double The_Double = 0.0;
        
        for (int i = 0; i < The_Rate.length; i++) {
            
            The_Double += (double)The_Rate[i] * Math.pow(2.0, The_Rate.length - i - 1);
            
        }
        
        return The_Double;
        
    }
    
    
    /**
     * parses_as_a_rating parses a binary number, written as a string, into a rating, an array of bits.
     * 
     * @param The_Rating_As_A_String
     * @return
     */
    
    public int[] parses_as_a_rating(String The_Rating_As_A_String) {
    	
    	int[] The_Rating = new int[The_Rating_As_A_String.length()];
    	
    	for (int i = 0; i < The_Rating_As_A_String.length(); i++) {
    		
    		The_Rating[i] = (The_Rating_As_A_String.charAt(i) == '1') ? 1 : 0;
    		
    	}
    	
    	return The_Rating;
    	
    }
    
    
    /**
     * provides_a_list_containing_the_first_binary_number_in provides a list containing the first binary number in a list of binary numbers.
     * 
     * @param The_List_Of_Binary_Numbers
     * @return
     */
    
    public ArrayList<String> provides_a_list_containing_the_first_binary_number_in(ArrayList<String> The_List_Of_Binary_Numbers) {
    	
    	String The_First_Binary_Number = The_List_Of_Binary_Numbers.get(0);
    	
    	The_List_Of_Binary_Numbers = new ArrayList<String>(1);
    	
    	The_List_Of_Binary_Numbers.add(The_First_Binary_Number);
    	
    	return The_List_Of_Binary_Numbers;
    	
    }
    
    
    /**
     * provides an updated list of binary numbers based on a winnowed list of binary numbers.
     * 
     * @param The_Winnowed_List_Of_Binary_Numbers
     * @return
     */
    
    public ArrayList<String> provides_an_updated_list_of_binary_numbers_based_on(ArrayList<String> The_List_Of_Binary_Numbers, ArrayList<String> The_Winnowed_List_Of_Binary_Numbers) {
    	
        if (The_Winnowed_List_Of_Binary_Numbers.isEmpty()) {
        	
        	The_List_Of_Binary_Numbers = this.provides_a_list_containing_the_first_binary_number_in(The_List_Of_Binary_Numbers);
        			
        }
        
        else {
        
            The_List_Of_Binary_Numbers = The_Winnowed_List_Of_Binary_Numbers;
        	
        }
        
        return The_List_Of_Binary_Numbers;
    	
    }
    
    
    /**
     * provides_the_frequency_of_0s_and_the_frequency_of_1s_given provides the frequency and 0's and the frequency of 1's given a list of binary numbers and a bit index.
     * 
     * @param The_List_Of_Binary_Numbers
     * @param The_Index_Of_The_Bit
     * @return
     */
    
    public int[] provides_the_frequency_of_0s_and_the_frequency_of_1s_given(ArrayList<String> The_List_Of_Binary_Numbers, int The_Index_Of_The_Bit) {
    	
    	int The_Frequency_Of_0s = 0;
    	int The_Frequency_Of_1s = 0;
    	
    	for (String The_Binary_Number : The_List_Of_Binary_Numbers) {
    		
    		if (The_Binary_Number.charAt(The_Index_Of_The_Bit) == '0') {
    			
    			The_Frequency_Of_0s++;
    			
    		}
    		
    		else {
    			
    			The_Frequency_Of_1s++;
    			
    		}
    		
    	}
    	
    	return new int[] {The_Frequency_Of_0s, The_Frequency_Of_1s};
    	
    }
    
    
    /**
     * provides_the_submarines_carbon_dioxide_scrubber_rating provides the submarine's carbon dioxide scrubber rating.
     * 
     * @return
     */
    
    public double provides_the_submarines_carbon_dioxide_scrubber_rating() {
    	
    	ArrayList<String> The_List_Of_Binary_Numbers = this.List_Of_Binary_Numbers;
    	
    	//System.out.println("Carbon Dioxide Rating\n" + The_List_Of_Binary_Numbers);
    	
    	for (int i = 0; i < this.Number_Of_Bits_In_A_Binary_Number; i++) {
    		
    		int[] The_Frequency_Of_0s_And_The_Frequency_Of_1s = this.provides_the_frequency_of_0s_and_the_frequency_of_1s_given(The_List_Of_Binary_Numbers, i);
    		
    		char The_Least_Common_Bit = (The_Frequency_Of_0s_And_The_Frequency_Of_1s[1] < The_Frequency_Of_0s_And_The_Frequency_Of_1s[0]) ? '1' : '0';
    		
            ArrayList<String> The_Winnowed_List_Of_Binary_Numbers = new ArrayList<String>();
            
            for (String The_Binary_Number : The_List_Of_Binary_Numbers) {
                
                if (The_Binary_Number.charAt(i) == The_Least_Common_Bit) {
                	
                    The_Winnowed_List_Of_Binary_Numbers.add(The_Binary_Number);
                    
                }
                
            }
            
            The_List_Of_Binary_Numbers = this.provides_an_updated_list_of_binary_numbers_based_on(The_List_Of_Binary_Numbers, The_Winnowed_List_Of_Binary_Numbers);
            
            //System.out.println(The_List_Of_Binary_Numbers);
            
            if (The_List_Of_Binary_Numbers.size() < 2) {
                break;
            }
            
    	}
    	
    	return this.converts_to_a_double(this.parses_as_a_rating(The_List_Of_Binary_Numbers.get(0)));
    	
    }
    
    
    /**
     * provides_the_submarines_epsilon_rate provides the submarine's epsilon rate.
     * 
     * @return
     */
    
    public double provides_the_submarines_epsilon_rate() {
    	
        int[] The_Epsilon_Rate = new int[this.Number_Of_Bits_In_A_Binary_Number];
        
        for (int i = 0; i < this.Number_Of_Bits_In_A_Binary_Number; i++) {
            
        	int[] The_Frequency_Of_0s_And_The_Frequency_Of_1s = this.provides_the_frequency_of_0s_and_the_frequency_of_1s_given(this.List_Of_Binary_Numbers, i);
        	
        	The_Epsilon_Rate[i] = (The_Frequency_Of_0s_And_The_Frequency_Of_1s[1] < The_Frequency_Of_0s_And_The_Frequency_Of_1s[0]) ? 1 : 0;
            
        }
        
        //System.out.println("Epsilon Rate: " + Arrays.toString(The_Epsilon_Rate));
        
        return this.converts_to_a_double(The_Epsilon_Rate);
        
    }
    
    
    /**
     * provides_the_submarines_gamma_rate provides the submarine's gamma rate.
     * 
     * @return
     */
	
    public double provides_the_submarines_gamma_rate() {
    	
        int[] The_Gamma_Rate = new int[this.Number_Of_Bits_In_A_Binary_Number];
        
        for (int i = 0; i < this.Number_Of_Bits_In_A_Binary_Number; i++) {
            
        	int[] The_Pair_Of_Frequencies = this.provides_the_frequency_of_0s_and_the_frequency_of_1s_given(this.List_Of_Binary_Numbers, i);
        	
        	The_Gamma_Rate[i] = (The_Pair_Of_Frequencies[1] >= The_Pair_Of_Frequencies[0]) ? 1 : 0;
            
        }
        
        //System.out.println("Gamma Rate: " + Arrays.toString(The_Gamma_Rate));
        
        return this.converts_to_a_double(The_Gamma_Rate);
        
    }
    
    
    /**
     * provides_the_submarines_life_support_rating provides the submarine's life support rating.
     * 
     * @return
     */
    
    public double provides_the_submarines_life_support_rating() {
    	
    	return this.provides_the_submarines_carbon_dioxide_scrubber_rating() * this.provides_the_submarines_oxygen_generator_rating();
    	
    }
    
    
    /**
     * provides_the_submarines_oxygen_generator_rating provides the submarine's oxygen generator rating.
     * 
     * @return
     */
    
    public double provides_the_submarines_oxygen_generator_rating() {
    	
    	ArrayList<String> The_List_Of_Binary_Numbers = this.List_Of_Binary_Numbers;
    	
    	//System.out.println("Oxygen Generator Rating\n" + The_List_Of_Binary_Numbers);
    	
    	for (int i = 0; i < this.Number_Of_Bits_In_A_Binary_Number; i++) {
    		
    		int[] The_Frequency_Of_0s_And_The_Frequency_Of_1s = this.provides_the_frequency_of_0s_and_the_frequency_of_1s_given(The_List_Of_Binary_Numbers, i);
    		
    		char The_Most_Common_Bit = (The_Frequency_Of_0s_And_The_Frequency_Of_1s[1] >= The_Frequency_Of_0s_And_The_Frequency_Of_1s[0]) ? '1' : '0';
    		
            ArrayList<String> The_Winnowed_List_Of_Binary_Numbers = new ArrayList<String>();
            
            for (String The_Binary_Number : The_List_Of_Binary_Numbers) {
                
                if (The_Binary_Number.charAt(i) == The_Most_Common_Bit) {
                	
                    The_Winnowed_List_Of_Binary_Numbers.add(The_Binary_Number);
                    
                }
                
            }
            
            The_List_Of_Binary_Numbers = this.provides_an_updated_list_of_binary_numbers_based_on(The_List_Of_Binary_Numbers, The_Winnowed_List_Of_Binary_Numbers);
            
            //System.out.println(The_List_Of_Binary_Numbers);
            
            if (The_List_Of_Binary_Numbers.size() < 2) {
                break;
            }
            
    	}
    	
    	return this.converts_to_a_double(this.parses_as_a_rating(The_List_Of_Binary_Numbers.get(0)));
    	
    }
    
    
    /**
     * provides_the_submarines_power_consumption provides the submarine's power consumption.
     * 
     * @return
     */
    
    public double provides_the_submarines_power_consumption() {
    	
    	return this.provides_the_submarines_epsilon_rate() * this.provides_the_submarines_gamma_rate();
    	
    }
	
}