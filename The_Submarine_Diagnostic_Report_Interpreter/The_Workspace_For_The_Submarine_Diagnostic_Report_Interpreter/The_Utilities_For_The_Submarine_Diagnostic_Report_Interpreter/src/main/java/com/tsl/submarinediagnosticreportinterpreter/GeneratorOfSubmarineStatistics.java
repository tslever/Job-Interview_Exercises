/*
 * GeneratorOfSubmarineStatistics
 * author Tom Lever
 * version 0.0
 * since 01/26/22
 */

package com.tsl.submarinediagnosticreportinterpreter;

import java.util.ArrayList;

public class GeneratorOfSubmarineStatistics {	
	private ArrayList<String> binaryNumbers;
	private int bitsInABinaryNumber;
	
	public GeneratorOfSubmarineStatistics(ArrayList<String> binaryNumbersToUse) {
		this.binaryNumbers = binaryNumbersToUse;
		this.bitsInABinaryNumber = binaryNumbersToUse.get(0).length();
	}
	
    public double convertsToDouble(int[] rate) {
        double theDouble = 0.0;
        for (int i = 0; i < rate.length; i++) {
            theDouble += ((double) rate[i]) * Math.pow(2.0, rate.length - i - 1);
            
        }
        return theDouble; 
    }
    
    public int[] parsesAsRating(String ratingAsString) {
    	int[] rating = new int[ratingAsString.length()];
    	for (int i = 0; i < ratingAsString.length(); i++) {
    		rating[i] = (ratingAsString.charAt(i) == '1') ? 1 : 0;
    	}
    	return rating;
    }
    
    public ArrayList<String> providesListContainingFirstBinaryNumberIn(ArrayList<String> binaryNumbers) {
    	String firstBinaryNumber = binaryNumbers.get(0);
    	binaryNumbers = new ArrayList<String>(1);
    	binaryNumbers.add(firstBinaryNumber);
    	return binaryNumbers;
    }
    
    public ArrayList<String> providesUpdatedListOfBinaryNumbersBasedOn(
    	ArrayList<String> binaryNumbers, ArrayList<String> winnowedBinaryNumbers) {
        if (winnowedBinaryNumbers.isEmpty()) {
        	binaryNumbers = this.providesListContainingFirstBinaryNumberIn(binaryNumbers);
        } else {
            binaryNumbers = winnowedBinaryNumbers;
        }
        return binaryNumbers;
    }
    
    public int[] providesFrequencyOf0sAndFrequencyOf1sGiven(ArrayList<String> binaryNumbers, int indexOfBit) {
    	int frequencyOf0s = 0;
    	int frequencyOf1s = 0;
    	for (String binaryNumber : binaryNumbers) {
    		if (binaryNumber.charAt(indexOfBit) == '0') {
    			frequencyOf0s++;
    		} else {
    			frequencyOf1s++;
    		}
    	}
    	return new int[] {frequencyOf0s, frequencyOf1s};
    }
    
    public double providesSubmarinesCarbonDioxideScrubberRating() {
    	ArrayList<String> binaryNumbers = this.binaryNumbers;
    	for (int i = 0; i < this.bitsInABinaryNumber; i++) {
    		int[] frequencyOf0sAndFrequencyOf1s = this.providesFrequencyOf0sAndFrequencyOf1sGiven(binaryNumbers, i);
    		char leastCommonBit = (frequencyOf0sAndFrequencyOf1s[1] < frequencyOf0sAndFrequencyOf1s[0]) ? '1' : '0';
            ArrayList<String> winnowedBinaryNumbers = new ArrayList<String>();
            for (String binaryNumber : binaryNumbers) {
                if (binaryNumber.charAt(i) == leastCommonBit) {
                    winnowedBinaryNumbers.add(binaryNumber);
                }
            }
            binaryNumbers = this.providesUpdatedListOfBinaryNumbersBasedOn(binaryNumbers, winnowedBinaryNumbers);
            if (binaryNumbers.size() < 2) {
                break;
            }
    	}
    	if (binaryNumbers.size() > 1) {
    		this.providesListContainingFirstBinaryNumberIn(binaryNumbers);
    	}
    	return this.convertsToDouble(this.parsesAsRating(binaryNumbers.get(0)));
    }
    
    public double providesSubmarinesEpsilonRate() {
        int[] epsilonRate = new int[this.bitsInABinaryNumber];
        for (int i = 0; i < this.bitsInABinaryNumber; i++) {
        	int[] frequencyOf0sAndFrequencyOf1s = this.providesFrequencyOf0sAndFrequencyOf1sGiven(this.binaryNumbers, i);
        	epsilonRate[i] = (frequencyOf0sAndFrequencyOf1s[1] < frequencyOf0sAndFrequencyOf1s[0]) ? 1 : 0;
        }
        return this.convertsToDouble(epsilonRate);
    }
	
    public double providesSubmarinesGammaRate() {
        int[] gammaRate = new int[this.bitsInABinaryNumber];
        for (int i = 0; i < this.bitsInABinaryNumber; i++) {
        	int[] frequencyOf0sAndFrequencyOf1s = this.providesFrequencyOf0sAndFrequencyOf1sGiven(this.binaryNumbers, i);
        	gammaRate[i] = (frequencyOf0sAndFrequencyOf1s[1] >= frequencyOf0sAndFrequencyOf1s[0]) ? 1 : 0;
        }
        return this.convertsToDouble(gammaRate);
    }
    
    public double providesSubmarinesLifeSupportRating() {
    	return this.providesSubmarinesCarbonDioxideScrubberRating() * this.providesSubmarinesOxygenGeneratorRating();
    }
    
    public double providesSubmarinesOxygenGeneratorRating() {
    	ArrayList<String> binaryNumbers = this.binaryNumbers;
    	for (int i = 0; i < this.bitsInABinaryNumber; i++) {
    		int[] frequencyOf0sAndFrequencyOf1s = this.providesFrequencyOf0sAndFrequencyOf1sGiven(binaryNumbers, i);
    		char mostCommonBit = (frequencyOf0sAndFrequencyOf1s[1] >= frequencyOf0sAndFrequencyOf1s[0]) ? '1' : '0';
            ArrayList<String> winnowedBinaryNumbers = new ArrayList<String>();
            for (String binaryNumber : binaryNumbers) {
                if (binaryNumber.charAt(i) == mostCommonBit) {
                    winnowedBinaryNumbers.add(binaryNumber);
                }
            }
            binaryNumbers = this.providesUpdatedListOfBinaryNumbersBasedOn(binaryNumbers, winnowedBinaryNumbers);
            if (binaryNumbers.size() < 2) {
                break;
            }
    	}
    	if (binaryNumbers.size() > 1) {
    		this.providesListContainingFirstBinaryNumberIn(binaryNumbers);
    	}
    	return this.convertsToDouble(this.parsesAsRating(binaryNumbers.get(0)));
    }
    
    public double providesSubmarinesPowerConsumption() {
    	return this.providesSubmarinesEpsilonRate() * this.providesSubmarinesGammaRate();
    }
}