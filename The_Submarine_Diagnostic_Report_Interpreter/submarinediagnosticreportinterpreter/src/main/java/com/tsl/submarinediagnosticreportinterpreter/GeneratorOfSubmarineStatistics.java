/*
 * GeneratorOfSubmarineStatistics
 * author Tom Lever
 * version 0.0
 * since 01/26/22
 */

package com.tsl.submarinediagnosticreportinterpreter;

import java.util.ArrayList;

class GeneratorOfSubmarineStatistics {    
    private ArrayList<String> binaryNumbers;
    private int bitsInABinaryNumber;
    
    public GeneratorOfSubmarineStatistics(ArrayList<String> binaryNumbersToUse) {
        this.binaryNumbers = binaryNumbersToUse;
        this.bitsInABinaryNumber = binaryNumbersToUse.get(0).length();
    }
    
    private double convertsToDouble(int[] rate) {
        double theDouble = 0.0;
        for (int i = 0; i < rate.length; i++) {
            theDouble += ((double) rate[i]) * Math.pow(2.0, rate.length - i - 1);
            
        }
        return theDouble; 
    }
    
    private int[] parsesAsRating(String ratingAsString) {
        int[] rating = new int[ratingAsString.length()];
        for (int i = 0; i < ratingAsString.length(); i++) {
            rating[i] = (ratingAsString.charAt(i) == '1') ? 1 : 0;
        }
        return rating;
    }
    
    private ArrayList<String> providesListContainingFirstBinaryNumberIn(ArrayList<String> binaryNumbers) {
        String firstBinaryNumber = binaryNumbers.get(0);
        binaryNumbers = new ArrayList<String>(1);
        binaryNumbers.add(firstBinaryNumber);
        return binaryNumbers;
    }
    
    private ArrayList<String> providesUpdatedListOfBinaryNumbersBasedOn(
        ArrayList<String> binaryNumbers, ArrayList<String> winnowedBinaryNumbers) {
        if (winnowedBinaryNumbers.isEmpty()) {
            binaryNumbers = this.providesListContainingFirstBinaryNumberIn(binaryNumbers);
        } else {
            binaryNumbers = winnowedBinaryNumbers;
        }
        return binaryNumbers;
    }
    
    private int[] providesFrequencyOf0sAndFrequencyOf1sGiven(ArrayList<String> binaryNumbers, int indexOfBit) {
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
    
    private double providesGasRating(Gas gasToUse) {
        ArrayList<String> binaryNumbers = this.binaryNumbers;
        for (int i = 0; i < this.bitsInABinaryNumber; i++) {
            int[] frequencyOf0sAndFrequencyOf1s = this.providesFrequencyOf0sAndFrequencyOf1sGiven(binaryNumbers, i);
            char significantBit = '\0';
            switch (gasToUse) {
            	case CARBON_DIOXIDE:
            		significantBit = (frequencyOf0sAndFrequencyOf1s[1] < frequencyOf0sAndFrequencyOf1s[0]) ? '1' : '0';
            		break;
            	case OXYGEN:
            		significantBit = (frequencyOf0sAndFrequencyOf1s[1] >= frequencyOf0sAndFrequencyOf1s[0]) ? '1' : '0';
            		break;
            }
            ArrayList<String> winnowedBinaryNumbers = new ArrayList<String>();
            for (String binaryNumber : binaryNumbers) {
                if (binaryNumber.charAt(i) == significantBit) {
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
    
    private double providesSubmarinesCarbonDioxideScrubberRating() {
        return this.providesGasRating(Gas.CARBON_DIOXIDE);
    }
    
    private double providesSubmarinesEpsilonRate() {
        int[] epsilonRate = new int[this.bitsInABinaryNumber];
        for (int i = 0; i < this.bitsInABinaryNumber; i++) {
            int[] frequencyOf0sAndFrequencyOf1s = this.providesFrequencyOf0sAndFrequencyOf1sGiven(this.binaryNumbers, i);
            epsilonRate[i] = (frequencyOf0sAndFrequencyOf1s[1] < frequencyOf0sAndFrequencyOf1s[0]) ? 1 : 0;
        }
        return this.convertsToDouble(epsilonRate);
    }
    
    private double providesSubmarinesGammaRate() {
        int[] gammaRate = new int[this.bitsInABinaryNumber];
        for (int i = 0; i < this.bitsInABinaryNumber; i++) {
            int[] frequencyOf0sAndFrequencyOf1s = this.providesFrequencyOf0sAndFrequencyOf1sGiven(this.binaryNumbers, i);
            gammaRate[i] = (frequencyOf0sAndFrequencyOf1s[1] >= frequencyOf0sAndFrequencyOf1s[0]) ? 1 : 0;
        }
        return this.convertsToDouble(gammaRate);
    }
    
    double providesSubmarinesLifeSupportRating() {
        return this.providesSubmarinesCarbonDioxideScrubberRating() * this.providesSubmarinesOxygenGeneratorRating();
    }
    
    private double providesSubmarinesOxygenGeneratorRating() {
        return this.providesGasRating(Gas.OXYGEN);
    }
    
    double providesSubmarinesPowerConsumption() {
        return this.providesSubmarinesEpsilonRate() * this.providesSubmarinesGammaRate();
    }
}